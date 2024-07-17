package uz.example.fastfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import uz.example.fastfood.enties.OrderEntity;
import uz.example.fastfood.enums.OrderStatus;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    @Transactional
    @Modifying
    @Query("update orders o set o.status = ?1 where o.id = ?2")
    void updateStatusById(OrderStatus status, UUID id);
}
