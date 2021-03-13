package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Subject;

@Repository
public interface EntrantRepository extends JpaRepository<Entrant, Integer> {
	
	public static Subject[] getSubjects() {
		return Subject.values();
	}
	
}
