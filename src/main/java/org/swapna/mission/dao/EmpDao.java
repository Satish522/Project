package org.swapna.mission.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.swapna.mission.bo.PiaRegistrationBo;
import org.swapna.mission.dto.PiaRegistrationDto;

@Repository
public class EmpDao {
	
	protected final String SQL_PIA_REGISTRATION="insert into pia_registration(pia_name,id) values(?,?)";
	protected final String SQL_PIA_COUNT="select count(*) from pia_registration";
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public int save(PiaRegistrationDto piaRegistrationDto)
	{
		PiaRegistrationBo piaRegistratioBo=new PiaRegistrationBo();
		
		piaRegistratioBo.setPIAName(piaRegistrationDto.getPIAName());
		piaRegistratioBo.setId(piaRegistrationDto.getId());
		int status= jdbcTemplate.update(SQL_PIA_REGISTRATION, new Object[] {piaRegistratioBo.getPIAName(),piaRegistratioBo.getId()});
		
		if(status >0)
		{
			System.out.println("Name Sucessfully Register");
		}
		else
		{
			System.out.println("Please Reenter");
		}
		return piaRegistratioBo.getId();
	}
	
	public int getCount()
	{
		int count=0;
		count=jdbcTemplate.queryForObject(SQL_PIA_COUNT,Integer.class);
		count++;
		return count;
	}

}
