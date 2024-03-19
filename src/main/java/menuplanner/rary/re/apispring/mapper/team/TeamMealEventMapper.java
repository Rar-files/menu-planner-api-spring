package menuplanner.rary.re.apispring.mapper.team;

import menuplanner.rary.re.apispring.dto.team.TeamMealEventDto;
import menuplanner.rary.re.apispring.model.team.TeamMealEvent;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMealEventMapper {
    TeamMealEvent toEntity(TeamMealEventDto teamMealEventDto);

    TeamMealEventDto toDto(TeamMealEvent teamMealEvent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TeamMealEvent partialUpdate(TeamMealEventDto teamMealEventDto, @MappingTarget TeamMealEvent teamMealEvent);
}