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

    public Meal(){}

    public Meal(int id, String slug, String name, String description, Set<Ingredient> ingredients) {
        super();
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}
