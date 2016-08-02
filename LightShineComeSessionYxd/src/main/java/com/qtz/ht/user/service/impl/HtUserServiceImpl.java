package com.qtz.ht.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.alibaba.dubbo.rpc.RpcException;
import com.mall.core.common.FifteenLongId;
import com.mall.core.dao.BizDao;
import com.mall.core.exception.DaoException;
import com.mall.core.exception.ServiceException;
import com.mall.core.log.LogTool;
import com.mall.core.service.impl.BaseServiceImpl;
import com.qtz.ht.user.dao.HtUserDao;
import com.qtz.ht.user.service.HtUserService;
import com.qtz.ht.user.vo.HtUser;

@Service("htUserServiceImpl")
public class HtUserServiceImpl extends BaseServiceImpl<HtUser,Long> implements HtUserService  {

	/**初始化日志对象*/
	private static LogTool log = LogTool.getInstance(HtUserServiceImpl.class);
	/**注入商户用户DAO接口类*/
	@Resource(name="htUserDaoImpl")
    private HtUserDao dao;
    @Autowired
    private FifteenLongId FifteenLongIdImpl;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<HtUser,Long> getDao() {
		return dao;
	}
	/** 
	* 【取得】日志对象
	* @return 	日志对象  
	*/
	@Override
	protected LogTool getLog() {
		return log;
	}
	@Override
	public boolean login(String account,String password) throws ServiceException,RpcException {
		log.debug(account + " 登录了 密码 = password；"+ password);
		if(null == account || null == password){
			throw new ServiceException(7, "入参错误");
		}
		
		HtUser user = this.getLoginVo(account,password,2);
		if (null == user) {
			throw new ServiceException(-1, "用户名或密码错误");
		}
	    
 		log.info("用户：【"+account+"】登陆系统成功!");
		user.setPassword(null);
		//更新用户最后登录时间
		HtUser update = new HtUser();
		update.setDmId(user.getDmId());
		update.setLastLogin(System.currentTimeMillis());
		super.modVoNotNull(update);
		return true;
	}
	@Override
	public boolean logout(Long userId, String sid) throws ServiceException {
		if(null == sid){
			throw new ServiceException(7, "入参错误","入参错误，sessionKey="+sid);
		}
		
		return true;
	}
	@Override
	public HtUser getLoginVo(String account, String password, int userType) throws ServiceException {
		try {
			return dao.getLoginVo(account, password, userType);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	@Override
	public HtUser findVo(Long userId) throws ServiceException {
		try {
			return dao.findVo(userId, new HtUser());
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	@Override
	public HtUser addUserVo(String account, String password)
			throws ServiceException, DaoException {
		// TODO Auto- generated method stub
        HtUser vo =new HtUser();
        vo.setDmId(FifteenLongIdImpl.nextId());
        vo.setAccount(account);
        vo.setPassword(password);
        vo.setUserType(2);
        vo.setCrtime(System.currentTimeMillis());
		HtUser userInDao=dao.addVo(vo);
		return    userInDao;
	}

}
