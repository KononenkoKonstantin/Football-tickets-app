package football.util;

import football.model.Role;
import football.model.User;
import football.service.RoleService;
import football.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ROLE_ADMIN);
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.ROLE_USER);
        roleService.add(userRole);

        User adminUser = new User();
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword("1234");
        adminUser.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_ADMIN)));
        userService.add(adminUser);

        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("1111");
        user.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_USER)));
        userService.add(user);
    }
}
