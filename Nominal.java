import javax.swing.*;
import java.applet.Applet;
import javax.swing.event.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;

public class Nominal extends JInternalFrame implements ActionListener
{
	private JMenuBar Barra = new JMenuBar();
	private JMenu incognita = new JMenu("Su incógnita >>");
	private JLabel lblV = new JLabel("Valor Futuro ( C$ ):");
	private JLabel lblC = new JLabel("Presente ( C$ ):");
	private JLabel lblT = new JLabel("Tasa nominal ( % ) :");
	private JLabel lcap = new JLabel("Capitalizable");
	private JLabel lblP = new JLabel("Período de Tiempo en:");
	private JLabel laño = new JLabel("Años:");
	private JLabel lmes = new JLabel("Meses:");
	private JLabel ldia = new JLabel("Días:");
	private JLabel lblR = new JLabel();
	
	
	public JTextField txtv = new JTextField();
	public JTextField txtc = new JTextField();
	public JTextField ttasa = new JTextField();
	public JTextField taño = new JTextField();
	public JTextField tmes = new JTextField();
	public JTextField tdia = new JTextField();
	
	String[] lista = { "","Semestral","Mensual","Cuatrimestral","Trimestral","Bimensual" };
	private JComboBox C = new JComboBox(lista);
	
	private JRadioButtonMenuItem valor = new JRadioButtonMenuItem("Valor Futuro",true);
	private JRadioButtonMenuItem capital = new JRadioButtonMenuItem("Presente",false);
	private JRadioButtonMenuItem tasa = new JRadioButtonMenuItem("Tasa",false);
	private JRadioButtonMenuItem periodo = new JRadioButtonMenuItem("Período",false);
	
	private ButtonGroup grupo = new ButtonGroup();
	
	static JButton calcular = new JButton("Calcular",new ImageIcon("Imagenes/calcular.GIF"));
	private JButton cancelar = new JButton("Cancelar",new ImageIcon("Imagenes/cancelar.GIF"));
	private JButton limpiar = new JButton("Limpiar",new ImageIcon("Imagenes/limpiar.GIF"));
	
	private JPanel p1 = new JPanel();
	
	double val, cap, tas, n , year, month, day;
	double dia1,dia2,mes1,cant1;
	static int op;
	double m1;
	int m;
	
	public Nominal()
	{
		construir();	
		cancelar.addActionListener(new cancelar_class());
		limpiar.addActionListener(new limpiar_class());	
		C.addActionListener(new lista_class());	
		
		valor.addActionListener(this);
		capital.addActionListener(this);
		tasa.addActionListener(this);
		periodo.addActionListener(this);
		calcular.addActionListener(this);
	}

