package busquedas;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*; 

public class Busquedas{
    public static String buscar(Persona a[],String nombre){
        Persona p=new Persona(0,nombre,"",0);   
        int inicio = 0;
        int fin = a.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( a[pos].esIgual(p)==true ){
                return a[pos].to()+"\n"+"Se encuentra en la posición: "+(pos+1);
            }
            else 
            if ( a[pos].esMenor(p)==true ) {
                inicio = pos+1;
            } else {
                fin = pos-1;
            }
        }
        return "No se encontro la persona buscada";
    }

    public static void buscarBin( Persona [] arreglo, int dato) {
        int inicio = 0;
        int fin = arreglo.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( arreglo[pos].getClave() == dato ){
                JOptionPane.showMessageDialog(null,arreglo[pos].to()+"\n"+"Se encuentra en la posición: "+(pos+1));
                return;
            }else 
            if ( arreglo[pos].getClave() < dato ) {
                inicio = pos+1;
            } 
            else {
                fin = pos-1;
            }
        }
        JOptionPane.showMessageDialog(null,"No se encontro a la persona");
    }

    public static String busLiNom(String nombre,String link){
        int i;
        Persona p;
        try{

            File fichero=new File(link);
            FileInputStream fis=new FileInputStream(fichero);
            ObjectInputStream leer=new ObjectInputStream(fis);
            for (i=0;i<200;i++) {         
                p=(Persona)leer.readObject();
                if (p.getNombre().equalsIgnoreCase(nombre)){
                    return p.to();
                }
            }
            leer.close();
        }
        catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());}
        return "Persona no encontrada";
    }

    public static void buLiCla(int dato,String link){
        int i;
        Persona p;
        try{
            File fichero=new File(link);
            FileInputStream fis=new FileInputStream(fichero);
            ObjectInputStream leer=new ObjectInputStream(fis);
            for (i=0;i<200;i++) {         
                p=(Persona)leer.readObject();
                if (p.getClave()==dato){
                    JOptionPane.showMessageDialog(null,p.to());
                    return;
                }
            }
            leer.close();
        }
        catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());}
        JOptionPane.showMessageDialog(null,"Persona no encontrada");
    }

}
