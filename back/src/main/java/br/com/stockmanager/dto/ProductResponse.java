package br.com.stockmanager.dto;
import br.com.stockmanager.enums.ProductUnit; import java.math.BigDecimal;
public record ProductResponse(Long id,String sku,String name,String description,String brand,ProductUnit unit,BigDecimal costPrice,BigDecimal salePrice,BigDecimal currentStock,BigDecimal minimumStock,boolean active,Long categoryId,String categoryName){}
