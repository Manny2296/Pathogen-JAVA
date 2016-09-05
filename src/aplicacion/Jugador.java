package aplicacion;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import aplicacion.Tablero;
import aplicacion.Virus;

/**
 *
 * @author Manuel Phelipe-Daniel Ayala
 */
public class Jugador implements Serializable{
	/**
   	 * Atributos de la clase 
   	 */
    private String nombre;
    private Virus virusSelec;
    private int totalVirus;
    private Color color;
    private boolean lastaction;
    /**
   	 * Constructor de la clase 
   	 * @param nombre : nombre del jugador
   	 * @param color : color del virus 
   	 */
    public Jugador(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
        this.totalVirus = 0;
    }
    /**
   	
   	 * @return nombre
   	 */

    public String getNombre() {
        return nombre;
    }
    /**
   	 
   	 * @param nombre : modificador nombre
   	 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
   	 
   	 * @return virusSelec
   	 */
    public Virus getVirusSelec() {
        return virusSelec;
    }
    /**
   	 
   	 * @param virusSelec : modificador virusseleccionado
   	 */
    public void setVirusSelec(Virus virusSelec) {
        this.virusSelec = virusSelec;
    }
   
    public boolean lastAction(){
    	return lastaction;
    }
    /**
   	
   	 * @return totalVirus
   	 */
    public int getTotalVirus() {
        return totalVirus;
    }
    /**
   	
   	 * @param porcentaje : modificador total de virus
   	 */
    public void setTotalVirus(int porcentaje) {
        this.totalVirus = porcentaje;
    }
    /**
   	 
   	 * @return color
   	 */
    public Color getColor() {
        return color;
    }
    /**
   	
   	 * @return color
   	 */
    public void setColor(Color color) {
        this.color = color;
    }
    /**
   	 * Metodo ponervirus : Pone un virus en el tablero en la posicion de la fila y la columna
   	 * @param tab : Tablero del jugador
   	 * @param fila: fila en la que se podra el virus
   	 * @param columna: columna en la que se pondra el virus
   	 */
    public void ponerVirus(Tablero tab,int fila,int columna)
    {
        tab.ponerVirus(fila,columna,getVirusSelec());
        lastaction = true;
    }
    
}
