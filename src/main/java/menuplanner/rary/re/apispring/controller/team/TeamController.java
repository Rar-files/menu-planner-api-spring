package menuplanner.rary.re.apispring.controller.team;

import menuplanner.rary.re.apispring.exception.ResourceNotFoundException;
import menuplanner.rary.re.apispring.model.team.Team;
import menuplanner.rary.re.apispring.repository.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamRepository _teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        _teamRepository = teamRepository;
    }

    // get all teams
    @GetMapping()
    public List<Team> getAllTeams(){
        return _teamRepository.findAll();
    }

    // get team by id
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable int id) {
        Team team = _teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not exist with id :" + id));
        return ResponseEntity.ok(team);
    }

    // create a new team
    @PostMapping()
    public Team createTeam(@RequestBody Team team) {
        return _teamRepository.save(team);
    }
}
