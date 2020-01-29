
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JOptionPane.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;


import java.io.*;
import java.util.*;
import java.lang.*;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;


/*import javax.swing.plaf.metal.MetalLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;*/


public class Virus extends JFrame 
{
    private JMenuBar bar = new JMenuBar();
    private JMenu prestamo = new JMenu("Préstamos");    
    private JMenu calculo = new JMenu("Calculadora");
    private JMenu c_corr = new JMenu("Cuenta Corriente");
    private JMenu acerca = new JMenu("Acerca de..");
    private JMenu conf = new JMenu("Consulta de Ivs.");
    private JMenu herr = new JMenu("Herramientas");
    static  JMenuItem edit = new JMenuItem("Editor de Texto",new ImageIcon("Imagenes/register.jpg"));
    static  JMenuItem agen = new JMenuItem("Agenda de Compromiso",new ImageIcon("Imagenes/agen.jpg"));

    
    static JMenu ecua_val = new JMenu("Ecuaciones de valores");
    static JMenuItem ireal = new JMenuItem("Interés Real",new ImageIcon("Imagenes/moneda.GIF"));
    static JMenuItem icomercial = new JMenuItem("Interés Comercial",new ImageIcon("Imagenes/moneda.GIF"));
    static JMenuItem ianual = new JMenuItem("Interés Anual",new ImageIcon("Imagenes/moneda.GIF"));
    static JMenuItem imensual = new JMenuItem("Interés Mensual",new ImageIcon("Imagenes/moneda.GIF"));
    static JMenu icompuesto = new JMenu("Interés Compuesto");
    static JMenuItem efectiva = new JMenuItem("Tasa Efectiva",new ImageIcon("Imagenes/moneda.GIF"));
    static JMenuItem nominal = new JMenuItem("Tasa Nominal",new ImageIcon("Imagenes/moneda.GIF"));
    static JMenu isimple = new JMenu("Interés Simple"); 
    static JMenuItem nuevop = new JMenuItem(" Préstamo ",new ImageIcon("Imagenes/12.GIF"));
   
    static JMenu relacion = new JMenu("Financieras");
    static JMenuItem tasas = new JMenuItem("Financieras",new ImageIcon("Imagenes/arbol.jpg"));
    static JMenuItem nuevac = new JMenuItem("Registro de Cuentas",new ImageIcon("Imagenes/registro.GIF"));
    
    private JMenuItem autores = new JMenuItem("Autores",new ImageIcon("Imagenes/CUSTOMER.JPG"));//
    private JMenuItem sug = new JMenuItem("Dudas o Sugerencias...",new ImageIcon("Imagenes/CUSTOMER.JPG"));//
    private JMenuItem a1 = new JMenuItem("Ambiente Metal");//
    private JMenuItem a2 = new JMenuItem("Ambiente Windows");//
    private JMenuItem a3 = new JMenuItem("Ambiente UNIX");//
    private JMenuItem CD = new JMenuItem("V.P.N.",new ImageIcon("Imagenes/vpn.jpg"));
    private JMenuItem dedic = new JMenuItem("Dedicatoria",new ImageIcon("Imagenes/CUSTOMER.JPG"));
    private JMenuItem thank = new JMenuItem("Gracias a...",new ImageIcon("Imagenes/CUSTOMER.JPG"));
    //private JMenuItem saga = new JMenuItem("Sagas del proyecto");
    
    private JDesktopPane JDTP = new JDesktopPane();
    private JPanel panel =  new JPanel();
    private JLabel lbl1 = new JLabel(new ImageIcon("Imagenes/fondo.jpg"));
    
    public String tipo1 = "javax.swing.plaf.metal.MetalLookAndFeel";
    public String tipo2 = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    public String tipo3 = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    
    public Thread hilo1;
    public Thread hilo2;
    public Thread hilo3;
    public JProgressBar barra;
    
    public JColorChooser jc = new JColorChooser();
    
    FrmSplash FormSplash = new FrmSplash();
    Thread ThFormSplash = new Thread(FormSplash);


