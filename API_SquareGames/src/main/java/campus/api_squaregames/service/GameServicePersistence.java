package campus.api_squaregames.service;

import campus.api_squaregames.daopersistence.GameDao;
import campus.api_squaregames.daopersistence.GameDaoMySql;
import campus.api_squaregames.dtopersistencee.*;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The type Game service persistence.
 */
@Service
public class GameServicePersistence {

    /**
     * Sets game entity.
     *
     * @param gameDtoPersistence the game dto persistence
     */
    public void setGameEntity(GameDtoPersistence gameDtoPersistence) throws SQLException {
        GameDao gameDao = new GameDaoMySql();
        gameDao.addGamePersistence(gameDtoPersistence);
    }
}
