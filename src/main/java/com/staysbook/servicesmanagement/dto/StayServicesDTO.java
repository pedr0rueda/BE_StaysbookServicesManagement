package com.staysbook.servicesmanagement.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.staysbook.servicesmanagement.entity.ServiceEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class StayServicesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("IdStay")
	private Long IdStay;

	@JsonProperty("NameStay")
	private String nameStay;
	
	@JsonProperty("DescriptionStay")
	private String descriptionStay;

	@JsonProperty("Services")
	private List<ServiceEntity> services;

}
