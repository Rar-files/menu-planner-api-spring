package menuplanner.rary.re.apispring.model.team;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Entity
@Table(name = "team")
public class Team {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @Setter
    private String name;

    @Column(nullable = false, unique = true)
    @Setter
    private String slug;

    @OneToMany(mappedBy = "team")
    private Set<TeamUser> users;

    @OneToMany(mappedBy = "team")
    private Set<TeamMealType> meal_types;

    public Team() {

    }

    public Team(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

}
