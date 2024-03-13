package menuplanner.rary.re.apispring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "team_user")
public class TeamUser {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "team_role")
    @Enumerated(EnumType.STRING)
    private TeamRole teamRole;

    @JoinColumn(name = "app_user")
    @ManyToOne
    private AppUser appUser;

    @JoinColumn(name = "team")
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
