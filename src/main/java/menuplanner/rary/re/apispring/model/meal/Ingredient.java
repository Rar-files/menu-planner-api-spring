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

    public Ingredient(){}

    public Ingredient(int id, int quantity, Product product, Meal meal) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.meal = meal;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
