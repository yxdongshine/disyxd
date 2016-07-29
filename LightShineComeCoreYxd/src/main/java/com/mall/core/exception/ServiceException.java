package com.mall.core.exception;

public class ServiceException extends Exception {

	/**
	 * 对象版本编号
	 */
	private static final long serialVersionUID = 7696590695741706297L;
	/**
	 * 错误信息
	 */
	private String errorMessage = null;
	/**
	 * 概括错误信息
	 */
	private String errorTitle = null;
	
	/**错误类型，缺省为0*/
	private int errorType = -1;
	
	/**
	 * ServiceException构造函数
	 */
	public ServiceException() {
		super();
		errorMessage = "Service layer is Error!!";
	}
	
	/**
	 * ServiceException构造函数根据传递的异常信息
	 * @param argMessage
	 */
	public ServiceException(String argMessage) {
		super(argMessage);
		errorMessage = argMessage;
	}
	
	/**
	 * ServiceException构造函数根据传递的异常信息
	 * @param argMessage
	 */
	public ServiceException(int errorType,String errorTitle) {
		super(errorTitle);
		this.errorTitle = errorTitle;
		this.errorMessage = errorTitle;
		this.errorType = errorType;
	}
	
	/**
	 * ServiceException构造函数根据传递的异常信息
	 * @param argMessage
	 */
	public ServiceException(int errorType,String errorTitle,String argMessage) {
		super(argMessage);
		this.errorMessage = argMessage;
		this.errorType = errorType;
		this.errorTitle = errorTitle;
	}
	
	/**
	 * ServiceException构造函数根据传递的异常信息
	 * @param argMessage
	 * @param argThr
	 */
	public ServiceException(String argMessage, Throwable argThr) {
		super(argMessage,argThr);
	}
	
	/**
	 * ServiceException构造函数根据传递的异常信息
	 * @param argMessage
	 * @param argThr
	 */
	public ServiceException(int errorType,String argMessage, Throwable argThr) {
		super(argMessage,argThr);
		this.errorType = errorType;
	}
	
	/**
	 * ServiceException构造函数根据传递的异常信息
	 * @param argMessage
	 * @param argThr
	 */
	public ServiceException(int errorType,String errorTitle,String argMessage, Throwable argThr) {
		super(argMessage,argThr);
		this.errorType = errorType;
		this.errorTitle = errorTitle;
	}
	
	/**
	 * ServiceException构造函数通过传递异常对象
	 * @param argThr
	 */
	public ServiceException(Throwable argThr) {
		super(argThr);
		if(argThr instanceof ServiceException){
			this.errorType = ((ServiceException) argThr).getErrorType();
			this.errorTitle = ((ServiceException) argThr).getErrorTitle();
			this.errorMessage = ((ServiceException) argThr).getErrorMessage();
		}else {
			this.errorType = -1;
			this.errorTitle = argThr.getLocalizedMessage();
			this.errorMessage = argThr.getLocalizedMessage();
		}
	}
	
	/**
	 * 当该异常被打印出来的时候执行
	 * @return String
	 */
	public String toString() {
		StringBuffer sqlString = new StringBuffer();
		sqlString.append("****************************************ServiceException Start****************************************\n");
		sqlString.append(errorMessage);
		sqlString.append("\n****************************************ServiceException End****************************************");
		return sqlString.toString();
	}

	public int getErrorType() {
		return errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

	public String getErrorTitle() {
		return errorTitle;
	}

	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}


}
