package adv.space.controller;

import adv.space.dto.responses.AuthDto;
import adv.space.dto.responses.AuthenticationResponseDto;
import adv.space.dto.requests.SignUpDto;
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