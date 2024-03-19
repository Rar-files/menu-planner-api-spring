package menuplanner.rary.re.apispring.controller.meal;

import menuplanner.rary.re.apispring.dto.meal.MealDto;
import menuplanner.rary.re.apispring.exception.ResourceNotFoundException;
import menuplanner.rary.re.apispring.mapper.meal.MealMapper;
import menuplanner.rary.re.apispring.model.meal.Ingredient;
import menuplanner.rary.re.apispring.model.meal.Meal;
import menuplanner.rary.re.apispring.repository.meal.IngredientRepository;
import menuplanner.rary.re.apispring.repository.meal.ProductRepository;
import menuplanner.rary.re.apispring.repository.meal.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/meals")
public class MealController {
    private final MealRepository _mealRepository;
    private final ProductRepository _productRepository;
    private final IngredientRepository _ingredientRepository;
    private final MealMapper _mealMapper;

    @Autowired
    public MealController(MealRepository mealRepository, ProductRepository productRepository, IngredientRepository ingredientRepository, MealMapper mealMapper){
        _mealRepository = mealRepository;
        _productRepository = productRepository;
        _ingredientRepository = ingredientRepository;
        _mealMapper = mealMapper;
    }

    @GetMapping()
    public ResponseEntity<List<Meal>> getAllMeals(){
        return ResponseEntity.ok(_mealRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable int id) {
        var meal = _mealRepository.findById(id);
        if (meal.isEmpty()) {
            throw new ResourceNotFoundException("Meal with id " + id);
        }
        return ResponseEntity.ok(meal.get());
    }

    @PostMapping()
    public ResponseEntity<Meal> createMeal(@RequestBody MealDto mealDto) {
        var meal = _mealMapper.toEntity(mealDto);
        meal = _mealRepository.saveAndFlush(meal);

        for(var ingredientDto : mealDto.getIngredients()) {
            Ingredient ingredient = new Ingredient();
            ingredient.setQuantity(ingredientDto.getQuantity());
            ingredient.setMeal(meal);

            var product = _productRepository.findBySlug(ingredientDto.getProductSlug());
            if (product.isEmpty()) { throw new ResourceNotFoundException("Product with slug " + ingredientDto.getProductSlug());}
            ingredient.setProduct(product.get());

            _ingredientRepository.save(ingredient);
        }

        meal = _mealRepository.findById(meal.getId()).get();

        return ResponseEntity.status(HttpStatus.CREATED).body(meal);
    }
}
