import javax.swing.*;
import java.applet.Applet;
import javax.swing.event.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;

public class inicio extends JFrame
{
  private JLabel imag = new JLabel(new ImageIcon("mortal.GIF"));
  private JLabel imag1 = new JLabel(new ImageIcon("tasa.GIF"));
  private JLabel v = new JLabel(new ImageIcon("v.GIF"));private JLabel i = new JLabel(new ImageIcon("i.GIF"));private JLabel r = new JLabel(new ImageIcon("r.GIF"));private JLabel u = new JLabel(new ImageIcon("u.GIF"));private JLabel s = new JLabel(new ImageIcon("s.GIF"));
  private JLabel f = new JLabel(new ImageIcon("f.GIF"));private JLabel i2 = new JLabel(new ImageIcon("i.GIF"));private JLabel n = new JLabel(new ImageIcon("n.GIF"));private JLabel a = new JLabel(new ImageIcon("a.GIF"));private JLabel n2 = new JLabel(new ImageIcon("n.GIF"));
  private JLabel c = new JLabel(new ImageIcon("c.GIF"));private JLabel e = new JLabel(new ImageIcon("e.GIF"));private JLabel r2 = new JLabel(new ImageIcon("r.GIF"));
  private JLabel login = new JLabel("Usuario:");
  private JLabel pwd = new JLabel("Contraseña:");
  private JTextField txtlogin = new JTextField(25);
  private JPasswordField txtpwd = new JPasswordField(10);
  private JButton got = new JButton("Aceptar",new ImageIcon("Next.GIF")); 
  private JButton Terminar = new JButton("Terminar",new ImageIcon("cancelar.GIF"));
  private JPanel Elvin = new JPanel();
  private Color C = new Color(0,0,0);
  String contra1 = "virus";
  String contra2 = "neron"; 
  String contra3 = "laberinto";
  
   String usu1 = "Roberto";
   String usu2 = "Marcos";
   String usu3 = "Elvin";
   public String input;
   public String input2;
   
  int fin = 0;
  public inicio()
  {  
	  super("  §§§   Bienvenidos a  VirusFinancer...");
	  /*try {
           javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    	    } 
	   catch (Exception e) {}*/
	  resize(1025,735);
	  Elvin.setLayout(null);
	  getContentPane().add(Elvin);
	  Elvin.setBounds(0,0,1025,735);
	  Elvin.setBackground(C);
	  setLocation(0,0);
	  Elvin.add(login);login.setBounds(370,440,90,20); login.setForeground(new java.awt.Color(51,51, 255));
	  Elvin.add(got);
	  Elvin.add(txtlogin);txtlogin.setBounds(460,440,100,20);
	  Elvin.add(pwd);pwd.setBounds(370,490,90,20);  pwd.setForeground(new java.awt.Color(51,51,255));

	  Elvin.add(txtpwd);txtpwd.setBounds(460,490,100,20);
	  
	  Elvin.add(Terminar);Terminar.setBounds(420,575,120,20);got.setBounds(420,530,120,20);
	  
	  Elvin.add(v); v.setBounds(250,100,100,60);
	  Elvin.add(i); i.setBounds(350,100,100,60);
	  Elvin.add(r); r.setBounds(450,100,100,60);
	  Elvin.add(u); u.setBounds(550,100,100,60);
	  Elvin.add(s); s.setBounds(650,100,100,60);
	  Elvin.add(f); f.setBounds(100,220,100,60);
	  Elvin.add(i2); i2.setBounds(200,220,100,60);
	  Elvin.add(n); n.setBounds(300,220,100,60);
	  Elvin.add(a); a.setBounds(400,220,100,60);
	  Elvin.add(n2); n2.setBounds(500,220,100,60);
	  Elvin.add(c); c.setBounds(600,220,100,60);
	  Elvin.add(e); e.setBounds(700,220,100,60);
	  Elvin.add(r2); r2.setBounds(800,220,100,60);
	  Elvin.add(imag); imag.setBounds(310,330,320,300);
	  Elvin.add(imag1); imag1.setBounds(100,-30,120,200);
  	  
	  got.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e)
		  {
			  
			  input = new String(txtpwd.getPassword());
			  input2 = new String(txtlogin.getText());
			  fin++;
			  if(fin == 4)
			  {
				  JOptionPane.showMessageDialog(null,"Sus oportunidades han consumido los recursos de memoria,\nel sistema se cerrara automaticamente\ngracias por preferir Virus Financer 1.0.0.0.1","Error",JOptionPane.WARNING_MESSAGE); 
			  	  hide();
				  dispose();				    
				  System.exit(0);
			  }
			  else
			  {
				  if((contra1.equals(input) && usu1.equals(input2)) ||(contra2.equals(input) && usu2.equals(input2) || (contra3.equals(input) && usu3.equals(input2))) )
				  {
					  Nigthwish mother = new Nigthwish();
					  hide();
					  dispose();							  
				   }
			      else
			      {
			  		  txtlogin.setText(" ");
			 		  txtpwd.setText(" ");
					  input = null;
					  input2 = null;
					   
			  		  JOptionPane.showMessageDialog(null,"Contraseña incorrecta!!!!!!!\nDigite la verdadera contraseña\nLe restan  "+(4-fin)+"   oportunidades para escribir correctamente\ncualquiera de las tres contraseñas del programa ","Error",JOptionPane.WARNING_MESSAGE);
			      }				  
			  }
		  }
		});
		
			   Terminar.addMouseListener(new MouseAdapter()
		{

			public void mousePressed(MouseEvent e)
			{
				System.exit(0);
			}
		});
			 
	  show(); }//fin del constructor
	  
	  
	  public static void main(String[]args)
	  {
		  //Instanciando la clase Inicio
		  /**try{
			UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
			}catch(Exception e){e.printStackTrace();}*/

		  inicio Ini = new inicio();

		 }// Fin del main
		 
		 
     public boolean handleEvent(Event e)
     {
	    if(e.id == Event.WINDOW_DESTROY)
		  {
		   hide();
		   dispose();
		   System.exit(0);
		   return true;
			  }
		  return super.handleEvent(e);
     }//Fin del hanleEvent
			
}
									