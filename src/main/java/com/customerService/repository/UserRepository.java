package com.customerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.customerService.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

//	 @Query("SELECT t FROM User t where t.username = :userName and password_value = :passWord")  
//	 User fetchUserDetails(@Param("userName") String userName, @Param("passWord") String passWord);
	 
	 @Query(nativeQuery = true, value= "SELECT  \r\n"
	 		+ "a.User_Id, a.Role_Id, a.Name, a.CompanyName, a.User_Name, a.password, a.Client_BrokerName, a.CSuserRoleID, b.BrokerUserName\r\n"
	 		+ "  FROM \r\n"
	 		+ "  Users as a LEFT JOIN CSuserRole as b\r\n"
	 		+ "  on a.CSuserRoleID = b.RoleId where\r\n"
	 		+ "  a.User_Name = :userName and a.password = :passWord ")
	 List<Object[]> fetchUserDetails(@Param("userName") String userName, @Param("passWord") String passWord);


	 @Query("SELECT t FROM User t where t.user_Id = :user_Id")  
	 User fetchUserDetailsUsingUserId();

}
