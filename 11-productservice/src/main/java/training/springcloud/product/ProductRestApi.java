package training.springcloud.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductRestApi {

    private final ProductService productService;

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return this.productService.getProduct(productId);
    }
}
