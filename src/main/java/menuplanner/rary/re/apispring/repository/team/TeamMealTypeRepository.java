package menuplanner.rary.re.apispring.repository.team;

import menuplanner.rary.re.apispring.model.team.TeamMealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMealTypeRepository extends JpaRepository<TeamMealType, Integer> { }
