package uz.example.fastfood.service.orderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.example.fastfood.enties.OrderEntity;
import uz.example.fastfood.enties.UserEntity;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    public OrderEntity placeOrder(OrderEntity order) {
        UserEntity user = getUserById(order.getUserId());
        double distance = calculateDistance(
                restaurantLatitude,
                restaurantLongitude,
                user.getLocation().getLatitude(),
                user.getLocation().getLongitude()
        );
        order.setDistance(distance);
        order.setEstimatedDeliveryTime(calculateEstimatedDeliveryTime(order));
        order.setCreateDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    private LocalDateTime calculateEstimatedDeliveryTime(OrderEntity order) {
        int numberOfMeals = order.getMealIds().size();
        double distance = order.getDistance();
        int preparationTime = (int) Math.ceil(numberOfMeals / 4.0) * 5;
        int deliveryTime = (int) (distance * 3);
        return LocalDateTime.now().plusMinutes(preparationTime + deliveryTime);
    }

}
