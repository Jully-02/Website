package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Author;
import Model.Customer;

public class CustomerDataAccessObject implements DataAccessObjectInterface<Customer>{

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> result = new ArrayList<Customer>();
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Customer";
			PreparedStatement st = c.prepareStatement(SQL);
			
			// Step 3: Execute statement SQL
			System.out.println("You executed: " + SQL);
			ResultSet rs = st.executeQuery();
			
			
			// Step 4: Add data into result
			while(rs.next()) {
				String customerID = rs.getString("customerID");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String customerName = rs.getString("customerName");
				boolean gender = rs.getBoolean("gender");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String shoppingAddress = rs.getString("shoppingAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean registerNews = rs.getBoolean("registerNews");
				
				Customer cus = new Customer(customerID, username, password, customerName, gender, address, deliveryAddress, shoppingAddress, dateOfBirth, phoneNumber, email, registerNews);
				result.add(cus);
				
			}
			
			// Step 5:
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer selectById(Customer t) {
		Customer customer = null;
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Customer WHERE customerID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getCustomerID());
			
			// Step 3: Excute statement SQL
			System.out.println(SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result;
			while (rs.next()) {
				String customerID = rs.getString("customerID");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String customerName = rs.getString("customerName");
				boolean gender = rs.getBoolean("gender");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String shoppingAddress = rs.getString("shoppingAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean registerNews = rs.getBoolean("registerNews");
				
				customer = new Customer(customerID, username, password, customerName, gender, address, deliveryAddress, shoppingAddress, dateOfBirth, phoneNumber, email, registerNews);
			}
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public boolean insert(Customer t) {
		boolean check = false;
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "INSERT INTO Customer(customerID, username, password, customerName, gender, address, deliveryAddress, shoppingAddress, dateOfBirth, phoneNumber, email, registerNews) " + 
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getCustomerID());
			st.setString(2, t.getUsername());
			st.setString(3, t.getPassword());
			st.setString(4, t.getCustomerName());
			st.setBoolean(5,t.isGender());
			st.setString(6, t.getAddress());
			st.setString(7, t.getDeliveryAddress());
			st.setString(8, t.getShoppingAddress());
			st.setDate(9, t.getDateOfBirth());
			st.setString(10, t.getPhoneNumber());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.isRegisterNews());
			
			// Step 3: Excute statement SQL
			int result = st.executeUpdate();
			if (result != 0) {
				check = true;
			}
			
			// Step 4: Show result
			System.out.println("You excuted: " + SQL);
			System.out.println("There are" + result + " lines changed");
			
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int insertAll(ArrayList<Customer> a) {
		int count = 0;
		for (Customer c : a) {
			if (insert(c)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean delete(Customer t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "DELETE FROM Customer WHERE customerID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getCustomerID());
			
			// Step 3: Excute statement SQL
			int result = st.executeUpdate();
			if (result != 0) {
				check = true;
			}
			
			// Step 4: Show result
			System.out.println("You excuted: " + SQL);
			System.out.println("There are " + result + " lines changed!");
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int deleteAll(ArrayList<Customer> a) {
		int count = 0;
		for (Customer c : a) {
			if (delete(c)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean update(Customer t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "UPDATE Customer "
					+ "SET username = ?, password = ?, customerName = ?, gender = ?, address = ?, deliveryAddress = ?, shoppingAddress = ?, dateOfBirth = ?, phoneNumber = ?, email = ?, registerNews = ? "
					+ " WHERE customerID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getUsername());
			st.setString(2, t.getPassword());
			st.setString(3, t.getCustomerName());
			st.setBoolean(4,t.isGender());
			st.setString(5, t.getAddress());
			st.setString(6, t.getDeliveryAddress());
			st.setString(7, t.getShoppingAddress());
			st.setDate(8, t.getDateOfBirth());
			st.setString(9, t.getPhoneNumber());
			st.setString(10, t.getEmail());
			st.setBoolean(11, t.isRegisterNews());
			st.setString(12, t.getCustomerID());
			
			// Step 3: Excute statement SQL
			int result = st.executeUpdate();
			if (result != 0) {
				check = true;
			}
			
			// Step 4: Show result
			System.out.println("You excuted: " + SQL);
			System.out.println("There are " + result + " lines changed!");
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean checkDuplicate (String username) {
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Customer WHERE username = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, username);
			
			// Step 3: Excute statement SQL
			System.out.println(SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result;
			while (rs.next()) {
				return true;
			}
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public Customer selectByUsernameAndPassword(String username, String password) {
		Customer customer = null;
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Customer WHERE BINARY username = ? AND BINARY password = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, username);
			st.setString(2, password);
			
			// Step 3: Excute statement SQL
			System.out.println(SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result;
			while (rs.next()) {
				String customerID = rs.getString("customerID");
				String usernameC = rs.getString("username");
				String passwordC = rs.getString("password");
				String customerName = rs.getString("customerName");
				boolean gender = rs.getBoolean("gender");
				String address = rs.getString("address");
				String deliveryAddress = rs.getString("deliveryAddress");
				String shoppingAddress = rs.getString("shoppingAddress");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				boolean registerNews = rs.getBoolean("registerNews");
				
				customer = new Customer(customerID, usernameC, passwordC, customerName, gender, address, deliveryAddress, shoppingAddress, dateOfBirth, phoneNumber, email, registerNews);
			}
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return customer;
	}
}