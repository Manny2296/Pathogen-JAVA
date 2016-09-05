package aplicacion;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Manuel Phelipe-Daniel Ayala
 */
public class VirusEvolutivo extends Virus{
	 /**
   	 * Constructor de la clase
   	 * @param nivel : nivel del virus
   	 * @param color : color del virus 
   	 */
    public VirusEvolutivo(int nivel, Color color) {
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
        
                
    }
    /**
   	 * Metodo abstracto implementado de la clase Virus
   	 * se encarga de reproducirse mirando si la casiila esta vacia y si no lo esta mira el virus que esta en la misma
   	 * @param tablero :tablero donde se infecta el virus
   	 * @return si logro infectar el tablero , de acuerdo a las condiciones de expansion del nivel y del mismo color
   	 *  
   	 */
    @Override
    public boolean infectar(Tablero tablero) {       
        
        if(!tablero.estaLibre(this.getPunto().x,this.getPunto().y))
        {
            Virus virusCasilla = tablero.getCasillas()[this.getPunto().x][this.getPunto().y].getVirus();
            
            if(virusCasilla.getColor().equals(this.getColor()))
            {    
                if(virusCasilla.getNivel()<=this.getNivel())
                {
                    Point puntoReferencia = this.getPunto();
                    virusCasilla.setNivel(virusCasilla.getNivel()+1);
                    
                    if(puntoReferencia.x-1>=0)
                    {
                        VirusEvolutivo virusNuevo = new VirusEvolutivo(virusCasilla.getNivel()-1, this.getColor());
                        virusNuevo.setPunto(new Point(puntoReferencia.x-1,puntoReferencia.y));
                        virusNuevo.infectar(tablero);
                    }
                    if(puntoReferencia.y-1>=0)
                    {
                        VirusEvolutivo virusNuevo = new VirusEvolutivo(virusCasilla.getNivel()-1, this.getColor());
                        virusNuevo.setPunto(new Point(puntoReferencia.x,puntoReferencia.y-1));
                        virusNuevo.infectar(tablero);
                    }
                    if(puntoReferencia.x+1<=tablero.getFilas()-1)
                    {
                        VirusEvolutivo virusNuevo = new VirusEvolutivo(virusCasilla.getNivel()-1, this.getColor());
                        virusNuevo.setPunto(new Point(puntoReferencia.x+1,puntoReferencia.y));
                        virusNuevo.infectar(tablero);
                    }
                    if(puntoReferencia.y+1<=tablero.getColumnas()-1)
                    {
                        VirusEvolutivo virusNuevo = new VirusEvolutivo(virusCasilla.getNivel()-1, this.getColor());
                        virusNuevo.setPunto(new Point(puntoReferencia.x,puntoReferencia.y+1));
                        virusNuevo.infectar(tablero);
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(virusCasilla.getNivel()<=this.getNivel())
                {
                    tablero.getCasillas()[this.getPunto().x][this.getPunto().y].setVirus(this);
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
           tablero.getCasillas()[this.getPunto().x][this.getPunto().y].setVirus(this);
        }
        return true;
    }
}
