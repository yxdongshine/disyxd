package com.qtz.ht.user.dao;

import com.mall.core.dao.BizDao;
import com.mall.core.exception.DaoException;
import com.qtz.ht.user.vo.HtUser;

public interface HtUserDao extends BizDao<HtUser,Long> {


	/**
	* 【登录方法】
	* @param account
	* 				用户账号
	* @param password
	* 				密码
	* @param userType
	* 				用户类型
	* @return
	* @throws DaoException  
	*/
	HtUser getLoginVo(String account, String password, int userType) throws DaoException;
	
	

}
