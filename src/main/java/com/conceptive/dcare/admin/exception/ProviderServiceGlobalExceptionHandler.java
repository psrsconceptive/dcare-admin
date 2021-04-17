package com.conceptive.dcare.admin.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.conceptive.dcare.admin.message.response.HttpGenericResponse;
import com.conceptive.dcare.admin.model.CurrentCorrelationInfo;
import com.conceptive.dcare.admin.model.GenericError;

import lombok.extern.slf4j.Slf4j;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class ProviderServiceGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Boolean RECOVERABLE_FALSE = false;
	private static final Boolean RECOVERABLE_TRUE = true;

	private static final String RECOVERABLE_TRUE_STRING = "true";

	/**
	 * Handles Default Exceptions.
	 */
	@ExceptionHandler(value = SystemErrorException.class)
	public ResponseEntity<Object> exception(SystemErrorException exception) {

		List<ErrorItem> errorItems = new ArrayList<>();

		log.error("SystemErrorException - ErrorCode:" + exception.getPublicErrorCode() + " "
				+ getCorrelationInfoMessage(exception.getMessage()), exception);
		ErrorItem errorItem = populateResponse(exception.getSource(), exception.getPublicErrorCode(), null,
				RECOVERABLE_FALSE, getCorrelationId());

		errorItems.add(errorItem);
		Errors errors = Errors.builder().error(errorItems).build();
		Error error = Error.builder().errors(errors).build();

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		List<ErrorItem> errorItems = new ArrayList<>();
		log.error("SystemErrorException - ErrorCode: Cardholder Application Internal Error "
				+ getCorrelationInfoMessage(exception.getMessage()), exception);
//    ErrorItem errorItem = populateResponse("Internal Error", "CARD_HOLDER_APP_INTERNAL_ERROR","Cardholder System Internal Error", RECOVERABLE_FALSE, getCorrelationId());
//    errorItems.add(errorItem);
//    Errors errors = Errors.builder()
//            .error(errorItems)
//            .build();
//    Error error = Error.builder()
//            .errors(errors)
//            .build();

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(((HttpClientErrorException) exception).getResponseBodyAsString());
	}

	// @Valid annotation error handler
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult result = ex.getBindingResult();
		List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
		log.error("InvalidRequestException - ErrorCode:" + ErrorCode.INVALID_REQUEST_PARAMETER + " "
				+ getCorrelationInfoMessage(ex.getMessage()), ex);
		List<ErrorItem> errorItems = new ArrayList<>();
		for (org.springframework.validation.FieldError fieldError : fieldErrors) {

			ErrorItem errorItem = populateResponse(fieldError.getObjectName(), ErrorCode.INVALID_REQUEST_PARAMETER,
					fieldError.getField() + " " + fieldError.getDefaultMessage(), RECOVERABLE_TRUE, getCorrelationId());

			errorItems.add(errorItem);
		}

		Errors errors = Errors.builder().error(errorItems).build();
		Error error = Error.builder().errors(errors).build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<Object> exception(ValidationException exception) {

		log.error(getCorrelationInfoMessage(exception.getMessage()), exception);
		HttpGenericResponse httpGenericResponse = populateResponse(exception.getSource(),
				exception.getPublicErrorCode(), exception.getPublicReason(), RECOVERABLE_TRUE_STRING);
		return ResponseEntity.status(HttpStatus.OK).body(httpGenericResponse);

	}

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Object> exception(BusinessException exception) {
		log.error(getCorrelationInfoMessage(exception.getMessage()), exception);
		HttpGenericResponse httpGenericResponse = populateResponse(exception.getSource(),
				exception.getPublicErrorCode(), exception.getPublicReason(), RECOVERABLE_TRUE_STRING);
		return ResponseEntity.status(HttpStatus.OK).body(httpGenericResponse);
	}

	private HttpGenericResponse populateResponse(String source, String reasonCode, String description,
			String recoverable) {
		List<GenericError> errors = new ArrayList<>();
		GenericError error = GenericError.builder().source(source).description(description).reasonCode(reasonCode)
				.recoverable(recoverable).build();
		errors.add(error);
		return HttpGenericResponse.builder().errors(errors)
				.correlationId(CurrentCorrelationInfo.getInstance().get().getCorrelationId()).build();

	}

	private ErrorItem populateResponse(String source, String reasonCode, String description, Boolean recoverable,
			String details) {
		ErrorItem errorItem = ErrorItem.builder().source(source).description(description).reasonCode(reasonCode)
				.recoverable(recoverable).details(details).build();
		return errorItem;
	}

	private String getCorrelationInfoMessage(String message) {
		return CurrentCorrelationInfo.getInstance().get().toString() + " msg= " + message;
	}

	private String getCorrelationId() {
		return CurrentCorrelationInfo.getInstance().get().getCorrelationId();
	}
}
