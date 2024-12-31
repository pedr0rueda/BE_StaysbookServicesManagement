package com.staysbook.servicesmanagement.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "STAY_SERVICE")
public class StayServiceEntity {

	@Basic(optional = false)
	@Column(name = "ID_STAY_SERVICE")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long idStayService;

	@Basic(optional = false)
	@Column(name = "ID_STAY")
	@NotNull
	private Long idStay;

	@Basic(optional = false)
	@Column(name = "ID_SERVICE")
	@NotNull
	private Long idService;

}
