package football.spring.service;

import football.spring.model.Stadium;
import java.util.List;

public interface StadiumService {
    Stadium add(Stadium stadium);

    Stadium get(Long id);

    List<Stadium> getAll();
}
