package br.com.stockmanager.dto;
import br.com.stockmanager.enums.AdjustmentDirection; import jakarta.validation.constraints.*; import java.math.BigDecimal;
public record MovementItemRequest(@NotNull Long productId,@NotNull @Positive BigDecimal quantity,AdjustmentDirection adjustmentDirection,@PositiveOrZero BigDecimal unitCost){}
