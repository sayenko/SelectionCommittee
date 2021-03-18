package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.EntrantRegisterRepository;
import ua.lviv.lgs.domain.EntrantRegister;

@Service
public class EntrantRegisterService {

	@Autowired
	private EntrantRegisterRepository entrantRegisterRepository;
	
	public List<EntrantRegister> getAll(){
		return entrantRegisterRepository.findAll();
	}
	
	public void delete(EntrantRegister entrantRegister) {
		entrantRegisterRepository.delete(entrantRegister);
	}
	
	public EntrantRegister add(EntrantRegister entrantRegister) {
		return entrantRegisterRepository.save(entrantRegister);
	}
	
	public EntrantRegister findByEntrantId(Integer id){
		return entrantRegisterRepository.findByEntrantId(id).orElse(null);
	}
}
