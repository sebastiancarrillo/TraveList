import java.sql.Time;
/**
 * Actividad modelas las actividades
 * a realizar en el itinerario
 * 
 @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Actividad
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String descripcion;
    private int diaInicio;   //manejamos los dias como enteros 1-primer dia, 2-segundo dia ...
    private int diaFin;      //...  ////////////TODO : modificar tipo de fecha, usar DATE
    private Time horaInicio;  // esta hora debe cumplir el formato de hora militar,ej: 1630 son las 4:30 por ejemplo  
    private Time horaFin;     //...  
    private Estado estado;

    /**
     * Constructor for objects of class Actividad
     * almacenar nombres con un estandar todo minuscula, quitar espacios inicio final
      */
    public Actividad()
    {
        // initialise instance variables
        
    }

    /**
     * metodo que devuelve el nombre de la actividad
     * 
     * @return     nombre: String con el nombre de la actividad 
     */
    public String getNombre()
    {
        // put your code here
        return nombre;
    }
    
    /**
     * metodo que devuelve la descripcion de la actividad
     *
     * @return  String con la descripcion de la actividad
     */
    public String getDescripcion()
    {
        // put your code here
        return descripcion;
    }
    
    /**
     * metodo que devuelve la fecha de inicio
     * de la actividad
     *
     * @return  Date con la fechaInicio de la actividad
     */
    public int getDiaInicio()
    {
        // put your code here
        return diaInicio;
    }
    
     /**
     * metodo que devuelve la fecha de finalizacion
     * de la actividad
     *
     * @return  Date con la fechafin de la actividad
     */
    public int getDiaFin()
    {
        // put your code here
        return diaFin;
    }
    
    /**
     * metodo que devuelve la horaInicio de la actividad
     *
     * @return  Time con la horaInicio de la actividad
     */
    public Time getHoraInicio()
    {
        // put your code here
        return horaInicio;
    }
    
    /**
     * metodo que devuelve la horaFin de la actividad
     *
     * @return  Time con la horaFin de la actividad
     */
    public Time getHoraFin()
    {
        // put your code here
        return horaFin;
    }
    
    /**
     * metodo que devuelve el estado de la actividad
     *
     * @return  estado 
     */
    public Estado getEstado()
    {
        // put your code here
        return estado;
    }
    
    /**
     * metodo que modifica el nombre de la actividad
     *  pasar el nombre al estandar antes de guardar
     * 
     * @param  nuevoNombre   
     * @return     boolean , para confirmar el exito del cambio 
     */
    public boolean setNombre( String nuevoNombre )
    {
        // put your code here
        return false;
    }
    
    /**
     * metodo que modifica el nombre de la actividad
     * 
     * @param  nuevaDescripcion   
     * @return     boolean para confirmar el cambio 
     */
    public boolean setDescripcion( String nuevaDescripcion )
    {
        // put your code here
        return false;
    }
    
    /**
     * metodo que modifica la fechaInicio de la actividad
     * ojo, validar la fecha antes menor a la duracion
     * 
     * @param  nuevaFechaInicio
     * @return  boolean para confirmar el cambio
     */
    public boolean setFechaInicio( int nuevaFechaIn )
    {
        // put your code here
        return false;
    }
    
    /**
     * metodo que modifica la fechaFin de la actividad
     * ojo, validar la fecha antes menor a la duracion.
     * 
     * @param  nuevaFechaFin
     * @return  boolean para confirmar el cambio
     */
    public boolean setFechaFin( int nuevaFechaFin )
    {
        // put your code here
        return false;
    }
    
    /**
     * metodo que modifica la horaInicio de la actividad
     * ojo, validar la hora antes, menor a 2400, mayor a 0
     * @param  nuevaHoraInicio
     * @return  boolean para confirmar el cambio
     */
    public boolean setHoraInicio( Time nuevaHoraIn )
    {
        // put your code here
        return false;
    }
    
    /**
     * metodo que modifica la horaFin de la actividad
     * ojo, validar la hora antes, menor a 2400, mayor a 0
     * 
     * @param  nuevaHoraFin
     * @return  boolean para confirmar el cambio
     */
    public boolean setHoraFin( Time nuevaHoraFin )
    {
        // put your code here
        return false;
    }
    
    /**
     * metodo que cambia el estado de la actividad
     *
     * @return  boolean de confirmacion 
     */
    public boolean setEstado( Estado est)
    {
        // put your code here
        return false;
    }
}
