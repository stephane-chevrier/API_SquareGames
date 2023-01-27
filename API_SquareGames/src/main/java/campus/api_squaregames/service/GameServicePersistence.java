package campus.api_squaregames.service;

import campus.api_squaregames.daopersistence.GameDao;
import campus.api_squaregames.daopersistence.GameDaoMySql;
import campus.api_squaregames.dtopersistencee.*;
import campus.api_squaregames.entity.GameEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public void setGameDtoPersistence(GameDtoPersistence gameDtoPersistence) throws SQLException {

        // creation de l'objet DaoPersistence de type Sql
        GameDao gameDao = new GameDaoMySql();


        gameDao.addGamePersistence(gameDtoPersistence);
    }

    /**
     * Gets game get list by status.
     *
     * @param gameGetListByStatus the game get list by status
     * @return the game get list by status
     * @throws SQLException the sql exception
     */
    public ArrayList<GameEntity> getGameGetListByStatus(GameGetListByStatus gameGetListByStatus) throws SQLException {
        GameDao gameDao = new GameDaoMySql();
        ArrayList<GameReturnGetListByStatus> gameReturnGetListByStatuses;
        ArrayList<GameEntity> gameEntities = new ArrayList<>();
        gameReturnGetListByStatuses = gameDao.getGameListPersistence(gameGetListByStatus);
        GameEntity gameEntity = new GameEntity();
        for (int i=0; i<gameReturnGetListByStatuses.size(); i++) {
            gameEntity.setBoardSize(gameReturnGetListByStatuses.get(i).getBoardSize());
            gameEntity.setUuid(gameReturnGetListByStatuses.get(i).getUUID());
            gameEntity.setGameStatus(gameReturnGetListByStatuses.get(i).getStatus());
            gameEntities.add(gameEntity);
        }

        return gameEntities;
    }
}
