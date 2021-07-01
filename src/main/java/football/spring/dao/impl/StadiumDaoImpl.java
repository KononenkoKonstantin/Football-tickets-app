package football.spring.dao.impl;

import football.spring.dao.AbstractDao;
import football.spring.dao.StadiumDao;
import football.spring.model.Stadium;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StadiumDaoImpl extends AbstractDao<Stadium> implements StadiumDao {
    public StadiumDaoImpl(SessionFactory factory) {
        super(factory, Stadium.class);
    }
}
