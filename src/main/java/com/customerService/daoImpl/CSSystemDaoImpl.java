package com.customerService.daoImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.customerService.dao.ICSSystemDao;
import com.customerService.entity.CSTracker;
import com.customerService.entity.CSTracker_History;
import com.customerService.entity.CSusers;
import com.customerService.model.CSHistory;
import com.customerService.model.CustomerTrackRequest;
import com.customerService.model.UserMessage;
import com.customerService.repository.CSTrackerRepository;
import com.customerService.repository.CSTracker_HistoryRepository;
import com.customerService.repository.CSusersRepository;
import com.customerService.repository.UserRepository;
import com.customerService.repository.UserServiceRepository;

@Repository
public class CSSystemDaoImpl implements ICSSystemDao{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CSusersRepository cSusersRepository;
	
	@Autowired
	UserServiceRepository userServiceRepository;
	
	@Autowired
	CSTrackerRepository csTrackerRepository;

	@Autowired
	CSTracker_HistoryRepository csTrackerHistoryRepository;
	
	public CSusers login(String userName, String passWord) {
		CSusers userDaetils = cSusersRepository.fetchUserDetails(userName, passWord);
		return userDaetils;
	}

	@Override
	public List<String> fetchServiceType(Integer user_id) {
		List<String> userServiceType = userServiceRepository.fetchUserServiceById(user_id);
		return userServiceType;
	}

