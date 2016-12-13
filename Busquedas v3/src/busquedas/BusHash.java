package busquedas;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
import java.util.Random; 
public class BusHash{
    static HashMap<Integer,Persona> Map1 = new HashMap<Integer,Persona>();
    static int indice;
    static int valor;
    static Random r= new Random();
    
    public static void buscar(){
        Persona p=null;
        ObjectInputStream leer=null;
        try{
            File fichero=new File("Personas.txt");
            FileInputStream fis=new FileInputStream(fichero);
            leer=new ObjectInputStream(fis);
            System.out.printf( "%-8s%-18s%-40s%-8s%-5s\n","Indice","Clave","Nombre","Sexo","Edad" );
            for(indice=0;indice<200;indice++){
                p=(Persona)leer.readObject();
                 valor=convertir(p.getClave());
                Map1.put(valor,p);
                System.out.printf( "%-8s%-18s%-40s%-8s%-5s\n",valor,p.getClave(),p.getNombre(),p.getSexo(),p.getEdad());
            }
            leer.close();
        }catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }
    public static String buscar2(String link){
        Persona p=null;
        String datos="";
        ObjectInputStream leer=null;
        try{
            File fichero=new File(link);
            FileInputStream fis=new FileInputStream(fichero);
            leer=new ObjectInputStream(fis);
            System.out.printf( "%-8s%-18s%-40s%-8s%-5s\n","Indice","Clave","Nombre","Sexo","Edad" );
            datos+="Indice"+"           "+"Clave"+"                  "+"Nombre"+"                                            "+"Sexo"+"               "+"Edad"+"\n";
            for(indice=0;indice<200;indice++){
                p=(Persona)leer.readObject();
                 valor=convertir(p.getClave());
                Map1.put(valor,p);
                System.out.printf( "%-8s%-18s%-40s%-8s%-5s\n",valor,p.getClave(),p.getNombre(),p.getSexo(),p.getEdad());
                datos+=valor+"       "+p.getClave()+"         "+p.getNombre()+"             "+p.getSexo()+"                   "+p.getEdad()+"\n";
            }
            leer.close();
        }catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        return datos;
    }

    public static void ge(int dato){
        if(Map1.containsKey(dato)){
            System.out.println("Se encontro el indice: "+dato+" con los datos siguientes"+"\n"+Map1.get(dato));
            JOptionPane.showMessageDialog(null,"Se encontro el indice: "+dato+" con los datos siguientes"+"\n"+Map1.get(dato));
        }
        else
            System.out.println("No se encuentra el indice");
    }
    
    public static int convertir(int val){
        String a=""+val;
        String clave=a.charAt(0)+""+a.charAt(2)+""+((Integer.parseInt(a.charAt(6)+""))*ran())+""+a.charAt(7);
        return (Integer.parseInt(clave));
    }
    
     public static int ran(){
        int e=0;
        while((e+"").length()<2)
            e=0+r.nextInt(40);

        return e;
    }
}

