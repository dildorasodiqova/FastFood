package uz.example.fastfood.dtos.createDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.example.fastfood.enties.Location;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCreateDto {
    private UUID userId;
    private List<UUID> mealIds;
    private Location location;
    private BigDecimal totalCost;
}
