
package com.yxd.hadoop.test.object;  

import java.io.Serializable;

/** 
 * ClassName:EMSInfo <br/> 
 * Function: TODO (EMS 对象类). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月23日 上午11:06:22 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class EMSInfo implements Serializable{

	/****/  
	private static final long serialVersionUID = 6655965224472548877L;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 容量
	 */
	private String capacity;
	
	public EMSInfo(String type,String capacity) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.capacity = capacity;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	 
	
}
  