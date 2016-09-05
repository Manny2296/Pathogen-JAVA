package presentacion;

import aplicacion.Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  
public class PnlDatosTablero extends JPanel{
	/**
	*Atributos estaticos para saber los datos del tablero 
	*/
	  
	public static int totalVirusTablero,totalVirus1,totalVirus2;
	public static int porcentajeVirus1,porcentajeVirus2;
	public static int VirusNeutral,VirusNIvel1_1,VirusNIvel2_1,VirusNIvel3_1,VirusBloques_1,VirusNIvel1_2,VirusNIvel2_2,VirusNIvel3_2,VirusBloques_2;
	
	private static JLabel labNombreyVirus1,labNombreyVirus2,labTotalVirus,labtotalTurnos;
	
	// juego estatico para ser utilizado en el metodo estatico cargarValores
	private static Juego juego;
	/**
    *Constructor del panel 
	*/
	  
	public PnlDatosTablero(Juego juego)
	{
		this.juego = juego;
		this.setLayout(new GridLayout(1, 4));
		this.setBackground(Color.WHITE);
		labNombreyVirus1 = new JLabel(juego.getJugadores()[0].getNombre()+" -- Total virus: 0   0%");
		
		if(juego.getModoJuego()==0)
		{
			labNombreyVirus2 = new JLabel(juego.getJugadores()[1].getNombre()+" -- Total virus: 0   0%");
		}
		else
		{
			labNombreyVirus2 = new JLabel(juego.getMaquina().getNombre()+" -- Total virus: 0   0%");
		}
		
		labTotalVirus = new JLabel("Total virus en el tablero: 0");
		if(juego.isIlimito())
		{
			labtotalTurnos = new JLabel("Total de turnos: Ilimitados");
		}
		else
		{
			labtotalTurnos = new JLabel("Total de turnos: "+juego.getTotalTurnos());
		}
		this.add(labNombreyVirus1);
		this.add(labNombreyVirus2);
		this.add(labTotalVirus);
		this.add(labtotalTurnos);
	}
	
	/**
	*Metodo para llenar los valores con los datos del tablero
	*/
	  
	public static void cargarValores()
	{
		totalVirus1 = 0; totalVirus2 = 0;
		VirusNeutral = 0; VirusNIvel1_1 = 0; VirusNIvel2_1 = 0; VirusNIvel3_1 = 0; VirusBloques_1 = 0; VirusNIvel1_2 = 0; VirusNIvel2_2 = 0; VirusNIvel3_2 = 0; VirusBloques_2 = 0;
		for (int i = 0; i < juego.getTablero().getFilas(); i++) {
			for (int j = 0; j < juego.getTablero().getColumnas(); j++) {
				if(juego.getTablero().getCasillas()[i][j].getVirus()!=null)
				{
					if(juego.getTablero().getCasillas()[i][j].getVirus().getColor().equals(juego.getJugadores()[0].getColor()))
					{
						totalVirus1++;
						switch (juego.getTablero().getCasillas()[i][j].getVirus().getNivel()) {
						case 1:
							VirusNIvel1_1++;
							break;
						case 2:
							VirusNIvel2_1++;
							break;
						case 3:
							VirusNIvel3_1++;
							break;
						case 4:
							VirusBloques_1++;
							break;
						}
					}
					else if(!juego.getTablero().getCasillas()[i][j].getVirus().getColor().equals(Color.GRAY))
					{
						totalVirus2++;
						switch (juego.getTablero().getCasillas()[i][j].getVirus().getNivel()) {
						case 1:
							VirusNIvel1_2++;
							break;
						case 2:
							VirusNIvel2_2++;
							break;
						case 3:
							VirusNIvel3_2++;
							break;
						case 4:
							VirusBloques_2++;
							break;
						}
					}
					else
					{
						VirusNeutral++;
					}
				}
			}
		}
		
		totalVirusTablero = totalVirus1 + totalVirus2 + VirusNeutral;
		
		porcentajeVirus1 = (totalVirus1*100)/(juego.getTablero().getFilas()*juego.getTablero().getColumnas());
		porcentajeVirus2 = (totalVirus2*100)/(juego.getTablero().getFilas()*juego.getTablero().getColumnas());
		
		labNombreyVirus1.setText(juego.getJugadores()[0].getNombre()+" -- Total virus: "+totalVirus1+"   "+porcentajeVirus1+"%");
		if(juego.getModoJuego()==0)
		{
			labNombreyVirus2.setText(juego.getJugadores()[1].getNombre()+" -- Total virus: "+totalVirus2+"   "+porcentajeVirus2+"%");
		}
		else
		{
			labNombreyVirus2.setText(juego.getMaquina().getNombre()+" -- Total virus: "+totalVirus2+"   "+porcentajeVirus2+"%");
		}
		
		labTotalVirus.setText("Total virus en el tablero: "+totalVirusTablero);
		if(juego.isIlimito())
		{
			labtotalTurnos.setText("Total de turnos: Ilimitados");
		}
		else
		{
			labtotalTurnos.setText("Total de turnos: "+juego.getTotalTurnos());
		}
	}
	

}
