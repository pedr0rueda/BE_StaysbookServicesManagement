package com.staysbook.servicesmanagement.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ServiceByStayDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("IdStay")
	private Long IdStay;

	@JsonProperty("NameStay")
	private String nameStay;

	@JsonProperty("DescriptionStay")
	private String descriptionStay;

	@JsonProperty("IdService")
	private Long idService;

	@JsonProperty("NameService")
	private String nameService;

}
