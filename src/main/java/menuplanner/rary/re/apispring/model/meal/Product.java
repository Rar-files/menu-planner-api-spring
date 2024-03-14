package menuplanner.rary.re.apispring.model.meal;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unit unit = Unit.APIECE;

    @Column(nullable = false)
    private float pricePerUnit;

    @OneToMany(mappedBy = "product")
    private Set<Ingredient> ingredients;
}
