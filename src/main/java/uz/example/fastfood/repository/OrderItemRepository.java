package uz.example.fastfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.fastfood.enties.OrderItemEntity;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, UUID> {
}
