/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class Board
{
    private final int rows = 6;
    private final int cols = 6;
    private Integer[][] BoardGrid;
    
    
    
    public void startGrid()
    {
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++)
            {
                BoardGrid[i][j] = 0;
            }
        }
    }
    
    
    
}
