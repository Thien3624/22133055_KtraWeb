package thien.vn.dao;


import java.util.List;

import thien.vn.entity.Category;

public interface ICategoryDao {
	void insert(Category category);
	int count();
	List<Category> findAll(int page, int pagesize);
	List<Category> searchByName(String catname);
	List<Category> findAll();
	Category findById(int int1);
	void delete(int cateid) throws Exception;
	void update(Category category);
	Category findByCategoryname(String name) throws Exception;

}
