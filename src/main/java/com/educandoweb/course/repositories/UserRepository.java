package com.educandoweb.course.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> { // Repository é sempre interface
	
	Optional<User> findByEmail(String email);

}
