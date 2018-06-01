import java.util.GregorianCalendar;
/**
 * Actividad modelas las actividades
 * a realizar en el itinerario
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Actividad extends Item
{
    private GregorianCalendar inicio; //Fecha en que inicia la actividad
    private GregorianCalendar fin; //Fecha en que termina la actividad
    private Estado estado; //Estado de la actividad
    private GregorianCalendar inicioViaje;
    private GregorianCalendar finViaje;
    /**
     * Constructor for objects of class Actividad
     * almacenar nombres con un estandar todo minuscula, quitar espacios inicio final
     */
    public Actividad(String nombre, String descripcion, GregorianCalendar inicio, int duracionHoras,
            int duracionMinutos, GregorianCalendar inicioViaje, GregorianCalendar finViaje) 
    {
        super(nombre, descripcion);
        this.inicio = inicio;
        this.fin = (GregorianCalendar) this.inicio.clone();
        this.fin.add(this.fin.HOUR,duracionHoras);
        this.fin.add(this.fin.MINUTE,duracionMinutos);
        this.estado = Estado.ACTIVA;
        this.inicioViaje = inicioViaje;
        this.finViaje = finViaje;
    }
    
    /**
     * metodo que devuelve la fecha de inicio
     * de la actividad
     *
     * @return  GregorianCalendar con la fecha de inicio de la actividad
     */
    public GregorianCalendar getInicio()
    {
        return (GregorianCalendar) this.inicio.clone();
    }
    
    /**
     * metodo que devuelve la fecha de terminacion
     * de la actividad
     *
     * @return  GregorianCalendar con la fecha de inicio de la actividad
     */
    public GregorianCalendar getFin()
    {
        return (GregorianCalendar) this.fin.clone();
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
     * metodo que modifica la fecha de inicio de la actividad
     * 
     * @param  diaInicio, horaInicio, minutoInicio
     * @return  boolean para confirmar el cambio
     */
    public boolean setInicio(GregorianCalendar nuevoInicio)
    {   
        if (validaFecha(nuevoInicio,this.fin)){
            this.inicio = nuevoInicio;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * metodo que modifica la fecha del fin de la actividad
     * 
     * @param  diaFin, horaFin, minutoFin
     * @return  boolean para confirmar el cambio
     */
    public boolean setFin(GregorianCalendar nuevoFin)
    {
        if (validaFecha(this.inicio,nuevoFin)){
            this.fin = nuevoFin;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * metodo que cambia el estado de la actividad
     *
     */
    public void setEstado(Estado est)
    {
        this.estado = est;
    }

    /**
     * metodo que cambia la fecha de inicio y terminacion del viaje
     * 
     * @param nuevoInicioViaje
     */
    public void setFechaViaje(GregorianCalendar nuevoInicioViaje, GregorianCalendar nuevoFinViaje){
        this.inicioViaje = nuevoInicioViaje;
        this.finViaje = nuevoFinViaje;
    }
    
    /**
     * metodo que valida la fecha de la actividad
     * 
     * @param inicio, fin
     */
    public boolean validaFecha(GregorianCalendar inicio, GregorianCalendar fin){
        if (inicio.before(fin) && inicio.after(this.inicioViaje) && fin.before(this.finViaje)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * metodo que valida la fecha de la actividad
     * 
     * @param inicio, fin
     */
    public boolean validaFecha(){
        if (this.inicio.before(this.fin) && this.inicio.after(this.inicioViaje) && this.fin.before(this.finViaje)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * metodo que valida la fecha de la actividad
     * 
     * @param inicio, fin
     */
    public boolean validaFecha(GregorianCalendar inicio, GregorianCalendar fin, GregorianCalendar inicioViaje, GregorianCalendar finViaje){
        if (inicio.before(fin) && inicio.after(inicioViaje) && fin.before(finViaje)){
            return true;
        }
        else{
            return false;
        }
    }

}
