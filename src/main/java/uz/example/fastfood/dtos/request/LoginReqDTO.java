package uz.example.fastfood.dtos.request;

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
    String phone;
    String password;
}
