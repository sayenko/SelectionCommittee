package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EntrantRegisterRepository;
import ua.lviv.lgs.domain.EntrantRegister;

@Service
public class EntrantRegisterService {
	
	private Logger logger = LoggerFactory.getLogger(EntrantRegisterService.class);

	@Autowired
	private EntrantRegisterRepository entrantRegisterRepository;
	
	public List<EntrantRegister> getAll(){
		logger.info("Get all entrant registers");
		return entrantRegisterRepository.findAll();
	}
	
	public void delete(EntrantRegister entrantRegister) {
		logger.info("Delete entrant register item {}: " + entrantRegister);
		entrantRegisterRepository.delete(entrantRegister);
	}
	
	public EntrantRegister add(EntrantRegister entrantRegister) {
		logger.info("Create new entrant register {}: " + entrantRegister);
		return entrantRegisterRepository.save(entrantRegister);
	}
	
	public EntrantRegister findByEntrantId(Integer id){
		logger.info("Get entrant register item {} by id: " + id);
		return entrantRegisterRepository.findByEntrantId(id).orElse(null);
	}
}

