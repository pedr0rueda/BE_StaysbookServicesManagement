package com.staysbook.servicesmanagement.service;

import java.util.List;

import com.staysbook.servicesmanagement.dto.StayServicesDTO;

public interface IStayService {
	// public List<ServiceByStayDTO> getServicesByStaysJpa(String idStays);
	
	// public List<ServiceByStayDTO> getServicesByStaysProc(String idStays);
	
	public List<StayServicesDTO> getServicesByStaysJpa(String idStays);
	
	public List<StayServicesDTO> getServicesByStaysProc(String idStays);
}
