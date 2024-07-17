package uz.example.fastfood.service.userService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.example.fastfood.dtos.createDto.UserCreateDto;
import uz.example.fastfood.dtos.responcseDto.UserResponseDto;
import uz.example.fastfood.enties.Location;
import uz.example.fastfood.enties.UserEntity;
import uz.example.fastfood.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    public UserResponseDto createUser(UserCreateDto dto) {
        UserEntity user = modelMapper.map(dto, UserEntity.class);
        Location location = modelMapper.map(dto.getLocation(), Location.class);
        location.setUser(user);
        user.setLocation(location);

        UserEntity savedUser = userRepository.save(user);
        locationRepository.save(location);

        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    public UserResponseDto getUser(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }
}
