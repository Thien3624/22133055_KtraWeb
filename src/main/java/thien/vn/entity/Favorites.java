package thien.vn.entity;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Favorites")
public class Favorites {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    private Date likedDate;

    @ManyToOne
    @JoinColumn(name = "videoId")
    private Videos videos;

    @ManyToOne
    @JoinColumn(name = "username")
    private Users users;
}
