package thien.vn.controllers.user;



import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import thien.vn.entity.Videos;
import thien.vn.services.IVideoService;
import thien.vn.services.impl.VideoServiceImpl;


@WebServlet(urlPatterns = "/video-detail")
public class VideoDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IVideoService videoService = new VideoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String videoId = req.getParameter("videoId");
        if (videoId != null) {
            Videos video = videoService.findById(videoId);
            
            if (video != null) {
                req.setAttribute("video", video);
                req.getRequestDispatcher("/views/web/video-detail.jsp").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Video not found");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing video ID");
        }
	}
}
