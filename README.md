## Gaming Task
    MySQL JDBC driver
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameuser", "root", "admin")

 ### CREATE DATABASE gameuser;
`USE gameuser;
CREATE TABLE gameuser (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL
);`

`CREATE TABLE game_History (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    result VARCHAR(255) NOT NULL,
    coins_left INTEGER NOT NULL,
    date_played DATETIME DEFAULT CURRENT_TIMESTAMP
);`

`INSERT INTO gameuser (username, PASSWORD) VALUES ('admin', 'admin1234');`
`INSERT INTO gameuser (username, PASSWORD) VALUES ('guest', 'guest1234');`

`INSERT INTO game_History (username, result, coins_left) VALUES ('admin', 'win', 1);`
`INSERT INTO game_History (username, result, coins_left) VALUES ('guest', 'lose', 1);`
