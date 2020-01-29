import java.io.*;

class  Record {

private float depo,reti,sal;
private String fecha;
private double tasa;

public Record (String fecha, float deposito, float retiro, double tasa, float sal)
{
     fecha = fecha;
     depo = deposito;
     reti = retiro;
     tasa = tasa;
     sal = sal;  

}

public Record()
{

}

public void read(RandomAccessFile file) throws IOException
{
   fecha = file.readUTF();
   depo =file.readFloat();
   reti = file.readFloat(); 
   sal = file.readFloat();
   tasa = file.readDouble();
}
       
public void write(RandomAccessFile file) throws IOException
{ 
  file.writeChars(fecha);
  file.writeFloat(depo);
  file.writeFloat(reti);
  file.writeDouble(tasa);
  file.writeFloat(sal);  
  
  System.out.println(fecha + depo + reti+ tasa + sal);
   
  
}
public String getfecha(){return fecha;}
public float getdepo(){return depo;}
public float getreti(){return reti;}
public double gettasa(){return tasa;}
public double getsal(){return sal;}
public int size(){return 46;}

}   