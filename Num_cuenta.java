import java.io.*;
import java.lang.*;
import java.util.*;


public class Num_cuenta 
{  

public static String num = null,r = null;
public static int contador = 0; 
static int dia = 0, mes = 0, año = 0;
static Date objeto = new Date();


public static String Cadena(int x)
{ 
   String t =null;
   dia = objeto.getDate();
   mes = objeto.getMonth() + 1;
   año = objeto.getYear() + 1900;

	    
	     if(x >= 100 && x < 1000)
     	 { 
	     t = "001 - "+String.valueOf(dia)+String.valueOf(mes)+String.valueOf(año)+" - 645770 - "+String.valueOf(x);
		 }//1000
		 else
		 {
		 	t =String.valueOf(x);
		 }
		 
	  if(x >= 10 && x < 100)
	   {  
	     t = "001 - " +String.valueOf(dia)+String.valueOf(mes)+String.valueOf(año)+" - 645770 - 0"+String.valueOf(x);
		
		}//100 
		 
	
		if(x>= 0 && x < 10)
	   {
	   	t = "001 - "+String.valueOf(dia)+String.valueOf(mes)+String.valueOf(año)+" - 645770 - 00"+String.valueOf(x);
	   	
	   	
	   }//10
       
  		
	      
   return t;
}
 	

public static void main(String []args)
{
	
	do
	{
	
		System.out.print("Digite el contador : ");
		contador = Leer.datoInt();
		System.out.println();
		
		
		if(contador > 100000)
		{
			System.out.println("El contador no debe ser mayor que 100,000");
			System.out.println("¿Salir? s / n");
			r =Leer.dato();
		}
		 else
		 {
		 System.out.println(Cadena(contador));
		 System.out.println("¿Salir? s / n");
		 r =Leer.dato();	
		 }
	}while(r != "s");
		
}

}