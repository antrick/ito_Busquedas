package busquedas;
public class Ordenar
{

    public static void burbuja(Persona a[]){
        Persona aux;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i].esMayor(a[j])==true){
                    aux=a[i];
                    a[i]=a[j];
                    a[j]=aux;
                }
            }
        }
        
    }

    public  static void quick(Persona []a){
        ayuquick(a, 0, a.length-1);

    }

    private static void ayuquick(Persona a[], int izq, int der){
        Persona pivote=a[izq];
        int i=izq;
        int j=der;
        Persona aux;
        while(i<j){
            while(a[i].getClave()<=pivote.getClave() && i<j)i++;
            while(a[j].getClave()>pivote.getClave())j--;
            if(i<j){
                aux=a[i];
                a[i]=a[j];
                a[j]=aux;
            }
        }
        a[izq]=a[j];
        a[j]=pivote;
        if(izq<j-1)
            ayuquick(a,izq,j-1);
        if(j+1<der)
            ayuquick(a,j+1,der);
    }
}
