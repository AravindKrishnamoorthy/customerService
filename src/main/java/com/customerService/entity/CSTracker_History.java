package com.customerService.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CSTracker_History")
@NamedQuery(name="CSTracker_History.findAll", query="SELECT u FROM CSTracker_History u")
public class CSTracker_History implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RowId")
	private int rowId;
	
	@Column(name="Reference_number")
	private String reference_number;
	
	@Column(name="ArticleID")
	private String articleID;
	
	@Column(name="Status")
	private String status;

	@Column(name="Status_Timestamp")
	private String status_Timestamp;
	
	@Column(name="StatusCode")
	private String statusCode;
	
	@Column(name="CourierEvents")
	private String courierEvents;
	
	@Column(name="Updated_Timestamp")
	private String Updated_Timestamp;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Handling")
	private String handling;
	
	@Column(name="comments")
	private String comments;

	@Column(name="IsUpdated")
	private String isUpdated;
	
	@Column(name="Created_Timestamp")
	private String created_Timestamp;

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

	public String getIsUpdated() {
		return isUpdated;
	}

	public void setIsUpdated(String isUpdated) {
		this.isUpdated = isUpdated;
	}

	public String getCreated_Timestamp() {
		return created_Timestamp;
	}

	public void setCreated_Timestamp(String created_Timestamp) {
		this.created_Timestamp = created_Timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
