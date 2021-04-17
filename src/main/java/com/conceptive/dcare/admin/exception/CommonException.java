package com.conceptive.dcare.admin.exception;

public abstract class CommonException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String IDR="IDR";
	

	  private final String publicErrorCode;
	  private final String publicReason;
	  private final String source;

	  protected CommonException(String publicErrorCode, String publicReason) {
	    super(publicReason);
	    this.publicErrorCode = publicErrorCode;
	    this.publicReason = publicReason;
	    this.source = IDR;
	  }

	  protected CommonException(String publicErrorCode, String publicReason, String privateMessage) {
	    super(privateMessage);
	    this.publicErrorCode = publicErrorCode;
	    this.publicReason = publicReason;
	    this.source = IDR;
	  }

	  protected CommonException(String source, String publicErrorCode, String publicReason, String privateMessage, Throwable cause) {
	    super(privateMessage, cause);
	    this.publicErrorCode = publicErrorCode;
	    this.publicReason = publicReason;
	    this.source = source;
	  }

	  protected CommonException(String publicErrorCode, String publicReason, Throwable cause) {
	    super(cause);
	    this.publicErrorCode = publicErrorCode;
	    this.publicReason = publicReason;
	    this.source = IDR;
	  }

	  protected CommonException(String publicErrorCode, String publicReason, String privateMessage, Throwable cause) {
	    super(privateMessage, cause);
	    this.publicErrorCode = publicErrorCode;
	    this.publicReason = publicReason;
	    this.source = "IDR";
	  }

	  public final String getPublicErrorCode() {
	    return publicErrorCode;
	  }

	  public final String getPublicReason() {
	    return publicReason;
	  }

	  public final String getSource() {
	    return source;
	  }

	  @Override
	  public String getMessage() {

	    return super.getMessage() != null ? super.getMessage() : publicReason;
	  }
	
	
	
	
	

}
