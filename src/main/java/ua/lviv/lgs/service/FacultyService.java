package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;

@Service
public class FacultyService {
	
	@Autowired
	FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		facultyRepository.save(faculty);
	}
	
	public List<Faculty> getAllFaculties(){
		return facultyRepository.findAll();
	}
	
	public Faculty findByName(String name) {
		return facultyRepository.findByName(name);
	}
}
