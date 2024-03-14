package menuplanner.rary.re.apispring.model.team;

import jakarta.persistence.*;
import menuplanner.rary.re.apispring.model.team.Team;
import menuplanner.rary.re.apispring.model.team.TeamRole;
import menuplanner.rary.re.apispring.model.user.AppUser;

@Entity
@Table(name = "team_user")
public class TeamUser {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getId() {
        return id;
    }

    public TeamRole getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(TeamRole teamRole) {
        this.teamRole = teamRole;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