	@SuppressWarnings("null")
	@Override
	public List<CSTracker> csDetails(String status, String reference_number, String brokerName) {
		List<CSTracker> csTrackerDetails = null;
		List<CSTracker> csTrackerDetailsNew = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		User userDaetils = userRepository.fetchUserDetailsUsingUserId();
		String[] reference_numbers = Arrays.stream(reference_number.split(",")).map(String::trim).toArray(String[]::new);
		String[] brokerNames = Arrays.stream(brokerName.split(",")).map(String::trim).toArray(String[]::new);
		if(status != null && !status.isBlank()) {
			if(reference_number != null && !reference_number.isBlank()) {
				csTrackerDetails = csTrackerRepository.fetchCSTrackDetailsByStatusRefNum(status, reference_numbers, brokerNames);
			}else {
				csTrackerDetails = csTrackerRepository.fetchCSTrackDetailsByStatus(status, brokerNames);
			}
			csTrackerDetailsNew = new ArrayList<CSTracker>();
			for(CSTracker csTracker:csTrackerDetails) {
				CSTracker csTrack = new CSTracker();
				csTrack.setReference_number(csTracker.getReference_number());
				csTrack.setBarcodelabelNumber(csTracker.getBarcodelabelNumber());
				csTrack.setArticleID(csTracker.getArticleID());
				csTrack.setAirwayBill(csTracker.getAirwayBill());
				csTrack.setUser_Id(csTracker.getUser_Id());
				csTrack.setBroker_Name(csTracker.getBroker_Name());
				csTrack.setService_Type(csTracker.getService_Type());
				csTrack.setCarrier(csTracker.getCarrier());
				csTrack.setStatus(csTracker.getStatus());
				csTrack.setCreated_Timestamp(csTracker.getCreated_Timestamp());
				csTrack.setUpdated_Timestamp(csTracker.getUpdated_Timestamp());
				csTrack.setHandling(csTracker.getHandling());
				csTrack.setComments(csTracker.getComments());
				csTrack.setReceiverName(csTracker.getReceiverName());
				csTrack.setReceiverAddress(csTracker.getReceiverAddress());
				csTrack.setPhoneNumber(csTracker.getPhoneNumber());
				csTrack.setSuburb(csTracker.getSuburb());
				csTrack.setState(csTracker.getState());
				csTrack.setPostcode(csTracker.getPostcode());
				csTrack.setDateAllocated(csTracker.getDateAllocated());
				csTrack.setStatus_Timestamp(csTracker.getStatus_Timestamp());
				csTrack.setSystemStatus(csTracker.getSystemStatus());
				if(csTracker.getBroker_Name().equalsIgnoreCase("FDMB")) {
					Integer fdmEta = getFDMMappingDetails(csTracker.getCarrier());
					if(csTracker.getDateAllocated() != null && fdmEta != null) {
						LocalDate dateVal = LocalDate.parse(csTracker.getDateAllocated().split(" ")[0]);
						LocalDate dateInc = dateVal.plusDays(fdmEta);
						csTrack.setEta(dateInc.toString()+ " "+ csTracker.getDateAllocated().split(" ")[1]);
					}
				}else if(csTracker.getBroker_Name().equalsIgnoreCase("5ULB") || csTracker.getBroker_Name().equalsIgnoreCase("EQB")) {
					if(csTracker.getCarrier().equalsIgnoreCase("eParcel") || csTracker.getCarrier().equalsIgnoreCase("eParcelPOBOX")) {
						Integer postEta = get5ULPostExMappingDetails(csTracker.getPostZone());
						if(csTracker.getDateAllocated() != null && postEta != null) {
							LocalDate dateVal = LocalDate.parse(csTracker.getDateAllocated().split(" ")[0]);
							LocalDate dateInc = dateVal.plusDays(postEta);
							csTrack.setEta(dateInc.toString()+ " "+ csTracker.getDateAllocated().split(" ")[1]);
						}
					}else if(csTracker.getCarrier().equalsIgnoreCase("Fastway")) {
						Integer fwEta = get5ULFastwayExMappingDetails(csTracker.getPostZone());
						if(csTracker.getDateAllocated() != null && fwEta != null) {
							LocalDate dateVal = LocalDate.parse(csTracker.getDateAllocated().split(" ")[0]);
							LocalDate dateInc = dateVal.plusDays(fwEta);
							csTrack.setEta(dateInc.toString()+ " "+ csTracker.getDateAllocated().split(" ")[1]);
						}
					}else if(csTracker.getCarrier().equalsIgnoreCase("NEX") || csTracker.getCarrier().equalsIgnoreCase("NEXFastway")) {
						Integer pflEta = get5ULPflExMappingDetails(csTracker.getPostZone());
						if(csTracker.getDateAllocated() != null && pflEta != null) {
							LocalDate dateVal = LocalDate.parse(csTracker.getDateAllocated().split(" ")[0]);
							LocalDate dateInc = dateVal.plusDays(pflEta);
							csTrack.setEta(dateInc.toString()+ " "+ csTracker.getDateAllocated().split(" ")[1]);
						}
					}
				}
				csTrackerDetailsNew.add(csTrack);
			}
		}else {
			if(reference_number != null && !reference_number.isBlank()) {
				csTrackerDetails = csTrackerRepository.fetchCSTrackDetailsByRefNum(reference_numbers, brokerNames);
			}else {
				csTrackerDetails = csTrackerRepository.fetchCSTrackDetails(brokerNames);
			}
			csTrackerDetailsNew = new ArrayList<CSTracker>();
			for(CSTracker csTracker:csTrackerDetails) {
				CSTracker csTrack = new CSTracker();
				csTrack.setReference_number(csTracker.getReference_number());
				csTrack.setBarcodelabelNumber(csTracker.getBarcodelabelNumber());
				csTrack.setArticleID(csTracker.getArticleID());
				csTrack.setAirwayBill(csTracker.getAirwayBill());
				csTrack.setUser_Id(csTracker.getUser_Id());
				csTrack.setBroker_Name(csTracker.getBroker_Name());
				csTrack.setService_Type(csTracker.getService_Type());
				csTrack.setCarrier(csTracker.getCarrier());
				csTrack.setStatus(csTracker.getStatus());
				csTrack.setCreated_Timestamp(csTracker.getCreated_Timestamp());
				csTrack.setUpdated_Timestamp(csTracker.getUpdated_Timestamp());
				csTrack.setHandling(csTracker.getHandling());
				csTrack.setComments(csTracker.getComments());
				csTrack.setReceiverName(csTracker.getReceiverName());
				csTrack.setReceiverAddress(csTracker.getReceiverAddress());
				csTrack.setPhoneNumber(csTracker.getPhoneNumber());
				csTrack.setSuburb(csTracker.getSuburb());
				csTrack.setState(csTracker.getState());
				csTrack.setPostcode(csTracker.getPostcode());
				csTrack.setDateAllocated(csTracker.getDateAllocated());
				csTrack.setStatus_Timestamp(csTracker.getStatus_Timestamp());
				csTrack.setSystemStatus(csTracker.getSystemStatus());
				if(csTracker.getBroker_Name().equalsIgnoreCase("FDMB")) {
					Integer fdmEta = getFDMMappingDetails(csTracker.getCarrier());
					if(csTracker.getDateAllocated() != null && fdmEta != null) {
						LocalDate dateVal = LocalDate.parse(csTracker.getDateAllocated().split(" ")[0]);
						LocalDate dateInc = dateVal.plusDays(fdmEta);
						csTrack.setEta(dateInc.toString()+ " "+ csTracker.getDateAllocated().split(" ")[1]);
					}
				}else if(csTracker.getBroker_Name().equalsIgnoreCase("5ULB") || csTracker.getBroker_Name().equalsIgnoreCase("EQB")) {
					if(csTracker.getCarrier().equalsIgnoreCase("eParcel") || csTracker.getCarrier().equalsIgnoreCase("eParcelPOBOX")) {
						Integer postEta = get5ULPostExMappingDetails(csTracker.getPostZone());
						if(csTracker.getDateAllocated() != null && postEta != null) {
							LocalDate dateVal = LocalDate.parse(csTracker.getDateAllocated().split(" ")[0]);
							LocalDate dateInc = dateVal.plusDays(postEta);
							csTrack.setEta(dateInc.toString()+ " "+ csTracker.getDateAllocated().split(" ")[1]);
						}
					}else if(csTracker.getCarrier().equalsIgnoreCase("Fastway")) {
						Integer fwEta = get5ULFastwayExMappingDetails(csTracker.getPostZone());
						if(csTracker.getDateAllocated() != null && fwEta != null) {
							LocalDate dateVal = LocalDate.parse(csTracker.getDateAllocated().split(" ")[0]);
							LocalDate dateInc = dateVal.plusDays(fwEta);
							csTrack.setEta(dateInc.toString()+ " "+ csTracker.getDateAllocated().split(" ")[1]);
						}
					}else if(csTracker.getCarrier().equalsIgnoreCase("NEX") || csTracker.getCarrier().equalsIgnoreCase("NEXFastway")) {
						Integer pflEta = get5ULPflExMappingDetails(csTracker.getPostZone());
						if(csTracker.getDateAllocated() != null && pflEta != null) {
							LocalDate dateVal = LocalDate.parse(csTracker.getDateAllocated().split(" ")[0]);
							LocalDate dateInc = dateVal.plusDays(pflEta);
							csTrack.setEta(dateInc.toString()+ " "+ csTracker.getDateAllocated().split(" ")[1]);
						}
					}
				}
				csTrackerDetailsNew.add(csTrack);
			}
		}
		return csTrackerDetailsNew;
	}

