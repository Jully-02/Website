package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Category;

public class CategoryDataAccessObject implements DataAccessObjectInterface<Category>{

	@Override
	public ArrayList<Category> selectAll() {
		ArrayList<Category> result = new ArrayList<Category>();
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Category";
			PreparedStatement st = c.prepareStatement(SQL);
			
			// Step 3: Execute statement SQL
			System.out.println("You execute: " + SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result
			while (rs.next()) {
				String categoryID = rs.getString("categoryID");
				String categoryName = rs.getString("categoryName");
				
				Category category = new Category(categoryID, categoryName);
				result.add(category);
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
	public Category selectById(Category t) {
		Category category = null;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Category WHERE categoryID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getCategoryID());
			
			// Step 3: Execute statement SQL
			System.out.println("You executed: " + SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result
			while (rs.next()) {
				String categoryID = rs.getString("categoryID");
				String categoryName = rs.getString("categoryName");
				
				category = new Category(categoryID, categoryName);
			}
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public boolean insert(Category t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "INSERT INTO Category (categoryID, categoryName) "
					+ " VALUES (?,?)";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getCategoryID());
			st.setString(2, t.getCategoryName());
			
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
	public int insertAll(ArrayList<Category> a) {
		int count = 0;
		for (Category c : a) {
			if (insert(c)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean delete(Category t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "DELETE FROM Category WHERE categoryID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getCategoryID());
			
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
	public int deleteAll(ArrayList<Category> a) {
		int count = 0;
		for (Category c : a) {
			if (delete(c)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean update(Category t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "UPDATE Category " +
						"SET categoryName = ? "
						+ "WHERE categoryID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getCategoryName());
			st.setString(2, t.getCategoryName());
			
			// Step 3: Executed statement SQL
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
