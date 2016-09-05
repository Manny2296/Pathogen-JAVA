package aplicacion;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.w3c.dom.ranges.RangeException;

/**
 *
 * @author Manuel Phelipe- Daniel Ayala
 */
public class Juego implements Dibujable,Serializable{
	 /**
	 * Constantes para la localizacion de una imagen, para utilizar en el metodo  getImagenColor
     */
    public static final int IMGNIVEL1=0;
    public static final int IMGNIVEL2=1;
    public static final int IMGNIVEL3=2;
    public static final int IMGDESTRUCTOR=3;
    
    private Tablero tablero;
    private Jugador[] jugadores;
    private Maquina maquina;
    private int turnoJugador,totalTurnos,modoJuego;
    private boolean ilimito;
    private static ManagerDatos manager = new ManagerDatos();
   private boolean lastaction;
   /**
  	 * Constructore de la clase Juego
  	 * @param filas: filas del tablero
  	 * @param columnas: columnas del tablero
  	 * @param nombres : arreglo de los nombres de los jugadores
  	 * @param colores : arreglo de colores de los virus de los jugadores
  	 * @param totalturnos : cantidad de turnos del juego
  	 * @param ilimitado : booleano para saber si es ilimitado los turnos
  	 */
    public Juego(int filas,int columnas,String[] nombres,Color[] colores,int totalTurnos){
        this.tablero = new Tablero(filas, columnas);
        this.jugadores = new Jugador[nombres.length];
        this.turnoJugador = 0;
        this.totalTurnos = totalTurnos;
        this.modoJuego = 0;
        this.ilimito = false;
        crearJugadores(nombres,colores);
    }
    /**
  	 * Constructore de la clase Juego
  	 * @param filas: filas del tablero
  	 * @param columnas: columnas del tablero
  	 * @param nombre : nombre del  jugador
  	 * @param color : color del virus del jugador
  	 * @param maquina : Maquina oponente
  	 * @param totalturnos: cantidad de turnos del juego
  	 */
  
    public Juego(int filas,int columnas,String nombre,Color color,Maquina maquina, int totalTurnos){
        this.tablero = new Tablero(filas, columnas);
        this.jugadores = new Jugador[1];
        this.maquina = maquina;
        this.turnoJugador = 0;
        this.totalTurnos = totalTurnos;
        this.modoJuego = 1;
        this.ilimito = false;
        jugadores[0] = new Jugador(nombre, color);
    }
    /**
  	 * Constructore de la clase Juego
  	 * @param filas: filas del tablero
  	 * @param columnas: columnas del tablero
  	 * @param nombres : nombres de  jugadores
  	 * @param colores : color del virus del jugador
  	 */
    
    public Juego(int filas,int columnas,String[] nombres,Color[] colores) {
        this.tablero = new Tablero(filas, columnas);
        this.jugadores = new Jugador[nombres.length];
        this.turnoJugador = 0;
        this.modoJuego = 0;
        this.ilimito = true;
        crearJugadores(nombres,colores);
    }
    /**
  	 * Constructore de la clase Juego
  	 * @param filas: filas del tablero
  	 * @param columnas: columnas del tablero
  	 * @param nombre : nombre del  jugador
  	 * @param color : color del virus del jugador
  	 * @param maquina : Maquina oponente
  	 * @param totalturnos: cantidad de turnos del juego
  	 */
  
    public Juego(int filas,int columnas,String nombre,Color color,Maquina maquina) {
        this.tablero = new Tablero(filas, columnas);
        this.jugadores = new Jugador[1];
        this.maquina = maquina;
        this.turnoJugador = 0;
        this.modoJuego = 1;
        this.ilimito = true;
        jugadores[0] = new Jugador(nombre, color);
    }
    
    /**
   	 
   	 * @return tablero
   	 */
    
