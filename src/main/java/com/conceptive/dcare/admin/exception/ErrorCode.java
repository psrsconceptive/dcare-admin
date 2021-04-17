package com.conceptive.dcare.admin.exception;

public class ErrorCode {
	
	
	public static final String RECORD_NOT_MATCH="Unable to match record please correct and resubmit";
	
	public static final String INVALID_REQUEST_PARAMETER = "INVALID_REQUEST_PARAMETER";
	
	public static final String FRAUD_TYPE_IS_REQUIRED="Fraud type must not be null when the fraud status is either confirmed or un confirmed fraud";
			
	public static final String INVALID_REQUEST_PARAMETER_DESC = "%s or invalid";
	 ;
	
	
	private ErrorCode() {
	    throw new IllegalStateException("Utility class");
	  }

}
