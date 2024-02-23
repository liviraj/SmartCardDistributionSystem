package com.scds.model;

import java.sql.Date;
import java.util.Arrays;

public class RationCardModel {
	private int rationCardId;
	private String rationCardNumber;
	private String familyHeadName;
	private Date dob;
	private String gender;
	private String fatherName;
	private String motherName;
	private String occupation;
	private int noOfFamilyMembers;
	private String address1;
	private String address2;
	private String city;
	private String district;
	private String state;
	private String pincode;

	public int getRationCardId() {
		return rationCardId;
	}

	public void setRationCardId(int rationCardId) {
		this.rationCardId = rationCardId;
	}

	public String getRationCardNumber() {
		return rationCardNumber;
	}

	public void setRationCardNumber(String rationCardNumber) {
		this.rationCardNumber = rationCardNumber;
	}

	public String getFamilyHeadName() {
		return familyHeadName;
	}

	public void setFamilyHeadName(String familyHeadName) {
		this.familyHeadName = familyHeadName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getNoOfFamilyMembers() {
		return noOfFamilyMembers;
	}

	public void setNoOfFamilyMembers(int noOfFamilyMembers) {
		this.noOfFamilyMembers = noOfFamilyMembers;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "RationCardModel [rationCardId=" + rationCardId + ", rationCardNumber=" + rationCardNumber
				+ ", familyHeadName=" + familyHeadName + ", dob=" + dob + ", gender=" + gender + ", fatherName="
				+ fatherName + ", motherName=" + motherName + ", occupation=" + occupation + ", noOfFamilyMembers="
				+ noOfFamilyMembers + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", district=" + district + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
