	/*
 * Internal_prestamo.java
 *
 * Created on 5 de mayo de 2006, 21:20
 * Modify: 22 de mayo de 2006, 21:37
 */


   import java.lang.*;
   import java.awt.*;
   import java.awt.print.PageFormat;
   import java.awt.print.Printable;
   import java.awt.print.PrinterException;
   import java.awt.print.PrinterJob;


   import java.awt.event.*;
   import java.io.*;
   import java.util.*;
   import java.util.Vector;
   import javax.swing.border.*;
   import javax.swing.*;
   import javax.swing.event.*;
   import javax.swing.text.*;
   import javax.swing.table.*;
   import javax.swing.JTable.*;
   import javax.swing.JFormattedTextField.*;

   //import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

   public class Internal_prestamo extends javax.swing.JInternalFrame 
   {	
      private JFileChooser ruta; 
      DataOutputStream escribir; 
      DataInputStream leer; 
      File fmombre,fmodelo;  
      private File elv; 
   
      private javax.swing.JButton calculate;
      private JButton clear1 = new JButton("Restablecer",new ImageIcon("Imagenes/Reload.jpg"));
      private JPanel panel_maestro=new JPanel();  
      private JButton btn_sig1 = new JButton("Paso 1",new ImageIcon("Imagenes/Siguiente.jpg"));
      private JButton btn_sig2 = new JButton("Paso 2",new ImageIcon("Imagenes/Siguiente.jpg"));
      private javax.swing.JMenuItem close;
      private javax.swing.JMenuItem calc;
      private javax.swing.JMenuItem imp;
      private javax.swing.JMenuItem ex;
      private javax.swing.JMenuItem ex1;
      private javax.swing.JMenuItem imp1;
      private javax.swing.JMenuItem save;
      private javax.swing.JMenuItem open;
      private javax.swing.JMenuItem abono;
      private javax.swing.JMenu file;
      private javax.swing.JMenu herr;
      private javax.swing.JMenuBar jMenuBar1;
      private javax.swing.JTabbedPane jtabbedpane;
      private javax.swing.JPanel panel_tablas;
      private javax.swing.JPanel JP1;
      private javax.swing.JPanel JP2;
      private javax.swing.JPanel JP3;
      private javax.swing.JPanel JP4;
      private javax.swing.JLabel name;
      private javax.swing.JLabel apell;
      private javax.swing.JLabel phone;
      private javax.swing.JLabel phonecell;
      private javax.swing.JLabel dir;
      private javax.swing.JLabel sex;
      private javax.swing.JLabel city;
      private javax.swing.JLabel ced ;
      private javax.swing.JLabel age;
      private javax.swing.JLabel prof;
      private javax.swing.JLabel image;
   ////////////////////////////////////////////////////////////////////////////////
      private javax.swing.JLabel monto_prestamo;  
      private javax.swing.JLabel plazo_prestamo; 
      private javax.swing.JLabel tipo_interes;  
      private javax.swing.JLabel tipo_calculo_interes;  
      private javax.swing.JLabel tasa_interes;  
      private javax.swing.JTextField monto_prestamo_txt;  
      private javax.swing.JTextField tasa_interes_txt;  
      private javax.swing.JTextField plazo_prestamo_txt;  // int 
      private javax.swing.JComboBox tipo_interes_jcbox;   
      static javax.swing.JComboBox tipo_calculo_interes_jcbox;	  
      private String[] ltipo_int = {"","Simple","Compuesto","Anual"};   
      private String[] ltipo_calculo = {"","Cuota Proporcional","Cuota Nivelada","Interés FLAT"};   
   
      private JLabel lblpcuotas = new JLabel("Capitalizable: ");  
      private String[] cuotas = {"","Mensual","Bimensual","Trimestral","Cuatrimestral","Semestral","Anual"};  
      private JComboBox pcuotas = new JComboBox(cuotas); 
      private MaskFormatter mf; 
   
   ///////////////////////////////////////////////////////////////////////////////	 
      private javax.swing.JTextField nombres;  
      private javax.swing.JTextField apellidos;  
      private javax.swing.JFormattedTextField telefono;  
      private javax.swing.JFormattedTextField celular;  
      private JTextArea direccion;  
      private javax.swing.JFormattedTextField cedula;  
      private javax.swing.JComboBox profesion;  
      private javax.swing.JFormattedTextField edad;	  
      private javax.swing.JComboBox ciudad;  
      private javax.swing.JComboBox sexo;	 
      private String[] lcity = {"","Chinandega","León","Managua","Masaya","Granada","Carazo","Rivas","Rio San Juan","Ocotal","Madriz","Nueva Segovia","Matagalpa","Jinotega","Chontales","Boaco","RAAS","RAAN"}; 
      private String[] lsexo = {"","Masculino","Femenino"}; 
      private String[] lprofesion = {"","Ingenierio","Licenciado","Comerciante","Otro..."}; 
   
   //////////////////////////////////////////////////////////////////////////////////////////////
   ///////////////////////// JP3 ////////////////////////////////////////////////////////////////	
   //////////////////////////////////////////////////////////////////////////////////////////////
   
      static DefaultTableModel modelo; 
      static Vector nuevafila;  
      static JTable tabla = new JTable(); 
   
   //////////////////////////////////////////////////////////////////////////////////////////////
   ///////////////////////// JP4 ////////////////////////////////////////////////////////////////	
   //////////////////////////////////////////////////////////////////////////////////////////////
   
      private JFormattedTextField fecha = new JFormattedTextField(new Date()); 
      private JButton abonobtn = new JButton("Abonar",new ImageIcon("Imagenes/abo.jpg")); 
      static JButton saldobtn = new JButton("Saldo",new ImageIcon("Imagenes/doloe1.gif")); 
      private JLabel lblfecha = new JLabel("Fecha del abono:"); 
      static DefaultTableModel modelo2; 
      static Vector nuevafila2; 
      static JTable tabla2 = new JTable(); 
      static JScrollPane JS2 = new JScrollPane(); 
      static JScrollPane js = new JScrollPane(); 
      static JScrollPane JS = new JScrollPane(); 
   
   ///////////////////////////////////////////////////////////////////////////////////////////////
   ///////////////////////////////////////////////////////////////////////////////////////////////
   
      private JButton cancelar = new JButton("Ver Cuota",new ImageIcon("Imagenes/mostrar.gif")); 
      private JLabel lbl = new JLabel(new ImageIcon("Imagenes/dolore.gif")); 
      private JLabel lbl1 = new JLabel(new ImageIcon("Imagenes/dolore.gif")); 
      private JLabel lbl2 = new JLabel(new ImageIcon("Imagenes/dolore.gif")); 
      private JLabel lbl3 = new JLabel(new ImageIcon("Imagenes/dolore.gif")); 
      private JLabel ldin = new JLabel(new ImageIcon("Imagenes/dinero.gif")); 
      private JLabel ave = new JLabel(new ImageIcon("Imagenes/te.jpg")); 
      private JLabel paloma = new JLabel(new ImageIcon("Imagenes/paloma.gif"));  
   
   
      String var_nombres = null; 
      String var_apellidos = null; 
      String var_edad = null; 
      String var_telefono = null; 
      String var_celular = null; 
      String var_direccion = null; 
      String var_sexo = null; 
      String var_ciudad = null; 
      String var_profesion = null; 
      String var_cedula = null; 
   
      static double var_mprestamo; 
      static double var_plazo; 
      String var_tinteres = null; 
      String var_tcalculo = null; 
      static double var_tasa; 
      String var_pcuotas = null; // el plazo entre cuotas  
      static int k;  
      static int[] Pk = new int[4000];  
      static double[] Ck = new double[4000];  
      static double[] Sk = new double[4000];  
      static double[] Ak = new double[4000];  
      static double[] Ik = new double[4000];  
   
   
    //variables locales donde acumula los valores para calcular tabla
      static int num_mes =0;  
      static double p;	//monto
      static double n;		//plazo
      static double m;		//capitalizaciones
      static double I;	//interes
      static double N;
      static double puto = 0;
      static double s1 = 0;
      static double abonoe;
      static double saldoe;
      static int periodo = 0;
      static String date = null;
      static String cass = null;
      static int counter = 0;
      static int neo = 0;
      static int neo1 = 0;
      static int nave;
      static int matrix;
      static double mora = 0;
   
   
   
      int dia_inic = 0,mes_inic = 0,año_inic= 0,año_pres= 0,incre= 0,num_pago= 0;
      Date ass = new Date();
      int[] meses_acu = new int[245];
      int[] años_acu = new int[245];
      int[] dias_acu = new int[245];
      
      int hdia = 0,hmes = 0,haño = 0;
   
   
   
      public Internal_prestamo()   
      {  
         initComponents();  
         elv = new File("c:/");  
         open.addActionListener(new abrir());  
         save.addActionListener(new guardar());  
         close.addActionListener(new cerrar());  
         btn_sig1.addActionListener(new boton1());  
         btn_sig2.addActionListener(new boton2());  
         profesion.addActionListener(new prof());  
         sexo.addActionListener(new sex());  
         ciudad.addActionListener(new ciu());  
         cancelar.addActionListener(new cclose());  
         tipo_calculo_interes_jcbox.addActionListener(new tcalculo());  
         pcuotas.addActionListener(new class_pcuotas());  
         clear1.addActionListener(new limp());  
         abonobtn.addActionListener(new abono());  
         saldobtn.addActionListener(new saldoc());  
      
      }      
      private void initComponents()  
      {  
         set_dinamic_memory_components();  
         set_frame_configuration();  
         set_components_configuration();    
      
      }   
      private void set_dinamic_memory_components()  
      {    
         panel_tablas = new javax.swing.JPanel();  
      
         jtabbedpane = new javax.swing.JTabbedPane();  
      
         calculate = new javax.swing.JButton();         
         jMenuBar1 = new javax.swing.JMenuBar();  
         file = new javax.swing.JMenu();  
         herr = new javax.swing.JMenu();  
         open = new javax.swing.JMenuItem();  
         save = new javax.swing.JMenuItem();  
         close = new javax.swing.JMenuItem();        
         abono = new javax.swing.JMenuItem();  
         calc = new javax.swing.JMenuItem();
         imp = new javax.swing.JMenuItem();
         ex = new javax.swing.JMenuItem();
         ex1 = new javax.swing.JMenuItem();
         imp1 = new javax.swing.JMenuItem();       
         JP1 = new javax.swing.JPanel();  
         JP2 = new javax.swing.JPanel();  
         JP3 = new javax.swing.JPanel();   
         JP4 = new javax.swing.JPanel();   
         name = new javax.swing.JLabel("Nombres: ");  
         apell = new javax.swing.JLabel("Apellidos: ");  
         phone = new javax.swing.JLabel("Teléfono: ");  
         phonecell = new javax.swing.JLabel("Celular: ");  
         dir = new javax.swing.JLabel("Dirección: ");  
         sex = new javax.swing.JLabel("Sexo: ");  
         city = new javax.swing.JLabel("Ciudad: ");        
         ced = new javax.swing.JLabel("Cédula: ");  
         age = new javax.swing.JLabel("Edad: ");  
         prof = new javax.swing.JLabel("Profesión: ");	  
         image = new javax.swing.JLabel();	  
         nombres = new javax.swing.JTextField();  
         apellidos = new javax.swing.JTextField(); 
         telefono = new javax.swing.JFormattedTextField();  
         celular = new javax.swing.JFormattedTextField(); 
         direccion = new javax.swing.JTextArea();
         cedula = new javax.swing.JFormattedTextField();
         profesion = new javax.swing.JComboBox(lprofesion);
         edad = new javax.swing.JFormattedTextField();		
         ciudad = new javax.swing.JComboBox(lcity);
         sexo = new javax.swing.JComboBox(lsexo);
         monto_prestamo = new javax.swing.JLabel("Monto del Préstamo ( C$ ): ");
         plazo_prestamo = new javax.swing.JLabel("Plazo del Préstamo ( en años ): ");
         tipo_interes = new javax.swing.JLabel("Tipo de interés: ");
         tipo_calculo_interes = new javax.swing.JLabel("Modo de Cálculo del Interés: ");
         tasa_interes = new javax.swing.JLabel("Tasa de interés: ");
         monto_prestamo_txt = new javax.swing.JTextField();
         tasa_interes_txt = new javax.swing.JTextField();
         plazo_prestamo_txt = new javax.swing.JTextField(); 
         tipo_interes_jcbox = new javax.swing.JComboBox(ltipo_int);
         tipo_calculo_interes_jcbox = new javax.swing.JComboBox(ltipo_calculo);
      
      
      
      }
      private void set_frame_configuration()
      {
         setTitle("§ Sistema de Crédito."); 
         setSize(880,590); 
         setResizable(false); 
         setLocation(60,80); 
         getContentPane().setLayout(null); 
         setVisible(true); 
      
      }
      private void set_components_configuration()
      {
         panel_tablas.setLayout(null); 
         panel_tablas.setBackground(new java.awt.Color(0,0,0)); 
      
      
         getContentPane().add(panel_tablas); 
      
      
      //panel_tablas.setSize(870,590);  
         panel_tablas.setBounds(0, 0, 880, 590);      		 
         panel_tablas.add(jtabbedpane); 
      
         construir_JP1();  
      
         construir_JP3();  
         construir_JP4();      
         jtabbedpane.setToolTipText("Aquí se registran únicamente los datos personales del cliente"); 
         jtabbedpane.setFont(new java.awt.Font("Arial", 1, 12));    
         jtabbedpane.addTab("Datos Personales",new ImageIcon("Imagenes/men.jpg"),panel_maestro); 
      //jtabbedpane.addTab("Requerimientos",new ImageIcon("house.jpg"),JP2);      
         jtabbedpane.addTab("Calendario",new ImageIcon("Imagenes/world.jpg"),JP3);   
         jtabbedpane.addTab("Estado de Cuenta",new ImageIcon("Imagenes/calcular.gif"),JP4);          
         jtabbedpane.setBounds(10,20,850,500);   
         clear1.setToolTipText("Restablece todos los campos para iniciar nuevamente"); 	  
         setJMenuBar(jMenuBar1);          
         jMenuBar1.add(file); 
         jMenuBar1.add(herr);  
         file.add(open);  
         file.add(save); 
         file.add(close); 
         herr.add(calc);
         herr.add(imp);
         herr.add(ex);
         herr.add(imp1);
         herr.add(ex1);      
         file.setText("Archivo"); 
         herr.setText("Herramientas");
         save.setText("Guardar Préstamo"); 
         open.setText("Abrir Préstamo"); 
         close.setText("Cerrar");
         calc.setText("Calculadora"); 
         imp.setText("Imprimir Calendario");
         ex.setText("Calendario a Excel");
         imp1.setText("Imprimir Estado Cuenta");
         ex1.setText("Estado Cuenta a Excel");
         save.setIcon(new javax.swing.ImageIcon("Imagenes/Guardar.jpg"));       
         close.setIcon(new javax.swing.ImageIcon("Imagenes/Cerrar.jpg")); 
         open.setIcon(new javax.swing.ImageIcon("Imagenes/Abrir.jpg")); 
         calc.setIcon(new javax.swing.ImageIcon("Imagenes/calcu.jpg")); 
         imp.setIcon(new javax.swing.ImageIcon("Imagenes/impre.jpg"));
         imp1.setIcon(new javax.swing.ImageIcon("Imagenes/impre.jpg"));
         ex.setIcon(new javax.swing.ImageIcon("Imagenes/excel.jpg"));
         ex1.setIcon(new javax.swing.ImageIcon("Imagenes/excel.jpg"));   
      //setFrameIcon(new javax.swing.ImageIcon("prestamo.GIF"));     
         open.setToolTipText("Abra archivos que ya se han creado anteriormente"); 
         save.setToolTipText("Guarde los datos que se han calculado en esta sub-aplicación"); 
         close.setToolTipText("Opción para cerrar la sub-aplicación");
         calc.setToolTipText("Calculadora para verificar los cálculos"); 	 
      
      }
      private void construir_JP1()//registro de datos del cliente
      {
         panel_maestro.setLayout(null);  
         panel_maestro.add(JP1); 
         panel_maestro.setBackground(new java.awt.Color(255,255,255));
         getContentPane().add(panel_maestro);
         JP1.setLayout(null);
         JP1.setBounds(15,0,370,400);
         JP1.setBackground(new java.awt.Color(255,255,255));
         JP1.setBorder(new TitledBorder(null,"Datos del Cliente",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, new Font("High Tower Text",0,18), new Color(0,0,255)));
         construir_JP2(); 
      
      
      
         JP1.add(nombres);		 
         JP1.add(apellidos);		 
         JP1.add(telefono);	 	
         JP1.add(celular);		  
         JP1.add(sexo);		  
         JP1.add(cedula);  
         JP1.add(ciudad);		  
         JP1.add(edad);	 		 
         JP1.add(name);  
         JP1.add(apell);	 	 		
         JP1.add(phone);  
         JP1.add(phonecell); 	 	
         JP1.add(dir);  
         JP1.add(sex);		  
         JP1.add(ced); 
         JP1.add(prof); 
         JP1.add(age);		 
         JP1.add(city);  
         JP1.add(profesion); 
         direccion.add(js); 
         panel_maestro.add(btn_sig1);	
         panel_maestro.add(btn_sig2); 
      
         panel_maestro.add(ave);
      
         Box box = Box.createHorizontalBox();
      
      
         direccion = new JTextArea ();  
         box.add( new JScrollPane( direccion ) );   
         JP1.add(box);
         box.setBounds(120,210,220,60); ///setBounds(120,150,220,40);    
      
      
      
         name.setBounds(10,30,100,20);			 	 			nombres.setBounds(120,30,220,20);  
         ave.setBounds(500,80,200,282);                
         age.setBounds(10,90,100,20);
         apell.setBounds(10,60,100,20);		 	 			edad.setBounds(120,90,30,20);
         apellidos.setBounds(120,60,220,20);
         ced.setBounds(10,120,100,20);			 	 	      cedula.setBounds(120,120,130,20);
         phone.setBounds(10,150,100,20);				     	telefono.setBounds(120,150,130,20); 
      
         phonecell.setBounds(10,180,100,20);	  				celular.setBounds(120,180,130,20);
         dir.setBounds(10,210,100,20);		 				                                                 																			js.setBounds(340,190,20,60);
         sex.setBounds(10,290,100,20);			  				sexo.setBounds(120,290,100,20);
         city.setBounds(10,320,100,20);		  		   	ciudad.setBounds(120,320,100,20);
         prof.setBounds(10,350,100,20);	                 profesion.setBounds(120,350,100,20);
         btn_sig1.setBounds(120,410,125,20);             btn_sig2.setBounds(540,410,125,20); btn_sig2.setVisible(false);
      
      
      
         nombres.setToolTipText("Digite sus dos nombres"); 
         apellidos.setToolTipText("Digite sus dos Apellidos"); 
         telefono.setToolTipText("Digite su Número de Teléfono convencional"); 
         celular.setToolTipText("Digite el Número de su Teléfono Celular"); 
         direccion.setToolTipText("Digite la dirección de su casa de habitación actual"); 
         cedula.setToolTipText("Número de cédula, procure que sea correcta"); 
         profesion.setToolTipText("Seleccione su nivel de profesionalidad"); 
         edad.setToolTipText("Digite su edad"); 
         sexo.setToolTipText("Su tendecia"); 
         ciudad.setToolTipText("Ciudad de residencia"); 
         btn_sig1.setToolTipText("Permite el acceso a la siguiente etapa de la aplicación.");	 
      
         try
         {
            mf = new MaskFormatter("###-######-####U");
            mf.setPlaceholderCharacter('_');
            DefaultFormatterFactory df = new DefaultFormatterFactory(mf);
            cedula.setFormatterFactory(df);
         
         }
            catch(Exception e){
            }
      
         try
         {
            MaskFormatter mf = new MaskFormatter("###-####");
            mf.setPlaceholderCharacter('_');
            DefaultFormatterFactory df = new DefaultFormatterFactory(mf);
            telefono.setFormatterFactory(df);
         }
            catch(Exception e){
            }
         try
         {
            MaskFormatter mf = new MaskFormatter("###-####");
            mf.setPlaceholderCharacter('_');
            DefaultFormatterFactory df = new DefaultFormatterFactory(mf);
            celular.setFormatterFactory(df);
         }
            catch(Exception e){
            }
      
         try
         {
            MaskFormatter mf = new MaskFormatter("##");
            DefaultFormatterFactory df = new DefaultFormatterFactory(mf);
            edad.setFormatterFactory(df);
         }
            catch(Exception e){
            }
      
         nombres.addKeyListener(
                                 new KeyAdapter()
                                 { 
                                    public void keyTyped(KeyEvent e){
                                    
                                       char c = e.getKeyChar(); 
                                       int x = e.getKeyChar(); 
                                       int keyCode = e.getKeyCode();
                                    
                                       if (((Character.isDigit(c)) ||(c == KeyEvent.VK_ENTER) || keyCode==110)) 
                                       
                                       { 
                                          try
                                          { 
                                             e.consume();
                                          }
                                             catch(Exception E){
                                             } 
                                       }   
                                    }
                                 });
      
         apellidos.addKeyListener(
                                 new KeyAdapter()
                                 { 
                                    public void keyTyped(KeyEvent e)
                                    {
                                    
                                       char c = e.getKeyChar(); 
                                       int x = e.getKeyChar(); 
                                       int keyCode = e.getKeyCode();
                                    
                                       if (((Character.isDigit(c)) ||(c == KeyEvent.VK_ENTER) || keyCode==110)) 
                                       { 
                                          try
                                          { 
                                             e.consume();
                                          }
                                             catch(Exception E){
                                             } 
                                       } 
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
            
            
            imp1.addActionListener(
    		new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				PrinterJob job = PrinterJob.getPrinterJob();
    				job.setPrintable(new PrintObject1());
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
    		     AExcel.crearExcel("Excel/Calendario.xls","Calendario de Pago",tabla.getModel());
		         JOptionPane.showMessageDialog( null,"Se ha agregado su calendario a la hoja Calendario\n está lista para que la vea","Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("nike.gif"));
    			}
    		});
		    
		    ex1.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent e)
			    {
    		     AExcel.crearExcel("Excel/Estado.xls","Estado de Cuenta",tabla2.getModel());
		         JOptionPane.showMessageDialog( null,"Se ha agregado su estado a la Estado test\n está lista para que la vea","Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("nike.gif"));
    			}
    		});

                       
      } 
      private void construir_JP2()//requerimientso del prestamo 
      { 
      
         panel_maestro.add(JP2);
         getContentPane().add(panel_maestro);
      // JP2.setLayout(new FlowLayout());
         JP2.setLayout(null);
      
         JP2.setBounds(410,0,370,400);
         JP2.setBackground(new java.awt.Color(255,255,255));
         JP2.setBorder(new TitledBorder(null,"Requirimientos del Préstamo",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION, new Font("High Tower Text",0,18), new Color(0,0,255)));
      
         JP2.add(monto_prestamo); 
         JP2.add(monto_prestamo_txt);
         JP2.add(plazo_prestamo);
         JP2.add(plazo_prestamo_txt);
      
         JP2.add(tipo_calculo_interes);
         JP2.add(tipo_calculo_interes_jcbox);
         JP2.add(tasa_interes);
         JP2.add(tasa_interes_txt); 
         JP2.add(pcuotas); 
         JP2.add(lblpcuotas);
      
         monto_prestamo_txt.setEditable(false); 
         plazo_prestamo_txt.setEditable(false); 
      
         tipo_calculo_interes_jcbox.setEditable(false); 
         tasa_interes_txt.setEditable(false); 
         pcuotas.setEnabled(false); 
      
      
         monto_prestamo.setBounds(10,30,190,20);
         monto_prestamo_txt.setBounds(200,30,80,20);	
         plazo_prestamo.setBounds(10,60,190,20);
         plazo_prestamo_txt.setBounds(200,60,80,20);
         tasa_interes.setBounds(10,90,170,20);	
         tasa_interes_txt.setBounds(200,90,80,20);
      
      
         tipo_calculo_interes.setBounds(10,120,220,20);		tipo_calculo_interes_jcbox.setBounds(200,120,140	,20);
         lblpcuotas.setBounds(10,150,100,20);					pcuotas.setBounds(200,150,140,20);		
      
         btn_sig2.setToolTipText("Permite el acceso a la creación del calendario de pago.");  
         monto_prestamo_txt.setToolTipText("El monto del préstamo tiene como rango de C$1,000 a  C$ 500,000.00");  
         plazo_prestamo_txt.setToolTipText("El plazo del préstamo tiene un máximo de 20 años");  
         tasa_interes_txt.setToolTipText("Asegúrese de que la tasa sea menor que el 100 %");   
         btn_sig2.setEnabled(false);  
         pcuotas.setEnabled(false);  
         JP2.setVisible(false);
      
         monto_prestamo_txt.addKeyListener(
                                 new KeyAdapter() 
                                 { 
                                    public void keyTyped(KeyEvent e)
                                    {
                                    
                                       char c = e.getKeyChar(); 
                                       int x = e.getKeyChar(); 
                                       int keyCode = e.getKeyCode();
                                    
                                       if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
                                       { 
                                          try
                                          { 
                                             e.consume();
                                          }
                                             catch(Exception E){
                                             }
                                       }
                                    }
                                 });
      
         plazo_prestamo_txt.addKeyListener(
                                 new KeyAdapter()
                                 { 
                                    public void keyTyped(KeyEvent e)
                                    {
                                    
                                       char c = e.getKeyChar(); 
                                       int x = e.getKeyChar(); 
                                       int keyCode = e.getKeyCode();
                                    
                                       if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) )) 
                                       { 
                                          try
                                          { 
                                             e.consume();
                                          }
                                             catch(Exception E){
                                             }
                                       }
                                    }
                                 });
      
         tasa_interes_txt.addKeyListener(
                                 new KeyAdapter()
                                 { 
                                    public void keyTyped(KeyEvent e)
                                    {
                                    
                                       char c = e.getKeyChar(); 
                                       int x = e.getKeyChar(); 
                                       int keyCode = e.getKeyCode();
                                    
                                       if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.')))
                                       { 
                                          try
                                          { 
                                             e.consume();
                                          }
                                             catch(Exception E){
                                             }
                                       }
                                    }
                                 });
      
      }
      private void construir_JP3()
      {
         JP3.setLayout(null);
         JP3.setBackground(new java.awt.Color(100,160,200));
      
         getContentPane().add(JP3);
         JP3.add(tabla);
         JP3.add(JS);
         JP3.add(paloma);
         paloma.setBounds(590,85,140,100);
         tabla.setBounds(20,10,750,440);
         JS.setBounds(20,10,750,440);
         tabla.setModel(new DefaultTableModel(
                                            new Object [][] {
	                                                 
                                            },
                                            new String [] {
                                               "Período","Fecha de la Cuota", "Pago al Principal", "Interés", "Cuota", "Saldo"
                                            }
                                            ) {
                             Class[] types = new Class [] {
                                Double.class,String.class,Double.class, Double.class, Double.class, Double.class
                             };
                             boolean[] canEdit = new boolean [] {
                                false, false, false, false,false,false
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
      
      
      
      
         tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
         JS.setViewportView(tabla);
      
      }
      private void construir_JP4()
      {
         JP4.setLayout(null);
         JP4.setBackground(new java.awt.Color(100,160,200)); 
         getContentPane().add(JP4);
         JP4.add(tabla2);
         JP4.add(JS2);
         JP4.add(lblfecha);
         JP4.add(fecha);
         JP4.add(abonobtn);
         JP4.add(saldobtn);
         JP4.add(cancelar);
         JP4.add(clear1);
         JP4.add(ldin);
      
         lblfecha.setBounds(615,30,130,20);
         fecha.setBounds(600,60,125,25);
         abonobtn.setBounds(600,100,125,25); 
         abonobtn.setBackground(new java.awt.Color(0,0,0));
         abonobtn.setForeground(new java.awt.Color(255,255,255));
      
         saldobtn.setBounds(600,130,125,25); 
         saldobtn.setBackground(new java.awt.Color(0,0,0));
         saldobtn.setForeground(new java.awt.Color(255,255,255));
      
         tabla2.setBounds(20,20,560,445);
         JS2.setBounds(20,20,560,445);
         cancelar.setBounds(600,170,125,25);
         clear1.setBounds(600,200,125,25);
         clear1.setForeground(new java.awt.Color(255,255,255));
         clear1.setBackground(new java.awt.Color(0,0,0));
         ldin.setBounds(615,250,125,100);
         cancelar.setBackground(new java.awt.Color(0,0,0));
         cancelar.setForeground(new java.awt.Color(255,255,255));
         abonobtn.setEnabled(false); 
         saldobtn.setEnabled(false); 
         fecha.setEditable(false); 
      
         tabla2.setModel(
                           new DefaultTableModel( 
                                             new Object [][] { 
                                             
                                             }, 
                                             new String [] { 
                                                "Período", "Fecha", "Interés", "Abono", "Saldo" 
                                             } 
                                             ) { 
                              Class[] types = new Class [] { 
                                 Integer.class, String.class,Double.class, Double.class, Double.class 
                              }; 
                              boolean[] canEdit = new boolean [] { 
                                 false, false, false, false ,false
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
      
      
      
      
         tabla2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS); 
         JS2.setViewportView(tabla2); 
      } 
      class abrir implements ActionListener 
      { 
         public void actionPerformed(ActionEvent e) 
         {
            JFileChooser f = new JFileChooser(elv);              
            f.setFileSelectionMode( JFileChooser.FILES_ONLY );
         
            int result = f.showOpenDialog(Internal_prestamo.this);
         
         // si el usuario hace click en cancel se retorna a la ventana del programa
            if ( result == JFileChooser.CANCEL_OPTION )
               return;
         
          // obtener el archivo seleccionado
         
            File fnombre = f.getSelectedFile();
            fmodelo = fnombre;
         // mostrar error en caso de nombre invalido
            if ( fnombre == null || fnombre.getName().equals(""))
               JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Error de lectura de Archivos", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif")); 
            else {
            // abrir archivo
               try {
                  leer = new DataInputStream(new FileInputStream(fnombre));
               	JP2.setVisible(true);   
                  leerFichero();
                  JOptionPane.showMessageDialog(null,"Su préstamo se ha cargado correctamente","Información del Sistema",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/nike.gif"));
                  if(saldoe == 0)
                  {
                     JOptionPane.showMessageDialog(null, "Esta cuenta ha sido cancelada.", "Estado de Cuenta", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/nike.gif"));
                     abonobtn.setEnabled(false);
                  }
               }
               
               // procesa la excepcion al abrir el archivo
                  catch ( IOException ioException ) {
                     JOptionPane.showMessageDialog(null,"Error al abrir el archivo","Error", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif")); }      
            }
         }
      
         public void leerFichero()
         {
            nombres.setEnabled(false);
            apellidos.setEnabled(false);
            telefono.setEnabled(false);
            celular.setEnabled(false);
            cedula.setEnabled(false);
            edad.setEnabled(false);
            direccion.setEnabled(false);
            tipo_calculo_interes_jcbox.setEnabled(true);
            abonobtn.setEnabled(true);
            saldobtn.setEnabled(true);
            btn_sig1.setEnabled(false);
            btn_sig2.setEnabled(false);
         
            String nom, ape, cel, ced,age,dir,tel,date,flecha,fecha_cuota;
            double mpres = 0;double pla = 0;int periodo = 0;
            double tasa = 0;double capi; int tipocal = 0;double abon = 0;double salado = 0;
            int matrix2 = 0;int indice = 0;int indice1 = 0;int periodo1 = 0;double amor = 0;double inter = 0;double cu = 0;double sado = 0;
         	int periodo2 = 0; double princi = 0; double interes2 = 0; double cuota = 0; double saldo2 = 0;
         	int diag = 0; int mesg = 0; int añog = 0; int num_pagog = 0; double morag = 0; 
         	
            try {
               nom = leer.readUTF();
               ape = leer.readUTF();
               age = leer.readUTF();
               ced = leer.readUTF();
               tel = leer.readUTF();
               cel = leer.readUTF();
               dir = leer.readUTF();
               mpres = leer.readDouble(); 
               pla = leer.readDouble();
               tasa = leer.readDouble();
               tipocal = leer.readInt();          
               capi = leer.readDouble();
               indice1 = leer.readInt();
               indice = leer.readInt();
               diag = leer.readInt();
               mesg = leer.readInt();
               añog = leer.readInt();
               num_pagog = leer.readInt();
            
               nombres.setText(nom);
               apellidos.setText(ape);
               edad.setText(age);
               cedula.setText(ced);
               telefono.setText(tel);
               celular.setText(cel);
               direccion.setText(dir);
               monto_prestamo_txt.setText(String.valueOf(mpres)); 
               tasa_interes_txt.setText(String.valueOf(tasa));
               plazo_prestamo_txt.setText(String.valueOf(pla));
               
               hdia = diag; System.out.println("coasasa"+hdia);
               hmes = mesg; System.out.println("coasasa"+hmes );
               haño = añog; System.out.println("coasasa"+haño );
            
               if(tipocal == 1) 
               { 
                  tipo_calculo_interes_jcbox.setSelectedIndex(1); 
               } 
               if(tipocal == 2) 
               {
                  tipo_calculo_interes_jcbox.setSelectedIndex(2); 
               } 
               if(tipocal == 3) 
               { 
                  tipo_calculo_interes_jcbox.setSelectedIndex(3);  
               } 
            
            
               if(capi == 12.0) 
               { 
                  pcuotas.setSelectedIndex(1); 
                  m = 12;
                  incre = 1;  
               } 
               if(capi == 6.0) 
               {
                  pcuotas.setSelectedIndex(2); 
                  m = 6; 
                  incre = 2;
               } 
               if(capi == 4.0) 
               { 
                  pcuotas.setSelectedIndex(3); 
                  m = 4; 
                  incre = 3;
               } 
               if(capi == 3.0) 
               { 
                  pcuotas.setSelectedIndex(4); 
                  m = 3;
                  incre = 4; 
               } 
               if(capi == 2.0) 
               { 
                  pcuotas.setSelectedIndex(5); 
                  m  = 2; 
                  incre = 6;
               } 
               if(capi == 1.0)	 
               {
                  pcuotas.setSelectedIndex(6);
                  m = 1;  
                  incre = 12;
               
               }
               n = pla; 
               N = m*n; 
               p = mpres; 
               I = tasa; 
               double sal; 
            
            /////////////////////////////////////////////////////////////////////////////////////////////////
               if(tipocal == 2)  
               {double inte,saldo;  
                  System.out.println("Cuota Nivelada");  
               
                  Pk[k] = 0;  
                  Ak[k] = 0; 
                  Ik[k] = 0;  
                  Sk[k] = p + (p*I*n);   
                  System.out.println("saldo inicial "+Sk[k]); 
                  Ck[k] = 0;  
               
               
                  System.out.println(N); 
                  I = I/100; 
                  System.out.println(I); 
                  int k = 1; 
                  sal = Sk[k]; 
                  saldoe = p;	
               
                  do								
                  {	
                     Pk[k] = Pk[(k-1)] + 1;									
                     Ck[k] = Math.pow((1+I),(-N));	
                     Ck[k] = 1 - Ck[k];					
                     Ck[k] = Ck[k]/I;					 
                     Ck[k] = (p / Ck[k]);
                  				
                     System.out.println("Cuota: "+Ck[k]);  
                  
                     Sk[k] = Math.pow((1+I),(-N + k)); 
                     Sk[k] = 1 - Sk[k]; 
                     Sk[k] = Sk[k] / I;
                     Sk[k] = Sk[k] * Ck[k];
                  				
                     System.out.println("Saldo: "+Sk[k]);
                  
                     Ik[k] = Math.pow((1+I),(k-N- 1));
                     Ik[k] = 1 - Ik[k];							
                     Ik[k] = Ik[k] * Ck[k]; 
                  				
                     System.out.println("Interes "+Ik[k]); 
                  
                     Ak[k] = Ck[k] - Ik[k]; 
                  				
                     System.out.print("Amortizacion "+Ak[k]); 
                     sal = Sk[k];
                     System.out.println("Su saldo es: "+sal);
                     System.out.println("Pago # "+k+"  ==  "+Ak[k]+"  "+Ik[k]+"   "+Ck[k]+"  "+Sk[k]);	 
                  
                     k++;
                  }
                  while(( sal > 0.00 ));
               
                  System.out.println("                     Calendario de pago    ");
                  System.out.println("Amortizacion            Interes                      Cuota              Saldo");
               
                  k = 0; 
               
                  do		 							
                  {	 					
                  
                     System.out.println("Pago # "+k+"  ==  "+Ak[k]+"  "+Ik[k]+"   "+Ck[k]+"  "+Sk[k]);	 
                     sal = Sk[k]; 
                     k++;				 			
                  } 
                  while(( sal > 0.00 )); 

               for(int i = 0; i < indice1; i++)
                  
                  {
                     System.out.println("y la tabla mierda");
                     periodo2 = leer.readInt();
                     fecha_cuota = leer.readUTF();
                     princi = leer.readDouble();
                     interes2 = leer.readDouble();
                     cuota = leer.readDouble();
                     saldo2 = leer.readDouble();
                     
                     Pk[k] = periodo2;
                     cass = fecha_cuota;
                     Ak[k] = princi;
                     Ik[k] = interes2;
                     Ck[k] = cuota;
                     Sk[k] = saldo2;
                     
                     System.out.println(Pk[k]);
                     System.out.println(cass);
                     System.out.println(Ak[k]);
                     System.out.println(Ik[k]);
                     System.out.println(Ck[k]);
                     System.out.println(Sk[k]);
                     
                  
                     Internal_prestamo.addrow2();
                      
                     nuevafila.add(Pk[k]);
                     nuevafila.add(cass);
                     nuevafila.add(Ak[k]);
                     nuevafila.add(Ik[k]);
                     nuevafila.add(Ck[k]);
                     nuevafila.add(Sk[k]);
                     modelo.addRow(nuevafila);
                  }

               
               
                  for(int i = 0; i < indice; i++)
                  
                  {
                     System.out.println("mierdoso");
                     periodo = leer.readInt();
                     flecha = leer.readUTF();
                     morag = leer.readDouble();
                     abon = leer.readDouble();
                     salado = leer.readDouble();
                  
                     counter = periodo;
                     date = flecha;
                     mora = morag;
                     abonoe = abon;
                     saldoe = salado;
                  
                     System.out.println(counter);
                     System.out.println(date);
                     System.out.println(mora);
                     System.out.println(abonoe);
                     System.out.println(saldoe);
                  
                     Internal_prestamo.addrow();
                  
                     nuevafila2.add(counter);
                     nuevafila2.add(date);
                     nuevafila2.add(mora);
                     nuevafila2.add(abonoe);
                     nuevafila2.add(saldoe);
                     modelo2.addRow(nuevafila2);
                  }				
               
               }
               if(tipocal == 1)
               {
               
                  System.out.println("Cuota Proporcional");   
                  I = I /100; 
                  k = 0; 
                  Pk[k] = 0; 
                  Ak[k]=0; 
                  Ik[k] = 0; 
                  Sk[k] = p; 
                  Ck[k] = 0; 
                  saldoe = Sk[k]; 
               
                  sal = Sk[k]; 
                  k=1; 
                  System.out.println(" plolo  : "+saldoe); 
               
                  do 
                  
                  { 
                     Pk[k] = Pk[(k-1)] + 1; 
                     Ak[k]=p/N; 
                     Ak[k] = Ak[k]*10; 
                     Ak[k] = Math.floor(Ak[k]); 
                     Ak[k] = Ak[k]/10; 
                  
                     System.out.println("Amortizacion: "+Ak[k]); 
                     Ik[k] = Sk[(k-1)]*I;
                     Ik[k] = Ik[k]*10; 
                     Ik[k] = Math.floor(Ik[k]);
                     Ik[k] = Ik[k]/10;
                  
                     System.out.println("Intereses C$: "+Ik[k]);
                     Ck[k] = Ak[k] + Ik[k];
                     Ck[k] = Ck[k]*10;
                     Ck[k] = Math.floor(Ck[k]);
                     Ck[k] = Ck[k]/10;
                  
                     System.out.println("Cuota C$: "+Ck[k]);
                     Sk[k] = Sk[(k-1)] - Ak[k];
                     System.out.println("Saldo sin redondeo: "+Sk[k]);
                     Sk[k] = Sk[k]*10;
                     Sk[k] = Math.floor(Sk[k]);
                     Sk[k] = Sk[k]/10;
                  
                     sal = Sk[k];
                  
                  
                     if(Sk[k]< 1)
                     {
                        Sk[k] = 0;
                        sal = 0;
                     }
                  
                  
                  
                     System.out.println("Saldo C$: "+Sk[k]);
                     k++;
                  }
                  while(sal>0.000000000000000000000000000000000);
               
                  fecha.setEditable(true);
                  abonobtn.setEnabled(true);
                  saldobtn.setEnabled(true);	
               
                  System.out.println("                     Calendario de pago");
                  System.out.println("        Amortizacion            Interes          Cuota           Saldo");
               
                  k = 0;
                  do
                  {
                     System.out.println("    "+Ak[k]+"     "+Ik[k]+"    "+Ck[k]+"    "+Sk[k]);	
                     sal = Sk[k];
                     k++;		
                  }
                  while(( sal > 0.00));	
                  
                  
                  
                  for(int i = 0; i < indice1; i++)
                  
                  {
                     System.out.println("y la tabla mierda");
                     periodo2 = leer.readInt();
                     fecha_cuota = leer.readUTF();
                     princi = leer.readDouble();
                     interes2 = leer.readDouble();
                     cuota = leer.readDouble();
                     saldo2 = leer.readDouble();
                     
                     Pk[k] = periodo2;
                     cass = fecha_cuota;
                     Ak[k] = princi;
                     Ik[k] = interes2;
                     Ck[k] = cuota;
                     Sk[k] = saldo2;
                     
                     System.out.println(Pk[k]);
                     System.out.println(cass);
                     System.out.println(Ak[k]);
                     System.out.println(Ik[k]);
                     System.out.println(Ck[k]);
                     System.out.println(Sk[k]);
                     
                  
                     Internal_prestamo.addrow2();
                      
                     nuevafila.add(Pk[k]);
                     nuevafila.add(cass);
                     nuevafila.add(Ak[k]);
                     nuevafila.add(Ik[k]);
                     nuevafila.add(Ck[k]);
                     nuevafila.add(Sk[k]);
                     modelo.addRow(nuevafila);
                  }

               
               
                  for(int i = 0; i < indice; i++)
                  
                  {
                     System.out.println("mierdoso");
                     periodo = leer.readInt();
                     flecha = leer.readUTF();
                     morag = leer.readDouble();
                     abon = leer.readDouble();
                     salado = leer.readDouble();
                  
                     counter = periodo;
                     date = flecha;
                     mora = morag;
                     abonoe = abon;
                     saldoe = salado;
                  
                     System.out.println(counter);
                     System.out.println(date);
                     System.out.println(mora);
                     System.out.println(abonoe);
                     System.out.println(saldoe);
                  
                     Internal_prestamo.addrow();
                  
                     nuevafila2.add(counter);
                     nuevafila2.add(date);
                     nuevafila2.add(mora);
                     nuevafila2.add(abonoe);
                     nuevafila2.add(saldoe);
                     modelo2.addRow(nuevafila2);
                  }	
               
			
                              
               
               }
               if(tipocal == 3) 
               { 
                  System.out.println("FLAT INTERESES____________________________"); 
               
                  N = m*n;  
                  I = I /100;   
               				//n = n*12; 
                  k = 0;  
                  Ak[k] = 0;  
                  Ck[k] = 0;  
                  Pk[k] = 0;  
                  Ik[k] = 0;  
                  Sk[0] = p + (p*I*n); 
                  Sk[k]=0; 
                  saldoe = p + (p*I*n);		  						
               
                  k = 1;  
                  do  
                  {  
                     Pk[k] = Pk[(k-1)] +1;  
                     System.out.println("Pk: "+Pk[k]);  
                     Ak[k] = p / N;  
                     Ak[k] = Ak[k]*10;  
                     Ak[k] = Math.floor(Ak[k]);  
                     Ak[k] = Ak[k]/10;  
                  
                     System.out.println("Ak: "+Ak[k]);  
                     Ik[k] = (p*I*n)/N;  
                     Ik[k] = Ik[k]*10;  
                     Ik[k] = Math.floor(Ik[k]);  
                     Ik[k] = Ik[k]/10;  
                  
                  
                     System.out.println("Ik: "+Ik[k]);  
                     Ck[k] = Ak[k] + Ik[k];  
                     Ck[k] = Ck[k]*10;  
                     Ck[k] = Math.floor(Ck[k]);  
                     Ck[k] = Ck[k]/10;  
                  
                     System.out.println("Ck: "+Ck[k]);  
                     Sk[k] = Sk[(k-1)] - Ck[k];  
                     Sk[k] = Sk[k]*10;  
                     Sk[k] = Math.floor(Sk[k]);  
                     Sk[k] = Sk[k]/10;  
                  
                     System.out.println("Sk: "+Pk[k]);  
                  
                     sal = Sk[k];  
                  
                     if(Sk[k]< 1)  
                     {  
                        Sk[k] = 0;  
                        sal = 0;  
                     }  
                  
                  
                     k++;   
                  
                  } 
                  while(( Sk[0] > 0.0000000000000 ));	  
               
                  
               
                  fecha.setEditable(true); 
                  abonobtn.setEnabled(true); 
                  saldobtn.setEnabled(true);	 
               
               
               
                  abonobtn.setEnabled(true); 
                  saldobtn.setEnabled(true); 
               
               
               
               
                  for(int i = 0; i < indice1; i++)
                  
                  {
                     System.out.println("y la tabla mierda");
                     periodo2 = leer.readInt();
                     fecha_cuota = leer.readUTF();
                     princi = leer.readDouble();
                     interes2 = leer.readDouble();
                     cuota = leer.readDouble();
                     saldo2 = leer.readDouble();
                     
                     Pk[k] = periodo2;
                     cass = fecha_cuota;
                     Ak[k] = princi;
                     Ik[k] = interes2;
                     Ck[k] = cuota;
                     Sk[k] = saldo2;
                     
                     System.out.println(Pk[k]);
                     System.out.println(cass);
                     System.out.println(Ak[k]);
                     System.out.println(Ik[k]);
                     System.out.println(Ck[k]);
                     System.out.println(Sk[k]);
                     
                  
                     Internal_prestamo.addrow2();
                      
                     nuevafila.add(Pk[k]);
                     nuevafila.add(cass);
                     nuevafila.add(Ak[k]);
                     nuevafila.add(Ik[k]);
                     nuevafila.add(Ck[k]);
                     nuevafila.add(Sk[k]);
                     modelo.addRow(nuevafila);
                  }

               
               
                  for(int i = 0; i < indice; i++)
                  
                  {
                     System.out.println("mierdoso");
                     periodo = leer.readInt();
                     flecha = leer.readUTF();
                     interes2 = leer.readDouble();
                     abon = leer.readDouble();
                     salado = leer.readDouble();
                  
                     counter = periodo;
                     date = flecha;
                     mora = morag;
                     abonoe = abon;
                     saldoe = salado;
                  
                     System.out.println(counter);
                     System.out.println(date);
                     System.out.println(interes2);
                     System.out.println(abonoe);
                     System.out.println(saldoe);
                  
                     Internal_prestamo.addrow();
                  
                     nuevafila2.add(counter);
                     nuevafila2.add(date);
                     nuevafila2.add(interes2);
                     nuevafila2.add(abonoe);
                     nuevafila2.add(saldoe);
                     modelo2.addRow(nuevafila2);
                  }			
               
               
               }
            
            }
            
               catch ( IOException ioException ) {
                  JOptionPane.showMessageDialog( null,"Error durante la lectura del archivo","Error de Lectura", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
               
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
	tabla.getColumnModel().getTotalColumnWidth();
	double scale = 1; 
	if (tableWidth >= pageWidth) {
	scale = pageWidth / tableWidth;
	}

	double headerHeightOnPage=
	tabla.getTableHeader().getHeight()*scale;
	double tableWidthOnPage=tableWidth*scale;
	double oneRowHeight=(tabla.getRowHeight()+
	tabla.getRowMargin())*scale;
	int numRowsOnAPage=(int)((pageHeight-headerHeightOnPage)/
	oneRowHeight);
	double pageHeightForTable=oneRowHeight*	numRowsOnAPage;
	int totalNumPages= (int)Math.ceil(((double)tabla.getRowCount())/
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
	int numRowsLeft = tabla.getRowCount() - lastRowPrinted;
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
		tabla.paint(g2);
		g2.scale(1/scale,1/scale);
		g2.translate(0f,pageIndex*pageHeightForTable);
		g2.translate(0f, -headerHeightOnPage);
		g2.setClip(0, 0,
		(int) Math.ceil(tableWidthOnPage), 
		(int)Math.ceil(headerHeightOnPage));
		g2.scale(scale,scale);
		tabla.getTableHeader().paint(g2);


				return Printable.PAGE_EXISTS;
				}

	}
	
	class PrintObject1 implements Printable
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
	tabla2.getColumnModel().getTotalColumnWidth();
	double scale = 1; 
	if (tableWidth >= pageWidth) {
	scale = pageWidth / tableWidth;
	}

	double headerHeightOnPage=
	tabla2.getTableHeader().getHeight()*scale;
	double tableWidthOnPage=tableWidth*scale;
	double oneRowHeight=(tabla2.getRowHeight()+
	tabla2.getRowMargin())*scale;
	int numRowsOnAPage=(int)((pageHeight-headerHeightOnPage)/
	oneRowHeight);
	double pageHeightForTable=oneRowHeight*	numRowsOnAPage;
	int totalNumPages= (int)Math.ceil(((double)tabla2.getRowCount())/
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
	int numRowsLeft = tabla2.getRowCount() - lastRowPrinted;
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
		tabla2.paint(g2);
		g2.scale(1/scale,1/scale);
		g2.translate(0f,pageIndex*pageHeightForTable);
		g2.translate(0f, -headerHeightOnPage);
		g2.setClip(0, 0,
		(int) Math.ceil(tableWidthOnPage), 
		(int)Math.ceil(headerHeightOnPage));
		g2.scale(scale,scale);
		tabla2.getTableHeader().paint(g2);


				return Printable.PAGE_EXISTS;
				}

	}
 
   
      class guardar implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JFileChooser f = new JFileChooser(elv);		
            f.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = f.showSaveDialog(Internal_prestamo.this);
            if(result==JFileChooser.CANCEL_OPTION)
               return;
            File fnombre = f.getSelectedFile();
            fmodelo = fnombre;
         
            if(result==JFileChooser.APPROVE_OPTION)
            {
               if(fnombre == null || fnombre.getName().equals(""))
                  JOptionPane.showMessageDialog(null,"Nombre del archivo inválido","Nombre del archivo inválido",JOptionPane.ERROR_MESSAGE);
               else
               {
                  try{
                     escribir = new DataOutputStream(new FileOutputStream(fmodelo));      
                     escribirFichero();
                     JOptionPane.showMessageDialog(null,"Su préstamo se ha guardado correctamente","Información del Sistema",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/nike.gif"));
                  }
                  // mostrar mensaje de error si no se puede abrir el archivo
                     catch ( IOException ioException ) {
                        JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE );  }    
               } // fin else
            }
         }
      
      
         public void escribirFichero()
         {
         
            String nom, ape, cel, ced,age,dir,tel,date,flecha,fecha_cuota;
            double mpres = 0;double pla = 0;
            double tasa = 0;double capi; int tipocal = 0; int matrix = 0; double abon = 0;double salado = 0;int periodo = 0;
            int indice = 0;int indice1 = 0;int periodo1 = 0;double amor = 0;double inter = 0;double cu = 0;double sado = 0;
            int periodo2 = 0; double princi = 0; double interes2 = 0; double cuota = 0; double saldo2 = 0;
            int diag = 0; int mesg = 0; int añog = 0; int num_pagog = 0; double morag = 0;
         
            nom = nombres.getText();
            ape = apellidos.getText();
            date = fecha.getText();           
            age = edad.getText();
            ced = cedula.getText();                      
            tel = telefono.getText();
            cel = celular.getText();
            dir = direccion.getText();
            indice1 = Internal_prestamo.tabla.getRowCount();
            indice = Internal_prestamo.tabla2.getRowCount();
            diag = dia_inic;
            mesg = mes_inic;
            añog = año_inic;
            num_pagog = num_pago;
            mpres = var_mprestamo;
            pla = var_plazo;
            tipocal = nave;
            tasa = var_tasa;
            capi = m;
            //periodo = counter;
         
            try
            {
            
               escribir.writeUTF(nom);
               escribir.writeUTF(ape);
               escribir.writeUTF(age);
               escribir.writeUTF(ced);
               escribir.writeUTF(tel);
               escribir.writeUTF(cel);
               escribir.writeUTF(dir);
               escribir.writeDouble(mpres);
               escribir.writeDouble(pla);
               escribir.writeDouble(tasa);
               escribir.writeInt(tipocal);
               escribir.writeDouble(capi);
               escribir.writeInt(indice1);
               escribir.writeInt(indice);
               escribir.writeInt(diag);
               escribir.writeInt(mesg);
               escribir.writeInt(añog);
               escribir.writeInt(num_pagog);
            
               System.out.println(nom);
               System.out.println(ape);
               System.out.println(age);
               System.out.println(ced);
               System.out.println(tel);
               System.out.println(cel);
               System.out.println(dir);
               System.out.println(mpres);
               System.out.println(pla);
               System.out.println(tasa);
               System.out.println(tipocal);
               System.out.println(capi);
               System.out.println(periodo);
               System.out.println(diag);
               System.out.println(mesg);
               System.out.println(añog);
               System.out.println(num_pagog);
            
            
            for(int i = 0; i < indice1; i++)
            {
                  periodo2 = Integer.parseInt(String.valueOf(tabla.getValueAt(i,0)));
                  fecha_cuota = String.valueOf(tabla.getValueAt(i,1));
                  princi = Double.parseDouble(String.valueOf(tabla.getValueAt(i,2)));
                  interes2 = Double.parseDouble(String.valueOf(tabla.getValueAt(i,3)));
                  cuota = Double.parseDouble(String.valueOf(tabla.getValueAt(i,4)));
                  saldo2 = Double.parseDouble(String.valueOf(tabla.getValueAt(i,5)));

                  escribir.writeInt(periodo2);  System.out.println(periodo2);
                  escribir.writeUTF(fecha_cuota);  System.out.println(fecha_cuota);
                  escribir.writeDouble(princi);  System.out.println(princi);
                  escribir.writeDouble(interes2);  System.out.println(interes2);
                  escribir.writeDouble(cuota);   System.out.println(cuota);
                  escribir.writeDouble(saldo2);   System.out.println(saldo2);
            }
            
            
               for(int i = 0; i < indice; i++)
               {
                  periodo = Integer.parseInt(String.valueOf(tabla2.getValueAt(i,0)));
                  flecha = String.valueOf(tabla2.getValueAt(i,1));
                  morag = Double.parseDouble(String.valueOf(tabla2.getValueAt(i,2)));
                  abon = Float.parseFloat(String.valueOf(tabla2.getValueAt(i,3)));
                  salado = Double.parseDouble(String.valueOf(tabla2.getValueAt(i,4)));
               
                  escribir.writeInt(periodo);
                  escribir.writeUTF(flecha);
                  escribir.writeDouble(morag);
                  escribir.writeDouble(abon);
                  escribir.writeDouble(salado);
               
                  System.out.println(periodo);
                  System.out.println(flecha);
                  System.out.println(morag);
                  System.out.println(abon);
                  System.out.println(salado);
               }
            
               escribir.close();
            }
            
               catch(IOException ioException )
               { 
                  JOptionPane.showMessageDialog(null,"Error escribiendo en el archivo","IO Exception", JOptionPane.ERROR_MESSAGE );}
         
         }
      }
   
      class cerrar implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            hide();
            dispose();
            Virus.nuevop.setEnabled(true);
         }
      }
   
      class boton1 implements ActionListener 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
            var_nombres = nombres.getText(); 
            var_apellidos = apellidos.getText(); 
            var_telefono = telefono.getText(); 
            var_celular = celular.getText(); 
            var_direccion = direccion.getText(); 
            var_cedula = cedula.getText(); 
            var_edad = edad.getText(); 
         
            if(var_sexo == ""||var_ciudad == ""||var_profesion == ""||var_profesion == null || var_sexo == null || var_ciudad == null || var_nombres == null || var_apellidos == null || var_edad == null || var_cedula == null || var_telefono == null || var_celular == null || var_direccion == null|| (nombres.getText()).length() == 0|| (apellidos.getText()).length() == 0|| (edad.getText()).length() == 0|| (cedula.getText()).length() == 0|| (direccion.getText()).length() == 0|| (telefono.getText()).length() == 0|| (celular.getText()).length() == 0 )
            { 
               JOptionPane.showMessageDialog(null, "Por favor complete el formulario correctamente.", "Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
               System.out.println("Error de introducción de datos");	
               JP2.setVisible(false);
               btn_sig2.setVisible(false);
               
            
            } 
            else 
            { 
               int result = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro de sus datos personales?","Confirmaciófn de Datos Personales",JOptionPane.YES_NO_OPTION);
               JP2.setVisible(false);
               btn_sig2.setVisible(false);
            
            
               if(result == JOptionPane.YES_OPTION) 
               { 
                  JP2.setVisible(true);
                  btn_sig2.setVisible(true);
                  btn_sig1.setEnabled(false); 
                  btn_sig2.setEnabled(true); 
                  ave.setVisible(false); 
               
                  monto_prestamo_txt.setEditable(true); 
                  plazo_prestamo_txt.setEditable(true); 
                  tipo_interes_jcbox.setEnabled(true); 
                  tipo_calculo_interes_jcbox.setEnabled(true); 
                  tasa_interes_txt.setEditable(true); 
                  pcuotas.setEnabled(true); 
               
                  nombres.setEditable(false); 
                  apellidos.setEditable(false); 
                  telefono.setEditable(false); 
                  celular.setEditable(false); 
                  direccion.setEditable(false); 
                  cedula.setEditable(false); 
                  profesion.setEditable(false); 
                  edad.setEditable(false); 
                  ciudad.setEnabled(false); 
                  sexo.setEnabled(false); 
                  profesion.setEnabled(false); 
               
               //jtabbedpane.setSelectedIndex(1);
               } 
               else 
               { 
                  JOptionPane.showMessageDialog(null, "Haga el favor de corregir sus datos.","Información del Sistema", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/help.gif")); 
                  JP2.setVisible(false);
                  btn_sig2.setVisible(false);
                  btn_sig1.setEnabled(true); 
                  btn_sig2.setEnabled(false); 
               
                  monto_prestamo_txt.setEditable(false); 
                  plazo_prestamo_txt.setEditable(false); 
                  tipo_interes_jcbox.setEnabled(false); 
                  tipo_calculo_interes_jcbox.setEnabled(false); 
                  tasa_interes_txt.setEditable(false); 
                  pcuotas.setEnabled(false); 
               
                  nombres.setEditable(true); 
                  apellidos.setEditable(true); 
                  telefono.setEditable(true); 
                  celular.setEditable(true); 
                  direccion.setEditable(true); 
                  cedula.setEditable(true); 
                  profesion.setEditable(true); 
                  edad.setEditable(true); 
                  ciudad.setEnabled(true); 
                  sexo.setEnabled(true);  
                  profesion.setEnabled(true); 
                  jtabbedpane.setSelectedIndex(0); 
               }			
            }  
         }  
      } 
   
      class boton2 implements ActionListener
      {	
         double sal;
         public void actionPerformed(ActionEvent e)
         { 
          try 
           {
            var_mprestamo = Float.parseFloat(monto_prestamo_txt.getText());
            var_plazo = Float.parseFloat(plazo_prestamo_txt.getText());
            año_pres = Integer.parseInt(plazo_prestamo_txt.getText());
            var_tasa = Float.parseFloat(tasa_interes_txt.getText());
            var_pcuotas = (String)pcuotas.getSelectedItem();
            var_tcalculo = (String)tipo_calculo_interes_jcbox.getSelectedItem();
         
            System.out.println();
            System.out.println();
            System.out.println();
         
            if(var_pcuotas == "" ||var_pcuotas == null||(monto_prestamo_txt.getText()).length() == 0 || (plazo_prestamo_txt.getText()).length() == 0 || var_tcalculo == null||var_tcalculo == ""||(tasa_interes_txt.getText()).length() == 0 || (año_pres == 0))
            {
               JOptionPane.showMessageDialog(null, "Haga el favor de completar correctamente\nel formulario de requerimientos", "Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
               System.out.println("Error de introduccion de datos");
            }
            else
            {
               if(var_tasa > 100 || var_mprestamo < 1000 || var_mprestamo > 500000 ||var_plazo > 20)
               {
                  JOptionPane.showMessageDialog(null, "Algunos de los datos digitados no son permisibles para los cálculos", "Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif") );
                  System.out.println("Error de introducción de datos");						
               
               }
               
               
               else
               {
                  int result = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro de sus Requerimientos del préstamo?","Información del Sistema",JOptionPane.YES_NO_OPTION);
               
                  if(result == JOptionPane.YES_OPTION)
                  {
                  
                     var_mprestamo = Float.parseFloat(monto_prestamo_txt.getText());
                  
                     var_plazo = Integer.parseInt(String.valueOf(plazo_prestamo_txt.getText()));
                     var_tasa = Float.parseFloat(tasa_interes_txt.getText());
                  
                  
                  
                     p = var_mprestamo;
                     n = var_plazo;
                     I = var_tasa;
                     N = m*n;
                  
                  
                     System.out.println("capital: "+p);
                     System.out.println("plazo:  "+n );
                     System.out.println("Interes: "+I);
                     System.out.println("m: "+m);
                     System.out.println("n: "+n);
                     System.out.println("N: "+N);
                  
                     System.out.println(var_tcalculo);
                  
                  
                     JOptionPane.showMessageDialog(null, "En la siguiente pestaña puede \nvisualizar su calendario de pago.", "Información del Sistema", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/nike.jpg"));
                  
                     monto_prestamo_txt.setEditable(false);
                     plazo_prestamo_txt.setEditable(false);
                     tipo_interes_jcbox.setEnabled(false);
                     tipo_calculo_interes_jcbox.setEnabled(true);
                     tasa_interes_txt.setEditable(false);
                     pcuotas.setEnabled(false);
                     btn_sig2.setEnabled(false);
                     jtabbedpane.setSelectedIndex(1);
                  
                     dia_inic = ass.getDate();
                  
                     mes_inic = ass.getMonth() + 1;
                     año_inic = ass.getYear() + 1900;
                     num_pago = (año_pres*12)/incre;
                     meses_acu[0] = 0;
                     años_acu[0] = 0;
                  
                  
                     for(int i=1;i<=num_pago;i++)
                     {       
                        meses_acu[0] = mes_inic;
                        años_acu[0] =  año_inic;
                        dias_acu[0] = dia_inic; 
                        System.out.println("Fecha de Pago #"+i+": "+Fechas_Pago.dia_retornado(dia_inic,Fechas_Pago.mes_retornado(i,meses_acu[0],incre),Fechas_Pago.año_retornado(meses_acu[0], años_acu[0],incre, i))+" / "+Fechas_Pago.mes_retornado(i,meses_acu[0],incre)+" / "+Fechas_Pago.año_retornado(meses_acu[0], años_acu[0],incre, i));
                        meses_acu[i] =Fechas_Pago.mes_retornado(i,meses_acu[0],incre);
                        años_acu[i] = Fechas_Pago.año_retornado(meses_acu[0], años_acu[0],incre, i);
                        dias_acu[i] = Fechas_Pago.dia_retornado(dia_inic,Fechas_Pago.mes_retornado(i,meses_acu[0],incre),Fechas_Pago.año_retornado(meses_acu[0], años_acu[0],incre, i));  
                     }
                  
                  
                     if(var_tcalculo == "Cuota Nivelada")
                     {
                        double inte,saldo;
                        System.out.println("Cuota Nivelada"); 
                     
                        Pk[k] = 0;
                        Ak[k] = 0;
                        Ik[k] = 0;
                        Sk[k] = p;
                        System.out.println("Saldo inicial "+Sk[k]);
                        Ck[k] = 0;
                     
                     
                        System.out.println(N);
                        I = I/100;
                        System.out.println(I);
                        int k = 1;
                        sal = Sk[k];
                        saldoe = p;	
                     
                        do								
                        {	
                           Pk[k] = Pk[(k-1)] + 1;									
                           Ck[k] = Math.pow((1+I),(-N));	
                           Ck[k] = 1 - Ck[k];					
                           Ck[k] = Ck[k]/I;					
                           Ck[k] = (p / Ck[k]);
                           Ck[k] = Ck[k]*1000;
                           Ck[k] = Math.floor(Ck[k]);
                           Ck[k] = Ck[k]/1000;
                        
                           System.out.println("Cuota: "+Ck[k]);
                        
                           Sk[k] = Math.pow((1+I),(-N + k));
                           Sk[k] = 1 - Sk[k];
                           Sk[k] = Sk[k] / I;
                           Sk[k] = Sk[k] * Ck[k];
                        	
                           System.out.println("Saldo: "+Sk[k]);
                        
                           Ik[k] = Math.pow((1+I),(k-N- 1));
                           Ik[k] = 1 - Ik[k];							
                           Ik[k] = Ik[k] * Ck[k];
                        	
                           System.out.println("Interés "+Ik[k]);
                        
                           Ak[k] = Ck[k] - Ik[k];
                        		
                           System.out.print(" "+Ak[k]);
                           sal = Sk[k];
                           System.out.println("Su saldo es: "+sal);
                        
                           k++;
                        }
                        while(( sal > 0.00 ));
                     
                        System.out.println("                      Calendario de pago");
                        System.out.println("Amortizacion            Interes                     Cuota              Saldo");
                     
                        k = 0; 
                     
                        do 
                        {   modelo =  (DefaultTableModel)tabla.getModel(); 
                            nuevafila = new Vector(); 
                        
                           nuevafila.add(Pk[k]);
                        
                           if(dias_acu[k] < 10)
                           {
                              nuevafila.add("0"+String.valueOf(dias_acu[k])+" / "+String.valueOf(Fechas_Pago.mes_string(meses_acu[k]))+" / "+String.valueOf(años_acu[k])); 
                           }
                           else
                           {
                              nuevafila.add(String.valueOf(dias_acu[k])+" / "+String.valueOf(Fechas_Pago.mes_string(meses_acu[k]))+" / "+String.valueOf(años_acu[k]));     
                           }
                           nuevafila.add(Fechas_Pago.round(Ak[k])); 
                           nuevafila.add(Fechas_Pago.round(Ik[k])); 
                           nuevafila.add(Fechas_Pago.round(Ck[k])); 
                           nuevafila.add(Fechas_Pago.round(Sk[k])); 
                           modelo.addRow(nuevafila); 
                           sal = Sk[k]; 
                           k++;
                        
                        
                        }  
                        while(( sal > 0.00 ));                       
                        k=0; 
                        do	 								
                        {	 					
                        
                           System.out.println("Pago # "+k+" == "+Ak[k]+"       "+Ik[k]+"       "+Ck[k]+"       "+Sk[k]); 	
                           sal = Sk[k]; 
                           k++;			 				
                        }
                        while(( sal > 0.00 )); 
                     
                        fecha.setEnabled(true); 
                        abonobtn.setEnabled(true); 
                        saldobtn.setEnabled(true);	 
                     
                        int a = 0;
                        String b = "Fecha Inicial";
                        double c = 0.00;
                        modelo2 =  (DefaultTableModel)tabla2.getModel();
                        nuevafila2 = new Vector();
                        tabla2.setModel(modelo2);									
                        nuevafila2.add(a);
                        nuevafila2.add(b);
                        nuevafila2.add(mora);
                        nuevafila2.add(c);
                        nuevafila2.add(saldoe);
                        modelo2.addRow(nuevafila2);
                     
                     } 
                     if(var_tcalculo == "Cuota Proporcional")  
                     { 
                        System.out.println("Cuota Proporcional"); 
                        I = I /100;
                        k = 0;
                        Pk[k] = 0;
                        Ak[k]=0;
                        Ik[k] = 0;
                        Sk[k] =  p;
                        Ck[k] = 0;
                        saldoe = Sk[k];
                        sal = Sk[k];
                        k=1;
                        System.out.println(" plolo  : "+saldoe);
                     
                        do
                        
                        {
                           Pk[k] = Pk[(k-1)] + 1;
                           Ak[k]=p/N;
                              
                           System.out.println("Amortizacion: "+Ak[k]);
                           Ik[k] = Sk[(k-1)]*I;
                             
                           System.out.println("Intereses C$: "+Ik[k]);
                           Ck[k] = Ak[k] + Ik[k];
                              
                           System.out.println("Cuota C$: "+Ck[k]);
                           Sk[k] = Sk[(k-1)] - Ak[k];
                           System.out.println("Saldo sin redondeo: "+Sk[k]);
                              
                           sal = Sk[k];
                        
                        
                           if(Sk[k]< 1)
                           {
                              Sk[k] = 0;
                              sal = 0;
                           }
                        
                        
                        
                           System.out.println("Saldo C$: "+Sk[k]);
                           k++;
                        }
                        while(sal>0.000000000000000000000000000000000);
                        k = 0; 
                     
                        do 
                        {   modelo =  (DefaultTableModel)tabla.getModel(); 
                           nuevafila = new Vector(); 
                        
                           nuevafila.add(Pk[k]);
                        
                           if(dias_acu[k] < 10)
                           {
                              nuevafila.add("0"+String.valueOf(dias_acu[k])+" / "+String.valueOf(Fechas_Pago.mes_string(meses_acu[k]))+" / "+String.valueOf(años_acu[k])); 
                           }
                           else
                           {
                              nuevafila.add(String.valueOf(dias_acu[k])+" / "+String.valueOf(Fechas_Pago.mes_string(meses_acu[k]))+" / "+String.valueOf(años_acu[k]));     
                           }
                           nuevafila.add(Fechas_Pago.round(Ak[k])); 
                           nuevafila.add(Fechas_Pago.round(Ik[k])); 
                           nuevafila.add(Fechas_Pago.round(Ck[k])); 
                           nuevafila.add(Fechas_Pago.round(Sk[k])); 
                           modelo.addRow(nuevafila); 
                           sal = Sk[k]; 
                           k++;
                        
                        
                        }  
                        while(( sal > 0.00 ));   
                     
                     
                        k=0;
                     
                        do
                        {
                           System.out.println("    "+Ak[k]+"     "+Ik[k]+"    "+Ck[k]+"    "+Sk[k]);	
                           sal = Sk[k];
                           k++;		
                        }
                        while(( sal > 0.00));	 
                     
                        k=0;
                        int a = 0;
                        String b = "Fecha Inicial";
                        double c = 0.00;
                        modelo2 =  (DefaultTableModel)tabla2.getModel();
                        nuevafila2 = new Vector();
                        tabla2.setModel(modelo2);									
                        nuevafila2.add(a);
                        nuevafila2.add(b);
                        nuevafila2.add(mora);
                        nuevafila2.add(c);
                        nuevafila2.add(saldoe);
                        modelo2.addRow(nuevafila2);
                     
                     
                        fecha.setEditable(true);
                        abonobtn.setEnabled(true);
                        saldobtn.setEnabled(true);	
                     
                     
                        System.out.println("                     Calendario de pago");
                        System.out.println("        Amortizacion            Interes          Cuota           Saldo");
                     
                        k = 0;
                     
                     } 
                     if(var_tcalculo == "Interés FLAT")  
                     { 							
                        I = I /100; 
                     
                     		//n = n*12;  
                        k = 0;  
                        Ak[k] = 0;  
                        Ck[k] = 0;  
                        Pk[k] = 0;  
                        Ik[k] = 0;  
                        Sk[k] = p + (p*I*n);  
                        saldoe = Sk[k];		  						
                     
                        k = 1;  
                        do  
                        {  
                        
                           Pk[k] = Pk[(k-1)] +1; 
                           System.out.println("Pk: "+Pk[k]); 
                           Ak[k] = p / N; 
                        	
                           System.out.println("Ak: "+Ak[k]); 
                           Ik[k] = (p*I*n)/N; 
                        		
                           System.out.println("Ik: "+Ik[k]); 
                           Ck[k] = Ak[k] + Ik[k]; 
                        		
                           System.out.println("Ck: "+Ck[k]); 
                           Sk[k] = Sk[(k-1)] - Ck[k]; 
                        	
                           System.out.println("Sk: "+Pk[k]);  
                        
                           sal = Sk[k]; 
                        
                           if(Sk[k]< Ck[k]) 
                           { 
                              Sk[k] = 0; 
                           } 
                        
                        
                           k++; 
                        
                        }
                        while((sal>0.000000000000000000000000000000000));
                        k=0;			
                        do 
                        {   modelo =  (DefaultTableModel)tabla.getModel(); 
                           nuevafila = new Vector(); 
                        
                           nuevafila.add(Pk[k]);
                        
                           if(dias_acu[k] < 10)
                           {
                              nuevafila.add("0"+String.valueOf(dias_acu[k])+" / "+String.valueOf(Fechas_Pago.mes_string(meses_acu[k]))+" / "+String.valueOf(años_acu[k])); 
                           }
                           else
                           {
                              nuevafila.add(String.valueOf(dias_acu[k])+" / "+String.valueOf(Fechas_Pago.mes_string(meses_acu[k]))+" / "+String.valueOf(años_acu[k]));     
                           }
                           nuevafila.add(Fechas_Pago.round(Ak[k])); 
                           nuevafila.add(Fechas_Pago.round(Ik[k])); 
                           nuevafila.add(Fechas_Pago.round(Ck[k])); 
                           nuevafila.add(Fechas_Pago.round(Sk[k])); 
                           modelo.addRow(nuevafila); 
                           sal = Sk[k]; 
                           k++;
                        
                        
                        }  
                        while(( sal > 0.00 ));
                     
                        k=0;
                        int a = 0;
                        String b = "Fecha Inicial";
                        double c = 0.00;
                        modelo2 =  (DefaultTableModel)tabla2.getModel();
                        nuevafila2 = new Vector();
                        tabla2.setModel(modelo2);									
                        nuevafila2.add(a);
                        nuevafila2.add(b);
                        nuevafila2.add(mora);
                        nuevafila2.add(c);
                        nuevafila2.add(saldoe);
                        modelo2.addRow(nuevafila2);
                     
                        fecha.setEditable(true); 
                        abonobtn.setEnabled(true);  
                        saldobtn.setEnabled(true);	  
                     
                     }
                  
                  }
                  
                  else
                  {
                     monto_prestamo_txt.setEditable(true);
                     plazo_prestamo_txt.setEditable(true);
                  
                     tipo_calculo_interes_jcbox.setEnabled(true);
                     tasa_interes_txt.setEditable(true);
                     btn_sig2.setEnabled(true);
                  }
               
               
               
               } 
            } 
         }
         catch(Exception E)
         { 
         JOptionPane.showMessageDialog(null, "Complete correctamente el formulario", "Información del Sistema", JOptionPane.WARNING_MESSAGE,new ImageIcon("Imagenes/help.gif"));
         System.out.println("Error de introduccion de datos");
         
         } 
         } 
      }
      class prof implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JComboBox profesion= (JComboBox)e.getSource();
            String nueva = (String)profesion.getSelectedItem();
         
            var_profesion = nueva;
            System.out.println(var_profesion);			
         }
      }
      class sex implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JComboBox sexo = (JComboBox)e.getSource();
            String nueva = (String)sexo.getSelectedItem();
         
            var_sexo = nueva;
            System.out.println(var_sexo);	
         }
      }
      class class_pcuotas implements ActionListener 
      {
         public void actionPerformed(ActionEvent e) 
         { 
            JComboBox pcuotas = (JComboBox)e.getSource(); 
            String nueva = (String)pcuotas.getSelectedItem(); 
            System.out.println("Capitalizacion: "+nueva); 
         
         
            var_pcuotas = nueva; 
         
            if(pcuotas.getSelectedIndex() == 1) 
            {  
               m = 12;
               incre = 1;
            } 
            if(pcuotas.getSelectedIndex() == 2) 
            { 
               m =  6; 
               incre = 2;
            } 
            if(pcuotas.getSelectedIndex() == 3) 
            { 
               m = 4;
               incre = 3;
            } 
            if(pcuotas.getSelectedIndex() == 4) 
            { 
               m = 3; 
               incre = 4;
            } 
            if(pcuotas.getSelectedIndex() == 5) 
            { 
               m = 2;
               incre = 6; 
            } 
            if(pcuotas.getSelectedIndex() == 6) 
            {
               m = 1;
               incre = 12;	
            }
         
         } 
      } 
      class ciu implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JComboBox ciduad= (JComboBox)e.getSource();
            String nueva = (String)ciudad.getSelectedItem();
         
            var_ciudad = nueva;
            System.out.println(var_ciudad);	
         }
      }
   
      class tcalculo implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            JComboBox tipo_calculo_interes_jcbox = (JComboBox)e.getSource();
            String nueva = (String)tipo_calculo_interes_jcbox.getSelectedItem();
            nave = tipo_calculo_interes_jcbox.getSelectedIndex();
            var_tcalculo = nueva;
            System.out.println(var_tcalculo);		
         
         }
      }
      class cclose implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
	         try
	            {
		            int bf;
		         do
		         {
		           bf = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Cuál es Numero de Cuota que desea ver?: ","Ver Cuotas",JOptionPane.QUESTION_MESSAGE)); 
		         }
		         while(bf < 0);
		         tabla.setRowSelectionInterval(bf,bf);
		         jtabbedpane.setSelectedIndex(1);
		        }
		        catch(Exception as)
		        {JOptionPane.showMessageDialog(null, "Digite correctamente el valor", "Información del Sistema", JOptionPane.WARNING_MESSAGE,new ImageIcon("Imagenes/help.gif"));}
            }
         }
      
   
      class limp implements ActionListener 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
            int result1 = JOptionPane.showConfirmDialog((Component) null, "¿Está seguro de restablecer los campos?,\n","Restablecer Campos",JOptionPane.YES_NO_OPTION);
         
            if(result1 == JOptionPane.YES_OPTION) 
            { 
               JOptionPane.showMessageDialog(null, "Ahora puede crear una nueva cuenta.","Información del Sistema", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/nike.gif"));	
               limpiarcampos();
               jtabbedpane.setSelectedIndex(0);
            }		  	
         }
        
               
         public void limpiarcampos() 
         {
            System.gc(); 
            clear(); 
         //textfield 
            JP2.setVisible(false);
            btn_sig2.setVisible(false);
            ave.setVisible(true);
            nombres.setEditable(true); nombres.setEnabled(true); 
            apellidos.setEditable(true); apellidos.setEnabled(true);
            telefono.setEditable(true);  telefono.setEnabled(true);
            celular.setEditable(true);  celular.setEnabled(true);
            direccion.setEditable(true); direccion.setEnabled(true);
            edad.setEditable(true);   edad.setEnabled(true);
            cedula.setEditable(true);  cedula.setEnabled(true);
            fecha.setEditable(true);   fecha.setEnabled(true);
            monto_prestamo_txt.setEditable(false);  
            tasa_interes_txt.setEditable(false);  
            plazo_prestamo_txt.setEditable(false);  
         
         //botones
            calculate.setEnabled(false);   
            clear1.setEnabled(true);  
            btn_sig1.setEnabled(true);  
            btn_sig2.setEnabled(false);  
            cancelar.setEnabled(true); 
            saldobtn.setEnabled(false); 
            abono.setEnabled(false); 
         
         //jcombobox 
            sexo.setEnabled(true);    
            ciudad.setEnabled(true);    
            profesion.setEnabled(true);  
            tipo_interes_jcbox.setEnabled(false);    
            tipo_calculo_interes_jcbox.setEnabled(false);   
            pcuotas.setEnabled(false);   
         
            sexo.setSelectedIndex(0);   
            ciudad.setSelectedIndex(0);   
            profesion.setSelectedIndex(0) ;   
            ciudad.setSelectedIndex(0);   
         
            tipo_calculo_interes_jcbox.setSelectedIndex(0);   
            pcuotas.setSelectedIndex(0);   
         
            p=0;	//monto
            n=0;		//plazo
            m=0;		//capitalizaciones
            I=0;	//interes
            N=0;
         
            abonoe=0;
            saldoe=0;
            periodo = 0;
            date = null;
            counter = 0;
            neo = 0;
            neo1 = 0;
            nave=0;
            matrix=0;
 
            var_nombres = null;
            var_apellidos = null;
            var_edad = null;
            var_telefono = null;
            var_celular = null;
            var_direccion = null;
            var_sexo = null;
            var_ciudad = null;
            var_profesion = null;
            String var_cedula = null;
         
            var_mprestamo =0;
            var_plazo =0;
            var_tinteres = null;
            var_tcalculo = null;
            var_tasa =0;
            var_pcuotas = null; // el plazo entre cuotas
            k = 0;
         
         }	
         public void clear()
         {
            nombres.setText(""); 
            apellidos.setText(""); 
            telefono.setText(""); 
            celular.setText(""); 
            direccion.setText(""); 
            edad.setText(""); 
            cedula.setText(""); 
            monto_prestamo_txt.setText(""); 
            tasa_interes_txt.setText(""); 
            plazo_prestamo_txt.setText("");  
         
            tabla.setModel(new DefaultTableModel(
                                            new Object [][] {
	                                                 
                                            },
                                            new String [] {
                                               "Período","Fecha de la Cuota", "Pago al Principal", "Interés", "Cuota", "Saldo"
                                            }
                                            ) {
                             Class[] types = new Class [] {
                                Double.class,String.class,Double.class, Double.class, Double.class, Double.class
                             };
                             boolean[] canEdit = new boolean [] {
                                false, false, false, false,false,false
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
 
         
            tabla2.setModel(
                              new DefaultTableModel( 
                                                new Object [][] { 
                                                
                                                }, 
                                                new String [] {  
                                                   "Período", "Fecha", "Interés","Abono", "Saldo" 
                                                }  
                                                ) { 
                                 Class[] types = new Class [] { 
                                    Integer.class, String.class, Double.class, Double.class ,Double.class 
                                 }; 
                                 boolean[] canEdit = new boolean [] { 
                                    false, false, false, false ,false
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
         } 
      } 
      class abono implements ActionListener   
      {  
         public void actionPerformed(ActionEvent e)  
         {  
            try
            {
               String abo = null;
               abonoe = 0;
               k++;		
            
               if(var_tcalculo == "Cuota Proporcional")
               {
               	
               	              	
                  try  
                  {		  
                     do 
                     { 
                        date = fecha.getText(); 
                        abonoe = Double.parseDouble(JOptionPane.showInputDialog(null,"El monto de su abono será: ","Abono al préstamo",JOptionPane.QUESTION_MESSAGE));
                     
                     } 
                     while(abonoe <= 0); 
                  
                  }
                     catch(Exception err) {
                        JOptionPane.showMessageDialog(null,"Introduzca sólo datos permisibles.","Error de lectura de datos", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/nike.gif"));}
                  counter++;  
               
               
               
               
               
               
               
               
               
                  if(abonoe != Fechas_Pago.round(Ck[counter])) 
                  { 
                     JOptionPane.showMessageDialog(null,"El monto de su abono tiene que ser el que se\nespecifica en el calendario de pago de lo contrario no podra abonar","Error de introduccion de datos", JOptionPane.ERROR_MESSAGE);
                     counter--; 
                     k--; 
                  
                  }
                  else
                  {			
                  //Sk[counter] -=Ak[counter];
                     saldoe -= Ak[counter];
                  
                     if(saldoe <= 1)
                     {
                     //counter++;
                        saldoe = 0;
                        abonobtn.setEnabled(false);
                        JOptionPane.showMessageDialog(null,"Su cuenta se ha cancelado.","Estado de Cuenta", JOptionPane.INFORMATION_MESSAGE);	
                     
                        nuevafila2 = new Vector();
                        nuevafila2.add((counter));
                        nuevafila2.add(date);
                        nuevafila2.add(Ik[counter]);
                        nuevafila2.add(abonoe);
                        nuevafila2.add(saldoe);
                        modelo2.addRow(nuevafila2);		
                     
                     }	
                     else
                     {
                        nuevafila2 = new Vector(); 
                        nuevafila2.add((counter)); 
                        nuevafila2.add(date);
                        nuevafila2.add(Ik[counter]);  
                        nuevafila2.add(abonoe); 
                        nuevafila2.add(saldoe); 
                        modelo2.addRow(nuevafila2); 
                     
                     } 
                  }				   	
               }
            
               if(var_tcalculo == "Cuota Nivelada")   
               {	 	 
                  try  
                  {		  
                     do 
                     { 
                        date = fecha.getText(); 
                        abonoe = Double.parseDouble(JOptionPane.showInputDialog(null,"El monto de su abono será: ","Abono al préstamo",JOptionPane.QUESTION_MESSAGE));
                     //abonoe = Double.parseDouble(abo); 
                     
                     } 
                     while(abonoe <= 0); 
                  
                  }
                     catch(Exception err) {
                        JOptionPane.showMessageDialog(null,"Introduzca sólo datos permisibles.","Error de lectura de datos", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/nike.gif"));}
                  counter++; 
               
                  if(abonoe < Fechas_Pago.round(Ck[counter]) || abonoe > Fechas_Pago.round(Ck[counter]))
                  {
                     JOptionPane.showMessageDialog(null,"El monto de su abono tiene que ser el que se\nespecifica en el calendario.","Error de introduccion de datos", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
                     counter--;
                     k--;					
                  }
                  else
                  {							
                     saldoe -= Ak[counter];  
                     if(saldoe <= 1)
                     {
                       // counter++;
                        abonobtn.setEnabled(false);
                        JOptionPane.showMessageDialog(null,"Su cuenta  ha sido  cancelado.","Estado de Cuenta", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/nike.jpg"));	
                        saldoe = 0;
                     
                     
                        nuevafila2 = new Vector();
                        nuevafila2.add((counter));
                        nuevafila2.add(date);
                        nuevafila2.add(Ik[counter]);
                        nuevafila2.add(abonoe);
                        nuevafila2.add(saldoe);
                        modelo2.addRow(nuevafila2);		
                     
                     }	
                     else
                     {
                        nuevafila2 = new Vector();
                        nuevafila2.add((counter));
                        nuevafila2.add(date);
                        nuevafila2.add(Ik[counter]);
                        nuevafila2.add(abonoe);
                        nuevafila2.add(saldoe);
                        modelo2.addRow(nuevafila2);
                     }
                  }						    
               }
               if(var_tcalculo == "Interés FLAT")
               {
                  try
                  {
                     do
                     {
                        date = fecha.getText();
                        abonoe = Double.parseDouble(JOptionPane.showInputDialog(null,"El monto de su abono será: ","Abono al préstamo",JOptionPane.QUESTION_MESSAGE));
                        if(abonoe < 0)
                        {
                           JOptionPane.showMessageDialog(null,"No introduzca cantidades negativas.","Información del Sistema", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
                        }
                     }
                     while(abonoe <= 0 || abonoe < Fechas_Pago.round(Ck[k]) || abonoe > saldoe );
                  
                  }
                     catch(Exception errroe){
                        JOptionPane.showMessageDialog(null,"Introduzca sólo datos permisibles.","Error de lectura de datos", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));}
                  counter++;
                  if(Fechas_Pago.round(Ck[k]) <= saldoe && abonoe >= Fechas_Pago.round(Ck[k]))
                  { 
                     saldoe -= abonoe;
                     nuevafila2 = new Vector();
                     nuevafila2.add((counter));
                     nuevafila2.add(date);
                     nuevafila2.add(Ik[counter]);
                     nuevafila2.add(abonoe);
                     nuevafila2.add(saldoe);
                     modelo2.addRow(nuevafila2);
                                      
                     if(saldoe <=1) 
                     {
	                     abonobtn.setEnabled(false);
	                    JOptionPane.showMessageDialog(null,"Su cuenta ha sido cancelada.","Estado de Cuenta", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/nike.gif"));	
                           
	                  }                
                                      
                  }    
               } 
            }
               catch(Exception eo){
                  JOptionPane.showMessageDialog(null,"Digite la cantidad correcta.","Error de lectura de datos", JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));}
         
         }
      }
   
      class saldoc implements ActionListener 
      { 
         public void actionPerformed(ActionEvent e) 
         { 
            JOptionPane.showMessageDialog(null,"Su saldo es: "+saldoe,"Estado de Cuenta", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/nike.jpg"));
         } 
      }	 
      
      public static void addrow() 
      {
         modelo2 =  (DefaultTableModel)tabla2.getModel();
         nuevafila2 = new Vector();
         tabla2.setModel(modelo2);
      
      }
   	public static void addrow2() 
              
      {
         modelo =  (DefaultTableModel)tabla.getModel();
         nuevafila = new Vector();
         tabla.setModel(modelo);
      }  
      //public static void main(String []args) 
      //{ 
       ///*try{
      	//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
      	//}catch(Exception e){e.printStackTrace();}*/
         //Internal_prestamo men = new Internal_prestamo(); 
      //}		 
   }