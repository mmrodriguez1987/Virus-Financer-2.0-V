
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Date;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class FrmSplash extends JWindow implements Runnable
{
public Thread hilo = new Thread();

	public void run(){
		JLabel SplashLabel = new JLabel(new ImageIcon("Imagenes/SuperFeria.jpg"));
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
			 
      //hilo = new Carga();	
		//hilo.start();	
  		getContentPane().add(SplashLabel,BorderLayout.CENTER);
		
		setSize(497,305);
		setLocation((screen.width - 490)/2,((screen.height-300)/2));
		show();
	}

}