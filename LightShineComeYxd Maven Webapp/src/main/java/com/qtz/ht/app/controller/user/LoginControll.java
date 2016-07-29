package com.qtz.ht.app.controller.user;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.rpc.RpcException;
import com.mall.core.common.response.RespJsonPHandler;
import com.mall.core.exception.ServiceException;
import com.mall.core.log.LogTool;
import com.qtz.ht.user.service.HtUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/v1.0/")
public class LoginControll {

	protected static final String htSession_cookie_path = "/";
	protected static LogTool log = LogTool.getInstance(LoginControll.class);
	@Resource(name="htUserServiceImpl")
	private HtUserService htUserService = null;
	
	/** 
	* 【登录】ajax
	* @param req
	* @param res
	 * @throws IOException 
	* @throws ActionException  
	*/
	@RequestMapping(value="login")
	public void login(@RequestParam String account,@RequestParam String pwd,HttpServletResponse resp,HttpServletRequest req) throws IOException {
		try {
			boolean isLogin = htUserService.login(account, pwd);//登录后生成新session
			JSONObject result = new JSONObject();
			result.put("isLogin", isLogin);
			RespJsonPHandler.respOK(result, resp,req);
		}catch (ServiceException e) {
			log.error("网络错误", e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), resp,req);
		}catch(RpcException e){
			log.error("网络错误", e);
			RespJsonPHandler.respError(-1, "连接异常，请重试", resp,req);
		}
	}
	
	
}
