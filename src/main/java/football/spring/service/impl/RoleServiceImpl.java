package football.spring.service.impl;

import football.spring.dao.RoleDao;
import football.spring.exception.DataProcessingException;
import football.spring.model.Role;
import football.spring.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleDao.getByName(roleName).orElseThrow(() ->
                new DataProcessingException("Can't get role by name " + roleName));
    }
}
