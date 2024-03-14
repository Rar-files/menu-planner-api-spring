package menuplanner.rary.re.apispring.repository.team;

import menuplanner.rary.re.apispring.model.team.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamUserRepository extends JpaRepository<TeamUser, Integer> { }
