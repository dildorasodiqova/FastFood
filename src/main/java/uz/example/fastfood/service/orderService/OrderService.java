package uz.example.fastfood.service.orderService;

import uz.example.fastfood.dtos.createDto.OrderCreateDto;
import uz.example.fastfood.dtos.responcseDto.BaseResponse;

public interface OrderService {
    BaseResponse<?> makeOrder(OrderCreateDto dto);
}
