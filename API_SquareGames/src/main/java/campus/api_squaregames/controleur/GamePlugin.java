package campus.api_squaregames.controleur;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;

import java.util.Locale;

public interface GamePlugin {

    String getName(Locale locale);

    GameFactory getGameFactory();

    int getDefaultPlayerCount();

}
