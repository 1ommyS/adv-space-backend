package adv.space.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link adv.space.entity.UserEntity}
 */
public record UserDto(Long id, LocalDateTime created, LocalDateTime modified, String fullName, String login,
                      String password, String email, String telegram, String phone,
                      Boolean isApproved) implements Serializable {
}