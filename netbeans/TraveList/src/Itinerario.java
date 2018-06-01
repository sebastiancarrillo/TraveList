import java.util.ArrayList;
import java.util.ListIterator;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.lang.Cloneable;
import java.util.Collections;
import java.util.Comparator;
/**
 * Itinerario es una lista de actividadas programadas para 
 * el viaje, se podran modificar o agremas mas actividades
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Itinerario
{
    private ArrayList<Actividad> itinerario; //Lista que contiene 
    private GregorianCalendar inicioViaje;
    private GregorianCalendar finViaje;
    /**
     * Constructor for objects of class Itinerario
     * toma la lista basica que contiene nombres y crea el itinerario basico
     * lista basica podria ser null
     */
    public Itinerario(GregorianCalendar inicioViaje, GregorianCalendar finViaje)
    {
        itinerario = new ArrayList<Actividad>();
        this.inicioViaje = inicioViaje;
        this.finViaje = finViaje;
    }
    
    /**
     * devuelve la lista del itinerario
     * 
     * @param  actividad a eliminar
    */    
    public ArrayList<Actividad> getItinerario()
    {
        if (itinerario != null && !itinerario.isEmpty())
            return itinerario;
        else{
            return null;
        }
    }
    
    public GregorianCalendar getInicioViaje()
    {
        return (GregorianCalendar) inicioViaje.clone();
    }
    
    public GregorianCalendar getFinViaje()
    {
        return (GregorianCalendar) finViaje.clone();
    }
    
     /**
     * agrega una actividad a la lista de actividades
     * ojooo!!!revisa que no haya nada programado en ese intervalo
     * en ese intervalo de tiempo
     * 
     * @param  nueva activida a agregar
     * @return    true si se agrego exitosamente, false si no
     */
    public boolean agregaActividad(Actividad nuevaActividad)
    {
        ListIterator<Actividad> it = itinerario.listIterator();
        Actividad actividad;
        boolean busy = false;
        if (nuevaActividad.validaFecha()){
            while(it.hasNext()){
                actividad = it.next();
                if (!(nuevaActividad.validaFecha(nuevaActividad.getInicio(),nuevaActividad.getFin(),inicioViaje,actividad.getInicio()) ||
                    nuevaActividad.validaFecha(nuevaActividad.getInicio(),nuevaActividad.getFin(),actividad.getFin(),finViaje))){
                        busy = true;
                }
            }
        }
        else{
            busy = true;
        }
        if (!busy){
            this.itinerario.add(nuevaActividad);
            return true;
        }
        return false;
    }
   
    /**
     * elimina una actividad deseada
     * 

     * @param  actividad a eliminar
     */
    public void eliminaActividad(Actividad actividad)
    {
        itinerario.remove(actividad);
    }
       
    /**
     * encontrar actividad segun nombre
     * 
     * @param  nombre de la actividad
     * @return    actividad encontrada o null
     */
    public Actividad buscarActividadPorNombre(String nombre)
    {
        ListIterator<Actividad> it = itinerario.listIterator();
        Actividad actividad;
        nombre = nombre.trim().toUpperCase();
        while(it.hasNext()){
            actividad = it.next();
            if (actividad.getNombre().equals(nombre)){
                return actividad; 
            }
        }
        return null;  
    }
    
    public void setFechaViaje(GregorianCalendar nuevoInicioViaje, GregorianCalendar nuevoFinViaje){
        ListIterator<Actividad> it = itinerario.listIterator();
        Actividad actividad;
        while (it.hasNext()){
            actividad = it.next();
            if (actividad.validaFecha(actividad.getInicio(),actividad.getFin(),nuevoInicioViaje,nuevoFinViaje)){
                actividad.setFechaViaje(nuevoInicioViaje,nuevoFinViaje);
            }
            else{
                eliminaActividad(actividad);
            }
        }
    }
    
    public void ordenarPorFecha(){
        Collections.sort(itinerario, new FechaComparador());
    }
    
    class FechaComparador implements Comparator<Actividad> {
        @Override
        public int compare(Actividad a, Actividad b) {
            return a.getInicio().before(b.getInicio()) ? -1 : a.getInicio().equals(b.getInicio()) ? 0 : 1;
        }
    }
    
    public String mostrarItinerario(){
        String imprimir = "";
        for (Actividad actividad : itinerario){
            GregorianCalendar inicio = actividad.getInicio();
            GregorianCalendar fin = actividad.getFin();
            imprimir = imprimir+(inicio.get(inicio.MONTH)+1)+"/"+inicio.get(inicio.DAY_OF_MONTH)+" "+inicio.get(inicio.HOUR)+":"+inicio.get(inicio.MINUTE)+"-"+(fin.get(inicio.MONTH)+1)+"/"+fin.get(inicio.DAY_OF_MONTH)+" "+fin.get(inicio.HOUR)+":"+fin.get(inicio.MINUTE)+" "+actividad.getNombre()+" "+actividad.getDescripcion()+"\n";
        }
        return imprimir;
    }
}