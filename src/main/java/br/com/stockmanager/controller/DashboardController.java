package br.com.stockmanager.controller;
import br.com.stockmanager.repository.*; import org.springframework.web.bind.annotation.*; import java.math.BigDecimal; import java.util.Map;
@RestController @RequestMapping("/api/dashboard") public class DashboardController{
 private final ProductRepository products; private final StockMovementRepository movements; public DashboardController(ProductRepository products,StockMovementRepository movements){this.products=products;this.movements=movements;}
 @GetMapping("/summary") public Map<String,Object> summary(){var active=products.findAll().stream().filter(br.com.stockmanager.entity.Product::isActive).toList();BigDecimal value=active.stream().map(p->p.getCurrentStock().multiply(p.getCostPrice())).reduce(BigDecimal.ZERO,BigDecimal::add);long low=products.findLowStock().size();return Map.of("activeProducts",(long)active.size(),"lowStockProducts",low,"outOfStockProducts",active.stream().filter(p->p.getCurrentStock().signum()==0).count(),"stockValue",value,"entries",movements.countByType(br.com.stockmanager.enums.MovementType.ENTRY),"exits",movements.countByType(br.com.stockmanager.enums.MovementType.EXIT));}
}
