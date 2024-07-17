package uz.example.fastfood.service.userService;

import uz.example.fastfood.dtos.request.RegisterReqDTO;
import uz.example.fastfood.dtos.responcseDto.BaseResponse;

public interface UserService {
    BaseResponse<?> register(RegisterReqDTO registerDTO);
}
