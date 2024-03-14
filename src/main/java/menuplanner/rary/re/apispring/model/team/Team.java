package menuplanner.rary.re.apispring.model.team;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "team")
public class Team {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @OneToMany(mappedBy = "team")
    private Set<TeamUser> app_users;

    @OneToMany(mappedBy = "team")
    private Set<TeamMealType> meal_types;

    public Team() {

    }

    public Team(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Set<TeamUser> getUsers() {
        return app_users;
    }

}
