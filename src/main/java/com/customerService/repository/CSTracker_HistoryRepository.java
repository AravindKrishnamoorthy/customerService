package com.customerService.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.customerService.entity.CSTracker_History;

public interface CSTracker_HistoryRepository extends CrudRepository<CSTracker_History, Long>{

//	@Query(nativeQuery = true, value= "SELECT DISTINCT reference_number, articleID, status, statusCode, statusTimestamp, courierEvents, barcodelabelNumber, airwayBill, user_Id, broker_Name, service_Type, carrier, created_Timestamp, Updated_Timestamp, location FROM CSTracker_History t where t.reference_number = :reference_number order by t.Updated_Timestamp desc ")  
//	List<CSTracker_History> fetchCSTrackHistoryDetails(@Param("reference_number") String reference_number);
	
	@Query(nativeQuery = true, value= "SELECT DISTINCT reference_number, articleID, status, status_Timestamp, statusCode, courierEvents, " +
			" Updated_Timestamp, location, handling, comments, created_Timestamp, null as broker_Name, null as dateAllocated, null as carrier,"
			+ "null as systemStatus FROM CSTracker_History t where t.reference_number = :reference_number order by t.Updated_Timestamp desc ")
	List<Object[]> fetchCSTrackHistoryDetails(@Param("reference_number") String reference_number);


	@Query(nativeQuery = true, value= " \tSELECT * FROM\n" +
			"\t(\n" +
			"\tSELECT b.reference_number, b.articleID, b.status, b.status_Timestamp, b.statusCode, b.courierEvents, \n" +
			"\tb.Updated_Timestamp, b.location, b.handling, b.comments, b.created_Timestamp, a.broker_Name, a.dateAllocated, a.carrier, a.systemStatus, \n" +
			"\tROW_NUMBER() OVER (PARTITION BY b.reference_number ORDER BY b.Updated_Timestamp DESC) AS RN\n" +
			"\tFROM \n" +
			"\tCSTracker as a\n" +
			"\tINNER JOIN\n" +
			"\tCSTracker_History  as b\n" +
			"\ton a.reference_number = b.reference_number\n" +
			"\twhere\n" +
			"\ta.systemStatus = :status\n" +
			"\t) sub_select \n" +
			"\tWHERE RN = 1 order by Updated_Timestamp desc; ")
	List<Object[]> fetchCSTrackHistoryStatusDetails(@Param("status") String status);

}
