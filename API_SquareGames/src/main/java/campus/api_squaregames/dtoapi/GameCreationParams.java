package campus.api_squaregames.dtoapi;

/**
 * Nom             GameCreationParams
 * Description     Paramètres de creation d'un jeu
 * @version v1.0
 * Date            12 décembre 2022
 * @author Stéphane CHEVRIER
 */

public class GameCreationParams {

    // creation des variables d'instances
    private String gameType;
    private int playerCount;
    private int boardSize;

    /**
     * Getter du gameType
     * @return
     */
    public String getGameType() {
        return gameType;
    }

    /**
     * Getter du playerCount
     * @return int
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * Getter du boardSize
     * @return
     */
    public int getBoardSize() {
        return boardSize;
    }
}