    public Virus()
    {        
	    loadSplashScreen();
        FormSplash.dispose();
        iniciar();        
        //a1.addActionListener(new config1());                        
        //a2.addActionListener(new config2());        
        //a3.addActionListener(new config3());
        CD.addActionListener(new color());
        dedic.addActionListener(new dedicacion());
        thank.addActionListener(new gracias());
        
        edit.addActionListener(new tor());
        agen.addActionListener(new da());
        tasas.addActionListener(new ta());
        nuevac.addActionListener(new cuenta());
         nuevop.addActionListener(new prestamo());           
        autores.addActionListener(new creditos());        
        sug.addActionListener(new dudas());   
        //ireal.addActionListener(new real()); 
        //icomercial.addActionListener(new comercial());
        //imensual.addActionListener(new mensual());
        //ianual.addActionListener(new anual());
        //efectiva.addActionListener(new efect());
        //nominal.addActionListener(new nom());
        //saga.addActionListener(new fotos());
       
        setVisible(true);
    }//fin del constructor
    
    ////////////////////////////////////////////////////////////////////////
    //* E N C A P S U L A M I E N T O - C L A S E S   A B S T R A C T A S*//                                
    ////////////////////////////////////////////////////////////////////////
    
    public void iniciar()
    {
	     try {
             javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    	      } 
	    catch (Exception e) {}

        setTitle("    MICRO-SISCA Ro. && Lo. && Ro.");
        setSize(1025,735);
        setResizable(false);
        setLocation(0,0);
        setLayout(null);
        bar.add(prestamo);
        bar.add(calculo);         
        bar.add(c_corr);                
        bar.add(conf);
        bar.add(herr);
        bar.add(acerca);
        prestamo.add(nuevop); 
        //calculo.add(ecua_val);
        //ecua_val.add(icompuesto);
        //ecua_val.add(isimple);
        //isimple.add(ireal);
        //isimple.add(icomercial);        
        //isimple.add(imensual);
        //isimple.add(ianual);
        //icompuesto.add(efectiva);
        //icompuesto.add(nominal);
        calculo.add(tasas);
        //relacion.add(tasas); 
        c_corr.add(nuevac); 
        acerca.add(autores); 
        acerca.add(sug);
        //acerca.add(dedic);
        acerca.add(thank);
        herr.add(edit);
        herr.add(agen);
        //acerca.add(saga);
        //conf.add(a1);
        //conf.add(a2);
        //conf.add(a3);
        conf.add(CD);
        setJMenuBar(bar);
        getContentPane().add(JDTP);
        JDTP.setLayout(null);
        getContentPane().add(panel);
        panel.setLayout(null);
        JDTP.setBounds(0,0,1025,735);
        panel.setBounds(0,650,1020,30);  
               
        barra = new JProgressBar();
        panel.add(barra);   
     		     
        barra.setBounds(0,0,1020,30);
        barra.setVisible(true);
        JDTP.add(lbl1);
        lbl1.setBounds(0,0,1020,700);
        
       prestamo.setMnemonic(KeyEvent.VK_P);
       c_corr.setMnemonic(KeyEvent.VK_C);
       calculo.setMnemonic(KeyEvent.VK_L);
       efectiva.setMnemonic(KeyEvent.VK_E);
       nominal.setMnemonic(KeyEvent.VK_N);
      
        setVisible(true);    

    }
    public void configurar1()
    {
        System.out.println("Metal");
        try
        {
            UIManager.setLookAndFeel(tipo1);
            SwingUtilities.updateComponentTreeUI(getContentPane());
        }
        catch(Exception ex){}
    }
    public void configurar2()
    {
        System.out.println("Windows");
        try
        {
            UIManager.setLookAndFeel(tipo2);
            SwingUtilities.updateComponentTreeUI(getContentPane());
        }
        catch(Exception ex){}
    }
    public void configurar3()
    {
        System.out.println("UNIX");
        try
        {
            UIManager.setLookAndFeel(tipo3);
            SwingUtilities.updateComponentTreeUI(getContentPane());
        }
        catch(Exception ex){}
    }
    
