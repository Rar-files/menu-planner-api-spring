package menuplanner.rary.re.apispring.mapper.team;

import menuplanner.rary.re.apispring.dto.team.TeamMealTypeDto;
import menuplanner.rary.re.apispring.model.team.TeamMealType;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMealTypeMapper {
    TeamMealType toEntity(TeamMealTypeDto teamMealTypeDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TeamMealType partialUpdate(TeamMealTypeDto teamMealTypeDto, @MappingTarget TeamMealType teamMealType);
}