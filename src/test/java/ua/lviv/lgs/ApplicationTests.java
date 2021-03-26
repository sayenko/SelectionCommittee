package ua.lviv.lgs;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.EntrantRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Entrant;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.EntrantService;
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
	private UserService userService;
	
	@Autowired
	private EntrantService entrantService;
	
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
	public void testFindByLogin() {
		
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
		
		
		
	}
	
	@Test
	public void testSaveEntrant() {
		List<Entrant> entrants = entrantRepository.findAll();
		assertThat(entrants, hasSize(0));
	}
	
	
}