
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JOptionPane.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Nigthwish extends JFrame
{
	private JPanel panel = new JPanel();   
	private JLabel lblbarra = new JLabel("Cargando su nueva Sesión Financiera...	");			
	private JProgressBar barra = new JProgressBar();
   public Thread hilo = new Thread();   
   private JLabel imagen_animada = new JLabel(new ImageIcon("gatito.GIF"));
   private JLabel otra = new JLabel(new ImageIcon("tiempo.GIF"));
   private JLabel mas = new JLabel(new ImageIcon("ladron.GIF"));
   private JLabel mas2 = new JLabel(new ImageIcon("mask.GIF"));

   
   public Nigthwish()
   {
		super("Iniciando Nueva Sesion de Virus Financer 1.0.0.0.1 ");	
		 try {
           javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    	    } 
	   catch (Exception e) {}
		setSize(500,500);
		setLocation(200,200);
		setResizable(false);
		
		//setClosable(false);
		getContentPane().add(panel);
		panel.add(lblbarra);
		panel.add(barra);
		panel.add(imagen_animada);
		panel.add(otra);
		panel.add(mas);
		panel.add(mas2);
		panel.setLayout(null);		
		panel.setBackground(new java.awt.Color(100,160,200));
		lblbarra.setBounds(120,50,300,20);
		barra.setBounds(20,100,460,20);
		imagen_animada.setBounds(200,150,110,43);	
		otra.setBounds(200,280,86,100);
		mas.setBounds(30,280,120,105);
		mas2.setBounds(350,250,116,150);
		
		
		setVisible(true);
		hilo = new Carga();	
		hilo.start();	   
	}
	class Carga extends Thread
   {
	   public void run() 
      {
	      try
	      {
		      int min = 0;
           	int max = 100;     
           	barra.setValue(min);
           	barra.setMinimum(min);
           	barra.setMaximum(max);
    
		      for(int i=min; i <= max; i++ )
		      {
			      barra.setValue( i );    
		         try
		         {
			         hilo.sleep(150);
		         }
		         catch(InterruptedException ie){}
		      }
		      Virus madre = new Virus();
		      hide();
		      dispose();
		      
		      barra.setValue(min);   
		   }
		   catch(Exception miniu){}		   		       
      }
   }    
}
   
           

	