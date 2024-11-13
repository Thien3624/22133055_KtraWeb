package thien.vn.controllers.admin;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import thien.vn.entity.Videos;
import thien.vn.services.IVideoService;
import thien.vn.services.impl.VideoServiceImpl;



@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/insert",
		"/admin/video/edit", "/admin/video/update", "/admin/video/delete" })
	public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public IVideoService videoService = new VideoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("categories")) {
			List<Videos> list = videoService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/videos-list.jsp").forward(req, resp);
		}else if (url.contains("add"))
		{
			req.getRequestDispatcher("/views/admin/videos-add.jsp").forward(req, resp);
		}else if(url.contains("edit"))
		{
			String id = req.getParameter("id");
			Videos video = videoService.findById(id);
			
			req.setAttribute("video", video);
			req.getRequestDispatcher("/views/admin/videos-edit.jsp").forward(req, resp);
		}else if(url.contains("delete"))
		{
			String id = req.getParameter("id");
			try {
				videoService.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/videos");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("insert")) {
			String title = req.getParameter("title");
			boolean status = Boolean.parseBoolean(req.getParameter("active"));
			Videos v = new Videos();
			v.setTitle(title);
			v.setActive(status);
			
			String fname = "";
			String uploadPath = "E:\\Video";
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists())
			{
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("poster");
				if(part.getSize() > 0)
				{
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// Đổi tên file khi upload lên trùng tên ảnh
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname=System.currentTimeMillis() + "." + ext;
					//Upload file
					part.write(uploadPath+"/"+fname);
					//ghi tên file vào data
					v.setPoster(fname);
				}else {
					v.setPoster("avatar.png");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}			
			
			
			videoService.insert(v);
			resp.sendRedirect(req.getContextPath()+"/admin/categories");
		}else if(url.contains("update"))
		{
			String id = req.getParameter("videoId");
			String title = req.getParameter("title");
			boolean status = Boolean.parseBoolean(req.getParameter("active"));			Videos v = new Videos();
			v.setVideoId(id);
			v.setTitle(title);
			v.setActive(status);
			//Xử lí để lưu hình cũ nếu không chọn
			Videos videoOld = videoService.findById(id);
			String fileOld = videoOld.getPoster();
			//Xử lí upload images
			
			String fname = "";
			String uploadPath = "E:\\Video";
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists())
			{
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("poster");
				if(part.getSize() > 0)
				{
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// Đổi tên file khi upload lên trùng tên ảnh
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname=System.currentTimeMillis() + "." + ext;
					//Upload file
					part.write(uploadPath+"/"+fname);
					//ghi tên file vào data
					v.setPoster(fname);
				}else {
					v.setPoster(fileOld);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}

			videoService.update(v);
			resp.sendRedirect(req.getContextPath()+"/admin/videos");
		}
	}
}
