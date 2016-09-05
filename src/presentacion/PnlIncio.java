package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import aplicacion.Juego;
import aplicacion.Maquina;
import aplicacion.RangoException;
import aplicacion.VirusEvolutivo;
import aplicacion.VirusNeutral;

public class PnlIncio extends JPanel{
	
	/**
	 * Variables para controlar el cambio del color de los botones
	 */
	private int contColo1,contColor2;
	
	/**
	 *  Variable Juego
	 */
	private Juego juego;
	
	public PnlIncio()
	{
		this.setLayout(new GridLayout(12, 2));
		rellenarPanel();
	}
	
	
		/**
		 * Rellena el panel con los componetes
		 */
		private void rellenarPanel() {
			
			JLabel labelOponente = new JLabel("Oponente:");
			labelOponente.setForeground(Color.WHITE);
			//ComboBox para escoger al oponente
			JComboBox<String> jcombOponente = new JComboBox<String>(new String[]{"Jugador 2","Maquina"});
			
			JLabel labelJug1 = new JLabel("Color jugador 1:");
			labelJug1.setForeground(Color.WHITE);
			//Boton para escoger el color del jugador 1, con un evento que va cambiando el color del boton
			JButton btnColor1 = new JButton();
			btnColor1.setBackground(Color.BLUE);
			btnColor1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					switch (contColo1) {
					case 0:
						btnColor1.setBackground(Color.BLUE);
						contColo1++;
						break;
						
					case 1:
						btnColor1.setBackground(Color.RED);
						contColo1++;
						break;
						
					case 2:
						btnColor1.setBackground(Color.YELLOW);
						contColo1++;
						break;
						
					case 3:
						btnColor1.setBackground(Color.GREEN);
						contColo1 = 0;
						break;
					}
				}
			});
			
			JLabel labelNombre1 = new JLabel("Nombre del jugador 1:");
			labelNombre1.setForeground(Color.WHITE);
			
			//un campo para digitar el nombre del jugador 1
			JTextField txtNombre1 = new JTextField();
			
			JLabel labelJug2 = new JLabel("Color jugador 2:");
			labelJug2.setForeground(Color.WHITE);
			
			//Boton para escoger el color del jugador 2, con un evento que va cambiando el color del boton
			JButton btnColor2 = new JButton();
			btnColor2.setBackground(Color.RED);
			btnColor2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					switch (contColor2) {
					case 0:
						btnColor2.setBackground(Color.BLUE);
						contColor2++;
						break;
						
					case 1:
						btnColor2.setBackground(Color.RED);
						contColor2++;
						break;
						
					case 2:
						btnColor2.setBackground(Color.YELLOW);
						contColor2++;
						break;
						
					case 3:
						btnColor2.setBackground(Color.GREEN);
						contColor2 = 0;
						break;
					}
				}
			});
			
			JLabel labelNombre2 = new JLabel("Nombre del jugador 2:");
			labelNombre2.setForeground(Color.WHITE);
			//un campo para digitar el nombre del jugador 2
			JTextField txtNombre2 = new JTextField();
			
			JLabel labelMaquina = new JLabel("Nivel maquina:");
			labelMaquina.setForeground(Color.WHITE);
			labelMaquina.setEnabled(false);
			//ComboBox para escoger el nivel de la maquina
			JComboBox<String> jcombNivelMaq = new JComboBox<String>(new String[]{"Irreflexivo","Timido","Ofensivo"});
			jcombNivelMaq.setEnabled(false);
			
			// se adiciona un escuchador al jcomb para controlar la edicion del oponente segun la seleccion
			jcombOponente.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					if(e.getItem().equals("Jugador 2"))
					{
						labelMaquina.setEnabled(false);
						jcombNivelMaq.setEnabled(false);
						labelJug2.setEnabled(true);
						btnColor2.setEnabled(true);
						btnColor2.doClick();
						labelNombre2.setEnabled(true);
						txtNombre2.setEnabled(true);
					}
					else
					{
						labelJug2.setEnabled(false);
						btnColor2.setEnabled(false);
						btnColor2.setBackground(Color.GRAY);
						contColor2 = 1;
						labelNombre2.setEnabled(false);
						txtNombre2.setEnabled(false);
						labelMaquina.setEnabled(true);
						jcombNivelMaq.setEnabled(true);
					}
				}
			});
			
			// componentes para los turnos
			JLabel labelTurnos = new JLabel("Digitar el numero de turnos (min 2):");
			labelTurnos.setForeground(Color.WHITE);
			JTextField txtTurnos = new JTextField("10");
			JCheckBox checkTurnosInfi = new JCheckBox("Turnos ilimitados");
			checkTurnosInfi.setForeground(Color.WHITE);
			checkTurnosInfi.setOpaque(false);
			checkTurnosInfi.addItemListener(new ItemListener() {
						
						@Override
						public void itemStateChanged(ItemEvent arg0) {
							if(checkTurnosInfi.isSelected())
							{
								labelTurnos.setEnabled(false);
								txtTurnos.setEnabled(false);
							}
							else
							{
								labelTurnos.setEnabled(true);
								txtTurnos.setEnabled(true);
							}
						}
					});
			
			// componentes para las filas y columnas
			JLabel labelFilas = new JLabel("Digitar filas del tablero (min 2)(max 10):");
			labelFilas.setForeground(Color.WHITE);
			JLabel labelColumnas = new JLabel("Digitar columnas del tablero(min 2)(max 10):");
			labelColumnas.setForeground(Color.WHITE);
			JTextField txtFilas = new JTextField("8");
			JTextField txtColumnas = new JTextField("8");
			JCheckBox checkAleatorio = new JCheckBox("Tablero aleatorio");
			checkAleatorio.setForeground(Color.WHITE);
			checkAleatorio.setOpaque(false);
			checkAleatorio.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					if(checkAleatorio.isSelected())
					{
						labelFilas.setEnabled(false);
						labelColumnas.setEnabled(false);
						txtFilas.setEnabled(false);
						txtColumnas.setEnabled(false);
					}
					else
					{
						labelFilas.setEnabled(true);
						labelColumnas.setEnabled(true);
						txtFilas.setEnabled(true);
						txtColumnas.setEnabled(true);
					}
				}
			});
			
			// componente para escoger si desea virus neutrales aleaotrios en el tablero
			JCheckBox checkVirNeutral = new JCheckBox("Virus neutrales");
			checkVirNeutral.setForeground(Color.WHITE);
			checkVirNeutral.setOpaque(false);
			// label vacio, solo para acomodar el frame
			JLabel labelVacio = new JLabel("");
			
			//Boton para aceptar la configuracion, con un evento que valida los datos para seguir al juego
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					boolean correcto = true;
					
	
						if(btnColor1.getBackground().equals(btnColor2.getBackground()))
						{
							JOptionPane.showMessageDialog(null, "Los dos jugadores no pueden tener el mismo color");
							correcto = false;
						}
					
					
					try
					{
						if(!checkTurnosInfi.isSelected())
						{
							int turnos = Integer.parseInt(txtTurnos.getText().trim());
							Juego.rangoTrunos(turnos);
						}
						if(!checkAleatorio.isSelected())
						{
							int filas = Integer.parseInt(txtFilas.getText().trim());
							int columnas = Integer.parseInt(txtColumnas.getText().trim());
							Juego.rangoFilyCol(filas, columnas);
						}
					}
					catch(NumberFormatException ex){
						correcto = false;
						Logger.getLogger(FrmInicio.class.getName()).log(Level.SEVERE, null, ex);
						JOptionPane.showMessageDialog(null, "El numero de turnos debe ser un numero");
					} catch (RangoException e1) {
						correcto = false;
						Logger.getLogger(FrmInicio.class.getName()).log(Level.SEVERE, null, e1);
						JOptionPane.showMessageDialog(null, e1);
					}
					
					if(correcto)
					{
						if(jcombOponente.getSelectedItem().equals("Jugador 2"))
						{
							if(checkTurnosInfi.isSelected())
							{
								if(checkAleatorio.isSelected())
								{
									if(checkVirNeutral.isSelected())
									{
										Random numAleatorio = new Random();
										int filas = (numAleatorio.nextInt(9))+2;
										int columnas = (numAleatorio.nextInt(9))+2;
										String[] nombres = {txtNombre1.getText().trim(),txtNombre2.getText().trim()};
										Color[] colores = {btnColor1.getBackground(),btnColor2.getBackground()};
										juego = new Juego(filas, columnas, nombres, colores);
										
										int cantidadVirNeutrales = (numAleatorio.nextInt((filas*columnas)/2))+1;
										int nivel;
										for (int i = 0; i < cantidadVirNeutrales; i++) {
											nivel = (numAleatorio.nextInt(4))+1;
											if(nivel!=3)
											{
												VirusNeutral virNeu = new VirusNeutral(nivel, Color.GRAY);
												juego.getTablero().getCasillas()[numAleatorio.nextInt(filas)][numAleatorio.nextInt(columnas)].setVirus(virNeu);
											}
											else
											{
												i--;
											}
										}
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
									else
									{
										int filas = (new Random().nextInt(9))+2;
										int columnas = (new Random().nextInt(9))+2;
										String[] nombres = {txtNombre1.getText().trim(),txtNombre2.getText().trim()};
										Color[] colores = {btnColor1.getBackground(),btnColor2.getBackground()};
										juego = new Juego(filas, columnas, nombres, colores);
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
								}
								else
								{
									if(checkVirNeutral.isSelected())
									{
										Random numAleatorio = new Random();
										String[] nombres = {txtNombre1.getText().trim(),txtNombre2.getText().trim()};
										Color[] colores = {btnColor1.getBackground(),btnColor2.getBackground()};
										juego = new Juego(Integer.parseInt(txtFilas.getText().trim()), Integer.parseInt(txtColumnas.getText().trim()), nombres, colores);
										
										int cantidadVirNeutrales = (numAleatorio.nextInt((juego.getTablero().getFilas()*juego.getTablero().getColumnas())/2))+1;
										int nivel;
										for (int i = 0; i < cantidadVirNeutrales; i++) {
											nivel = (numAleatorio.nextInt(4))+1;
											if(nivel!=3)
											{
												VirusNeutral virNeu = new VirusNeutral(nivel, Color.GRAY);
												juego.getTablero().getCasillas()[numAleatorio.nextInt(juego.getTablero().getFilas())][numAleatorio.nextInt(juego.getTablero().getColumnas())].setVirus(virNeu);
											}
											else
											{
												i--;
											}
										}
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
									else
									{
										String[] nombres = {txtNombre1.getText().trim(),txtNombre2.getText().trim()};
										Color[] colores = {btnColor1.getBackground(),btnColor2.getBackground()};
										juego = new Juego(Integer.parseInt(txtFilas.getText().trim()), Integer.parseInt(txtColumnas.getText().trim()), nombres, colores);
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
								}
							}
							else
							{
								if(checkAleatorio.isSelected())
								{
									if(checkVirNeutral.isSelected())
									{
										Random numAleatorio = new Random();
										int filas = (numAleatorio.nextInt(9))+2;
										int columnas = (numAleatorio.nextInt(9))+2;
										String[] nombres = {txtNombre1.getText().trim(),txtNombre2.getText().trim()};
										Color[] colores = {btnColor1.getBackground(),btnColor2.getBackground()};
										juego = new Juego(filas, columnas, nombres, colores,Integer.parseInt(txtTurnos.getText().trim()));
										
										int cantidadVirNeutrales = (numAleatorio.nextInt((juego.getTablero().getFilas()*juego.getTablero().getColumnas())/2))+1;
										int nivel;
										for (int i = 0; i < cantidadVirNeutrales; i++) {
											nivel = (numAleatorio.nextInt(4))+1;
											if(nivel!=3)
											{
												VirusNeutral virNeu = new VirusNeutral(nivel, Color.GRAY);
												juego.getTablero().getCasillas()[numAleatorio.nextInt(juego.getTablero().getFilas())][numAleatorio.nextInt(juego.getTablero().getColumnas())].setVirus(virNeu);
											}
											else
											{
												i--;
											}
										}
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
									else
									{
										int filas = (new Random().nextInt(9))+2;
										int columnas = (new Random().nextInt(9))+2;
										String[] nombres = {txtNombre1.getText().trim(),txtNombre2.getText().trim()};
										Color[] colores = {btnColor1.getBackground(),btnColor2.getBackground()};
										juego = new Juego(filas, columnas, nombres, colores,Integer.parseInt(txtTurnos.getText().trim()));
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
								}
								else
								{
									if(checkVirNeutral.isSelected())
									{
										Random numAleatorio = new Random();
										String[] nombres = {txtNombre1.getText().trim(),txtNombre2.getText().trim()};
										Color[] colores = {btnColor1.getBackground(),btnColor2.getBackground()};
										juego = new Juego(Integer.parseInt(txtFilas.getText().trim()), Integer.parseInt(txtColumnas.getText().trim()), nombres, colores,Integer.parseInt(txtTurnos.getText().trim()));
										
										int cantidadVirNeutrales = (numAleatorio.nextInt((juego.getTablero().getFilas()*juego.getTablero().getColumnas())/2))+1;
										int nivel;
										for (int i = 0; i < cantidadVirNeutrales; i++) {
											nivel = (numAleatorio.nextInt(4))+1;
											if(nivel!=3)
											{
												VirusNeutral virNeu = new VirusNeutral(nivel, Color.GRAY);
												juego.getTablero().getCasillas()[numAleatorio.nextInt(juego.getTablero().getFilas())][numAleatorio.nextInt(juego.getTablero().getColumnas())].setVirus(virNeu);
											}
											else
											{
												i--;
											}
										}
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
									else
									{
										String[] nombres = {txtNombre1.getText().trim(),txtNombre2.getText().trim()};
										Color[] colores = {btnColor1.getBackground(),btnColor2.getBackground()};
										juego = new Juego(Integer.parseInt(txtFilas.getText().trim()), Integer.parseInt(txtColumnas.getText().trim()), nombres, colores,Integer.parseInt(txtTurnos.getText().trim()));
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
								}
							}
						}
						else
						{
							if(checkTurnosInfi.isSelected())
							{
								if(checkAleatorio.isSelected())
								{
									if(checkVirNeutral.isSelected())
									{
										Random numAleatorio = new Random();
										int filas = (numAleatorio.nextInt(9))+2;
										int columnas = (numAleatorio.nextInt(9))+2;
										Color colorJugador = btnColor1.getBackground();
										btnColor1.doClick();
										Maquina maquina = new Maquina("Machine",jcombNivelMaq.getSelectedIndex(),btnColor1.getBackground());
										juego = new Juego(filas, columnas,txtNombre1.getText().trim(),colorJugador, maquina);
										
										int cantidadVirNeutrales = (numAleatorio.nextInt((filas*columnas)/2))+1;
										int nivel;
										for (int i = 0; i < cantidadVirNeutrales; i++) {
											nivel = (numAleatorio.nextInt(4))+1;
											if(nivel!=3)
											{
												VirusNeutral virNeu = new VirusNeutral(nivel, Color.GRAY);
												juego.getTablero().getCasillas()[numAleatorio.nextInt(filas)][numAleatorio.nextInt(columnas)].setVirus(virNeu);
											}
											else
											{
												i--;
											}
										}
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
									else
									{
										int filas = (new Random().nextInt(9))+2;
										int columnas = (new Random().nextInt(9))+2;
										Color colorJugador = btnColor1.getBackground();
										btnColor1.doClick();
										Maquina maquina = new Maquina("Machine",jcombNivelMaq.getSelectedIndex(),btnColor1.getBackground());
										juego = new Juego(filas, columnas,txtNombre1.getText().trim(),colorJugador, maquina);
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
								}
								else
								{
									if(checkVirNeutral.isSelected())
									{
										Random numAleatorio = new Random();
										Color colorJugador = btnColor1.getBackground();
										btnColor1.doClick();
										Maquina maquina = new Maquina("Machine",jcombNivelMaq.getSelectedIndex(),btnColor1.getBackground());
										juego = new Juego(Integer.parseInt(txtFilas.getText().trim()), Integer.parseInt(txtColumnas.getText().trim()),txtNombre1.getText().trim(),colorJugador, maquina);
										
										int cantidadVirNeutrales = (numAleatorio.nextInt((juego.getTablero().getFilas()*juego.getTablero().getColumnas())/2))+1;
										int nivel;
										for (int i = 0; i < cantidadVirNeutrales; i++) {
											nivel = (numAleatorio.nextInt(4))+1;
											if(nivel!=3)
											{
												VirusNeutral virNeu = new VirusNeutral(nivel, Color.GRAY);
												juego.getTablero().getCasillas()[numAleatorio.nextInt(juego.getTablero().getFilas())][numAleatorio.nextInt(juego.getTablero().getFilas())].setVirus(virNeu);
											}
											else
											{
												i--;
											}
										}
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
									else
									{
										Color colorJugador = btnColor1.getBackground();
										btnColor1.doClick();
										Maquina maquina = new Maquina("Machine",jcombNivelMaq.getSelectedIndex(),btnColor1.getBackground());
										juego = new Juego(Integer.parseInt(txtFilas.getText().trim()), Integer.parseInt(txtColumnas.getText().trim()),txtNombre1.getText().trim(),colorJugador, maquina);
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
								}
							}
							else
							{
								if(checkAleatorio.isSelected())
								{
									if(checkVirNeutral.isSelected())
									{
										Random numAleatorio = new Random();
										int filas = (numAleatorio.nextInt(9))+2;
										int columnas = (numAleatorio.nextInt(9))+2;
										Color colorJugador = btnColor1.getBackground();
										btnColor1.doClick();
										Maquina maquina = new Maquina("Machine",jcombNivelMaq.getSelectedIndex(),btnColor1.getBackground());
										juego = new Juego(filas, columnas,txtNombre1.getText().trim(),colorJugador, maquina,Integer.parseInt(txtTurnos.getText().trim()));
										
										int cantidadVirNeutrales = (numAleatorio.nextInt((filas*columnas)/2))+1;
										int nivel;
										for (int i = 0; i < cantidadVirNeutrales; i++) {
											nivel = (numAleatorio.nextInt(4))+1;
											if(nivel!=3)
											{
												VirusNeutral virNeu = new VirusNeutral(nivel, Color.GRAY);
												juego.getTablero().getCasillas()[numAleatorio.nextInt(filas)][numAleatorio.nextInt(columnas)].setVirus(virNeu);
											}
											else
											{
												i--;
											}
										}
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
									else
									{
										int filas = (new Random().nextInt(9))+2;
										int columnas = (new Random().nextInt(9))+2;
										Color colorJugador = btnColor1.getBackground();
										btnColor1.doClick();
										Maquina maquina = new Maquina("Machine",jcombNivelMaq.getSelectedIndex(),btnColor1.getBackground());
										juego = new Juego(filas, columnas,txtNombre1.getText().trim(),colorJugador, maquina,Integer.parseInt(txtTurnos.getText().trim()));
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
								}
								else
								{
									if(checkVirNeutral.isSelected())
									{
										Random numAleatorio = new Random();
										Color colorJugador = btnColor1.getBackground();
										btnColor1.doClick();
										Maquina maquina = new Maquina("Machine",jcombNivelMaq.getSelectedIndex(),btnColor1.getBackground());
										juego = new Juego(Integer.parseInt(txtFilas.getText().trim()), Integer.parseInt(txtColumnas.getText().trim()),txtNombre1.getText().trim(),colorJugador, maquina,Integer.parseInt(txtTurnos.getText().trim()));
										
										int cantidadVirNeutrales = (numAleatorio.nextInt((juego.getTablero().getFilas()*juego.getTablero().getColumnas())/2))+1;
										int nivel;
										for (int i = 0; i < cantidadVirNeutrales; i++) {
											nivel = (numAleatorio.nextInt(4))+1;
											if(nivel!=3)
											{
												VirusNeutral virNeu = new VirusNeutral(nivel, Color.GRAY);
												juego.getTablero().getCasillas()[numAleatorio.nextInt(juego.getTablero().getFilas())][numAleatorio.nextInt(juego.getTablero().getFilas())].setVirus(virNeu);
											}
											else
											{
												i--;
											}
										}
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
									else
									{
										Color colorJugador = btnColor1.getBackground();
										btnColor1.doClick();
										Maquina maquina = new Maquina("Machine",jcombNivelMaq.getSelectedIndex(),btnColor1.getBackground());
										juego = new Juego(Integer.parseInt(txtFilas.getText().trim()), Integer.parseInt(txtColumnas.getText().trim()),txtNombre1.getText().trim(),colorJugador, maquina,Integer.parseInt(txtTurnos.getText().trim()));
										setVisible(false);
										new FrmJuego(juego).setVisible(true);
									}
								}
							}
						}
					}
				}
			});
			
			// boton para cargar un estado de un juego guardado con anterioridad
			JButton btnCargarEstado = new JButton("Abrir");
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
			        		setVisible(false);
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
	
			//se adiciona los componentes al panel del frame respectivamente
			this.add(labelOponente);
			this.add(jcombOponente);
			this.add(labelJug1);
			this.add(btnColor1);
			this.add(labelNombre1);
			this.add(txtNombre1);
			this.add(labelJug2);
			this.add(btnColor2);
			this.add(labelNombre2);
			this.add(txtNombre2);
			this.add(labelMaquina);
			this.add(jcombNivelMaq);
			this.add(checkTurnosInfi);
			this.add(checkAleatorio);
			this.add(labelTurnos);
			this.add(txtTurnos);
			this.add(labelFilas);
			this.add(labelColumnas);
			this.add(txtFilas);
			this.add(txtColumnas);
			this.add(checkVirNeutral);
			this.add(labelVacio);
			this.add(btnAceptar);
			this.add(btnCargarEstado);
			
			// se pinta el fondo
			this.repaint();
		}
		/**
		 * Metodo para pintar el fondo 
		 */
		@Override
		public void paint(Graphics g)
		{
			g.drawImage(new ImageIcon(getClass().getResource("/presentacion/imagenes/fondo.jpg")).getImage(), 0, 0, getSize().width,getSize().height,null);
			this.setOpaque(false);
			super.paint(g);
		}

}
