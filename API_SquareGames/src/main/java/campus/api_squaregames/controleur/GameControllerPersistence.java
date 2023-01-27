package campus.api_squaregames.controleur;

import campus.api_squaregames.dtopersistencee.*;
import campus.api_squaregames.entity.GameEntity;
import campus.api_squaregames.service.GameServicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class GameControllerPersistence {

    // Creation de l'objet gameServicePersistence
    @Autowired
    GameServicePersistence gameServicePersistence = new GameServicePersistence();

    /**
     * method de sauvegarde d'une partie
     * @param
     */
    @PostMapping(value = "/addgame")
    public void sauveGame(@RequestBody GameDtoPersistence gameDtoPersistence) throws SQLException {
        gameServicePersistence.setGameDtoPersistence(gameDtoPersistence);
    }

//    @GetMapping(value = "/gamelist")
//    public ArrayList<GameEntity> getGameList(@RequestBody GameGetListByStatus gameGetListByStatus) throws SQLException {
//        return gameServicePersistence.getGameGetListByStatus(gameGetListByStatus);
//    }
}
