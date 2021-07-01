package football.spring.service;

import football.spring.model.Game;
import java.util.List;

public interface GameService {
    Game add(Game game);

    Game get(Long id);

    List<Game> getAll();
}
