package campus.api_squaregames.dtopersistencee;

import fr.le_campus_numerique.square_games.engine.GameStatus;

/**
 * The type Game get list by status.
 */
public class GameGetListByStatus {

    private GameStatus gameStatus;

    /**
     * Gets game status.
     *
     * @return the game status
     */
    public String getGameStatus() {
        return gameStatus.toString();
    }

    /**
     * Sets game status.
     *
     * @param gameStatus the game status
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
