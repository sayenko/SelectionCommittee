package ua.lviv.lgs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Subject;

@SpringBootApplication
@ComponentScan({"ua.lviv.lgs"})
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		new Application().createFacultyAndPassings(run);
	}
	
	public void createFacultyAndPassings(ConfigurableApplicationContext run) {
		FacultyRepository facultyService = run.getBean(FacultyRepository.class);
		
		//Faculty 1
		Faculty faculty = new Faculty();
		faculty.setName("Faculty 1");
		faculty.setRecruitmentPlan(50);		
		
		Map<Subject, Integer> map1 = new HashMap<Subject, Integer>();
		map1.put(Subject.CERTIFICATE, 50);
		map1.put(Subject.MATHEMATICS, 70);
		faculty.setSubjectsMap(map1);
		
		//Faculty 2
		Faculty faculty2 = new Faculty();
		faculty2.setName("Faculty 2");
		faculty2.setRecruitmentPlan(50);
		
		Map<Subject, Integer> map2 = new HashMap<Subject, Integer>();
		map2.put(Subject.CERTIFICATE, 70);
		map2.put(Subject.PHYSICS, 80);				
		faculty2.setSubjectsMap(map2);
		
		//Save faculty
		facultyService.save(faculty);
		facultyService.save(faculty2);
	}
}
