package com.customerService.model;

/**
 * @author Rafik
 *
 */
public class CSHistory {
	
	private String reference_number;
	private String articleID;
	private String status;
	private String status_Timestamp;
	private String statusCode;
	private String courierEvents;
	private String Updated_Timestamp;
	private String location;
	private String handling;
	private String comments;
	private String created_Timestamp;
	private String broker_Name;
	private String dateAllocated;
	private String carrier;
	private String systemStatus;
	
	public CSHistory(Object[] obj) {
		reference_number = (String)obj[0];
		articleID = (String)obj[1];
		status = (String)obj[2];
		status_Timestamp = (String)obj[3];
		statusCode = (String)obj[4];
		courierEvents = (String)obj[5];
		Updated_Timestamp = (String)obj[6];
		location = (String)obj[7];
		handling = (String)obj[8];
		comments = (String)obj[9];
		created_Timestamp = (String)obj[10];
		broker_Name = (String)obj[11];
		dateAllocated = (String)obj[12];
		carrier = (String)obj[13];
		systemStatus = (String)obj[14];
	}

	public String getReference_number() {
		return reference_number;
	}

	public void setReference_number(String reference_number) {
		this.reference_number = reference_number;
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_Timestamp() {
		return status_Timestamp;
	}

	public void setStatus_Timestamp(String status_Timestamp) {
		this.status_Timestamp = status_Timestamp;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getCourierEvents() {
		return courierEvents;
	}

	public void setCourierEvents(String courierEvents) {
		this.courierEvents = courierEvents;
	}

	public String getUpdated_Timestamp() {
		return Updated_Timestamp;
	}

	public void setUpdated_Timestamp(String updated_Timestamp) {
		Updated_Timestamp = updated_Timestamp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getCreated_Timestamp() {
		return created_Timestamp;
	}

	public void setCreated_Timestamp(String created_Timestamp) {
		this.created_Timestamp = created_Timestamp;
	}

	public String getBroker_Name() {
		return broker_Name;
	}

	public void setBroker_Name(String broker_Name) {
		this.broker_Name = broker_Name;
	}

	public String getDateAllocated() {
		return dateAllocated;
	}

	public void setDateAllocated(String dateAllocated) {
		this.dateAllocated = dateAllocated;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getSystemStatus() {
		return systemStatus;
	}

	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}
	
}
