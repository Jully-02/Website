package Model;

import java.sql.Date;

public class Customer {
	private String customerID;
	private String username;
	private String password;
	private String customerName;
	private boolean gender;
	private String address;
	private String deliveryAddress;
	private String shoppingAddress;
	private Date dateOfBirth;
	private String phoneNumber;
	private String email;
	private boolean registerNews;

	public Customer () {
		
	}

	public Customer(String customerID, String username, String password, String customerName, boolean gender,
			String address, String deliveryAddress, String shoppingAddress, Date dateOfBirth, String phoneNumber,
			String email, boolean registerNews) {
		this.customerID = customerID;
		this.username = username;
		this.password = password;
		this.customerName = customerName;
		this.gender = gender;
		this.address = address;
		this.deliveryAddress = deliveryAddress;
		this.shoppingAddress = shoppingAddress;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.registerNews = registerNews;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getShoppingAddress() {
		return shoppingAddress;
	}

	public void setShoppingAddress(String shoppingAddress) {
		this.shoppingAddress = shoppingAddress;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRegisterNews() {
		return registerNews;
	}

	public void setRegisterNews(boolean registerNews) {
		this.registerNews = registerNews;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", username=" + username + ", password=" + password
				+ ", customerName=" + customerName + ", gender=" + gender + ", address=" + address
				+ ", deliveryAddress=" + deliveryAddress + ", shoppingAddress=" + shoppingAddress + ", dateOfBirth="
				+ dateOfBirth + ", phoneNumber=" + phoneNumber + ", email=" + email + ", registerNews=" + registerNews
				+ "]";
	}
	
	
	
}
