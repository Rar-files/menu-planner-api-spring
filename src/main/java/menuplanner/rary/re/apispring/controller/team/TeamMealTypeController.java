package menuplanner.rary.re.apispring.controller.team;

import menuplanner.rary.re.apispring.dto.team.TeamMealTypeDto;
import menuplanner.rary.re.apispring.exception.ResourceNotFoundException;
import menuplanner.rary.re.apispring.mapper.team.TeamMealTypeMapper;
import menuplanner.rary.re.apispring.model.meal.MealType;
import menuplanner.rary.re.apispring.model.team.TeamMealType;
import menuplanner.rary.re.apispring.repository.team.TeamMealTypeRepository;
import menuplanner.rary.re.apispring.repository.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/teams/{id}/meal-types")
public class TeamMealTypeController {
    private final TeamMealTypeRepository _teamMealTypeRepository;
    private final TeamRepository _teamRepository;
    private final TeamMealTypeMapper _teamMealTypeMapper;

    @Autowired
    public TeamMealTypeController(TeamMealTypeRepository teamMealTypeRepository, TeamRepository teamRepository, TeamMealTypeMapper teamMealTypeMapper) {
        _teamMealTypeRepository = teamMealTypeRepository;
        _teamRepository = teamRepository;
        _teamMealTypeMapper = teamMealTypeMapper;
    }

    // get all meal types for a team
    @GetMapping()
    public ResponseEntity<List<MealType>> getAllTeamMealTypes(@PathVariable int id) {
        return ResponseEntity.ok(_teamMealTypeRepository.findAllByTeamID(id));
    }

    // create a new meal type for a team
    @PostMapping()
    public ResponseEntity<TeamMealType> createMealType(@PathVariable int id, @RequestBody TeamMealTypeDto teamMealTypeDto) {
        var teamMealType = _teamMealTypeMapper.toEntity(teamMealTypeDto);
        var team = _teamRepository.findById(id);
        if (team.isEmpty()) {throw new ResourceNotFoundException("Team with id " + id);}
        teamMealType.setTeam(team.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(_teamMealTypeRepository.save(teamMealType));
    }
}
