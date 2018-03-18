import java.util.ArrayList;

/**
 * Itinerario es una lista de actividadas programadas para 
 * el viaje, se podran modificar o agremas mas actividades
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Itinerario
{
    // instance variables - replace the example below with your own
    private ArrayList<Actividad> itinerario;

    /**
     * Constructor for objects of class Itinerario
     * toma la lista basica que contiene nombres y crea el itinerario asico
     * lista basica podria ser null
     
     */
    public Itinerario( ArrayList listaBasica )//debe pedir los datos del viaje duracion baño...
    {
        // initialise instance variables
        itinerario = new ArrayList<Actividad>();
    }
    
    /**
     * generar el itinerario del viaje
     * ojooo solo se debe generar una vez,toma los datos 
     * del viaje y genera una itinerario apropiado
     * si ya existesolo debe poderse agregar 
     * 
     * @return arreglo con el itinerario basico 
     */
    public ArrayList generarItinerario( ArrayList itinerario )
    {
        // initialise instance variables
        return itinerario;
    }

    /**
     * agrega una actividad a la lista de actividades
     * ojooo!!!reviza que no haya nada programado en ese intervalo
     * en ese intervalo de tiempo
     * 
     * @param  nueva activida a agregar
     * @return    true si seagrego exitosamente, false si no
     */
    public boolean agregaActividad( Actividad nueva )
    {
        // put your code here
        return false;
 
   }
   
   /**
     * elimina una actividad deseada
     * 

     * @param  activiad a eliminar
     * @return    true si se elimino exitosamente, false si no
     */
    public boolean eliminaActividad( Actividad actividad )
    {
        // put your code here
        
        /////////TODO: escoger mejor metodo de eliminar una actividad
     ////////////indice o actividad
        return false;
    }
    
    
    /**
     * encontrar actividad segun indice
     * 
     * @param  index int de la actividad
     * @return    actividad encontrada o null
     */
    public Actividad buscarActividadPorIndex( String nombre )
    {
        
        return new Actividad();
    }
    
    
}
