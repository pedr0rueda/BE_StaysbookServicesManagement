package com.staysbook.servicesmanagement.entity;

import java.math.BigDecimal;

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
@Table(name = "STAY")
public class StayEntity {

	@Basic(optional = false)
	@Column(name = "ID_STAY")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long idStay;

	@Basic(optional = false)
	@Column(name = "NAME")
	@NotNull
	@Size(min = 1, max = 200)
	private String name;

	@Basic(optional = false)
	@Column(name = "PRICE")
	@NotNull
	private BigDecimal price;

	@Basic(optional = false)
	@Column(name = "picture")
	@NotNull
	@Size(min = 1, max = 200)
	private String picture;

	@Basic(optional = false)
	@Column(name = "DESCRIPTION")
	@NotNull
	@Size(min = 1, max = 200)
	private String description;

	@Basic(optional = false)
	@Column(name = "id_address")
	@NotNull
	private Long idAddress;

}
