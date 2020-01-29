/*
 * AExcel.java
 *
 * Created on 7 de octubre de 2005, 8:35
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */



import java.io.*;
import java.io.IOException;
import javax.swing.JOptionPane;

import jxl.write.WritableWorkbook;
import jxl.write.WritableSheet;
import jxl.write.Label;
import jxl.Workbook;
import jxl.write.WriteException;

import javax.swing.table.TableModel;

/**
 *
 * @author Marcos Michael Rodriguez Chavarria
 * Ing. Sistemas 
 * UNI - RUPAP
 */
public class AExcel {
    static WritableWorkbook  workbook = null;
    static WritableSheet sheet = null;
    static Label label = null;
      
    public static void crearExcel(String ruta,String nombreHoja,TableModel modeloTabla){
        
    try{
        workbook = Workbook.createWorkbook(new File(ruta));
        sheet = workbook.createSheet(nombreHoja,0);
        
        for(int i=0;i<modeloTabla.getRowCount();i++)
            for(int j=0;j<modeloTabla.getColumnCount();j++){
                Object x = modeloTabla.getValueAt(i,j);
                
                if(x!=null)
                    label = new Label(j,i,x.toString());
                else
                    label = new Label(j,i,"");
                
                sheet.addCell(label);                
            }

	workbook.write(); 
        workbook.close();
    }
    catch(IOException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    catch(WriteException e){
        JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }
}

