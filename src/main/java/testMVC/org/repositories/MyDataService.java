package testMVC.org.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testMVC.org.entity.MyData;

@Service
public class MyDataService {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public List<MyData> getAll () {
		return (List<MyData>) manager.createQuery("from MyData").getResultList();
	}
}
