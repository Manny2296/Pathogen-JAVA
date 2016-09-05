package aplicacion;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Manuel Phelipe -Daniel Ayala
 */
public class VirusDestructor extends Virus{
    private boolean lastaction;
    /**
   	 * Constructor de la clase
   	 * @param color : color del virus 
   	 */
    public VirusDestructor(Color color) {
        super(color);
        setNombre("De");
        lastaction = true;
    }
    public boolean lastAction(){
    	return lastaction;
    }
    /**
   	 * Metodo abstracto implementado de la clase Virus
   	 * se encarga de reproducirse mirando si la casiila esta vacia y si no lo esta mira el virus que esta en la misma
   	 * @param tablero : tablero donde infecta el virus
   	 */
    @Override
    public boolean infectar(Tablero tablero) {
    	
    	if(!tablero.estaLibre(this.getPunto().x,this.getPunto().y))
        {
            Virus virusCasilla = tablero.getCasillas()[this.getPunto().x][this.getPunto().y].getVirus();
            
            if(virusCasilla.getNivel()!=4)
            {
	            if(!virusCasilla.getColor().equals(this.getColor()))
	            {    
	                if(virusCasilla.getNivel()<=this.getNivel())
	                {
	                    Point puntoReferencia = this.getPunto();
	                    tablero.getCasillas()[puntoReferencia.x][puntoReferencia.y].setVirus(null);
	                    
	                    if(puntoReferencia.x-1>=0)
	                    {
	                        this.setPunto(new Point(puntoReferencia.x-1,puntoReferencia.y));
	                        this.infectar(tablero);
	                    }
	                    if(puntoReferencia.y-1>=0)
	                    {
	                    	this.setPunto(new Point(puntoReferencia.x,puntoReferencia.y-1));
	                        this.infectar(tablero);
	                    }
	                    if(puntoReferencia.x+1<=tablero.getFilas()-1)
	                    {
	                    	this.setPunto(new Point(puntoReferencia.x+1,puntoReferencia.y));
	                        this.infectar(tablero);
	                    }
	                    if(puntoReferencia.y+1<=tablero.getColumnas()-1)
	                    {
	                    	this.setPunto(new Point(puntoReferencia.x,puntoReferencia.y+1));
	                        this.infectar(tablero);
	                    }
	                }
	                else
	                {
	                    return false;
	                }
	            }
	            else
	            {
	                return false;
	            }
            }
            else
            {
            	return false;
            }
        }
        else
        {
        	return false;
        }
    	return true;
    } 
}
