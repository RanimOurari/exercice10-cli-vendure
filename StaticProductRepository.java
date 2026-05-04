package ch.unifr.shopcli;

import java.util.List;

public class StaticProductRepository implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return List.of(
                new Product("p1", "Coffee", 4.50),
                new Product("p2", "Tea", 3.20),
                new Product("p3", "Chocolate", 5.90)
        );
    }
}
