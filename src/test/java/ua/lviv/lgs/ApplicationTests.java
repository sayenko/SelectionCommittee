package ua.lviv.lgs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.EntrantRegisterRepository;
import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.EntrantRegister;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.Subject;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.EntrantRegisterService;
import ua.lviv.lgs.service.EntrantService;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.UserService;

import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class ApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EntrantRepository entrantRepository;

	@Autowired
	private EntrantRegisterRepository entrantRegisterRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EntrantService entrantService;
	
	@Autowired
	private EntrantRegisterService entrantRegisterService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));
		
		User user = new User();
		user.setLogin("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(Role.ROLE_ENTRANT);
		
		userService.save(user);
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
		
		User userFromDb = users.get(0);
		assertTrue(userFromDb.getLogin().equals(user.getLogin()));
		assertTrue(userFromDb.getPassword().equals(user.getPassword()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));
		
	}
	
	@Test
	public void testFindUserByLogin() {
		
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));
		
		User user = new User();
		user.setLogin("login");
		user.setPassword("2");
		user.setPasswordConfirm("2");
		user.setRole(Role.ROLE_ENTRANT);
		
		userRepository.save(user);
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
		
		User userFromDb = userService.findByLogin(user.getLogin());
		assertTrue(userFromDb.getLogin().equals(user.getLogin()));
		assertTrue(userFromDb.getPassword().equals(user.getPassword()));
		assertTrue(userFromDb.getRole().equals(user.getRole()));
	}
	
	@Test
	public void testSaveEntrant() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));
		
		Entrant entrant = new Entrant();
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setAge(1);
		entrant.setContacts("1");
		entrant.setPhoto("1");
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		
		entrant.setFaculty(faculty);
		entrantService.save(entrant);
		
		entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(1));
		
		Entrant entrantFromDb = entrants.get(0);
		assertTrue(entrantFromDb.getFirstName().equals(entrant.getFirstName()));
		assertTrue(entrantFromDb.getLastName().equals(entrant.getLastName()));
		assertTrue(entrantFromDb.getAge()==entrant.getAge());
		assertTrue(entrantFromDb.getContacts().equals(entrant.getContacts()));
		assertTrue(entrantFromDb.getFaculty().equals(entrant.getFaculty()));
		assertTrue(entrantFromDb.getPhoto().equals(entrant.getPhoto()));
	}
	
	@Test
	public void testGetAllEntrants() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));
		
		Entrant entrant = new Entrant();
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setAge(1);
		entrant.setContacts("1");
		entrant.setPhoto("1");
		
		Entrant entrant2 = new Entrant();
		entrant2.setFirstName("1");
		entrant2.setLastName("1");
		entrant2.setAge(1);
		entrant2.setContacts("1");
		entrant2.setPhoto("1");
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		
		entrant.setFaculty(faculty);
		entrant2.setFaculty(faculty);
		entrantRepository.saveAll(Arrays.asList(entrant, entrant2));
		
		entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(2));
		
		assertTrue(entrants.get(0).getFirstName().equals(entrant.getFirstName()));
		assertTrue(entrants.get(0).getLastName().equals(entrant.getLastName()));
		assertTrue(entrants.get(0).getAge()==entrant.getAge());
		assertTrue(entrants.get(0).getContacts().equals(entrant.getContacts()));
		assertTrue(entrants.get(0).getFaculty().equals(entrant.getFaculty()));
		assertTrue(entrants.get(0).getPhoto().equals(entrant.getPhoto()));
		
		assertTrue(entrants.get(1).getFirstName().equals(entrant2.getFirstName()));
		assertTrue(entrants.get(1).getLastName().equals(entrant2.getLastName()));
		assertTrue(entrants.get(1).getAge()==entrant2.getAge());
		assertTrue(entrants.get(1).getContacts().equals(entrant2.getContacts()));
		assertTrue(entrants.get(1).getFaculty().equals(entrant2.getFaculty()));
		assertTrue(entrants.get(1).getPhoto().equals(entrant2.getPhoto()));
	}
	
	@Test
	public void testFindEntrantById() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));
		
		Entrant entrant = new Entrant();
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setAge(1);
		entrant.setContacts("1");
		entrant.setPhoto("1");
		
		entrantService.save(entrant);
		
		entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(1));
		
		Entrant entrantFromDb = entrantService.findById(entrants.get(0).getId());
		assertTrue(entrantFromDb.getFirstName().equals(entrant.getFirstName()));
		assertTrue(entrantFromDb.getLastName().equals(entrant.getLastName()));
		assertTrue(entrantFromDb.getAge()==entrant.getAge());
		assertTrue(entrantFromDb.getContacts().equals(entrant.getContacts()));
		assertTrue(entrantFromDb.getFaculty().equals(entrant.getFaculty()));
		assertTrue(entrantFromDb.getPhoto().equals(entrant.getPhoto()));
	}
	
	@Test
	public void testSaveFaculty() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		
		Map<Subject, Integer> subjects = new HashMap<Subject, Integer>();
		subjects.put(Subject.PHYSICS, 70);
		subjects.put(Subject.CERTIFICATE, 60);
		
		faculty.setSubjectsMap(subjects);
		
		facultyService.save(faculty);
		
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));
		
		Faculty facultyFromDb = faculties.get(0);
		assertTrue(facultyFromDb.getName().equals(faculty.getName()));
		assertTrue(facultyFromDb.getRecruitmentPlan()==faculty.getRecruitmentPlan());
		assertTrue(facultyFromDb.getSubjectsMap().equals(faculty.getSubjectsMap()));
	}
	
	@Test
	public void testGetAllFaculties() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		
		Map<Subject, Integer> subjects = new HashMap<Subject, Integer>();
		subjects.put(Subject.PHYSICS, 70);
		subjects.put(Subject.CERTIFICATE, 60);
		
		faculty.setSubjectsMap(subjects);
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("2-nd");
		faculty2.setRecruitmentPlan(30);
		
		Map<Subject, Integer> subjects2 = new HashMap<Subject, Integer>();
		subjects2.put(Subject.PHYSICS, 70);
		subjects2.put(Subject.CERTIFICATE, 60);
		
		faculty2.setSubjectsMap(subjects2);
		
		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));
		
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(2));
		
		assertTrue(faculties.get(0).getName().equals(faculty.getName()));
		assertTrue(faculties.get(0).getRecruitmentPlan()==faculty.getRecruitmentPlan());
		assertTrue(faculties.get(0).getSubjectsMap().equals(faculty.getSubjectsMap()));
		
		assertTrue(faculties.get(1).getName().equals(faculty2.getName()));
		assertTrue(faculties.get(1).getRecruitmentPlan()==faculty2.getRecruitmentPlan());
		assertTrue(faculties.get(1).getSubjectsMap().equals(faculty2.getSubjectsMap()));
	}
	
	@Test
	public void testFindFacultyByName() {
		
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		
		Map<Subject, Integer> subjects = new HashMap<Subject, Integer>();
		subjects.put(Subject.PHYSICS, 70);
		subjects.put(Subject.CERTIFICATE, 60);
		
		faculty.setSubjectsMap(subjects);
		
		facultyRepository.save(faculty);
		
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));		
		
		Faculty facultyFromDb = facultyService.findByName(faculty.getName());
		assertTrue(facultyFromDb.getName().equals(faculty.getName()));
		assertTrue(facultyFromDb.getRecruitmentPlan()==faculty.getRecruitmentPlan());
		assertTrue(facultyFromDb.getSubjectsMap().equals(faculty.getSubjectsMap()));
	}
	
	@Test
	public void testGetAllEntrantRegisters() {
		List<EntrantRegister> entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(0));
		
		//entrantRegister 1
		EntrantRegister entrantRegister = new EntrantRegister();
		
		User user = new User();
		user.setLogin("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(Role.ROLE_ENTRANT);
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		Map<Subject, Integer> subjects = new HashMap<Subject, Integer>();
		subjects.put(Subject.PHYSICS, 70);
		subjects.put(Subject.CERTIFICATE, 60);		
		faculty.setSubjectsMap(subjects);
		
		Entrant entrant = new Entrant();
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setAge(1);
		entrant.setContacts("1");
		entrant.setPhoto("1");		
		entrant.setFaculty(faculty);
		entrant.setUser(user);
		
		entrantRegister.setEntrant(entrant);		
		entrantRegister.setFaculty(faculty);
		entrantRegister.setUser(user);
		
		//entrantRegister 2
		EntrantRegister entrantRegister2 = new EntrantRegister();
		
		User user2 = new User();
		user2.setLogin("2");
		user2.setPassword("2");
		user2.setPasswordConfirm("2");
		user2.setRole(Role.ROLE_ENTRANT);
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("2-nd");
		faculty2.setRecruitmentPlan(50);
		Map<Subject, Integer> subjects2 = new HashMap<Subject, Integer>();
		subjects2.put(Subject.MATHEMATICS, 65);
		subjects2.put(Subject.CERTIFICATE, 70);		
		faculty2.setSubjectsMap(subjects2);
		
		Entrant entrant2 = new Entrant();
		entrant2.setFirstName("2");
		entrant2.setLastName("2");
		entrant2.setAge(2);
		entrant2.setContacts("2");
		entrant2.setPhoto("2");		
		entrant2.setFaculty(faculty2);
		entrant2.setUser(user2);
		
		entrantRegister2.setEntrant(entrant2);		
		entrantRegister2.setFaculty(faculty2);
		entrantRegister2.setUser(user2);
		
		entrantRegisterRepository.saveAll(Arrays.asList(entrantRegister, entrantRegister2));
		
		entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(2));
		
	}

	public void testDeleteEntrantRegister() {
		List<EntrantRegister> entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(0));
		
		//entrantRegister 1
		EntrantRegister entrantRegister = new EntrantRegister();
		
		User user = new User();
		user.setLogin("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(Role.ROLE_ENTRANT);
		userService.save(user);
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		Map<Subject, Integer> subjects = new HashMap<Subject, Integer>();
		subjects.put(Subject.PHYSICS, 70);
		subjects.put(Subject.CERTIFICATE, 60);		
		faculty.setSubjectsMap(subjects);
		facultyService.save(faculty);
		
		Entrant entrant = new Entrant();
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setAge(1);
		entrant.setContacts("1");
		entrant.setPhoto("1");		
		entrant.setFaculty(faculty);
		entrant.setUser(user);
		entrantService.save(entrant);
		
		entrantRegister.setEntrant(entrant);		
		entrantRegister.setFaculty(faculty);
		entrantRegister.setUser(user);
		
		//entrantRegister 2
		EntrantRegister entrantRegister2 = new EntrantRegister();
		
		User user2 = new User();
		user2.setLogin("2");
		user2.setPassword("2");
		user2.setPasswordConfirm("2");
		user2.setRole(Role.ROLE_ENTRANT);
		userService.save(user2);
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("2-nd");
		faculty2.setRecruitmentPlan(50);
		Map<Subject, Integer> subjects2 = new HashMap<Subject, Integer>();
		subjects2.put(Subject.MATHEMATICS, 65);
		subjects2.put(Subject.CERTIFICATE, 70);		
		faculty2.setSubjectsMap(subjects2);
		facultyService.save(faculty2);
		
		Entrant entrant2 = new Entrant();
		entrant2.setFirstName("2");
		entrant2.setLastName("2");
		entrant2.setAge(2);
		entrant2.setContacts("2");
		entrant2.setPhoto("2");		
		entrant2.setFaculty(faculty2);
		entrant2.setUser(user2);
		entrantService.save(entrant2);
		
		entrantRegister2.setEntrant(entrant2);		
		entrantRegister2.setFaculty(faculty2);
		entrantRegister2.setUser(user2);
		
		entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(0));
		
		entrantRegisterRepository.saveAll(Arrays.asList(entrantRegister, entrantRegister2));
		
		entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(2));
		
		entrantRegisterService.delete(entrantRegisters.get(0));
		
		entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(1));		
		
	}

	public void testAddEntrantRegister() {
		List<EntrantRegister> entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(0));
		
		EntrantRegister entrantRegister = new EntrantRegister();
		
		User user = new User();
		user.setLogin("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(Role.ROLE_ENTRANT);
		userService.save(user);
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		Map<Subject, Integer> subjects = new HashMap<Subject, Integer>();
		subjects.put(Subject.PHYSICS, 70);
		subjects.put(Subject.CERTIFICATE, 60);		
		faculty.setSubjectsMap(subjects);
		facultyService.save(faculty);
		
		Entrant entrant = new Entrant();
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setAge(1);
		entrant.setContacts("1");
		entrant.setPhoto("1");		
		entrant.setFaculty(faculty);
		entrant.setUser(user);
		entrantService.save(entrant);
		
		entrantRegister.setEntrant(entrant);		
		entrantRegister.setFaculty(faculty);
		entrantRegister.setUser(user);
		
		entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(1));
		
		EntrantRegister entrantRegisterFromDb = entrantRegisters.get(0);
				
		Integer userId = entrantRegisterFromDb.getUser().getId();
		User userFromEntrantRegister = entrantRegister.getUser();
		userFromEntrantRegister.setId(userId);
		entrantRegister.setUser(userFromEntrantRegister);
		
		Integer entrantId = entrantRegisterFromDb.getEntrant().getId();
		Entrant entrantFromEntrantRegister = entrantRegister.getEntrant();
		entrantFromEntrantRegister.setId(entrantId);
		entrantRegister.setEntrant(entrantFromEntrantRegister);
		
		Integer facultyId = entrantRegisterFromDb.getFaculty().getId();
		Faculty facultyFromEntrantRegister = entrantRegister.getFaculty();
		facultyFromEntrantRegister.setId(facultyId);
		entrantRegister.setFaculty(facultyFromEntrantRegister);
		
		assertTrue(entrantRegisterFromDb.getUser().equals(entrantRegister.getUser()));
		assertTrue(entrantRegisterFromDb.getEntrant().equals(entrantRegister.getEntrant()));
		assertTrue(entrantRegisterFromDb.getFaculty().equals(entrantRegister.getFaculty()));
		
	}
	
	@Test
	public void testFindEntrantRegisterByEntrantId() {
		List<EntrantRegister> entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(0));
		
		EntrantRegister entrantRegister = new EntrantRegister();
		
		User user = new User();
		user.setLogin("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(Role.ROLE_ENTRANT);
		userService.save(user);
		
		Faculty faculty = new Faculty();
		faculty.setName("1-st");
		faculty.setRecruitmentPlan(50);
		Map<Subject, Integer> subjects = new HashMap<Subject, Integer>();
		subjects.put(Subject.PHYSICS, 70);
		subjects.put(Subject.CERTIFICATE, 60);		
		faculty.setSubjectsMap(subjects);
		facultyService.save(faculty);
		
		Entrant entrant = new Entrant();
		entrant.setFirstName("1");
		entrant.setLastName("1");
		entrant.setAge(1);
		entrant.setContacts("1");
		entrant.setPhoto("1");		
		entrant.setFaculty(faculty);
		entrant.setUser(user);
		entrantService.save(entrant);
		
		entrantRegister.setEntrant(entrant);		
		entrantRegister.setFaculty(faculty);
		entrantRegister.setUser(user);
		
		entrantRegisters = entrantRegisterRepository.findAll();
		assertThat(entrantRegisters, hasSize(1));		
		
		EntrantRegister entrantRegisterFromDb = entrantRegisterService.findByEntrantId(entrantRegisters.get(0).getEntrant().getId());
		
		Integer userId = entrantRegisterFromDb.getUser().getId();
		User userFromEntrantRegister = entrantRegister.getUser();
		userFromEntrantRegister.setId(userId);
		entrantRegister.setUser(userFromEntrantRegister);
		
		Integer entrantId = entrantRegisterFromDb.getEntrant().getId();
		Entrant entrantFromEntrantRegister = entrantRegister.getEntrant();
		entrantFromEntrantRegister.setId(entrantId);
		entrantRegister.setEntrant(entrantFromEntrantRegister);
		
		Integer facultyId = entrantRegisterFromDb.getFaculty().getId();
		Faculty facultyFromEntrantRegister = entrantRegister.getFaculty();
		facultyFromEntrantRegister.setId(facultyId);
		entrantRegister.setFaculty(facultyFromEntrantRegister);
		
		assertTrue(entrantRegisterFromDb.getUser().equals(entrantRegister.getUser()));
		assertTrue(entrantRegisterFromDb.getEntrant().equals(entrantRegister.getEntrant()));
		assertTrue(entrantRegisterFromDb.getFaculty().equals(entrantRegister.getFaculty()));
	}
}