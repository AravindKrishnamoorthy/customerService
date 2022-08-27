package com.customerService.dao;

import java.util.List;
import com.customerService.entity.CSTracker;
import com.customerService.entity.CSusers;
import com.customerService.model.CSHistory;
import com.customerService.model.CustomerTrackRequest;
import com.customerService.model.UserMessage;

public interface ICSSystemDao {
	
	public CSusers login(String userName, String passWord);

	public List<String> fetchServiceType(Integer user_id);

	public List<CSTracker> csDetails(String status, String reference_number, String brokerName);

	public UserMessage csStatusUpdate(List<CustomerTrackRequest> orderDetailList);

	public List<CSHistory> csDetailsHist(String reference_number);

	public List<CSHistory> csDetailsStatusList(String status, String reference_number, String brokerName);
}
