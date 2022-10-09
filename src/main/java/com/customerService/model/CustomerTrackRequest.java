package com.customerService.model;

public class CustomerTrackRequest {
	
	private String action;
	private String reference_number;
	private String airwayBill;
	private String articleID;
	private String barcodelabelNumber;
	private String broker_Name;
	private String carrier;
	private String systemStatus;
	private String created_Timestamp;
	private String service_type;
	private String user_id;
	private String handling;
	private String comments;
	private String status_Timestamp;
	private Boolean statusUpdateFlag;
	private Boolean handlingUpdateFlag;
	private Boolean commentsUpdateFlag;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getReference_number() {
		return reference_number;
	}
	public void setReference_number(String reference_number) {
		this.reference_number = reference_number;
	}
	public String getAirwayBill() {
		return airwayBill;
	}
	public void setAirwayBill(String airwayBill) {
		this.airwayBill = airwayBill;
	}
	public String getArticleID() {
		return articleID;
	}
	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}
	public String getBarcodelabelNumber() {
		return barcodelabelNumber;
	}
	public void setBarcodelabelNumber(String barcodelabelNumber) {
		this.barcodelabelNumber = barcodelabelNumber;
	}
	public String getBroker_Name() {
		return broker_Name;
	}
	public void setBroker_Name(String broker_Name) {
		this.broker_Name = broker_Name;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getCreated_Timestamp() {
		return created_Timestamp;
	}
	public void setCreated_Timestamp(String created_Timestamp) {
		this.created_Timestamp = created_Timestamp;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHandling() {
		return handling;
	}
	public void setHandling(String handling) {
		this.handling = handling;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStatus_Timestamp() {
		return status_Timestamp;
	}
	public void setStatus_Timestamp(String status_Timestamp) {
		this.status_Timestamp = status_Timestamp;
	}
	public String getSystemStatus() {
		return systemStatus;
	}
	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}
	public Boolean getStatusUpdateFlag() {
		return statusUpdateFlag;
	}
	public void setStatusUpdateFlag(Boolean statusUpdateFlag) {
		this.statusUpdateFlag = statusUpdateFlag;
	}
	public Boolean getHandlingUpdateFlag() {
		return handlingUpdateFlag;
	}
	public void setHandlingUpdateFlag(Boolean handlingUpdateFlag) {
		this.handlingUpdateFlag = handlingUpdateFlag;
	}
	public Boolean getCommentsUpdateFlag() {
		return commentsUpdateFlag;
	}
	public void setCommentsUpdateFlag(Boolean commentsUpdateFlag) {
		this.commentsUpdateFlag = commentsUpdateFlag;
	}
	
}
