package br.com.stockmanager.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="suppliers")
public class Supplier {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String corporateName; private String tradeName;
 @Column(nullable=false,unique=true,length=14) private String cnpj; private String phone,email,address,city,state; @Column(nullable=false) private boolean active=true;
 @Column(nullable=false) private LocalDateTime createdAt; @Column(nullable=false) private LocalDateTime updatedAt; protected Supplier(){}
 public Supplier(String corporateName,String tradeName,String cnpj,String phone,String email,String address,String city,String state){this.corporateName=corporateName;this.tradeName=tradeName;this.cnpj=cnpj;this.phone=phone;this.email=email;this.address=address;this.city=city;this.state=state;}
 @PrePersist void pre(){createdAt=LocalDateTime.now();updatedAt=createdAt;} @PreUpdate void upd(){updatedAt=LocalDateTime.now();}
 public Long getId(){return id;} public String getCorporateName(){return corporateName;} public void setCorporateName(String v){corporateName=v;} public String getTradeName(){return tradeName;} public void setTradeName(String v){tradeName=v;}
 public String getCnpj(){return cnpj;} public void setCnpj(String v){cnpj=v;} public String getPhone(){return phone;} public void setPhone(String v){phone=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getAddress(){return address;} public void setAddress(String v){address=v;} public String getCity(){return city;} public void setCity(String v){city=v;} public String getState(){return state;} public void setState(String v){state=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}
