package com.conceptive.dcare.admin.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorItem {

  @JsonProperty("Source")
  private String source ;

  @JsonProperty("ReasonCode")
  private String reasonCode;

  @JsonProperty("Description")
  private String description;

  @JsonProperty("Recoverable")
  private Boolean recoverable ;

  @JsonProperty("Details")
  private String details ;

}
