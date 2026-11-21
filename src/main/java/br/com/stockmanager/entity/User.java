package br.com.stockmanager.entity;
import br.com.stockmanager.enums.UserRole; import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String name; @Column(nullable=false,unique=true) private String email; @Column(nullable=false) private String password;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private UserRole role; @Column(nullable=false) private boolean active=true; @Column(nullable=false) private LocalDateTime createdAt; @Column(nullable=false) private LocalDateTime updatedAt;
 protected User(){} public User(String name,String email,String password,UserRole role){this.name=name;this.email=email;this.password=password;this.role=role;}
 @PrePersist void pre(){createdAt=LocalDateTime.now();updatedAt=createdAt;} @PreUpdate void upd(){updatedAt=LocalDateTime.now();}
 public Long getId(){return id;} public String getName(){return name;} public String getEmail(){return email;} public String getPassword(){return password;} public UserRole getRole(){return role;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}
