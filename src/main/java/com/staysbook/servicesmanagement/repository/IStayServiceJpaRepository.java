package com.staysbook.servicesmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.staysbook.servicesmanagement.dto.ServiceByStayDTO;
import com.staysbook.servicesmanagement.entity.ServiceEntity;

@Repository
public interface IStayServiceJpaRepository extends JpaRepository<ServiceEntity, Long> {

	@Query("SELECT new com.staysbook.servicesmanagement.dto.ServiceByStayDTO "
			+ "( st.idStay, st.name, st.description, se.idService, se.name ) "
			+ "FROM StayEntity st "
			+ "INNER JOIN StayServiceEntity ss ON ss.idStay    = st.idStay "
			+ "INNER JOIN ServiceEntity     se ON se.idService = ss.idService "
			+ "WHERE st.idStay IN :idStays "
			+ "ORDER BY st.idStay, se.idService")
	List<ServiceByStayDTO> getServicesByStays(@Param("idStays") List<String> idStays);
}
