package com.customerService.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customerService.dao.ICSSystemDao;
import com.customerService.entity.CSTracker;
import com.customerService.entity.CSTracker_History;
import com.customerService.entity.User;
import com.customerService.model.CSHistory;
import com.customerService.model.CustomerTrackRequest;
import com.customerService.model.UserDetails;
import com.customerService.model.UserMessage;
import com.customerService.model.UsersData;
import com.customerService.service.ICSSystemService;

@Service
public class CSSystemServiceImpl implements ICSSystemService{
	
	@Autowired
	private ICSSystemDao csDao;

	@Override
	public List<UsersData> login(String userName, String passWord) {
		List<UsersData> userData = csDao.login(userName, passWord);
//		UserDetails userDetails = new UserDetails();
//		userDetails.setAddress(userData.getAddress());
//		userDetails.setCompanyName(userData.getCompanyName());
//		userDetails.setContactName(userData.getName());
//		userDetails.setContactPhoneNumber(userData.getPhoneNumber());
//		userDetails.setCountry(userData.getCountry());
//		userDetails.setEmailAddress(userData.getEmail());
//		userDetails.setPassword(userData.getPassword_value());
//		userDetails.setPostCode(userData.getPostcode());
//		userDetails.setState(userData.getState());
//		userDetails.setSuburb(userData.getSuburb());
//		userDetails.setUserName(userData.getUsername());
//		userDetails.setRole_Id(userData.getRole_Id());
//		userDetails.setUser_id(userData.getUser_Id());
//		List<String> serviceTypeList = csDao.fetchServiceType(userDetails.getUser_id());
//		userDetails.setServiceType(serviceTypeList);
		return userData;
	}

	@Override
	public List<CSTracker> csDetails(String status, String reference_number) {
		List<CSTracker> csTrackerDetails = csDao.csDetails(status, reference_number);
		return csTrackerDetails;
	}

	@Override
	public UserMessage csStatusUpdate(List<CustomerTrackRequest> orderDetailList) {
		UserMessage csStatus = csDao.csStatusUpdate(orderDetailList);
		return csStatus;
	}

	@Override
	public List<CSHistory> csDetailsHist(String reference_number) {
		List<CSHistory> csTrackerDetails = csDao.csDetailsHist(reference_number);
		return csTrackerDetails;
	}

	@Override
	public List<CSHistory> csDetailsStatusList(String status, String reference_number) {
		List<CSHistory> csTrackerDetailsStatus = csDao.csDetailsStatusList(status, reference_number);
		return csTrackerDetailsStatus;
	}
}
