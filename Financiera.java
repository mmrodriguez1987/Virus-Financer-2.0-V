
 

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.TreePath;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import javax.swing.text.*;
import java.lang.*;


public class Financiera extends javax.swing.JInternalFrame {
    
   
    
    public Financiera () 
    {
        initComponents();
    }  
        
    private void initComponents() 
    {
        jPanel1 = new javax.swing.JPanel();
        DefaultMutableTreeNode top = new javax.swing.tree.DefaultMutableTreeNode("Calculadoras Financieras");
        CrearArbol(top);
        jTree1 = new JTree(top);             
        jPanel2 = new javax.swing.JPanel();
        land = new javax.swing.JLabel(new ImageIcon("imagenes/qw.jpg"));
        jDesktopPane1 = new javax.swing.JDesktopPane();
        js = new JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea("    Hola Usuario!!!:\n    Bienvenido    \n    esperamos que satisfazga\n    tus necesidades");
        jLabel1 = new javax.swing.JLabel();       
        //jPanel4 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem(new ImageIcon("Imagenes/Cerrar.jpg"));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("§§§ Calculadoras Financieras.");
        setLocation(20,20);
        jPanel1.setLayout(null);
        //jTree1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setFont(new java.awt.Font("French Script MT",1,23));
        jTree1.setFont(new java.awt.Font("French Script MT", 1, 23));
        jTree1.setToolTipText("Seleccione la calculadora a usar");
        jTree1.addTreeSelectionListener(new TreeSelectionListener() 
        {
            public void valueChanged(TreeSelectionEvent e)
            {
					DefaultMutableTreeNode Principal = (DefaultMutableTreeNode)(e.getPath().getLastPathComponent());
        			Object nodeInfo = Principal.getUserObject();
			        String kulo = nodeInfo.toString();
			        System.out.println("Cadena = "+kulo);
			        Calling(kulo);
  		      }
        });    
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 20, 200, 240);
        jPanel1.add(jTree1);
        jTree1.setBounds(0, 0, 200, 240);
        jPanel2.setLayout(null);
        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 0));      
        jDesktopPane1.setToolTipText("Pantalla Visualizadora de las calculadoras Financieras");
        jPanel2.add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 800, 490);
        jDesktopPane1.add(land);
        land.setBounds(0,0,800,490);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(200, 20, 800, 490);             
        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 200, 240);
        jScrollPane1.setViewportView(jTree1);
        jPanel3.setLayout(null);
     
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("French Script MT", 1, 23));
        jTextArea1.setForeground(new java.awt.Color(51, 51, 51));
        jTextArea1.setToolTipText("Aqui se muestra como se debe de usar cada una de las diversas calculadoras que le ofrece nuestro programa.");
        jPanel3.add(jTextArea1);
        jPanel3.add(js);
        jTextArea1.setBounds(0, 40, 200, 210);
		js.setBounds(0,40,200,210);
		js.setViewportView(jTextArea1);
        jLabel1.setFont(new java.awt.Font("French Script MT", 1, 23));
        jLabel1.setText("Información al Usuario.");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 10, 200, 20);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 260, 200, 250);
        jMenu2.setText("Opciones");
        jMenu2.setFont(new java.awt.Font("French Script MT", 1, 23));
        jMenuItem1.setFont(new java.awt.Font("French Script MT", 1, 23));
        jMenuItem1.setText("Limpiar");
        //jMenu2.add(jMenuItem1);
        jMenuItem2.setFont(new java.awt.Font("French Script MT", 1, 23));
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
         });

         jMenu2.add(jMenuItem2);

         jMenuBar2.add(jMenu2);

         setJMenuBar(jMenuBar2);
         setVisible(true);
         setSize(1000,650);

    }
   
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)
    {
       hide();
       dispose();
    }
    public void Calling(String cadena)
    {
	      String Internal = cadena; 
	      Efectiva efe = new Efectiva();
	      Real re = new Real();
	      Nominal nomi = new Nominal();
	      Comercial come = new Comercial();
	      Anual ano = new Anual();
	      Mensual menu = new Mensual();
	      Relaciones rela = new Relaciones();
	     
       if(Internal == "Tasas Efectivas") 
       {
	        jTextArea1.setText(Advertencia_Efectiva);
	       
	       
		    jDesktopPane1.add(efe);
		    efe.setClosable(true);
		    efe.setMaximizable(false);
		    efe.setIconifiable(false);
		    efe.setVisible(true);
		    efe.toFront();
		    
            nomi.setVisible(false);
            re.setVisible(false);
            come.setVisible(false);
            ano.setVisible(false);
            menu.setVisible(false);
            rela.setVisible(false);

          System.out.println("Has elegido Efectiva");
       }
       if(Internal == "Tasas Nominales") 
       {
          
            jTextArea1.setText(Advertencia_Nominal);

            jDesktopPane1.add(nomi);
		    nomi.setClosable(true);
		    nomi.setMaximizable(false);
		    nomi.setIconifiable(false);
		    nomi.setVisible(true);
		    nomi.toFront();

       }
       if(Internal == "Interés Real") 
       {
           
            jTextArea1.setText(Advertencia_Real);
            jDesktopPane1.add(re);
		    re.setClosable(true);
		    re.setMaximizable(false);
		    re.setIconifiable(false);
		    re.setVisible(true);
		    re.toFront();

       }
       if(Internal == "Interés Comercial") 
       {
           
            jTextArea1.setText(Advertencia_Comercial);
            jDesktopPane1.add(come );
		    come.setClosable(true);
		    come.setMaximizable(false);
		    come.setIconifiable(false);
		    come.setVisible(true);
		    come.toFront();

       }
       if(Internal == "Interés Anual") 
       {
           
            jTextArea1.setText(Advertencia_Anual);

            jDesktopPane1.add(ano );
		    ano.setClosable(true);
		    ano.setMaximizable(false);
		    ano.setIconifiable(false);
		    ano.setVisible(true);
		    ano.toFront();

       }
       if(Internal == "Interés Mensual") 
       { 
           
            jTextArea1.setText(Advertencia_Mensual);

            jDesktopPane1.add(menu);
		    menu.setClosable(true);
		    menu.setMaximizable(false);
		    menu.setIconifiable(false);
		    menu.setVisible(true);
		    menu.toFront();

       } 
       if(Internal == "Tasas Equivalentes") 
       {
            
            jTextArea1.setText(Advertencia_tasas);

            jDesktopPane1.add(rela);
		    rela.setClosable(true);
		    rela.setMaximizable(false);
		    rela.setIconifiable(false	);
		    rela.setVisible(true);
		    rela.toFront();

       }
       if(Internal == "Calculadora Convencional.")
       {
          Run_calculadora(); 
          jTextArea1.setText(Advertencia_Calculadora);

       }  
	 }     
    public void CrearArbol(DefaultMutableTreeNode Mutable)
    {
      DefaultMutableTreeNode Principal = null; 
      DefaultMutableTreeNode Ecuaciones = null;  
      DefaultMutableTreeNode Simple = null;  
      DefaultMutableTreeNode Compuesto = null;  
      DefaultMutableTreeNode Relaciones = null; 
      DefaultMutableTreeNode normal = null;  
      DefaultMutableTreeNode efectiva = null;  
      DefaultMutableTreeNode nominal = null;
      DefaultMutableTreeNode real = null;
      DefaultMutableTreeNode comercial = null;
      DefaultMutableTreeNode mensual = null;
      DefaultMutableTreeNode anual = null;
      DefaultMutableTreeNode tasas = null;
      DefaultMutableTreeNode calculadora = null;
    	 
    	
        Ecuaciones = new DefaultMutableTreeNode("Ecuaciones de Valores");
    	Mutable.add(Ecuaciones); 
    	Simple = new DefaultMutableTreeNode("Interés Compuesto"); 
    	Ecuaciones.add(Simple); 
    	efectiva = new DefaultMutableTreeNode("Tasas Efectivas"); 
    	Simple.add(efectiva); 
    	nominal = new DefaultMutableTreeNode("Tasas Nominales"); 
    	Simple.add(nominal);    	 
    	Compuesto = new DefaultMutableTreeNode("Interés Simple"); 
    	Ecuaciones.add(Compuesto); 
    	real = new DefaultMutableTreeNode("Interés Real"); 
    	Compuesto.add(real);  
    	comercial = new DefaultMutableTreeNode("Interés Comercial"); 
    	Compuesto.add(comercial); 
    	mensual = new DefaultMutableTreeNode("Interés Mensual"); 
    	Compuesto.add(mensual); 
    	anual = new DefaultMutableTreeNode("Interés Anual"); 
    	Compuesto.add(anual); 	    	 
    	Relaciones = new DefaultMutableTreeNode("Relaciones"); 
        Mutable.add(Relaciones); 
        tasas = new DefaultMutableTreeNode("Tasas Equivalentes"); 
        Relaciones.add(tasas); 
    	normal = new DefaultMutableTreeNode("Calculadora"); 
        Mutable.add(normal);  
        calculadora = new DefaultMutableTreeNode("Calculadora Convencional."); 
        normal.add(calculadora);   	 
    }       
    public void Run_calculadora()
    {        
    	try
		{
			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec("calc.exe");
			p.waitFor();

		}
		catch (IOException ioe )
		{
			ioe.printStackTrace();
		} 
		catch ( InterruptedException ie )
		{
		    ie.printStackTrace();
		}
    }    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Financiera().setVisible(true);
            }
        });
    }    
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel land;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    //private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTree jTree1;    
    private DefaultMutableTreeNode ecuaciones1; 
    private DefaultMutableTreeNode ecuaciones2; 
    private DefaultMutableTreeNode ecuaciones3; 
    private DefaultMutableTreeNode int_simple;
    private DefaultMutableTreeNode int_comp; 
    private DefaultMutableTreeNode tefectiva;
    private DefaultMutableTreeNode tnominal;
    private DefaultMutableTreeNode real;
    private DefaultMutableTreeNode comercial;
    private DefaultMutableTreeNode anual;
    private DefaultMutableTreeNode mensual;
    private DefaultMutableTreeNode tasas;
    private DefaultMutableTreeNode calcwin;
    private String comparador = null;
    private String Advertencia_Efectiva = "Con esta calculadora puedes\nobtener los distintos valores\nde los diferentes despejes que\nrealiza la calculadora al escojer\nla incógnita correspondiente a la\nTasa Nominal";
    private String Advertencia_Nominal = "Con esta calculadora puedes\nobtener los distintos valores\nde los diferentes despejes que\nrealiza la calculadora al escojer\nla incógnita correspondiente a la\nTasa Efectiva";
    private String Advertencia_Real = "Con esta calculadora puedes\nconocer tus intereses\nsegún el año real(365 días)";
    private String Advertencia_Comercial = "Con esta calculadora\npuedes conocer\ntus intereses\nsegún el año comercial(360 días)";
    private String Advertencia_Anual = "Con esta calculadora\npuedes conocer tus\nintereses anuales.";
    private String Advertencia_tasas = "Con esta calculadora\npuedes establecer las\ndistintas relaciones\nentre las tasas equivalentes.";
    private String Advertencia_Calculadora = "Calculadora de Windows";
    private String Advertencia_Mensual = "Con esta calculadora\npuedes conocer tus interes\nde acuerdo a un número\ndeterminado de meses.";
    private JScrollPane js;

}
