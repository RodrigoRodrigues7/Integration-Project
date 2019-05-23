package com.rodrigo.integration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.integration.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
