package presentacion;

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
import aplicacion.Jugador;
import aplicacion.Virus;
import aplicacion.VirusDestructor;
import aplicacion.VirusEvolutivo;
/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  
public class PnlJugadores extends JPanel{
	/**
	*Las vaiables para la informacion de los jugadores, hay variables estaticas para habilitar y desabilitar en otros paneles
	*/
	  

	private Jugador jugador1;
	private static JLabel labelJugador1, labelNombre1,labelJugador2,labelNombre2,labelMaquina,labelNombreMaq;
	private static JButton btnNivel1,btnNivel2,btnNivel3,btnDestructor,btn2Nivel1,btn2Nivel2,btn2Nivel3,btn2Destructor;
	
	// juego estatico para ser utilizado en el metodo estatico cambiarJugador
	private static Juego juego;
	/**
	* Constructoer del panel de jugadores
	*/
	  
	public PnlJugadores(Juego juegoParametro)
	{    
		this.setBackground(new Color(25, 25, 112));
		juego = juegoParametro;
		// se escoge el modo, si es de dos jugadores o contra la maquina
		switch (juego.getModoJuego()) {
		case 0:
			this.setLayout(new GridLayout(6,2));
			// se obtiene el jugador 1
			jugador1 = juego.getJugadores()[0];
			
			// datos del jugador 1
			labelJugador1 = new JLabel("Nombre del jugador 1:");
			labelJugador1.setForeground(Color.WHITE);
			labelNombre1 = new JLabel(jugador1.getNombre());
			labelNombre1.setForeground(Color.WHITE);
			
			
			// se establece un virus por defecto al juagdor 1
			jugador1.setVirusSelec(new VirusEvolutivo(1, jugador1.getColor()));
			
			// botones para el jugador 1 con su respectiva imagen
			btnNivel1 = new JButton(juego.getImagenColor(jugador1.getColor(), 0));

			btnNivel2 = new JButton(juego.getImagenColor(jugador1.getColor(), Juego.IMGNIVEL2));
			btnNivel3 = new JButton(juego.getImagenColor(jugador1.getColor(), Juego.IMGNIVEL3));
			
			btnDestructor = new JButton(juego.getImagenColor(jugador1.getColor(), Juego.IMGDESTRUCTOR));
			
			// se utiliza el metodo establecerEvento para asginarcelos a cada boton del jugador 1 con su respectivo virus
			establecerEvento(btnNivel1, new VirusEvolutivo(1,jugador1.getColor()));
            establecerEvento(btnNivel2, new VirusEvolutivo(2, jugador1.getColor()));
            establecerEvento(btnNivel3, new VirusEvolutivo(3, jugador1.getColor()));
            establecerEvento(btnDestructor, new VirusDestructor(jugador1.getColor()));
             
             
            // se obtiene el jugador 2
 			Jugador jugador2 = juego.getJugadores()[1];
 			
 			// datos del jugador 2
 			labelJugador2 = new JLabel("Nombre del jugador 2: ");
 			labelJugador1.setForeground(Color.WHITE);
 			labelNombre2 = new JLabel(jugador2.getNombre());
 			labelNombre2.setForeground(Color.WHITE);
 			labelJugador2.setEnabled(false);
 			labelNombre2.setEnabled(false);
 			// se establece un virus por defecto al juagdor 2
 			jugador2.setVirusSelec(new VirusEvolutivo(1, jugador2.getColor()));
 			
 			// botones para el jugador 2 con su respectiva imagen
 			btn2Nivel1 = new JButton(juego.getImagenColor(jugador2.getColor(), Juego.IMGNIVEL1));
 			btn2Nivel2 = new JButton(juego.getImagenColor(jugador2.getColor(), Juego.IMGNIVEL2));
 			btn2Nivel3 = new JButton(juego.getImagenColor(jugador2.getColor(), Juego.IMGNIVEL3));
 			btn2Destructor = new JButton(juego.getImagenColor(jugador2.getColor(), Juego.IMGDESTRUCTOR));
 			btn2Nivel1.setEnabled(false);
 			btn2Nivel2.setEnabled(false);
 			btn2Nivel3.setEnabled(false);
 			btn2Destructor.setEnabled(false);
 			
 			// se utiliza el metodo establecerEvento para asginarcelos a cada boton del jugador 2 con su respectivo virus
 			establecerEvento(btn2Nivel1, new VirusEvolutivo(1,jugador2.getColor()));
            establecerEvento(btn2Nivel2, new VirusEvolutivo(2, jugador2.getColor()));
            establecerEvento(btn2Nivel3, new VirusEvolutivo(3, jugador2.getColor()));
            establecerEvento(btn2Destructor, new VirusDestructor(jugador2.getColor()));
            
            //se adiciona los componentes al panel respectivamente
            this.add(labelJugador1);
            this.add(labelNombre1);
            this.add(btnNivel1);
            this.add(btnNivel2);
            this.add(btnNivel3);
            this.add(btnDestructor);
            this.add(labelJugador2);
            this.add(labelNombre2);
            this.add(btn2Nivel1);
            this.add(btn2Nivel2);
            this.add(btn2Nivel3);
            this.add(btn2Destructor);
			break;
		case 1:
			this.setLayout(new GridLayout(4,2));
			// se obtiene el jugador 1
			jugador1 = juego.getJugadores()[0];
				
			// datos del jugador 1
			labelJugador1 = new JLabel("Nombre del jugador 1:");
			labelNombre1 = new JLabel(jugador1.getNombre());
						
			// se establece un virus por defecto al juagdor 1
			jugador1.setVirusSelec(new VirusEvolutivo(1, jugador1.getColor()));
						
			// botones para el jugador 1 con su respectiva imagen
			btnNivel1 = new JButton(juego.getImagenColor(jugador1.getColor(), Juego.IMGNIVEL1));
			btnNivel2 = new JButton(juego.getImagenColor(jugador1.getColor(), Juego.IMGNIVEL2));
			btnNivel3 = new JButton(juego.getImagenColor(jugador1.getColor(), Juego.IMGNIVEL3));
			btnDestructor = new JButton(juego.getImagenColor(jugador1.getColor(), Juego.IMGDESTRUCTOR));
						
			// se utiliza el metodo establecerEvento para asginarcelos a cada boton del jugador 1 con su respectivo virus
			establecerEvento(btnNivel1, new VirusEvolutivo(1,jugador1.getColor()));
			establecerEvento(btnNivel2, new VirusEvolutivo(2, jugador1.getColor()));
			establecerEvento(btnNivel3, new VirusEvolutivo(3, jugador1.getColor()));
			establecerEvento(btnDestructor, new VirusDestructor(jugador1.getColor()));
			 			
			// datos de la maquina
			labelMaquina = new JLabel("Nombre de la maquina: ");
			labelNombreMaq = new JLabel(juego.getMaquina().getNombre());
			
			//se adiciona los componentes al panel respectivamente
			this.add(labelJugador1);
			this.add(labelNombre1);
			this.add(btnNivel1);
			this.add(btnNivel2);
			this.add(btnNivel3);
			this.add(btnDestructor);
			this.add(labelMaquina);
			this.add(labelNombreMaq);
			break;
		}
	}

