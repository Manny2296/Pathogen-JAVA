package presentacion;

import aplicacion.Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  
public class PnlTablero extends JPanel{
	/**
	*Atributos del panel
	*Arraylist de pnlcasillas para llenar el panel con paneles casilla
	*/
	  
	public ArrayList<PnlCasilla> pnlCasillas;
	private FrmJuego frmJuego;
	private Juego juego;
	/**
	*Constructor del panel 
	*/
	  
	public PnlTablero(FrmJuego frmJuego,Juego juego)
	{
		this.frmJuego = frmJuego;
		this.juego = juego;
		this.pnlCasillas = new ArrayList<PnlCasilla>();
		this.setLayout(new GridLayout(juego.getTablero().getFilas(),juego.getTablero().getColumnas()));
		rellenarTablero();
	}
	/**
    * Rellena el Panel tablero con Paneles casillas segun el tamaño de filas * columnas
	*/
	  
	public void rellenarTablero() {
		
		for (int i = 0; i < juego.getTablero().getFilas(); i++) {
			for (int j = 0; j < juego.getTablero().getColumnas(); j++) {
				PnlCasilla pnlCas = new PnlCasilla(juego,new Point(i,j));
				pnlCasillas.add(pnlCas);
				this.add(pnlCas);
			}
		}
	}
	/**
	*Se llama el paint de la clase JPanel, para pintar cada una de las casillas q estan en su lista
	*/
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        for (PnlCasilla pnlCasila : pnlCasillas) {
            pnlCasila.repaint();
            
    		
        }
        
    }
	/**
	 * Se utiliza para hacer la pregunta al jugador si desea volver a juagr si se llena el tablero
    */
	
	public void preguntarVolverAJugar()
	{
		if(JOptionPane.showConfirmDialog(null,"¿Desea volver a jugar?","Volver a jugarr",0)==JOptionPane.OK_OPTION)
		{
			frmJuego.setVisible(false);;
			new FrmInicio().setVisible(true);
		}
		else
		{
			System.exit(0);
		}
	}
	public void cerrar()
	{
		frmJuego.setVisible(false);
	}
}
