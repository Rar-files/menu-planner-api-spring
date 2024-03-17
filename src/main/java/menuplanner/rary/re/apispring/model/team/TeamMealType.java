package menuplanner.rary.re.apispring.model.team;

import lombok.Getter;
import lombok.Setter;
import menuplanner.rary.re.apispring.model.meal.MealType;
import jakarta.persistence.*;

@Getter
@Entity
@Table(name="team_meal_type")
public class TeamMealType {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Setter
    private MealType mealType;

    @JoinColumn(nullable = false)
    @ManyToOne
    @Setter
    private Team team;

    public TeamMealType(){}

    public TeamMealType(MealType mealType, Team team) {
        super();
        this.mealType = mealType;
        this.team = team;
    }
}
