package menuplanner.rary.re.apispring.dto.team;

import lombok.Value;
import menuplanner.rary.re.apispring.model.meal.MealType;

import java.io.Serializable;

/**
 * DTO for {@link menuplanner.rary.re.apispring.model.team.TeamMealEvent}
 */
@Value
public class TeamMealEventDto implements Serializable {
    String slug;
    MealType mealType;
    String date;
    String mealSlug;
}