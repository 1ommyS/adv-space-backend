package adv.space.service;

import adv.space.configuration.JwtService;
import adv.space.dto.AuthDTO;
import adv.space.dto.AuthenticationResponseDTO;
import adv.space.dto.SignUpDTO;
import adv.space.entity.UserEntity;
import adv.space.repository.RoleRepository;
import adv.space.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtToken;

    public AuthenticationResponseDTO createUser(SignUpDTO dto) {
        var role = roleRepository.findByTitle(dto.getRoleTitle()).orElseThrow(() -> {
            log.error("UserService.createUser | Такая роль не найдена");
            return new EntityNotFoundException();
        });

        UserEntity existingUser = repository.findByLogin(dto.getLogin()).orElseThrow(() -> {
            log.error("UserService.createUser | Такой пользователь уже есть");
            return new IllegalArgumentException();
        });


        UserEntity user = UserEntity.builder()
                .fullName(dto.getFullName())
                .login(dto.getLogin())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .telegram(dto.getTelegram())
                .phone(dto.getPhone())
                .isApproved(false)
                .role(role)
                .build();

        UserEntity saved = repository.save(user);
        String accessToken = jwtToken.generateToken(saved);
        String refreshToken = jwtToken.generateRefreshToken(saved);

        return new AuthenticationResponseDTO(accessToken, refreshToken);
    }

    public AuthenticationResponseDTO authoriseUser(AuthDTO dto) {
        //TODO
        return null;
    }
}