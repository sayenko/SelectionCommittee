package ua.lviv.lgs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Role;
import ua.lviv.lgs.domain.User;

@Service
public class UserService{
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
    	logger.info("Register new user {}: " + user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(Role.ROLE_ENTRANT);
        userRepository.save(user);
    }

    public User findByLogin(String login) {
    	logger.info("Get user {} by login: " + login);
    	return userRepository.findByLogin(login).get();
    }
    
}