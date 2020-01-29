

import java.lang.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
    
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.border.*;
import java.lang.*;
import javax.swing.text.*;
import java.io.*;
import java.util.Vector;
import javax.swing.JTable.*;
import java.lang.*;

public class Internal_cuenta extends JInternalFrame 
{	
	private JMenuBar barra = new JMenuBar();
	private JMenu file = new JMenu("Archivo");
	private JMenu herr = new JMenu("Herramientas");
	private JMenuItem  calc = new JMenuItem("Calculadora",new ImageIcon("Imagenes/calcu.jpg"));
	private JMenuItem  imp = new JMenuItem("Imprimir Estado",new ImageIcon("Imagenes/impre.jpg"));
   private JMenuItem  ex = new JMenuItem("Estado a Excel", new ImageIcon("Imagenes/excel.jpg"));
	private JMenuItem save = new JMenuItem("Guardar",new ImageIcon("Imagenes/Guardar.jpg"));
	private JMenuItem open = new JMenuItem("Abrir",new ImageIcon("Imagenes/Abrir.jpg"));
	private JMenuItem close = new JMenuItem("Cerrar",new ImageIcon("Imagenes/Cerrar.jpg"));
	

	private JPanel p_tablas = new JPanel();
	private JPanel p_botones = new JPanel();
	private JPanel p_hilo_carga = new JPanel();
	private JPanel tipo_cuenta = new JPanel();
	private JPanel JP1 = new JPanel();
	private JPanel JP2 = new JPanel(); 
	private JPanel mega_panel = new JPanel();
	private JPanel c_cuenta = new JPanel();
	
	private JButton cancelar = new JButton("Cancelar",new ImageIcon("Imagenes/cancelar.GIF"));
	private JButton limpiar = new JButton("Restablecer",new ImageIcon("Imagenes/Flag.jpg"));
	private JLabel lbltransaccion = new JLabel("Tipo de transacción:");
	private JButton saldo = new JButton("Saldo",new ImageIcon("Imagenes/saldo.GIF"));

	private JButton inic = new JButton("Paso I",new ImageIcon("Imagenes/Check.jpg"));
	private JButton inic1 = new JButton("Paso II",new ImageIcon("Imagenes/Check.jpg"));
	private JButton b_deposito = new JButton("  Depositar  ",new ImageIcon("Imagenes/reti1.jpg"));
	private JButton b_retiro = new JButton("  Retirar   ",new ImageIcon("Imagenes/reti.jpg"));
	private JLabel tran = new JLabel(new ImageIcon("Imagenes/tran.GIF"));
	private JLabel pajaro = new JLabel(new ImageIcon("Imagenes/dol.jpg"));
	
	private JTabbedPane tabla = new JTabbedPane();
	
	private JTextField txtnombres = new JTextField();
	private JTextField txtapellidos = new JTextField();
	private JFormattedTextField txttelefono = new JFormattedTextField();
	private JFormattedTextField txtcelular = new JFormattedTextField();
	private JTextArea txtdireccion = new JTextArea();
	private JFormattedTextField txtedad = new JFormattedTextField ();
	private JFormattedTextField txtcedula = new JFormattedTextField();
	private JFormattedTextField tfecha = new JFormattedTextField(new Date());
		
	private JLabel lblnombres = new JLabel("Nombres: ");
	private JLabel lblapellidos = new JLabel("Apellidos: ");
	private JLabel lbltelefono = new JLabel("Teléfono: ");
	private JLabel lblcelular = new JLabel("Celular: ");
	private JLabel lbldireccion = new JLabel("Dirección: ");
	private JLabel lblsexo = new JLabel("Sexo: ");
	private JLabel lblcedula= new JLabel("Cédula: ");
	private JLabel lblciudad = new JLabel("Ciudad: ");
	private JLabel lbledad = new JLabel("Edad: ");
	private JLabel lblprofesion = new JLabel("Profesión: ");
	private JLabel lblcuota = new JLabel("Cuota (C$): ");
	private JTextField txt_cuota = new JTextField(3);
	
	private JScrollPane JS = new JScrollPane();
	private JButton retiro = new JButton("Retiro");
	private JButton deposito = new JButton("Depósito");
    private JRadioButton tipo1 = new JRadioButton("Cuenta Corriente",new ImageIcon ("Imagenes/CUSTOMER.jpg"));
    private JRadioButton tipo2 = new JRadioButton("Cuenta Cuota Fija",new ImageIcon ("Imagenes/CUSTOMER.jpg"));
    private JRadioButton tipo3 = new JRadioButton("Cuenta Navidad",new ImageIcon ("Imagenes/CUSTOMER.jpg"));
	
	private JRadioButton c0 = new JRadioButton("C$  50");
	private JRadioButton c1 = new JRadioButton("C$ 100");
	private JRadioButton c2 = new JRadioButton("C$ 150");
    private JRadioButton c3 = new JRadioButton("C$ 200");
    private JRadioButton c4 = new JRadioButton("C$ 250");
    private JRadioButton c5 = new JRadioButton("C$ 300");
    private static String num_cuenta = null;
    private static int contame = 0;
    
    
	private JLabel fecha = new JLabel("Fecha de la transacción:");
	
	private JLabel montolbl = new JLabel("Monto Inicial ( C$ ):");
	
	private JTextField montotxt = new JTextField();
	
	
	
	static DefaultTableModel modelotabla;
    static Vector nuevafila;
    static JTable jtable = new JTable(); 
 	private String fe;
	private float dep,ret,ta,sa;
	 
	private JFileChooser f;
    DataOutputStream escribir;
    DataInputStream leer;
    File name,modelo;
	 
	public String var_nom = null;
	public String var_ape = null;
	public String var_tel = null;
	public String var_cel = null;
	public String var_dir = null;
	public String var_sex;
	public String var_ced = null;
	public String var_ciu;
	public String var_eda = null;
	public String var_pro;
	public String var_fecha = null;
	
	Date objeto= new Date();
	
	
	public double var_deposito;
	public double abono_depo = 0,abono_reti;
	public double var_retiro;
	public double var_saldo;
	public double var_cuota =0,cuota_nav = 0,limite = 0, cuota_fija =0;
	public String var_transaccion;
	public String t_fecha = null;
	public int indice = 0;
	public int index = 0, sub_index = 0;
	public double var_tasa;
	public double interes =0;
	public int dia = 0,mes = 0,año = 0,confir =0;
	
