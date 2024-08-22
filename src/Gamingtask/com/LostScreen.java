package Gamingtask.com;

import java.sql.SQLException;
import java.util.Scanner;

public class LostScreen {
    private String username;

    public LostScreen(String username) {
        this.username = username;
    }

    public void showScreen() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Play Again");
        System.out.println("2. View History");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                new GamePlayScreen(username).startGame();
                break;
            case 2:
                new HistoryScreen(username).showHistory();
                break;
            case 3:
                System.out.println("You have successfully exited.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showScreen();
        }
        sc.close();
    }
}
