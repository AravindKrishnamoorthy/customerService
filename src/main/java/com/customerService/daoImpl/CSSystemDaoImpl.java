package com.customerService.daoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.customerService.dao.ICSSystemDao;
import com.customerService.entity.CSTracker;
import com.customerService.entity.CSTracker_History;
import com.customerService.model.CSHistory;
import com.customerService.model.CustomerTrackRequest;
import com.customerService.model.UserMessage;
import com.customerService.model.UsersData;
import com.customerService.repository.CSTrackerRepository;
import com.customerService.repository.CSTracker_HistoryRepository;
import com.customerService.repository.UserRepository;
import com.customerService.repository.UserServiceRepository;

@Repository
public class CSSystemDaoImpl implements ICSSystemDao{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServiceRepository userServiceRepository;
	
	@Autowired
	CSTrackerRepository csTrackerRepository;

	@Autowired
	CSTracker_HistoryRepository csTrackerHistoryRepository;
	
	public List<UsersData> login(String userName, String passWord) {
		List<UsersData> userData = new ArrayList<UsersData>();
		List<Object[]>  userDaetils = userRepository.fetchUserDetails(userName, passWord);
		userDaetils.forEach(obj -> userData.add(new UsersData(obj)));
		return userData;
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
//				csTrack.setBroker_Name(userDaetils.getClient_BrokerName());
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
//				csTrack.setBroker_Name(userDaetils.getClient_BrokerName());
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
			csHistObj.setStatus(orderDetailHist.getAction());
			csHistObj.setStatusCode(null);
			csHistObj.setStatus_Timestamp(orderDetailHist.getStatus_Timestamp());
			csHistObj.setCourierEvents("Comments Added");
			csHistObj.setUpdated_Timestamp(sdf.format(new Date()));
			csHistObj.setLocation(null);
			csHistObj.setHandling(orderDetailHist.getHandling());
			csHistObj.setComments(orderDetailHist.getComments());
			csHistObj.setIsUpdated(null);
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

}
