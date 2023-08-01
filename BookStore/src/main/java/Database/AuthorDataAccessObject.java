package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import Model.Author;

public class AuthorDataAccessObject implements DataAccessObjectInterface<Author>{

	@Override
	public ArrayList<Author> selectAll() {
		ArrayList<Author> result = new ArrayList<Author>();
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Author";
			PreparedStatement st = c.prepareStatement(SQL);
			
			// Step 3: Excute statement SQL
			System.out.println(SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result
			while (rs.next()) {
				String authorID = rs.getString("authorID");
				String authorName = rs.getString("authorName");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String story = rs.getString("story");
				
				Author author = new Author(authorID, authorName, dateOfBirth, story);
				result.add(author);
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
	public Author selectById(Author t) {
		Author author = null;
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "SELECT * FROM Author WHERE authorID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getAuthorID());
			
			// Step 3: Excute statement SQL
			System.out.println(SQL);
			ResultSet rs = st.executeQuery();
			
			// Step 4: Add data into result;
			while (rs.next()) {
				String authorID = rs.getString("authorID");
				String authorName = rs.getString("authorName");
				Date dateOfBirth = rs.getDate("dateOfBirth");
				String story = rs.getString("story");
				
				author = new Author(authorID, authorName, dateOfBirth, story);
			}
			
			// Step 5: Disconnection
			JDBCUtil.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public boolean insert(Author t) {
		boolean check = false;
		try {
			// Step 1: Create connection to Database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "INSERT INTO Author (authorID, authorName, dateOfBirth, story) " + 
						" VALUES (?,?,?)";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getAuthorID());
			st.setString(2, t.getAuthorName());
			st.setDate(3, t.getDateOfBirth());
			st.setString(4, t.getStory());
			
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
	public int insertAll(ArrayList<Author> a) {
		int count = 0;
		for (Author author : a) {
			if (insert(author)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean delete(Author t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "DELETE FROM Author WHERE authorID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getAuthorID());
			
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
	public int deleteAll(ArrayList<Author> a) {
		int count = 0;
		for (Author author : a) {
			if (delete(author)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean update(Author t) {
		boolean check = false;
		try {
			// Step 1: Create connection to database
			Connection c = JDBCUtil.getConnection();
			
			// Step 2: Create an object statement
			String SQL = "UPDATE Author "
					+ "SET authorName = ?, dateOfBirth = ?, story = ?"
					+ " WHERE authorID = ?";
			PreparedStatement st = c.prepareStatement(SQL);
			st.setString(1, t.getAuthorName());
			st.setDate(2, t.getDateOfBirth());
			st.setString(3, t.getStory());
			st.setString(4, t.getAuthorID());
			
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
}
