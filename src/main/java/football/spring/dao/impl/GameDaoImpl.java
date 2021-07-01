package football.spring.dao.impl;

import football.spring.dao.AbstractDao;
import football.spring.dao.GameDao;
import football.spring.model.Game;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl extends AbstractDao<Game> implements GameDao {
    public GameDaoImpl(SessionFactory factory) {
        super(factory, Game.class);
    }
}
