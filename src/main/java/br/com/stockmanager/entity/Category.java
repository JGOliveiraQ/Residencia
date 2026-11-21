package br.com.stockmanager.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "categories")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, length=120) private String name;
    @Column(name="normalized_name", nullable=false, unique=true, length=120) private String normalizedName;
    private String description;
    @Column(nullable=false) private boolean active = true;
    @Column(nullable=false) private LocalDateTime createdAt;
    @Column(nullable=false) private LocalDateTime updatedAt;
    @OneToMany(mappedBy="category") private List<Product> products = new ArrayList<>();
    protected Category() {}
    public Category(String name, String description) { this.name=name; this.description=description; this.normalizedName=normalize(name); }
    @PrePersist void prePersist() { createdAt=LocalDateTime.now(); updatedAt=createdAt; normalizedName=normalize(name); }
    @PreUpdate void preUpdate() { updatedAt=LocalDateTime.now(); normalizedName=normalize(name); }
    private static String normalize(String value) { return value == null ? null : value.trim().toLowerCase(java.util.Locale.ROOT); }
    public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
    public String getNormalizedName(){return normalizedName;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}
