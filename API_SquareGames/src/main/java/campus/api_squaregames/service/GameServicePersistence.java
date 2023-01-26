package campus.api_squaregames.service;

import campus.api_squaregames.daopersistence.GameDao;
import campus.api_squaregames.daopersistence.GameDaoMySql;
import campus.api_squaregames.dtopersistencee.*;
import org.springframework.stereotype.Service;

/**
 * The type Game service persistence.
 */
@Service
public class GameServicePersistence {

//    public GameEntity gameEntity = new GameEntity();  // Pourquoi pas de Pb de compilation, il existe deja !


    /**
     * Sets game entity.
     *
     * @param gameDtoPersistence the game dto persistence
     */
    public void setGameEntity(GameDtoPersistence gameDtoPersistence) {
        GameDao gameDao = new GameDaoMySql();
        gameDao.addGamePersistence(gameDtoPersistence);
    }
}
