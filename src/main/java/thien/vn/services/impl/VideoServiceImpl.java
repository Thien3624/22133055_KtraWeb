package thien.vn.services.impl;

import java.util.List;

import thien.vn.dao.IVideoDao;
import thien.vn.dao.impl.VideoDao;
import thien.vn.entity.Category;
import thien.vn.entity.Videos;
import thien.vn.services.IVideoService;

public class VideoServiceImpl implements IVideoService{

	public IVideoDao videoDao = new VideoDao();

	@Override
	public List<Videos> findAll() {
		return videoDao.findAll();
	}

	@Override
	public Videos findById(String id) {
		return videoDao.findById(id);
	}

	@Override
	public List<Videos> searchByTitle(String keyword) {
		return videoDao.searchByTitle(keyword);
	}

	@Override
	public void insert(Videos video) {
		Videos v = this.findByTitle(video.getTitle());
		if (v == null) {
			videoDao.insert(video);
		}

	}

	@Override
	public void update(Videos video) {
		Videos v = this.findById(video.getVideoId());
		if (v != null) {
			videoDao.update(video);
		}

	}

	@Override
	public void delete(String id) {
		try {
			videoDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int count() {
		return videoDao.count();
	}

	@Override
	public List<Videos> findAll(int page, int pagesize) {
		return videoDao.findAll(page, pagesize);
	}

	@Override

	public Videos findByTitle(String name) {
		try {
			return videoDao.findByTitle(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> findAllCategoriesWithVideos() {
		return videoDao.findAllCategoriesWithVideos();
	}

}
