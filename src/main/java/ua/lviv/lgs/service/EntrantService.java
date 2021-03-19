package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Subject;

@Service
public class EntrantService {
	
	private Logger logger = LoggerFactory.getLogger(EntrantService.class);
	
	@Autowired
	private EntrantRepository entrantRepository;
	
	public Entrant save(Entrant entrant) {
		logger.info("Register new entrant {}: " + entrant);
		return entrantRepository.save(entrant);
	}
	
	public List<Entrant> getAllEntrants(){
		logger.info("Get all entrants");
		return entrantRepository.findAll();
	}
	
	public Entrant findById(Integer id) {
		logger.info("Get entrant {} by id: " + id);
		return entrantRepository.findById(id).get();
	}
	
	public Subject[] getSubjects() {
		logger.info("Get subject items from all entrants");
		return EntrantRepository.getSubjects();
	}
	
}
