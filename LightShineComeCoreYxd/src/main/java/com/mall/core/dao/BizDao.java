package com.mall.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.mall.core.exception.DaoException;
import com.mall.core.vo.Pager;
import com.mall.core.vo.VO;

public interface BizDao<T extends VO<PK>,PK extends Serializable>{


	
	/** 
	* 【增加】VO对象
	* @param 	vo				VO对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public T addVo(T vo) throws DaoException;
	
	
	/** 
	* 【增加】VO集合对象
	* @param 	list			VO集合对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void addList(List <T> list) throws DaoException;
	
	
	/** 
	* 【删除】ID值的对象
	* @param 	id			  	VO对应的ID值
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void delId(PK id) throws DaoException;
	
	
	/** 
	* 【删除】多个ID值的对象
	* @param 	ids			  	多个ID值
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void delIds(PK ... ids) throws DaoException;
	
	
	/** 
	* 【删除】List中多个ID值的对象
	* @param 	list		  	List集合ID值
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void delList(Collection <PK> list) throws DaoException; 
	/**
	 * 
	* 【删除对象】(这里用一句话描述这个方法的作用)
	* @param vo
	* @throws DaoException
	 */
	public void delVo(T vo) throws DaoException; 
	/** 
	* 【修改】VO对象
	* @param 	vo		  	  	vo对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void modVo(T vo) throws DaoException;
	
	
	/** 
	* 【修改】VO对象,字段为NULL的不修改
	* @param 	vo		  	  	vo对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void modVoNotNull(T vo) throws DaoException;
	
	
	/** 
	* 【查询】ID值对应的VO
	* @param 	id				 字段ID值
	* @return	VO			  	VO对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public T findVo(PK id ,T clazz) throws DaoException;
	
	
	/**
	 * 
	* 【查询最大、最小 记录】(这里用一句话描述这个方法的作用)
	* @param vo
	* @fild  排序的字段
	* @param sort -1 max  1 min
	* @return
	* @throws DaoException
	 */
	public T findVoMax(T vo,String filed,int sort) throws DaoException;

	
	/** 
	* 【查询】List对象方法
	* @param 	obj				参数对象			（必须）
	* @return	List<E>			E对象的List集合对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public List<T> findList(T vo) throws DaoException;
	/**
	 * 
	  * 【查询】 多个id 集合查询
	  * @param ids
	  * @return
	  * @throws DaoException  
	  * @time:2015年5月8日 下午7:18:37
	  * @author 涂鑫
	  * @version
	 */
	public List<T> findList(Class<T> clazz,PK... ids) throws DaoException;

	
	
	/** 
	* 【分页查询】分页对象
	* @param 	page		  	分页对象
	* @return	Pager	  	  	分页对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public Pager<T,PK> query(Pager<T,PK> page, Class<T> clazz) throws DaoException;

	/**
	 * 
	* 【统计查询】(这里用一句话描述这个方法的作用)
	* @param vo
	* @return
	* @throws DaoException
	 */
	public Long findCount(T vo)throws DaoException;
	
	/**
	 * 
	  * 【修改 替换 文档】
	  * @param vo
	  * @throws DaoException  
	  * @time:2015年8月5日 下午4:55:42
	  * @author 涂鑫
	  * @version
	 */
	public int modReplace(T vo) throws DaoException;


}