	// metodo encargado de asignar un evento al boton, el evento del boton establece el virus al jugador en juego
	private void establecerEvento(JButton boton, Virus virus) {
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Virus v;
				if(virus.getNivel()==0)
				{
					v = new VirusDestructor(virus.getColor());
				}
				else
				{
					v = new VirusEvolutivo(virus.getNivel(),virus.getColor());
				}
				juego.getJugadorEnJuego().setVirusSelec(v);
			}
		});
	}
	
	// metodo estatico para ser llamado en otro panel sin instanciar, y poder asi deshabilitar y habilitar los botones
	
	public static void cambiarJugador()
	{
		switch (juego.getModoJuego()) {
		case 0:
			if(juego.getJugadorEnJuego().equals(juego.getJugadores()[0]))
			{
				// se habilita el jugador 1
				labelJugador1.setEnabled(true);
				labelNombre1.setEnabled(true);
				btnNivel1.setEnabled(true);
			
				btnNivel2.setEnabled(true);
				
				btnNivel3.setEnabled(true);
				
				btnDestructor.setEnabled(true);
				// se deshabilita el jugador 2
				labelJugador2.setEnabled(false);
				labelNombre2.setEnabled(false);
				btn2Nivel1.setEnabled(false);
				btn2Nivel2.setEnabled(false);
				btn2Nivel3.setEnabled(false);
				btn2Destructor.setEnabled(false);
			}
			else
			{
				// se deshabilita el jugador 1
				labelJugador1.setEnabled(false);
				labelNombre1.setEnabled(false);
				btnNivel1.setEnabled(false);
				btnNivel2.setEnabled(false);
				btnNivel3.setEnabled(false);
				btnDestructor.setEnabled(false);
				// se habilita el jugador 2
				labelJugador2.setEnabled(true);
				labelNombre2.setEnabled(true);
				btn2Nivel1.setEnabled(true);
				btn2Nivel2.setEnabled(true);
				btn2Nivel3.setEnabled(true);
				btn2Destructor.setEnabled(true);
			}
			break;

		case 1:
			if(juego.getJugadorEnJuego().equals(juego.getJugadores()[0]))
			{
				// se habilita el jugador 1
				labelJugador1.setEnabled(true);
				labelNombre1.setEnabled(true);
				btnNivel1.setEnabled(true);
				btnNivel2.setEnabled(true);
				btnNivel3.setEnabled(true);
				btnDestructor.setEnabled(true);
				// se deshabilita la maquina
				labelMaquina.setEnabled(false);
				labelNombreMaq.setEnabled(false);
			}
			else
			{
				// se deshabilita el jugador 1
				labelJugador1.setEnabled(false);
				labelNombre1.setEnabled(false);
				btnNivel1.setEnabled(false);
				btnNivel2.setEnabled(false);
				btnNivel3.setEnabled(false);
				btnDestructor.setEnabled(false);
				// se habilita la maquina
				labelMaquina.setEnabled(true);
				labelNombreMaq.setEnabled(true);
			}
			break;
		}
		
	}
	
}
