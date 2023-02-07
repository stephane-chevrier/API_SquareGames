package campus.api_squaregames.controleur;

import campus.api_squaregames.dtoweb.GameCreationParams;
import campus.api_squaregames.dtoweb.GameDtoWeb;
import campus.api_squaregames.dtoweb.GamePartDtoWeb;
import campus.api_squaregames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Nom             GameController
 * Description     Controleur de jeux
 * @version v1.0
 * Date            20 janvier 2023
 * @author Stéphane CHEVRIER
 */
@RestController
public class GameController {

    // initialisation du chemin racine de gamestats
    @Value("url.racine.gameStats")
    private String urlRacineGameStats;

    // initialisation chemin gamepart de gamestats
    @Value("url.gamepart.gameStats")
    private String urlGamePartGameStats;

    // initialisation chemin info de gamestats
    @Value("url.info.gameStats")
    private String urlInfoGameStats;

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

    /**
     * Gets game part.
     *
     * @param gameId the game id
     * @return the game part
     */
    @GetMapping("/gamepart/{gameId}/info")
    public Object getGamePart(@PathVariable("gameId") int gameId) {

        // initialisation de l'url de la requete envoyee a l'API_GameStats
//        String url = urlRacineGameStats+urlGamePartGameStats+"/"+gameId+urlInfoGameStats;
        String url = "http://localhost:8080/gamepart/6/info";
        RestTemplate restTemplate = new RestTemplate();
//        Object objet = restTemplate.getForObject(url, Object.class);
        Object gamePartDtoWeb = restTemplate.getForObject(url, Object.class);
        return  gamePartDtoWeb;
    }
}
