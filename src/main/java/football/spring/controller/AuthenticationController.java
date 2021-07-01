package football.spring.controller;

import football.spring.dto.request.UserRequestDto;
import football.spring.dto.response.UserResponseDto;
import football.spring.model.User;
import football.spring.service.AuthenticationService;
import football.spring.service.mapper.UserMapper;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;
    private static final Logger logger = LogManager.getLogger(AuthenticationController.class);

    public AuthenticationController(AuthenticationService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        logger.info("user with email={} registered", requestDto.getEmail());
        return userMapper.mapToDto(user);
    }
}
