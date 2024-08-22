package Gamingtask.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HistoryScreen {
    private String username;

    public HistoryScreen(String username) {
        this.username = username;
    }

    public void showHistory() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameuser", "root", "admin");
             Statement stmt = con.createStatement()) {

            String query = "SELECT * FROM game_History WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Game history for " + username + ":");
            while (rs.next()) {
                System.out.println("Result: " + rs.getString("result") + ", Coins left: " 
                        + rs.getInt("coins_left") + ", Date played: " + rs.getTimestamp("date_played"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        new LostScreen(username).showScreen();
    }
}
