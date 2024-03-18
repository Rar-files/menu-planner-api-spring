package menuplanner.rary.re.apispring.controller.team;

import menuplanner.rary.re.apispring.dto.team.TeamUserDto;
import menuplanner.rary.re.apispring.exception.ResourceNotFoundException;
import menuplanner.rary.re.apispring.model.team.TeamUser;
import menuplanner.rary.re.apispring.model.user.AppUser;
import menuplanner.rary.re.apispring.repository.team.TeamRepository;
import menuplanner.rary.re.apispring.repository.team.TeamUserRepository;
import menuplanner.rary.re.apispring.repository.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams/{id}/users")
public class TeamUserController {
    private final TeamUserRepository _teamUserRepository;
    private final TeamRepository _teamRepository;
    private final UserRepository _userRepository;

    public TeamUserController(TeamUserRepository teamUserRepository, TeamRepository teamRepository, UserRepository userRepository){
        _teamUserRepository = teamUserRepository;
        _teamRepository = teamRepository;
        _userRepository = userRepository;
    }

    // get all users in a team
    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsersInTeam(@PathVariable int id) {
        return ResponseEntity.ok(_teamUserRepository.findAllUsersByTeamID(id));
    }

    // create a new user in a team
    @PostMapping()
    public ResponseEntity<TeamUser> createUserInTeam(@PathVariable int id, @RequestBody TeamUserDto teamUserDto) {
        var team = _teamRepository.findById(id);
        if (team.isEmpty()) {throw  new ResourceNotFoundException("Team not exist with id :" + id);}

        var user = _userRepository.findById(teamUserDto.appUserId());
        if (user.isEmpty()) {throw  new ResourceNotFoundException("User not exist with id :" + teamUserDto.appUserId());}

        TeamUser teamUser = new TeamUser(teamUserDto.teamRole(), user.get(), team.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(_teamUserRepository.save(teamUser));
    }
}
