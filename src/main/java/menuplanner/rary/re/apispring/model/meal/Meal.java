package menuplanner.rary.re.apispring.model.meal;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="meal")
public class Meal {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private int id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "meal")
    private Set<Ingredient> ingredients;

    public Meal(){}

    public Meal(int id, String slug, String name, String description, Set<Ingredient> ingredients) {
        super();
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

}
