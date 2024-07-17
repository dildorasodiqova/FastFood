package uz.example.fastfood.service.userService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.example.fastfood.dtos.createDto.UserCreateDto;
import uz.example.fastfood.dtos.request.RegisterReqDTO;
import uz.example.fastfood.dtos.responcseDto.BaseResponse;
import uz.example.fastfood.dtos.responcseDto.UserResponseDto;
import uz.example.fastfood.enties.Location;
import uz.example.fastfood.enties.UserEntity;
import uz.example.fastfood.exception.DataAlreadyExistsException;
import uz.example.fastfood.repository.LocationRepository;
import uz.example.fastfood.repository.UserRepository;

import java.rmi.AlreadyBoundException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto createUser(UserCreateDto dto) {
        UserEntity user = modelMapper.map(dto, UserEntity.class);
        Location location = modelMapper.map(dto.getLocation(), Location.class);
        location.setUser(user);
//        user.setLocation(location);

        UserEntity savedUser = userRepository.save(user);
        locationRepository.save(location);

        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    public UserResponseDto getUser(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public BaseResponse<?> register(RegisterReqDTO registerDTO) {
        Optional<UserEntity> existsUser = userRepository.findByPhoneNumberAndIsActiveIsTrue(registerDTO.getPhone());
        if (existsUser.isPresent()) {
            log.warn("User already exists phone = {}", registerDTO.getPhone());
            throw new DataAlreadyExistsException("User already exists!");
        }
        UserEntity entity = new UserEntity();
        entity.setFullName(registerDTO.getFullName());
        entity.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        entity.setPhoneNumber(registerDTO.getPhone());
        userRepository.save(entity);

        return BaseResponse.success(UserResponseDto.toDTO(entity));
    }
}
