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

    public TeamMealType(){}

    public TeamMealType(MealType mealType, Team team) {
        super();
        this.mealType = mealType;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
