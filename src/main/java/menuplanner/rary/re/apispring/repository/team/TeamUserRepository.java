package menuplanner.rary.re.apispring.repository.team;

import menuplanner.rary.re.apispring.model.team.TeamUser;
import menuplanner.rary.re.apispring.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamUserRepository extends JpaRepository<TeamUser, Integer> {
    @Query("SELECT tu.appUser FROM TeamUser tu WHERE tu.team.id = :teamId")
    List<AppUser> findAllUsersByTeamID(int teamId);

}
