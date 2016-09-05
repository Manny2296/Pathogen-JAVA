package aplicacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Manuel Phelipe- Daniel Ayala
 */

public abstract class Virus implements Dibujable,Serializable{
	 /**
	* Atributos de la clase abstracta
    */
    private int nivel;
    private String nombre;
    private Point punto;
    private Dimension dimension;
    private ImageIcon imagen;
    private Color color;
    /**
   	 * Constructor de la clase abstracta 
   	 * @param nivel : nivel del virus
   	 * @param color : color del virus 
   	 */
    public Virus(int nivel, Color color) {
        this.nivel = nivel;
        this.color = color;
        establecerImagen();
    }
    /**
   	 * Constructor de la clase abstracta 
   	 * @param color : color del virus 
   	 */
    public Virus(Color color) {
        this.nivel = 0;
        this.color = color;
        establecerImagen();
    }
    /**
   	 * Metodo estatico para crear Virus por medio del dato y el color
   	 * @param dato :  letra del virus
   	 * @param color : color del virus 
   	 */
    
    public static Virus crearVirus(String dato,Color color)
    {
        switch(dato)
        {
            case "U":{return new VirusEvolutivo(1,color);}
            case "D":{return new VirusEvolutivo(2,color);}
            case "T":{return new VirusEvolutivo(3,color);}
            case "B":{return new VirusEvolutivo(4,color);}
            case "U_":{return new VirusNeutral(1,color);}
            case "D_":{return new VirusNeutral(2,color);}
            case "T_":{return new VirusNeutral(3,color);}
            case "B_":{return new VirusNeutral(4,color);}
        }
        return null;
    }
    /**
 
   	 * @return nivel
   	 */
    public int getNivel() {
        return nivel;
    }
    /**
   
   	 * @param nivel : modificador del nivel 
   	 */
    public void setNivel(int nivel) {
        this.nivel = nivel;
        if(getNivel()==2)
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
        establecerImagen();
    }
    /**
   	 
   	 * @return nombre
   	 */
    public String getNombre() {
        return nombre;
    }
    /**
   
   	 * @param nombre : modificador del nombre 
   	 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
   	 
   	 * @return punto
   	 */
    public Point getPunto() {
        return punto;
    }
    /**
   	 
   	 * @param punto : modificador del punto 
   	 */
    public void setPunto(Point punto) {
        this.punto = punto;
    }
    /**
   	
   	 * @return dimension
   	 */
    public Dimension getDimension() {
        return dimension;
    }
    /**
   	 
   	 * @param dimension : modificador del dimension 
   	 */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
    /**
   
   	 * @return imagen
   	 */
    public ImageIcon getImagen() {
        return imagen;
    }
    /**
   	 
   	 * @param imagen : modificador de la imagen 
   	 */
    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }
    /**
 
   	 * @return color
   	 */
    public Color getColor() {
        return color;
    }
    /**
   	
   	 * @param setColor : modificador de Color
   	 */
    public void setColor(Color setColor) {
        this.color = color;
        establecerImagen();
    }
    /**
   	 * Metodo abstracto infectar : este metodo es el encargado de reproducirse
   	 * funciona distinto segun el nivel
   	 */
    public abstract boolean infectar(Tablero tablero);
    /**
   	 * Metodo privado de la clase abstracta : establecerImagen
   	 * Establece la imagen del virus segun el color elegido y el nivel del virus
   	 */
    private void establecerImagen() {
        
        if(getColor().equals(Color.BLUE))
        {
            switch(getNivel())
            {
                case 0:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulDestructor.png")));    
                    break;
                }
                case 1:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulNivel1.png")));
                    break;
                }
                case 2:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulNivel2.png")));
                    break;
                }
                case 3:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulNivel3.png")));
                    break;
                }
                case 4:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AzulBloque.png")));
                    break;
                }
            }
        }
        else if(getColor().equals(Color.RED))
        {
            switch(getNivel())
            {
                case 0:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoDestructor.png")));    
                    break;
                }
                case 1:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoNivel1.png")));
                    break;
                }
                case 2:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoNivel2.png")));
                    break;
                }
                case 3:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoNivel3.png")));
                    break;
                }
                case 4:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/RojoBloque.png")));
                    break;
                }
            }
        }
        else if(getColor().equals(Color.YELLOW))
        {
            switch(getNivel())
            {
                case 0:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloDestructor.png")));    
                    break;
                }
                case 1:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloNivel1.png")));
                    break;
                }
                case 2:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloNivel2.png")));
                    break;
                }
                case 3:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloNivel3.png")));
                    break;
                }
                case 4:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/AmarilloBloque.png")));
                    break;
                }
            }
        }
        else if(getColor().equals(Color.GREEN))
        {
            switch(getNivel())
            {
                case 0:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeDestructor.png")));
                    break;
                }
                case 1:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeNivel1.png")));
                    break;
                }
                case 2:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeNivel2.png")));
                    break;
                }
                case 3:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeNivel3.png")));
                    break;
                }
                case 4:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/VerdeBloque.png")));
                    break;
                }
            }
        }
        else if(getColor().equals(Color.GRAY))
        {
            switch(getNivel())
            {
                case 1:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/NeutralNivel1.png")));
                    break;
                }
                case 2:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/NeutralNivel2.png")));
                    break;
                }
                case 4:
                {
                    setImagen(new ImageIcon(getClass().getResource("/presentacion/imagenes/NeutralBloque.png")));
                    break;
                }
            }
        }
    }
    /**
   	 * Metodo implementado de la interfaz dibujable
   	 */
    @Override
    public void dibujar(Graphics g) {
        
        g.drawImage(getImagen().getImage(),0,0,getDimension().width,getDimension().height,null);
    }  
}