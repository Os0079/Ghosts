/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class DecoyGhost extends Ghost
{
    private boolean moved;

    public DecoyGhost(Coordinates coords, String filePath, Board board)
    {
        super("GOOD", coords, filePath, board);
        moved = false;
    }
}
