package com.conceptive.dcare.admin.message.response;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.conceptive.dcare.admin.model.GenericError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * HttpGenericResponse
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class HttpGenericResponse {

  @JsonProperty("correlationId")
  //@ApiModelProperty(required = true, value = "Unique identifier for the request. Will always be provided (success or error scenarios)")
  @NotNull
  @Builder.Default
  private String correlationId = "";

  @JsonProperty("errors")
  @JsonInclude(Include.NON_EMPTY)
  //@ApiModelProperty(value = "Errors")
  @Valid
  @Builder.Default
  private List<GenericError> errors = null;

  public HttpGenericResponse addErrorsItem(GenericError errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<GenericError>();
    }
    this.errors.add(errorsItem);
    return this;
  }






  
 
}

