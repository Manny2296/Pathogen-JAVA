package aplicacion;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  
public class ManagerDatos implements Serializable{
	 /**
		 * Metodo guardar tablero
		 * @param juego juego del tablero a guardar
		 * @param ruta : ruta del tablero a guardar
		 */
	public boolean guardarTablero(Juego juego,String ruta)
    {
        File file = new File(ruta);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter br = new BufferedWriter(fw);
            String info = "";
            for (int i = 0; i < juego.getTablero().getColumnas(); i++) {
                info+="*";
            }
            info+="\r\n";
            for (int i = 0; i < juego.getTablero().getFilas(); i++) {
                info+="*";
                for (int j = 0; j < juego.getTablero().getColumnas()+1; j++) {
                    if(j==juego.getTablero().getColumnas())
                    {
                        info+="*\r\n";
                    }
                    else if(juego.getTablero().getCasillas()[i][j].getVirus()==null)
                    {
                        info+=" ";
                    }
                    //El operador instanceof sirve para conocer si un objeto es de un tipo determinado de virus eneste caso Neutral
                    else if(juego.getTablero().getCasillas()[i][j].getVirus() instanceof VirusNeutral)
                    {
                        info+=juego.getTablero().getCasillas()[i][j].getVirus().getNombre()+"_";
                    }
                    else
                    {
                        if(juego.getTablero().getCasillas()[i][j].getVirus().getColor().equals(juego.getJugadores()[0].getColor()))
                        {
                            info+=juego.getTablero().getCasillas()[i][j].getVirus().getNombre()+"1";
                        }
                        else
                        {
                            info+=juego.getTablero().getCasillas()[i][j].getVirus().getNombre()+"2";
                        }
                    }
                }
            }
            
            for (int i = 0; i <  juego.getTablero().getColumnas(); i++) {
                info+="*";
            }
            br.write(info);
            br.close();
            fw.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ManagerDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
	/**
	 * Metodo cargar tablero
	 * @param juego juego del tablero a cargar
	 * @param ruta : ruta del tablero a cargar
	 */
    
    public Tablero cargarTablero(Juego juego,String ruta)
    {
        Tablero tablero = null;
        File file = new File(ruta);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int filas=(int) br.lines().count()-2;
            br.close();
            fr.close();
            br = new BufferedReader(new FileReader(file));
            int columnas=br.readLine().length();
            br.close();
            fr.close();
            br = new BufferedReader(new FileReader(file));
            tablero = new Tablero(filas, columnas);
            int cont = 0;int cont2 = 0;
            while(br.ready())
            {                
                if(cont!=0||cont!=tablero.getFilas())
                {
                    String linea = br.readLine();
                    for (int i = 0; i < linea.length(); i++) {
                    	//IsLetter determina si el carácter especificado es una letra
                        if(Character.isLetter(linea.charAt(i)))
                        {     //Metodo charart devuelve un char y sirve para leer solo un caracter en un String 
                            if(linea.charAt(i+1)!='_')
                            {
                            	if(juego.getModoJuego()==0)
                            	{
	                                tablero.getCasillas()[cont-1][i-cont2-1].setVirus(Virus.crearVirus(""+linea.charAt(i), juego.getJugadores()[Integer.parseInt(""+linea.charAt(i+1))-1].getColor()));
	                                cont2++;
                            	}
                            	else
                            	{
                            		if(linea.charAt(i+1)=='1')
                            		{
                            			tablero.getCasillas()[cont-1][i-cont2-1].setVirus(Virus.crearVirus(""+linea.charAt(i), juego.getJugadores()[Integer.parseInt(""+linea.charAt(i+1))-1].getColor()));
    	                                cont2++;
                            		}
                            		else
                            		{
                            			tablero.getCasillas()[cont-1][i-cont2-1].setVirus(Virus.crearVirus(""+linea.charAt(i), juego.getMaquina().getColor()));
    	                                cont2++;
                            		}
                            	}
                            }
                            else
                            {
                                tablero.getCasillas()[cont-1][i-cont2-1].setVirus(Virus.crearVirus(""+linea.charAt(i)+linea.charAt(i+1), Color.GRAY));
                                cont2++;
                            }
                        }
                    }
                }
                cont++;
                cont2 = 0;
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(ManagerDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablero;
    }
    
    /**
	 * Metodo guardarEstado (Salvar)
	 * @param juego juego del tablero a salvar
	 * @param ruta : ruta del tablero a salvar
	 */
	public boolean guardarEstado(Juego juego,String ruta) {
 
			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(ruta));
				oos.writeObject(juego);
				oos.close();
				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		
	}
	 /**
		 * Metodo cargarEstado (Abrir)
		 * @param ruta : ruta del tablero a salvar
		 */
	public Juego cargarEstado(String ruta) {
		ObjectInputStream ois;
		Juego juego=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(ruta));
			juego=(Juego)ois.readObject();
			ois.close();
			return juego;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return juego;
		} catch (IOException e) {
			e.printStackTrace();
			return juego;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return juego;
		}
	}
}
