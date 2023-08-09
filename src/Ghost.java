/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public abstract class Ghost
{
    private String ghostType;
    private boolean alive;
    private Coordinates coords;

    public Ghost(String ghostType, boolean alive, Coordinates coords) 
    {
        this.ghostType = ghostType;
        this.alive = alive;
        this.coords = coords;
    }

    public String getGhostType() {
        return ghostType;
    }

    public void setGhostType(String ghostType) {
        this.ghostType = ghostType;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Coordinates getCoords() {
        return coords;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }
    
    
    public abstract String getFilePath();
}
