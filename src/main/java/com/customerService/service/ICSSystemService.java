package com.customerService.service;

import java.util.List;
import com.customerService.entity.CSTracker;
import com.customerService.model.CSHistory;
import com.customerService.model.CustomerTrackRequest;
import com.customerService.model.UserDetails;
import com.customerService.model.UserMessage;
import com.customerService.model.UsersData;

public interface ICSSystemService {
	
	public List<UsersData> login(String userName, String passWord);

	public List<CSTracker> csDetails(String status, String reference_number);

	public UserMessage csStatusUpdate(List<CustomerTrackRequest> orderDetailList);

	public List<CSHistory> csDetailsHist(String reference_number);

	public List<CSHistory> csDetailsStatusList(String status, String reference_number);

}
