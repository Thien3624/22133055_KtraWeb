package thien.vn.controllers.user;

import java.io.IOException;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thien.vn.entity.Category;
import thien.vn.services.IVideoService;
import thien.vn.services.impl.VideoServiceImpl;


@WebServlet(urlPatterns = "/videos")
public class VideoController_22133054 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IVideoService videoService = new VideoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> categories = videoService.findAllCategoriesWithVideos();
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("/views/user/category-videos.jsp").forward(req, resp);
	}

}
