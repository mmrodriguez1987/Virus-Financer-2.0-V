import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JOptionPane.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.*;
import java.lang.*;

import javax.swing.plaf.metal.MetalLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

public class jinternal_comercial extends JInternalFrame
{
	private JLabel lblI = new JLabel("Interes($): ");
	private JLabel lblC = new JLabel("Capital($): ");
	private JLabel lbli = new JLabel("Porcentaje(%): ");
	private JLabel lblt = new JLabel("Tiempo(Dias): ");		
	private JLabel lblr = new JLabel("Respuesta: ");
	
	//Declaracion de los TextField
	
	private JTextField txtI = new JTextField();	//Monto de interes
	private JTextField txtC = new JTextField();	//Capital
	private JTextField txti = new JTextField();	//Porcentaje de interes
	private JTextField txtt = new JTextField();	//Periodo de tiempo
	private JTextField txtr = new JTextField();	//Respuesta
	
	//declaracion del List que permitira al usuario 
	//elegir la incognita que desea encontrar 
	//osea despejar la ecuacion
	
	String[] lista = { "Capital","Periodo de Tiempo","Porcentaje de Interes","Monto de interes" };
	private JComboBox I = new ComboBox(lista);
	private JLabel lblo = new JLabel("Elija su incognita: ");
	
	
	//declaracion de los botones
	
	private JButton cancelar = new JButton("Cancelar");
	private JButton limpiar = new JButton("Limpiar");
	private JButton calcular = new JButton("Calcular");
	
	//Declaracion de los paneles 
	
	private JPanel P1 = new JPanel();
	private JPanel P2 = new JPanel();
	
	//Declaracion de las variables 
	//donde se almacenaran los valores de ecuaciones
	
	
	 					// aqui se almacenara la incognita del usuario
	public int x;
	private double 	cap,i,m; // m es el monto de interes
	

