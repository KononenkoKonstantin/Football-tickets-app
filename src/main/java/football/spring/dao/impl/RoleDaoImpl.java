package football.spring.dao.impl;

import football.spring.dao.AbstractDao;
import football.spring.dao.RoleDao;
import football.spring.exception.DataProcessingException;
import football.spring.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(Role.RoleName roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Role r where r.roleName = :role", Role.class)
                    .setParameter("role", roleName)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Not found role " + roleName + " ", e);
        }
    }
}
