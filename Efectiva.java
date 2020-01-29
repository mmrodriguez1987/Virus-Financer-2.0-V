import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Efectiva extends JInternalFrame implements ActionListener
{
    private JMenuBar barra = new JMenuBar();
    private JMenu incognita = new JMenu("Su incógnita >>");
    private JLabel lblV = new JLabel("Valor Futuro ( C$ ):");
    private JLabel lblC = new JLabel("Presente ( C$ ):");
    private JLabel lblP = new JLabel("Tasa efectiva ( % ) :");
    private JLabel lblT = new JLabel("Períodos ( años ):");
    private JLabel lblR = new JLabel();
    
    public JTextField txtv = new JTextField();
    public JTextField txtc = new JTextField();
    public JTextField txttasa = new JTextField();
    public JTextField txtpe = new JTextField();
    
    private JRadioButtonMenuItem valor = new JRadioButtonMenuItem("Valor Futuro",true);
    private JRadioButtonMenuItem capital = new JRadioButtonMenuItem("Presente",false);
    private JRadioButtonMenuItem tasa = new JRadioButtonMenuItem("Tasa",false);
    private JRadioButtonMenuItem periodo = new JRadioButtonMenuItem("Períodos",false);
	 
	 
	 private ButtonGroup grupo = new ButtonGroup();

    private JButton calcular = new JButton("Calcular",new ImageIcon("Imagenes/calcular.GIF"));
    private JButton cancelar = new JButton("Cancelar",new ImageIcon("Imagenes/cancelar.GIF"));
    private JButton limpiar = new JButton("Limpiar",new ImageIcon("Imagenes/limpiar.GIF"));

    private JPanel P1 = new JPanel();
    private JPanel P2 = new JPanel();

        double tas;
        double per;
        double cap;
        double val;

   
    public Efectiva()
    {
     iniciar();  
     cancelar.addActionListener(new cancelar_class());
     limpiar.addActionListener(new limpiar_class());
     calcular.addActionListener(this);
     valor.addActionListener(this);
     tasa.addActionListener(this);
     capital.addActionListener(this);
     periodo.addActionListener(this);
    } 
    
    public void iniciar()
    {
	   setTitle("    § Interés Compuesto - Tasa Efectiva   ");
	   setFrameIcon(new javax.swing.ImageIcon("Imagenes/dolar.GIF"));
      setLayout(null);
      setSize(450,290);
      setLocation(230,150);
      setResizable(false);
      getContentPane().add(P1);
      getContentPane().add(P2);      
		P1.setBackground(new java.awt.Color(153,153,255));
		P2.setBackground(new java.awt.Color(153,153,255));

      P1.setSize(450,250);     
      
      P1.setLayout(null);
      
      P1.add(lblV);
      P1.add(lblC);
      P1.add(lblP);
      P1.add(lblT); 
      P1.add(lblR);
           
      grupo.add(valor);
      grupo.add(capital);
      grupo.add(tasa);
      grupo.add(periodo);
      
      incognita.add(valor);
      incognita.add(capital);
      incognita.add(tasa);
      incognita.add(periodo);
      setJMenuBar(barra);
      barra.add(incognita);    
      
      P1.add(txtv);
      P1.add(txtpe);
      P1.add(txtc);
      P1.add(txttasa);
                
      P1.add(calcular);
      P1.add(limpiar);
      P1.add(cancelar);
      
      //   * objetos del P1 *    //
      lblV.setBounds(20,20,120,20);
      lblC.setBounds(20,50,100,20);
      lblT.setBounds(20,80,110,20);
      lblP.setBounds(20,110,110,20);
      
      
      txtv.setBounds(140,20,100,20);
      txtc.setBounds(140,50,100,20);
      txtpe.setBounds(140,80,100,20);
      txttasa.setBounds(140,110,100,20);
      lblR.setBounds(20,140,310,20);      
      
      
      cancelar.setBounds(270,30,110,20);
      limpiar.setBounds(270,60,110,20);
      calcular.setBounds(270,90,110,20);
      
      txtv.setEditable(false);
      txtc.setEditable(false);
      txtpe.setEditable(false);
      txttasa.setEditable(false);
 		
		 
		 
		//--------------------------------------
		//          Validación de datos
		//--------------------------------------
      
        txtv.addKeyListener(new KeyAdapter()
        {
	        public void keyTyped(KeyEvent e)
	        {
		        char c = e.getKeyChar(); 
		        
		        if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
			  		e.consume();			   

			  }
		  });

		  txtc.addKeyListener(new KeyAdapter()
		  {
			  public void keyTyped(KeyEvent e)
			  {
				  char c = e.getKeyChar(); 
				   if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.'))) 
				  			   		e.consume();			   
			  }
		  });

		  txtpe.addKeyListener(new KeyAdapter()
   		  {
			  public void keyTyped(KeyEvent e)
			  {
				  char c = e.getKeyChar(); 
     
      			  if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.')))
        
			   		e.consume();
			  }
		  });



		  txttasa.addKeyListener(new KeyAdapter()
		  { 
			  public void keyTyped(KeyEvent e)
			  {
				  char c = e.getKeyChar(); 
     
      			  if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.')))
         
			   		e.consume();			   
			 
			  }
		  });
		  
		
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
			
			txtc.setText(" ");
			txtpe.setText(" ");
			txttasa.setText(" ");
			txtv.setText(" ");
						
			tas = 0;
			cap = 0;
			per = 0;
			val = 0;
			lblR.setText(" ");	
			
			txtc.setEditable(false);
			txtpe.setEditable(false);
			txttasa.setEditable(false);
			txtv.setEditable(false);
			
				 		 
		}
	}
	public void actionPerformed(ActionEvent e)
	{ 
							if (e.getSource() == capital) 
		 	{
				 txtpe.setEditable(true); 
			 	 txttasa.setEditable(true);
			 	 txtc.setEditable(false);
			 	 txtv.setEditable(true);
		 	}
			if (e.getSource() == tasa)
		   {
			   txtc.setEditable(true); 
			   txtpe.setEditable(true);
	         txttasa.setEditable(false);
	         txtv.setEditable(true);

		   }
		   if (e.getSource() == periodo) 
		   {
			   txtc.setEditable(true); 
			   txtpe.setEditable(false);
			   txttasa.setEditable(true);
			   txtv.setEditable(true);
		   }
		   if (e.getSource() == valor) 
		   {
			   txtc.setEditable(true); 
			   txtpe.setEditable(true);
			   txttasa.setEditable(true);
			   txtv.setEditable(false);
		   }	
		
		if(e.getSource() == calcular)
		{
			try
			   {
			    if(valor.isSelected() == true)
			      { 
					tas = Float.parseFloat(txttasa.getText());
				 	cap = Float.parseFloat(txtc.getText());
				 	per = Float.parseFloat(txtpe.getText());
				 	if(tas > 100 || tas < 0)
				 	{
						 JOptionPane.showMessageDialog(null,"La Tasa Efectiva no puede ser mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
						 txttasa.setText(" ");
				 	}
				 	else
		       	{
				       val = 1+(tas/100);
				       val = Math.pow(val,per);
				       val = round(val*cap); 
				      
				       System.out.println(val);
				       lblR.setText("Respuesta: Su valor futuro será de C$ "+val);
				   }
			}
			if(capital.isSelected() == true)
		 	{
					  
				   val = Float.parseFloat(txtv.getText());
				   per = Float.parseFloat(txtpe.getText());
			       tas = Float.parseFloat(txttasa.getText());
			       
			       System.out.println(val);
			       System.out.println(per);
			       System.out.println(tas);

					 if(tas > 100 || tas < 0)
				    {
					    JOptionPane.showMessageDialog(null,"La Tasa Efectiva no puede ser  mayor que el 100%.\nIngrese nuevamente sus datos.","Error de lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
					 	 txttasa.setText(" ");
				 	 }
				 	 else
		       	 {
				        cap = 1 + (tas/100);
				        cap = Math.pow(cap,per);
				        cap =  round(val / cap);
				        System.out.println(cap);
				        lblR.setText("Respuesta: Su capital es de C$ "+cap);
				    }
			}
			if(tasa.isSelected() == true)
		 	{ 
				 val = Float.parseFloat(txtv.getText());
				 cap = Float.parseFloat(txtc.getText());
				 per = Float.parseFloat(txtpe.getText());
				 if(cap > val)
				 {
					 JOptionPane.showMessageDialog(null,"El capital no puede ser mayor que el valor futuro.\n","Error de lectura  de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
					 txtc.setText(" ");
					 txtv.setText(" ");					 
				 }
				 else
				 {
					 
					tas = val/cap;
				    tas = Math.pow(tas,(1/per));
				    tas = round(tas - 1);
				    
				    System.out.println(tas);
				    lblR.setText("Respuesta: Su tasa efectiva es del "+tas+" %");
				  }
       	}
	      if(periodo.isSelected() == true)
    		{ 
			    
			    
	             val =  Float.parseFloat(txtv.getText());
				 tas = Float.parseFloat(txttasa.getText());
				 cap =	Float.parseFloat(txtc.getText());
				 if(cap > val)
				  {
					 JOptionPane.showMessageDialog(null,"El capital no puede ser mayor que el valor futuro.\n","Error en la lectura de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
					 txtc.setText(" ");
					 txtv.setText(" ");					 
				  }
				 else
				  {
					  
					 if(tas > 100 || tas < 0)
					 {
						 JOptionPane.showMessageDialog(null,"La tasa Efectiva no puede ser mayor que el 100%.\nIngrese nuevamente sus datos.","Error de Ingreso de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
						 txttasa.setText(" ");
					 }
					 else
					 {
						 per =round(Math.log((val/cap)) / Math.log((1 + (tas / 100))));   
						 lblR.setText("Respuesta: Su período es de "+per+" años"); 	
			     	 }
			     }
           }
         } 
		    catch(Exception g)
		          {
			         JOptionPane.showMessageDialog(null,"Complete  correctamente los datos","Error de lectura de datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help.gif"));
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