package com.conceptive.dcare.admin.exception;

public class SystemErrorException extends CommonException{
	
	private static final long serialVersionUID = 1L;

	public SystemErrorException(String publicErrorCode, String privateMessage, Throwable cause) {
		    super(publicErrorCode, null, privateMessage, cause);
		  }

		  public SystemErrorException(String publicErrorCode, String privateMessage) {
		    this(publicErrorCode, privateMessage, null);
		  }

		  public SystemErrorException(String publicErrorCode, Throwable cause) {
		    this(publicErrorCode, null, cause);
		  }

		  public SystemErrorException(String publicErrorCode) {
		    this(publicErrorCode, null, null);
		  }
}
