package com.scds.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.scds.model.RationCardModel;
import com.scds.service.RationCardService;
import com.scds.utill.RationCardUtil;

@WebServlet("/RationCardController")
public class RationCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGISTER_PAGE = "RegisterRationCard.jsp";
	private static final String VIEW_PAGE = "ViewRationCard.jsp";
	private static final String LOGIN = "login.jsp";
	private static final String DISTRIBUTE_PAGE = "Distribute.jsp";
	private static final String SUBSCRIBE_PAGE = "subscribe.jsp";
	private static final String VIEW_STOCK = "viewStock.jsp";
	RequestDispatcher requestDispatcher = null;

	public RationCardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("action");
		String navigation = "";
		if (action.equals("register")) {
			if (check != null) {
				request.setAttribute("name", "save");
				navigation = REGISTER_PAGE;
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		} else if (action.equals("cancel")) {
			ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
			RationCardService service2 = new RationCardService();
			try {
				dataList = service2.getAllList();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.setAttribute("details", dataList);
			navigation = VIEW_PAGE;
		} else if (action.equals("update")) {
			if (check != null) {
				RationCardService service = new RationCardService();
				RationCardModel model = new RationCardModel();
				int id = Integer.parseInt(request.getParameter("rationCardId"));
				try {
					model = service.getById(id);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("name", "update");
				request.setAttribute("details", model);
				navigation = REGISTER_PAGE;
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		} else if (action.equals("delete")) {
			String confirm = request.getParameter("confirm");
			if (check != null) {
				if (!"false".equals(confirm)) {
					RationCardService service = new RationCardService();
					int id = Integer.parseInt(request.getParameter("rationCardId"));
					try {
						int reult = service.deleteById(id);
						if (reult == 1) {
							ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
							RationCardService service2 = new RationCardService();
							try {
								dataList = service2.getAllList();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							request.setAttribute("details", dataList);
							navigation = VIEW_PAGE;
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					requestDispatcher = request.getRequestDispatcher(LOGIN);
				}
			}
		} else if (action.equals("add")) {
			if (check != null) {
				String rationCardNumber = RationCardUtil.generateUniqueNumber();
				request.setAttribute("rationCardNumber", rationCardNumber);
				request.setAttribute("name", "save");
				navigation = REGISTER_PAGE;
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		} else if (action.equals("distribute")) {
			int id = Integer.parseInt(request.getParameter("rationCardId"));
			RationCardService service = new RationCardService();
			RationCardModel details = null;
			try {
				details = service.getById(id);
				request.setAttribute("details", details);
				navigation = DISTRIBUTE_PAGE;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else if (action.equals("subscribe")) {
			int id = Integer.parseInt(request.getParameter("rationCardId"));
			request.setAttribute("rationId", id);
			navigation = SUBSCRIBE_PAGE;
		} else if (action.equals("subscribePlan")) {
			int id = Integer.parseInt(request.getParameter("rationCardId"));
			String subscribePlan = request.getParameter("plan");
			RationCardService service = new RationCardService();
			int subscribeStatus = service.subscribePlan(id, subscribePlan);

			ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
			try {
				dataList = service.getAllList();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.setAttribute("details", dataList);
			navigation = VIEW_PAGE;

		} else if (action.equals("viewStock")) {
			navigation = VIEW_STOCK;
		} else {
			if (check != null) {
				ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
				RationCardService service = new RationCardService();
				try {
					dataList = service.getAllList();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", dataList);
				navigation = VIEW_PAGE;
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		}
		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("submit");
		ArrayList<RationCardModel> arrayList = new ArrayList<RationCardModel>();
		if (action.equals("save")) {
			if (check != null) {
				RationCardModel model = new RationCardModel();
				RationCardService service = new RationCardService();

				String rationCardNumber = request.getParameter("rationCardNumber");
				String familyHeadName = request.getParameter("familyHeadName");

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date dobReq = null;
				try {
					String reqDate = request.getParameter("dob");
					dobReq = dateFormat.parse(reqDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date dobDate = new Date(dobReq.getTime());
				String gender = request.getParameter("gender");
				String fatherName = request.getParameter("fatherName");

				String motherName = request.getParameter("motherName");
				String occupation = request.getParameter("occupation");
				int noOfFamilyMembers = Integer.parseInt(request.getParameter("noOfFamilyMembers"));
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				String city = request.getParameter("city");
				String district = request.getParameter("district");
				String state = request.getParameter("state");
				String pincode = request.getParameter("pincode");

				model.setRationCardNumber(rationCardNumber);
				model.setFamilyHeadName(familyHeadName);
				model.setDob(dobDate);
				model.setGender(gender);
				model.setFatherName(fatherName);
				model.setMotherName(motherName);
				model.setOccupation(occupation);
				model.setNoOfFamilyMembers(noOfFamilyMembers);
				model.setAddress1(address1);
				model.setAddress2(address2);
				model.setCity(city);
				model.setDistrict(district);
				model.setState(state);
				model.setPincode(pincode);

				String result = service.check(rationCardNumber);
				arrayList.add(model);
				if (result.equals("success")) {
					request.setAttribute("name", "save");
					request.setAttribute("msg", "Ration card no Already Exist");
					request.setAttribute("details", model);
					requestDispatcher = request.getRequestDispatcher(REGISTER_PAGE);
				} else {
					int status = service.insertDetails(model);
					if (status > 0) {
						ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
						RationCardService service2 = new RationCardService();
						try {
							dataList = service2.getAllList();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						request.setAttribute("details", dataList);
						requestDispatcher = request.getRequestDispatcher(VIEW_PAGE);
					}
				}
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		} else if (action.equals("Cancel")) {
			if (check != null) {
				ArrayList<RationCardModel> model = new ArrayList<RationCardModel>();
				RationCardService service = new RationCardService();
				try {
					model = service.getAllList();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", model);
				requestDispatcher = request.getRequestDispatcher(VIEW_PAGE);
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		} else if (action.equals("Distribute")) {
			if (check != null) {
				ArrayList<RationCardModel> model = new ArrayList<RationCardModel>();
				RationCardService service = new RationCardService();
				try {
					model = service.getAllList();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("msg", "Smart card distributed successfully!");
				request.setAttribute("details", model);
				requestDispatcher = request.getRequestDispatcher(VIEW_PAGE);
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		} else {
			if (check != null) {
				RationCardModel model = new RationCardModel();
				RationCardService service = new RationCardService();

				int id = Integer.parseInt(request.getParameter("rationCardId"));
				String rationCardNumber = request.getParameter("rationCardNumber");
				String familyHeadName = request.getParameter("familyHeadName");

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date dobReq = null;
				try {
					String reqDate = request.getParameter("dob");
					dobReq = dateFormat.parse(reqDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date dobDate = new Date(dobReq.getTime());
				String gender = request.getParameter("gender");
				String fatherName = request.getParameter("fatherName");

				String motherName = request.getParameter("motherName");
				String occupation = request.getParameter("occupation");
				int noOfFamilyMembers = Integer.parseInt(request.getParameter("noOfFamilyMembers"));
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				String city = request.getParameter("city");
				String district = request.getParameter("district");
				String state = request.getParameter("state");
				String pincode = request.getParameter("pincode");

				model.setRationCardId(id);
				model.setRationCardNumber(rationCardNumber);
				model.setFamilyHeadName(familyHeadName);
				model.setDob(dobDate);
				model.setGender(gender);
				model.setFatherName(fatherName);
				model.setMotherName(motherName);
				model.setOccupation(occupation);
				model.setNoOfFamilyMembers(noOfFamilyMembers);
				model.setAddress1(address1);
				model.setAddress2(address2);
				model.setCity(city);
				model.setDistrict(district);
				model.setState(state);
				model.setPincode(pincode);
				try {
					int status = service.update(model);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ArrayList<RationCardModel> dataList = null;
				try {
					dataList = service.getAllList();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", dataList);
				request.setAttribute("msg", "record updated successfully");
				requestDispatcher = request.getRequestDispatcher(VIEW_PAGE);
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		}
		requestDispatcher.forward(request, response);
	}
}