	@Override
	public UserMessage csStatusUpdate(List<CustomerTrackRequest> orderDetailList) {
		UserMessage usrMsg = new UserMessage();
		Date dt = new Date();
		List<CSTracker_History> csHistList = new ArrayList<CSTracker_History>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		
		for(CustomerTrackRequest orderDetail:orderDetailList) {
			if(orderDetail.getComments() != null)
				csTrackerRepository.updateTicketComments(orderDetail.getReference_number(), orderDetail.getAction(), sdf.format(dt), orderDetail.getHandling(), orderDetail.getComments() );
			else
				csTrackerRepository.updateTicketInfo(orderDetail.getReference_number(), orderDetail.getAction(), sdf.format(new Date()), orderDetail.getHandling());
		}
		usrMsg.setMessage("Ticket Status Updated Successfully");
		
		for(CustomerTrackRequest orderDetailHist:orderDetailList) {
			CSTracker_History csHistObj = new CSTracker_History();
			csHistObj.setReference_number(orderDetailHist.getReference_number());
			csHistObj.setArticleID(orderDetailHist.getArticleID());
			
			if(orderDetailHist.getStatusUpdateFlag()) {
				csHistObj.setStatus("Moved");
				csHistObj.setSystemStatus(orderDetailHist.getAction());
			}else if(orderDetailHist.getCommentsUpdateFlag() || orderDetailHist.getHandlingUpdateFlag()) {
				csHistObj.setStatus(orderDetailHist.getSystemStatus());
				csHistObj.setSystemStatus(orderDetailHist.getSystemStatus());
			}
			
			if(orderDetailHist.getStatusUpdateFlag()) {
				csHistObj.setCourierEvents("Moved from "+ orderDetailHist.getSystemStatus() + " to "+ orderDetailHist.getAction());
			}else if(orderDetailHist.getCommentsUpdateFlag()) {
				csHistObj.setCourierEvents("Comments Added");
			}else if(orderDetailHist.getHandlingUpdateFlag()) {
				csHistObj.setCourierEvents("Handling changed");
			}
			csHistObj.setStatusCode(null);
			csHistObj.setStatus_Timestamp(orderDetailHist.getStatus_Timestamp());
			csHistObj.setUpdated_Timestamp(sdf.format(new Date()));
			csHistObj.setLocation(null);
			csHistObj.setHandling(orderDetailHist.getHandling());
			csHistObj.setComments(orderDetailHist.getComments());
			csHistObj.setIsUpdated("Y");
			csHistObj.setCreated_Timestamp(orderDetailHist.getCreated_Timestamp());
			csHistList.add(csHistObj);
		}
		csTrackerHistoryRepository.saveAll(csHistList);
		return usrMsg;
	}

