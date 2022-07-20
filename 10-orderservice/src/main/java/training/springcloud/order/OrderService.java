package training.springcloud.order;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import training.springcloud.order.client.product.Product;
import training.springcloud.order.client.product.ProductClient;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private final ProductClient productClient;

    private final Tracer tracer;

    @NewSpan
    public Order placeOrder(String mobilePhoneNumber, Map<String, Integer> productQuantities) {
        log.info("placeOrder({}, {})", mobilePhoneNumber, productQuantities);

        var currentSpan = tracer.currentSpan();
        var products = productQuantities.keySet().parallelStream()
                .map(
                        productId -> {
                            tracer.withSpan(currentSpan);
                            return productClient.getProduct(productId);
                        })
                .collect(Collectors.toList());
        log.info("Collected {} product(s)", products.size());

        return null;
    }

}

