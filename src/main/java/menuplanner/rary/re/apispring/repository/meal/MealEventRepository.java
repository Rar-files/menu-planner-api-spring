package menuplanner.rary.re.apispring.repository.meal;

import menuplanner.rary.re.apispring.model.team.TeamMealEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealEventRepository extends JpaRepository<TeamMealEvent, Integer> { }
