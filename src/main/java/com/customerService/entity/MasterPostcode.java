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
@Table(name="MasterPostcode")
@NamedQuery(name="MasterPostcode.findAll", query="SELECT m FROM MasterPostcode m")
public class MasterPostcode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="Postcode")
	private String postcode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Suburb")
	private String suburb;
	
	@Column(name="State")
	private String state;
	
	@Column(name="StateName")
	private String stateName;
	
	@Column(name="Zone")
	private String zone;
	
	@Column(name="PFLZone")
	private String pFLZone;
	
	@Column(name="FastwayZone")
	private String fastwayZone;
	
	@Column(name="TollZone")
	private String tollZone;
	
	@Column(name="FDMRoute")
	private String fDMRoute;
	
	@Column(name="RCZone")
	private String rCZone;
	
	@Column(name="MCSZone")
	private String mCSZone;
	
	@Column(name="VCZone")
	private String vCZone;
	
	@Column(name="PostZone")
	private String postZone;
	
	@Column(name="MC2Zone")
	private String mC2Zone;
	
	@Column(name="eTowerZone")
	private String eTowerZone;
	
	@Column(name="MCweight05")
	private String mCweight05;
	
	@Column(name="MCweight1")
	private String mCweight1;
	
	@Column(name="MCweight2")
	private String mCweight2;
	
	@Column(name="MCweight3")
	private String mCweight3;
	
	@Column(name="MCweight4")
	private String mCweight4;
	
	@Column(name="MCweight5")
	private String mCweight5;
	
	@Column(name="MCweight22")
	private String mCweight22;
	
	@Column(name="FWVIC")
	private String fWVIC;
	
	@Column(name="D2Z")
	private String d2Z;
	
	@Column(name="VC2Zone")
	private String vC2Zone;
	
	@Column(name="FWVIC2")
	private String fWVIC2;
	
	@Column(name="EXPRESS")
	private String eXPRESS;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getpFLZone() {
		return pFLZone;
	}

	public void setpFLZone(String pFLZone) {
		this.pFLZone = pFLZone;
	}

	public String getFastwayZone() {
		return fastwayZone;
	}

	public void setFastwayZone(String fastwayZone) {
		this.fastwayZone = fastwayZone;
	}

	public String getTollZone() {
		return tollZone;
	}

	public void setTollZone(String tollZone) {
		this.tollZone = tollZone;
	}

	public String getfDMRoute() {
		return fDMRoute;
	}

	public void setfDMRoute(String fDMRoute) {
		this.fDMRoute = fDMRoute;
	}

	public String getrCZone() {
		return rCZone;
	}

	public void setrCZone(String rCZone) {
		this.rCZone = rCZone;
	}

	public String getmCSZone() {
		return mCSZone;
	}

	public void setmCSZone(String mCSZone) {
		this.mCSZone = mCSZone;
	}

	public String getvCZone() {
		return vCZone;
	}

	public void setvCZone(String vCZone) {
		this.vCZone = vCZone;
	}

	public String getPostZone() {
		return postZone;
	}

	public void setPostZone(String postZone) {
		this.postZone = postZone;
	}

	public String getmC2Zone() {
		return mC2Zone;
	}

	public void setmC2Zone(String mC2Zone) {
		this.mC2Zone = mC2Zone;
	}

	public String geteTowerZone() {
		return eTowerZone;
	}

	public void seteTowerZone(String eTowerZone) {
		this.eTowerZone = eTowerZone;
	}

	public String getmCweight05() {
		return mCweight05;
	}

	public void setmCweight05(String mCweight05) {
		this.mCweight05 = mCweight05;
	}

	public String getmCweight1() {
		return mCweight1;
	}

	public void setmCweight1(String mCweight1) {
		this.mCweight1 = mCweight1;
	}

	public String getmCweight2() {
		return mCweight2;
	}

	public void setmCweight2(String mCweight2) {
		this.mCweight2 = mCweight2;
	}

	public String getmCweight3() {
		return mCweight3;
	}

	public void setmCweight3(String mCweight3) {
		this.mCweight3 = mCweight3;
	}

	public String getmCweight4() {
		return mCweight4;
	}

	public void setmCweight4(String mCweight4) {
		this.mCweight4 = mCweight4;
	}

	public String getmCweight5() {
		return mCweight5;
	}

	public void setmCweight5(String mCweight5) {
		this.mCweight5 = mCweight5;
	}

	public String getmCweight22() {
		return mCweight22;
	}

	public void setmCweight22(String mCweight22) {
		this.mCweight22 = mCweight22;
	}

	public String getfWVIC() {
		return fWVIC;
	}

	public void setfWVIC(String fWVIC) {
		this.fWVIC = fWVIC;
	}

	public String getD2Z() {
		return d2Z;
	}

	public void setD2Z(String d2z) {
		d2Z = d2z;
	}

	public String getvC2Zone() {
		return vC2Zone;
	}

	public void setvC2Zone(String vC2Zone) {
		this.vC2Zone = vC2Zone;
	}

	public String getfWVIC2() {
		return fWVIC2;
	}

	public void setfWVIC2(String fWVIC2) {
		this.fWVIC2 = fWVIC2;
	}

	public String geteXPRESS() {
		return eXPRESS;
	}

	public void seteXPRESS(String eXPRESS) {
		this.eXPRESS = eXPRESS;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
