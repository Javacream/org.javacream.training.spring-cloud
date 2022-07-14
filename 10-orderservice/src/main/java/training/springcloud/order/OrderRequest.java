package training.springcloud.order;

import lombok.*;

import java.util.Map;

@Data
public class OrderRequest {

    private final String phoneNumber;
    private final Map<String, Integer> productQuantities;

}
