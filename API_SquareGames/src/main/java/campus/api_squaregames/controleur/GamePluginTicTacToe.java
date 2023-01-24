package campus.api_squaregames.controleur;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class GamePluginTicTacToe implements GamePlugin {

    @Value("TicTacToe")
    public String name;

    @Value("${TicTacToe.defaultPlayerCount}")
    private int defaultPlayerCount;

    private GameFactory gameFactory = new TicTacToeGameFactory();

    @Override
    public GameFactory getGameFactory() {
        return gameFactory;
    }

    /**
     * Methode de recuperation du nombre de joueurs par defaut
     * @return int
     */
    public int getDefaultPlayerCount() {
        return this.defaultPlayerCount;
    }

//    /**
//     * Methode de recuperation de la bonne GameFactory
//     * @return
//     */
//    @Override
//    public GameFactory getGameFactory() {
//        return new TicTacToeGameFactory();
//    }

    /**
     * Methode de recuperation du nom
     * @param locale
     * @return String name
     */
    @Override
    public String getName(Locale locale) {
        return name;
    }

}
