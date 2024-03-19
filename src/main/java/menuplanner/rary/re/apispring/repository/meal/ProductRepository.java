package menuplanner.rary.re.apispring.repository.meal;

import menuplanner.rary.re.apispring.model.meal.MealType;
import menuplanner.rary.re.apispring.model.meal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.slug = :slug")
    Optional<Product> findBySlug(String slug);
}
