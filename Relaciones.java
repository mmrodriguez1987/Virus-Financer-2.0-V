import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTabbedPane.*;
import javax.swing.event.*;

public class Relaciones extends JInternalFrame implements ActionListener
{

   private JTabbedPane tabla = new JTabbedPane();
   private JPanel p_tablas = new JPanel();
   
	private JMenuBar barra = new JMenuBar();
	private JMenu tasa1 = new JMenu("Tasas Equivalentes");
	private JMenu tasa2 = new JMenu("Tasas Efectiva-Nominal");
	private JMenu tasa3 = new JMenu("Tasas Real-Comercial");
	
	
	private JLabel efec1 = new JLabel("Tasa Efectiva I ( % ):");
	private JLabel efec2 = new JLabel("Tasa Efectiva II ( % ):");
	private JLabel lcap = new JLabel("Capitalización I");
	private JLabel lcap1 = new JLabel("Capitalización II");
	private JLabel resp1= new JLabel();
	
	private JTextField efe1 = new JTextField();
	private JTextField efe2 = new JTextField();
	
	private JRadioButtonMenuItem item1 = new JRadioButtonMenuItem("Tasa Efectiva 1",true);
	private JRadioButtonMenuItem item2 = new JRadioButtonMenuItem("Tasa Efectiva 2",false);
	
	String[] lista = {"","Semestral","Cuatrimestral","Trimestral","Bimensual","Mensual"};
	private JComboBox capita = new JComboBox(lista);
	String[] lista2 = {"","Semestral","Cuatrimestral","Trimestral","Bimensual","Mensual"};
	private JComboBox capita2 = new JComboBox(lista2);
	
	private JButton calcular = new JButton("Calcular",new ImageIcon("Imagenes/calcular.GIF"));
	private JButton limpiar = new JButton("Limpiar",new ImageIcon("Imagenes/limpiar.GIF"));
	private JButton cancelar = new JButton("Cancelar",new ImageIcon("Imagenes/cancelar.GIF"));
	
	private JPanel p = new JPanel();
	private ButtonGroup grupo = new ButtonGroup();
	
	//////////////////////////////////////////////////////////////////
	private JLabel hefec = new JLabel("Tasa Efectiva( % ): ");
	private JLabel nomi = new JLabel("Tasa Nominal( % ): ");
	private JLabel resp2 = new JLabel();
	private JLabel rh = new JLabel("Capitalizable:");
	
	private JTextField efem = new JTextField();
	private JTextField efem2 = new JTextField();
	
	String[] capitem2 = {"","Semestral","Cuatrimestral","Trimestral","Bimensual","Mensual"};
	private JComboBox capi2 = new JComboBox(capitem2);
	
	
	private JRadioButtonMenuItem item3 = new JRadioButtonMenuItem("Interés Real",true);
	private JRadioButtonMenuItem item4 = new JRadioButtonMenuItem("Interés Comercial",false);
	
	private JButton calcular2 = new JButton("Calcular",new ImageIcon("Imagenes/calcular.GIF"));
   private JButton limpiar2 = new JButton("Limpiar",new ImageIcon("Imagenes/limpiar.GIF"));
   
   private JPanel p2 = new JPanel();
   private ButtonGroup grupo2 = new ButtonGroup();
   
	//////////////////////////////////////////////////////
	private JLabel lblIo = new JLabel("Interes Comercial ( C$ ): ");
	private JLabel lblIr = new JLabel("Interes Real ( C$ ): ");	
	private JLabel lblresp = new JLabel();
	
	private JTextField txtIo = new JTextField();
	private JTextField txtIr = new JTextField();
	private JRadioButtonMenuItem item5 = new JRadioButtonMenuItem("Tasa Nominal",true);
	private JRadioButtonMenuItem item6 = new JRadioButtonMenuItem("Tasa Efectiva",false);
	private JButton calcular3 = new JButton("Calcular",new ImageIcon("Imagenes/calcular.GIF"));
	private JButton limpiar3 = new JButton("Limpiar",new ImageIcon("Imagenes/limpiar.GIF"));
	
