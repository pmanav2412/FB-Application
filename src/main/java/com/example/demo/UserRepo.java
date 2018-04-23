package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {
	public List<Users> findAll();
	List<Users> findByName(String name);
	
}

