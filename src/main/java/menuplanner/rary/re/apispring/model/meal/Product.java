package menuplanner.rary.re.apispring.model.meal;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit = Unit.APIECE;

    @Column(nullable = false)
    private float pricePerUnit;

    @OneToMany(mappedBy = "product")
    private Set<Ingredient> ingredients;

    public Product(){}

    public Product(int id, String name, String slug, Unit unit, float pricePerUnit) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
}
