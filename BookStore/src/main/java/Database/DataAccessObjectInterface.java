package Database;

import java.util.ArrayList;

public interface DataAccessObjectInterface<T> {
	
	public ArrayList<T> selectAll ();
	
	public T selectById(T t);
	
	public boolean insert (T t);
	
	public int insertAll (ArrayList<T> a);
	
	public boolean delete (T t);
	
	public int deleteAll (ArrayList<T> a);
	
	public boolean update (T t);
}
