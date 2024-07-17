package uz.example.fastfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.fastfood.enties.OrderEntity;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
