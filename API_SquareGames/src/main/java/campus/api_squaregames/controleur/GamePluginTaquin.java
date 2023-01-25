package campus.api_squaregames.controleur;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class GamePluginTaquin implements GamePlugin {

    // Creation propriete name avec une valeur par défaut definie dans le fichier application.properties
    @Value("${Taquin.name}")
    private String name;

    // Creation propriete defaultPlayerCount avec une valeur par défaut definie dans le fichier application.properties
    @Value("${Taquin.defaultPlayerCount}")
    private int defaultPlayerCount;

    // Creation objet GameFactory
    private GameFactory gameFactory = new TaquinGameFactory();

    /**
     * Methode de recuperation de GameFactory
     * @return int
     */
    @Override
    public GameFactory getGameFactory() {
        return gameFactory;
    }

    /**
     * Methode de recuperation du nombre de joueurs par defaut
     * @return int
     */
    @Override
    public int getDefaultPlayerCount() {
        return this.defaultPlayerCount;
    }

    /**
     * Methode de recuperation du nom
     * @param
     * @return String name
     */
    @Override
    public String getName() {
        return name;
    }

}