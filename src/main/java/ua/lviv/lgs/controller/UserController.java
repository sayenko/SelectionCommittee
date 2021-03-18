package ua.lviv.lgs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.EntrantRegisterService;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.UserService;

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private EntrantService entrantService;
    
    @Autowired
    private EntrantRegisterService entrantRegisterService;
    
    @Autowired
    private FacultyService facultyService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);

        return "redirect:/home";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView welcome() {
		ModelAndView map = new ModelAndView("home");
		map.addObject("entrants", unallocatedEntrants());
		unallocatedEntrants();
		return map;
	}
    
    @RequestMapping(value ="/create-entrant", method = RequestMethod.GET)
    public ModelAndView createEntrant() {
    	ModelAndView map = new ModelAndView("registration_form");
		List<String> allFaculties = facultyService.getAllFaculties().stream().map(Faculty::getName).collect(Collectors.toList());
    	map.addObject("allFaculties", allFaculties);
    	map.addObject("allSubjects", entrantService.getSubjects());
    	
        return map;
    }
    
    public List<Entrant> unallocatedEntrants() {
    	List<Entrant> allEntrants = entrantService.getAllEntrants();
    	List<Entrant> collect = entrantRegisterService.getAll().stream().map(x-> x.getEntrant()).collect(Collectors.toList());
    	
//    	List<Entrant> coll = new ArrayList<Entrant>();
//    	for(Entrant entrant: allEntrants) {
//    		if(!collect.contains(entrant)) {
//    			coll.add(entrant);
//    		}
//    	}
//    	return coll;
    	return allEntrants.stream().filter(entrant -> !collect.contains(entrant)).collect(Collectors.toList());
    }
    
}