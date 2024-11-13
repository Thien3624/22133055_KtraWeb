package thien.vn.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class Users {

	@Id
    private String username;

    private String password;
    private String phone;
    private String fullname;
    private String email;
    private Boolean admin;
    private Boolean active;
    private String images;

    @OneToMany(mappedBy = "users")
    private List<Favorites> favorites;

    @OneToMany(mappedBy = "users")
    private List<Shares> shares;
}
