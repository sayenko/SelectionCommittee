package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;

@Service
public class FacultyService {
	
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);
	
	@Autowired
	FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		logger.info("Register new faculty {}: " + faculty);
		facultyRepository.save(faculty);
	}
	
	public List<Faculty> getAllFaculties(){
		logger.info("Get all faculties");
		return facultyRepository.findAll();
	}
	
	public Faculty findByName(String name) {
		logger.info("Get faculty {} by name: " + name);
		return facultyRepository.findByName(name);
	}
}
