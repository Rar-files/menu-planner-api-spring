package menuplanner.rary.re.apispring.controller.meal;

import menuplanner.rary.re.apispring.dto.meal.ProductDto;
import menuplanner.rary.re.apispring.exception.ResourceNotFoundException;
import menuplanner.rary.re.apispring.mapper.meal.ProductMapper;
import menuplanner.rary.re.apispring.model.meal.Product;
import menuplanner.rary.re.apispring.repository.meal.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meals/products")
public class ProductController {
    private final ProductRepository _productRepository;
    private final ProductMapper _productMapper;

    public ProductController(ProductRepository productRepository, ProductMapper productMapper) {
        _productRepository = productRepository;
        _productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(_productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        var product = _productRepository.findById(id);
        if (product.isEmpty()) { throw new ResourceNotFoundException("Product with id " + id);}
        return ResponseEntity.ok(product.get());
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(_productRepository.save(
                        _productMapper.toEntity(productDto)
                )
        );
    }
}
