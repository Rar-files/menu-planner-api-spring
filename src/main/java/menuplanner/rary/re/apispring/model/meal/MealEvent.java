package menuplanner.rary.re.apispring.model.meal;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import menuplanner.rary.re.apispring.model.team.Team;

@Getter
@Setter
@Entity
@Table(name="meal_event")
public class MealEvent {
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
    private Team team;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Meal meal;

    public MealEvent(){}

    public MealEvent(int id, String slug, MealType mealType, String date, Team team, Meal meal) {
        this.id = id;
        this.slug = slug;
        this.mealType = mealType;
        this.date = date;
        this.team = team;
        this.meal = meal;
    }
}
