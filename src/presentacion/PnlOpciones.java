package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import aplicacion.Juego;
import aplicacion.Tablero;
import aplicacion.VirusEvolutivo;
import static presentacion.FrmJuego.pnlTablero;


/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  

public class PnlOpciones extends JPanel{
	  
	private FrmJuego frmJuego;
	private Juego juego;
	/**
	* Constructor del Panel 
	*@param frmJuego : el frame del juego actual
	*/
	  
	public PnlOpciones(FrmJuego frmJuego,Juego juego)
	{
		this.frmJuego = frmJuego;
		this.juego = juego;
		this.setLayout(new GridLayout(8,1));
		rellenarPanel();
	}
	
	private void rellenarPanel()
	{
		JButton btnPasarTur = new JButton("Pasar turno");
		btnPasarTur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(juego.getModoJuego()==0)
				{
					juego.setTurnoJugador(juego.nextJugador());
					juego.getJugadorEnJuego().setVirusSelec(new VirusEvolutivo(1, juego.getJugadorEnJuego().getColor()));
					PnlJugadores.cambiarJugador();
				}
				else
				{
					juego.getMaquina().setVirus(new VirusEvolutivo(1, juego.getMaquina().getColor()));
            		juego.getMaquina().ponerVirus(juego.getTablero());
            		juego.getJugadorEnJuego().setVirusSelec(new VirusEvolutivo(1, juego.getJugadorEnJuego().getColor()));
            		pnlTablero.repaint();
				}
			}
		});
		
		JButton btnRendirse = new JButton("Rendirse");
		btnRendirse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(juego.getModoJuego()==0)
				{
					juego.setTurnoJugador(juego.nextJugador());
			        JOptionPane.showMessageDialog(null,"El ganador es "+juego.getJugadorEnJuego().getNombre());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"El ganador es "+juego.getMaquina().getNombre());
				}
				
		        pnlTablero.preguntarVolverAJugar();
			}
		});
		
		JButton btnGuardarTablero = new JButton("Guardar Tablero");
		btnGuardarTablero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser jf=new JFileChooser();
		        jf.setFileFilter(new FileNameExtensionFilter("Archivo tablero .txt","txt"));
		        if(jf.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
		        {
		                if(juego.guardarTablero(jf.getSelectedFile().getAbsolutePath()+".txt"))
		                {
		                	JOptionPane.showMessageDialog(null,"Se guardo el tablero");
		                }
		                else
		                {
		                	JOptionPane.showMessageDialog(null,"No se pudo guardar el tablero");
		                }
		        }
			}
		});
		
		JButton btnCargarTablero = new JButton("Cargar Tablero");
		btnCargarTablero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser jf=new JFileChooser();
		        jf.setFileFilter(new FileNameExtensionFilter("Archivo tablero .txt","txt"));
		        if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		        {
		        	Tablero tablero = juego.cargarTablero(jf.getSelectedFile().getAbsolutePath()); 
		            if(tablero!=null)
		            {
		            	juego.setTablero(tablero);
			            frmJuego.dispose();
			            new FrmJuego(juego).setVisible(true);
			            PnlDatosTablero.cargarValores();
			            JOptionPane.showMessageDialog(null,"Se cargo el tablero");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null,"No se pudo cargar el tablero");
		            }
		        }
			}
		});
		
		JButton btnGuardarEstado = new JButton("Salvar");
		btnGuardarEstado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser jf=new JFileChooser();
		        jf.setFileFilter(new FileNameExtensionFilter("Archivo tablero .pat","pat"));
		        if(jf.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
		        {
		                if(juego.guardarEstado(jf.getSelectedFile().getAbsolutePath()+".pat"))
		                {
		                	JOptionPane.showMessageDialog(null,"Se guardo el estado");
		                }
		                else
		                {
		                	JOptionPane.showMessageDialog(null,"No se pudo guardar el estado");
		                }
		        }
			}
		});
		
		JButton btnCargarEstado = new JButton("	Abrir");
		btnCargarEstado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser jf=new JFileChooser();
		        jf.setFileFilter(new FileNameExtensionFilter("Archivo tablero .pat","pat"));
		        if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		        {
		        	Juego juego2 = Juego.cargarEstado(jf.getSelectedFile().getAbsolutePath());
		        	if(juego2!=null)
		        	{
		        		juego = juego2;
		        		juego.getJugadorEnJuego().setVirusSelec(new VirusEvolutivo(1, juego.getJugadorEnJuego().getColor()));
			            frmJuego.dispose();
			            new FrmJuego(juego).setVisible(true);
			            PnlDatosTablero.cargarValores();
			            JOptionPane.showMessageDialog(null,"Se cargo el estado del juego");
		        	}
		        	else
		        	{
		        		JOptionPane.showMessageDialog(null,"No se pudo cargar el estado del juego");
		        	}
		        }
			}
		});
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				pnlTablero.cerrar();
				new FrmDatosFinal(juego).setVisible(true);
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				pnlTablero.cerrar();
				new FrmInicio().setVisible(true);
			}
		});
		//adicionando los componentes al panel
		this.add(btnPasarTur);
		this.add(btnRendirse);
		this.add(btnGuardarTablero);
		this.add(btnCargarTablero);
		this.add(btnGuardarEstado);
		this.add(btnCargarEstado);
		this.add(btnTerminar);
		this.add(btnVolver);
		this.setVisible(true);
	}
}


