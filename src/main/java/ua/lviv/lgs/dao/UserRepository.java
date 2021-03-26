package ua.lviv.lgs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.lgs.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByLogin(String login);
	
}
