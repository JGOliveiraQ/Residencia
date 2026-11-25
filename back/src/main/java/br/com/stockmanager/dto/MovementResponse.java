package br.com.stockmanager.dto;
import br.com.stockmanager.enums.MovementType; import java.time.LocalDateTime; import java.util.List;
public record MovementResponse(Long id,MovementType type,String description,String reason,LocalDateTime createdAt,List<Item> items){public record Item(Long productId,String sku,String name,java.math.BigDecimal quantity,java.math.BigDecimal previousStock,java.math.BigDecimal resultingStock,java.math.BigDecimal unitCost){}}
