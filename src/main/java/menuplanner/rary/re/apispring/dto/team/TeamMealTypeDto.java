package menuplanner.rary.re.apispring.dto.team;

import menuplanner.rary.re.apispring.model.meal.MealType;

import java.io.Serializable;

/**
 * DTO for {@link menuplanner.rary.re.apispring.model.team.TeamMealType}
 */

public record TeamMealTypeDto(MealType mealType) implements Serializable {
}