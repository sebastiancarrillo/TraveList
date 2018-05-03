import java.util.Date;
/**
 * Actividad modelas las actividades
 * a realizar en el itinerario
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Actividad extends Item
{
    private Date inicio; //Fecha en que inicia la actividad
    private Date fin; //Fecha en que termina la actividad
    private Estado estado; //Estado de la actividad
    private int año;
    private int mes; 
    private Date inicioViaje;
    private Date finViaje;
    /**
     * Constructor for objects of class Actividad
     * almacenar nombres con un estandar todo minuscula, quitar espacios inicio final
     */
    public Actividad(String nombre, String descripcion, int año, int mes, int diaInicio, int diaFin, 
    int horaInicio, int horaFin, int minutoInicio, int minutoFin, Date inicioViaje, Date finViaje) 
    {
        super(nombre, descripcion);
        inicio = new Date(año, mes, diaInicio, horaInicio, minutoInicio);
        fin = new Date(año, mes, diaFin, horaFin, minutoFin);
        this.año = año;
        this.mes = mes;
        this.estado = Estado.ACTIVA;
        this.inicioViaje = inicioViaje;
        this.finViaje = finViaje;
    }

    /**
     * metodo que devuelve la fecha de inicio
     * de la actividad
     *
     * @return  Date con la fecha de inicio de la actividad
     */
    public Date getInicio()
    {
        return this.inicio;
    }
    
    /**
     * metodo que devuelve la fecha de terminacion
     * de la actividad
     *
     * @return  Date con la fecha de inicio de la actividad
     */
    public Date getFin()
    {
        return this.fin;
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
    public boolean setInicio(int nuevoDiaInicio, int nuevaHoraInicio, int nuevoMinutoInicio)
    {   
        Date nuevoInicio = new Date(this.año, this.mes, nuevoDiaInicio, nuevaHoraInicio, nuevoMinutoInicio);
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
    public boolean setFin(int nuevoDiaFin, int nuevaHoraFin, int nuevoMinutoFin)
    {
        Date nuevoFin = new Date(this.año, this.mes, nuevoDiaFin, nuevaHoraFin, nuevoMinutoFin);
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
    public void setFechaViaje(Date nuevoInicioViaje, Date nuevoFinViaje){
        this.inicioViaje = nuevoInicioViaje;
        this.finViaje = nuevoFinViaje;
    }
    
    /**
     * metodo que cambia el año de la actividad
     * 
     * @param nuevoAño
     */
    public void setAño(int nuevoAño){
        this.año = nuevoAño;
    }
    
    /**
     * metodo que cambia el mes de la actividad
     * 
     * @param nuevoMes
     */
    public void setMes(int nuevoMes){
        this.mes = nuevoMes;
    }
    
    /**
     * metodo que valida la fecha de la actividad
     * 
     * @param inicio, fin
     */
    public boolean validaFecha(Date inicio, Date fin){
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
    public boolean validaFecha(Date inicio, Date fin, Date inicioViaje, Date finViaje){
        if (inicio.before(fin) && inicio.after(inicioViaje) && fin.before(finViaje)){
            return true;
        }
        else{
            return false;
        }
    }

}
