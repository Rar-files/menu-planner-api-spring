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

    public MealEvent(){}

    public MealEvent(int id, String slug, MealType mealType, String date, Team team, Meal meal) {
        this.id = id;
        this.slug = slug;
        this.mealType = mealType;
        this.date = date;
        this.team = team;
        this.meal = meal;
    }

    public int getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
