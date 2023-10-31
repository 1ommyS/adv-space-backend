package adv.space.controller;

import adv.space.dto.AuthDTO;
import adv.space.dto.AuthenticationResponseDTO;
import adv.space.dto.SignUpDTO;
import adv.space.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signUp")
    public AuthenticationResponseDTO signUp(@RequestBody SignUpDTO dto) {
        return userService.createUser(dto);
    }

    @PostMapping("auth")
    public AuthenticationResponseDTO auth(@RequestBody AuthDTO dto) {
        return userService.authoriseUser(dto);
    }
}