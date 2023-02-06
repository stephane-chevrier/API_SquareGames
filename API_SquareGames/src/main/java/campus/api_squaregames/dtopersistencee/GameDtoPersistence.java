package campus.api_squaregames.dtopersistencee;

import fr.le_campus_numerique.square_games.engine.GameStatus;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Game dto persistence.
 */
@Entity
//@Table(name="toto")
public class GameDtoPersistence {

    // creation des champs de la table correspondante
    // declaration nécessaire a la creation de la clef etrangere dans la table TokkenDtoPersistence
    @OneToMany ( targetEntity=TokenDtoPersistence.class, mappedBy="gameDtoPersistence" )
    private List<TokenDtoPersistence> tokenDtoPersistence = new ArrayList<>();
    // clef de la table
    @Id
    private UUID uuidGame;
    private int boardSize;
    private String gameStatus;

    /**
     * Instantiates a new Game dto persistence.
     *
     * @param uuidGame   the uuid game
     * @param boardSize  the board size
     * @param gameStatus the game status
     */
    public GameDtoPersistence(UUID uuidGame, int boardSize, String gameStatus) {
        this.uuidGame = uuidGame;
        this.boardSize = boardSize;
        this.gameStatus = gameStatus;
    }

    /**
     * Instantiates a new Game dto persistence.
     */
    public GameDtoPersistence() {
    }

    /**
     * Sets game status.
     *
     * @param gameStatus the game status
     */
    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * Gets token dto persistence.
     *
     * @return the token dto persistence
     */
    public List<TokenDtoPersistence> getTokenDtoPersistence() {
        return tokenDtoPersistence;
    }

    /**
     * Sets token dto persistence.
     *
     * @param tokenDtoPersistence the token dto persistence
     */
    public void setTokenDtoPersistence(List<TokenDtoPersistence> tokenDtoPersistence) {
        this.tokenDtoPersistence = tokenDtoPersistence;
    }

    /**
     * Gets game status.
     *
     * @return the game status
     */
    public String getGameStatus() {
        return gameStatus;
    }

    /**
     * Sets game status.
     *
     * @param gameStatus the game status
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus.toString();
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public UUID getUuid() {
        return uuidGame;
    }

    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(UUID uuid) {
        this.uuidGame = uuid;
    }

    /**
     * Gets board size.
     *
     * @return the board size
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * Sets board size.
     *
     * @param boardSize the board size
     */
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
