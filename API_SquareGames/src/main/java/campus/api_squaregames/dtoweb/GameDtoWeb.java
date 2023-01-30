package campus.api_squaregames.dtoweb;

import fr.le_campus_numerique.square_games.engine.GameStatus;

import java.util.UUID;

    public class GameDtoWeb {

    // création des variables d'instance
    private long id;

    private GameStatus gameStatus;
    private UUID uuid;
    private int BoardSize;

    public int getBoardSize() {
        return BoardSize;
    }

    public void setBoardSize(int boardSize) {
        BoardSize = boardSize;
    }

    /**
     * Setter de gameStatus
     * @param gameStatus
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    /**
     * Setter de uuid
     * @param uuid
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter de gameStatus
     */
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     * Getter de uuid
     */
    public UUID getUuid() {
        return uuid;
    }


}
