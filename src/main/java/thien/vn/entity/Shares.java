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
@Table(name = "Shares")
public class Shares {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shareId;

    private String emails;
    private Date sharedDate;

    @ManyToOne
    @JoinColumn(name = "username")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "videoId")
    private Videos videos;
}
