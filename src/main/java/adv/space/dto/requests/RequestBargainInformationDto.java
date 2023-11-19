package adv.space.dto.requests;

import adv.space.dto.responses.UserDto;

/**
 * @author 1ommy
 * @version 16.11.2023
 */
public record RequestBargainInformationDto(
        UserDto advertisier,

        UserDto customer
) {
}
