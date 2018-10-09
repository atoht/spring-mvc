package testMVC.org.dao;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao <T> extends Serializable{
	
	public List<T> getALL();
	
	public T findById(long id);
	
	public List<T> findByName(String name);
	
	public void add(T data);
	
	public void update(T data);
	
	public void delete(T data);
	
	public void delete(long id);
	
	public List<T> find(String fstr);
}
