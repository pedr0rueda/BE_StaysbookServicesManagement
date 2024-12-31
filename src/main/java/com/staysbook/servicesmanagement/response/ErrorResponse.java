package com.staysbook.servicesmanagement.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ErrorResponse {
	
	@JsonProperty("CodeError")
	private Integer code;
	
	@JsonProperty("DescriptionError")
	private String description;
}
