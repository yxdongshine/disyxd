package com.mall.core.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.mall.core.exception.ServiceException;
import com.mall.core.vo.Pager;
import com.mall.core.vo.VO;

public interface BaseService<T extends VO<PK>,PK extends Serializable> {

	
	/** 
	* 【增加】VO对象
	* @param 	vo					VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public T addVo(T vo)  throws ServiceException;
	
	
	/** 
	* 【增加】多个VO对象的集合
	* @param 	list				多个VO对象的集合
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public void addList(List <T> list) throws ServiceException;
	
	
	/** 
	* 【删除】ID值的单条记录
	* @param 	id					ID值
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public void delId(PK id)throws ServiceException;

	
	/** 
	* 【删除】多个ID值的多条记录
	* @param 	ids					多个ID值
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public void delIds(PK... ids) throws ServiceException;
	
	
	/** 
	* 【删除】集合中多个ID值的多条记录
	* @param 	list				多个ID值的集合
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public void delList(Collection <PK> list) throws ServiceException;
	
	
	/** 
	* 【修改】VO对象
	* @param 	vo					VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public void modVo(T vo) throws ServiceException;
	
	
	/** 
	* 【修改】VO对象,字段为NULL的不修改字段值
	* @param 	vo					VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public void modVoNotNull(T vo)  throws ServiceException;
	
	
	/** 
	* 【查询】ID值对应的VO对象
	* @param 	id					ID值
	* @return	VO			  		VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public T findVo(PK id,T clazz) throws ServiceException;
	
	
	/** 
	* 【查询】List对象方法
	* @param 	obj					参数对象			（必须）
	* @return	List<E>				E对象的List集合对象
	* @throws 	ServiceException  	SERVER异常对象
	*/
	
	public List<T> findList(T obj) throws ServiceException;
	
	
	/** 
	* 【分页查询】分页对象
	* @param 	page		  		分页对象
	* @return	Pager	  	  		分页对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public Pager<T,PK> query(Pager<T,PK> page, Class<T> clazz) throws ServiceException;
	
	
	
	/** 
	* 【保存】VO对象
	* @param 	vo					VO对象
	* @return	vo					VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public T save(T vo) throws ServiceException;
	
	
	/** 
	* 【保存】列表集合
	* @param 	list				列表集合
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	
	public void saveList(Collection <T> list)throws ServiceException;
	

}