	private JRadioButtonMenuItem comercial = new JRadioButtonMenuItem("Comercial",false);
   private JRadioButtonMenuItem real = new JRadioButtonMenuItem("Real",true);
   
   private JPanel p3 = new JPanel();
   private ButtonGroup grupo3 = new ButtonGroup();
    
   double tf1, tf2,Io,Ir; 
   double te_p2,tn_p2;
   double m,m2,m3;
   int op,op2,op3; 
   
	public Relaciones()
	{
		construir_frame();
		cancelar.addActionListener(new cancelar_class());
		limpiar.addActionListener(new limpiar_class());
		limpiar2.addActionListener(new limpiar2_class());
		limpiar3.addActionListener(new limpiar3_class());
		capita.addActionListener(new lista_class());
		capita2.addActionListener(new lista2_class());
		capi2.addActionListener(new lista3_class());
		calcular.addActionListener(this);
		calcular2.addActionListener(this);
		calcular3.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		
		tabla.addMouseListener(new MouseAdapter()
      { public void mouseClicked(MouseEvent e){
        
      if(tabla.getSelectedIndex() == 0)
      {
	     tasa1.setEnabled(true);
	     tasa2.setEnabled(false);
	     tasa3.setEnabled(false);
	   }
	   }});
	   
	   tabla.addMouseListener(new MouseAdapter()
      { public void mouseClicked(MouseEvent e){

	   if(tabla.getSelectedIndex() == 1)
	   {
		   tasa1.setEnabled(false);
		   tasa2.setEnabled(true);
		   tasa3.setEnabled(false);
		 }
		}});
	
	tabla.addMouseListener(new MouseAdapter()
      { public void mouseClicked(MouseEvent e){

		 if(tabla.getSelectedIndex() == 2)
		 {
			 tasa1.setEnabled(false);
			 tasa2.setEnabled(false);
			 tasa3.setEnabled(true);
		 } 
		}});
	}
	
