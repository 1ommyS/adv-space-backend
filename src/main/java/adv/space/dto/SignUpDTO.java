package adv.space.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpDTO {

    @NotBlank(message = "Login is mandatory")
    @Size(min = 3, max = 50, message = "Login should be between 3 and 50 characters")
    private String login;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 50, message = "Password should be between 6 and 50 characters")
    private String password;

    @Pattern(
        regexp = "^(\\+\\d{1,3}(-| )?\\(?\\d{1,3}\\)?(-| )?\\d{1,3}(-| )?\\d{1,3}(-| )?\\d{1,4})?$",
        message = "Invalid phone format"
    )
    private String phone;

    @Pattern(regexp = "^[a-zA-Z0-9_]{5,}$", message = "Invalid Telegram username")
    private String telegram;

    @NotBlank(message = "Full name is mandatory")
    private String fullName;

    private String roleTitle;
}