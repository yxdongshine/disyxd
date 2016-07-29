package com.mall.core.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.mall.core.common.Global;
import com.mall.core.dao.AbstractDao;
import com.mall.core.dao.BizDao;
import com.mall.core.exception.DaoException;
import com.mall.core.vo.Pager;
import com.mall.core.vo.VO;

public abstract class MyBaitsDaoImpl<T extends VO<PK>,PK extends Serializable>  extends AbstractDao<T,PK>  implements BizDao<T,PK>{


	/** 
	* 【增加】VO对象
	* @param 	vo				VO对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public T addVo(T vo) throws DaoException {
		try {
			 return (T)getMyBaitsTemplate().add(getPreName(),Global.MYBTS_ADD_VO, vo);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}
	
	
	@Override
	public void delVo(T vo) throws DaoException {
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public Long findCount(T vo) throws DaoException {
	    List<T> findList = findList(vo);
	    if(findList!=null){
	      return Long.parseLong(findList.size()+"");
	    }
		return 0l;
	}

	@Override
	public int modReplace(T vo) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delFileds(String filedsName, PK id) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	public T findVoMax(T vo,String filed,int sort) throws DaoException{
		return null;
	}
	/** 
	* 【增加】VO集合对象
	* @param 	list			VO集合对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void addList(List <T> list) throws DaoException {
		try {
			getMyBaitsTemplate().add(getPreName(),Global.MYBTS_ADD_LIST, list);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	
	/** 
	* 【删除】ID值的对象
	* @param 	id			  	VO对应的ID值
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void delId(PK id) throws DaoException {
		try {
			//add by tanlinqing\\
			//若记录不存在，增加异常抛出，否则外层事务无法控制
			if(this.findVo(id, null) == null){
				throw new DaoException("记录不存在，无法删除");
			}
			//add by tanlinqing\\
			getMyBaitsTemplate().del(getPreName(),Global.MYBTS_DEL_ID, id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}
	
	
	/** 
	* 【删除】多个ID值的对象
	* @param 	ids			  	多个ID值
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void delIds(PK... ids) throws DaoException {
		try {
			//add by tanlinqing
			for (int i = 0; i < ids.length; i++) {
				//若记录不存在，增加异常抛出，否则外层事务无法控制
				if(this.findVo(ids[i], null) == null){
					throw new DaoException("记录不存在，无法删除");
				}
			}
			//add by tanlinqing\\
			getMyBaitsTemplate().del(getPreName(),Global.MYBTS_DEL_IDS, ids);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	
	/** 
	* 【删除】List中多个ID值的对象
	* @param 	list		  	List集合ID值
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void delList(Collection <PK> list) throws DaoException {
		try {
			getMyBaitsTemplate().del(getPreName(),Global.MYBTS_DEL_LIST, list);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	
	/** 
	* 【修改】VO对象
	* @param 	vo		  	  	vo对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void modVo(T vo) throws DaoException {
		try {
			getMyBaitsTemplate().mod(getPreName(),Global.MYBTS_MOD_VO, vo);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	
	/** 
	* 【修改】VO对象,字段为NULL的不修改
	* @param 	vo		  	  	vo对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public void modVoNotNull(T vo) throws DaoException {
		try {
			getMyBaitsTemplate().mod(getPreName(),Global.MYBTS_MOD_VO_NOT_NULL, vo);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}
	
	
	/** 
	* 【查询】ID值对应的VO
	* @param 	id			  	字段ID值
	* @return	VO			  	VO对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public T findVo(PK id,T clazz) throws DaoException {
		try {
			return (T) getMyBaitsTemplate().findVoBySqlid(getPreName(),Global.MYBTS_FIND_VO, id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	
	/** 
	* 【查询】List对象方法
	* @param 	param			参数对象			（必须）
	* @return	List<E>			E对象的List集合对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public List<T> findList(T param) throws DaoException {
		try {
			return getMyBaitsTemplate().findList(getPreName(),Global.MYBTS_FIND_List, param);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	
	
	/** 
	* 【分页查询】分页对象
	* @param 	page		  	分页对象
	* @return	Pager	  	  	分页对象
	* @throws 	DaoException  	DAO异常对象
	*/
	
	public Pager<T,PK> query(Pager<T,PK> page,Class<T> clazz) throws DaoException {
		try {
			return getMyBaitsTemplate().query(getPreName(),page);
		} catch (Exception e) {
			throw new DaoException(this.getClass().getName() + ".query(" + page + ")调用【报错】了！", e);
		}
	}
	@Override
	public List<T> findList(Class<T> clazz,PK... ids) throws DaoException{
		return null;
	}

}
