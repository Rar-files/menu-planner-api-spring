package menuplanner.rary.re.apispring.repository.meal;

import menuplanner.rary.re.apispring.model.meal.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> { }
