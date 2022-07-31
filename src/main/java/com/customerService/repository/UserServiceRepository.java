package com.customerService.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.customerService.entity.UserService;

public interface UserServiceRepository extends CrudRepository<UserService, Long>{

	@Query("Select t.serviceType from UserService t where t.userId = :user_Id and t.service_isDeleted = 0") 
	List<String> fetchUserServiceById(@Param("user_Id") Integer user_Id);
	
}
