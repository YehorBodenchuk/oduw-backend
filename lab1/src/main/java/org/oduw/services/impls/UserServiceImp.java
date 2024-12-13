package org.oduw.services.impls;

import lombok.RequiredArgsConstructor;
import org.oduw.controllers.dtos.LoginDto;
import org.oduw.controllers.dtos.RegisterDto;
import org.oduw.controllers.dtos.UpdateDto;
import org.oduw.models.User;
import org.oduw.models.enums.UserRole;
import org.oduw.repositories.UserRepository;
import org.oduw.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public User register(RegisterDto dto) {
        User user = User.builder()
                .role(UserRole.USER)
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .password(dto.password())
                .build();

        return userRepository.save(user);
    }

    @Override
    public User login(LoginDto dto) {
        User user = userRepository.findByEmail(dto.email()).orElseThrow(() -> new RuntimeException("User not found!"));

        if (!user.getPassword().equals(dto.password())) {
            throw new RuntimeException("User credentials are not valid!");
         }

        return user;
    }

    @Override
    public User deleteById(Long id) {
        User user = getById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User updateById(Long id, UpdateDto dto) {
        User user = getById(id);

        if (Objects.nonNull(dto.email())) {
            user.setEmail(dto.email());
        }

        if (Objects.nonNull(dto.password())) {
            user.setPassword(dto.password());
        }

        if (Objects.nonNull(dto.firstName())) {
            user.setFirstName(dto.firstName());
        }

        if (Objects.nonNull(dto.lastName())) {
            user.setLastName(dto.lastName());
        }

        return userRepository.save(user);
    }
}
