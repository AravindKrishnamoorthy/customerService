package com.customerService.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.customerService.entity.CSusers;

public interface CSusersRepository extends CrudRepository<CSusers, Long>{

	@Query("SELECT t FROM CSusers t where t.userName = :userName and t.password = :passWord ")
	CSusers fetchUserDetails(@Param("userName") String userName, @Param("passWord") String passWord);

}
