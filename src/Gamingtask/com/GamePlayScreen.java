package Gamingtask.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class GamePlayScreen {
	private static int coins = 21;
	private String username;

	public GamePlayScreen(String username) {
		this.username = username;
	}

	public void startGame() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		while (coins > 1) {
			System.out.println("Coins left: " + coins);
			System.out.println("Pick 1, 2, 3, or 4: ");
			int playerPick = sc.nextInt();
			if (playerPick < 1 || playerPick > 4) {
				System.out.println("Invalid choice, please choose between 1 and 4.");
				continue;
			}

			coins -= playerPick;

			if (coins == 1) {
				System.out.println("AI WINS! You are forced to pick the last coin.");
				saveGame("lost");
				new LostScreen(username).showScreen();
				return;
			}

			int aiPick = (coins - 1) % 5;
			if (aiPick == 0) {
				aiPick = 1;
			}

			coins -= aiPick;
			System.out.println("AI picked " + aiPick + " coins.");

			if (coins == 1) {
				System.out.println("You win! AI is forced to pick the last coin.");
				saveGame("win");
				new LostScreen(username).showScreen();
				return;
			}
		}
	}

	private void saveGame(String result) throws SQLException {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gameuser", "root", "admin")) {
			String query = "INSERT INTO game_History (username, result, coins_left) VALUES (?, ?, ?)";
			try (PreparedStatement pstmt = con.prepareStatement(query)) {
				pstmt.setString(1, username);
				pstmt.setString(2, result);
				pstmt.setInt(3, coins);
				pstmt.executeUpdate();
			}
		}
	}
}
