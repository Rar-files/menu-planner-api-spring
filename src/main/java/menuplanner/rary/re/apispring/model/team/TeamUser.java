package menuplanner.rary.re.apispring.model.team;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import menuplanner.rary.re.apispring.model.team.Team;
import menuplanner.rary.re.apispring.model.team.TeamRole;
import menuplanner.rary.re.apispring.model.user.AppUser;

@Getter
@Entity
@Setter
@Table(name = "team_user")
public class TeamUser {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TeamRole teamRole = TeamRole.MEMBER;

    @JoinColumn(nullable = false)
    @ManyToOne
    private AppUser appUser;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Team team;

    public TeamUser() {
    }

    public TeamUser(TeamRole teamRole, AppUser appUser, Team team) {
        this.teamRole = teamRole;
        this.appUser = appUser;
        this.team = team;
    }
}
