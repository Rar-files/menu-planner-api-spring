package menuplanner.rary.re.apispring.repository.meal;

import menuplanner.rary.re.apispring.model.meal.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("select i from Ingredient i where i.meal.id = :id")
    List<Ingredient> getIngredientsByMealId(int id);
}
