package aplicacion;

import java.awt.Color;

/**
 *
 * @author Manuel Phelipe-Daniel Ayala
 */
public class VirusNeutral extends Virus{
 private boolean lastaction;
 /**
	 * Constructor de la clase
	 * @param nivel : nivel del virus
	 * @param color : color del virus 
	 */
    public VirusNeutral(int nivel, Color color) {
        super(nivel, color);
        if(getNivel()==1)
        {
            setNombre("U");
        }
        else if(getNivel()==2)
        {
            setNombre("D");
        }
        else if(getNivel()==3)
        {
            setNombre("T");
        }
        else
        {
            setNombre("B");
        }
        lastaction = true;
    }
    
    
    
    
    public boolean lastAction(){
    	return lastaction;
    }
    /**
   	 * Metodo abstracto implementado de la clase Virus
   	 * se encarga de reproducirse mirando si la casiila esta vacia y si no lo esta mira el virus que esta en la misma
   	 *  
   	 */
    @Override
    public boolean infectar(Tablero tablero) {
        return true;
    }
}
