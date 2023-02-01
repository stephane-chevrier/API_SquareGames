package campus.api_squaregames.controleur;

import campus.api_squaregames.dtoweb.GameDtoWeb;
import campus.api_squaregames.service.GameServicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class GameControllerPersistence {

    // Creation de l'objet gameServicePersistence
    @Autowired
    GameServicePersistence gameServicePersistence;

    /**
     * method de sauvegarde d'une partie
     * @param
     */
    @PostMapping(value = "/addgame")
    public void sauveGame(@RequestBody GameDtoWeb gameDtoWeb) throws SQLException {
        gameServicePersistence.setGameDtoPersistence(gameDtoWeb);
    }

    /**
     * method de sauvegarde d'un tokken
     * @param
     */
    @PostMapping(value = "/addtoken")
    public void sauveToken(@RequestBody GameDtoWeb gameDtoWeb) throws SQLException {
        gameServicePersistence.setTokenDtoPersistence(gameDtoWeb);
    }


//    @GetMapping(value = "/gamelist")
//    public ArrayList<GameEntity> getGameList(@RequestBody GameGetListByStatus gameGetListByStatus) throws SQLException {
//        return gameServicePersistence.getGameGetListByStatus(gameGetListByStatus);
//    }
}
