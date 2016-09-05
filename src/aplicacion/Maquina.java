package aplicacion;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.Random;

public class Maquina implements Serializable{

	/**
   	 * Atributos de la clase
   	 */
	private String nombre;
	private int nivel,totalVirus;
	private Color color;
	private Virus virus;
	
	/**
   	 * Constructor Maquina
   	 * @param nombre : nombre de la maquina
   	 * @param color : color del virus
   	 */
	public Maquina(String nombre,int nivel,Color color) {
		this.nombre = nombre;
		this.nivel = nivel;
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
   	
   	 * @return nivel
   	 */
	public int getNivel() {
		return nivel;
	}
	/**
   	 
   	 * @param nivel : modificador nivel
   	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
   	
   	 * @return totalVirus
   	 */
	public int getTotalVirus() {
		return totalVirus;
	}
	/**
   	
   	 * @param totalVirus : modificador total de virus
   	 */
	public void setTotalVirus(int totalVirus) {
		this.totalVirus = totalVirus;
	}
	/**
   	
   	 * @return color
   	 */
	public Color getColor() {
		return color;
	}
	/**
   	
   	 * @param color : modificador de color
   	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
   	 
   	 * @return virus
   	 */
	public Virus getVirus() {
		return virus;
	}
	/**

   	 * @param virus : modificador de virus
   	 */
	public void setVirus(Virus virus) {
		this.virus = virus;
	}
	/**
   	 * Metodo poner virus : Pone un virus en el tablero actual en una pocision aleatoria
   	 * @param tablero: tablero donde se pone el virus
   	 * @return True : Si la casilla encontrada esta vacia o si hay un virus del mismo color en la casilla
   	 * @return buscarCasillalibre: Si no encuentra la casilla al salir del while
   	 */

	public boolean ponerVirus(Tablero tablero)
	{
		Random ran = new Random();
		int fila,columna;
		int cont = 0;
		switch (getNivel()) {
		case 0:
			while(cont<=10)
			{
				fila = ran.nextInt(tablero.getFilas());
				columna = ran.nextInt(tablero.getColumnas());
				if(tablero.getCasillas()[fila][columna].getVirus()==null)
				{
					getVirus().setPunto(new Point(fila,columna));
					getVirus().infectar(tablero);
					return true;
				}
				else if(tablero.getCasillas()[fila][columna].getVirus().getColor().equals(getVirus().getColor())||tablero.getCasillas()[fila][columna].getVirus().getColor().equals(Color.GRAY))
				{
					if(tablero.getCasillas()[fila][columna].getVirus().getNivel()<=getVirus().getNivel())
					{
						getVirus().setPunto(new Point(fila,columna));
						getVirus().infectar(tablero);
						return true;
					}
				}
				else
				{
					cont++;
				}
			}
			return buscarCasillaLibre(tablero);
		case 1:
			while(cont<=10)
			{
				fila = ran.nextInt(tablero.getFilas());
				columna = ran.nextInt(tablero.getColumnas());
				if(tablero.getCasillas()[fila][columna].getVirus()==null)
				{
					getVirus().setPunto(new Point(fila,columna));
					getVirus().infectar(tablero);
					return true;
				}
				else if(tablero.getCasillas()[fila][columna].getVirus().getNivel()<=getVirus().getNivel())
				{
					getVirus().setPunto(new Point(fila,columna));
					getVirus().infectar(tablero);
					return true;
				}
				else
				{
					cont++;
				}
			}
			return buscarCasillaLibre(tablero);
		case 2:
			while(cont<=10)
			{
				fila = ran.nextInt(tablero.getFilas());
				columna = ran.nextInt(tablero.getColumnas());
				if(tablero.getCasillas()[fila][columna].getVirus()==null)
				{
					getVirus().setPunto(new Point(fila,columna));
					getVirus().infectar(tablero);
					return true;
				}
				else if(tablero.getCasillas()[fila][columna].getVirus().getColor().equals(getVirus().getColor())||tablero.getCasillas()[fila][columna].getVirus().getColor().equals(Color.GRAY))
				{
					if(tablero.getCasillas()[fila][columna].getVirus().getNivel()<=getVirus().getNivel())
					{
						getVirus().setPunto(new Point(fila,columna));
						getVirus().infectar(tablero);
						return true;
					}
				}
				else
				{
					cont++;
				}
			}
			return buscarCasillaLibre(tablero);
		
		}
		return false;
	}
	/**
   	 * Metodo buscar casilla libre 
   	 * @param tablero : busca una casilla libre en el tablero para poner el virus
   	 * @return True : encontro False : No encontro
   	 */

	private boolean buscarCasillaLibre(Tablero tablero) {
		
		for (int i = 0; i < tablero.getFilas(); i++) {
			for (int j = 0; j < tablero.getColumnas(); j++) {
				if(tablero.getCasillas()[i][j].getVirus()==null)
				{
					getVirus().setPunto(new Point(i,j));
					getVirus().infectar(tablero);
					return true;
				}
			}
		}
		
		return false;
	}
	
	
}
