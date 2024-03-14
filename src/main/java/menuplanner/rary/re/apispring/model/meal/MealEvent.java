package menuplanner.rary.re.apispring.model.meal;

import jakarta.persistence.*;
import menuplanner.rary.re.apispring.model.team.Team;

@Entity
@Table(name="meal_event")
public class MealEvent {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
