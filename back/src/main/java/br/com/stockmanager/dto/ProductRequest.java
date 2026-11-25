package br.com.stockmanager.dto;
import br.com.stockmanager.enums.ProductUnit; import jakarta.validation.constraints.*; import java.math.BigDecimal;
public record ProductRequest(@NotBlank String sku,@NotBlank String name,String description,String brand,@NotNull ProductUnit unit,@NotNull @PositiveOrZero BigDecimal costPrice,@NotNull @PositiveOrZero BigDecimal salePrice,@NotNull @PositiveOrZero BigDecimal minimumStock,@NotNull Long categoryId){}
