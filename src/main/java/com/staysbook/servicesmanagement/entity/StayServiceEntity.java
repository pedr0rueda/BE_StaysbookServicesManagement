package com.staysbook.servicesmanagement.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
