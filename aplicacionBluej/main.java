import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
/**
 * TravelList te ayuda con una lista de implementos importantes para llevar a un viaje,
 * de tal forma que no olvides llevar ninguna de las cosas basicas que podrias necesitar.
 * Tambien da la posibilidad de manejar un itinerario en el cual puedes organizar tus 
 * actividades del viaje.
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class main
{
    // instance variables - replace the example below with your own
    public static ListaViajes  trips = new ListaViajes();
    public static Scanner reader = new Scanner(System.in);
    /**
     * metodo inicial de la aplicacion
     * 
     */
    public static void main (String [ ] args){

        menuPrincipal();

    }

    public static void menuPrincipal()
    {
        boolean terminar = false;
        while(!terminar)
        {

            limpiar(30);
            System.out.println("bem vindo ,welcome, bienvenido, bienvenue");
            System.out.println("----------------TRAVELIST----------------");
            System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|");
            Iterator <Viaje> it = trips.getViajes().iterator();
            System.out.println("               ");
             System.out.println("lista de viajes");
              System.out.println("               ");
            while(it.hasNext())//los articulos que quedaron el la nueva lista se agregan a la listaArticulos
            {
                Viaje viaj = it.next();
                System.out.println(viaj.getNombre());
            }
            System.out.println("1. agregar un viaje   2.eliminar un viaje  \n 3.detalles del viaje   4.terminar" );
            int n=reader.nextInt();
            boolean correcto = false;
            while(!correcto)
            {
                switch(n)
                {
                    case 1:
                    correcto=true;
                    //preguntar datos y agregar
                    break;
                    case 2:
                    correcto=true;
                    //pegreuntar cual y eliminar
                    break;
                    case 3:
                    correcto=true;
                    menuDetallesDelViaje();
                    break;
                    case 4:
                    correcto=true;//sale del bucle pequeño del swtich
                    terminar=true;//sale del bucle grande del menu de la app
                    break;
                    default :
                    System.out.println("respuesta invalida, porfavor intentelo de nuevo");
                }
            }
        }
    }


    public static void menuDetallesDelViaje()
    {
    }

    
    public static void limpiar(int lineas)
    {
        for (int i=0; i < lineas; i++)
        {
            System.out.println();
        }
    }
}
