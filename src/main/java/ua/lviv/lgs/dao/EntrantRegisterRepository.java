package ua.lviv.lgs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.EntrantRegister;

@Repository
public interface EntrantRegisterRepository extends JpaRepository<EntrantRegister, Integer>{

	@Query("select er from EntrantRegister er, Entrant e where e.id=?1 and er.entrant.id=e.id")
	Optional<EntrantRegister> findByEntrantId(Integer id);
	
}
