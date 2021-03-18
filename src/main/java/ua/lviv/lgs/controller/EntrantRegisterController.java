package ua.lviv.lgs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.EntrantRegister;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Subject;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.EntrantRegisterService;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.UserService;

@Controller
public class EntrantRegisterController {
	
	@Autowired
	private EntrantRegisterService entrantRegisterService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EntrantService entrantService;
	
	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value ="/registers", method = RequestMethod.GET)
	public ModelAndView getAllItems() {
		return getRegistrItems();
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam Integer entrantId, @RequestParam String facultyName) {
		
		Entrant entrant = entrantService.findById(entrantId);
		entrant.setAddedToRegister(true);
		entrantService.save(entrant);
		
		EntrantRegister entrantRegister = new EntrantRegister();
		EntrantRegister isAlreadyCreatedEntrantRegister = entrantRegisterService.findByEntrantId(entrantId);
		if(isAlreadyCreatedEntrantRegister != null) {
			entrantRegister = isAlreadyCreatedEntrantRegister;
		}
		entrantRegister.setEntrant(entrant);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		String userLogin = authentication.getName();		
		User findUserByLogin = userService.findByLogin(userLogin);
		entrantRegister.setUser(findUserByLogin);
		
		Faculty faculty = facultyService.findByName(facultyName);
		entrantRegister.setFaculty(faculty);
		
		if(isPassing(faculty, entrant.getSubjectsMap())) {
			entrantRegisterService.add(entrantRegister);
		}
		return getRegistrItems();
	}
	 
	@RequestMapping(value ="/register", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam String id) {
		entrantRegisterService.delete(new EntrantRegister(Integer.parseInt(id.replaceAll("\\s", ""))));
		return getRegistrItems();
	}
	 
	private ModelAndView getRegistrItems() {
		ModelAndView map = new ModelAndView("register_sheet");
		map.addObject("registerItems", entrantRegisterService.getAll());
		return map;
	}
	
	public boolean isPassing(Faculty faculty, Map<Subject, Integer> entrantSubjectAndPoints) {
		
		Map<Subject, Integer> facultySubjectAndPoints = faculty.getSubjectsMap();		

//		for (Entry<Subject, Integer> facultyEntry : facultySubjectAndPoints.entrySet()) {
//			for (Entry<Subject, Integer> entrantEntry : entrantSubjectAndPoints.entrySet()) {
//				if(entrantEntry.getKey().name().equalsIgnoreCase(facultyEntry.getKey().name())
//						&& entrantEntry.getValue() < facultyEntry.getValue()) {
//					return false;
//				}
//			}
//		}
//		return true;

		return facultySubjectAndPoints.entrySet().stream()
		.noneMatch(facultyEntry -> entrantSubjectAndPoints.entrySet().stream()
			.anyMatch(entrantEntry -> entrantEntry.getKey().name().equalsIgnoreCase(facultyEntry.getKey().name())
        && entrantEntry.getValue() < facultyEntry.getValue()));

	}
	
}
