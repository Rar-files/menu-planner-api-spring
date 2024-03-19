package menuplanner.rary.re.apispring.repository.team;

import menuplanner.rary.re.apispring.model.meal.MealType;
import menuplanner.rary.re.apispring.model.team.TeamMealType;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMealTypeRepository extends JpaRepository<TeamMealType, Integer> {
    @Query("SELECT tmt.mealType FROM TeamMealType tmt WHERE tmt.team.id = :teamId")
    List<MealType> findAllByTeamID(int teamId);

}