/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class GoodGhost extends Ghost
{
    private String filePath = "C:\\Users\\smnsl\\OneDrive\\Documentos\\NetBeansProjects\\Programacion2_Ghosts\\Images\\GoodGhost.png";
    
    public GoodGhost() {
        super("Good", true, null);
    }
    
    public String getFilePath()
    {
        return filePath;
    }
    
}
