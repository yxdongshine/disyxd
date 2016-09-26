
package com.yxd.hadoop.test.object;  

import java.io.Serializable;

/** 
 * ClassName:HardDiskInfo <br/> 
 * Function: TODO (硬盘信息类). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月23日 上午11:10:33 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class HardDiskInfo implements Serializable {

	/****/  
	private static final long serialVersionUID = 8594327710496052556L;

	/**
	 * 硬盘容量
	 */
	private String capacity;

	public HardDiskInfo(String capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
	}
	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	
}
  