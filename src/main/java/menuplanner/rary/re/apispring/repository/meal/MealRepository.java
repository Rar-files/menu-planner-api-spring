package menuplanner.rary.re.apispring.repository.meal;

import menuplanner.rary.re.apispring.model.meal.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> { }