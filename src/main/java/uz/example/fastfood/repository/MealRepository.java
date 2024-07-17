package uz.example.fastfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.fastfood.enties.MealEntity;

import java.util.UUID;

public interface MealRepository extends JpaRepository<MealEntity, UUID> {
}
