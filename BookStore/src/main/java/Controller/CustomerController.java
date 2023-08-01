package Controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.CustomerDataAccessObject;
import Model.Customer;
import Util.Encode;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/customer-controller")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String act = request.getParameter("act");
		if (act.equals("sign_in")) {
			sign_in(request, response);
		} else if (act.equals("sign_up")) {
			sign_up(request, response);
		} else if (act.equals("logout")) {
			logout(request, response);
		} else if (act.equals("change_information")) {
			change_information(request, response);
		} else if (act.equals("change_password")) {
			change_password(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void sign_in(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			password = Encode.toSHA1(password);

			request.setAttribute("valueUsername", username);

			CustomerDataAccessObject customerDataAccessObject = new CustomerDataAccessObject();
			Customer customer = customerDataAccessObject.selectByUsernameAndPassword(username, password);
			String url = "";
			if (customer != null) {
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
				url = "/index.jsp";
			} else {
				request.setAttribute("error", "Username or password is incorrect!");
				url = "/Customer/sign-in.jsp";
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sign_up (HttpServletRequest request, HttpServletResponse response) {
		try {	
			String fullname = request.getParameter("fullname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			String email = request.getParameter("email");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String shoppingAddress = request.getParameter("shoppingAddress");
			String phoneNumber = request.getParameter("phoneNumber");
			
			request.setAttribute("valueFullname", fullname);
			request.setAttribute("valueUsername", username);
			request.setAttribute("valueEmail", email);
			request.setAttribute("valueDateOfBirth", dateOfBirth);
			request.setAttribute("valueAddress", address);
			request.setAttribute("valueDeliveryAddress", deliveryAddress);
			request.setAttribute("valueShoppingAddress", shoppingAddress);
			request.setAttribute("valuePhoneNumber", phoneNumber);
			
			boolean checkError = false;
			CustomerDataAccessObject customerDataAccessObject = new CustomerDataAccessObject();
			if (customerDataAccessObject.checkDuplicate(username)) {
				checkError = true;
				request.setAttribute("eUsername", "Already exist!");
			}
			
			Pattern passwordPattern = Pattern.compile("(.*[A-Z])(.*[a-z])(.*\\d)");
			Matcher passwordMatcher = passwordPattern.matcher(password);
			if (password.length() < 6) {
				checkError = true;
				request.setAttribute("ePassword", "Must have at least 6 characters.");
			}
			else {
				if (!passwordMatcher.matches()) {
					checkError = true;
					request.setAttribute("ePassword", "There must be at least one uppercase letter, one lowercase letter and one number. Ex: Abc123");
				}
				else {
					password = Encode.toSHA1(password);
					repassword = Encode.toSHA1(repassword);
				}
			}
			
			if (!password.equals(repassword)) {
				checkError = true;
				request.setAttribute("eRepassword", "Password incorrect!");
			}
			
			Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
			Matcher emailMatcher = emailPattern.matcher(email);
			if (!emailMatcher.matches()) {
				checkError = true;
				request.setAttribute("eEmail", "Enter the wrong email format!");
			}
			
			Pattern phoneNumberPattern = Pattern.compile("0\\d{9}");
			Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);
			if (!phoneNumberMatcher.matches()) {
				checkError = true;
				request.setAttribute("ePhoneNumber", "Enter the wrong phone number format!");
			}
			String url = "";
			if (checkError == true) {
				url = "/Customer/sign-up.jsp";
			}
			else {
				Random rd = new Random();
				String customerID = System.currentTimeMillis() + rd.nextInt(1000) + "";
				Customer customer = new Customer(customerID, username, password, fullname, true, address, deliveryAddress, shoppingAddress, Date.valueOf(dateOfBirth), phoneNumber, email, true);
				customerDataAccessObject.insert(customer);
				url = "/Customer/sign-in.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void logout (HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
			response.sendRedirect(url + "/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void change_information (HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String shoppingAddress = request.getParameter("shoppingAddress");
			String phoneNumber = request.getParameter("phoneNumber");

			request.setAttribute("valueFullname", fullname);
			request.setAttribute("valueEmail", email);
			request.setAttribute("valueDateOfBirth", dateOfBirth);
			request.setAttribute("valueAddress", address);
			request.setAttribute("valueDeliveryAddress", deliveryAddress);
			request.setAttribute("valueShoppingAddress", shoppingAddress);
			request.setAttribute("valuePhoneNumber", phoneNumber);

			boolean checkError = false;
			CustomerDataAccessObject customerDataAccessObject = new CustomerDataAccessObject();

			Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
			Matcher emailMatcher = emailPattern.matcher(email);
			if (!emailMatcher.matches()) {
				checkError = true;
				request.setAttribute("eEmail", "Enter the wrong email format!");
			}

			Pattern phoneNumberPattern = Pattern.compile("0\\d{9}");
			Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);
			if (!phoneNumberMatcher.matches()) {
				checkError = true;
				request.setAttribute("ePhoneNumber", "Enter the wrong phone number format!");
			}
			String url = "";
			if (checkError == true) {
				url = "/Customer/ChangeInformation.jsp";
			} else {
				HttpSession session = request.getSession();
				Customer customer = (Customer)session.getAttribute("customer");
				customer.setCustomerName(fullname);
				customer.setEmail(email);
				customer.setPhoneNumber(phoneNumber);
				customer.setDateOfBirth(Date.valueOf(dateOfBirth));
				customer.setShoppingAddress(shoppingAddress);
				customer.setDeliveryAddress(deliveryAddress);
				customer.setAddress(address);
				customerDataAccessObject.update(customer);
				url = "/index.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void change_password (HttpServletRequest request, HttpServletResponse response) {
		try {
			String currentPassword = request.getParameter("currentPassword");
			String newPassword = request.getParameter("newPassword");
			String confirmPassword = request.getParameter("confirmPassword");
			
			currentPassword = Encode.toSHA1(currentPassword);
			
			String url = "";
			HttpSession session = request.getSession();
			Object object = session.getAttribute("customer");
			Customer customer = null;
			if (object != null) {
				customer = (Customer)object;
			}
			
			boolean checkError = false;
			
			if (customer == null) {
				url = "/index.jsp";
			}
			else {
				if (!currentPassword.equals(customer.getPassword())) {
					request.setAttribute("eCurrentPassword", "The current password is incorrect!");
					checkError = true;
				}
				else {
					if (Encode.toSHA1(newPassword).equals(currentPassword)) {
						request.setAttribute("eNewPassword", "The new password cannot be the same as the old password!");
						checkError = true;
					}
					else {
						Pattern passwordPattern = Pattern.compile("(.*[A-Z])(.*[a-z])(.*\\d)");
						Matcher passwordMatcher = passwordPattern.matcher(newPassword);
						if (newPassword.length() < 6) {
							request.setAttribute("eNewPassword", "Must have at least 6 characters.");
							checkError = true;
						}
						else {
							if (!passwordMatcher.matches()) {
								checkError = true;
								request.setAttribute("eNewPassword", "There must be at least one uppercase letter, one lowercase letter and one number. Ex: Abc123");
							}
						}
						
						if (!confirmPassword.equals(newPassword)) {
							checkError = true;
							request.setAttribute("eConfirmPassword", "Password incorrect!");
						}
					}
				}
			}
			
			if (checkError == true) {
				url = "Customer/ChangePassword.jsp";
			}
			else {
				customer.setPassword(Encode.toSHA1(newPassword));
				CustomerDataAccessObject customerDataAccessObject = new CustomerDataAccessObject();
				customerDataAccessObject.update(customer);
				url = "Customer/sign-in.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
