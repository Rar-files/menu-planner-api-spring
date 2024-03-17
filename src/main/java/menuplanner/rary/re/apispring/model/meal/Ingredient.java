package menuplanner.rary.re.apispring.model.meal;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private int id;

    @Column(nullable = false)
    private int quantity;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Product product;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Meal meal;

    public Ingredient(){}

    public Ingredient(int id, int quantity, Product product, Meal meal) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.meal = meal;
    }

}
