import java.io.*;
import java.lang.*;
import java.util.*;

public class Fechas_Pago
{
static	Date Objeto = new Date();

	 
static int dia_inic, mes_inic, año_inic, cant_mes,m,cant_año,num_pago;
static int[] meses_acu = new int[500];
static int[] años_acu = new int[500];
 
 static double r;
public static String mes_string(int x)
{ 
 String cadena =null;
 
 switch(x)
 {
	case 1:
   {
	   cadena = "Enero";
	   break;
	}
	case 2:
   {
	   cadena = "Febrero";
	   break;
	}
   case 3:
   {
	   cadena = "Marzo";
	   break;
	}
   case 4:
   {
	   cadena = "Abril";
	   break;
	}
	case 5:
   {
	   cadena = "Mayo";
	   break;
	}
	case 6:
   {
	   cadena = "Junio";
	   break;
	}
   case 7:
   {
	   cadena = "Julio";
	   break;
	}
   case 8:
   {
	   cadena = "Agosto";
	   break;
	}
   case 9:
   {
	   cadena = "Septiembre";
	   break;
	}
	case 10:
   {
	   cadena = "Octubre";
	   break;
	}
	case 11:
   {
	   cadena = "Noviembre";
	   break;
	}
   case 12:
   {
	   cadena = "Diciembre";
	   break;
	}

 }return cadena;
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
public static int dia_retornado(int dia,int mes,int año)	//dia
{
	int day=0;
	
	
	if(dia == 29 || dia == 30 || dia == 31)
	{
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
	}	
	else
	{
		day = dia;
	}
	return day;
}
	
  

public static int mes_retornado(int i, int meses_acu, int m)
{
	int month=0;
	int month1=0;

	 	month= meses_acu + i*m; 
	    month1 = month - (month/12)*(12);
	    month = month1;
	    if(month <=0)
	    {
	    	month*=(-1);
	    	month = 12;
	    }

	
	return month;
}    

public static int año_retornado(int meses_acu, int años_acu, int m, int i)
{ 
    int year=0;
	    
	    
	year = años_acu + ((meses_acu + i*m)/12);
	
	return year; 
}


  public static void main(String []args) 
  { 
    dia_inic = Objeto.getDate();
    mes_inic = Objeto.getMonth() + 1;
    año_inic = Objeto.getYear() + 1900;
    meses_acu[0] = 0;
    años_acu[0] = 0;
    
    System.out.println("Cantidad: ");
    r=Leer.datoDouble();
    r=round(r);
    System.out.println();
    System.out.println(r);
        do
     {
    
    System.out.println("Fecha Inicial: "+dia_inic+" / "+mes_inic+" / "+año_inic);
    System.out.println();
  	
  System.out.println("1. Mesual");
  System.out.println("2. Bimensual");
  System.out.println("3. Trimestral");
  System.out.println("4. Cuatrimestral");
  System.out.println("5. Semestral");
  System.out.println("6. Anual");
  System.out.println("7. Salir");
  System.out.println();
  
  System.out.print("Digite cada cuanto es capitalizable: ");
  System.out.println();
  cant_mes = Leer.datoInt();
  
  switch(cant_mes)
  {
  	case 1:
  	{
  		m=1;
  		break;
  	}
  	
  	case 2:
  	{
  		m=2;
  		break;
  	}
  	
  	case 3:
  	{
  		m=3;
  		break;
  	}
  	
  	case 4:
  	{
  		m=4;
  		break;
  	}
  	
  	case 5:
  	{
  		m=6;
  		break;
  	}
  	
  	case 6:
  	{
  		m=12;
  		break;
  	}
  	case 7:
  	{
  		
  	}
  	
  }

  	System.out.println();
  	
  	System.out.println("Cuantos años es el prestamo:");
  	cant_año = Leer.datoInt();
  	num_pago = (cant_año*12)/m;
  	System.out.println("Numeros de pagos: "+num_pago);
  	
  	for(int i=1;i<=num_pago;i++)
  	{       
  			meses_acu[0] = mes_inic;
  			años_acu[0] =  año_inic;
  		
  		    //años_acu[i] =  años_acu[i];
  			System.out.println("Fecha de Pago #"+i+": "+dia_retornado(dia_inic,mes_retornado(i,meses_acu[0],m),año_retornado(meses_acu[0], años_acu[0], m, i))+" / "+mes_retornado(i,meses_acu[0],m)+" / "+año_retornado(meses_acu[0], años_acu[0], m, i));
  			meses_acu[i] = meses_acu[0]+ i*m;
			años_acu[i] = años_acu[0] + (meses_acu[i]/12);
  	
  	}
  	}
  	while(cant_mes !=7);
  } 
		
}