package uz.example.fastfood.dtos.createDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Admin on 7/17/2024
 * @project FastFood
 * @package uz.example.fastfood.dtos.createDto
 * @contact @sarvargo
 */
@Getter
@Setter
public class OrderMealDTO {

    private UUID mealId;

    private Integer amount;
}
