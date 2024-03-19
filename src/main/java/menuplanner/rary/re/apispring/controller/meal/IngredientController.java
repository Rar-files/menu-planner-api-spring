package menuplanner.rary.re.apispring.controller.meal;

import menuplanner.rary.re.apispring.exception.ResourceNotFoundException;
import menuplanner.rary.re.apispring.model.meal.Ingredient;
import menuplanner.rary.re.apispring.repository.meal.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meals")
public class IngredientController {
    private final IngredientRepository _ingredientRepository;


    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        _ingredientRepository = ingredientRepository;
    }


    // get ingredient by id
    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable int id) {
        var ingredient = _ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            throw new ResourceNotFoundException("Ingredient with id " + id);
        }
        return ResponseEntity.ok(ingredient.get());
    }

    // get all ingredients for a meal
    @GetMapping("/{id}/ingredients")
    public ResponseEntity<List<Ingredient>> getAllMealIngredients(@PathVariable int id) {
        return ResponseEntity.ok(_ingredientRepository.getIngredientsByMealId(id));
    }

}
