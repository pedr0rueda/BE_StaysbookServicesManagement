package com.staysbook.servicesmanagement.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.staysbook.servicesmanagement.dto.ServiceByStayDTO;


@Repository
public class StayServiceRepository {

	@Autowired
	JdbcTemplate jdbcTemplate; 

	public List<ServiceByStayDTO> getServicesByStays(String idStays) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("GetServicesByStays")
				.declareParameters(new SqlParameter[] {
						new SqlParameter("i_vStayIds", Types.VARCHAR),
						new SqlParameter("o_rServices", Types.REF_CURSOR)
				})
				.returningResultSet("o_rServices", new RowMapper<ServiceByStayDTO>() {
					@Override
					public ServiceByStayDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						ServiceByStayDTO serviceByStay = new ServiceByStayDTO();
						serviceByStay.setIdStay(rs.getLong(1));
						serviceByStay.setNameStay(rs.getString(2));
						serviceByStay.setDescriptionStay(rs.getString(3));
						serviceByStay.setIdService(rs.getLong(4));
						serviceByStay.setNameService(rs.getString(5));
						
						return serviceByStay;
					}
				});
		
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("i_vStayIds", idStays);
		
		Map<String, Object> results = simpleJdbcCall.execute(mapSqlParameterSource);
		
		List<ServiceByStayDTO> serviceByStayList = (List<ServiceByStayDTO>) results.get("o_rServices");
		
		return serviceByStayList;
	}

}
