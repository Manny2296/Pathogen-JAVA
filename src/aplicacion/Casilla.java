package aplicacion;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import aplicacion.Dibujable;
import aplicacion.Virus;

/**
 *
 * @author Manuel Phelipe - Daniel Ayala
 */
public class Casilla implements Dibujable,Serializable{

    /**
	 * Atributos de la clase 
	 */
	private Virus virus;
    private Point punto;
    /**
   	 * Constructor de la clase Casilla
   	 * @param punto : punto de la casilla
   	 */
    public Casilla(Point punto)
    {
        this.punto = punto;
        this.virus = null;
    }
    /**
   	 
   	 * @return virus
   	 */
    public Virus getVirus() {
        return virus;
    }
    /**
   
   	 * @param virus : virus a modificar
   	 */
    public void setVirus(Virus virus) {
        this.virus = virus;
    }
    /**
   	 
   	 * @return punto
   	 */
    public Point getPunto() {
        return punto;
    }
    /**
   
   	 * @param punto :punto a modificar
   	 */
    public void setPunto(Point punto) {
        this.punto = punto;
    }
    /**
   	 * Metodo implementado de la interfaz Dibujable 
   	 */
    @Override
    public void dibujar(Graphics g) {
        
        if(getVirus()!=null)
        {
            getVirus().dibujar(g);
        }
    }
}
