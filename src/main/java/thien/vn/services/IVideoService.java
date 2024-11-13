package thien.vn.services;

import java.util.List;

import thien.vn.entity.Category;
import thien.vn.entity.Videos;



public interface IVideoService {
	void insert(Videos video);
	int count();
	List<Videos> findAll(int page, int pagesize);
	List<Videos> searchByTitle(String title);
	List<Videos> findAll();
	Videos findById(String videoId);
	void delete(String videoId) throws Exception;
	void update(Videos video);
	Videos findByTitle(String title);
	List<Category> findAllCategoriesWithVideos();
}
