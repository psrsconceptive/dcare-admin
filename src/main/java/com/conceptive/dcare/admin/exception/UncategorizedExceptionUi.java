package com.conceptive.dcare.admin.exception;

/**
 *
 * @author e081151
 */
public class UncategorizedExceptionUi extends IssuerUiServiceBaseException {

  private static final long serialVersionUID = -1510315512754944079L;

  public UncategorizedExceptionUi(String publicMessage) {
    super(null, publicMessage);
  }

  public UncategorizedExceptionUi(String publicMessage, String privateMessage) {
    super(null, publicMessage, privateMessage);
  }

  public UncategorizedExceptionUi(String publicMessage, Throwable cause) {
    super(null, publicMessage, cause);
  }

  public UncategorizedExceptionUi(String publicMessage, String privateMessage, Throwable cause) {
    super(null, publicMessage, privateMessage, cause);
  }
}