    public Tablero getTablero() {
        return tablero;
    }
    /**
   	 
   	 * @param tablero : tablero a modificar
   	 */
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    /**
   	
   	 * @return jugadores
   	 */
    public Jugador[] getJugadores() {
        return jugadores;
    }
    /**
   	
   	 * @param jugadores : Arreglo de jugadores a modificar
   	 */ 
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
    /**
   	 
   	 * @return turnojugador
   	 */
    public int getTurnoJugador() {
        return turnoJugador;
    }
    /**
   
   	 * @param turnoJugador : modificador de turnos
   	 */
    public void setTurnoJugador(int turnoJugador) {
        this.turnoJugador = turnoJugador;
    }
    /**
   
   	 * @return maquina
   	 */
    public Maquina getMaquina() {
		return maquina;
	}
    /**
   
   	 * @param maquina
   	 */
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	/**
   	
   	 * @return totalTurnos
   	 */
	public int getTotalTurnos() {
		return totalTurnos;
	}
	/**
   
   	 * @param totalTurnos : modificador de turnos
   	 */
	public void setTotalTurnos(int totalTurnos) {
		this.totalTurnos = totalTurnos;
	}
	/**
  
   	 * @return modoJuego
   	 */
	public int getModoJuego() {
		return modoJuego;
	}
	/**
 
   	 * @param modoJuego : modificador modoJuego
   	 */
	public void setModoJuego(int modoJuego) {
		this.modoJuego = modoJuego;
	}
	/**
   	 
   	 * @return ilimito
   	 */
	public boolean isIlimito() {
		return ilimito;
	}
	/**
   
   	 * @param ilimito : modificador booleano
   	 */
	public void setIlimito(boolean ilimito) {
		this.ilimito = ilimito;
	}
	
	public boolean lastAction(){
	    	return lastaction;
	    }
	/**
   	 
   	 * @return getJugadores()[getTurnoJugador()]
   	 */
	public Jugador getJugadorEnJuego()
    {
        return getJugadores()[getTurnoJugador()];
    }
	/**
   	 * Metodo de la clase que crea los jugadores segun el tamaño del arreglo de jugadores
   	 * @param nombres : nombre de los jugadores  
   	 * @param colores: color de los virus del jugador
   	 */
    private void crearJugadores(String[] nombres, Color[] colores) {
        
        for (int i = 0; i < getJugadores().length; i++) {
            jugadores[i]=new Jugador(nombres[i],colores[i]);
        }
        lastaction = true;
    }
    /**
   	
   	 * @return ImageIcon
   	 */
    
