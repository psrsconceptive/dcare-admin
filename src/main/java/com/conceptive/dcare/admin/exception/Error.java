package com.conceptive.dcare.admin.exception;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Error
 */


@Getter 
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Error {

  @JsonProperty("Errors")
  @Valid
  private Errors errors;

}