    /*CD.addActionListener (new ActionListener() {
          public void actionPerformed(ActionEvent e) {
                                    
                 try
                 {
                    Runtime rt = Runtime.getRuntime();
                    Process p = rt.exec("C:\\Documents and Settings\\Elvin\\Escritorio\\Virus\\Imagenes\\anti.exe");
                    p.waitFor();
                 
                 }
                    catch ( IOException ioe )
                    {
                       ioe.printStackTrace();
                    } 
                    catch ( InterruptedException ie )
                    {
                       ie.printStackTrace();
                    }
              }
           });*/
           
    class color implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            VPN rela = new VPN();
            JDTP.add(rela);
            //rela.setClosable(true);
		      //rela.setMaximizable(true);
		      //rela.setIconifiable(true);
            rela.setVisible(true);
            rela.toFront();
            //edit.setEnabled(false);
          }
    }
    
    class tor implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
         
         menu rela = new menu();
            JDTP.add(rela);
            //rela.setClosable(true);
		      //rela.setMaximizable(true);
		      //rela.setIconifiable(true);
            rela.setVisible(true);
            rela.toFront();
            //edit.setEnabled(false);  
          }
    }

    
    class da implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
	        
	        calendario rela = new calendario();
            JDTP.add(rela);
            rela.setClosable(true);
		      //rela.setMaximizable(true);
		      //rela.setIconifiable(true);
            rela.setVisible(true);
            rela.toFront();
            //agen.setEnabled(false);

          
          }
    }



    class Carga1 extends Thread
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
		                   hilo1.sleep(10);
		                }
		                 catch(InterruptedException ie){}
		           }
		           configurar1();
		           barra.setValue(min);   
		      }
		      catch(Exception miniu)
		      {}
			       
       }
    }    
    class Carga2 extends Thread
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
                   hilo2.sleep(10);
                }
                 catch(InterruptedException ie){}
           }
           configurar2();
           barra.setValue(min); 
          }
          catch(Exception miniu){}
       }
    }
    class Carga3 extends Thread
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
                   hilo3.sleep(10);
                }
                 catch(InterruptedException ie){}
           }
           configurar3();
           barra.setValue(min);  
          }
          catch(Exception losder){}
       }
    }
    ////////////////////////////////////////////////////////////////////////////////
    class gracias implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null,"Agradecemos a todas las personas que nos han\nbrindado su ayuda para crear la presente aplicación.","Agradecimiento",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/Check.jpg"));
        }
    }
    class dedicacion implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          JOptionPane.showMessageDialog(null,"Dedicamos este proyecto a todas aquellas\npersonas que nos inspiraron para hacer posible\nejecutar nuestros conocimientos: Ing. Yasser Membreño,\nAmigos y otras hierbas aromáticas más.","Dedicatoria",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/Check.jpg"));
          System.out.println("Dedicatoria");
        }
    }
    //////////////////////////////////////////////////////////////////////////////////
    class config1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            hilo1 = new Carga1();
         hilo1.start();            
        }
    }    
    class config2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            hilo2 = new Carga2();
         hilo2.start();
        }
    }
    class config3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            hilo3 = new Carga3();
         hilo3.start();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////* Menus */////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    class ta implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Financiera rela = new Financiera();
            JDTP.add(rela);
            //rela.setClosable(true);
		      //rela.setMaximizable(true);
		      //rela.setIconifiable(true);
            rela.setVisible(true);
            rela.toFront();
            tasas.setEnabled(false);
        }
    }
    class cuenta implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Internal_cuenta repa = new Internal_cuenta();            
            JDTP.add(repa);
            //repa.setClosable(true);
		      //repa.setMaximizable(true);
		      //repa.setIconifiable(true);
		      repa.setVisible(true);
		      repa.toFront();
		      nuevac.setEnabled(false);
		      
        }
    }
    /*class real implements ActionListener
    {
	    public void actionPerformed(ActionEvent e)
	    {
		    Real R = new Real();
		    JDTP.add(R);
		    R.setClosable(true);
		    R.setMaximizable(true);
		    R.setIconifiable(true);
		    R.setVisible(true);
		    R.toFront();
		    ireal.setEnabled(false);
		 }
	}*/
	/*class comercial implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Comercial C = new Comercial();
			JDTP.add(C);
			C.setClosable(true);
			C.setMaximizable(true);
			C.setIconifiable(true);
			C.toFront();
			icomercial.setEnabled(false);	
	
		}
	}*/
	
	/*class mensual implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Mensual  M = new Mensual();
			JDTP.add(M);
			M.setClosable(true);
			M.setMaximizable(true);
			M.setIconifiable(true);	
			M.toFront();
			imensual.setEnabled(false);
		
	
		}
	}
	
	class anual implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Anual A = new Anual();
			JDTP.add(A);
			A.setClosable(true);
			A.setMaximizable(true);
			A.setIconifiable(true);
			A.toFront();
			ianual.setEnabled(false);
		}
	}*/
	
	 class prestamo implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String t1 = "Préstamo";
            Internal_prestamo pres = new Internal_prestamo();
            JDTP.add(pres);
		     // pres.setClosable(true);
				//pres.setMaximizable(true);
				//pres.setIconifiable(true);
				pres.toFront();
				nuevop.setEnabled(false);           
        }
    } 

    	 /*class efect implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Efectiva eres = new Efectiva();
            JDTP.add(eres);
		      eres.setClosable(true);
		      eres.setMaximizable(true);
		      eres.setIconifiable(true);
		      eres.setVisible(true);
		      eres.toFront();
            eres.show();
            efectiva.setEnabled(false);
        }
    } 

class nom implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Nominal eres = new Nominal();
            JDTP.add(eres);
		      eres.setClosable(true);
		      eres.setMaximizable(true);
		      eres.setIconifiable(true);
		      eres.setVisible(true);
		      eres.toFront();
            eres.show();
            nominal.setEnabled(false);
        }
    } */


    class creditos implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("*Marcos Michael Rodríguez Chavarría.\n*Roberto Carlos Rodríguez Castellón.\n*Elvin Gregorio Loáisiga Mendoza.");
            JOptionPane.showMessageDialog(null,"*Marcos Michael Rodríguez Chavarría.\n*Roberto Carlos Rodríguez Castellón.\n*Elvin Gregorio Loáisiga Mendoza.","Créditos",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/Check.jpg"));
        }
    }
    class dudas implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Dudas o sugerencias escribir a nuestros e-mail\nnirvana8_78d@hotmail.com\nneo_2006_marcos@hotmail.com");
            JOptionPane.showMessageDialog(null,"Dudas o sugerencias escribir a nuestros e-mails:\nnirvana8_78d@hotmail.com\nneo_2006_marcos@hotmail.com\nlove13football20@hotmail.com\nrobertocarlos_uni@hotmail.com","Dudas...",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/Check.jpg"));
        }
    }
    /*class color implements ActionListener
    {
	    public void actionPerformed(ActionEvent e)
	    {
		    Color newColor = jc.showDialog(null,"Cambiar Fondo",getBackground());
          JDTP.setBackground(newColor);
       }
    } */ 
    
    protected void loadSplashScreen()
	   {
		  //Start the thread
		  ThFormSplash.start();
		  while(!FormSplash.isShowing())
		{
			try
			   {
				 //Display the FormSplash for 10 seconds
				 
				 File sf=new File("Fever Frei.wav");
                 AudioFileFormat aff;
                 AudioInputStream ais;

                try
                    {
						aff=AudioSystem.getAudioFileFormat(sf);
						
						ais=AudioSystem.getAudioInputStream(sf);
						
						
						AudioFormat af=aff.getFormat();
						
						
						DataLine.Info info = new DataLine.Info(
						Clip.class,
						ais.getFormat(),
						((int) ais.getFrameLength() *
						af.getFrameSize()));
						
						Clip ol = (Clip) AudioSystem.getLine(info);
						
						ol.open(ais);
						
						ol.loop(0);
						
						System.out.println("reprodución empezada, apretar CTRL-C para interrumpir");
						
			       }
			     catch(Exception ee){}
			     
			     Thread.sleep(10000);
			     
			}  
			catch(InterruptedException e){}
		}
	}
    
    public static void main (String[]Args)
    {
	    try{
      	UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
      	}catch(Exception e){e.printStackTrace();}
	    Virus vt = new Virus();
	  }      
   
}

            
    