    public ImageIcon getImagenColor(Color color,int imagen)
    {
        if(color.equals(Color.BLUE))
        {
            switch(imagen)
            {
                case IMGNIVEL1:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulNivel1.png"));
                }
                case IMGNIVEL2:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulNivel2.png"));
                }
                case IMGNIVEL3:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulNivel3.png"));
                }
                case IMGDESTRUCTOR:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulDestructor.png"));
                }
            }
        }
        if(color.equals(Color.RED))
        {
            switch(imagen)
            {
                case IMGNIVEL1:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoNivel1.png"));
                }
                case IMGNIVEL2:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoNivel2.png"));
                }
                case IMGNIVEL3:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoNivel3.png"));
                }
                case IMGDESTRUCTOR:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoDestructor.png"));
                }
            }
        }
        if(color.equals(Color.YELLOW))
        {
            switch(imagen)
            {
                case IMGNIVEL1:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloNivel1.png"));
                }
                case IMGNIVEL2:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloNivel2.png"));
                }
                case IMGNIVEL3:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloNivel3.png"));
                }
                case IMGDESTRUCTOR:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloDestructor.png"));
                }
            }
        }
        if(color.equals(Color.GREEN))
        {
            switch(imagen)
            {
                case IMGNIVEL1:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeNivel1.png"));
                }
                case IMGNIVEL2:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeNivel2.png"));
                }
                case IMGNIVEL3:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeNivel3.png"));
                }
                case IMGDESTRUCTOR:
                {
                    return new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeDestructor.png"));
                }
            }
        }
        return null;
    }
    
    // metodo para saber si un turno esta en el rango, se utiliza la excepcion RangoException
    public static void rangoTrunos(int turnos) throws RangoException
    {
    	if(turnos<2)
    	{
    		throw new RangoException("El numero de turnos tiene que ser mayor a dos");
    	}
    }
    
    // metodo para saber si la fila y columnas estan en el rango, se utiliza la excepcion RangoException
    public static void rangoFilyCol(int filas,int columnas) throws RangoException
    {
    	if((filas<2||filas>10)||(columnas<2||columnas>10))
		{
			throw new RangoException("Las filas y/o columnas no estan en el rango");
		}
    }
    
    
    /**
   	 * Metodo implementado de la interfaz Dibujable
   	 */
   
    @Override
    public void dibujar(Graphics g) {
        
        getTablero().dibujar(g);
    }
    /**
   	 * Metodo de la clase para saber cual es el siguiente jugador
   	 * por medio de el atributo turno 
   	 * @return el turno del jugador
   	 */
    public int nextJugador() {
        
    	switch(getModoJuego())
    	{
    	case 0:
        	if(getTurnoJugador()+1<getJugadores().length)
        	{
        		setTurnoJugador(getTurnoJugador()+1);
        		return getTurnoJugador();
        	}
        	else
        	{
        		setTurnoJugador(0);
        		return getTurnoJugador();
        	}
		case 1:
			return 0;
    		
    	}
    	return 0;
    }
    
    
    /**
   	 * Metodo para saber si el tablero esta lleno para saber si finalizar la partida o no
   	 * @return True: esta lleno False : No esta lleno
   	 */
    public boolean tableroLleno()
    {
    	for (int i = 0; i < getTablero().getFilas(); i++) {
			for (int j = 0; j < getTablero().getColumnas(); j++) {
				if(getTablero().getCasillas()[i][j].getVirus()==null)
				{
					return false;
				}
			}
		}
    	return true;
    }
    /**
   	 * Metodo dar ganador 
   	 * @return el nombre del jugador que ha ganado ya se maquina o usuario
    */
    
   
	public String darGanador() {
		
		if(getModoJuego()==0)
		{
			if(getJugadores()[0].getTotalVirus()==getJugadores()[1].getTotalVirus())
			{
				return "Empate";
			}
			else if(getJugadores()[0].getTotalVirus()>getJugadores()[1].getTotalVirus())
			{
				return "El ganador es "+getJugadores()[0].getNombre();
			}
			else
			{
				return "El ganador es "+getJugadores()[1].getNombre();
			}
		}
		else
		{
			if(getJugadores()[0].getTotalVirus()==getMaquina().getTotalVirus())
			{
				return "Empate";
			}
			else if(getJugadores()[0].getTotalVirus()>getMaquina().getTotalVirus())
			{
				return "El ganador es "+getJugadores()[0].getNombre();
			}
			else
			{
				return "El ganador es "+getMaquina().getNombre();
			}
		}
	}
	/**
   	 * Metodo para guardar el tablero
   	 * @param ruta: ruta del tablero
   	 */
	
	public boolean guardarTablero(String ruta)
	{
		return manager.guardarTablero(this, ruta);
	}
	/**
   	 * Metodo para cargar el tablero
   	 * @param ruta: ruta del tablero
   	 */
	
	public Tablero cargarTablero(String ruta)
	{
		return manager.cargarTablero(this, ruta);
	}
	/**
   	 * Metodo para guardar el estado
   	 * @param ruta: ruta del tablero
   	 */
	//
	public boolean guardarEstado(String ruta)
	{
		return manager.guardarEstado(this,ruta);
	}
	/**
   	 * Metodo para cargar el estado
   	 * @param ruta: ruta del tablero
   	 */
	public static Juego cargarEstado(String ruta)
	{
		return manager.cargarEstado(ruta);
	}
    
    
}
