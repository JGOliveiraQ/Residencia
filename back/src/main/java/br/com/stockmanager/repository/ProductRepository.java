package br.com.stockmanager.repository;
import br.com.stockmanager.entity.Product; import org.springframework.data.domain.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface ProductRepository extends JpaRepository<Product,Long>{
 boolean existsBySkuIgnoreCase(String sku); Optional<Product> findBySkuIgnoreCase(String sku);
 Page<Product> findByNameContainingIgnoreCaseOrSkuContainingIgnoreCase(String name,String sku,Pageable pageable);
 @org.springframework.data.jpa.repository.Query("select p from Product p where p.active = true and p.currentStock <= p.minimumStock")
 List<Product> findLowStock();
 long countByActiveTrue(); long countByActiveTrueAndCurrentStock(java.math.BigDecimal stock);
}
