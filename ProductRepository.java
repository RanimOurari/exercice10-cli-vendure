package ch.unifr.shopcli;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
