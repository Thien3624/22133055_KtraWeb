package thien.vn.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Videos")
@NamedQuery(name = "Videos.findAll", query = "SELECT c FROM Videos c")
public class Videos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String videoId;

    private String title;
    private String poster;
    private int views;
    private String description;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "videos")
    private List<Favorites> favorites;

    @OneToMany(mappedBy = "videos")
    private List<Shares> shares;
}
