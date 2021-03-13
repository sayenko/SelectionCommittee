package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Subject;

public interface FacultyRepository  extends JpaRepository<Faculty, Integer> {
	
	public Faculty findByName(String name);

}
