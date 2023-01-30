package campus.api_squaregames.dtopersistencee;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface GameDtoPersistenceRepository extends CrudRepository<GameDtoPersistence, Long> {

    List<GameDtoPersistence> findByBoardSizeGreaterThan(int boardSize);
}
