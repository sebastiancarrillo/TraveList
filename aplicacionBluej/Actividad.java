import java.sql.Time;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
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
    private int duracion;    // Se usa para validar que la actividad no se haga fuera de la fecha del viaje
    private Time horaInicio;  // esta hora debe cumplir el formato de hora militar,ej: 1630 son las 4:30 por ejemplo  
    private Time horaFin;     //...  
    private Estado estado;

    /**
     * Constructor for objects of class Actividad
     * almacenar nombres con un estandar todo minuscula, quitar espacios inicio final
      */
    public Actividad(String nombre, String descripcion, int diaInicio, int diaFin,
                       int duracion, Time horaInicio, Time horaFin)    
    {
        if (!validaNombre(nombre))
        {         
            throw new RuntimeException("nombre invalido, no pude tener numeros");
        }
        this.nombre = nombre.replaceAll("\\s","").trim().toLowerCase();
        this.descripcion = descripcion;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.duracion = duracion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = Estado.ACTIVA;
    }

    public Actividad(String nombre, String descripcion,int duracion)    
    {   
        if (!validaNombre(nombre))
        {         
            throw new RuntimeException("nombre invalido, no pude tener numeros");
        }
        this.nombre = nombre.replaceAll("\\s","").trim().toUpperCase();
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = Estado.ACTIVA;
    }
    /**
     * metodo que devuelve el nombre de la actividad
     * 
     * @return     nombre: String con el nombre de la actividad 
     */
    public String getNombre()
    {
        return this.nombre;
    }
    
    /**
     * metodo que devuelve la descripcion de la actividad
     *
     * @return  String con la descripcion de la actividad
     */
    public String getDescripcion()
    {
        return this.descripcion;
    }
    
    /**
     * metodo que devuelve la fecha de inicio
     * de la actividad
     *
     * @return  Date con la fechaInicio de la actividad
     */
    public int getDiaInicio()
    {
        return this.diaInicio;
    }
    
     /**
     * metodo que devuelve la fecha de finalizacion
     * de la actividad
     *
     * @return  Date con la fechafin de la actividad
     */
    public int getDiaFin()
    {
        return this.diaFin;
    }
    
    public int getDuracion(){
        return this.duracion;
    }
    /**
     * metodo que devuelve la horaInicio de la actividad
     *
     * @return  Time con la horaInicio de la actividad
     */
    public Time getHoraInicio()
    {
        return this.horaInicio;
    }
    
    /**
     * metodo que devuelve la horaFin de la actividad
     *
     * @return  Time con la horaFin de la actividad
     */
    public Time getHoraFin()
    {
        return this.horaFin;
    }
    
    /**
     * metodo que devuelve el estado de la actividad
     *
     * @return  estado 
     */
    public Estado getEstado()
    {
        return this.estado;
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
        if(validaNombre(nuevoNombre))
        {
            this.nombre = nombre.replaceAll("\\s","").trim().toLowerCase();
            return true;
        }
        else
        {
            return false;
        }
    }   
    
    /**
     * metodo que modifica la descripcion de la actividad
     * 
     * @param  nuevaDescripcion   
     * @return     boolean para confirmar el cambio 
     */
    public boolean setDescripcion( String nuevaDescripcion )
    {
        if (nuevaDescripcion != "" && nuevaDescripcion.length() <= 50){
            this.descripcion = nuevaDescripcion;
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * metodo que modifica la fechaInicio de la actividad
     * ojo, validar la fecha antes menor a la duracion
     * 
     * @param  nuevaFechaInicio
     * @return  boolean para confirmar el cambio
     */
    public boolean setDiaInicio( int nuevoDiaIn )
    {   
        if (nuevoDiaIn <= this.diaFin && nuevoDiaIn <= this.duracion){
            this.diaInicio = nuevoDiaIn;
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * metodo que modifica la fechaFin de la actividad
     * ojo, validar la fecha antes menor a la duracion.
     * 
     * @param  nuevaFechaFin
     * @return  boolean para confirmar el cambio
     */
    public boolean setDiaFin( int nuevoDiaFin )
    {
        if (nuevoDiaFin >= this.diaInicio && nuevoDiaFin <= this.duracion){
            this.diaFin = nuevoDiaFin;
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * metodo que modifica la horaInicio de la actividad
     * ojo, validar la hora antes, menor a 2400, mayor a 0
     * @param  nuevaHoraInicio
     * @return  boolean para confirmar el cambio
     */
    public boolean setHoraInicio( Time nuevaHoraIn )
    {
        if (nuevaHoraIn.before(this.horaFin)){
            this.horaInicio = nuevaHoraIn;
            return true;
        }
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
        if (nuevaHoraFin.after(horaFin)){
            this.horaFin = nuevaHoraFin;
            return true;
        }
        return false;
    }
    
    /**
     * metodo que cambia el estado de la actividad
     *
     * @return  boolean de confirmacion 
     */
    public void setEstado( Estado est)
    {
        this.estado = est;
    }
    
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }
    /**
     * metodo para validar el nombre de la actividad
     * 
     * solo se permiten nombres sin numeros  
     * 
     */
    public  boolean validaNombre(String nombre)
    {
        if(!nombre.equals("") && nombre.length() <= 30 )
        {
            nombre=nombre.replaceAll("\\s","").trim();//quita saltos de linea y espacios
            Pattern patron = Pattern.compile("[^A-Za-z ]");
            Matcher encaja = patron.matcher(nombre);
            if( !encaja.find() )// que sean solo letras
            {
                return true;
            }
        }
        return false;
    }
}
