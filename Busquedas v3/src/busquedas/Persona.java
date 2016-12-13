package busquedas;
import java.io.Serializable;
public class Persona implements Serializable{

    private int clave; 
    private String nombre;
    private String sexo;
    private int edad;

    public Persona(int clave, String nombre,String sexo, int edad){
        this.clave=clave;
        this.nombre=nombre;
        this.sexo=sexo;
        this.edad=edad;

    }

    public int getClave(){

        return clave;
    }

    public void setClave(int c){
        clave=c;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String n){
        nombre=n;
    }

    public String getSexo(){

        return sexo;
    }

    public void setSexo(String s){
        sexo=s;
    }

    public int getEdad(){

        return edad;
    }

    public void setEdad(int e){
        edad=e;
    }

    public String toString(){
        return"\tClave: "+getClave()+"\tNombre: "+getNombre()+"\tSexo: "+getSexo()+"\tEdad: "+getEdad();
    }
     public String toS(){
        return"\tNombre: "+getNombre()+"\tSexo: "+getSexo()+"\tEdad: "+getEdad();
    }

    public String to(){
               return"\nClave: "+getClave()+"\nNombre: "+getNombre()+"\nSexo: "+getSexo()+"\nEdad: "+getEdad();
    }

    public boolean esIgual(Object o){
        Persona p=(Persona)o;
        int r=this.nombre.compareToIgnoreCase(p.getNombre());
        return (r==0);
     }
  

    public boolean esMayor(Object o){
        Persona p=(Persona)o;
        int r=this.nombre.compareToIgnoreCase(p.getNombre());
        return (r>0);
    }

    public boolean esMenor(Object o){
        Persona p=(Persona)o;
        int r=this.nombre.compareToIgnoreCase(p.getNombre());
        return (r<0);
    }

}
