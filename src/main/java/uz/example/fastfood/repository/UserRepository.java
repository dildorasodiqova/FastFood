package uz.example.fastfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.example.fastfood.enties.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
