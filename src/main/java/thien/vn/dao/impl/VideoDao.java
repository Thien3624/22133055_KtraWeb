package thien.vn.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import thien.vn.configs.JPAConfig;
import thien.vn.dao.IVideoDao;
import thien.vn.entity.Category;
import thien.vn.entity.Videos;

public class VideoDao implements IVideoDao {

	@Override
	public void insert(Videos video) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(video);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void update(Videos video) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(video);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	
	@Override
	public void delete(String id) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Videos category = enma.find(Videos.class, id);
			if (category != null) {
				enma.remove(category);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public Videos findById(String videoId) {
		EntityManager enma = JPAConfig.getEntityManager();
		Videos video = enma.find(Videos.class, videoId);
		return video;
	}

	@Override
	public Videos findByTitle(String title) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT c FROM Videos c WHERE c.title =:title";
		try {
			TypedQuery<Videos> query = enma.createQuery(jpql, Videos.class);
			query.setParameter("title", title);
			Videos video = query.getSingleResult();
			if (video == null) {
				throw new Exception("Title đã tồn tại");
			}
			return video;
		} finally {
			enma.close();
		}
	}

	@Override
	public List<Videos> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Videos> query = enma.createNamedQuery("Category.findAll", Videos.class);
		return query.getResultList();
	}
	
	@Override
	public List<Videos> searchByTitle(String title) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT c FROM Videos c WHERE c.title like :title";
		TypedQuery<Videos> query = enma.createQuery(jpql, Videos.class);
		query.setParameter("title", "%" + title + "%");
		return query.getResultList();
	}
	
	@Override
	public List<Videos> findAll(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Videos> query = enma.createNamedQuery("Videos.findAll", Videos.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	@Override
	 public int count() {
		 EntityManager enma = JPAConfig.getEntityManager();
		 String jpql = "SELECT count(c) FROM Videos c";
		 Query query = enma.createQuery(jpql);
		 return ((Long)query.getSingleResult()).intValue();
	 }

	@Override
	public List<Category> findAllCategoriesWithVideos() {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT DISTINCT c FROM Category c JOIN FETCH c.videos";
        TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
        return query.getResultList();
	}

}
