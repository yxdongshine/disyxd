
package com.qtz.ht.user.dao.impl;  

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mall.core.dao.impl.MyBaitsDaoImpl;
import com.mall.core.exception.DaoException;
import com.qtz.ht.user.dao.CaiPiaoDao;
import com.qtz.ht.user.vo.CpiaoYxd;

/** 
 * ClassName:CaiPiaoDaoImpl <br/> 
 * Function: TODO (实现彩票接口类). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月12日 下午8:55:00 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@Repository("caiPiaoDaoImpl")
public class CaiPiaoDaoImpl extends MyBaitsDaoImpl<CpiaoYxd,Long> implements CaiPiaoDao {

	private static String preName = CaiPiaoDao.class.getName();
	/**
	 * 批量添加曾经的彩票数据
	 */
	@Override
	public void batchInsertList(List<CpiaoYxd> cpList) throws DaoException {
		// TODO Auto-generated method stub
		addList(cpList);
	}

	@Override
	protected String getPreName() {
		// TODO Auto-generated method stub
		return preName;
	}

}
  