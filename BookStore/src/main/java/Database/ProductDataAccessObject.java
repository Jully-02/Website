package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Author;
import Model.Category;
import Model.Product;

public class ProductDataAccessObject implements DataAccessObjectInterface<Product>{

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Product";
			PreparedStatement st = c.prepareStatement(SQL);
			
			// Step 3: Execute statement SQL
			System.out.println("You executed: " + SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result
			while (rs.next()) {
				String productID = rs.getString("productID");
				String productName = rs.getString("productName");
				String authorID = rs.getString("authorID");
				int publishYear = rs.getInt("publishYear");
				double entryPrice = rs.getDouble("entryPrice");
				double cost = rs.getDouble("cost");
				double price = rs.getDouble("price");
				int quantities = rs.getInt("quantities");
				String categoryID = rs.getString("categoryID");
				String language = rs.getString("language");
				String description = rs.getString("description");
				
				Author author = (new AuthorDataAccessObject().selectById(new Author(authorID, "", null, "")));
				Category category = (new CategoryDataAccessObject().selectById(new Category(categoryID, "")));
				
				Product product = new Product(productID, productName, author, publishYear, entryPrice, cost, price, quantities, category, language, description);
				result.add(product);
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
	public Product selectById(Product t) {
		Product product = null;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Product WHERE productID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getProductID());
			
			// Step 3: Execute statement SQL
			System.out.println("You executed: " + SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result
			while (rs.next()) {
				String productID = rs.getString("productID");
				String productName = rs.getString("productName");
				String authorID = rs.getString("authorID");
				int publishYear = rs.getInt("publishYear");
				double entryPrice = rs.getDouble("entryPrice");
				double cost = rs.getDouble("cost");
				double price = rs.getDouble("price");
				int quantities = rs.getInt("quantities");
				String categoryID = rs.getString("categoryID");
				String language = rs.getString("language");
				String description = rs.getString("description");
				
				Author author = (new AuthorDataAccessObject().selectById(new Author(authorID, "", null, "")));
				Category category = (new CategoryDataAccessObject().selectById(new Category(categoryID, "")));
				
				product = new Product(productID, productName, author, publishYear, entryPrice, cost, price, quantities, category, language, description);
			}
			
			// Step 5: Disconnection 
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean insert(Product t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "INSERT INTO Product(productID, productName, authorID, publishYear, entryPrice, cost, price, quantities, categoryID, language, description) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getProductID());
			st.setString(2, t.getProductName());
			st.setString(3, t.getAuthor().getAuthorID());
			st.setInt(4, t.getPublishYear());
			st.setDouble(5, t.getEntryPrice());
			st.setDouble(6, t.getCost());
			st.setDouble(7, t.getPrice());
			st.setInt(8, t.getQuantities());
			st.setString(9, t.getCategory().getCategoryID());
			st.setString(10, t.getLanguage());
			st.setString(11, t.getDescription());
			
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
	public int insertAll(ArrayList<Product> a) {
		int count = 0;
		for (Product p : a) {
			if (insert(p)) {
				count ++;
			}
		}
		return count;
	}

	@Override
	public boolean delete(Product t) {
		boolean check = false;
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "DELETE FROM Product WHERE productID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getProductID());
			
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
	public int deleteAll(ArrayList<Product> a) {
		int count = 0;
		for (Product p : a) {
			if (delete(p)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean update(Product t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "UPDATE Product "
					+ "SET productID = ?, productName = ?, authorID= ?, publishYear = ?, entryPrice = ?, cost = ?, price = ?, quantities = ?, categoryID = ?, language = ?, description = ? "
					+ " WHERE productID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getProductName());
			st.setString(2, t.getAuthor().getAuthorID());
			st.setInt(3, t.getPublishYear());
			st.setDouble(4, t.getEntryPrice());
			st.setDouble(5, t.getCost());
			st.setDouble(6, t.getPrice());
			st.setInt(7, t.getQuantities());
			st.setString(8, t.getCategory().getCategoryID());
			st.setString(9, t.getLanguage());
			st.setString(10, t.getDescription());
			st.setString(11, t.getProductID());
			
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
