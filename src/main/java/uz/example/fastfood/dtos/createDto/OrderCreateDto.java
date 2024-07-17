package uz.example.fastfood.dtos.createDto;

import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Meals not empty!")
    private List<OrderMealDTO> meals;

    private LocationDto location;

}
