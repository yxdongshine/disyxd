
package com.qtz.ht.user.service.impl;  

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.core.common.FifteenLongId;
import com.mall.core.dao.BizDao;
import com.mall.core.exception.DaoException;
import com.mall.core.exception.ServiceException;
import com.mall.core.log.LogTool;
import com.mall.core.service.impl.BaseServiceImpl;
import com.qtz.ht.user.dao.CaiPiaoDao;
import com.qtz.ht.user.service.CaipiaoService;
import com.qtz.ht.user.vo.CpiaoYxd;

/** 
 * ClassName:CaiPiaServiceImpl <br/> 
 * Function: TODO (实现彩票service服务接口). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月12日 下午9:03:51 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@Service("caiPiaServiceImpl")
public class CaiPiaServiceImpl extends BaseServiceImpl<CpiaoYxd,Long> implements CaipiaoService  {

	/**初始化日志对象*/
	private static LogTool log = LogTool.getInstance(CaiPiaServiceImpl.class);
	
	/**
	 * 注入dao层
	 */
	@Resource(name="caiPiaoDaoImpl")
    private CaiPiaoDao dao;
	/**
	 * 自增长主键编号
	 */
    @Autowired
    private FifteenLongId FifteenLongIdImpl;
    
	
	@Override
	protected LogTool getLog() {
		// TODO Auto-generated method stub
		return log;
	}

	@Override
	protected BizDao<CpiaoYxd, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	/**
	 * service层添加
	 */
	@Override
	public void batchInsertCpiaoService(List<CpiaoYxd> cpList)
			throws ServiceException {
		// TODO Auto-generated method stub
		try {
			dao.batchInsertList(cpList);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int dataCount() throws ServiceException {
		// TODO Auto-generated method stub
		int count = 0;
		CpiaoYxd cp= new CpiaoYxd();
		List<CpiaoYxd> cpList = null;
		try {
			cpList = dao.findList(cp);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		if(cpList!=null){
			count= cpList.size();
		}
		return count;
	}

}
  