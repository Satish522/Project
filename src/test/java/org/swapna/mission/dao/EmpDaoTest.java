package org.swapna.mission.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.swapna.mission.dto.PiaRegistrationDto;
import org.swapna.mission.piaregistration.PiaRegistration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:resources/appConfig.xml"})
public class EmpDaoTest {
	
	@Autowired
	EmpDao empDao;
	
	@Test
	public void piaSave() {
		assertThat(empDao, instanceOf(EmpDao.class));
		
		PiaRegistrationDto pia=new PiaRegistrationDto();
		pia.setId(6);
		pia.setPIAName("Swapna");
		assertEquals(1,empDao.save(pia));
	}
}
