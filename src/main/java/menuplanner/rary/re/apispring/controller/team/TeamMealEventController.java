package menuplanner.rary.re.apispring.controller.team;

import menuplanner.rary.re.apispring.dto.team.TeamMealEventDto;
import menuplanner.rary.re.apispring.exception.ResourceNotFoundException;
import menuplanner.rary.re.apispring.mapper.team.TeamMealEventMapper;
import menuplanner.rary.re.apispring.model.team.TeamMealEvent;
import menuplanner.rary.re.apispring.repository.meal.MealRepository;
import menuplanner.rary.re.apispring.repository.team.TeamMealEventRepository;
import menuplanner.rary.re.apispring.repository.team.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams/{id}/meal-events")
public class TeamMealEventController {
    private final TeamMealEventRepository _teamMealEventRepository;
    private final TeamRepository _teamRepository;
    private final MealRepository _mealRepository;
    private final TeamMealEventMapper _teamMealEventMapper;


    @Autowired
    public TeamMealEventController(TeamMealEventRepository teamMealEventRepository, TeamRepository teamRepository, MealRepository mealRepository, TeamMealEventMapper teamMealEventMapper) {
        _teamMealEventRepository = teamMealEventRepository;
        _teamRepository = teamRepository;
        _mealRepository = mealRepository;
        _teamMealEventMapper = teamMealEventMapper;
    }


    // get all meal events for a team
    @GetMapping()
    public ResponseEntity<List<TeamMealEvent>> getAllTeamMealEvents(@PathVariable int id) {
        _teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Team with id " + id));

        return ResponseEntity.ok(_teamMealEventRepository.getTeamMealEventsByTeamId(id));
    }


    // get a meal event by id
    @GetMapping("/{me_id}")
    public ResponseEntity<TeamMealEvent> getTeamMealEventById(@PathVariable int id, @PathVariable int me_id) {
        TeamMealEvent teamMealEvent = _teamMealEventRepository.findById(me_id)
                .orElseThrow(() -> new ResourceNotFoundException("Team meal event with id " + me_id));
        return ResponseEntity.ok(teamMealEvent);
    }


    // create a new meal event
    @PostMapping()
    public ResponseEntity<TeamMealEvent> createTeamMealEvent(@PathVariable int id, @RequestBody TeamMealEventDto teamMealEventDto) {
        var team = _teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team with id " + id));
        var meal = _mealRepository.getMealBySlug(teamMealEventDto.getMealSlug())
                .orElseThrow(() -> new ResourceNotFoundException("Meal with id " + id));
        var teamMealEvent = _teamMealEventMapper.toEntity(teamMealEventDto);
        teamMealEvent.setTeam(team);
        teamMealEvent.setMeal(meal);
        return ResponseEntity.status(HttpStatus.CREATED).body(_teamMealEventRepository.save(teamMealEvent));
    }
}
