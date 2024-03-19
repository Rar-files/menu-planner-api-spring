package menuplanner.rary.re.apispring.dto.meal;

import menuplanner.rary.re.apispring.model.meal.Unit;

import java.io.Serializable;

/**
 * DTO for {@link menuplanner.rary.re.apispring.model.meal.Product}
 */

public record ProductDto(String slug, String name, Unit unit, float pricePerUnit) implements Serializable {
}