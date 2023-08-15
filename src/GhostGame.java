/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class GhostGame
{
    //Atributes
    private int GameScore;
    private String enemyPlayer;
    private boolean won;
    private String description;
    private Difficulty difficulty;
    private String gameType;
    
    // Constructor
    public GhostGame(String enemigo, boolean gano, Difficulty diff, String gameType) 
    {
        GameScore = 3;
        enemyPlayer = enemigo;
        won = gano;
        difficulty = diff;
        this.gameType = gameType;
    }

    
    // Gets
    public int getGameScore() {
        return GameScore;
    }

    public String getEnemyPlayer() {
        return enemyPlayer;
    }

    public boolean isWon() {
        return won;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    
    
    
    
}
