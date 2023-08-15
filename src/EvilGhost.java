/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class EvilGhost extends Ghost
{
    private boolean moved;

    public EvilGhost(Coordinates coords, String filePath, Board board) 
    {
        super("EVIL", coords, filePath, board);
        moved = false;
    }
}
