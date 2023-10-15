package tech.neckel.security.product;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public List<Product> listAll(){
        return productService.listAll();
    }

    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        productService.delete(id);
    }
}
