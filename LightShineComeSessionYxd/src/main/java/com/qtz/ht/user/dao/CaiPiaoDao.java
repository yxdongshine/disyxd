
package com.qtz.ht.user.dao;  

import java.util.List;

import com.mall.core.dao.BizDao;
import com.mall.core.exception.DaoException;
import com.qtz.ht.user.vo.CpiaoYxd;

/** 
 * ClassName:CaiPiaoDao <br/> 
 * Function: TODO (彩票的dao接口). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月12日 下午8:41:57 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public interface CaiPiaoDao extends BizDao<CpiaoYxd,Long> {

	/**
	 * 批次添加彩票接口
	 * batchInsertList:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param cpList
	 * @throws DaoException
	 */
	public void batchInsertList(List<CpiaoYxd> cpList)throws DaoException;
}
  