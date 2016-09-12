
package com.qtz.ht.user.vo;  

import com.mall.core.vo.VO;

/** 
 * ClassName:CpiaoYxd <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年9月12日 下午8:31:21 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
public class CpiaoYxd extends VO<Long> implements java.io.Serializable {

	/****/  
	private static final long serialVersionUID = 4581179708009574298L;

	/**
	 * 彩票号码
	 */
	private String number ;
	/**
	 * 出彩票时期
	 */
	private String dateline;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDateline() {
		return dateline;
	}
	public void setDateline(String dateline) {
		this.dateline = dateline;
	}
	
	
}
  