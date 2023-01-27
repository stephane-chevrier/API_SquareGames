package campus.api_squaregames.dtopersistencee;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface GameDtoPersistenceRepository extends CrudRepository<GameDtoPersistence, Long> {
}
