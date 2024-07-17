package uz.example.fastfood.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Admin on 7/17/2024
 * @project FastFood
 * @package uz.example.fastfood.dtos.request
 * @contact @sarvargo
 */
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginReqDTO {

    @NotBlank(message = "Phone can't be blank!")
    String phone;

    @NotBlank(message = "Password can't be blank!")
    String password;
}
