package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import aplicacion.Juego;
import aplicacion.VirusEvolutivo;
import static presentacion.FrmJuego.pnlTablero;

/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  
public class PnlCasilla extends JPanel{
	/**
	 *  Atributo punto para saber en que posicion esta la casilla
	 *  Atributo juego para ir actualizando el estado del juego
	 */
	private Juego juego;
	private Point punto;
	/**
	*Constructor del panel
	*/
	  
	public PnlCasilla(Juego juego,Point punto)
	{
		this.juego = juego;
		this.punto = punto;
		this.setBackground(new Color(25, 25 ,112));
		this.setBorder(new LineBorder(Color.BLACK));
		this.setSize(new Dimension(20,20));
	    
		
		// se llama al metodo adicionarListener para que cada casilla escuche el mouse
		adicionarListener(this);
	}

	private void adicionarListener(PnlCasilla pnlCasilla) {
		
		pnlCasilla.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				// se llama al virus del jugador en juego, y se le asigna el punto de la casilla
				juego.getJugadorEnJuego().getVirusSelec().setPunto(punto);
					if(juego.getJugadorEnJuego().getVirusSelec().getNivel()==0)
					{
						if(juego.getTablero().getCasillas()[punto.x][punto.y].getVirus()!=null)
						{
							// se llama al virus del jugador en juego, y se le asigna el punto al virus destructor
							juego.getJugadorEnJuego().getVirusSelec().setNivel(juego.getTablero().getCasillas()[punto.x][punto.y].getVirus().getNivel());
						}
					}
					// el virus del jugador hace el efecto de infectar, y si se realizó, devuelve true
	                if(juego.getJugadorEnJuego().getVirusSelec().infectar(juego.getTablero()))
	                {
	                	juego.setTotalTurnos(juego.getTotalTurnos()-1);
	                	switch(juego.getModoJuego())
	                	{
	                	case 0:
		                    juego.setTurnoJugador(juego.nextJugador());
		                    juego.getJugadorEnJuego().setVirusSelec(new VirusEvolutivo(1, juego.getJugadorEnJuego().getColor()));
		                    pnlTablero.repaint();
		                    PnlDatosTablero.cargarValores();
		                    PnlJugadores.cambiarJugador();
		                    break;
	                	case 1:
	                		juego.getMaquina().setVirus(new VirusEvolutivo(1, juego.getMaquina().getColor()));
	                		juego.getMaquina().ponerVirus(juego.getTablero());
	                		juego.getJugadorEnJuego().setVirusSelec(new VirusEvolutivo(1, juego.getJugadorEnJuego().getColor()));
	                		pnlTablero.repaint();
	                		PnlDatosTablero.cargarValores();
	                		break;
	                	}
	                	
	                	if(juego.tableroLleno())
		                {
		                	JOptionPane.showMessageDialog(null,"Se acabo el juego");
		                	pnlTablero.cerrar();
		                	new FrmDatosFinal(juego).setVisible(true);
		                }
	                	else if(juego.getTotalTurnos()==0)
	                	{
	                		JOptionPane.showMessageDialog(null,"Se acabo el juego");
		                	pnlTablero.cerrar();
		                	new FrmDatosFinal(juego).setVisible(true);
	                	}
	                }
			}
		});
	}
	/**
   	 * Pinta el virus de ese punto del tablero, si este existe
   	 */			
	@Override
    public void paint(Graphics g) {
		
        super.paint(g);
        g.drawImage(new ImageIcon(getClass().getResource("/presentacion/imagenes/fondoespacio.png")).getImage(), 0, 0, getSize().width,getSize().height,null);
		this.setOpaque(false);
        if(juego.getTablero().getCasillas()[punto.x][punto.y].getVirus()!=null)
        { 
            juego.getTablero().getCasillas()[punto.x][punto.y].getVirus().setDimension(this.getSize());
            juego.getTablero().getCasillas()[punto.x][punto.y].dibujar(g);
        }
       
		
       
    }

}
