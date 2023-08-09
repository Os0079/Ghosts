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
    private String filePath = "";
    
    public DecoyGhost()
    {
        super("Decoy", true, null);
    }
    
    public String getFilePath()
    {
        return filePath;
    }
}
