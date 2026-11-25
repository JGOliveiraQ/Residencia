package br.com.stockmanager.entity;
import br.com.stockmanager.enums.AdjustmentDirection; import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="stock_movement_items")
public class StockMovementItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="movement_id") private StockMovement movement;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="product_id") private Product product; @Column(nullable=false) private BigDecimal quantity;
 @Enumerated(EnumType.STRING) private AdjustmentDirection adjustmentDirection; @Column(nullable=false) private BigDecimal previousStock; @Column(nullable=false) private BigDecimal resultingStock; private BigDecimal unitCost; @Column(nullable=false) private LocalDateTime createdAt;
 protected StockMovementItem(){} public StockMovementItem(Product product,BigDecimal quantity,AdjustmentDirection direction,BigDecimal previousStock,BigDecimal resultingStock,BigDecimal unitCost){this.product=product;this.quantity=quantity;this.adjustmentDirection=direction;this.previousStock=previousStock;this.resultingStock=resultingStock;this.unitCost=unitCost;}
 @PrePersist void pre(){createdAt=LocalDateTime.now();} void setMovement(StockMovement v){movement=v;} public Long getId(){return id;} public Product getProduct(){return product;} public BigDecimal getQuantity(){return quantity;} public BigDecimal getPreviousStock(){return previousStock;} public BigDecimal getResultingStock(){return resultingStock;} public BigDecimal getUnitCost(){return unitCost;}
}
