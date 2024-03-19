package menuplanner.rary.re.apispring.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import menuplanner.rary.re.apispring.model.team.TeamUser;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="app_user")
public class AppUser implements Serializable {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private int id;

    @Column(nullable = false, unique = true)
    private String authId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String image = "https://i.ibb.co/SNvQNgq/no-profile.png";

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "appUser")
    @JsonIgnore()
    private Set<TeamUser> teams;

    public AppUser(){}

    public AppUser(int id, String authId, String name, String email, String image, Role role) {
        super();
        this.id = id;
        this.authId = authId;
        this.name = name;
        this.email = email;
        this.image = image;
        this.role = role;
    }
}
