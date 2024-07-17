package uz.example.fastfood.enties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.stream.Location;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class UserEntity extends BaseEntity {
    private String name;
    private String surname;
    private String password;
    private String phoneNumber;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Location location;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
