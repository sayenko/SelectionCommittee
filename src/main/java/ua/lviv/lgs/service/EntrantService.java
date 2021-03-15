package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Subject;

@Service
public class EntrantService {
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	public Entrant save(Entrant entrant) {
		return entrantRepository.save(entrant);
	}
	
	public List<Entrant> getAllEntrants(){
		return entrantRepository.findAll();
	}
	
	public Entrant findById(Integer id) {		
		return entrantRepository.findById(id).get();
	}
	
	public Subject[] getSubjects() {
		return EntrantRepository.getSubjects();
	}
	
}
