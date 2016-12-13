package busquedas;
import java.io.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Auxiliar
{
    static Leer arch= new Leer();
    static Graphic g=new Graphic();
//    public static void main (String [] andy)throws ClassNotFoundException, IOException,EOFException,Exception{
//        Iniciar(); 
//    }

    public static void Iniciar(){
        int op=0;
        do{
            try{
                op= Integer.parseInt(JOptionPane.showInputDialog("-- Menu Inicio -- Elige una opcion "+"\n"+
                        "1 - Mostrar Lista De Alumnos "+"\n"+
                        "2 - Ordenar por Nombre"+"\n"+
                        "3 - Metodo Busqueda Secuencial"+"\n"+
                        "4 - Metodo Busqueda Binaria"+"\n"+
                        "5 - Metodo Busqueda Hash"+"\n"+
                        "6 - Listar "+"\n"+
                        "7 - Salir"+"\n"));
                try{
                    switch(op){
                        case 1:
                        arch.read();
                        break;
                        case 2:
                        ordenar(arch.leerFile(201-1,g.getLink())); 
                        break;
                        case 3:
                        busqSec();
                        break;
                        case 4:
                        busqBin();
                        break;
                        case 5:
                        BusHash.buscar();
                        int dato=Integer.parseInt(JOptionPane.showInputDialog("Indique indice a buscar"));
                        BusHash.ge(dato);
                        break;
                        case 6:
                        listarHM();
                        break;
                    }
                }catch(NullPointerException enm){
                    JOptionPane.showMessageDialog(null,"----------------Error no se encontraron coincidencias------------------");
                }
            }catch(NumberFormatException en){
                JOptionPane.showMessageDialog(null,"Por favor debes ingresar un numero entero");
            }
        }while(op!=7);
    }

    public static void ordenar(Persona a[]){
        Ordenar.burbuja(a);
        System.out.println("Arreglo de personas ordenado ");
        System.out.printf( "%-8s%-40s%-8s%-5s\n","Clave","Nombre","Sexo","Edad" );
        for(int i=0;i<a.length;i++){
            System.out.printf( "%-8s%-40s%-8s%-5s\n",a[i].getClave(),a[i].getNombre(),a[i].getSexo(),a[i].getEdad());
        }
    }
    
    public static String ordenar2(Persona a[]){
        String datos="";
        Ordenar.burbuja(a);
        System.out.println("Arreglo de personas ordenado ");
        datos+="------------Arreglo de personas ordenado -------------\n";
        System.out.printf( "%-8s%-40s%-8s%-5s\n","Clave","Nombre","Sexo","Edad" );
        datos+=" Clave"+"                  "+"Nombre"+"                                            "+"Sexo"+"               "+"Edad"+"\n";
        for(int i=0;i<a.length;i++){
            System.out.printf( "%-8s%-40s%-8s%-5s\n",a[i].getClave(),a[i].getNombre(),a[i].getSexo(),a[i].getEdad());
            datos+=a[i].getClave()+"         "+a[i].getNombre()+"             "+a[i].getSexo()+"                   "+a[i].getEdad()+"\n";
        }
        return datos;
    }

    public static void busqBin(){
        int op=0;
        do{
            try{
                op= Integer.parseInt(JOptionPane.showInputDialog("Elige una opcion "+"\n"+
                        "1 - Busqueda por Nombre "+"\n"+
                        "2 - Busqueda por clave"+"\n"+
                        "3 - Regresar al menu Inicio"+"\n"));              
                try{
                    switch(op){
                        case 1:
                        Persona a[]=arch.leerFile(201-1,g.getLink());
                        Ordenar.burbuja(a);
                        System.out.printf( "%-10s%-17s%-32s%-6s%-5s\n","Posición","Clave","Nombre","Sexo","Edad" );
                        for(int i=0;i<a.length;i++){
                            System.out.printf( "%-10s%-17s%-32s%-6s%-5s\n",i+1,a[i].getClave(),a[i].getNombre(),a[i].getSexo(),a[i].getEdad());
                        }
                        String nombre=JOptionPane.showInputDialog("Ingrese nombre de la persona a buscar");
                         nombre.toUpperCase();
                        String aux=(String)Busquedas.buscar(a,nombre); 
                        JOptionPane.showMessageDialog(null,aux);
                        break;
                        case 2:
                        Persona a1[]=arch.leerFile(201-1,g.getLink());
                        Ordenar.quick(a1);
                        System.out.printf( "%-10s%-7s%-32s%-6s%-5s\n","Posición","Clave","Nombre","Sexo","Edad" );
                        for(int i=0;i<a1.length;i++){
                            System.out.printf( "%-10s%-7s%-32s%-6s%-5s\n",i+1,a1[i].getClave(),a1[i].getNombre(),a1[i].getSexo(),a1[i].getEdad());
                        }
                        int dato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese clave a buscar"));
                        Busquedas.buscarBin(a1,dato); 
                        break;
                    }
                }catch(NullPointerException enm){
                    JOptionPane.showMessageDialog(null,"----------------Error no se encontraron coincidencias------------------");
                }
            }catch(NumberFormatException en){
                JOptionPane.showMessageDialog(null,"Por favor debes ingresar un numero entero");
            }
        }while(op!=3);
    }

    public  static void busqSec(){
        int op=0;
        do{
            try{
                op= Integer.parseInt(JOptionPane.showInputDialog("Elige una opcion "+"\n"+
                        "1 - Busqueda por Nombre "+"\n"+
                        "2 - Busqueda por clave"+"\n"+
                        "3 - Regresar al Menu Inicio"+"\n"));              
                try{
                    switch(op){
                        case 1:
                        String nombre=JOptionPane.showInputDialog("Ingrese nombre de la persona a buscar");
                        String aux=Busquedas.busLiNom(nombre,g.getLink()); 
                        JOptionPane.showMessageDialog(null,aux);
                        break;
                        case 2:
                        int dato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese clave a buscar"));
                        Busquedas.buLiCla(dato,g.getLink()); 
                        break;
                    }
                }catch(NullPointerException enm){
                    JOptionPane.showMessageDialog(null,"----------------Error no se encontraron coincidencias------------------");
                }
            }catch(NumberFormatException en){
                JOptionPane.showMessageDialog(null,"Por favor debes ingresar un numero entero");
            }
        }while(op!=3);
    }

    public  static void listarHM(){
        int op=0;
        do{
            try{
                op= Integer.parseInt(JOptionPane.showInputDialog("Elige una opcion "+"\n"+
                        "1 - Listar Hombres "+"\n"+
                        "2 - Listar Mujeres"+"\n"+
                        "3 - Listar Mayores de: "+"\n"+
                        "4 - Listar Menores de: "+"\n"+
                        "5 - Regresar al Menu Inicio"+"\n"));              
                try{
                    switch(op){
                        case 1:
                        Listar.lisH();
                        break;
                        case 2:
                        Listar.lisM();
                        break;
                        case 3:
                        int dato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad:"));
                        //System.out.println("Las personas mayores de: "+dato+" son: ");
                        Listar.lisMayoEd(dato);
                        break;
                        case 4:
                        int datos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad:"));
                        //System.out.println("Las personas menores de: "+datos+" son: ");
                        Listar.lisMenEd(datos);
                        break;
                    }
                }catch(NullPointerException enm){
                    JOptionPane.showMessageDialog(null,"----------------Error no se encontraron coincidencias------------------");
                }
            }catch(NumberFormatException en){
                JOptionPane.showMessageDialog(null,"Por favor debes ingresar un numero entero");
            }
        }while(op!=5);
    }

}