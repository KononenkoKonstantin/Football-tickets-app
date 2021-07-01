package football.spring.controller;

import football.spring.service.AuthenticationService;
import football.spring.service.GameService;
import football.spring.service.RoleService;
import football.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectController {
    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final RoleService roleService;
    private final GameService gameService;

    public InjectController(UserService userService, AuthenticationService authenticationService,
                            RoleService roleService, GameService gameService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.roleService = roleService;
        this.gameService = gameService;
    }

    @GetMapping("/inject")
    public String injectData() {

        return "Done!!!";
    }
}
