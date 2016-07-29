package com.mall.core.vo;

import java.io.Serializable;

public class VO<PK extends Serializable> implements Serializable {

	/**(用一句话描述这个变量表示什么)*/
	private static final long serialVersionUID = -4443871748239452071L;

	/**业务ID*/
	protected PK dmId;

	public PK getDmId() {
		return dmId;
	}

	public void setDmId(PK dmId) {
		this.dmId = dmId;
	}

	public static enum Status{
		NO(1),OK(0);
		private int value;
		
		private Status(int value) {
			this.value = value;
		}

		public int value() {
			return value;
		}
	}



}
