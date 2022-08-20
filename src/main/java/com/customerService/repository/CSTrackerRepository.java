package com.customerService.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.customerService.entity.CSTracker;
import java.util.List;

public interface CSTrackerRepository extends CrudRepository<CSTracker, Long>{

//	 broker_Name in ('5ULB', 'FDMB', 'PFLB')
//	 @Query(nativeQuery = true, value="SELECT * FROM CSTracker where CAST(created_Timestamp as date) > '2022-03-31' union  SELECT * FROM CSTracker_17Events where CAST(created_Timestamp as date) > '2022-03-31' order by created_Timestamp desc ")
	 @Query("SELECT t FROM CSTracker t where t.Updated_Timestamp >= GETDATE() - 35 and broker_Name in (:brokerNames) order by t.Updated_Timestamp desc ")  
	 List<CSTracker> fetchCSTrackDetails(@Param("brokerNames") String[] brokerNames);
	 
//	 broker_Name in ('5ULB', 'FDMB', 'PFLB')
//	 @Query(nativeQuery = true, value="SELECT * FROM CSTracker where CAST(created_Timestamp as date) > '2022-03-31' union  SELECT * FROM CSTracker_17Events where CAST(created_Timestamp as date) > '2022-03-31' order by created_Timestamp desc ")
	 @Query("SELECT t FROM CSTracker t where t.Updated_Timestamp >= GETDATE() - 35 and broker_Name in (:brokerNames) and t.reference_number in (:reference_numberVal)  order by t.Updated_Timestamp desc ")  
	 List<CSTracker> fetchCSTrackDetailsByRefNum(@Param("reference_numberVal") String[] reference_numberVal, @Param("brokerNames") String[] brokerNames);

//	 broker_Name in ('5ULB', 'FDMB', 'PFLB')
	 @Query("SELECT t FROM CSTracker t where t.Updated_Timestamp >= GETDATE() - 35 and t.systemStatus = :statusVal and broker_Name in (:brokerNames) order by t.Updated_Timestamp desc ")
	 List<CSTracker> fetchCSTrackDetailsByStatus(@Param("statusVal") String statusVal, @Param("brokerNames") String[] brokerNames);
	 
//	 broker_Name in ('5ULB', 'FDMB', 'PFLB')
	 @Query("SELECT t FROM CSTracker t where t.Updated_Timestamp >= GETDATE() - 35 and t.systemStatus = :statusVal and t.reference_number in (:reference_numberVal) and broker_Name in (:brokerNames) order by t.Updated_Timestamp desc ")
	 List<CSTracker> fetchCSTrackDetailsByStatusRefNum(@Param("statusVal") String statusVal, 
			 @Param("reference_numberVal") String[] reference_numberVal, @Param("brokerNames") String[] brokerNames);

	 @Modifying
	 @Transactional
	 @Query("update CSTracker c set c.systemStatus = :action, c.Updated_Timestamp = :Updated_Timestamp, c.handling = :handling where c.reference_number = :reference_number")
	 int updateTicketInfo(@Param("reference_number") String reference_number, @Param("action") String action, 
			 @Param("Updated_Timestamp") String Updated_Timestamp, @Param("handling") String handling);

	 @Modifying
	 @Transactional
	 @Query("update CSTracker c set c.systemStatus = :action, c.Updated_Timestamp = :Updated_Timestamp, c.handling = :handling, c.comments = :comments where c.reference_number = :reference_number")
	 int updateTicketComments(@Param("reference_number") String reference_number, @Param("action") String action, 
			 @Param("Updated_Timestamp") String Updated_Timestamp, @Param("handling") String handling, @Param("comments") String comments);


}