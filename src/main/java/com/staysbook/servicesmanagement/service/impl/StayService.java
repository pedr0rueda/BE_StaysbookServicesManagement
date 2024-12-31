package com.staysbook.servicesmanagement.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staysbook.servicesmanagement.dto.ServiceByStayDTO;
import com.staysbook.servicesmanagement.dto.StayServicesDTO;
import com.staysbook.servicesmanagement.entity.ServiceEntity;
import com.staysbook.servicesmanagement.repository.IStayServiceJpaRepository;
import com.staysbook.servicesmanagement.repository.StayServiceRepository;
import com.staysbook.servicesmanagement.service.IStayService;

@Service
public class StayService implements IStayService {

	@Autowired
	IStayServiceJpaRepository stayServiceJpaRepository;

	@Autowired
	StayServiceRepository stayServiceRepository;

	@Override
	public List<StayServicesDTO> getServicesByStaysJpa(String idStays) {

		List<String> idStaysList = Arrays.asList(idStays.split(","));
		List<ServiceByStayDTO> servicesByStaysList = stayServiceJpaRepository.getServicesByStays(idStaysList);

		Map<Long, StayServicesDTO> stayServicesMap = new LinkedHashMap<>();

		for (ServiceByStayDTO serviceStay : servicesByStaysList) {
			// Obtengo el 
			StayServicesDTO stayServices = stayServicesMap.getOrDefault(serviceStay.getIdStay(),
					new StayServicesDTO(serviceStay.getIdStay(), serviceStay.getNameStay(), serviceStay.getDescriptionStay(), new ArrayList<>()));
			
			stayServices.getServices().add(new ServiceEntity(serviceStay.getIdService(), serviceStay.getNameService()));
			
			stayServicesMap.put(serviceStay.getIdStay(), stayServices);
		}

		return new ArrayList<StayServicesDTO>(stayServicesMap.values());
	}

	@Override
	public List<StayServicesDTO> getServicesByStaysProc(String idStays) {
		List<ServiceByStayDTO> servicesByStaysList = stayServiceRepository.getServicesByStays(idStays);
		
		Map<Long, StayServicesDTO> stayServicesMap = new LinkedHashMap<>();

		for (ServiceByStayDTO serviceStay : servicesByStaysList) {
			StayServicesDTO stayServices = stayServicesMap.getOrDefault(serviceStay.getIdStay(),
					new StayServicesDTO(serviceStay.getIdStay(), serviceStay.getNameStay(), serviceStay.getDescriptionStay(), new ArrayList<>()));
			
			stayServices.getServices().add(new ServiceEntity(serviceStay.getIdService(), serviceStay.getNameService()));
			
			stayServicesMap.put(serviceStay.getIdStay(), stayServices);
		}

		return new ArrayList<StayServicesDTO>(stayServicesMap.values());
	}

	/*
	 * @Override public List<ServiceByStayDTO> getServicesByStaysJpa(String idStays)
	 * { // TODO Auto-generated method stub List<String> listIdStays =
	 * Arrays.asList(idStays.split(",")); List<ServiceByStayDTO> servicesByStays =
	 * stayServiceJpaRepository.getServicesByStays(listIdStays);
	 * 
	 * return servicesByStays; }
	 * 
	 * @Override public List<ServiceByStayDTO> getServicesByStaysProc(String
	 * idStays) { // TODO Auto-generated method stub return
	 * stayServiceRepository.getServicesByStays(idStays); }
	 */

}
