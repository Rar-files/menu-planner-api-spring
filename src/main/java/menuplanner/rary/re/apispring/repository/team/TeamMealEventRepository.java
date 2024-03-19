package menuplanner.rary.re.apispring.repository.team;

import menuplanner.rary.re.apispring.model.team.TeamMealEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMealEventRepository extends JpaRepository<TeamMealEvent, Integer> {
    @Query("select tm from TeamMealEvent tm where tm.team.id = :id")
    List<TeamMealEvent> getTeamMealEventsByTeamId(int id);
}
