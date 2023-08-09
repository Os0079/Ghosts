
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class Logger
{
    //Atributes
    private ArrayList<Player> players;
    
    // Constructor    ---- Inicializa el ArrayList de los jugadores
    public Logger()
    {
        players = new ArrayList<>();
    }
    
    // Gets 
    public ArrayList<Player> getPlayers() 
    {
        return players;
    }

    // Sets

    
    
    // Funciones
    
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    
    public Player search(String username)
    {
        for (Player p: players)
        {
            if (p != null && p.getUsername().equals(username)) 
            {
                return p;
            }
        }
        return null;
        
    }
    
    
    public boolean login(String username, String password) 
    {
        Player p = search(username);
        
        if (p != null)
        {

            if ( password.equals(p.getPassword() ) )
            {
                return true;
            }

        }
        return false;
    }
    
    
    public Player getLoggedInPlayer() //posible recursiva?
    {
        for (Player player : players) {
            if (player.isLoggedIn())
            {
                return player;
            }
        }
        return null;
    }
    public void listPlayers()
    {
        String data = "------ Lista de jugadores ------\n";
        
        for (Player p : players)
        {
            data += "Jugador: " + p.getUsername() + "\tLogged In: " + p.isLoggedIn() + "\n";
        }
        
        System.out.println(data);
    }
}
