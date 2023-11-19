package adv.space.dto.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author 1ommy
 * @version 30.10.2023
 */

public record AuthDto(

        @NotBlank(message = "Login is mandatory")
        @Size(min = 3, max = 50, message = "Login should be between 3 and 50 characters")
        String login,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 6, max = 50, message = "Password should be between 6 and 50 characters")
        String password
) {
}