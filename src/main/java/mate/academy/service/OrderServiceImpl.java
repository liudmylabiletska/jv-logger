package mate.academy.service;

import java.math.BigDecimal;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public Order completeOrder(Long userId) {
        logger.info("Method completeOrder was called with userId={}", userId);
        List<Product> products = getAllProductsFromShoppingCart(userId);
        Order order = new Order(products, userId);
        order.setOrderId(1L);
        logger.info("Order completed with orderId={} for userId={}", order.getOrderId(), userId);
        return order;
    }

    private List<Product> getAllProductsFromShoppingCart(Long userId) {
        List<Product> products = List.of(
                new Product("iPhone X", BigDecimal.valueOf(1199)),
                new Product("MacBook Air 2020", BigDecimal.valueOf(1399)),
                new Product("Xiaomi 12", BigDecimal.valueOf(499))
        );
        logger.info("Fetched {} products from DB for userId={}", products.size(), userId);
        return products;
    }
}