	@Override
	public List<CSHistory> csDetailsHist(String reference_number) {
		List<CSHistory> csHistoryData = new ArrayList<CSHistory>();
		List<Object[]> csTrackerHistDetails = csTrackerHistoryRepository.fetchCSTrackHistoryDetails(reference_number);
		csTrackerHistDetails.forEach(obj -> csHistoryData.add(new CSHistory(obj)));
		return csHistoryData;
	}

	@Override
	public List<CSHistory> csDetailsStatusList(String status, String reference_number, String brokerName) {
		List<CSHistory> csHistoryDataStatus = new ArrayList<CSHistory>();
		List<Object[]> csTrackerHistDetails = null;
		String[] reference_numbers = Arrays.stream(reference_number.split(",")).map(String::trim).toArray(String[]::new);
		String[] brokerNames = Arrays.stream(brokerName.split(",")).map(String::trim).toArray(String[]::new);
		if(reference_number != null && !reference_number.isBlank()) {
			csTrackerHistDetails = csTrackerHistoryRepository.fetchCSTrackHistoryStatusDetailsWithRefNum(status, reference_numbers, brokerNames);
		}else {
			csTrackerHistDetails = csTrackerHistoryRepository.fetchCSTrackHistoryStatusDetails(status, brokerNames);
		}
		csTrackerHistDetails.forEach(obj -> csHistoryDataStatus.add(new CSHistory(obj)));
		return csHistoryDataStatus;
	}
	
	public Integer getFDMMappingDetails(String carrier) {
		Map<String, Integer> fdmMap = new HashMap<String, Integer>();
		fdmMap.put("ALL",4);
		fdmMap.put("AUSF",1);
		fdmMap.put("BEN",4);
		fdmMap.put("CAL",4);
		fdmMap.put("D2Z",2);
		fdmMap.put("FAST VIC",3);
		fdmMap.put("FastwayM",3);
		fdmMap.put("GPC",4);
		fdmMap.put("MLD",4);
		fdmMap.put("PFL",2);
		fdmMap.put("NEX",2);
		fdmMap.put("NEXFastway",2);
		fdmMap.put("POST",6);
		fdmMap.put("eParcel",6);
		fdmMap.put("eParcelPOBOX",6);
		fdmMap.put("RPD",2);
		fdmMap.put("SEN",4);
		fdmMap.put("SWH",4);
		fdmMap.put("TOLL",6);
		fdmMap.put("YVT",4);
		return fdmMap.get(carrier);
	}
	
	public Integer get5ULPostExMappingDetails(String postZone) {
		Map<String, Integer> postExMap = new HashMap<String, Integer>();
		postExMap.put("N0", 3);
		postExMap.put("N1", 4);
		postExMap.put("GF", 4);
		postExMap.put("WG", 4);
		postExMap.put("NC", 4);
		postExMap.put("CB", 4);
		postExMap.put("N3", 4);
		postExMap.put("N4", 4);
		postExMap.put("N2", 5);
		postExMap.put("V0", 3);
		postExMap.put("V1", 5);
		postExMap.put("GL", 5);
		postExMap.put("BR", 5);
		postExMap.put("V3", 5);
		postExMap.put("V2", 6);
		postExMap.put("Q0", 3);
		postExMap.put("Q1", 5);
		postExMap.put("IP", 5);
		postExMap.put("GC", 5);
		postExMap.put("Q5", 5);
		postExMap.put("SC", 5);
		postExMap.put("Q2", 8);
		postExMap.put("Q3", 8);
		postExMap.put("Q4", 8);
		postExMap.put("S0", 4);
		postExMap.put("S1", 6);
		postExMap.put("S2", 8);
		postExMap.put("W0", 6);
		postExMap.put("W1", 8);
		postExMap.put("W2", 14);
		postExMap.put("W3", 14);
		postExMap.put("T0", 6);
		postExMap.put("T1", 8);
		postExMap.put("NT1", 10);
		postExMap.put("NT2", 14);
		postExMap.put("NF", 14);
		postExMap.put("W4", 14);
		postExMap.put("AAT", 14);
		
		return postExMap.get(postZone);
	}
	
