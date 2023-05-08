package com.jd_sanchez.frisbeefriendsservice;

import org.springframework.data.repository.CrudRepository;

import com.jd_sanchez.frisbeefriendsservice.entities.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}