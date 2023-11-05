package adv.space.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
public record SignUpDto(
        @NotBlank(message = "Login is mandatory")
        @Size(min = 3, max = 50, message = "Login should be between 3 and 50 characters")
        String login,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 6, max = 50, message = "Password should be between 6 and 50 characters")
        String password,

        @Pattern(
                regexp = "^(\\+\\d{1,3}(-| )?\\(?\\d{1,3}\\)?(-| )?\\d{1,3}(-| )?\\d{1,3}(-| )?\\d{1,4})?$",
                message = "Invalid phone format"
        )
        String phone,

        @Pattern(regexp = "^[a-zA-Z0-9_]{5,}$", message = "Invalid Telegram username")
        String telegram,

        @NotBlank(message = "Full name is mandatory")
        String fullName,

        String roleTitle
) {

}