	public Integer get5ULFastwayExMappingDetails(String postZone) {
		Map<String, Integer> fastwayExMap = new HashMap<String, Integer>();
		fastwayExMap.put("N0", 3);
		fastwayExMap.put("N1", 5);
		fastwayExMap.put("GF", 5);
		fastwayExMap.put("WG", 5);
		fastwayExMap.put("NC", 5);
		fastwayExMap.put("CB", 5);
		fastwayExMap.put("N3", 5);
		fastwayExMap.put("N4", 5);
		fastwayExMap.put("N2", 6);
		fastwayExMap.put("V0", 4);
		fastwayExMap.put("V1", 6);
		fastwayExMap.put("GL", 6);
		fastwayExMap.put("BR", 6);
		fastwayExMap.put("V3", 6);
		fastwayExMap.put("V2", 7);
		fastwayExMap.put("Q0", 4);
		fastwayExMap.put("Q1", 6);
		fastwayExMap.put("IP", 6);
		fastwayExMap.put("GC", 6);
		fastwayExMap.put("Q5", 6);
		fastwayExMap.put("SC", 6);
		fastwayExMap.put("Q2", 9);
		fastwayExMap.put("Q3", 9);
		fastwayExMap.put("Q4", 9);
		fastwayExMap.put("S0", 5);
		fastwayExMap.put("S1", 7);
		fastwayExMap.put("S2", 9);
		fastwayExMap.put("W0", 9);
		fastwayExMap.put("W1", 10);
		fastwayExMap.put("W2", 0);
		fastwayExMap.put("W3", 0);
		fastwayExMap.put("T0", 7);
		fastwayExMap.put("T1", 9);
		fastwayExMap.put("NT1", 0);
		fastwayExMap.put("NT2", 0);
		fastwayExMap.put("NF", 0);
		fastwayExMap.put("W4", 0);
		fastwayExMap.put("AAT", 0);
		
		return fastwayExMap.get(postZone);
	}

	public Integer get5ULPflExMappingDetails(String postZone) {
		Map<String, Integer> pflExMap = new HashMap<String, Integer>();
		pflExMap.put("N0", 3);
		pflExMap.put("N1", 4);
		pflExMap.put("GF", 0);
		pflExMap.put("WG", 0);
		pflExMap.put("NC", 0);
		pflExMap.put("CB", 0);
		pflExMap.put("N3", 0);
		pflExMap.put("N4", 0);
		pflExMap.put("N2", 0);
		pflExMap.put("V0", 5);
		pflExMap.put("V1", 5);
		pflExMap.put("GL", 0);
		pflExMap.put("BR", 0);
		pflExMap.put("V3", 0);
		pflExMap.put("V2", 0);
		pflExMap.put("Q0", 5);
		pflExMap.put("Q1", 5);
		pflExMap.put("IP", 0);
		pflExMap.put("GC", 0);
		pflExMap.put("Q5", 0);
		pflExMap.put("SC", 0);
		pflExMap.put("Q2", 0);
		pflExMap.put("Q3", 0);
		pflExMap.put("Q4", 0);
		pflExMap.put("S0", 6);
		pflExMap.put("S1", 6);
		pflExMap.put("S2", 0);
		pflExMap.put("W0", 0);
		pflExMap.put("W1", 0);
		pflExMap.put("W2", 0);
		pflExMap.put("W3", 0);
		pflExMap.put("T0", 0);
		pflExMap.put("T1", 0);
		pflExMap.put("NT1",0);
		pflExMap.put("NT2",0);
		pflExMap.put("NF", 0);
		pflExMap.put("W4", 0);
		pflExMap.put("AAT", 0);
		
		return pflExMap.get(postZone);
	}
	
}
