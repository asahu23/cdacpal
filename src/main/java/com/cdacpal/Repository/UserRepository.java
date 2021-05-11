package com.cdacpal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdacpal.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	public User findByLoginid(String loginid);
	
	
	
	
	
}
