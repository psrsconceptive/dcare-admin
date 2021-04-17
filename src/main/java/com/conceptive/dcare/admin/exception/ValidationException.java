package com.conceptive.dcare.admin.exception;

public class ValidationException extends CommonException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String publicErrorCode, String publicReason, String privateMessage) {
	    super(publicErrorCode, publicReason, privateMessage, null);
	  }
	
	  public ValidationException(String publicErrorCode, String privateMessage, Throwable cause) {
	    super(publicErrorCode, null, privateMessage, cause);
	  }
	  
	  public ValidationException(String source, String publicErrorCode, String publicReason, String privateMessage, Throwable cause) {
		  super(source, publicErrorCode, publicReason, privateMessage,cause);
	  }

	  public ValidationException(String publicErrorCode, String privateMessage) {
	    this(publicErrorCode, privateMessage, (Throwable) null);
	  }

	  public ValidationException(String publicErrorCode, Throwable cause) {
	    this(publicErrorCode, null, cause);
	  }

	  public ValidationException(String publicErrorCode) {
	    this(publicErrorCode, null, (Throwable) null);
	  }
}
