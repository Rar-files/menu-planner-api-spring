package menuplanner.rary.re.apispring.model.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="product")
public class Product {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
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
    @JsonIgnore()
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
}