	public void construir()
	{
		setTitle("  § Interés Compuesto - Tasa Nominal ");
		setFrameIcon(new javax.swing.ImageIcon("Imagenes/dolar.GIF"));
		p1.setLayout(null);
		setSize(550,300);
		setLocation(155,155);
		setResizable(false); 
		getContentPane().add(p1);
		p1.setSize(550,300);
		p1.setLayout(null);
		p1.setBackground(new java.awt.Color(153,153,255));

		
		incognita.add(valor);
		incognita.add(capital);
		incognita.add(tasa);
		incognita.add(periodo);
		setJMenuBar(Barra);
		
		setJMenuBar(Barra);
		Barra.add(incognita);
		
		p1.add(lblV);
		p1.add(lblT);                     
		p1.add(txtv);                      p1.add(lblC);
		p1.add(txtc);                      p1.add(lblP);
		p1.add(tmes);                      p1.add(ttasa);
		p1.add(tdia);                      p1.add(C);	              
		p1.add(ldia);                      p1.add(lmes);
		p1.add(taño);        				  p1.add(C);							  
		p1.add(lcap);                      p1.add(limpiar);
		p1.add(laño);                      p1.add(limpiar);  p1.add(cancelar);   p1.add(calcular);
		p1.add(lblR);
		
		grupo.add(valor);
		grupo.add(capital);
		grupo.add(tasa);
		grupo.add(periodo);
		
		lblV.setBounds(20,20,110,20);  txtv.setBounds(130,20,100,20);
		lblC.setBounds(20,50,110,20);  txtc.setBounds(130,50,100,20);
		lblT.setBounds(20,80,110,20);  ttasa.setBounds(130,80,100,20);
		lcap.setBounds(20,110,100,20); C.setBounds(130,110,100,20);
		lblP.setBounds(180,140,150,20);
		laño.setBounds(20,170,50,20);  taño.setBounds(80,170,80,20);
		lmes.setBounds(170,170,50,20); tmes.setBounds(240,170,80,20);
		ldia.setBounds(330,170,50,20); tdia.setBounds(390,170,80,20);
		lblR.setBounds(20,200,400,20);
		
		cancelar.setBounds(360,30,110,20);
		limpiar.setBounds(360,60,110,20);
		calcular.setBounds(360,90,110,20);
		
		txtc.setEditable(false);
		ttasa.setEditable(false);
		txtv.setEditable(false);
		taño.setEditable(false);
		tdia.setEditable(false);
		tmes.setEditable(false);
		C.setEnabled(false);
	
		 txtv.addKeyListener(new KeyAdapter()
		  { public void keyTyped(KeyEvent e){
		  
		     char c = e.getKeyChar(); 
		    
		if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
				   e.consume();			   
		
		}});
		
		  txtc.addKeyListener(new KeyAdapter()
		   { public void keyTyped(KeyEvent e){
		   
		      char c = e.getKeyChar(); 
		     
		if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
					   e.consume();			   
		
			}});
			
		  ttasa.addKeyListener(new KeyAdapter()
		   { public void keyTyped(KeyEvent e){
		   
		      char c = e.getKeyChar(); 
		     
		if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
					   e.consume();			   
		
			}});
			
		  taño.addKeyListener(new KeyAdapter()
		   { public void keyTyped(KeyEvent e){
		   
		      char c = e.getKeyChar(); 
		     
		if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))) 
					   e.consume();			   
		
			}});
			
			  tmes.addKeyListener(new KeyAdapter()
		   { public void keyTyped(KeyEvent e){
		   
		      char c = e.getKeyChar(); 
		     
		if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))) 
					   e.consume();			   
		
			}});
		
		  tdia.addKeyListener(new KeyAdapter()
		   { public void keyTyped(KeyEvent e){
		   
		      char c = e.getKeyChar(); 
		     
		if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE))) 
					   e.consume();			   
		
			}});
	
	
		 
		setVisible(true);
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
			txtv.setText(" ");
			txtc.setText(" ");
			ttasa.setText(" ");
			taño.setText(" ");
			tmes.setText(" ");
			tdia.setText(" ");
				 
			val = 0; cap = 0; tas = 0; n = 0;
	        year = 0; month = 0; day = 0; m = 0;
				 
			lblR.setText(" ");		 		 
		}
	}
	class lista_class implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox C = (JComboBox)e.getSource();
			op = (int)C.getSelectedIndex();
			
			if(op == 0)
			{
				JOptionPane.showMessageDialog(null,"Elija una opción válida.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
				System.out.println("Error");
			}
			if(op == 1)
			{
				m = 2;
				System.out.println(m);
			}
			if(op == 2)
			{
				m = 12;
				System.out.println(m);
			}
			if(op == 3)
			{
				m = 3;
				System.out.println(m);
			}
			if(op == 4)
			{
				m = 4;
				System.out.println(m);
			}
			if(op == 5)
			{
				m = 6;
				System.out.println(m);
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == valor)
		{
			txtc.setEditable(true);
			txtv.setEditable(false);
			ttasa.setEditable(true);
			taño.setEditable(true);
			tmes.setEditable(false);
			tdia.setEditable(false);
			C.setSelectedIndex(0);
			C.setEnabled(true);
			
		}
		if(e.getSource() == tasa)
		{
			txtc.setEditable(true);
			txtv.setEditable(true);
			ttasa.setEditable(false);
			taño.setEditable(true);
			tmes.setEditable(false);
			tdia.setEditable(false);
			C.setSelectedIndex(0);
			C.setEnabled(true);

		}
		if(e.getSource() == capital)
		{
			txtc.setEditable(false);
			txtv.setEditable(true);
			ttasa.setEditable(true);
			taño.setEditable(true);
			tmes.setEditable(false);
			tdia.setEditable(false);
			C.setSelectedIndex(0);
			C.setEnabled(true);

		}
		
		if(e.getSource() == periodo)
		{
			txtc.setEditable(true);
			txtv.setEditable(true);
			ttasa.setEditable(true);
			taño.setEditable(false);
			tmes.setEditable(false);
			tdia.setEditable(false);
			C.setSelectedIndex(0);
			C.setEnabled(true);

		}
		if(e.getSource() == calcular)
		{			
			try
			{
				if(valor.isSelected() == true)
				{
					cap = Float.parseFloat(txtc.getText());
					tas = Float.parseFloat(ttasa.getText());
                    year = Float.parseFloat(taño.getText());
            
               if(tas > 100 || tas < 0)
				 	{
						 JOptionPane.showMessageDialog(null,"La Tasa Nominal no puede ser  mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
						 ttasa.setText(" ");
				 	}
				 	else
		       	{
				    tas = tas / 100;
	                n = year;
	                val = round(cap * (Math.pow((1 + (tas / m)),(n * m))));
	                System.out.println(val);
	                lblR.setText("Respuesta: Su valor futuro será de C$"+String.valueOf(val));
               }
             
				}
				if(capital.isSelected() == true)
				{
					val = Float.parseFloat(txtv.getText());
					tas = Float.parseFloat(ttasa.getText());
                    year = Float.parseFloat(taño.getText());
               
               if(tas > 100 || tas < 0)
				 	{
						 JOptionPane.showMessageDialog(null,"La Tasa Nominal no puede ser  mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
						 ttasa.setText(" ");
				 	}
				 	else
		       	{
				     tas = tas / 100;  
				     n = year;
				     cap = round(val /(Math.pow((1 + (tas / m)),(n * m)))); 
				     lblR.setText("Respuesta: Su valor capital es de C$"+String.valueOf(cap)); 
		         }
				}
				if(tasa.isSelected() == true)
				{
					val = Float.parseFloat(txtv.getText());
					cap = Float.parseFloat(txtc.getText());
                    year = Float.parseFloat(taño.getText());
               
               
                  if(cap > val)
			       {
						 JOptionPane.showMessageDialog(null,"El capital no puede ser mayor que el valor futuro.\n","Error en la lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
						 txtc.setText(" ");
						 txtv.setText(" ");					 
			       }
 
                  else
                  { 
	               n = year;
	               tas = round(((Math.pow((val / cap),(1 /(n * m))) - 1)) * m)*100;
				   lblR.setText("Respuesta: Su Tasa Nominal es de "+String.valueOf(tas)+"%");
				  }
				 
				}
				if(periodo.isSelected() == true)
				{
					val = Float.parseFloat(txtv.getText());
					cap = Float.parseFloat(txtc.getText());
					tas = Float.parseFloat(ttasa.getText());
					
					 if(cap > val)
			    {
						 JOptionPane.showMessageDialog(null,"El capital no puede ser mayor que el valor futuro.\n","Error en la lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
						 txtc.setText(" ");
						 txtv.setText(" ");					 
			    }
 
              else
              { 
							if(tas > 100 || tas < 0)
						 	{
								 JOptionPane.showMessageDialog(null,"La Tasa Nominal no puede ser  mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
								 ttasa.setText(" ");
						 	}
						 	else
				       	{   tas = tas / 100;
						       m1 = m;
						       n =Math.log(val / cap) / (m1 * Math.log((1 + (tas / m1))));
						       System.out.println(n);
						       
									cant1 = n*1000;
									cant1 = Math.floor(cant1);
									dia1 = cant1%10;
									dia1 = dia1*0.36;
									
									dia2 = n*100;
									dia2 = Math.floor(dia2);
									dia2 = dia2%10;
									dia2 = dia2*3.6;
									
									mes1 = n*10;
									mes1 = Math.floor(mes1);
									mes1 = mes1%10;
									
									day = Math.floor(dia1 + dia2);
									month = Math.floor((mes1*3.6)/3);
									year = Math.floor(n);
									
									taño.setText(String.valueOf(year));
									tmes.setText(String.valueOf(month));
									tdia.setText(String.valueOf(day));
					     }
				      
				       
		       }

			   }				
			}
			catch(Exception error)
			{
			   JOptionPane.showMessageDialog(null,"Complete todos los datos.","Error de Lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
				System.out.println("Error");

			}			
		}
	}
	
public static Double round(double num)
    {
	   double cantidad_redondeada=num;
	 
	   cantidad_redondeada = cantidad_redondeada*100; 
	   cantidad_redondeada = Math.floor(cantidad_redondeada);
	  if(cantidad_redondeada%10 > 5)
	  {
		  cantidad_redondeada+=1;
	  }
	   
	  cantidad_redondeada = cantidad_redondeada/100;
	  
	  return cantidad_redondeada;
	  
   } 	
}
