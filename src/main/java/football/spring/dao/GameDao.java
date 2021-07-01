package football.spring.dao;

import football.spring.model.Game;
import java.util.List;
import java.util.Optional;

public interface GameDao {
    Game add(Game game);

    Optional<Game> get(Long id);

    List<Game> getAll();
}
