package com.mall.core.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.mall.core.common.FifteenLongId;
import com.mall.core.common.ReflectUtils;
import com.mall.core.common.SpringContextHolder;
import com.mall.core.common.UUIDFactory;
import com.mall.core.common.impl.FifteenLongIdImpl;
import com.mall.core.dao.BizDao;
import com.mall.core.exception.DaoException;
import com.mall.core.exception.ServiceException;
import com.mall.core.log.LogTool;
import com.mall.core.service.BaseService;
import com.mall.core.vo.Pager;
import com.mall.core.vo.VO;

public abstract class BaseServiceImpl<T extends VO<PK>,PK extends Serializable> implements BaseService<T,PK>{


	
	/** 
	* 【取得】日志对象
	* @return  	日志对象
	*/
	protected abstract LogTool getLog();
	
	/** 
	* 【取得】业务DAO对象
	* @return  	业务DAO对象
	*/
	protected abstract BizDao<T,PK> getDao();
	
	/** 
	* 【增加】VO对象
	* @param 	vo					VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public T addVo(T vo)  throws ServiceException {
		try {
			if (null == vo.getDmId() || "".equals(vo.getDmId())) {
				
				Class c = ReflectUtils.getClassGenricType(this.getClass(),1);
				if(null == c){
					throw new ServiceException("主键类型为空，主键="+c);
				}
				else if(c.toString().endsWith(String.class.toString()))
					vo.setDmId((PK) UUIDFactory.newUUID());
				else if(c.toString().endsWith(Long.class.toString())){
					vo.setDmId((PK)new Long(((FifteenLongId) SpringContextHolder.getApplicationContext().getBean(FifteenLongIdImpl.class)).nextId()));
				}
				else
					throw new ServiceException(-1,"未知的主键类型，类型="+c.toString());
			}
			return getDao().addVo(vo);
		} catch (DaoException e) {
			throw new ServiceException(-1,"添加失败",e);
		}
	}
	
	/** 
	* 【增加】多个VO对象的集合
	* @param 	list				多个VO对象的集合
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public void addList(List <T> list) throws ServiceException {
		try {
			if (null != list && list.size() > 0) {
				for (T vo: list) {
					if (null == vo.getDmId() || "".equals(vo.getDmId())) {
						
						Class c = ReflectUtils.getClassGenricType(this.getClass(),1);
						if(null == c){
							throw new ServiceException("主键类型为空，主键="+c);
						}
						else if(c.toString().endsWith(String.class.toString()))
							vo.setDmId((PK) UUIDFactory.newUUID());
						else if(c.toString().endsWith(Long.class.toString()))
							vo.setDmId((PK)new Long(((FifteenLongId) SpringContextHolder.getBean("fifteenLongIdImpl")).nextId()));
						else
							throw new ServiceException(-1,"未知的主键类型，类型="+c.toString());
						
					}
				}
				getDao().addList(list);
			}
		} catch (DaoException e) {
			throw new ServiceException(-1,"批量添加失败",e);
		}
	}
	
	/** 
	* 【删除】ID值的单条记录
	* @param 	id					ID值
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public void delId(PK id)throws ServiceException {
		try {
			//add by tanlinqing\\
			//若记录不存在，增加异常抛出，否则外层事务无法控制
			if(getDao().findVo(id, null) == null){
				throw new DaoException("记录不存在，无法删除");
			}
			//add by tanlinqing\\
			getDao().delId(id);
		} catch (DaoException e) {
			throw new ServiceException(-1,"删除失败",e);
		}
	}
	
	/** 
	* 【删除】多个ID值的多条记录
	* @param 	ids					多个ID值
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public void delIds(PK... ids) throws ServiceException {
		try {
			//add by tanlinqing
			for (int i = 0; i < ids.length; i++) {
				//若记录不存在，增加异常抛出，否则外层事务无法控制
				if(getDao().findVo(ids[i], null) == null){
					throw new DaoException("记录不存在，无法删除");
				}
			}
			//add by tanlinqing\\
			getDao().delIds(ids);
		} catch (DaoException e) {
			throw new ServiceException(-1,"批量删除失败",e);
		}
	}
	
	/** 
	* 【删除】集合中多个ID值的多条记录
	* @param 	list				多个ID值的集合
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public void delList(Collection <PK> list) throws ServiceException {
		try {
			getDao().delList(list);
		} catch (DaoException e) {
			throw new ServiceException(-1,"删除列表失败",e);
		}
	}
	
	/** 
	* 【修改】VO对象
	* @param 	vo					VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public void modVo(T vo) throws ServiceException {
		try {
			getDao().modVo(vo);
		} catch (DaoException e) {
			throw new ServiceException(-1,"修改失败",e);
		}
	}
	
	/** 
	* 【修改】VO对象,字段为NULL的不修改字段值
	* @param 	vo					VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public void modVoNotNull(T vo)  throws ServiceException {
		try {
			getDao().modVoNotNull(vo);
		} catch (DaoException e) {
			throw new ServiceException(-1,"修改非空字段失败",e);
		}
	}
	
	/** 
	* 【查询】ID值对应的VO对象
	* @param 	id					ID值
	* @return	VO			  		VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public T findVo(PK id ,T clazz) throws ServiceException {
		try {
			return getDao().findVo(id,clazz);
		} catch (DaoException e) {
			throw new ServiceException(-1,"查询失败",e);
		}
	}
	
	
	/** 
	* 【查询】List对象方法
	* @param 	obj					参数对象			（必须）
	* @return	List<E>				E对象的List集合对象
	* @throws 	ServiceException  	SERVER异常对象
	*/
	public List<T> findList(T obj) throws ServiceException {
		try {
			return getDao().findList(obj);
		} catch (DaoException e) {
			throw new ServiceException(-1,"查询列表失败",e);
		}
	}

	
	/** 
	* 【分页查询】分页对象
	* @param 	page		  		分页对象
	* @return	Pager	  	  		分页对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public Pager<T,PK> query(Pager<T,PK> page ,Class<T> clazz) throws ServiceException {
		try {
			return getDao().query(page,clazz);
		} catch (DaoException e) {
			throw new ServiceException(-1,"分页查询失败",e);
		}
	}
	
	
	/** 
	* 【保存】VO对象
	* @param 	vo					VO对象
	* @return	VO					VO对象
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public T save(T vo) throws ServiceException {
		T result = null;
		try {
			if (null == vo.getDmId() || "".equals(vo.getDmId())) {
				
				Class c = ReflectUtils.getClassGenricType(this.getClass(),1);
				if(null == c){
					throw new ServiceException("主键类型为空，主键="+c);
				}
				else if(c.toString().endsWith(String.class.toString()))
					vo.setDmId((PK) UUIDFactory.newUUID());
				else if(c.toString().endsWith(Long.class.toString()))
					vo.setDmId((PK)new Long(((FifteenLongId) SpringContextHolder.getBean("fifteenLongIdImpl")).nextId()));
				else
					throw new ServiceException(-1,"未知的主键类型，类型="+c.toString());
				
				result = getDao().addVo(vo);
				
			} else {
				getDao().modVo(vo);
				result = vo;
			}
		} catch (DaoException e) {
			throw new ServiceException(-1,"保存失败",e);
		}
		return result;
	}
	
	/** 
	* 【保存】列表集合
	* @param 	list				列表集合
	* @throws 	ServiceException  	SERVICE异常对象
	*/
	public void saveList(Collection <T> list)throws ServiceException {
		try {
			if (null != list && list.size() > 0) {
				T vo = null;
				Iterator <T> iter = list.iterator();
				while (iter.hasNext()) {
					vo = iter.next();
					if (null == vo.getDmId() || "".equals(vo.getDmId())) {

						Class c = ReflectUtils.getClassGenricType(this.getClass(),1);
						if(null == c){
							throw new ServiceException("主键类型为空，主键="+c);
						}
						else if(c.toString().endsWith(String.class.toString()))
							vo.setDmId((PK) UUIDFactory.newUUID());
						else if(c.toString().endsWith(Long.class.toString()))
							vo.setDmId((PK)new Long(((FifteenLongId) SpringContextHolder.getBean("fifteenLongIdImpl")).nextId()));
						else
							throw new ServiceException(-1,"未知的主键类型，类型="+c.toString());

						getDao().addVo(vo);
					} else {
						getDao().modVoNotNull(vo);
					}
				}
			}
		} catch (DaoException e) {
			throw new ServiceException(-1,"保存列表失败",e);
		}
	}
	
	public T  modReplace(T vo) throws ServiceException{
		try{
			if(vo==null || vo.getDmId()==null){
				throw new ServiceException(-1,"入参错误");
			}
			getDao().modReplace(vo);
		}catch(DaoException e){
			throw new ServiceException(-1,"替换失败",e);
		}
		
		return vo;
	}

}
