package ua.lviv.lgs.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Subject;
import ua.lviv.lgs.dto.EntrantResponse;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.FacultyService;

@Controller
public class EntrantController {

	@Autowired
	EntrantService entrantsService;
	
	@Autowired
	FacultyService facultyService; 

	@RequestMapping(value = "/addEntrant", method = RequestMethod.POST)
	public ModelAndView createPeriodical(			
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam Integer age, 
			@RequestParam String contacts,
			@RequestParam String faculty,
			@RequestParam String subjectAndPoints,
			@RequestParam MultipartFile image) throws IOException {
		
		Entrant entrant = new Entrant();
		entrant.setFirstName(firstName);
		entrant.setLastName(lastName);
		entrant.setAge(age);
		entrant.setContacts(contacts);
		
		entrant.setSubjectsMap(subjectAndPoints(subjectAndPoints));
		
		Faculty newFaculty = facultyService.findByName(faculty);
		entrant.setFaculty(newFaculty);
		
		entrant.setPhoto(Base64.getEncoder().encodeToString(image.getBytes()));
		
		entrantsService.save(entrant);
		return new ModelAndView("redirect:/home");
	}
	
	public Map<Subject, Integer> subjectAndPoints(String subjectAndPoints){		
		Map<Subject, Integer> stringMap = new HashMap<Subject, Integer>();
		String[] split = subjectAndPoints.split(",");
		for(int i = 0; i<split.length-1; i++) {
			
			for (Subject subject : Subject.values()) {
		        if (subject.name().equals(split[i])) {
		        	stringMap.put(subject, Integer.valueOf(split[i+1]));
					i++;
		        }
		    }			
		}		
		return stringMap;
	}
	
}