	class cancelar_class implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			hide();
			dispose();
		
		}
	}
	
	class limpiar_class implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			efem.setText(" ");
			efem2.setText(" ");
			
				 				 
			resp2.setText(" ");		 		 
		}
	}
   
   class limpiar2_class implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			efe1.setText(" ");
			efe2.setText(" ");
				 				 
			resp1.setText(" ");		 		 
		}
	}
	
	class limpiar3_class implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			txtIo.setText(" ");
			txtIr.setText(" ");
				 				 
			lblresp.setText(" ");		 		 
		}
	}
	
		class lista_class implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox capita = (JComboBox)e.getSource();
			op = (int)capita.getSelectedIndex();
			
			if(op == 0)
			{
				JOptionPane.showMessageDialog(null,"Elija una opción válida.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
			}
			if(op == 1)
			{
				m = 2;
			}
			if(op == 2)
			{
				m = 3;
			}
			if(op == 3)
			{
				m = 4;
			}
			if(op == 4)
			{
				m = 6;
			}
			if(op == 5)
			{
				m = 12;
			}
		}
	}
	
			class lista2_class implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox capita2 = (JComboBox)e.getSource();
			op2 = (int)capita2.getSelectedIndex();
			
			if(op2 == 0)
			{
				JOptionPane.showMessageDialog(null,"Elija una opción válida.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
			}
			if(op2 == 1)
			{
				m2 = 2;
			}
			if(op2 == 2)
			{
				m2 = 3;
			}
			if(op2 == 3)
			{
				m2 = 4;
			}
			if(op2 == 4)
			{
				m2 = 6;
			}
			if(op2 == 5)
			{
				m2 = 12;
			}
		}
	}
	
				class lista3_class implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox capi2 = (JComboBox)e.getSource();
			op3 = (int)capi2.getSelectedIndex();
			
			if(op3 == 0)
			{
				JOptionPane.showMessageDialog(null,"Elija una opción válida.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
			}
			if(op3 == 1)
			{
				m3 = 2;
			}
			if(op3 == 2)
			{
				m3 = 3;
			}
			if(op3 == 3)
			{
				m3 = 4;
			}
			if(op3 == 4)
			{
				m3 = 6;
			
			}
			if(op3 == 5)
			{
				m3 = 12;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == item1)
		{
			efe1.setEditable(false);
			efe2.setEditable(true);
			capita.setEnabled(true);
		   capita2.setEnabled(true);
			
	   }
	   if(e.getSource() == item2)
		{
			efe2.setEditable(false);
			efe1.setEditable(true);
			capita.setEnabled(true);
		   capita2.setEnabled(true);
		
	   }
	  if(e.getSource() == item3)
		{
			txtIr.setEditable(false);
			txtIo.setEditable(true);
	   }
	   if(e.getSource() == item4)
		{
			txtIo.setEditable(false);
			txtIr.setEditable(true);
	   }
	   if(e.getSource() == item5)
		{
			efem.setEditable(true);
			efem2.setEditable(false);
			capi2.setEnabled(true);
	   }
	   if(e.getSource() == item6)
		{
			efem2.setEditable(true);
			efem.setEditable(false);
			capi2.setEnabled(true);

	   }
	   if(e.getSource() == calcular)
	   {
		   try
		   {
					    if(item1.isSelected() == true)
					    {		               
							   tf2 = Float.parseFloat(efe2.getText());
							   if(tf2 > 100 || tf2 < 0)
							 	{
									 JOptionPane.showMessageDialog(null,"La tasa Nominal no puede ser mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
									 efe2.setText(" ");
							 	}
							 	else
					       	{
							    tf1 = Math.pow ((1 + ((tf2/100)/m2)),(m2/m)) - 1;
							    tf1 = tf1*m*100;
							    tf1 = tf1*1000;
							    tf1 = Math.floor(tf1);
							    tf1 = tf1/1000;
							    resp1.setText("Respuesta: Su Tasa Efectiva #1 equivale al "+String.valueOf(tf1)+"%");
					         }
					     }    
				         if(item2.isSelected() == true)
					     {
						      	
							   tf1 = Float.parseFloat(efe1.getText());
							   if(tf1 > 100 || tf1 < 0)
							 	{
									 JOptionPane.showMessageDialog(null,"La tasa Nominal no puede ser mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
									 efe1.setText(" ");
							 	}
							 	else
					       	{
							    tf2 = Math.pow ((1 + ((tf1/100)/m)),(m/m2)) - 1; 
							    tf2 = tf2*m2*100;
							    tf2 = tf2*1000;
							    tf2 = Math.floor(tf2);
							    tf2 = tf2/1000;

							    resp1.setText("Respuesta: Su Tasa Efectiva #2 equivale al "+String.valueOf(tf2)+"%");
					         }
				       }
		      }
		   catch(Exception ed){JOptionPane.showMessageDialog(null,"Complete correctamente los datos","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));} 
	   }
	   if(e.getSource() == calcular2)
	   {
		   try
		   {
			   if(item5.isSelected() == true)
			   {
				   te_p2 = Float.parseFloat(efem.getText());
				   if(te_p2 > 100 || te_p2 < 0)
						{
						 JOptionPane.showMessageDialog(null,"La tasa Nominal no puede ser mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
						 efem.setText(" ");
						}
						else
						{
							tn_p2 = Math.pow((1 + ((te_p2 / 100) / m3)),(m3)) * m3;
							tn_p2 = tn_p2*1000;
							tn_p2 = Math.floor(tn_p2);
						   tn_p2 = tn_p2/1000;

							resp2.setText("Respuesta: Su Tasa Nominal  equivale al "+String.valueOf(tn_p2)+"%");
					   }
			   }
			   if(item6.isSelected() == true)
			   {
				   tn_p2 = Float.parseFloat(efem2.getText());
				   if(tn_p2 > 100 || tn_p2 < 0)
						{
						 JOptionPane.showMessageDialog(null,"La tasa Nominal no puede ser mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
						 efem2.setText(" ");
						}
						else
						{  te_p2 = 1+ (tn_p2/100);
							te_p2 = Math.pow(te_p2,(1 / m3)) - 1;
							te_p2 = (te_p2*m3 )* 100;
							te_p2 = te_p2*1000;
							te_p2 = Math.floor(te_p2);
						   te_p2 = te_p2/1000;
							resp2.setText("Respuesta: Su Tasa Efectiva  equivale al "+String.valueOf(te_p2)+"%");
					   }
			   }

		   }
		   catch(Exception a){JOptionPane.showMessageDialog(null,"Complete correctamente los datos","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));}
	   }
	   
	   	   if(e.getSource() == calcular3)
	   {
		   try
			{
				if(item3.isSelected() == true)
				{
					Io = Float.parseFloat(txtIo.getText());
					
					Ir = Io *1.01388;
					Ir = Ir*1000;
					Ir = Math.floor(Ir);
					Ir = Ir/1000;

					lblresp.setText("Su Interés Real equivale a C$ "+Ir+" del Interés Comercial."); 
				}
				if(item4.isSelected() == true)
				{
					Ir = Float.parseFloat(txtIr.getText());
					Io = Ir*0.9863;
					Io = Io*1000;
					Io = Math.floor(Io);
					Io = Io/1000;
					lblresp.setText("Su Interés Ordinario equivale a C$ "+Io+" del Interés Real.");
				}
			}
		   catch(Exception ab){JOptionPane.showMessageDialog(null,"Complete correctamente los datos","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));}
	   }
    }
	
	public void construir_frame()
	{
		setTitle("     § Relaciones entre Tasas    ");
		setFrameIcon(new javax.swing.ImageIcon("Imagenes/dolar.gif"));
		setResizable(true);
		setSize(720,275);
		setLayout(null);
		//setLocation(130,130);
		grupo.add(item1);
		grupo.add(item2);
		tasa1.add(item1);
		tasa1.add(item2);
		
      grupo3.add(item3);
      grupo3.add(item4);
      tasa3.add(item3);
      tasa3.add(item4);
      
      grupo2.add(item5);
		grupo2.add(item6);
		tasa2.add(item5);
		tasa2.add(item6);
      
      setJMenuBar(barra);
      barra.add(tasa1);
      barra.add(tasa2);
      barra.add(tasa3);
      p_tablas.setLayout(null);
      getContentPane().add(p_tablas);
      p_tablas.add(cancelar);
      construir_P1();
		construir_P2();
		construir_P3();
		construir_panel_tabla();
		p.setBackground(new java.awt.Color(204,204,255));
		p2.setBackground(new java.awt.Color(204,204,255));
		p3.setBackground(new java.awt.Color(204,204,255));
		p_tablas.setBackground(new java.awt.Color(204,204,255));



	  tabla.addTab("Tasas Equivalentes",p);
	  tabla.addTab("Tasa Efectiva-Nominal",p2);
	  tabla.addTab("Tasa Real-Comercial",p3);
	  tabla.setSize(550,200);
	  p_tablas.add(tabla);
	  p_tablas.setBounds(0,0,720,900);
	  
	  
	  		txtIo.addKeyListener(new KeyAdapter()
   { public void keyTyped(KeyEvent e){
   
      char c = e.getKeyChar(); 
     
if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
			   e.consume();			   

	}});
	        txtIr.addKeyListener(new KeyAdapter()
   { public void keyTyped(KeyEvent e){
   
      char c = e.getKeyChar(); 
     
if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
			   e.consume();			   

	}});
	        efem.addKeyListener(new KeyAdapter()
   { public void keyTyped(KeyEvent e){
   
      char c = e.getKeyChar(); 
     
if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
			   e.consume();			   

	}});
	        efem2.addKeyListener(new KeyAdapter()
   { public void keyTyped(KeyEvent e){
   
      char c = e.getKeyChar(); 
     
if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
			   e.consume();			   

	}});
	        efe1.addKeyListener(new KeyAdapter()
   { public void keyTyped(KeyEvent e){
   
      char c = e.getKeyChar(); 
     
if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
			   e.consume();			   

	}});
	
	        efe2.addKeyListener(new KeyAdapter()
   { public void keyTyped(KeyEvent e){
   
      char c = e.getKeyChar(); 
     
if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
			   e.consume();			   

	}});
	  
		setVisible(true); 
	}
	public void construir_P1()
	{
		p.setLayout(null);
		getContentPane().add(p);
		p.setSize(600,900);
		p.add(efec1);    efec1.setBounds(10,20,120,20);
		p.add(efe1);     efe1.setBounds(130,20,100,20);
		p.add(efec2);    efec2.setBounds(260,20,120,20);
		p.add(efe2);     efe2.setBounds(380,20,100,20);
		p.add(lcap);      lcap.setBounds(10,50,100,20);
		p.add(capita);   capita.setBounds(130,50,100,20);
		p.add(lcap1);     lcap1.setBounds(260,50,100,20);
		p.add(capita2);  capita2.setBounds(380,50,100,20);
		
		efe1.setEditable(false);
		efe2.setEditable(false);
		capita.setEnabled(false);
		capita2.setEnabled(false);
		
		p.add(resp1);     resp1.setBounds(10,120,400,20);
		p.add(calcular); calcular.setBounds(240,90,110,20);
		p.add(limpiar2);  limpiar2.setBounds(380,90,110,20);
	}
	public void construir_P2()
	{
		p2.setLayout(null);
		getContentPane().add(p2);
		p2.setSize(600,900);
		p2.add(hefec);     hefec.setBounds(10,20,120,20);
		p2.add(efem);      efem.setBounds(120,20,100,20);
		p2.add(nomi);      nomi.setBounds(10,50,120,20);
		p2.add(efem2);     efem2.setBounds(120,50,100,20);
		p2.add(rh);        rh.setBounds(10,80,100,20);
		p2.add(capi2);     capi2.setBounds(120,80,100,20);
		
		efem.setEditable(false);
		efem2.setEditable(false);
		capi2.setEnabled(false);
		
		p2.add(resp2);         resp2.setBounds(10,110,400,20);
		p2.add(calcular2);  calcular2.setBounds(240,20,110,20);
		p2.add(limpiar);   limpiar.setBounds(240,50,110,20);
	}
	public void construir_P3()
	{
		p3.setLayout(null);
		getContentPane().add(p3);
		p3.setSize(600,900);
		p3.add(lblIo);
      p3.add(lblIr);
      p3.add(txtIo);
      p3.add(txtIr);
      p3.add(lblresp);
      p3.add(calcular3);
      p3.add(limpiar3);
      grupo3.add(comercial);
      grupo3.add(real);
      
      txtIo.setEditable(false);
      txtIr.setEditable(false);
     
      lblIr.setBounds(20,20,150,20);			txtIr.setBounds(175,20,100,20);
      lblIo.setBounds(20,50,150,20);			txtIo.setBounds(175,50,100,20);
      lblresp.setBounds(20,80,400,20);		
           
      limpiar3.setBounds(290,20,110,20);
      calcular3.setBounds(290,50,110,20);

	}
		public void construir_panel_tabla()
	{
		p_tablas.add(tabla);
		tabla.setBounds(20,10,400,900);
		p_tablas.add(cancelar);
	  cancelar.setBounds(590,70,110,20);		
	}
	public static void main(String[]Args)
	{Relaciones e = new Relaciones();}
}

	
