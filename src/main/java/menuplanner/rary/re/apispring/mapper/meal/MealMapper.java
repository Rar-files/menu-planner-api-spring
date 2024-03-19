package menuplanner.rary.re.apispring.mapper.meal;

import menuplanner.rary.re.apispring.dto.meal.MealDto;
import menuplanner.rary.re.apispring.model.meal.Meal;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MealMapper {
    Meal toEntity(MealDto mealDto);

    @AfterMapping
    default void linkIngredients(@MappingTarget Meal meal) {
        meal.getIngredients().forEach(ingredient -> ingredient.setMeal(meal));
    }

    MealDto toDto(Meal meal);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Meal partialUpdate(MealDto mealDto, @MappingTarget Meal meal);
}