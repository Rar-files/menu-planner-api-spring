package menuplanner.rary.re.apispring.model.meal;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="meal")
public class Meal {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "meal")
    private Set<Ingredient> ingredients;
}
