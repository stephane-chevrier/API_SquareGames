package campus.api_squaregames.dtopersistencee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SingletonConnexion {

    // Creation instance de la class SingletonConnexion
    private static SingletonConnexion instance;

    /**
     * Constructeur
     */
    private SingletonConnexion() {
    }

    /**
     * Fonction getInstance qui renvoie un objet unique de la classe
     *
     * @return SingletonConnexion
     */
    public static SingletonConnexion getInstance() {
        if (instance == null) {
            instance = new SingletonConnexion();
        }
        return instance;
    }

    /**
     * initialisation des variables
     */
    private Connection connexion;         // Connection est un objet de java.sql
    private static String url = "jdbc:mysql://localhost:6603/square_games";
    private static String user = "root";
    private static String mdp = "helloworld";

    /**
     * methode de creation de la connexion si elle n'existe pas
     * @return Connection
     */
    public Connection getConnexion() throws SQLException {
        if (connexion==null || connexion.isClosed()) {
            connexion = DriverManager.getConnection(url,user,mdp);
        }
        return connexion;
    }
}