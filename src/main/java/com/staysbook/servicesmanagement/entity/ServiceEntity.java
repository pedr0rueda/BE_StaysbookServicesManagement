package com.staysbook.servicesmanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
