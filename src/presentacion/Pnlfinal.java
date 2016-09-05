package presentacion;

import static presentacion.FrmJuego.pnlTablero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.Juego;

public class Pnlfinal extends JPanel {
	private Juego juego;
	public Pnlfinal(Juego juego)
	{
		this.juego = juego;
		this.setLayout(new GridLayout(8, 3));
		rellenarPanel();
	}
	/**
	 *
	 * Metodo privado para rellenar el panel del frame
	 * con los distintos componentes informando los resultados del juego
	 */

	private void rellenarPanel(){
		
		JLabel labnombres = new JLabel("Nombres:");
		labnombres.setForeground(Color.WHITE);
		JLabel labjugador1 = new JLabel(juego.getJugadores()[0].getNombre());
		labjugador1.setForeground(Color.WHITE);
		JLabel labjugador2;
		
		
		if(juego.getModoJuego()==0)
		{
			labjugador2 = new JLabel(juego.getJugadores()[1].getNombre());
			labjugador2.setForeground(Color.WHITE);
			
		}
		else
		{
			labjugador2 = new JLabel(juego.getMaquina().getNombre());
			labjugador2.setForeground(Color.WHITE);
		}
		
		this.add(labnombres); this.add(labjugador1);  this.add(labjugador2);
		
		JLabel labTotales = new JLabel("Total de virus:");
		labTotales.setForeground(Color.WHITE);
		JLabel labTotaljugador1 = new JLabel(""+PnlDatosTablero.totalVirus1);
		labTotaljugador1.setForeground(Color.WHITE);
		JLabel labTotaljugador2 = new JLabel(""+PnlDatosTablero.totalVirus2);
		labTotaljugador2.setForeground(Color.WHITE);
		
		this.add(labTotales); this.add(labTotaljugador1);  this.add(labTotaljugador2);
		
		JLabel labTotalesPor = new JLabel("Virus en porcentaje:");
		labTotalesPor.setForeground(Color.WHITE);
		JLabel labTotaljugador1Por = new JLabel(""+PnlDatosTablero.porcentajeVirus1+"%");
		labTotaljugador1Por.setForeground(Color.WHITE);
		JLabel labTotaljugador2Por = new JLabel(""+PnlDatosTablero.porcentajeVirus2+"%");
		labTotaljugador2Por.setForeground(Color.WHITE);
		
		this.add(labTotalesPor); this.add(labTotaljugador1Por);  this.add(labTotaljugador2Por);
		
		JLabel labTotalesNiv1 = new JLabel("Total de virus nivel 1:");
		labTotalesNiv1.setForeground(Color.WHITE);
		JLabel labTotaljugador1Niv1 = new JLabel(""+PnlDatosTablero.VirusNIvel1_1);
		labTotaljugador1Niv1.setForeground(Color.WHITE);
		JLabel labTotaljugador2Niv1 = new JLabel(""+PnlDatosTablero.VirusNIvel1_2);
		labTotaljugador2Niv1.setForeground(Color.WHITE);
		
		this.add(labTotalesNiv1); this.add(labTotaljugador1Niv1);  this.add(labTotaljugador2Niv1);
		
		JLabel labTotalesNiv2 = new JLabel("Total de virus nivel 2:");
		labTotalesNiv2.setForeground(Color.WHITE);	
		JLabel labTotaljugador1Niv2 = new JLabel(""+PnlDatosTablero.VirusNIvel2_1);
		labTotaljugador1Niv2.setForeground(Color.WHITE);
		JLabel labTotaljugador2Niv2 = new JLabel(""+PnlDatosTablero.VirusNIvel2_2);
		labTotaljugador2Niv2.setForeground(Color.WHITE);
		
		this.add(labTotalesNiv2); this.add(labTotaljugador1Niv2);  this.add(labTotaljugador2Niv2);
		
		JLabel labTotalesNiv3 = new JLabel("Total de virus nivel 3:");
		labTotalesNiv3.setForeground(Color.WHITE);
		JLabel labTotaljugador1Niv3 = new JLabel(""+PnlDatosTablero.VirusNIvel3_1);
		labTotaljugador1Niv3.setForeground(Color.WHITE);
		JLabel labTotaljugador2Niv3 = new JLabel(""+PnlDatosTablero.VirusNIvel3_2);
		labTotaljugador2Niv3.setForeground(Color.WHITE);
		
		this.add(labTotalesNiv3); this.add(labTotaljugador1Niv3);  this.add(labTotaljugador2Niv3);
		
		JLabel labTotalesBloq = new JLabel("Total de virus bloques:");
		labTotalesBloq.setForeground(Color.WHITE);
		JLabel labTotaljugador1Bloq = new JLabel(""+PnlDatosTablero.VirusBloques_1);
		labTotaljugador1Bloq.setForeground(Color.WHITE);
		JLabel labTotaljugador2Bloq = new JLabel(""+PnlDatosTablero.VirusBloques_2);
		labTotaljugador2Bloq.setForeground(Color.WHITE);
		
		this.add(labTotalesBloq); this.add(labTotaljugador1Bloq);  this.add(labTotaljugador2Bloq);
		
		juego.getJugadores()[0].setTotalVirus(PnlDatosTablero.totalVirus1);
		if(juego.getModoJuego()==0)
		{
			juego.getJugadores()[1].setTotalVirus(PnlDatosTablero.totalVirus2);
		}
		else
		{
			juego.getMaquina().setTotalVirus(PnlDatosTablero.totalVirus2);
		}
		
		JLabel labGanador = new JLabel(juego.darGanador());
		labGanador.setForeground(Color.WHITE);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pnlTablero.preguntarVolverAJugar();
			}
		});
		
		this.add(labGanador);   this.add(btnContinuar);
	    
		
	
		
		
	
	}
	/**
	 * Metodo para pintar el fondo 
	 */
	@Override
	public void paint(Graphics g)
	{
		g.drawImage(new ImageIcon(getClass().getResource("/presentacion/imagenes/fondoespacio.png")).getImage(), 0, 0, getSize().width,getSize().height,null);
		this.setOpaque(false);
		super.paint(g);
	}
}
