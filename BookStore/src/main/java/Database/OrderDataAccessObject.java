package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Customer;
import Model.Order;
import Model.OrderDetails;

public class OrderDataAccessObject implements DataAccessObjectInterface<Order> {

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> result = new ArrayList<Order>();
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();

			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Order";
			PreparedStatement st = c.prepareStatement(SQL);

			// Step 3: Execute statement SQL
			System.out.println("You executed: " + SQL);
			ResultSet rs = st.executeQuery();

			// Step 4: Add data into result
			while (rs.next()) {
				String orderID = rs.getString("orderID");
				String customerID = rs.getString("customerID");
				String deliveryAddress = rs.getString("deliveryAddress");
				String customerAddress = rs.getString("customerAddress");
				String status = rs.getString("status");
				String payments = rs.getString("payments");
				String paymentStatus = rs.getString("paymentStatus");
				double amountPaid = rs.getDouble("amountPaid");
				double missingAmount = rs.getDouble("missingAmount");
				Date orderDate = rs.getDate("orderDate");
				Date deliveryDate = rs.getDate("deliveryDate");
				
				Customer customer = (new CustomerDataAccessObject().selectById(new Customer(customerID,"","","",true,"","","",null,"","",true)));
				
				Order order = new Order(orderID, customer, deliveryAddress, customerAddress, status, payments,
						paymentStatus, amountPaid, missingAmount, orderDate, deliveryDate);
				result.add(order);
			}
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Order selectById(Order t) {
		Order order = null;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();

			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Order WHERE orderID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getOrderID());

			// Step 3: Execute statement SQL
			System.out.println("You executed: " + SQL);
			ResultSet rs = st.executeQuery();

			// Step 4: Add data into result
			while (rs.next()) {
				String orderID = rs.getString("orderID");
				String customerID = rs.getString("customerID");
				String deliveryAddress = rs.getString("deliveryAddress");
				String customerAddress = rs.getString("customerAddress");
				String status = rs.getString("status");
				String payments = rs.getString("payments");
				String paymentStatus = rs.getString("paymentStatus");
				double amountPaid = rs.getDouble("amountPaid");
				double missingAmount = rs.getDouble("missingAmount");
				Date orderDate = rs.getDate("orderDate");
				Date deliveryDate = rs.getDate("deliveryDate");
				
				Customer customer = (new CustomerDataAccessObject().selectById( new Customer(customerID, "", "", "", true,"", "", "", null, "", "", true)));

				order = new Order(orderID, customer, deliveryAddress, customerAddress, status, payments, paymentStatus,
						amountPaid, missingAmount, orderDate, deliveryDate);
			}
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public boolean insert(Order t) {
		boolean check = true;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "INSERT INTO Order (orderID, customerID, deliveryAddress, customerAddress, status, payments, paymentStatus, amountPaid, missingAmount, orderDate, deliveryDate) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getOrderID());
			st.setString(2, t.getCustomer().getCustomerID());
			st.setString(3, t.getDeliveryAddress());
			st.setString(4, t.getCustomerAddress());
			st.setString(5, t.getStatus());
			st.setString(6, t.getPayments());
			st.setString(7, t.getPaymentStatus());
			st.setDouble(8, t.getAmountPaid());
			st.setDouble(9, t.getMissingAmount());
			st.setDate(10, t.getOrderDate());
			st.setDate(11, t.getDeliveryDate());
			
			// Step 3: Execute statement SQL
			int result = st.executeUpdate();
			if (result != 0) {
				check = true;
			}
			
			// Step 4: Show result
			System.out.println("You executed: " + SQL);
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
	public int insertAll(ArrayList<Order> a) {
		int count = 0;
		for (Order o : a) {
			if (insert(o)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean delete(Order t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "DELETE FROM Order WHERE orderID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getOrderID());
			
			// Step 3: Execute statement SQL
			int result = st.executeUpdate();
			if (result != 0) {
				check = true;
			}
			
			// Step 4: Show result
			System.out.println("You executed: " + SQL);
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
	public int deleteAll(ArrayList<Order> a) {
		int count = 0;
		for (Order o : a) {
			if (delete(o)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean update(Order t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2 : Create an object statement
			String SQL = "UPDATE Order "
					+ "	SET customerID = ?, deliveryAddress  = ?, customerAddress = ?, status = ?, payments = ?, paymentStatus = ?, amountPaid = ?, missingAmount = ?, orderDate = ?, deliveryDate = ? "
					+ " WHERE orderID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getCustomer().getCustomerID());
			st.setString(2, t.getDeliveryAddress());
			st.setString(3, t.getCustomerAddress());
			st.setString(4, t.getStatus());
			st.setString(5, t.getPayments());
			st.setString(6, t.getPaymentStatus());
			st.setDouble(7, t.getAmountPaid());
			st.setDouble(8, t.getMissingAmount());
			st.setDate(9, t.getOrderDate());
			st.setDate(10, t.getDeliveryDate());
			st.setString(11, t.getOrderID());
			
			// Step 3: Execut statement SQL
			int result = st.executeUpdate();
			if (result != 0) {
				check = true;
			}
			
			// Step 4: Show result
			System.out.println("You executed: " + SQL);
			System.out.println("There are " + result + " lines changed!");
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}
}
