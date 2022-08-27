package com.customerService.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customerService.dao.ICSSystemDao;
import com.customerService.entity.CSTracker;
import com.customerService.entity.CSusers;
import com.customerService.model.CSHistory;
import com.customerService.model.CustomerTrackRequest;
import com.customerService.model.UserMessage;
import com.customerService.service.ICSSystemService;

@Service
public class CSSystemServiceImpl implements ICSSystemService{
	
	@Autowired
	private ICSSystemDao csDao;

	@Override
	public CSusers login(String userName, String passWord) {
		CSusers userData = csDao.login(userName, passWord);
		return userData;
	}

	@Override
	public List<CSTracker> csDetails(String status, String reference_number, String brokerName) {
		List<CSTracker> csTrackerDetails = csDao.csDetails(status, reference_number, brokerName);
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
	public List<CSHistory> csDetailsStatusList(String status, String reference_number, String brokerName) {
		List<CSHistory> csTrackerDetailsStatus = csDao.csDetailsStatusList(status, reference_number, brokerName);
		return csTrackerDetailsStatus;
	}
}
