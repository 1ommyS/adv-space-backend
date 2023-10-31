package adv.space.controller;

import adv.space.dto.AuthDTO;
import adv.space.dto.AuthenticationResponseDTO;
import adv.space.dto.SignUpDTO;
import adv.space.service.AuthorisationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class AuthorisationController {

    private final AuthorisationService authorisationService;

    public AuthorisationController(AuthorisationService authorisationService) {
        this.authorisationService = authorisationService;
    }

    @PostMapping("signUp")
    public AuthenticationResponseDTO signUp(@RequestBody SignUpDTO dto) {
        return authorisationService.createUser(dto);
    }

    @PostMapping("auth")
    public AuthenticationResponseDTO auth(@RequestBody AuthDTO dto) {
        return authorisationService.authoriseUser(dto);
    }
}