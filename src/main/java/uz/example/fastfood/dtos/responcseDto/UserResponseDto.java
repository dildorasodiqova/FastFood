package uz.example.fastfood.dtos.responcseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.example.fastfood.dtos.createDto.LocationDto;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private UUID id;
    private String name;
    private String surname;
    private String phoneNumber;
    private LocationDto location;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
