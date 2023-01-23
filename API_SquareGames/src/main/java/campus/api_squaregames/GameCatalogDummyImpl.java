package campus.api_squaregames;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

/**
 * Nom             GameCatalogDummyImpl
 * Description     Implementation de l'interface GameCatalog
 * @version v1.0
 * Date            19 janvier 2023
 * @author Stéphane CHEVRIER
 */

@Service
public class GameCatalogDummyImpl implements GameCatalog {

    /**
     * Methode de recuperation des identifiants des 3 jeux
     * @return
     */
    @Override
    public Map<String, GameFactory> getGameIdentifiers() {
        Map<String, GameFactory> factories = Stream.of(
                        new TicTacToeGameFactory(),
                        new TaquinGameFactory(),
                        new ConnectFourGameFactory())
                .collect(Collectors.toUnmodifiableMap(GameFactory->GameFactory.getGameId(), Function.identity()));
        return factories;
    }
}

