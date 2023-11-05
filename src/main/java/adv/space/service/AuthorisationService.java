package adv.space.service;

import adv.space.configuration.JwtService;
import adv.space.dto.AuthDto;
import adv.space.dto.AuthenticationResponseDto;
import adv.space.dto.SignUpDto;
import adv.space.entity.UserEntity;
import adv.space.exception.UserAlreadyExistsException;
import adv.space.repository.RoleRepository;
import adv.space.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.Configuration;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorisationService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtToken;

    public AuthenticationResponseDto createUser(SignUpDto dto) {
        var role = roleRepository.findByTitle(dto.roleTitle()).orElseThrow(() -> {
            log.error("UserService.createUser | Роль {} не найдена", dto.roleTitle());
            return new EntityNotFoundException();
        });

        repository.findByLogin(dto.login()).orElseThrow(() -> {
            log.error("UserService.createUser | Пользователь с логином {} уже есть", dto.login());
            return new UserAlreadyExistsException("Такой пользователь уже есть");
        });


        UserEntity user = UserEntity.builder()
                .fullName(dto.fullName())
                .login(dto.login())
                .password(passwordEncoder.encode(dto.password()))
                .email(dto.email())
                .telegram(dto.telegram())
                .phone(dto.phone())
                .isApproved(false)
                .role(role)
                .build();

        UserEntity saved = repository.save(user);
        String accessToken = jwtToken.generateToken(saved);
        String refreshToken = jwtToken.generateRefreshToken(saved);

        return new AuthenticationResponseDto(accessToken, refreshToken);
    }

    public AuthenticationResponseDto authoriseUser(AuthDto dto) {
        var user = repository.findByLogin(dto.login()).orElseThrow(() -> {
            log.error("UserService.authoriseUser | Пользователь с логином {} не найден", dto.login());
            return new EntityNotFoundException("Такой пользователь не найден");
        });

        Authentication authenticated = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.login(),
                        dto.password()
                )
        );

        if (authenticated.isAuthenticated()) {
            String accessToken = jwtToken.generateToken(user);
            String refreshToken = jwtToken.generateRefreshToken(user);
            return new AuthenticationResponseDto(accessToken, refreshToken);
        }

        return null;
    }
}