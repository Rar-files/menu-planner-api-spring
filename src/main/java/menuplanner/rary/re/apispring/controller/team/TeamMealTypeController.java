package menuplanner.rary.re.apispring.controller.team;

import menuplanner.rary.re.apispring.dto.team.TeamMealTypeDto;
import menuplanner.rary.re.apispring.exception.ResourceNotFoundException;
import menuplanner.rary.re.apispring.mapper.team.TeamMealTypeMapper;
import menuplanner.rary.re.apispring.model.meal.MealType;
import menuplanner.rary.re.apispring.model.team.TeamMealType;
import menuplanner.rary.re.apispring.repository.team.TeamMealTypeRepository;
import menuplanner.rary.re.apispring.repository.team.TeamRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/teams/{id}/meal-types")
public class TeamMealTypeController {
    private final TeamMealTypeRepository _teamMealTypeRepository;
    private final TeamRepository _teamRepository;
    private final TeamMealTypeMapper _teamMealTypeMapper;

    public TeamMealTypeController(TeamMealTypeRepository teamMealTypeRepository, TeamRepository teamRepository, TeamMealTypeMapper teamMealTypeMapper) {
        _teamMealTypeRepository = teamMealTypeRepository;
        _teamRepository = teamRepository;
        _teamMealTypeMapper = teamMealTypeMapper;
    }

    // get all meal types for a team
    @GetMapping()
    public List<MealType> getAllTeamMealTypes(@PathVariable int id) {
        return _teamMealTypeRepository.findByTeamID(id);
    }

    // get all meal types for a team
    @GetMapping("/details")
    public List<TeamMealType> getAllTeamMealTypesWithDetails(@PathVariable int id) {
        return _teamMealTypeRepository.findWithDetailsByTeamID(id);
    }

    // create a new meal type for a team
    @PostMapping()
    public TeamMealType createMealType(@PathVariable int id, @RequestBody TeamMealTypeDto teamMealTypeDto) {
        var teamMealType = _teamMealTypeMapper.toEntity(teamMealTypeDto);
        var team = _teamRepository.findById(id);
        if (team.isEmpty()) {throw new ResourceNotFoundException("Team not exist with id :" + id);}
        teamMealType.setTeam(team.get());
        return _teamMealTypeRepository.save(teamMealType);
    }
}
