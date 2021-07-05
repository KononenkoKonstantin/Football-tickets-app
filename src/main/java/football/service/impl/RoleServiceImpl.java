package football.service.impl;

import football.dao.RoleDao;
import football.model.Role;
import football.service.RoleService;
import football.exception.DataProcessingException;
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
