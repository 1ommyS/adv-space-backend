package adv.space.controller;

import adv.space.dto.AuthDto;
import adv.space.dto.AuthenticationResponseDto;
import adv.space.dto.SignUpDto;
import adv.space.service.AuthorisationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authorisation")
public class AuthorisationController {

    private final AuthorisationService authorisationService;

    public AuthorisationController(AuthorisationService authorisationService) {
        this.authorisationService = authorisationService;
    }

    @PostMapping("signUp")
    public AuthenticationResponseDto signUp(@RequestBody SignUpDto dto) {
        return authorisationService.createUser(dto);
    }

    @PostMapping("auth")
    public AuthenticationResponseDto auth(@RequestBody AuthDto dto) {
        return authorisationService.authoriseUser(dto);
    }
}