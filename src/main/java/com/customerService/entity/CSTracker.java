package com.customerService.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="CSTracker")
@NamedQuery(name="CSTracker.findAll", query="SELECT u FROM CSTracker u")
public class CSTracker implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RowId")
	private int rowId;
	
	@Column(name="Reference_number")
	private String reference_number;

	@Column(name="ArticleID")
	private String articleID;

	@Column(name="User_Id")
	private int user_Id;
	
	@Column(name="Broker_Name")
	private String broker_Name;
	
	@Column(name="Service_Type")
	private String service_Type;
	
	@Column(name="Carrier")
	private String carrier;
	
	@Column(name="DateAllocated")
	private String dateAllocated;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Status_Timestamp")
	private String status_Timestamp;
	
	@Column(name="SystemStatus")
	private String systemStatus;
	
	@Column(name="Updated_Timestamp")
	private String Updated_Timestamp;
	
	@Column(name="Handling")
	private String handling;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="ReceiverName")
	private String receiverName;
	
	@Column(name="ReceiverAddress")
	private String receiverAddress;

	@Column(name="PhoneNumber")
	private String phoneNumber;
	
	@Column(name="Suburb")
	private String suburb;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Postcode")
	private String postcode;
	
	@Column(name="AirwayBill")
	private String airwayBill;
	
	@Column(name="SchedulerTimestamp")
	private String schedulerTimestamp;

	@Column(name="BarcodelabelNumber")
	private String barcodelabelNumber;
	
	@Column(name="Created_Timestamp")
	private String created_Timestamp;
	
	@Transient
	private String eta;
	
	@Column(name="PostZone")
	private String postZone;
	
	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
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

	public String getAirwayBill() {
		return airwayBill;
	}

	public void setAirwayBill(String airwayBill) {
		this.airwayBill = airwayBill;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getBroker_Name() {
		return broker_Name;
	}

	public void setBroker_Name(String broker_Name) {
		this.broker_Name = broker_Name;
	}

	public String getService_Type() {
		return service_Type;
	}

	public void setService_Type(String service_Type) {
		this.service_Type = service_Type;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_Timestamp() {
		return created_Timestamp;
	}

	public void setCreated_Timestamp(String created_Timestamp) {
		this.created_Timestamp = created_Timestamp;
	}

	public String getUpdated_Timestamp() {
		return Updated_Timestamp;
	}

	public void setUpdated_Timestamp(String updated_Timestamp) {
		Updated_Timestamp = updated_Timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getDateAllocated() {
		return dateAllocated;
	}

	public void setDateAllocated(String dateAllocated) {
		this.dateAllocated = dateAllocated;
	}

	public String getBarcodelabelNumber() {
		return barcodelabelNumber;
	}

	public void setBarcodelabelNumber(String barcodelabelNumber) {
		this.barcodelabelNumber = barcodelabelNumber;
	}

	public String getSystemStatus() {
		return systemStatus;
	}

	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}

	public String getStatus_Timestamp() {
		return status_Timestamp;
	}

	public void setStatus_Timestamp(String status_Timestamp) {
		this.status_Timestamp = status_Timestamp;
	}

	public String getSchedulerTimestamp() {
		return schedulerTimestamp;
	}

	public void setSchedulerTimestamp(String schedulerTimestamp) {
		this.schedulerTimestamp = schedulerTimestamp;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getPostZone() {
		return postZone;
	}

	public void setPostZone(String postZone) {
		this.postZone = postZone;
	}
	
}