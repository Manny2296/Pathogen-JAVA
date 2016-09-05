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
import javax.swing.JFrame;
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
/**
*
* @author Manuel Phelipe-Daniel Ayala
*/
  
public class FrmInicio extends JFrame{
	
	public FrmInicio()
	{
		this.setTitle("Pathogen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new PnlIncio());
		this.pack();
		this.setSize(new Dimension(520,500));
		this.setLocationRelativeTo(null);
	}
	
	

}
