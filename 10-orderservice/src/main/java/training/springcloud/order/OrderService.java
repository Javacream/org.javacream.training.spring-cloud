package training.springcloud.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import training.springcloud.order.client.product.ProductClient;

import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private final ProductClient productClient;

    public Order placeOrder(String mobilePhoneNumber, Map<String,Integer> productQuantities) {
        productQuantities.keySet().forEach(productClient::getProduct);
        return null;
    }

}

