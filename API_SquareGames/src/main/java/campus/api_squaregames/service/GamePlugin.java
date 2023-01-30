package campus.api_squaregames.service;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import java.util.Locale;

public interface GamePlugin {

    String getName();

    GameFactory getGameFactory();

    int getDefaultPlayerCount();

}
