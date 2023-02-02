package campus.api_squaregames.dtopersistencee;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameDtoPersistenceRepository extends CrudRepository<GameDtoPersistence, Long> {

    List<GameDtoPersistence> findByBoardSizeGreaterThan(int boardSize);

}
