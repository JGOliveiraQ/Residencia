package br.com.stockmanager.entity;
import br.com.stockmanager.enums.MovementType; import jakarta.persistence.*; import java.time.LocalDateTime; import java.util.*;
@Entity @Table(name="stock_movements")
public class StockMovement {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Enumerated(EnumType.STRING) @Column(nullable=false) private MovementType type; private String description,reason;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="supplier_id") private Supplier supplier; @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id") private User user;
 @Column(nullable=false) private LocalDateTime createdAt; @OneToMany(mappedBy="movement",cascade=CascadeType.PERSIST,orphanRemoval=false) private List<StockMovementItem> items=new ArrayList<>();
 protected StockMovement(){} public StockMovement(MovementType type,String description,String reason,Supplier supplier,User user){this.type=type;this.description=description;this.reason=reason;this.supplier=supplier;this.user=user;}
 @PrePersist void pre(){createdAt=LocalDateTime.now();} public void addItem(StockMovementItem item){items.add(item);item.setMovement(this);}
 public Long getId(){return id;} public MovementType getType(){return type;} public String getDescription(){return description;} public String getReason(){return reason;} public Supplier getSupplier(){return supplier;} public User getUser(){return user;} public LocalDateTime getCreatedAt(){return createdAt;} public List<StockMovementItem> getItems(){return items;}
}
