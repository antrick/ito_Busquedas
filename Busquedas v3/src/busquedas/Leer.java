package busquedas;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*; 

public class Leer{
    ObjectInputStream entrada;
    FileInputStream cv;
    ObjectOutputStream salida;
    

    public void read(){
        Persona registro;
        try{
            cv = new FileInputStream("Personas.txt");
            entrada = new ObjectInputStream(cv);
            System.out.printf( "%-11s%-40s%-8s%-5s\n","Clave","Nombre","Sexo","Edad" );

            while(true){
                registro =(Persona)entrada.readObject();
                System.out.printf( "%-11s%-40s%-8s%-5s\n",registro.getClave(),registro.getNombre(),registro.getSexo(),registro.getEdad());                                 
            }
        }
        catch( EOFException endOfFileException){}
        catch( ClassNotFoundException classNot){

            JOptionPane.showMessageDialog(null,"No se pudo crear el objeto");
        }
        catch( FileNotFoundException clot){

            JOptionPane.showMessageDialog(null,"No se pudo abrir el objeto");
        }
        catch(IOException ioException){
            JOptionPane.showMessageDialog(null,"Error de E/S");

        }
        try{
            entrada.close();
        }catch(IOException ip){
            JOptionPane.showMessageDialog(null,"Error al cerrar el archivo");

        }  
    }
    
    public String read2(String link){
        Persona registro;
        String datos="";
        try{
            cv = new FileInputStream(link);
            entrada = new ObjectInputStream(cv);
            System.out.printf( "%-11s%-40s%-8s%-5s\n","Clave","Nombre","Sexo","Edad" );
            datos+=" Clave"+"                  "+"Nombre"+"                                            "+"Sexo"+"               "+"Edad"+"\n";
            

            while(true){
                registro =(Persona)entrada.readObject();
                System.out.printf( "%-11s%-40s%-8s%-5s\n",registro.getClave(),registro.getNombre(),registro.getSexo(),registro.getEdad());
                datos+=registro.getClave()+"         "+registro.getNombre()+"             "+registro.getSexo()+"                   "+registro.getEdad()+"\n";
            }
        }
        catch( EOFException endOfFileException){}
        catch( ClassNotFoundException classNot){

            JOptionPane.showMessageDialog(null,"No se pudo crear el objeto");
        }
        catch( FileNotFoundException clot){

            JOptionPane.showMessageDialog(null,"No se pudo abrir el objeto");
        }
        catch(IOException ioException){
            JOptionPane.showMessageDialog(null,"Error de E/S");

        }
        try{
            entrada.close();
        }catch(IOException ip){
            JOptionPane.showMessageDialog(null,"Error al cerrar el archivo");

        }  
        return datos;
    }
   
    
    public static Persona[] leerFile(int x,String link){
        
        Persona a[]=new Persona[x];
        try{
            File fichero=new File(link);
            FileInputStream fis=new FileInputStream(fichero);
            ObjectInputStream leer=new ObjectInputStream(fis);
            for(int i=0;i<a.length;i++){
                Persona p=(Persona)leer.readObject();
                a[i]=p;
              //System.out.println(p);
            }
            leer.close();

            // ordenar(a,metodo);           
        }catch(Throwable e){JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());}
        return a;
    }

}
