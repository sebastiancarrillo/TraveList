import java.sql.Time;
/**
 * Actividad modelas las actividades
 * a realizar en el itinerario
 * 
@author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Actividad extends Item
{
    // instance variables - replace the example below with your own
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
        super(nombre, descripcion);
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.duracion = duracion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = Estado.ACTIVA;
    }

    public Actividad(String nombre, String descripcion,int duracion)    
    {   
        super(nombre, descripcion);
        this.duracion = duracion;
        this.estado = Estado.ACTIVA;
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

}
