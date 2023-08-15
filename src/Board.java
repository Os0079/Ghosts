

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class Board extends JPanel
{
    private Container contents;
    
    // Componentes
    private JButton[][] squares = new JButton[6][6];
    
    // Colores
    private Color colorBlack = Color.BLACK;
    
    private int row = 5, col = 1;
    private ImageIcon icon = new ImageIcon("C:\\Users\\smnsl\\OneDrive\\Documentos\\NetBeansProjects\\Programacion2_Ghosts\\Images\\GoodGhost.png");
    
    
    public Board()
    {
       
        contents.setLayout(new GridLayout(6, 6));
        
        // Handlers
        ButtonHandler buttonHandler = new ButtonHandler();
        
        
        // Board components
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                squares[i][j] = new JButton();
                if ( (i + j ) % 2 != 0 ) 
                {
                    squares[i][j].setBackground(colorBlack);
                }
                contents.add(squares[i][j]);
                squares[i][j].addActionListener(buttonHandler);
            }
        }
        squares[row][col].setIcon(icon);
        
        // size y display
        setSize(700, 680);
        setVisible(false);
    }
    
    public boolean isValidMove(int i, int j)
    {
        int rowDelta = Math.abs(i - row);
        int colDelta = Math.abs(j - col);
        
        if ((rowDelta == 1) && (colDelta == 2) ) 
        {
            return true;
        }
        if ((colDelta == 1) && (rowDelta == 2))
        {
            return true;
        }
        return false;
    }
    
    public class ButtonHandler implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            Object source = e.getSource();
            
            for (int i = 0; i < 6; i++)
            {
                for (int j = 0; j < 6; j++)
                {
                    if ( source == squares[i][j] ) 
                    {
                        processClick( i, j );
                        return;
                    }
                }
            }
        }
        
    }
    
    public void processClick(int i, int j)
    {
        if ( isValidMove(i,j) == false )
        {
            return;
        }
        squares[row][col].setIcon(null);
        squares[i][j].setIcon(icon);
        row = i; col = j; 
    }
    
    
    
}
