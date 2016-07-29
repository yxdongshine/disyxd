package com.mall.core.dao;

import java.io.Serializable;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mall.core.common.SpringContextHolder;
import com.mall.core.vo.VO;

public abstract class AbstractDao<T extends VO<PK>,PK extends Serializable> {

	
	/** 
	* 【取得�?MYBatis命名空间�?
	* @return  	MYBatis命名空间�?
	*/
	protected abstract String getPreName();
	private  MyBaitsTemplate<T,PK> myBaitsTemplate;
	
	

	//目前还没有找到同层调用不同数据库的方法目前采用springJDBC提供
	private static JdbcTemplate jdbcTemplate;
	
	public static JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = SpringContextHolder.getApplicationContext().getBean(JdbcTemplate.class);
		}
		return jdbcTemplate;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  MyBaitsTemplate getMyBaitsTemplate() {
		if(null == myBaitsTemplate)  myBaitsTemplate = ((MyBaitsTemplate<T,PK>) SpringContextHolder.getBean("myBaitsTemplate"));
		return myBaitsTemplate;
	}
	

}
