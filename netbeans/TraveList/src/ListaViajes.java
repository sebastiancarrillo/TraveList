import java.util.Date;
import java.util.ArrayList;
import java.util.ListIterator;
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
     * @param datos del viaje
     * @return boolean de confirmacion

     */
    public boolean agregarViaje(Viaje viaje)
    {
        // put your code here
        try {//estas clases validan los parametros entonces aca no los validamos
            viajes.add(viaje);
        } catch (RuntimeException e) {
            //System.out.println("holaaaaaaaaaaaaaaa");
            return false;
        } 

        return true;
    }
    /**
     * obteenr la lista de viajes
     */
    public ArrayList<Viaje> getViajes()
    {
        return viajes;
    }
    /**
     * elimina un viaje de la lista de viajes
     * 

     */
    public boolean eliminarViaje( Viaje viaje)
    {
        // put your code here
        return viajes.remove(viaje);
    }
    /**
     * elimina un viaje de la lista de viajes
     * 

     */
    public Viaje buscarViajeNombre( String nombre)
    {
        // put your code here
        Viaje v;
        ListIterator<Viaje> it = viajes.listIterator();
         while (it.hasNext()){
            v = it.next();
            if (nombre.equals(v.getNombre())){
                System.out.println("Encontrado");
                return v;
            }
        }
        return null;
    }
    
    
}
