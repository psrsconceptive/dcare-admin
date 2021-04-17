package com.conceptive.dcare.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GenericError {

    @JsonProperty("source")
    @Schema(description = "An actionable item for the client (e.g. the account_uri)")
    @Builder.Default
    private String source = null;

    @JsonProperty("reasonCode")
    @Schema(description = "Reason code of the error")
    @Builder.Default
    private String reasonCode = null;

    @JsonProperty("description")
    @Builder.Default
    private String description = null;

    @JsonProperty("recoverable")
    @Builder.Default
    private String recoverable = null;
}
