package busquedas;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*; 
public class Listar
{
       public static void lisH(){
        int i;
        Persona p;
        try{
            File fichero=new File("Personas.txt");
            FileInputStream fis=new FileInputStream(fichero);
            ObjectInputStream leer=new ObjectInputStream(fis);
            for (i=0;i<200;i++) {         
                p=(Persona)leer.readObject();
                if (p.getSexo().equals("H")){
                    System.out.printf( "%-11s%-40s%-8s%-5s\n",p.getClave(),p.getNombre(),p.getSexo(),p.getEdad()); 
                }
            }
            leer.close();
        }
        catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());}
    }

    public static void lisM(){
        int i;
        Persona p;
        try{
            File fichero=new File("Personas.txt");
            FileInputStream fis=new FileInputStream(fichero);
            ObjectInputStream leer=new ObjectInputStream(fis);
            for (i=0;i<200;i++) {         
                p=(Persona)leer.readObject();
                if (p.getSexo().equals("F")){
                    System.out.printf( "%-11s%-40s%-8s%-5s\n",p.getClave(),p.getNombre(),p.getSexo(),p.getEdad()); 
                }
            }
            leer.close();
        }
        catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());}
    }

    public static void lisMayoEd(int dato){
        int i;
        Persona p;
        try{
            File fichero=new File("Personas.txt");
            FileInputStream fis=new FileInputStream(fichero);
            ObjectInputStream leer=new ObjectInputStream(fis);
            for (i=0;i<200;i++) {         
                p=(Persona)leer.readObject();
                if (p.getEdad()>dato){
                    System.out.printf( "%-11s%-40s%-8s%-5s\n",p.getClave(),p.getNombre(),p.getSexo(),p.getEdad()); 
                }
            }
            leer.close();
        }
        catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());}
    }

    public static void lisMenEd(int dato){
        int i;
        Persona p;
        try{
            File fichero=new File("Personas.txt");
            FileInputStream fis=new FileInputStream(fichero);
            ObjectInputStream leer=new ObjectInputStream(fis);
            for (i=0;i<200;i++) {         
                p=(Persona)leer.readObject();
                if (p.getEdad()<dato){
                    System.out.printf( "%-11s%-40s%-8s%-5s\n",p.getClave(),p.getNombre(),p.getSexo(),p.getEdad()); 
                }
            }
            leer.close();
        }
        catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());}
    }
}
