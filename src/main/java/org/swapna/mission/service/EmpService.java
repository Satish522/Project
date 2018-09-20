package org.swapna.mission.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.swapna.mission.dao.EmpDao;
import org.swapna.mission.dto.PiaRegistrationDto;
import org.swapna.mission.piaregistration.PiaRegistration;

@Service
public class EmpService {
	
	@Autowired
	protected EmpDao empdao;
	
	@Transactional
	public int register(PiaRegistration  piaRegistration)
	{
	    piaRegistration=new PiaRegistration();
		PiaRegistrationDto piaRegistrationDto=new PiaRegistrationDto();
		int ret=empdao.getCount();

		piaRegistrationDto.setPIAName(piaRegistration.getPiaName());
		piaRegistrationDto.setId(ret);
		return empdao.save(piaRegistrationDto);
		
	
	}
	



}
