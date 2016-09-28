
package com.qtz.ht.user.service;  

import java.util.List;

import com.mall.core.exception.ServiceException;
import com.mall.core.service.BaseService;
import com.qtz.ht.user.vo.CpiaoYxd;

/** 
 * ClassName:CaipiaoService <br/> 
 * Function: TODO (彩票服务接口). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月12日 下午9:04:22 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public interface CaipiaoService extends BaseService<CpiaoYxd,Long> {
    
	public void batchInsertCpiaoService(List<CpiaoYxd> cpList)throws ServiceException;
	
	public int dataCount()throws ServiceException;
	
	public List<Object> getCaiPiaoStatistics()throws ServiceException;
}
  