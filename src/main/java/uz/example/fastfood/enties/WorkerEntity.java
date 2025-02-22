package uz.example.fastfood.enties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.example.fastfood.enums.UserRole;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "workers")
public class WorkerEntity extends BaseEntity {
    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserRole role;


}
