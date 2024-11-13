package thien.vn.configs;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import thien.vn.entity.Category;
import thien.vn.entity.Videos;

public class Test {
    public static void main(String[] args) {

        EntityManager entityManager = JPAConfig.getEntityManager();
        EntityTransaction trans = entityManager.getTransaction();

        Category category = new Category();
        category.setCategoryName("Iphone");
        category.setCategoryCode("Iphone1");
        category.setImages("abc.jpg");
        category.setStatus(true);

        Videos video = new Videos();
        video.setVideoId("v001");
        video.setTitle("test");

        try {
            trans.begin();

            // Persist category trước để nó trở thành managed
            entityManager.persist(category);
            entityManager.flush(); // Đảm bảo category đã được lưu vào cơ sở dữ liệu
            
            // Sau đó gán category vào video
            video.setCategory(category);
        }catch (Exception e) {
			e.printStackTrace();
		}
    }
}
