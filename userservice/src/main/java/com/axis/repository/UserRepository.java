package com.axis.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.axis.model.User;

public interface UserRepository extends MongoRepository<User, Long> {

	 User findByPhoneNumber(String phoneNumber);

	    boolean existsByPhoneNumber(String phoneNumber);
     
}
