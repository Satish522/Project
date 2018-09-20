package org.swapna.mission.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.swapna.mission.piaregistration.PiaRegistration;
import org.swapna.mission.service.EmpService;

@Controller
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	protected EmpService empService;
	
	@RequestMapping(value= {"/"})
	public String getRequest()
	{
		logger.info("Landing Page");
		return "Registration";
		
	}
	
	
	/*@RequestMapping(value= {"/{page}"},method=RequestMethod.GET)
	public String getRequest(@PathParam("page") String page)
	{

		return page;
	}*/


	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registrationController(Model model)
	{
		logger.info("Entered into Registration Page");
		PiaRegistration piaRegistration=new PiaRegistration();
		model.addAttribute("piaRegistration", piaRegistration);
		/*ModelAndView model=new ModelAndView();
		model.setViewName("piaregistration.htm");*/
		return "piaregistration";
		
	}
	
	@RequestMapping("/piaregistration")
	public ModelAndView piaregistration(@ModelAttribute("piaRegistration") PiaRegistration piaRegistration)
	{
		logger.info("Saving PIA information"+piaRegistration.getPiaName());
		int id=0;
		try {
			id=empService.register(piaRegistration);
		}catch(Exception e) {
			logger.error("Could not save");
		}
		ModelAndView model=new ModelAndView();
		model.setViewName("acknowledge");
		model.addObject("PIAName",piaRegistration.getPiaName());
		model.addObject("id",id);
		
		return model;

	}

}
