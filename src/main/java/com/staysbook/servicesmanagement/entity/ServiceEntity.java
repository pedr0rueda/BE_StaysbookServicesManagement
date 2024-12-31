package com.staysbook.servicesmanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "SERVICE")
public class ServiceEntity {

	@Basic(optional = false)
	@Column(name = "ID_SERVICE")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("IdService")
	@NotNull
	private Long idService;

	@Basic(optional = false)
	@Column(name = "NAME")
	@JsonProperty("NameService")
	@NotNull
	@Size(min = 1, max = 100)
	private String name;

}
