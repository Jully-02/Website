package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Order;
import Model.OrderDetails;
import Model.Product;

public class OrderDetailsDataAccessObject implements DataAccessObjectInterface<OrderDetails>{
	@Override
	public ArrayList<OrderDetails> selectAll () {
		ArrayList<OrderDetails> result = new ArrayList<OrderDetails>();
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM OrderDetails";
			PreparedStatement st = c.prepareStatement(SQL);
			
			// Step 3: Execute statement SQL
			System.out.println("You executed: " + SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result
			while (rs.next()) {
				String oderDetailsID = rs.getString("orderDetailsID");
				String orderID = rs.getString("orderID");
				String productID = rs.getString("productID");
				int quantities = rs.getInt("quantities");
				double cost = rs.getDouble("cost");
				double discount = rs.getDouble("discount");
				double price = rs.getDouble("price");
				double tax = rs.getDouble("tax");
				double totalMoney = rs.getDouble("totalMoney");
				
				Order order = (new OrderDataAccessObject().selectById(new Order(orderID, null, "","","","","",0,0,null,null)));
				Product product = (new ProductDataAccessObject().selectById(new Product(productID, "", null,0, 0, 0,0,0,null,"","")));
				OrderDetails oD = new OrderDetails(oderDetailsID, order, product, quantities, cost, discount, price, tax, totalMoney);
				
				result.add(oD);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public OrderDetails selectById (OrderDetails t) {
		OrderDetails oD = null;
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM OrderDetails WHERE orderDetailsID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getOrderDetailsID());
			
			// Step 3: Execute statement SQL
			System.out.println("You executed: " + SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result
			while (rs.next()) {
				String orderDetailsID = rs.getString("orderDetailsID");
				String orderID = rs.getString("orderID");
				String productID = rs.getString("productID");
				int quantities = rs.getInt("quantities");
				double cost = rs.getDouble("cost");
				double discount = rs.getDouble("discount");
				double price = rs.getDouble("price");
				double tax = rs.getDouble("tax");
				double totalMoney = rs.getDouble("totalMoney");
				
				Order order = (new OrderDataAccessObject().selectById(new Order(orderID, null, "","","","","",0,0,null,null)));
				Product product = (new ProductDataAccessObject().selectById(new Product(productID,"", null,0,0,0,0,0,null,"","")));
				
				oD = new OrderDetails(orderDetailsID, order, product, quantities, cost, discount, price, tax, totalMoney);
			}
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return oD;
	}
	
	@Override
	public boolean insert (OrderDetails t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "INSERT INTO OrderDetails(orderDetailsID, orderID, productID, quantities, cost, discount, price, tax, totalMoney) "
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getOrderDetailsID());
			st.setString(2, t.getOrder().getOrderID());
			st.setString(3, t.getProduct().getProductID());
			st.setInt(4, t.getQuantities());
			st.setDouble(5, t.getCost());
			st.setDouble(6, t.getDiscount());
			st.setDouble(7, t.getPrice());
			st.setDouble(8, t.getTax());
			st.setDouble(9, t.getTotalMoney());
			
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
	public int insertAll (ArrayList<OrderDetails> a) {
		int count = 0;
		for (OrderDetails oD : a) {
			if (insert(oD)) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public boolean delete (OrderDetails t) {
		boolean check = false;
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "DELETE FROM OrderDetails WHERE orderDetailsID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getOrderDetailsID());
			
			// Step 3: Execute statement SQL
			int result = st.executeUpdate();
			if (result != 0) {
				check = true;
			}
			
			// Step 4: Show result
			System.out.println("You exectued: " + SQL);
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
	public int deleteAll (ArrayList<OrderDetails> a) {
		int count = 0;
		for (OrderDetails oD : a) {
			if (delete(oD)) {
				count++;
			}
 		}
		return count;
	}
	
	public int deleteAll (Order order) {
		int count = 0;
		ArrayList<OrderDetails> data = this.selectAll();
		for (OrderDetails oD : data) {
			if (oD.getOrder().equals(order)) {
				delete(oD);
				count++;
			}
		}
		return count;
	}
	
	@Override
	public boolean update (OrderDetails t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "UPDATE OrderDetails "
					+ "SET orderID = ?, productID = ?, quantities= ?, cost = ?, discount = ?, price = ?, tax = ?, totalMoney =?"
					+ " WHERE orderDetailsID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getOrder().getOrderID());
			st.setString(2, t.getProduct().getProductID());
			st.setInt(3, t.getQuantities());
			st.setDouble(4, t.getCost());
			st.setDouble(5, t.getDiscount());
			st.setDouble(6, t.getPrice());
			st.setDouble(7, t.getTax());
			st.setDouble(8, t.getTotalMoney());
			st.setString(9, t.getOrderDetailsID());
			
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
}