	private File g;
	private RandomAccessFile output,input;
    private Record data;
	private int fila = 0;
	private int columna = 0;
	boolean resto=true;
	
	
	public Internal_cuenta()
	{
		construir();

		txtnombres.addKeyListener(new KeyAdapter()
   		{
		   public void keyTyped(KeyEvent e){
   
	      char c = e.getKeyChar(); 
	      int x = e.getKeyChar(); 
	      int keyCode = e.getKeyCode();
	     
	      	if (Character.isDigit(c)) 
	        
	      	{ 
	        		try
			    	{ 
				   	txtnombres.setText("");
				   	e.consume();
				   }
				   catch(Exception E){} 
	         }   
		   }
		});
		
		txtapellidos.addKeyListener(new KeyAdapter()
	   	{
			   public void keyTyped(KeyEvent e){
	   
		      char c = e.getKeyChar(); 
		      int x = e.getKeyChar(); 
		      int keyCode = e.getKeyCode();
		     
	      	if (Character.isDigit(c))
	        
	      	{ 
	        		try
			    	{ 
				   	txtapellidos.setText("");
				   	e.consume();
				   }
				   catch(Exception E){} 
	         }   
		   }
		});
		montotxt.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar(); 
		  		int x = e.getKeyChar(); 
		  		int keyCode = e.getKeyCode();
		    
	   			if (!((Character.isDigit(c)) || (c == '.'))) 
	       
	   			{
			      	try
		         	{ 
				         	montotxt.setText("");
				   		e.consume();
				   }
				   catch(Exception E){} 
	         	}   
		   }
		});
		
		txt_cuota.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar(); 
		  		int x = e.getKeyChar(); 
		  		int keyCode = e.getKeyCode();
		    
	   			if (!((Character.isDigit(c)) || (c == '.'))) 
	       
	   			{
			      	try
		         	{ 
				         	montotxt.setText("");
				   		e.consume();
				   }
				   catch(Exception E){} 
	         	}   
		   }
		});
		
		tipo1.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent q)
         {
         	tipo2.setSelected(false);
         	tipo3.setSelected(false);
         }
        });
        
        tipo2.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent w)
         {
         	tipo1.setSelected(false);
         	tipo3.setSelected(false);
         }
        });
        
        tipo3.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent ew)
         {
         	tipo1.setSelected(false);
         	tipo2.setSelected(false);
         }
        });
        
        c0.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent ew)
         {
         	c1.setSelected(false);  c2.setSelected(false);  c3.setSelected(false);
         	c4.setSelected(false);  c5.setSelected(false);
         
         }
        });
        
        c1.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent ew)
         {
         	c0.setSelected(false);  c2.setSelected(false);  c3.setSelected(false);
         	c4.setSelected(false);  c5.setSelected(false);
         }
        });
        
        c2.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent ew)
         {
         	c1.setSelected(false);  c0.setSelected(false);  c3.setSelected(false);
         	c4.setSelected(false);  c5.setSelected(false);
         }
        });
        
        c3.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent ew)
         {
         	c1.setSelected(false);  c2.setSelected(false);  c0.setSelected(false);
         	c4.setSelected(false);  c5.setSelected(false);
         }
        });
        
        c4.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent ew)
         {
         	c1.setSelected(false);  c2.setSelected(false);  c3.setSelected(false);
         	c0.setSelected(false);  c5.setSelected(false);
         }
        });
        
        c5.addMouseListener(new MouseAdapter()
        {
         public void mousePressed(MouseEvent ew)
         {
         	c1.setSelected(false);  c2.setSelected(false);  c3.setSelected(false);
         	c4.setSelected(false);  c0.setSelected(false);
         }
        });
        
        calc.addActionListener(
                                 new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                    
                                       try
                                       {
                                          Runtime rt = Runtime.getRuntime();
                                          Process p = rt.exec("calc.exe");
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
                                 });
                                 
            imp.addActionListener(
    		new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				PrinterJob job = PrinterJob.getPrinterJob();
    				job.setPrintable(new PrintObject());
    				job.printDialog();
    				if (job.printDialog())
    			      {
    			         try { job.print(); }
    			         catch (PrinterException excep) { System.out.println(excep); }
    			      }
    			}
    		});
		    
		    ex.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e)
			    {
    		     AExcel.crearExcel("Excel/Estado1.xls","Estado de Cuenta",jtable.getModel());
		         JOptionPane.showMessageDialog( null,"Se ha agregado su calendario a la hoja Calendario\n está lista para que la vea","Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/nike.gif"));
    			}
    		});
        
		cancelar.addActionListener(new class_cerrar());
		limpiar.addActionListener(new class_limpiar());		
		close.addActionListener(new class_close());
		
		inic.addActionListener(new class_inic());
		inic1.addActionListener(new class_inic1());		
		save.addActionListener(new class_save());
		b_retiro.addActionListener(new c_retiro());
		b_deposito.addActionListener(new c_deposito());		
		open.addActionListener(new class_open());
		
		tipo1.addActionListener(new corriente());
		tipo2.addActionListener(new fija());
		tipo3.addActionListener(new navidad());
		c0.addActionListener(new c_c0());
		c1.addActionListener(new c_c1());
		c2.addActionListener(new c_c2());
		c3.addActionListener(new c_c3());
		c4.addActionListener(new c_c4());
		c5.addActionListener(new c_c5());		
		
		setDefaultCloseOperation(javax.swing.JInternalFrame.EXIT_ON_CLOSE);
	}
   public void construir()
   {
	  setTitle("§ Sistema Cuenta de Ahorro");
	  //setFrameIcon(new javax.swing.ImageIcon("cuenta.GIF"));
	  setLayout(null);
	  setBackground(new java.awt.Color(204,204,204));
	  setSize(850,540);
	  setLocation(70,40);
	 
	  file.add(open);
	  file.add(save);
	  file.add(close);
	  herr.add(calc);
	  herr.add(imp);
	  herr.add(ex);
	  barra.add(file);
	  barra.add(herr);
	  setJMenuBar(barra);
	  getContentPane().add(p_botones);
	  getContentPane().add(p_tablas);
	  getContentPane().add(p_hilo_carga);
	  
	  p_botones.setLayout(null);
	  p_tablas.setLayout(null);
	  p_hilo_carga.setLayout(null);	  	 
	  
	  construir_JP1();
	  construir_panel_botones();
	  construir_JP2(); 
	  
	  tabla.addTab("Datos Personales",new ImageIcon("Imagenes/register.jpg"),mega_panel);
	  tabla.addTab("Estado de Cuenta",new ImageIcon("Imagenes/esa.jpg"),JP2);
	  
	  construir_panel_tabla();
	 
	  p_tablas.setBounds(0,0,850,590);	  
	 	  
	  setVisible(true);
	   
	}

	public void construir_JP1()
	{  
	    mega_panel.setLayout(null);  
		mega_panel.add(JP1); 
		mega_panel.add(pajaro);
		mega_panel.add(inic);  
		mega_panel.add(inic1);  
    	mega_panel.setBackground(new java.awt.Color(255,255,255));
		getContentPane().add(mega_panel);
		
		JP1.setLayout(null);
		JP1.setBounds(15,0,370,350);
		JP1.setBackground(new java.awt.Color(255,255,255));
		JP1.setBorder(new TitledBorder(null,"Datos del Cliente",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, new Font("High Tower Text",0,18), new Color(0,0,255)));
        
	  
	   JP1.add(lblnombres);					    JP1.add(txtnombres);
	   JP1.add(lblapellidos);			        JP1.add(txtapellidos);
	   JP1.add(lbltelefono);	   			    JP1.add(txtcelular);
	   JP1.add(lblcelular);				    	JP1.add(txttelefono);
	   JP1.add(lbldireccion);  	    		    JP1.add(txtedad);		
	   JP1.add(lblcedula);			
	   JP1.add(lbledad);				
	   JP1.add(txtcedula);
	           	  
	  
	   lblnombres.setBounds(10,30,100,20);		txtnombres.setBounds(120,30,220,20);
	   lblapellidos.setBounds(10,60,100,20);	txtapellidos.setBounds(120,60,220,20);
	   lbledad.setBounds(10,90,100,20);			txtedad.setBounds(120,90,30,20);
	   lblcedula.setBounds(10,120,100,20);		txtcedula.setBounds(120,120,130,20);
	   lbltelefono.setBounds(10,150,100,20);	txttelefono.setBounds(120,150,130,20);
	   lblcelular.setBounds(10,180,100,20);		txtcelular.setBounds(120,180,130,20);
	   lbldireccion.setBounds(10,210,100,20);    
	  
	   pajaro.setBounds(490,50,200,282);
	   pajaro.setVisible(true);
	   inic.setBounds(170,360,120,20);
	   inic1.setBounds(520,360,120,20);
	   inic1.setEnabled(false);
	   Box box = Box.createHorizontalBox();


       txtdireccion = new JTextArea ();  
       box.add( new JScrollPane( txtdireccion ) );   
       JP1.add(box);
       box.setBounds(120,210,220,60);   


	  
	   txtnombres.setToolTipText("Sus dos nombres,por favor"); 
	   txtapellidos.setToolTipText("Sus dos apellidos,por favor");
	   txttelefono.setToolTipText("Su número de teléfono convencional");
	   txtcelular.setToolTipText("Su número de teléfono celular");
	   txtdireccion.setToolTipText("Su dirección exacta");
	   txtcedula.setToolTipText("Su número de cédula");
	   txtedad.setToolTipText("Su edad");
	   limpiar.setToolTipText("Le permite limpiar los campos para iniciar otra nueva cuenta");
	   inic.setToolTipText("Permite registrar los datos personales");
	  
	  
	  
	  try
		{
			MaskFormatter mf = new MaskFormatter("###-######-####U");
			mf.setPlaceholderCharacter('_');
			DefaultFormatterFactory df = new DefaultFormatterFactory(mf);
			txtcedula.setFormatterFactory(df);
		}
		catch(Exception e){}
		
		try
		{
			MaskFormatter mf = new MaskFormatter("###-####");
			mf.setPlaceholderCharacter('_');
			DefaultFormatterFactory df = new DefaultFormatterFactory(mf);
			txttelefono.setFormatterFactory(df);
		}
		catch(Exception e){}
		try
		{
			MaskFormatter mf = new MaskFormatter("###-####");
			mf.setPlaceholderCharacter('_');
			DefaultFormatterFactory df = new DefaultFormatterFactory(mf);
			txtcelular.setFormatterFactory(df);
		}
		catch(Exception e){}
		
		try
		{
			MaskFormatter mf = new MaskFormatter("##");
			DefaultFormatterFactory df = new DefaultFormatterFactory(mf);
			txtedad.setFormatterFactory(df);
		}
		catch(Exception e){}
		
		
	  	
	}
	public void construir_JP2()//tabla
	{	
	 getContentPane().add(JP2);
	 JP2.setLayout(null);
	   
	 JP2.setBackground(new java.awt.Color(100,160,200));
	 JP2.add(jtable);
	 JP2.add(JS);
	 JP2.add(b_deposito);
	 JP2.add(b_retiro);
	 JP2.add(limpiar);
	 
	 b_deposito.setBounds(645,90,135,25);   b_deposito.setBackground(new java.awt.Color(255,255,255)); b_deposito.setForeground(new java.awt.Color(0,0,0));
	 b_retiro.setBounds(645,120,135,25);    b_retiro.setBackground(new java.awt.Color(255,255,255));   b_retiro.setForeground(new java.awt.Color(0,0,0));
	 limpiar.setBounds(645,150,135,25);     limpiar.setBackground(new java.awt.Color(255,255,255));    limpiar.setForeground(new java.awt.Color(0,0,0));
	 
	 b_retiro.setEnabled(false);   b_deposito.setEnabled(false);
	      
	 jtable.setBounds(10,10,630,400);
	 jtable.setBackground(new java.awt.Color(255,255,255));
	 JS.setBounds(10, 10,630, 400);
     jtable.setModel(new DefaultTableModel(
            new Object [][] {
					
            },
            new String [] {
                "Fecha", "Depósito", "Retiro", "Interés", "Saldo"
            }
        ) {
	        Class[] types = new Class [] { 
		     		String.class, Double.class, Double.class, Double.class, Double.class
		     };
		     boolean[] canEdit = new boolean [] {
			     false, false, false, false, false
			     
			  };
	        
           public Class getColumnClass(int columnIndex) 
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) 
            {
                return canEdit [columnIndex];
            }
        });
			jtable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
			JS.setViewportView(jtable);
	}
	public void construir_panel_tabla()
	{   p_tablas.setBackground(new java.awt.Color(0,0,0));
		p_tablas.add(tabla);
		tabla.setBounds(10,10,800,450);		
	}
	
	public void construir_panel_botones()
	{ 
		mega_panel.add(p_botones);
	    getContentPane().add(mega_panel);
		p_botones.setLayout(null);
	    p_botones.add(tipo_cuenta);
	    p_botones.add(montotxt);
	    p_botones.add(montolbl);
	    p_botones.add(c_cuenta);
	    
	    c_cuenta.add(c0);    c0.setBackground(new java.awt.Color(255,255,255)); 
	    c_cuenta.add(c1);    c1.setBackground(new java.awt.Color(255,255,255));
	    c_cuenta.add(c2);    c2.setBackground(new java.awt.Color(255,255,255));
	    c_cuenta.add(c3);    c3.setBackground(new java.awt.Color(255,255,255));
	    c_cuenta.add(c4);    c4.setBackground(new java.awt.Color(255,255,255));
	    c_cuenta.add(c5);    c5.setBackground(new java.awt.Color(255,255,255));
	    
	    tipo_cuenta.setBackground(new java.awt.Color(255,255,255));
	    tipo_cuenta.setBounds(10,30,350,100);
	    tipo_cuenta.setBorder(new TitledBorder(null,"Tipo de Cuenta.",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, new Font("Verdan",3,12), new Color(0,0,255)));
	    
	    tipo_cuenta.add(tipo1); 
	    tipo_cuenta.add(tipo2); 
	    tipo_cuenta.add(tipo3); 
	    
	    c_cuenta.setBackground(new java.awt.Color(255,255,255));
	    c_cuenta.setBounds(10,160,350,100);
	    c_cuenta.setBorder(new TitledBorder(null,"Elija una Cuota .",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, new Font("Verdan",3,12), new Color(0,0,255)));
	    c_cuenta.setVisible(false);
	    p_botones.add(lblcuota);
	    p_botones.add(txt_cuota);
	    
	    montotxt.setBounds(200,150,80,20);   montotxt.setVisible(false);
	    montolbl.setBounds(50,150,130,20);   montolbl.setVisible(false);
	    lblcuota.setBounds(50,150,130,20);   txt_cuota.setBounds(200,150,80,20);
	    lblcuota.setVisible(false);          txt_cuota.setVisible(false);
	    
	    
	    
	    tipo1.setToolTipText("En esta cuenta,puede depositar cualquier cantidad.");
	    tipo2.setToolTipText("En esta cuenta puede establecer su cuota,pero esta será fija.");
	    tipo3.setToolTipText("En esta cuenta puede escojer una cuota establecida y fija.");
	    
	    tipo1.setRolloverEnabled(true);
	    
	    tipo1.setBackground(new java.awt.Color(255,255,255));
	    tipo2.setBackground(new java.awt.Color(255,255,255));
	    tipo3.setBackground(new java.awt.Color(255,255,255));
	    
           
	    p_botones.setBounds(410,0,370,350);
		p_botones.setBackground(new java.awt.Color(255,255,255));
		p_botones.setBorder(new TitledBorder(null,"Datos Generales de la Cuenta",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, new Font("High Tower Text",0,18), new Color(0,0,255)));
		p_botones.setVisible(false); 
	}
	


 
 class class_inic1 implements ActionListener
 {
 	
 	public void actionPerformed(ActionEvent evt)	
    {
         if(tipo1.isSelected() == true)
	     {   
	        index = 1;
	         	 
	  	 try 
	     	{
	     	
	         var_saldo = Double.parseDouble(montotxt.getText());
	         
	        }
	          catch(Exception jkv)
	        {
		        JOptionPane.showMessageDialog(null, "Por favor digite sólo datos permisibles", "Información del Sistema", JOptionPane.WARNING_MESSAGE,new ImageIcon("Imagenes/help.gif"));	
		        montotxt.setText("");
	        }
	         
	         
	        if(var_saldo != 0)
	        {
	        
			 System.out.println(var_saldo);
			 var_deposito = var_saldo;
			 System.out.println(var_deposito);
			 var_retiro = 0; var_tasa = 0;
			 interes = 0.08;
			 dia = objeto.getDate();
			 mes = objeto.getMonth() + 1;
			 año = objeto.getYear() + 1900;
			 t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
			 

			 
			 modelotabla =  (DefaultTableModel)jtable.getModel(); 
             nuevafila = new Vector();
			             
			 nuevafila.add(t_fecha);
			 nuevafila.add(var_deposito);
			 nuevafila.add(var_retiro);
			 nuevafila.add(var_tasa);
			 nuevafila.add(var_saldo);
			 modelotabla.addRow(nuevafila);
			 montotxt.setEnabled(false);
			 b_retiro.setEnabled(true);
			 b_deposito.setEnabled(true);
			 tabla.setSelectedIndex(1);
			 inic1.setEnabled(false);
			}
			 else
			 {
			 JOptionPane.showMessageDialog(null, "El monto inicial debe ser mayor que C$ 0 \n    ó distinto de un valor nulo.", "Información del Sistema", JOptionPane.WARNING_MESSAGE,new ImageIcon("Imagenes/help.gif"));	

			 }
			 
	     }
  
	     if(tipo2.isSelected()==true)
	     {  
	        index = 2;
	    	
		    try 
		     	{  		     	
			      var_cuota = Double.parseDouble(txt_cuota.getText()); 
		        }
	        catch(Exception jk)
		       {
		        JOptionPane.showMessageDialog(null, "Por favor digite sólo datos permisibles", "Información del Sistema", JOptionPane.WARNING_MESSAGE,new ImageIcon("Imagenes/help.gif"));
		        txt_cuota.setText("");
		        System.out.println(var_cuota);
		       }	
	        
	      if(var_cuota !=0)
	      {  
	        if(var_cuota <500 || var_cuota >1500)
	        {
	        	JOptionPane.showMessageDialog(null, "Su cuota debe ser entre \n C$ 500 y C$ 1500", "Información del Sistema", JOptionPane.WARNING_MESSAGE,new ImageIcon("Imagenes/help.gif"));
	        	txt_cuota.setText("");	   
	        }
	        else
	        {
	      
	         var_saldo = var_cuota;
	         cuota_fija = var_cuota;
			 System.out.println(var_saldo);
			 var_retiro = 0; var_tasa = 0;
			 interes = 0.05;
			 dia = objeto.getDate();
			 mes = objeto.getMonth() + 1;
		     año = objeto.getYear() + 1900;
		     t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
			 
		   	 modelotabla =  (DefaultTableModel)jtable.getModel(); 
             nuevafila = new Vector();
			             
		     nuevafila.add(t_fecha);
			 nuevafila.add(var_cuota);
			 nuevafila.add(var_retiro);
			 nuevafila.add(var_tasa);
			 nuevafila.add(var_saldo);
			 modelotabla.addRow(nuevafila);
			 txt_cuota.setEnabled(false);
			 tabla.setSelectedIndex(1);
			 b_retiro.setEnabled(true);
			 b_deposito.setEnabled(true);
			 inic1.setEnabled(false);
			}
		  }	 
	        
	     }
	     
    }
 	
 	
 }
 
 class PrintObject implements Printable
	{
		public int print(Graphics g, PageFormat pageFormat, 
	int pageIndex) throws PrinterException {
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(Color.black);
	int fontHeight=g2.getFontMetrics().getHeight();
	int fontDesent=g2.getFontMetrics().getDescent();
	double pageHeight = 
	pageFormat.getImageableHeight()-fontHeight;
	double pageWidth = pageFormat.getImageableWidth();
	double tableWidth = (double) 
	jtable.getColumnModel().getTotalColumnWidth();
	double scale = 1; 
	if (tableWidth >= pageWidth) {
	scale = pageWidth / tableWidth;
	}

	double headerHeightOnPage=
	jtable.getTableHeader().getHeight()*scale;
	double tableWidthOnPage=tableWidth*scale;
	double oneRowHeight=(jtable.getRowHeight()+
	jtable.getRowMargin())*scale;
	int numRowsOnAPage=(int)((pageHeight-headerHeightOnPage)/
	oneRowHeight);
	double pageHeightForTable=oneRowHeight*	numRowsOnAPage;
	int totalNumPages= (int)Math.ceil(((double)jtable.getRowCount())/
				numRowsOnAPage);
	if(pageIndex>=totalNumPages) {
	return NO_SUCH_PAGE;
		}

	g2.translate(pageFormat.getImageableX(), 
	pageFormat.getImageableY());
        //loque esta borrado es para enumerar las paginas
	/*g2.drawString("Página: "+(pageIndex+1),
	(int)pageWidth/2-35, (int)(pageHeight
	+fontHeight-fontDesent));*/

	g2.translate(0f,headerHeightOnPage);
	g2.translate(0f,-pageIndex*pageHeightForTable);
	if (pageIndex + 1 == totalNumPages) {
	int lastRowPrinted = 	numRowsOnAPage * pageIndex;
	int numRowsLeft = jtable.getRowCount() - lastRowPrinted;
	g2.setClip(0, (int)(pageHeightForTable * pageIndex),
	(int) Math.ceil(tableWidthOnPage),
	(int) Math.ceil(oneRowHeight * numRowsLeft));
				}

	else{ 
		g2.setClip(0, 
	(int)(pageHeightForTable*pageIndex), 
		(int) Math.ceil(tableWidthOnPage),
		(int) Math.ceil(pageHeightForTable)); 
				}

		g2.scale(scale,scale);
		jtable.paint(g2);
		g2.scale(1/scale,1/scale);
		g2.translate(0f,pageIndex*pageHeightForTable);
		g2.translate(0f, -headerHeightOnPage);
		g2.setClip(0, 0,
		(int) Math.ceil(tableWidthOnPage), 
		(int)Math.ceil(headerHeightOnPage));
		g2.scale(scale,scale);
		jtable.getTableHeader().paint(g2);


				return Printable.PAGE_EXISTS;
				}

	}
 
 
 class corriente implements ActionListener
 {
 	public void actionPerformed(ActionEvent sa)
 	{
 			
 		if(sa.getSource()==tipo1)
	     {
	      int result = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro del tipo de Cuenta?","Información del Sistema",JOptionPane.YES_NO_OPTION);
		      if(result == JOptionPane.YES_OPTION)
		      {
		      	tipo1.setEnabled(false);
		      	tipo2.setEnabled(false);
		      	tipo3.setEnabled(false);
		      	tipo2.setVisible(false);
		      	tipo3.setVisible(false);
		      	montolbl.setVisible(true);
	            montotxt.setVisible(true);
	            montotxt.setEnabled(true);
	            inic1.setEnabled(true);
		      	
		      }
		      
		      else
		      {
		      	tipo1.setEnabled(true);
		      	tipo2.setEnabled(true);
		      	tipo3.setEnabled(true);
		      }
	     }
     	
 	}
 	
 	
 }
 
 class fija implements ActionListener
 {
 	public void actionPerformed(ActionEvent d)
 	{
 		
 	       if(d.getSource()==tipo2)
            {
       	     int result = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro del tipo de Cuenta?","Información del Sistema",JOptionPane.YES_NO_OPTION);
		      if(result == txtprecio.YES_OPTION)
		      {
		      	tipo1.setEnabled(false);
		      	tipo2.setEnabled(false);
		      	tipo1.setVisible(false);
		      	tipo3.setVisible(false);
		      	tipo3.setEnabled(false);

		      	lblcuota.setVisible(true);
	            txt_cuota.setVisible(true);
	            txt_cuota.setEnabled(false);
	            txt_cuota.setEnabled(true);
	            inic1.setEnabled(true);
		      	
		      }
		      
		      else
		      {
		      	tipo1.setEnabled(true);
		      	tipo2.setEnabled(true);
		      	tipo3.setEnabled(true);
		      }
       	
       }
 	}
 	
 }
 
 
 class c_deposito implements ActionListener
 {
 	public void actionPerformed(ActionEvent dep)
 	{
 		if(tipo1.isSelected() == true)
 		{
 		  try
 		  { 
 		    do  
	         { 
	            var_cuota = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite la cantidad a depositar C$ : "," Depósito de  Cuenta Ambiente",JOptionPane.QUESTION_MESSAGE));
	            
	         }while(var_cuota == 0);
	         
	         var_saldo += var_cuota;
	         var_tasa = 0;
	         var_retiro = 0;
		     	
		 	
			 dia = objeto.getDate();
		     mes = objeto.getMonth() + 1;
			 año = objeto.getYear() + 1900;
		     t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
		     	
		     modelotabla =  (DefaultTableModel)jtable.getModel(); 
		     nuevafila = new Vector();
				             
			 nuevafila.add(t_fecha);
		     nuevafila.add(var_cuota);
			 nuevafila.add(var_retiro);
		   	 nuevafila.add(var_tasa);
			 nuevafila.add(var_saldo);
			 modelotabla.addRow(nuevafila);
	         
 		  	
 		  }
 		  catch(Exception put)
	      {
	      	JOptionPane.showMessageDialog(null,"Por favor digite sólo datos permisibles.","Información del Sistema.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));	
	      }	
 			
 		}
 		
 		if(tipo2.isSelected() == true)
 		{
 	    try
 		  {
 			 do  
	         { 
	            var_cuota = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite la cantidad a depositar C$ : "," Depósito de  Cuenta Ambiente ( § Cuenta Corriente).",JOptionPane.QUESTION_MESSAGE));
	            
	         }while(var_cuota == 0);
	         
	         if(var_cuota != cuota_fija)
	         {
	         JOptionPane.showMessageDialog(null,"Recuerde que su depósito debe ser igual\n   a la cuota establecida (C$ "+cuota_fija+" ).","Depósito § Cuenta Cuota Fija.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));		
	         }
	         else 
	         {
	         var_saldo += var_cuota;
	         var_tasa = 0;
	         var_retiro = 0;
		     	
		 	
			 dia = objeto.getDate();
		     mes = objeto.getMonth() + 1;
			 año = objeto.getYear() + 1900;
		     t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
		     	
		     modelotabla =  (DefaultTableModel)jtable.getModel(); 
		     nuevafila = new Vector();
				             
			 nuevafila.add(t_fecha);
		     nuevafila.add(var_cuota);
			 nuevafila.add(var_retiro);
		   	 nuevafila.add(var_tasa);
			 nuevafila.add(var_saldo);
			 modelotabla.addRow(nuevafila);
	         }
 				
 	 	  }
 		catch(Exception put)
	      {
	      JOptionPane.showMessageDialog(null,"Por favor digite sólo datos permisibles.","Información del Sistema.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));	
	      }
 		}
 		
 	 if(tipo3.isSelected() == true)
 	 {
 	   try
 	    {
 	      do  
	         { 
	            var_cuota = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite la cantidad a depositar C$ : "," Depósito § Cuenta Corriente.",JOptionPane.QUESTION_MESSAGE));
	            
	         }while(var_cuota == 0 || (var_cuota + var_saldo) >limite);
	         
	         if( var_cuota%cuota_nav != 0)
	         {
	         JOptionPane.showMessageDialog(null,"    Recuerde que su depósito debe ser igual   \n   a la cuota selecionada ó a un múltiplo (C$ "+cuota_nav+" ).","Depósito  § Cuenta Navidad.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));		
	         }
	         else 
	         {
	         var_saldo += var_cuota;
	         
	         if(var_saldo == limite)
	         {
	         JOptionPane.showMessageDialog(null,"Su cuenta de ahorro navideña a llegado a su límite,\n entonces puede retirar sus ahorro a partir del\n          01 de Diciembre del "+año+"  ","Depósito  § Cuenta Navidad.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));
	         var_tasa = 0;
	         var_retiro = 0;
		     	
		 	
			 dia = objeto.getDate();
		     mes = objeto.getMonth() + 1;
			 año = objeto.getYear() + 1900;
		     t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
		     	
		     modelotabla =  (DefaultTableModel)jtable.getModel(); 
		     nuevafila = new Vector();
				             
			 nuevafila.add(t_fecha);
		     nuevafila.add(var_cuota);
			 nuevafila.add(var_retiro);
		   	 nuevafila.add(var_tasa);
			 nuevafila.add(var_saldo);
			 modelotabla.addRow(nuevafila);		
	     	  b_deposito.setEnabled(false);       	
	         }
	         else
	         {
	         
	         var_tasa = 0;
	         var_retiro = 0;
		     	
		 	
			 dia = objeto.getDate();
		     mes = objeto.getMonth() + 1;
			 año = objeto.getYear() + 1900;
		     t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
		     	
		     modelotabla =  (DefaultTableModel)jtable.getModel(); 
		     nuevafila = new Vector();
				             
			 nuevafila.add(t_fecha);
		     nuevafila.add(var_cuota);
			 nuevafila.add(var_retiro);
		   	 nuevafila.add(var_tasa);
			 nuevafila.add(var_saldo);
			 modelotabla.addRow(nuevafila);
	         }
	        } 
	          	         	
 	    }
 	    catch(Exception put)
	    {
	      JOptionPane.showMessageDialog(null,"Por favor digite sólo datos permisibles.","Información del Sistema.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));	
	     }	
 	 }	
 		
 		
 	}
 	
 }
 class c_retiro implements ActionListener
 {
 	
 	public void actionPerformed(ActionEvent ret)
 	{
 		
 	  if(tipo1.isSelected()== true)
 	  {
 	  
 		try
 		{   
	 		do  
	         { 
	            var_retiro = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite la cantidad a retirar C$ : "," Retiro de su Cuenta Ambiente",JOptionPane.QUESTION_MESSAGE));
	            
	            if(var_retiro > var_saldo)
	            {
	            	JOptionPane.showMessageDialog(null,"Recuerde que no puede retirar más de su saldo.","Información del Sistema.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));	
	            }
	            
	            
	         }while(var_retiro < 0 || var_retiro > var_saldo);
	         
	         if(confir == JOptionPane.OK_OPTION)
	         {
	         	var_saldo -= var_retiro;
		     	var_cuota = 0;
		        var_tasa = 0;
		     	
		 	
			    dia = objeto.getDate();
				mes = objeto.getMonth() + 1;
			    año = objeto.getYear() + 1900;
		     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
		     	
		        modelotabla =  (DefaultTableModel)jtable.getModel(); 
		        nuevafila = new Vector();
				             
			    nuevafila.add(t_fecha);
				nuevafila.add(var_cuota);
			    nuevafila.add(var_retiro);
				nuevafila.add(var_tasa);
				nuevafila.add(var_saldo);
				modelotabla.addRow(nuevafila);
				System.out.print("Saldo = "+var_saldo+"Retiro = "+var_retiro);
				
				while(Fechas_Pago.round(var_saldo) == var_retiro);
				{
					
				 JOptionPane.showMessageDialog(null,"Usted ha cancelado su cuenta de ahorro\n      ¡Gracias por utilizar Micro-Sisca!.","Retiro de su Cuenta Ambiente.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/trio.jpg"));		
				 b_retiro.setEnabled(false);	
				}
	         	
	         	
	         }	
	      } 
	      catch(Exception put)
	      {
	      	JOptionPane.showMessageDialog(null,"Por favor digite sólo datos permisibles.","Información del Sistema.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));	
	      }
	      		
	}//if1
	
	if(tipo2.isSelected() == true)
	{  
	   try
	   {
	   
		   do  
	          { 
	            var_retiro = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite la cantidad a retirar C$ : "," Retiro de su Cuenta Ambiente",JOptionPane.QUESTION_MESSAGE));
	            
	            if(var_retiro > var_saldo)
	            {
	            	JOptionPane.showMessageDialog(null,"Recuerde que no puede retirar más de su saldo.","Información del Sistema.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));	
	            }
	            
	            
	         }while(var_retiro < 0 || var_retiro > var_saldo);
	         
	         if(confir == JOptionPane.OK_OPTION)
	         {
	         	var_saldo -= var_retiro;
		     	var_cuota = 0;
		        var_tasa = 0;
		     	
		 	
			    dia = objeto.getDate();
				mes = objeto.getMonth() + 1;
			    año = objeto.getYear() + 1900;
		     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
		     	
		        modelotabla =  (DefaultTableModel)jtable.getModel(); 
		        nuevafila = new Vector();
				             
			    nuevafila.add(t_fecha);
				nuevafila.add(var_cuota);
			    nuevafila.add(var_retiro);
				nuevafila.add(var_tasa);
				nuevafila.add(var_saldo);
				modelotabla.addRow(nuevafila);
				
			while(Fechas_Pago.round(var_saldo) == var_retiro);
				{
					
				 JOptionPane.showMessageDialog(null,"Usted ha cancelado su cuenta de ahorro\n      ¡Gracias por utilizar Micro-Sisca!.","Retiro de su Cuenta Ambiente.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/trio.jpg"));		
				 b_retiro.setEnabled(false);	
				}
	         	
	         	
	         }	
	      } 
	      catch(Exception put)
	      {
	      	JOptionPane.showMessageDialog(null,"Por favor digite sólo datos permisibles.","", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));	

	      }
		
	}//if2
	
	if(tipo3.isSelected() == true)
	{
		
		if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		{
			b_retiro.setEnabled(true);
			try
			{
				  do  
		          { 
		            var_retiro = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite la cantidad a retirar C$ : "," Retiro de su Cuenta Ambiente",JOptionPane.QUESTION_MESSAGE));
		             
		          } while(var_retiro != Fechas_Pago.round(var_saldo));
		         
				if(confir == JOptionPane.OK_OPTION)
		         {
		         	var_saldo = 0;
			     	var_cuota = 0;
			        var_tasa = 0;
			     	
			 	
				    dia = objeto.getDate();
					mes = objeto.getMonth() + 1;
				    año = objeto.getYear() + 1900;
			     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
			     	
			        modelotabla =  (DefaultTableModel)jtable.getModel(); 
			        nuevafila = new Vector();
					             
				    nuevafila.add(t_fecha);
					nuevafila.add(var_cuota);
				    nuevafila.add(var_retiro);
					nuevafila.add(var_tasa);
					nuevafila.add(var_saldo);
					modelotabla.addRow(nuevafila);
					
					b_retiro.setEnabled(false);
					
					JOptionPane.showMessageDialog(null,"Su Cuenta Navidad ha sido cancelada\n          con un saldo C$ "+var_retiro+"\n              ¡Feliz Navidad!      ","Retiro de su Cuenta Ambiente.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("nav.jpg"));
					
					
			     }
			
			}
			catch(Exception put)
	        {
	      	  JOptionPane.showMessageDialog(null,"Por favor digite sólo datos permisibles.","Información del Sistema.", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif"));	
	        }
		
	}
	else
	{
		b_retiro.setEnabled(false);
	}
	
	
   }
 }
 	
}
 

class c_c0 implements ActionListener
{
	public void actionPerformed(ActionEvent aa)
	{
		
 	 int result = JOptionPane.showConfirmDialog((Component) null, "¿Está es la cuota que desea escojer?","Información del Sistema",JOptionPane.YES_NO_OPTION);
     if(result == JOptionPane.YES_OPTION)
      {
      	sub_index = 30;
      	
        cuota_nav = 50;
      	c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	c4.setEnabled(false);  c5.setEnabled(false);  c0.setEnabled(false);
     	
     	c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
     	c4.setVisible(false);  c5.setVisible(false);  
     	
     	inic1.setEnabled(true);
     	
      	var_saldo = cuota_nav;
     	var_cuota = cuota_nav;
        var_tasa = 0;
     	var_retiro = 0;
//------------------------     	
     	interes = 0.03;
     	limite = 1000;
//-----------------------     	
	    dia = objeto.getDate();
		mes = objeto.getMonth() + 1;
	    año = objeto.getYear() + 1900;
     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
     	
        modelotabla =  (DefaultTableModel)jtable.getModel(); 
        nuevafila = new Vector();
		             
	    nuevafila.add(t_fecha);
		nuevafila.add(var_cuota);
	    nuevafila.add(var_retiro);
		nuevafila.add(var_tasa);
		nuevafila.add(var_saldo);
		modelotabla.addRow(nuevafila);
	    b_deposito.setEnabled(true);
		tabla.setSelectedIndex(1);
		inic1.setEnabled(false);
	     
	   
      	
      }
      else
      {
      	c1.setEnabled(true);  c2.setEnabled(true);  c3.setEnabled(true);
     	c4.setEnabled(true);  c5.setEnabled(true);  c0.setEnabled(true);
      }
		      
	}
	
}

class c_c1 implements ActionListener
{
	public void actionPerformed(ActionEvent aa)
	{
		
 	 int result = JOptionPane.showConfirmDialog((Component) null, "¿Está es la cuota que desea escojer?","Información del Sistema",JOptionPane.YES_NO_OPTION);
     if(result == JOptionPane.YES_OPTION)
      {
      	sub_index = 31;
      	
        cuota_nav = 100;
      	c0.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	c4.setEnabled(false);  c5.setEnabled(false);  c1.setEnabled(false);
     	
        c2.setVisible(false);  c3.setVisible(false);
     	c4.setVisible(false);  c5.setVisible(false);  c0.setVisible(false);
     	
      	inic1.setEnabled(true);
      	
      	var_saldo = cuota_nav;
     	var_cuota = cuota_nav;
        var_tasa = 0;
     	var_retiro = 0;
//---------------------------     	
     	interes = 0.03;
     	limite = 2000;
//--------------------------     	
	    dia = objeto.getDate();
		mes = objeto.getMonth() + 1;
	    año = objeto.getYear() + 1900;
     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
     	
        modelotabla =  (DefaultTableModel)jtable.getModel(); 
        nuevafila = new Vector();
		             
	    nuevafila.add(t_fecha);
		nuevafila.add(var_cuota);
	    nuevafila.add(var_retiro);
		nuevafila.add(var_tasa);
		nuevafila.add(var_saldo);
		modelotabla.addRow(nuevafila);
		b_deposito.setEnabled(true);
		tabla.setSelectedIndex(1);
		inic1.setEnabled(false);
      }
      else
      {
      	c1.setEnabled(true);  c2.setEnabled(true);  c3.setEnabled(true);
     	c4.setEnabled(true);  c5.setEnabled(true);  c0.setEnabled(true);
      }
		      
	}
	
}

class c_c2 implements ActionListener
{
	public void actionPerformed(ActionEvent aa)
	{
		
 	 int result = JOptionPane.showConfirmDialog((Component) null, "¿Está es la cuota que desea escojer?","Información del Sistema",JOptionPane.YES_NO_OPTION);
     if(result == JOptionPane.YES_OPTION)
      {
      	sub_index = 32;
      	
        cuota_nav = 150;
      	c1.setEnabled(false);  c0.setEnabled(false);  c3.setEnabled(false);
     	c4.setEnabled(false);  c5.setEnabled(false);  c2.setEnabled(false);
     	
     	c1.setVisible(false);  c0.setVisible(false);  c3.setVisible(false);
     	c4.setVisible(false);  c5.setVisible(false);
     	
      	inic1.setEnabled(true);
      	
      	var_saldo = cuota_nav;
     	var_cuota = cuota_nav;
        var_tasa = 0;
     	var_retiro = 0;
//----------------------     	     	
     	interes = 0.03;
     	limite = 3000;
//---------------------     	
	    dia = objeto.getDate();
		mes = objeto.getMonth() + 1;
	    año = objeto.getYear() + 1900;
     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
     	
        modelotabla =  (DefaultTableModel)jtable.getModel(); 
        nuevafila = new Vector();
		             
	    nuevafila.add(t_fecha);
		nuevafila.add(var_cuota);
	    nuevafila.add(var_retiro);
		nuevafila.add(var_tasa);
		nuevafila.add(var_saldo);
		modelotabla.addRow(nuevafila);
		b_deposito.setEnabled(true);
		tabla.setSelectedIndex(1);
		inic1.setEnabled(false);
      }
      else
      {
      	c1.setEnabled(true);  c2.setEnabled(true);  c3.setEnabled(true);
     	c4.setEnabled(true);  c5.setEnabled(true);  c0.setEnabled(true);
      }
		      
	}
	
}

class c_c3 implements ActionListener
{
	public void actionPerformed(ActionEvent aa)
	{
		
 	 int result = JOptionPane.showConfirmDialog((Component) null, "¿Está es la cuota que desea escojer?","Información del Sistema",JOptionPane.YES_NO_OPTION);
     if(result == JOptionPane.YES_OPTION)
      {
      	sub_index = 33;
      	
        cuota_nav = 200;
      	c1.setEnabled(false);  c2.setEnabled(false);  c0.setEnabled(false);
     	c4.setEnabled(false);  c5.setEnabled(false);  c3.setEnabled(false);
     	
     	c1.setVisible(false);  c2.setVisible(false);  c0.setVisible(false);
     	c4.setVisible(false);  c5.setVisible(false);
     	
      	inic1.setEnabled(true);
      	
      	var_saldo = cuota_nav;
     	var_cuota = cuota_nav;
        var_tasa = 0;
     	var_retiro = 0;
//----------------------     	
     	interes = 0.03;
     	limite = 4000;
//----------------------
	    dia = objeto.getDate();
		mes = objeto.getMonth() + 1;
	    año = objeto.getYear() + 1900;
     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
     	
        modelotabla =  (DefaultTableModel)jtable.getModel(); 
        nuevafila = new Vector();
		             
	    nuevafila.add(t_fecha);
		nuevafila.add(var_cuota);
	    nuevafila.add(var_retiro);
		nuevafila.add(var_tasa);
		nuevafila.add(var_saldo);
		modelotabla.addRow(nuevafila);
		b_deposito.setEnabled(true);
		tabla.setSelectedIndex(1);
		inic1.setEnabled(false);
      }
      else
      {
      	c1.setEnabled(true);  c2.setEnabled(true);  c3.setEnabled(true);
     	c4.setEnabled(true);  c5.setEnabled(true);  c0.setEnabled(true);
      }
		      
	}
	
}

class c_c4 implements ActionListener
{
	public void actionPerformed(ActionEvent aa)
	{
		
 	 int result = JOptionPane.showConfirmDialog((Component) null, "¿Está es la cuota que desea escojer?","Información del Sistema",JOptionPane.YES_NO_OPTION);
     if(result == JOptionPane.YES_OPTION)
      { 
        sub_index = 34;
        
        cuota_nav = 250;
      	c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	c0.setEnabled(false);  c5.setEnabled(false);  c4.setEnabled(false);
     	
     	c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
     	c0.setVisible(false);  c5.setVisible(false);
     	
      	inic1.setEnabled(true);
      	
      	var_saldo = cuota_nav;
     	var_cuota = cuota_nav;
        var_tasa = 0;
        var_retiro = 0;
//----------------------             	
     	interes = 0.03;
     	limite = 5000;
//----------------------     	
	    dia = objeto.getDate();
		mes = objeto.getMonth() + 1;
	    año = objeto.getYear() + 1900;
     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
     	
        modelotabla =  (DefaultTableModel)jtable.getModel(); 
        nuevafila = new Vector();
		             
	    nuevafila.add(t_fecha);
		nuevafila.add(var_cuota);
	    nuevafila.add(var_retiro);
		nuevafila.add(var_tasa);
		nuevafila.add(var_saldo);
		modelotabla.addRow(nuevafila);
		b_deposito.setEnabled(true);
		tabla.setSelectedIndex(1);
		inic1.setEnabled(false);
      }
      else
      {
      	c1.setEnabled(true);  c2.setEnabled(true);  c3.setEnabled(true);
     	c4.setEnabled(true);  c5.setEnabled(true);  c0.setEnabled(true);
      }
		      
	}
	
}

class c_c5 implements ActionListener
{
	public void actionPerformed(ActionEvent aa)
	{
		
 	 int result = JOptionPane.showConfirmDialog((Component) null, "¿Está es la cuota que desea escojer?","Información del Sistema",JOptionPane.YES_NO_OPTION);
     if(result == JOptionPane.YES_OPTION)
      {
      	sub_index = 35;
      	
        cuota_nav = 300;
      	c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	c4.setEnabled(false);  c0.setEnabled(false);  c5.setEnabled(false);
     	
        c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
     	c4.setVisible(false);  c0.setVisible(false);
     	
      	inic1.setEnabled(true);
      	
      	var_saldo = cuota_nav;
     	var_cuota = cuota_nav;
        var_tasa = 0;
     	var_retiro = 0;
//----------------------     	
     	interes = 0.03;
     	limite = 6000;
//----------------------    	
	    dia = objeto.getDate();
		mes = objeto.getMonth() + 1;
	    año = objeto.getYear() + 1900;
     	t_fecha = String.valueOf(dia)+" / "+Fechas_Pago.mes_string(mes)+" / "+String.valueOf(año);
     	
        modelotabla =  (DefaultTableModel)jtable.getModel(); 
        nuevafila = new Vector();
		             
	    nuevafila.add(t_fecha);
		nuevafila.add(var_cuota);
	    nuevafila.add(var_retiro);
		nuevafila.add(var_tasa);
		nuevafila.add(var_saldo);
		modelotabla.addRow(nuevafila);
		b_deposito.setEnabled(true);
		tabla.setSelectedIndex(1);
		inic1.setEnabled(false);
      }
      else
      {
      	c1.setEnabled(true);  c2.setEnabled(true);  c3.setEnabled(true);
     	c4.setEnabled(true);  c5.setEnabled(true);  c0.setEnabled(true);
      }
		      
	}
	
}
class navidad implements ActionListener
{
	public void actionPerformed(ActionEvent ro)
	{
		if(ro.getSource()==tipo3)
		{
			int result = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro del tipo de Cuenta?","Información del Sistema",JOptionPane.YES_NO_OPTION);
		      if(result == JOptionPane.YES_OPTION)
		      {
		      	tipo1.setEnabled(false);
		      	tipo2.setEnabled(false);
		      	tipo3.setEnabled(false);
		      	tipo1.setVisible(false);
		      	tipo3.setVisible(true);
		      	tipo2.setVisible(false);
		        c_cuenta.setVisible(true);
		      }else
		      {
		      	tipo1.setEnabled(true);
		      	tipo2.setEnabled(true);
		      	tipo3.setEnabled(true);
		      }
			
		}
		
	}
	
	
}

	
	class class_cerrar implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			hide();
			dispose();
			Virus.nuevac.setEnabled(true);
		}
	}
	
	class class_limpiar implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{ 
		int result1 = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro de restablecer los campos?,\n","Restablecer Campos",JOptionPane.YES_NO_OPTION);
         
            if(result1 == JOptionPane.YES_OPTION) 
            { 
               JOptionPane.showMessageDialog(null, "Ahora puede crear una nueva cuenta.","Información del Sistema", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/nike.gif"));	
               clear();
               tabla.setSelectedIndex(0);
            }		  	
         }
		
		}
		
		public void clear()
	{   
	    p_botones.setVisible(false);
		txtnombres.setText("");
		txtapellidos.setText("");
		txtedad.setText("");
		txtcedula.setText("");
		txtdireccion.setText("");
		txtcelular.setText("");
		txttelefono.setText("");
		txt_cuota.setText("");
		montotxt.setText("");
		b_deposito.setEnabled(false);
		b_retiro.setEnabled(false);
		p_botones.setVisible(false);
		pajaro.setVisible(true);
		
		 
		txtnombres.setEditable(true);
		txtapellidos.setEditable(true);
		txtedad.setEditable(true);
		txtcedula.setEditable(true);
		txtdireccion.setEditable(true);
		txtcelular.setEditable(true);
		txttelefono.setEditable(true);
		
		txtnombres.setEnabled(true);
		txtapellidos.setEnabled(true);
		txtedad.setEnabled(true);
		txtcedula.setEnabled(true);
		txtdireccion.setEnabled(true);
		txtcelular.setEnabled(true);
		txttelefono.setEnabled(true);
		montotxt.setEnabled(true);
		
		tipo1.setSelected(false); tipo1.setVisible(true);
		tipo2.setSelected(false); tipo2.setVisible(true);
		tipo3.setSelected(false); tipo3.setVisible(true);
		
		
		tipo1.setEnabled(true);
		tipo2.setEnabled(true);
		tipo3.setEnabled(true);
		
		c0.setEnabled(true); c1.setEnabled(true);c2.setEnabled(true);c3.setEnabled(true);
		c4.setEnabled(true);  c5.setEnabled(true); 
		
		c0.setSelected(false); c1.setSelected(false);c2.setSelected(false);c3.setSelected(false);
		c4.setSelected(false);  c5.setSelected(false);
		
		c0.setVisible(true); c1.setVisible(true);c2.setVisible(true);c3.setVisible(true);
		c4.setVisible(true);  c5.setVisible(true);
		
		mega_panel.setVisible(false);
		c_cuenta.setVisible(false);
				
		montotxt.setVisible(false); montotxt.setEnabled(true); montotxt.setEditable(true);
		montolbl.setVisible(false); 
		txt_cuota.setVisible(false);txt_cuota.setEnabled(true); txt_cuota.setEditable(true);
		lblcuota.setVisible(false);
		
		saldo.setEnabled(false);
		
		tfecha.setEditable(false);
		inic.setEnabled(true);
		tabla.setSelectedIndex(0);
		
		
		
					 jtable.setModel(new DefaultTableModel(
            new Object [][] {
					
            },
            new String [] {
                "Fecha", "Depósitos", "Retiros", "Intereses", "Saldo"
            }
        ) {
	        Class[] types = new Class [] { 
		     		String.class, Double.class, Double.class, Double.class, Double.class
		     };
		     boolean[] canEdit = new boolean [] {
			     false, false, false, false, false
			     
			  };
	        
           public Class getColumnClass(int columnIndex) 
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) 
            {
                return canEdit [columnIndex];
            }
        });
			jtable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
			JS.setViewportView(jtable);
	}
	
	
	
	class class_close implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			hide();
			dispose();
			Virus.nuevac.setEnabled(true);

		}
	}
	class class_inic implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			var_nom = txtnombres.getText();
			var_ape = txtapellidos.getText();
			var_tel = txttelefono.getText();
			var_cel = txtcelular.getText();
			var_dir = txtdireccion.getText();
			var_ced = txtcedula.getText();
			var_eda = txtedad.getText();
			System.out.println("Nombres: "+var_nom);
			System.out.println("Apellidos: "+var_ape);
			System.out.println("Teléfono: "+var_tel);
			System.out.println("Celular: "+var_cel);
			System.out.println("Dirección: "+var_dir);
			System.out.println("Cédula: "+var_ced);
			System.out.println("Edad: "+var_eda);
			
			if(var_nom.length() == 0 || var_ape.length() == 0 || var_tel.length() == 0 || var_cel.length() == 0 || var_dir.length() == 0 || var_ced.length() == 0 || var_eda.length() == 0)
			{
				System.out.println("Error de entrada de datos");
				JOptionPane.showMessageDialog(null, "Complete los campos correctamente,\nasegúrese de elegir sus respectivas especificaciones.", "Error de lectura de datos.", JOptionPane.WARNING_MESSAGE,new ImageIcon("Imagenes/help.gif"));
			}
			else
			{	confir = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro de sus datos personales?","Confirmación de Datos Personales",JOptionPane.YES_NO_OPTION);
              
              if(confir == JOptionPane.YES_OPTION)
               {
               
			    pajaro.setVisible(false);
			    p_botones.setVisible(true);	
				inic.setEnabled(false);				
				limpiar.setEnabled(true);
				
				txtnombres.setEditable(false);
				txtapellidos.setEditable(false);
				txttelefono.setEditable(false);
				txtcelular.setEditable(false);
				txtdireccion.setEditable(false);
				txtcedula.setEditable(false);
				txtedad.setEditable(false);
				
				}
				 else
				 { pajaro.setVisible(true);
				   p_botones.setVisible(false);	   
				   txtnombres.setEditable(true);
				   txtapellidos.setEditable(true);
				   txttelefono.setEditable(true);
				   txtcelular.setEditable(true);
				   txtdireccion.setEditable(true);
				   txtcedula.setEditable(true);
				   txtedad.setEditable(true);				 	
				 }
				
			}
		}
	}
	
	
	class class_open implements ActionListener
	{ 
		 public void actionPerformed(ActionEvent e)
		{
			
	         JFileChooser f = new JFileChooser();              
            f.setFileSelectionMode( JFileChooser.FILES_ONLY );
    
           int result = f.showOpenDialog(Internal_cuenta.this);
     
         // si el usuario hace click en cancel se retorna a la ventana del programa
       if ( result == JFileChooser.CANCEL_OPTION )
           return;

          // obtener el archivo seleccionado
           File name = f.getSelectedFile();
          modelo = name;
        
         // mostrar error en caso de nombre invalido
       if ( name == null || name.getName().equals(""))
           JOptionPane.showMessageDialog(null, "Nombre de archivo invalido", "Nombre del Archivo Invalido", JOptionPane.ERROR_MESSAGE );
       else {
            // abrir archivo
         try {
              leer = new DataInputStream(new FileInputStream(name));   
	           leerFichero();
	           JOptionPane.showMessageDialog(null, "Se ha cargado su cuenta correctamente", "Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/nike.gif"));
          }
  
          // procesa la excepcion al abrir el archivo
          catch ( IOException ioException ) {
           JOptionPane.showMessageDialog(null,"Error al abrir el archivo","Error", JOptionPane.ERROR_MESSAGE ); }      
          }
       }
             
           public void leerFichero()
     {
	       txtnombres.setEnabled(false);
          txtapellidos.setEnabled(false);
          txttelefono.setEnabled(false);
          txtcelular.setEnabled(false);
          txtcedula.setEnabled(false);
          txtedad.setEnabled(false);
          txtdireccion.setEnabled(false);
         
          montotxt.setEnabled(false);
          b_deposito.setEnabled(true);
          pajaro.setVisible(false);
          p_botones.setVisible(true);
          c_cuenta.setVisible(true);
          inic1.setEnabled(false);
          montotxt.setEditable(false);
          
          
	     
      String nom = null, ape = null, cel = null, ced = null,edad = null,dir = null,tel = null,fecha = null;
      float deposito = 0;float retiro = 0;float saldo = 0;
      double tasa = 0;int indice = 0;
      int indexg = 0; int sub_indexg; double interesg = 0; int diag = 0; int mesg = 0;  int añog = 0; double cuota_navg = 0;  String cuota_fijag = null;
      double limiteg = 0;  String montog = null;  int contameg = 0;  String num_cuentag = null;
      
     try {
          nom = leer.readUTF();
          ape = leer.readUTF();
          cel = leer.readUTF();
          ced = leer.readUTF();
          edad = leer.readUTF();
          dir = leer.readUTF();
          tel = leer.readUTF();
          
          indexg = leer.readInt();
          sub_indexg = leer.readInt();
          interesg = leer.readDouble();
          diag = leer.readInt();
          mesg = leer.readInt();
          añog = leer.readInt();
          cuota_navg = leer.readDouble();
          cuota_fijag = leer.readUTF();
          limiteg = leer.readDouble();
          montog  = leer.readUTF();
          contameg = leer.readInt();
          num_cuentag = leer.readUTF();
          indice = leer.readInt();
          
          
          if(sub_indexg != 0)
          {
          	b_retiro.setEnabled(false);
          }
          else
          {
          	b_retiro.setEnabled(true);
          }
          
          if(indexg == 1)
          {
          	
          	montotxt.setText(String.valueOf(montog));
          	tipo1.setSelected(true);
          	tipo1.setEnabled(false);
		    tipo2.setEnabled(false);
		    tipo3.setEnabled(false);
		    tipo2.setVisible(false);
		    tipo3.setVisible(false);
		    montolbl.setVisible(true);
	        montotxt.setVisible(true);
	        montotxt.setEnabled(false);
	        inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        c_cuenta.setVisible(false);  
          }
          
          if(indexg == 2)
          {  
            cuota_fija = Double.parseDouble(cuota_fijag);
            txt_cuota.setText(String.valueOf(cuota_fijag));
          	tipo2.setSelected(true);
          	tipo1.setEnabled(false);
		    tipo2.setEnabled(false);
		    tipo1.setVisible(false);
		    tipo3.setVisible(false);
		    tipo3.setEnabled(false);

		    lblcuota.setVisible(true);
	        txt_cuota.setVisible(true);
	        txt_cuota.setEnabled(false);
	        inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        c_cuenta.setVisible(false);
          	
          }
          
          if(sub_indexg == 30)
          {
          	
      	   tipo1.setEnabled(false);
	       tipo2.setEnabled(false);
	       tipo3.setEnabled(false);
	       tipo1.setVisible(false);
	       tipo3.setVisible(true);
	       tipo2.setVisible(false);
	       
           c_cuenta.setVisible(true);
           
             if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
           tipo3.setSelected(true); c0.setSelected(true);
           c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	   c4.setEnabled(false);  c5.setEnabled(false);  c0.setEnabled(false);
     	
     	   c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
           c4.setVisible(false);  c5.setVisible(false);
          }
          
          if(sub_indexg == 31)
          { 
          
            tipo1.setEnabled(false);
	      	tipo2.setEnabled(false);
	      	tipo3.setEnabled(false);
	      	tipo1.setVisible(false);
	      	tipo3.setVisible(true);
	      	tipo2.setVisible(false);
	      	inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        
	        if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
		      	
            c_cuenta.setVisible(true);
          	tipo3.setSelected(true); c1.setSelected(true);
          	c0.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	    c4.setEnabled(false);  c5.setEnabled(false);  c1.setEnabled(false);
     	
            c2.setVisible(false);  c3.setVisible(false);
        	c4.setVisible(false);  c5.setVisible(false);  c0.setVisible(false);
          	
          }
          
          if(sub_indexg == 32)
          {
          	
      	    tipo1.setEnabled(false);
	      	tipo2.setEnabled(false);
	      	tipo3.setEnabled(false);
	      	tipo1.setVisible(false);
	      	tipo3.setVisible(true);
	      	tipo2.setVisible(false);
	      	inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        
	        if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
		      	
          	c_cuenta.setVisible(true);
          	tipo3.setSelected(true); c2.setSelected(true);
          	c1.setEnabled(false);  c0.setEnabled(false);  c3.setEnabled(false);
        	c4.setEnabled(false);  c5.setEnabled(false);  c2.setEnabled(false);
     	
     	    c1.setVisible(false);  c0.setVisible(false);  c3.setVisible(false);
     	    c4.setVisible(false);  c5.setVisible(false);
          }
          
          if(sub_indexg == 33)
          { 
            tipo1.setEnabled(false);
	      	tipo2.setEnabled(false);
	      	tipo3.setEnabled(false);
	      	tipo1.setVisible(false);
	      	tipo3.setVisible(true);
	      	tipo2.setVisible(false);
	      	inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        
	        if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
		      	
            c_cuenta.setVisible(true);
            tipo3.setSelected(true); c3.setSelected(true);
            c1.setEnabled(false);  c2.setEnabled(false);  c0.setEnabled(false);
        	c4.setEnabled(false);  c5.setEnabled(false);  c3.setEnabled(false);
     	
     	    c1.setVisible(false);  c2.setVisible(false);  c0.setVisible(false);
     	    c4.setVisible(false);  c5.setVisible(false);
            	
          }
          if(sub_indexg == 34)
          {
          	tipo1.setEnabled(false);
		    tipo2.setEnabled(false);
		    tipo3.setEnabled(false);
		    tipo1.setVisible(false);
		    tipo3.setVisible(true);
		    tipo2.setVisible(false);
		    inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        
	        if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
          	
          	c_cuenta.setVisible(true);
            tipo3.setSelected(true); c4.setSelected(true);
            c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	    c0.setEnabled(false);  c5.setEnabled(false);  c4.setEnabled(false);
     	
     	    c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
     	    c0.setVisible(false);  c5.setVisible(false);          	
          }
          if(sub_index == 35)
          {
          	
          	tipo1.setEnabled(false);
		    tipo2.setEnabled(false);
		    tipo3.setEnabled(false);
		    tipo1.setVisible(false);
		    tipo3.setVisible(true);
		    tipo2.setVisible(false);
		    inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        
	        if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
          	
          	c_cuenta.setVisible(true);
            tipo3.setSelected(true); c5.setSelected(true);
          	c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	    c4.setEnabled(false);  c0.setEnabled(false);  c5.setEnabled(false);
     	
            c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
     	    c4.setVisible(false);  c0.setVisible(false);
          	
          }
          
          
          System.out.println(indice);
          System.out.println(nom);
		  System.out.println(ape);
		  System.out.println(cel);
		  System.out.println(ced);
		  System.out.println(edad);
		  System.out.println(dir);
		  System.out.println(tel);
		  
		  System.out.println("aqui empiez a abrir ceroteeeeeeeeeeeeeeeeeee");
		  System.out.println(indexg);
		  System.out.println(sub_indexg);
		  System.out.println(interesg);
		  System.out.println(diag);
		  System.out.println(mesg);
		  System.out.println(añog);
		  System.out.println(cuota_navg);
		  System.out.println("alfo"+contameg);
		  System.out.println(num_cuentag);

          
          txtnombres.setText(nom);
          txtapellidos.setText(ape);
          txttelefono.setText(tel);
          txtcelular.setText(cel);
          txtcedula.setText(ced);
          txtedad.setText(edad);
          txtdireccion.setText(dir);
          
          
          
          index = indexg;
          sub_indexg = sub_indexg;
          interes = interesg;
          dia = diag;
          mes = mesg;
          año = añog;
          cuota_nav = cuota_navg;
          limite = limiteg;
          contame = contameg;
          num_cuenta = num_cuentag;
          
          System.out.println("alalalal"+contame);
          
        for(int i = 0; i < indice; i++)
			{
					fecha = leer.readUTF();
					deposito = leer.readFloat();
					retiro = leer.readFloat();
					tasa = leer.readDouble();
					saldo = leer.readFloat();
					
					var_fecha = fecha;
					var_deposito = deposito;
					var_retiro = retiro;
					var_tasa = tasa;
					var_saldo = saldo;
					
					System.out.println(var_fecha);
					System.out.println(var_deposito);
					System.out.println(var_retiro);
					System.out.println(var_tasa);
					System.out.println(var_saldo);
					
				     Internal_cuenta.addrow();
				    
             
		             nuevafila.add(var_fecha);
		             nuevafila.add(var_deposito);
		             nuevafila.add(var_retiro);
		             nuevafila.add(var_tasa);
		             nuevafila.add(var_saldo);
		             modelotabla.addRow(nuevafila);
			}	
			
			System.out.println(" fecha :" + String.valueOf((diag + 30) - num_dias(mesg,añog)));		
			
			if(((diag + 30) - num_dias(mesg,añog)) <= objeto.getDate() )
			{
				saldo *=(1 + interesg) ;
				var_saldo = saldo;
		     	var_cuota = 0;
		     	var_retiro = 0;
		        var_tasa = saldo*interesg;
		     	
		     	t_fecha = String.valueOf(objeto.getDate())+" / "+Fechas_Pago.mes_string(objeto.getMonth() + 1)+" / "+String.valueOf( objeto.getYear() + 1900);
		     	
		        modelotabla =  (DefaultTableModel)jtable.getModel(); 
		        nuevafila = new Vector();
				             
			    nuevafila.add(t_fecha);
				nuevafila.add(var_cuota);
			    nuevafila.add(var_retiro);
				nuevafila.add(var_tasa);
				nuevafila.add(saldo);
				modelotabla.addRow(nuevafila);
				index = indexg;
				sub_index = sub_indexg;
				
				
		if(indexg == 1)
          {
          	
          	montotxt.setText(String.valueOf(montog));
          	tipo1.setSelected(true);
          	tipo1.setEnabled(false);
		    tipo2.setEnabled(false);
		    tipo3.setEnabled(false);
		    tipo2.setVisible(false);
		    tipo3.setVisible(false);
		    montolbl.setVisible(true);
	        montotxt.setVisible(true);
	        montotxt.setEnabled(false);
	        inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        c_cuenta.setVisible(false); 
	         
          }
          
          if(indexg == 2)
          {  
            cuota_fija = Double.parseDouble(cuota_fijag);
            txt_cuota.setText(String.valueOf(cuota_fijag));
          	tipo2.setSelected(true);
          	tipo1.setEnabled(false);
		    tipo2.setEnabled(false);
		    tipo1.setVisible(false);
		    tipo3.setVisible(false);
		    tipo3.setEnabled(false);

		    lblcuota.setVisible(true);
	        txt_cuota.setVisible(true);
	        txt_cuota.setEnabled(false);
	        inic.setEnabled(false); 
	        inic1.setEnabled(false);
	        c_cuenta.setVisible(false);
          	
          }
          
          if(sub_indexg == 30)
          {
          	
      	   tipo1.setEnabled(false);
	       tipo2.setEnabled(false);
	       tipo3.setEnabled(false);
	       tipo1.setVisible(false);
	       tipo3.setVisible(true);
	       tipo2.setVisible(false);
	       
	       if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
		      
          	c_cuenta.setVisible(true);
           tipo3.setSelected(true); c0.setSelected(true);
           c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	   c4.setEnabled(false);  c5.setEnabled(false);  c0.setEnabled(false);
     	
     	   c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
           c4.setVisible(false);  c5.setVisible(false);
          }
          
          if(sub_indexg == 31)
          { 
          
            tipo1.setEnabled(false);
	      	tipo2.setEnabled(false);
	      	tipo3.setEnabled(false);
	      	tipo1.setVisible(false);
	      	tipo3.setVisible(true);
	      	tipo2.setVisible(false);
	      	
	      	if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
		      	
            c_cuenta.setVisible(true);
          	tipo3.setSelected(true); c1.setSelected(true);
          	c0.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	    c4.setEnabled(false);  c5.setEnabled(false);  c1.setEnabled(false);
     	
            c2.setVisible(false);  c3.setVisible(false);
        	c4.setVisible(false);  c5.setVisible(false);  c0.setVisible(false);
          	
          }
          
          if(sub_indexg == 32)
          {
          	
      	    tipo1.setEnabled(false);
	      	tipo2.setEnabled(false);
	      	tipo3.setEnabled(false);
	      	tipo1.setVisible(false);
	      	tipo3.setVisible(true);
	      	tipo2.setVisible(false);
	      	
	      	if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
		      	
          	c_cuenta.setVisible(true);
          	tipo3.setSelected(true); c2.setSelected(true);
          	c1.setEnabled(false);  c0.setEnabled(false);  c3.setEnabled(false);
        	c4.setEnabled(false);  c5.setEnabled(false);  c2.setEnabled(false);
     	
     	    c1.setVisible(false);  c0.setVisible(false);  c3.setVisible(false);
     	    c4.setVisible(false);  c5.setVisible(false);
          }
          
          if(sub_indexg == 33)
          { 
            tipo1.setEnabled(false);
	      	tipo2.setEnabled(false);
	      	tipo3.setEnabled(false);
	      	tipo1.setVisible(false);
	      	tipo3.setVisible(true);
	      	tipo2.setVisible(false);
	      	
	      	if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
		      	
            c_cuenta.setVisible(true);
            tipo3.setSelected(true); c3.setSelected(true);
            c1.setEnabled(false);  c2.setEnabled(false);  c0.setEnabled(false);
        	c4.setEnabled(false);  c5.setEnabled(false);  c3.setEnabled(false);
     	
     	    c1.setVisible(false);  c2.setVisible(false);  c0.setVisible(false);
     	    c4.setVisible(false);  c5.setVisible(false);
            	
          }
          if(sub_indexg == 34)
          {
          	tipo1.setEnabled(false);
		    tipo2.setEnabled(false);
		    tipo3.setEnabled(false);
		    tipo1.setVisible(false);
		    tipo3.setVisible(true);
		    tipo2.setVisible(false);
		    
		    if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
          	
          	c_cuenta.setVisible(true);
            tipo3.setSelected(true); c4.setSelected(true);
            c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	    c0.setEnabled(false);  c5.setEnabled(false);  c4.setEnabled(false);
     	
     	    c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
     	    c0.setVisible(false);  c5.setVisible(false);          	
          }
          if(sub_index == 35)
          {
          	
          	tipo1.setEnabled(false);
		    tipo2.setEnabled(false);
		    tipo3.setEnabled(false);
		    tipo1.setVisible(false);
		    tipo3.setVisible(true);
		    tipo2.setVisible(false);
		    
		    if((objeto.getDate() >= 1) && ((objeto.getMonth() + 1) == 12))
		      {
                   b_retiro.setEnabled(true);
               }
               else 
		      {
                  b_retiro.setEnabled(false);
		      }
          	
          	c_cuenta.setVisible(true);
            tipo3.setSelected(true); c5.setSelected(true);
          	c1.setEnabled(false);  c2.setEnabled(false);  c3.setEnabled(false);
     	    c4.setEnabled(false);  c0.setEnabled(false);  c5.setEnabled(false);
     	
            c1.setVisible(false);  c2.setVisible(false);  c3.setVisible(false);
     	    c4.setVisible(false);  c0.setVisible(false);
          	
          }

			}
			
			
			
			
			
}
catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( null,"Error durante la lectura del archivo","Error de Lectura", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
        
			}
		}
	}
	

   	class class_save implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{	
			JFileChooser f = new JFileChooser();		
			f.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int result = f.showSaveDialog(Internal_cuenta.this);
   	   if(result==JFileChooser.CANCEL_OPTION)
   	   return;
		   File name = f.getSelectedFile();
			modelo = name;
			
   	  if(name == null || name.getName().equals(""))
   		   JOptionPane.showMessageDialog(null,"Nombre del archivo invalido","Nombre del archivo invalido",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
   		else
   		{
   			try{
   				escribir = new DataOutputStream(new FileOutputStream(modelo));      
				escribirFichero();
				JOptionPane.showMessageDialog(null, "Se ha guardado su cuenta correctamente", "Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/nike.gif"));
   			}
   			// mostrar mensaje de error si no se puede abrir el archivo
            catch ( IOException ioException ) {
            	JOptionPane.showMessageDialog(null, "Error al abrir el archivo", "Error de lectura de Datos", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));  }    
   		} // fin else 
   	}
	   

		     public void escribirFichero()
           { 
           
            
            contame += 1;
            num_cuenta = Num_cuenta.Cadena(contame);
           
            String nom = null, ape = null, cel = null, ced = null,edad = null,dir = null,tel = null,fecha = null;
            float deposito = 0;float retiro = 0;float saldo = 0;
            double tasa = 0;int indice = 0;
            int indexg = 0; int sub_indexg = 0; double interesg = 0; int diag = 0; int mesg = 0;  int añog = 0; double cuota_navg = 0; String cuota_fijag = null;
            double limiteg = 0;  String montog = null; int contameg = 0;  String num_cuentag = null;
            
            nom = txtnombres.getText();
            ape = txtapellidos.getText();
            cel = txtcelular.getText();
            ced = txtcedula.getText();
            edad = txtedad.getText();
            dir = txtdireccion.getText();
            tel = txttelefono.getText();
            indexg = index;
            sub_indexg = sub_index;
            interesg = interes;
            diag = dia;
            mesg = mes; 
            añog = año;
            cuota_navg = cuota_nav;
            cuota_fijag = txt_cuota.getText();
            limiteg = limite;
            montog = montotxt.getText();
            contameg = contame;
            num_cuentag = num_cuenta;
            indice = Internal_cuenta.jtable.getRowCount();
            System.out.println(indice);
            
             try
              {
               escribir.writeUTF(nom);
               escribir.writeUTF(ape);
               escribir.writeUTF(cel);
               escribir.writeUTF(ced);
               escribir.writeUTF(edad);
               escribir.writeUTF(dir);
               escribir.writeUTF(tel);
               escribir.writeInt(indexg);
               escribir.writeInt(sub_indexg);
               escribir.writeDouble(interesg);
               escribir.writeInt(diag);
               escribir.writeInt(mesg);
               escribir.writeInt(añog);
               escribir.writeDouble(cuota_navg);
               escribir.writeUTF(cuota_fijag);
               escribir.writeDouble(limiteg);
               escribir.writeUTF(montog);
               escribir.writeInt(contameg);
               escribir.writeUTF(num_cuentag);
               escribir.writeInt(indice);
               
               System.out.println(nom);
	           System.out.println(ape);
			   System.out.println(cel);
			   System.out.println(ced);
		       System.out.println(edad);
	           System.out.println(dir);
			   System.out.println(tel);
			   
			   System.out.println("Aqui empieza a guardar cerote de mierda");
			   
			   System.out.println(indexg);
			   System.out.println(sub_indexg);
			   System.out.println(interesg);
			   System.out.println(diag);
			   System.out.println(mesg);
			   System.out.println(añog);
			   System.out.println(cuota_navg);
			   System.out.println(cuota_fijag);
			   System.out.println(limiteg);
			   System.out.println(montog);
			   System.out.println(contameg);
			   System.out.println(num_cuentag);
               
               for(int i = 0; i < indice; i++)
			  {
				fecha = String.valueOf(jtable.getValueAt(i,0));
				deposito = Float.parseFloat(String.valueOf(jtable.getValueAt(i,1)));
				retiro = Float.parseFloat(String.valueOf(jtable.getValueAt(i,2)));
				tasa = Double.parseDouble(String.valueOf(jtable.getValueAt(i,3)));
				saldo = Float.parseFloat(String.valueOf(jtable.getValueAt(i,4)));
				
				escribir.writeUTF(fecha);
				escribir.writeFloat(deposito);
				escribir.writeFloat(retiro);
				escribir.writeDouble(tasa);
				escribir.writeFloat(saldo);
				
				
	            System.out.println(fecha);
	            System.out.println(deposito);
				System.out.println(retiro);
				System.out.println(tasa);
		        System.out.println(saldo);
		   }
			   escribir.close();
            }
     catch ( IOException ioException ) {
             JOptionPane.showMessageDialog(null,"Error escribiendo en el archivo","IO Exception", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));    		
  
			}
		}
	}
	
	
	
	
	public static void addrow()
   {
	   modelotabla =  (DefaultTableModel)jtable.getModel();
      nuevafila = new Vector();
      jtable.setModel(modelotabla);
   }
   
   
   public static int num_dias(int mes, int año)	//dia
  {
	int day=0;
	
		switch(mes)
		{
			case 1:  // Enero
			{
				day = 31;
			    break;
			}
			
			case 2:  //Febrero
			{
		    	if((año % 4 == 0) && (año % 10 != 0) || (año % 400 == 0))
						day = 29;
				else
						day = 28;
				break;

			}
			
			case 3: // Marzo
			{
				day = 31;
				break;
			}
			
			case 4:  // Abril
			{
				day = 30;
				break;
			}
			
			case 5:  //Mayo
			{
				day = 31;
				break;
			}
			
			case 6:  //Junio
			{
				day = 30;
				break;
			}
			
			case 7:  //Julio
			{
				day = 31;
				break;
			}
			
			case 8:  //Agosto
			{
				day = 31;
				break;
			}
			
			case 9:  //Septiembre
			{
				day = 30;
				break;
			}
			
			case 10:
			{
				day = 31;
				break;
			}
			
			case 11:
			{
				day = 30;
				break;
			}
			
			case 12:
			{
				day = 31;
				break;
			}
		}

	return day;
}
   
   public static void main(String []args)
  {
	Internal_cuenta superobjeto = new Internal_cuenta();  
  }
}