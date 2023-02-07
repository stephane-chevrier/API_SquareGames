package campus.api_squaregames.dtopersistencee;

import jakarta.persistence.*;

/**
 * The type Tokken dto persistence.
 */
@Entity
//@Table(name="toto")
public class TokenDtoPersistence {

    // Creation des variables d'instances correspondantes à la table
    // Clef de la table generee automatiquement
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long idToken;
    // creation de la clef etrangere en lien avec la table game(parties)
    @ManyToOne @JoinColumn(name="uuidgame", nullable=false)
    private GameDtoPersistence gameDtoPersistence;
    private String name;
    private int positionX;
    private int positionY;

    /**
     * Gets game dto persistence.
     *
     * @return the game dto persistence
     */
    public GameDtoPersistence getGameDtoPersistence() {
        return gameDtoPersistence;
    }

    /**
     * Sets game dto persistence.
     *
     * @param gameDtoPersistence the game dto persistence
     */
    public void setGameDtoPersistence(GameDtoPersistence gameDtoPersistence) {
        this.gameDtoPersistence = gameDtoPersistence;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets position x.
     *
     * @return the position x
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Sets position x.
     *
     * @param positionX the position x
     */
    public void setPositionX(int x) {
        this.positionX = x;
    }

    /**
     * Gets position y.
     *
     * @return the position y
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Sets position y.
     *
     * @param positionY the position y
     */
    public void setPositionY(int y) {
        this.positionY = y;
    }
}

