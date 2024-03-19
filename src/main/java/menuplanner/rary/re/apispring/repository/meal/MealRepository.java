package menuplanner.rary.re.apispring.repository.meal;

import menuplanner.rary.re.apispring.model.meal.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
    @Query("select m from Meal m where m.slug = :slug")
    Optional<Meal> getMealBySlug(String slug);
}
