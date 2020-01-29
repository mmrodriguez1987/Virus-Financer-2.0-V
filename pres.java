import java.awt.*;
import java.awt.event.*;

public class pres extends Frame
{
	public pres()
	{
		this.addWindowListener	(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				dispose();
				System.exit(0);
			}
		});
	}
	
	public static void main(String args[])
	{
		System.out.println("Starting App");
		pres f = new pres();
		f.setSize(100,100);
		f.show();
	}
}