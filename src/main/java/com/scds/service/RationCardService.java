package com.scds.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.scds.model.RationCardModel;
import com.scds.dbconnection.DbConnection;

public class RationCardService {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ArrayList<RationCardModel> getAllList() throws ClassNotFoundException {
		ArrayList<RationCardModel> studentList = new ArrayList<RationCardModel>();
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			String query = "select * from rationcarddetails";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				RationCardModel model = new RationCardModel();
				model.setRationCardId(rs.getInt("rationCardId"));
				model.setFamilyHeadName(rs.getString("familyHeadName"));
				model.setGender(rs.getString("gender"));
				model.setDob(rs.getDate("dob"));
				model.setRationCardNumber(rs.getString("rationCardNumber"));
				model.setFatherName(rs.getString("fatherName"));
				model.setMotherName(rs.getString("motherName"));
				model.setOccupation(rs.getString("occupation"));
				model.setNoOfFamilyMembers(rs.getInt("noOfFamilyMembers"));
				model.setAddress1(rs.getString("address1"));
				model.setAddress2(rs.getString("address2"));
				model.setCity(rs.getString("city"));
				model.setDistrict(rs.getString("district"));
				model.setState(rs.getString("state"));
				model.setPincode(rs.getString("pincode"));
				model.setPlan(rs.getString("plan"));
				studentList.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public RationCardModel getById(int id) throws ClassNotFoundException {
		RationCardModel model = new RationCardModel();
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from rationcarddetails where rationCardId='" + id + "'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.setRationCardId(rs.getInt("rationCardId"));
				model.setFamilyHeadName(rs.getString("familyHeadName"));
				model.setGender(rs.getString("gender"));
				model.setDob(rs.getDate("dob"));
				model.setRationCardNumber(rs.getString("rationCardNumber"));
				model.setFatherName(rs.getString("fatherName"));
				model.setMotherName(rs.getString("motherName"));
				model.setOccupation(rs.getString("occupation"));
				model.setNoOfFamilyMembers(rs.getInt("noOfFamilyMembers"));
				model.setAddress1(rs.getString("address1"));
				model.setAddress2(rs.getString("address2"));
				model.setCity(rs.getString("city"));
				model.setDistrict(rs.getString("district"));
				model.setState(rs.getString("state"));
				model.setPincode(rs.getString("pincode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public int deleteById(int id) throws ClassNotFoundException, SQLException {
		int status = 0;
		String query = "delete from rationcarddetails where rationCardId=" + id + "";
		con = DbConnection.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		status = ps.executeUpdate();
		return status;
	}

	public int insertDetails(RationCardModel model) {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"insert into rationcarddetails(rationCardNumber,familyHeadName,dob,gender,fatherName"
					+ ", motherName, occupation, noOfFamilyMembers, address1, address2, city, district, state, pincode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, model.getRationCardNumber());
			ps.setString(2, model.getFamilyHeadName());
			ps.setDate(3, model.getDob());
			ps.setString(4, model.getGender());
			ps.setString(5, model.getFatherName());
			ps.setString(6, model.getMotherName());
			ps.setString(7, model.getOccupation());
			ps.setInt(8, model.getNoOfFamilyMembers());
			ps.setString(9, model.getAddress1());
			ps.setString(10, model.getAddress2());
			ps.setString(11, model.getCity());
			ps.setString(12, model.getDistrict());
			ps.setString(13, model.getState());
			ps.setString(14, model.getPincode());

			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int update(RationCardModel model) throws ClassNotFoundException {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"update rationcarddetails set familyHeadName=?,dob=?,gender=?,fatherName=?,motherName=?,occupation=?,noOfFamilyMembers=?, address1=?, address2=?, city=?, "
					+ "district=?, state=?, pincode=?  where rationCardId='"
							+ model.getRationCardId() + "'");
			ps.setString(1, model.getFamilyHeadName());
			ps.setDate(2, model.getDob());
			ps.setString(3, model.getGender());
			ps.setString(4, model.getFatherName());
			ps.setString(5, model.getMotherName());
			ps.setString(6, model.getOccupation());
			ps.setInt(7, model.getNoOfFamilyMembers());
			ps.setString(8, model.getAddress1());
			ps.setString(9, model.getAddress2());
			ps.setString(10, model.getCity());
			ps.setString(11, model.getDistrict());
			ps.setString(12, model.getState());
			ps.setString(13, model.getPincode());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public int subscribePlan(int id, String paln) {
		int status = 0;
		try {
			try {
				con = DbConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"update rationcarddetails set plan=? where rationCardId='"
							+ id + "'");
			ps.setString(1, paln);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public String check(String check) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			rs = st.executeQuery(
					"select rationCardNumber from rationcarddetails where  rationCardNumber = '" + check + "'");
			if (rs.next()) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}
}
