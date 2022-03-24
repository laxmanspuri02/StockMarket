package com.wipro.bankofamerica.estore.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bankofamerica.estore.model.User;
/**
 * @author Jeevan
 */
@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {

	public User findByUsername(String username);
	//custom query in project
	@Query(value="select * from user c where city=?1", nativeQuery =true)
	List<User> findByCity(String city);

}
