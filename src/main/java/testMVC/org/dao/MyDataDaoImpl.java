package testMVC.org.dao;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import testMVC.org.entity.MyData;

@Service
public class MyDataDaoImpl implements MyDataDao<MyData> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory factor = Persistence.createEntityManagerFactory("persistenceUnit");
	
	@Override
	public List<MyData> getALL() {
		List<MyData> resultList = null;
		EntityManager em = null;
//		try {
			em = factor.createEntityManager();
//			Query createQuery = em.createQuery("from MyData");
//			resultList = createQuery.getResultList();
//			em.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (em.isOpen()) {
//				em.close();
//			}
//		}
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
			Root<MyData> root = query.from(MyData.class);
			query.select(root);
			resultList = em.createQuery(query).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			em.close();
//			factor.close();
		}
		return resultList;
	}

	@Override
	public void add(MyData data) {
		EntityManager em = factor.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(data);
		tx.commit();
		em.close();
	}

	@Override
	public MyData findById(long id) {
		EntityManager em = factor.createEntityManager();
		Query createQuery = em.createQuery("from MyData where id = " + id);
		MyData result = (MyData)createQuery.getSingleResult();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyData> findByName(String name) {
		EntityManager em = factor.createEntityManager();
		return (List<MyData>)em.createQuery("from MyData where name = " +name).getResultList();
	}

	@Override
	public void update(MyData data) {
		EntityManager em = factor.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(data);
		tx.commit();
		em.close();
	}

	@Override
	public void delete(MyData data) {
		EntityManager em = factor.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		MyData merge = em.merge(data);
		em.remove(merge);
		tx.commit();
		em.close();
	}

	@Override
	public void delete(long id) {
		delete(findById(id));
	}

	@Override
	public List<MyData> find(String fstr) {
		EntityManager em = factor.createEntityManager();
		List<MyData> list = null;
//		String qstr = "from MyData where id = :fstr or name like :fname or mail like :fmail";
		long fid = 0L;
		try {
			if (checkNum(fstr) && !"".equals(fstr)) {
				fid = Long.parseLong(fstr);
			}
			Query query = em.createNamedQuery("find").setParameter("fname", "%" + fstr + "%")
					.setParameter("fid", fid).setParameter("fmail", "%" + fstr + "%");
			list = query.getResultList();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			em.close();
//			factor.close();
		}
		return list;
	}

	private boolean checkNum (String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
