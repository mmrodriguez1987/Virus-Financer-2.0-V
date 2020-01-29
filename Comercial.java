import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Comercial extends JInternalFrame implements ActionListener
{
    private JMenuBar barra = new JMenuBar();
    private JMenu incognita = new JMenu("Su incógnita >>");
    private JLabel lblI = new JLabel("Interés ( C$ ): ");
    private JLabel lblC = new JLabel("Capital ( C$ ):");
    private JLabel lblP = new JLabel("Porcentaje ( % ):");
    private JLabel lblT = new JLabel("Tiempo (en días):");
    public JLabel lblR = new JLabel();

    public JTextField txti = new JTextField();
    public JTextField txtc = new JTextField();
    public JTextField txtp = new JTextField();
    public JTextField txtt = new JTextField();
       
    private JRadioButtonMenuItem interes= new JRadioButtonMenuItem("Interés",false);
    private JRadioButtonMenuItem capital= new JRadioButtonMenuItem("Capital",true);
    private JRadioButtonMenuItem porcentaje= new JRadioButtonMenuItem("Porcentaje",false);
    private JRadioButtonMenuItem tiempo= new JRadioButtonMenuItem("Tiempo",false);

	 private ButtonGroup grupo = new ButtonGroup();

    private JButton calcular = new JButton("Calcular",new ImageIcon("Imagenes/calcular.GIF"));
    private JButton cancelar = new JButton("Cancelar",new ImageIcon("Imagenes/cancelar.GIF"));
    private JButton limpiar = new JButton("Limpiar",new ImageIcon("Imagenes/limpiar.GIF"));

    private JPanel P1 = new JPanel();
    private JPanel P2 = new JPanel();

    
    public String incog;
    int opcion1, opcion2, opcion3, opcion4;
    
    double dia, por, cap, inter;
   
    public Comercial()
    {
     iniciar();
     cancelar.addActionListener(new cancelar_class());
     limpiar.addActionListener(new limpiar_class());
     calcular.addActionListener(this);
     interes.addActionListener(this);
     porcentaje.addActionListener(this);
     capital.addActionListener(this);
     tiempo.addActionListener(this);
    } 
    
    public void iniciar()
    {
	  setTitle("    § Interés Comercial   ");
	  setFrameIcon(new javax.swing.ImageIcon("Imagenes/dolar.GIF"));
      setLayout(null);
      setSize(450,250);
      setLocation(120,120);
      setResizable(false);
      getContentPane().add(P1);
      getContentPane().add(P2);      
      P1.setBackground(new java.awt.Color(0,153,153));
      P2.setBackground(new java.awt.Color(0,153,153));

      P1.setSize(450,250);     
      
      P1.setLayout(null);
      
      P1.add(lblI);
      P1.add(lblC);
      P1.add(lblP);
      P1.add(lblT); 
      P1.add(lblR);
      
      
      grupo.add(interes);
      grupo.add(capital);
      grupo.add(porcentaje);
      grupo.add(tiempo);
      
      incognita.add(interes);
      incognita.add(capital);
      incognita.add(porcentaje);
      incognita.add(tiempo);
      setJMenuBar(barra);
      barra.add(incognita);    
      
      P1.add(txti);
      P1.add(txtp);
      P1.add(txtc);
       
      P1.add(txtt);    
           
      P1.add(calcular);
      P1.add(limpiar);
      P1.add(cancelar);
      
      //   * objetos del P1 *    //
      
      lblC.setBounds(20,20,100,20);
      lblT.setBounds(20,50,100,20);
      lblI.setBounds(20,80,100,20);
      lblP.setBounds(20,110,100,20);
      lblR.setBounds(20,140,310,20);
      
      
      txtc.setBounds(130,20,100,20);
      txtt.setBounds(130,50,100,20);
      txti.setBounds(130,80,100,20);
      txtp.setBounds(130,110,100,20);
      
      txtc.setEditable(false);
      txtt.setEditable(false);
      txti.setEditable(false);
      txtp.setEditable(false);
      
      
      cancelar.setBounds(250,30,110,20);
      limpiar.setBounds(250,60,110,20);
      calcular.setBounds(250,90,110,20);
      
 		
		 
		 
//--------------------------------------
//          Validación de datos
//--------------------------------------
      
        txti.addKeyListener(new KeyAdapter()
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

txtp.addKeyListener(new KeyAdapter()
   { public void keyTyped(KeyEvent e){
   
      char c = e.getKeyChar(); 
     
      if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.')))
        
			   e.consume();
	}});

txtt.addKeyListener(new KeyAdapter()
   { public void keyTyped(KeyEvent e){
   
      char c = e.getKeyChar(); 
     
      if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == '.')))
         
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
			 txti.setText(" ");
			 txtc.setText(" ");
			 txtp.setText(" ");
			 txtt.setText(" ");
			 
			 inter = 0;
			 por = 0;
			 cap = 0;
			 dia = 0;
			 lblR.setText(" ");		 		 
		 }
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource() == calcular)
		{
			try
			{ 
 
 if(interes.isSelected() == true)
	 {   	 
             por = Float.parseFloat(txtp.getText());
				 cap = Float.parseFloat(txtc.getText());
				 dia = Float.parseFloat(txtt.getText());
				 
			  if(por>100 || por<0)
			   {
					 JOptionPane.showMessageDialog(null,"El porcentaje no puede ser menor\ncero, ni mayor que 100.\nIngrese nuevamente sus datos.","Error de Ingreso de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
					 txtp.setText(" ");
			   }
				 else
		       {
					por = por/100;
				    dia = dia/360;
				    inter = round(cap*por*dia);				 
				    lblR.setText("Respuesta: Sus intereses son de C$ "+String.valueOf(inter));	
		       }
	 }

if(capital.isSelected() == true)
		 {			  
	      inter = Float.parseFloat(txti.getText());
			dia = Float.parseFloat(txtt.getText());
			por = Float.parseFloat(txtp.getText());
			
			if(por>100 || por<0)
				 {
				 JOptionPane.showMessageDialog(null,"El porcentaje no puede ser menor\ncero, ni mayor que 100.\nIngrese nuevamente sus datos.","Error de Ingreso de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
				 txtp.setText(" ");
				 }
				 else
		        {			
			   por = por/100;
			   dia = dia/360; 
			   cap= round(inter/(por*dia));
               lblR.setText("Respuesta: Su Capital es de C$ "+String.valueOf(cap));
                }
       }
	 
	if(porcentaje.isSelected() == true)
		 {
			  
	        inter = Float.parseFloat(txti.getText());
	        cap = Float.parseFloat(txtc.getText());
			dia = Float.parseFloat(txtt.getText());
			
						if(por>100 || por<0)
				 {
					 JOptionPane.showMessageDialog(null,"El porcentaje no puede ser menor\ncero, ni mayor que 100.\nIngrese nuevamente sus datos.","Error de Ingreso de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
					 txtp.setText(" ");
				 }
				 else
		       {
		        	dia = dia/360; 
		       	    por = round((inter/(dia*cap))*100); 
                    lblR.setText("Respuesta: Su Tasa es de "+String.valueOf(por)+"%");
               }
       }
    
    if(tiempo.isSelected() == true)
    		 { 
	      float day2,año;
	
				 inter = Float.parseFloat(txti.getText());
				 por = Float.parseFloat(txtp.getText());
				 cap =	Float.parseFloat(txtc.getText());
				 
				 	if(por>100 || por<0)
				 {
					 JOptionPane.showMessageDialog(null,"El porcentaje no puede ser menor\ncero, ni mayor que 100.\nIngrese nuevamente sus datos.","Error de Ingreso de Datos",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));
					 txtp.setText(" ");
				 }
				 else
		       {
					dia = inter/(cap*(por/100));
				    day2 = Math.round(dia)*360;
				    lblR.setText("Respuesta: Total de años: "+round(dia)+" ;  días: "+day2);
       }
       }
       }
       catch(Exception g){					 JOptionPane.showMessageDialog(null,"Complete todos los datos","Error de lectura de datos.",JOptionPane.ERROR_MESSAGE,new ImageIcon("Imagenes/help"));}
       }
       
       	if (e.getSource() == interes) {
         txti.setEditable(false); 
	      txtc.setEditable(true);
	      txtt.setEditable(true);
	      txtp.setEditable(true);

       }
	     if (e.getSource() == capital) {
         txtp.setEditable(true); 
			txtt.setEditable(true);
			txti.setEditable(true);
			txtc.setEditable(false);
		
       }
	     if (e.getSource() == porcentaje) {
         txtc.setEditable(true); 
			txtp.setEditable(false);
			txti.setEditable(true);
			txtt.setEditable(true);

      }
      if (e.getSource() == tiempo) {
		   txtc.setEditable(true); 
			txtp.setEditable(true);
			txtt.setEditable(false);
			txti.setEditable(true);
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




