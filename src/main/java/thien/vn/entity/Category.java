package thien.vn.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Category")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    private String categoryName;
    private String categoryCode;
    private String images;
    private Boolean status;

    @OneToMany(mappedBy = "category")
    private List<Videos> videos;
    
    
}
