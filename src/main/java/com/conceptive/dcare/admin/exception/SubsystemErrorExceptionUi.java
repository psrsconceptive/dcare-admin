package com.conceptive.dcare.admin.exception;

/**
 * The Class SubsystemErrorException.
 *
 * @author e081151
 */
public class SubsystemErrorExceptionUi extends IssuerUiServiceBaseException {

  private static final long serialVersionUID = 1L;

  public SubsystemErrorExceptionUi(String source, String publicErrorCode, String publicReason) {
    super(source, publicErrorCode, publicReason, null, null);
  }

  public SubsystemErrorExceptionUi(String source, String publicErrorCode, String publicReason, Throwable cause) {
    super(source, publicErrorCode, publicReason, null, cause);
  }

  public SubsystemErrorExceptionUi(String source, String publicErrorCode) {
    super(source, publicErrorCode, null, null, null);
  }

}
