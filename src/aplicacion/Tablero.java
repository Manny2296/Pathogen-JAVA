package aplicacion;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Manuel Phelipe-Daniel Ayala
 */
public class Tablero implements Dibujable,Serializable{
	 /**
	 * Atributos de la clase 
	*/
    private Casilla[][] casillas;
    private Casilla casillaSelec;
    private int filas,columnas;
    /**
   	 * Constructor de Tablero
   	 * @param filas : cantidad de filas del tablero
   	 * @param columnas : cantidad de columnas del tablero
   	 */
    public Tablero(int filas,int columnas) {
        this.casillas = new Casilla[filas][columnas];
        this.filas = filas;
        this.columnas = columnas;
        crearCasillas();
    }
    /**
   	 * Metodo Poner Virus : El tablero pone un Virus en la fila y columna que recibe
   	 * @param fila: fila a poner el virus
   	 * @param columna : columna a poner el virus
   	 * @param virus : Virus que se pone en el tablero
   	 * 
   	 */
    
    public void ponerVirus(int fila,int columna,Virus virus)
    {
        casillas[fila][columna].setVirus(virus);
    }
    /**
   
   	 * @return casillas
   	 */
    public Casilla[][] getCasillas() {
        return casillas;
    }
    /**
   	 
   	 * @param casillas : modificador de casillas
   	 */

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
    /**
   	 
   	 * @return casillaSelec
   	 */
    public Casilla getCasillaSelec() {
        return casillaSelec;
    }
    /**
   	 
   	 * @param casillaSelec : modificador de casillas seleccionadas
   	 */
    public void setCasillaSelec(Casilla casillaSelec) {
        this.casillaSelec = casillaSelec;
    }
    /**
   
   	 * @return filas
   	 */
    public int getFilas() {
        return filas;
    }
    /**
  
   	 * @param filas : modificador de filas del tablero
   	 */
    public void setFilas(int filas) {
        this.filas = filas;
    }
    /**
   	
   	 * @return columnas
   	 */
    public int getColumnas() {
        return columnas;
    }
    /**
  
   	 * @param columnas : modificador de columnas del tablero
   	 */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    /**
   	 * Metodo privado de la clase crearCasillas
   	 * crea las casillas del tablero segun el numero de filas y columnas del mismo
   	 */
    private void crearCasillas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                getCasillas()[i][j]=new Casilla(new Point(i, j));
            }
        }
    }
    /**
   	 * Metodo estaLibre
   	 * @param fila: fila a consultar
   	 * @param columna :columna a consultar
   	 * @return Si la casilla generada por la fila y la columna esta vacia o no 
   	 */
    public boolean estaLibre(int fila,int columna)
    {
        return getCasillas()[fila][columna].getVirus()==null;
    }
    /**
   	 * Metodo implementado de la interfaz
   	 */
    @Override
    public void dibujar(Graphics g) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                getCasillas()[i][j].dibujar(g);
            }
        }
    }
}
