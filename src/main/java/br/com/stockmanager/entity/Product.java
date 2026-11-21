package br.com.stockmanager.entity;

import br.com.stockmanager.enums.ProductUnit;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name="products")
public class Product {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, unique=true, length=60) private String sku;
    @Column(nullable=false, length=180) private String name;
    private String description; private String brand;
    @Enumerated(EnumType.STRING) @Column(nullable=false, length=20) private ProductUnit unit;
    @Column(nullable=false, precision=19, scale=4) private BigDecimal costPrice=BigDecimal.ZERO;
    @Column(nullable=false, precision=19, scale=4) private BigDecimal salePrice=BigDecimal.ZERO;
    @Column(nullable=false, precision=19, scale=4) private BigDecimal currentStock=BigDecimal.ZERO;
    @Column(nullable=false, precision=19, scale=4) private BigDecimal minimumStock=BigDecimal.ZERO;
    @Column(nullable=false) private boolean active=true;
    @ManyToOne(fetch=FetchType.LAZY, optional=false) @JoinColumn(name="category_id") private Category category;
    @Column(nullable=false) private LocalDateTime createdAt; @Column(nullable=false) private LocalDateTime updatedAt;
    protected Product() {}
    public Product(String sku,String name,String description,String brand,ProductUnit unit,BigDecimal costPrice,BigDecimal salePrice,BigDecimal minimumStock,Category category){
        this.sku=sku;this.name=name;this.description=description;this.brand=brand;this.unit=unit;this.costPrice=costPrice;this.salePrice=salePrice;this.minimumStock=minimumStock;this.category=category;
    }
    @PrePersist void prePersist(){createdAt=LocalDateTime.now();updatedAt=createdAt;currentStock=BigDecimal.ZERO;}
    @PreUpdate void preUpdate(){updatedAt=LocalDateTime.now();}
    public Long getId(){return id;} public String getSku(){return sku;} public void setSku(String v){sku=v;} public String getName(){return name;} public void setName(String v){name=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;} public String getBrand(){return brand;} public void setBrand(String v){brand=v;}
    public ProductUnit getUnit(){return unit;} public void setUnit(ProductUnit v){unit=v;} public BigDecimal getCostPrice(){return costPrice;} public void setCostPrice(BigDecimal v){costPrice=v;}
    public BigDecimal getSalePrice(){return salePrice;} public void setSalePrice(BigDecimal v){salePrice=v;} public BigDecimal getCurrentStock(){return currentStock;} public void setCurrentStock(BigDecimal v){currentStock=v;}
    public BigDecimal getMinimumStock(){return minimumStock;} public void setMinimumStock(BigDecimal v){minimumStock=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
    public Category getCategory(){return category;} public void setCategory(Category v){category=v;}
}
