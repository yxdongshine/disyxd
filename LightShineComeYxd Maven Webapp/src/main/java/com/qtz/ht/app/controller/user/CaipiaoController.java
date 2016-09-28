
package com.qtz.ht.app.controller.user;  

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.fastjson.JSONObject;
import com.mall.core.common.response.RespJsonPHandler;
import com.mall.core.exception.ServiceException;
import com.mall.core.log.LogTool;
import com.qtz.ht.user.service.CaipiaoService;
import com.qtz.ht.user.service.HtUserService;

/** 
 * ClassName:CaipiaoController <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月28日 下午2:47:08 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@RestController
@RequestMapping("/v1.0/caipiaoController/")
public class CaipiaoController {


	protected static final String htSession_cookie_path = "/";
	protected static LogTool log = LogTool.getInstance(LoginControll.class);
	
	@Resource(name="caiPiaServiceImpl")
	private CaipiaoService caipiaoService;
	
	@RequestMapping(value="caiPiao")
	public void getCaiPiaoData(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		try {
			
			List<Object> objectList =caipiaoService.getCaiPiaoStatistics();//统计彩票
			JSONObject result = new JSONObject();
			result.put("caipiaodata", objectList);
			RespJsonPHandler.respOK(result, resp,req);
		}catch (ServiceException e) {
			log.error("�������", e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), resp,req);
		}catch(RpcException e){
			log.error("�������", e);
			RespJsonPHandler.respError(-1, "�����쳣��������", resp,req);
		}
	}
}
  