import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Date;
/**
 * Itinerario es una lista de actividadas programadas para 
 * el viaje, se podran modificar o agremas mas actividades
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Itinerario
{
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
     * si ya existe solo debe poderse agregar 
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
     * ojooo!!!revisa que no haya nada programado en ese intervalo
     * en ese intervalo de tiempo
     * 
     * @param  nueva activida a agregar
     * @return    true si se agrego exitosamente, false si no
     */
    public boolean agregaActividad( Actividad nueva )
    {
        ListIterator<Actividad> it = itinerario.listIterator();
        Actividad actividad;
        boolean busy = true;
        while(it.hasNext()){
            actividad = it.next();
            if (((nueva.getHoraInicio().before(actividad.getHoraInicio()) || 
            nueva.getHoraInicio().equals(actividad.getHoraInicio())) &&
            nueva.getHoraFin().after(actividad.getHoraInicio())) ||           
            (nueva.getHoraInicio().before(actividad.getHoraInicio()) && 
            nueva.getHoraInicio().after(actividad.getHoraInicio()))){
                busy = false;
            }
        }
        if (busy == true){
            this.itinerario.add(nueva);
            return true;
        }
        return false;
   }
   
   /**
     * elimina una actividad deseada
     * 

     * @param  activiad a eliminar
     */
    public void eliminaActividad( Actividad actividad )
    {
        itinerario.remove(actividad);
    }
       
    /**
     * encontrar actividad segun nombre
     * 
     * @param  index int de la actividad
     * @return    actividad encontrada o null
     */
    public ArrayList<Actividad> buscarActividadPorNombre( String nombre )
    {
        ArrayList<Actividad> consulta = new ArrayList();
        ListIterator<Actividad> it = itinerario.listIterator();
        Actividad actividad;
        nombre = nombre.trim().toUpperCase();
        while(it.hasNext()){
            actividad = it.next();
            if (it.next().getNombre().contains(nombre)){
                consulta.add(actividad);
            }
        }
        return consulta;  
    }
}