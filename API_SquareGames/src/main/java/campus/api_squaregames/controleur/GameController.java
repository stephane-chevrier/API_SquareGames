package campus.api_squaregames.controleur;

import campus.api_squaregames.dtoweb.GameCreationParams;
import campus.api_squaregames.dtoweb.GameDtoWeb;
import campus.api_squaregames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Nom             GameController
 * Description     Controleur de jeux
 * @version v1.0
 * Date            20 janvier 2023
 * @author Stéphane CHEVRIER
 */
@RestController
public class GameController {

    // création de l'objet gameService
   @Autowired
   private GameService gameService;

    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    @PostMapping(value = "/games")
    public GameDtoWeb createGame(@RequestBody GameCreationParams gameCreationParams, @RequestHeader("Accept-language") String langage) {

        GameDtoWeb gameDtoWeb = gameService.getGamePart(gameService.createGameService(gameCreationParams, langage));
        // Appel du service de creation d'une partie et retour des attributs de Game necessaires
        return gameDtoWeb;
    }
    /**
     * method de creation d'une partie
     * @param
     * @return Object
     */
    @GetMapping("/games/{gameId}/status")
    public Object getGameStatus(@PathVariable("gameId") int gameId) {
        // Appel du service de retour du status d'une partie à partie de son Id et retour de ce status
        return gameService.getGameStatusService(gameId);
    }

}
