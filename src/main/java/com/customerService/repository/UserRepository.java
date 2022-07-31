package com.customerService.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.customerService.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	 @Query("SELECT t FROM User t where t.username = :userName and password_value = :passWord")  
	 User fetchUserDetails(@Param("userName") String userName, @Param("passWord") String passWord);

	 @Query("SELECT t FROM User t where t.user_Id = :user_Id")  
	 User fetchUserDetailsUsingUserId();

}
