package thien.vn.dao;

import java.util.List;

import thien.vn.entity.Category;
import thien.vn.entity.Videos;

public interface IVideoDao {
	void insert(Videos video);
	int count();
	List<Videos> findAll(int page, int pagesize);
	List<Videos> searchByTitle(String title);
	List<Videos> findAll();
	Videos findById(String id);
	void delete(String videoId) throws Exception;
	void update(Videos video);
	Videos findByTitle(String title) throws Exception;
	List<Category> findAllCategoriesWithVideos();
}
