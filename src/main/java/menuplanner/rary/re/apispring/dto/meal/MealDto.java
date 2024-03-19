package menuplanner.rary.re.apispring.dto.meal;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link menuplanner.rary.re.apispring.model.meal.Meal}
 */
@Value
public class MealDto implements Serializable {
    String slug;
    String name;
    String description;
    Set<IngredientDto> ingredients;

    /**
     * DTO for {@link menuplanner.rary.re.apispring.model.meal.Ingredient}
     */
    @Value
    public static class IngredientDto implements Serializable {
        int quantity;
        String productSlug;
    }
}