package menuplanner.rary.re.apispring.model.team;

import menuplanner.rary.re.apispring.model.meal.MealType;
import jakarta.persistence.*;

@Entity
@Table(name="team_meal_type")
public class TeamMealType {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private MealType mealType;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Team team;
}
