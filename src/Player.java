
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */



public class Player 
{
    // Atributes
    private String username;
    private String password;
    private int playerScore;
    private boolean loggedIn;
    private GhostGame[] gameReports;

    // Contructor
    public Player(String username, String password)
    {
        this.username = username;
        this.password = password;
        playerScore = 0;
        gameReports = new GhostGame[10];
        loggedIn = false;
    }
    
    // Gets & Sets

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore)
    {
        this.playerScore+= playerScore;
    }

    public GhostGame[] getGameReports() 
    {
        return gameReports;
    }

    public void addGameReport(GhostGame game)
    {
        for (int i = 0; i < gameReports.length ; i++)
        {
            if (gameReports[i] == null)
            {
                gameReports[i] = game;
                break;
            } else
            {
                for (int j = gameReports.length - 1 ; j > 0; j--) 
                {
                    gameReports[j] = gameReports[j - 1];
                }
                gameReports[0] = game;
                break;
            }
        }
        
        
        System.out.println("Games: " + Arrays.toString(gameReports));
        
    }
    
    
    
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    
    
    
}
