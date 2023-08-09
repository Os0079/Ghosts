/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public enum Difficulty
{

    NORMAL(8), EXPERT(4), GENIUS(2);
    
    int ghostNumber;

    private Difficulty(int diff)
    {
        ghostNumber = diff;
    }
    
    
    
}
