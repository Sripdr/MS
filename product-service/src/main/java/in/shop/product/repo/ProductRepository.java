package in.shop.product.repo;

import in.shop.product.dao.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDetails,Integer> {
}
