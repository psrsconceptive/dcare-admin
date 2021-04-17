package com.conceptive.dcare.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CorrelationInfo implements Serializable {
  public static final String CORRELATION_ID = "correlationId";

	  private static final long serialVersionUID = -7545598698401887749L;

	  private String correlationId;
	  private long startTime;

}
