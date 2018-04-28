import java.util.Date;
import java.util.ArrayList;
/**
 * TraveList mantiene una lista de viajes
 * Cada viaje es una instancia de la clase viaje.
 * 
 * @author JhonMelendez,SebastianCarrillo
 * @version v1
 */
public class ListaViajes
{
    // instance variables - replace the example below with your own
    private ArrayList<Viaje> viajes;

    /**
     * Constructor for objects of class ListaViajes
     */
    public ListaViajes()
    {
        // initialise instance variables
        viajes = new ArrayList< Viaje >();
    }

    /**
     * agrega un viaje a la lista de viajes
     * TODO:validar la fecha y los dias

     */
    public boolean agregarViaje(Date fechaIni, int dias, int noches, Clima clima, boolean balneario, int genero)
    {
        // put your code here
        Viaje viaje = new Viaje( fechaIni, dias, noches, clima, balneario,1);//1 es un hombre
        viajes.add(viaje);
        
        return false;
    }
    
    /**
     * elimina un viaje de la lista de viajes
     * 

     */
    public boolean agregarViaje( Viaje viaje)
    {
        // put your code here
        return false;
    }
    
    
}
