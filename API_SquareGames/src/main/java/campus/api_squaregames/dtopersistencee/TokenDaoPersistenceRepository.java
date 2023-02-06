package campus.api_squaregames.dtopersistencee;

import org.springframework.data.repository.CrudRepository;

/**
 * The interface Token dao persistence repository.
 */
public interface TokenDaoPersistenceRepository extends CrudRepository<TokenDtoPersistence, Long> {
}
