package com.conceptive.dcare.admin.exception;

/**
 *
 * @author e081151
 */
public class InvalidRequestExceptionUi extends IssuerUiServiceBaseException {
  
  private static final long serialVersionUID = 1L;

	public InvalidRequestExceptionUi(String publicErrorCode, String publicReason, Throwable cause) {
		super(publicErrorCode, publicReason, null, cause);
	}

	public InvalidRequestExceptionUi(String publicErrorCode, String publicReason) {
		this(publicErrorCode, publicReason, null);
	}

	public InvalidRequestExceptionUi(String publicErrorCode, Throwable cause) {
		this(publicErrorCode, null, cause);
	}

	public InvalidRequestExceptionUi(String publicErrorCode) {
		this(publicErrorCode, null, null);
	}
}
