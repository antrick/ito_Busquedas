package busquedas;

import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectOutputStream;  
import java.util.NoSuchElementException; 
import java.util.Scanner; 
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Random;

/**CLASE PARA CREAR DATOS ALEATORIOS Y AGREGARLOS A UN ARCHIVO NUEVO POR SI NO EXISTE Y PROBAR EL PROGRAMA!*/
public class CreacionEmpleados
{
    
    static Random r= new Random();

//    public static void main (String [] args )throws IOException{
//        iniciar();   
//    }

    public static void iniciar() throws IOException{

        File salida = new File("Personas.txt");
        FileOutputStream Archivo = new FileOutputStream(salida);
        ObjectOutputStream esobj = new ObjectOutputStream(Archivo);
        String hom[]={"Antonio","Abraham","Abel","Adan","Alejandro","Alfonso","Alvaro","Alfredo","Angel","Arturo","Jorge","Aurelio","Federico",
                "Felipe","Fernando","Fidel","Francisco","Andres","Gabriel","Gonzalo","Luis","Hugo","Ismael","Jacob","Jaime"};
        String muj[]={"Ana","Laura","Ines","Isabel", "Monica", "Natalia","Lucero","Lidia", "Matilde", "Jaquelin", "Mariana", "Priscila","Julia",
                "Huri", "Silvana","Sofia","Elisa","Nilda", "Victoria", "Rosalia","Magaly", "Leslie", "Gabriela","Araceli","Allison"};
        String ap[]={"Lopez","Rios","Bautista","Velasco","Canseco","Bazan","Baños","Robles","Medina","Antonio","Espinoza","Navarro",
                "Arango","Rodriguez","Barroso","Sanchez","Juarez","Hernandez","Quintana","Valdes","Silva","Baños","Diaz","Camacho","Calvo"};

        System.out.printf( "%-8s%-17s%-32s%-6s%-5s\n","Numero","Clave","Nombre","Sexo","Edad" );
        for(int i=1; i<201; i++){
            genX();
            geSe();
            if(geSe()==1){
                String nombre=hom[genX()]+" "+ ap[genX()]+" "+ ap[genX()];
                Persona  p=new Persona(ran(),nombre,"H",generarE());
                esobj.writeObject(p);
                // System.out.println(i+" "+ p);
                System.out.printf( "%-8s%-17s%-32s%-6s%-5s\n",i,p.getClave(),p.getNombre(),p.getSexo(),p.getEdad());
            }else{
                String nombre=muj[genX()]+" "+ ap[genX()]+" "+ ap[genX()];
                Persona  p=new Persona(ran(),nombre,"F",generarE());
                esobj.writeObject(p);
                //  System.out.println(i+" "+ p);
                System.out.printf( "%-8s%-17s%-32s%-6s%-5s\n",i,p.getClave(),p.getNombre(),p.getSexo(),p.getEdad());
            }
        }
        esobj.close();
    }

    public static int generarE(){
        int e=18+r.nextInt(42);

        return e;
    }

    public static int genX(){
        int e=0+r.nextInt(24);

        return e;
    }

    public static int generarNC(){
        int n=0+r.nextInt(40000);

        return n;
    }

    public static int geSe(){
        int sex=(int)(Math.random()*2+1);   
        return sex;
    }
     public static int ran(){
        int e=0;
        while((e+"").length()<8)
            e=0+r.nextInt(40000000);

        return e;
    }
}

