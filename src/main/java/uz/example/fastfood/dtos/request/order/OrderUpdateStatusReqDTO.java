package uz.example.fastfood.dtos.request.order;

import lombok.Getter;
import lombok.Setter;
import uz.example.fastfood.enums.OrderStatus;

import java.util.UUID;

/**
 * @author Admin on 7/18/2024
 * @project FastFood
 * @package uz.example.fastfood.dtos.request.order
 * @contact @sarvargo
 */
@Getter
@Setter
public class OrderUpdateStatusReqDTO {
    private UUID orderId;
    private OrderStatus status;
}
