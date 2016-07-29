package com.qtz.ht.user.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.mall.core.vo.VO;

public class HtUser extends VO<Long> implements java.io.Serializable {

	
	/**类的版本号*/
	private static final long serialVersionUID = 1601393422649344L;

	
	/** 商户信息id */
	private Long busiId;
	/**  */
	private String account;
	/**  */
	private String password;
	/** 真实姓名 */
	private String realName;
	/** 用户头像 */
	private String headPortrait;
	/** 用户类型（参见userType枚举类型） */
	private Integer userType;
	/** 性别(1：l男；2：女；3：保密) */
	private Integer sex;
	/** 创建时间 */
	private Long crtime;
	/**  */
	private Long crname;
	/** 最后登录时间 */
	private Long lastLogin;
	public Long getDmId() {
	    return this.dmId;
	}
	public void setDmId(Long dmId) {
	    this.dmId=dmId;
	}
	public Long getBusiId() {
	    return this.busiId;
	}
	public void setBusiId(Long busiId) {
	    this.busiId=busiId;
	}
	public String getAccount() {
	    return this.account;
	}
	public void setAccount(String account) {
	    this.account=account;
	}
	public String getPassword() {
	    return this.password;
	}
	public void setPassword(String password) {
	    this.password=password;
	}
	public String getRealName() {
	    return this.realName;
	}
	public void setRealName(String realName) {
	    this.realName=realName;
	}
	public String getHeadPortrait() {
	    return this.headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
	    this.headPortrait=headPortrait;
	}
	public Integer getUserType() {
	    return this.userType;
	}
	public void setUserType(Integer userType) {
	    this.userType=userType;
	}
	public Integer getSex() {
	    return this.sex;
	}
	public void setSex(Integer sex) {
	    this.sex=sex;
	}
	public Long getCrtime() {
	    return this.crtime;
	}
	public void setCrtime(Long crtime) {
	    this.crtime=crtime;
	}
	public Long getCrname() {
	    return this.crname;
	}
	public void setCrname(Long crname) {
	    this.crname=crname;
	}
	public Long getLastLogin() {
	    return this.lastLogin;
	}
	public void setLastLogin(Long lastLogin) {
	    this.lastLogin=lastLogin;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
