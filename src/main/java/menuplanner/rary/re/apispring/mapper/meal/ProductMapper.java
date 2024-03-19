package menuplanner.rary.re.apispring.mapper.meal;

import menuplanner.rary.re.apispring.dto.meal.ProductDto;
import menuplanner.rary.re.apispring.model.meal.Product;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
//    @Mapping(source = "unit", target = "unit")
    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product partialUpdate(ProductDto productDto, @MappingTarget Product product);
}