package menuplanner.rary.re.apispring.dto.team;

import menuplanner.rary.re.apispring.model.team.TeamRole;

import java.io.Serializable;

/**
 * DTO for {@link menuplanner.rary.re.apispring.model.team.TeamUser}
 */

public record TeamUserDto(TeamRole teamRole, int appUserId) implements Serializable {
}