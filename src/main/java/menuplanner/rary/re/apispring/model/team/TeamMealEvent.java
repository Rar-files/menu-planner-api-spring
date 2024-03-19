package menuplanner.rary.re.apispring.model.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import menuplanner.rary.re.apispring.model.meal.Meal;
import menuplanner.rary.re.apispring.model.meal.MealType;

@Getter
@Setter
@Entity
@Table(name="meal_event")
public class TeamMealEvent {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private int id;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private MealType mealType;

    @Column(nullable = false)
    private String date;

    @JoinColumn(nullable = false)
    @ManyToOne
    @JsonIgnoreProperties("meal_events")
    private Team team;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Meal meal;

    public TeamMealEvent(){}

    public TeamMealEvent(int id, String slug, MealType mealType, String date, Team team, Meal meal) {
        this.id = id;
        this.slug = slug;
        this.mealType = mealType;
        this.date = date;
        this.team = team;
        this.meal = meal;
    }
}
