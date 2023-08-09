/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class Game
{
    //Atributes
    private int GameScore;
    private String enemyPlayer;
    private boolean won;
    private String description;
    
    
    // Constructor
    public Game(int puntaje, String enemigo, boolean gano) 
    {
        GameScore = puntaje;
        enemyPlayer = enemigo;
        won = gano;
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
    
    
    
    
}
