
package com.yxd.hadoop.test.object;  

import java.io.Serializable;

/** 
 * ClassName:CPUInfo <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月23日 上午11:01:51 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class CPUInfo implements Serializable {

	/****/  
	private static final long serialVersionUID = -3078424662679003768L;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 * 主频
	 */
	private String frequency;
	
	public CPUInfo(String brand,String frequency) {
		// TODO Auto-generated constructor stub
	   this.brand = brand;
	   this.frequency =frequency;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	
}
  