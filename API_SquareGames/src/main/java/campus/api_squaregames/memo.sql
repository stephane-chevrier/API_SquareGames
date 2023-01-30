-- creation base si elle n'existe pas
# CREATE DATABASE IF NOT EXISTS square_games;

-- suppression table si elle existe
# DROP TABLE IF EXISTS square_games.game;

-- creation de la table si elle n'existe pas
CREATE TABLE IF NOT EXISTS square_games.game (
                                                 id             int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                                 board_size     int,
                                                 uuid           varchar(50),
    game_status    varchar(20)
    );

-- test de creation d'un enregistrement
# INSERT INTO
# 	square_games.game (board_size, uuid, game_status)
# 	VALUES (3,'f1966786-6451-4780-b074-f4534798c739','ONGOING');