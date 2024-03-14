package menuplanner.rary.re.apispring.model.meal;

import jakarta.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int quantity;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Product product;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Meal meal;
}
