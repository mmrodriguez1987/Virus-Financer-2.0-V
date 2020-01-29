
import java.lang.*;
import java.io.*;
import java.util.*;
/*
 *
 * @utor: Marcos Michael Rodriguez Chavarria
 * Fecha: Lunes 16 de Octuble de 2006
 * Hora : 01: 09 : 02
 *
 * Descripcion: en esta clase esta almacenados todos
 * los metodos de traslacion de tiemmo de los flujo de
 * efectivo.
 *
 ***/

public  class Trasladar {
    public static Double PF(double f,double i,double año) {
        double presente = 0;
        i /=100;
        presente = (f)/(Math.pow((1 + i),año));
        
        return presente;
    }
    
    public static Double FP(double p, double i, double año) {
        double futuro = 0;
        i /= 100;
        futuro = (p)*(Math.pow((1 + i),año));
        
        return futuro;
    }
    
    public static Double AP(double p, double i, double año) {
        double anualidad = 0, num = 0, den = 0;
        i /= 100;
        
        num = (i)*(Math.pow((1 + i),año));
        den = Math.pow((1 + i),año) - 1;
        anualidad =(p)*(num/den);
        
        return anualidad;
    }
    
    
    public static Double PA(double a, double i, double año) {
        double presente = 0,num = 0,den = 0;
        i /=100;
        num = Math.pow((1 + i),año) - 1;
        den = (i)*(Math.pow((1 + i),año));
        
        presente =(a)*(num/den);
        return presente;
    }
    
    
    public static Double FA(double a, double i, double año) {
        double futuro = 0, num = 0;
        i /=100;
        num = Math.pow((1 + i),año) - 1;
        futuro = (a)*(num/i);
        
        return futuro;
    }
    
    public static Double AF(double f,double i,double año) {
        double anualidad = 0, den = 0;
        i /= 100;
        den = Math.pow((1 + i),año) - 1;
        anualidad =(f)*(den);
        
        return anualidad;
    }
    
    public static Double round(double num) {
        double cantidad_redondeada=num;
        
        cantidad_redondeada = cantidad_redondeada*100;
        cantidad_redondeada = Math.floor(cantidad_redondeada);
        if(cantidad_redondeada%10 > 5) {
            cantidad_redondeada+=1;
        }
        
        cantidad_redondeada = cantidad_redondeada/100;
        
        return cantidad_redondeada;
        
    }
}


