package presentacion;

import aplicacion.Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import static presentacion.FrmJuego.pnlTablero;

/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  
public class FrmDatosFinal extends JFrame{
	
	
	/**
	 *
	 * Constructor del Frame
	 */
	public FrmDatosFinal(Juego juego)
	{
		
		this.setTitle("Datos finales");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new Pnlfinal(juego));
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
	
	}
	

		
		
	
	
	
}
