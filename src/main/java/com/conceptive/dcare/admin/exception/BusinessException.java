package com.conceptive.dcare.admin.exception;

public class BusinessException extends CommonException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String publicErrorCode, String publicReason, String privateMessage) {
	    super(publicErrorCode, publicReason, privateMessage, null);
	  }

	  public BusinessException(String publicErrorCode, String privateMessage, Throwable cause) {
	    super(publicErrorCode, null, privateMessage, cause);
	  }

	  public BusinessException(String publicErrorCode, String privateMessage) {
	    this(publicErrorCode, privateMessage, (Throwable) null);
	  }

	  public BusinessException(String publicErrorCode, Throwable cause) {
	    this(publicErrorCode, null, cause);
	  }

	  public BusinessException(String publicErrorCode) {
	    this(publicErrorCode, null, (Throwable) null);
	  }
}
