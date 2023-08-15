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
    private Coordinates coords;
    private String file_path;
    public Board board;
    
    
    public Ghost(String ghostType, Coordinates coords, String file_path, Board board) 
    {
        this.ghostType = ghostType;
        this.coords = coords;
        this.file_path = file_path;
        this.board = board;
        
    }

    public String getGhostType() {
        return ghostType;
    }

    public void setGhostType(String ghostType) {
        this.ghostType = ghostType;
    }

    public Coordinates getCoords() {
        return coords;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }
    
    public boolean canMove(int Xdestination, int Ydestination)
    {
        return false;
    }
    
    public String getFilePath()
    {
        return file_path;
    }
    
    public void setFilePath(String path)
    {
        this.file_path = path;
    }
    
}
