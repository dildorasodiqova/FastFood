package uz.example.fastfood.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.example.fastfood.dtos.createDto.OrderCreateDto;
import uz.example.fastfood.dtos.request.order.OrderUpdateStatusReqDTO;
import uz.example.fastfood.dtos.responcseDto.BaseResponse;
import uz.example.fastfood.service.orderService.OrderService;

/**
 * @author Admin on 7/17/2024
 * @project FastFood
 * @package uz.example.fastfood.controller
 * @contact @sarvargo
 */
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/make")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<BaseResponse<?>> makeOrder(@RequestBody @Valid OrderCreateDto dto){
        log.info("Make order with = {}",dto);
        return ResponseEntity.ok(
                orderService.makeOrder(dto)
        );
    }

    @PutMapping("/status")
    @PreAuthorize("hasRole('ROLE_OFITSIANT')")
    public ResponseEntity<BaseResponse<?>> updateStatus(@RequestBody @Valid OrderUpdateStatusReqDTO dto){
        log.info(
                "Update status"
        );
        return ResponseEntity.ok(orderService.updateStatus(dto.getOrderId(),dto.getStatus()));
    }
}
