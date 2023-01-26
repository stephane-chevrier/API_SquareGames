package campus.api_squaregames.controleur;

import campus.api_squaregames.dtopersistencee.*;
import campus.api_squaregames.service.GameServicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public void SauveGame(@RequestBody GameDtoPersistence gameDtoPersistence) {
        gameServicePersistence.setGameEntity(gameDtoPersistence);
    }
}
