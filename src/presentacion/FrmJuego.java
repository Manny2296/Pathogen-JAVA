package presentacion;

import aplicacion.Juego;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  
public class FrmJuego extends JFrame{
	 /**
 *  Atributo para pintar todo el tablero en cada click y utilizarlo en otras clases
 */
	
	public static PnlTablero pnlTablero;
	 /**
		 *Constructor del Frame Juego 
		 */
	public FrmJuego(Juego juego)
	{
		pnlTablero = new PnlTablero(this,juego);
		this.setTitle("Pathogen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new PnlJugadores(juego), BorderLayout.WEST);
		this.getContentPane().add(pnlTablero, BorderLayout.CENTER);
		this.getContentPane().add(new PnlOpciones(this,juego), BorderLayout.EAST);
		this.getContentPane().add(new PnlDatosTablero(juego), BorderLayout.NORTH);
		PnlDatosTablero.cargarValores();
		this.pack();
		this.setSize(new Dimension(900,750));
		this.setLocationRelativeTo(null);
		
	}

}
