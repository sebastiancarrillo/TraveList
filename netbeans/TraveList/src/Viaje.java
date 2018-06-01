import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.lang.Cloneable;
/**
 * viaje guarda y organiza el itinerario y la lista de articulos
 * de un viaje
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Viaje
{
    // instance variables - replace the example below with your own
    private String nombre;
    private ListaArticulos listaArticulos;
    private Itinerario itinerario;
    private int dias;//duracion 
    private int noches;//duracion
    private Clima clima;  
    private boolean baño;  // indica si hay un cuerpo de agua cercano
    private int genero; //  si es mujer, 1 si es hombre
    private GregorianCalendar inicio;
    private GregorianCalendar fin;

    /**
     * Constructor for objects of class Viaje
     * 

     */
    public Viaje(GregorianCalendar inicio, int dias,int noches,
    Clima clima,boolean balneario,int genero,String nombreViaje)
    {
        try {//estas clases validan los parametros entonces aca no los validamos
            if(nombreViaje.length() >= 30)
            {
                throw new RuntimeException("nombre muy largo");
            }
            this.inicio = inicio;
            this.fin = (GregorianCalendar) this.inicio.clone();
            this.fin.add(this.fin.HOUR,(dias+noches)*12);
        } catch (RuntimeException e) {
            throw new RuntimeException("parametros de fechas, duracion o genero invalidos");
        } 
        // la fecha es validadaen esta clase :
        GregorianCalendar fechaActual = new GregorianCalendar();
        if(inicio.before(fechaActual)){
                    throw new RuntimeException("fecha invalida, debe ser mayor que la actual");
        }
        //si llega hasta aca los parametros son validos
        listaArticulos = new ListaArticulos(dias, noches, clima, balneario, genero);
        itinerario = new Itinerario(inicio, fin);
        this.dias = dias;  
        this.noches = noches;
        this.clima = clima;
        this.baño = balneario;
        this.genero = genero;
        this.nombre = nombreViaje.toUpperCase().replaceAll("\\s","").trim();
    }
    
    /**
     * Obtener la hora de inicio del viaje
     * 
     * @return entero que representa la hora
     */
    public int getHora(boolean jornada){
        int hora;
        if (jornada){
            hora = 6;
        }
        else{
            hora = 18;
        }
        return hora;
    }
    
    /**
     * Obtener el numero de dias
     * 
     * @return entero que representa el numero de dias del viaje
     */
    public int getDias(){
        return dias;
    }
    /**
     * Obtener el numero de dias
     * 
     * @return entero que representa el numero de dias del viaje
     */
    public int getNoches(){
        return noches;
    }
    /**
     * obtener la lista de articulos
     * 
     * @return     lista de articulos
     */
    public ListaArticulos getListaArticulos()
    {
        return listaArticulos;
    }    

    /**
     * obtener itinerario
     * 
     * @return     itinerario
     */
    public Itinerario getItinerario()
    {
        return itinerario;
    }
    
    /**
     * obtain the travels name
     * 
     * @return     itinerario
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * obtener fecha de inicio
     * 
     * @return     fechainicio
     */
    public GregorianCalendar getInicio()
    {
        return (GregorianCalendar) inicio.clone();
    }

    /**
     * obtener duracion 
     * 
     * @return     arreglo de enteros con la cantidad de dias y noches
     */
    public int[] getDuracionViaje()
    {
        // put your code here
        int [] duracion= {dias,noches};
        return duracion;
    }

    /**
     * obtener clima 
     * 
     * @return     clima
     */
    public Clima getClima()
    {
        // put your code here
        return clima;
    }

    /**
     * obtener baño
     * 
     * @return     boolean baño
     */
    public boolean getBaño()
    {
        // put your code here
        return baño;
    }

    /**
     * modificar fecha de inicio
     * validar fecha
     */
    public boolean setInicio(GregorianCalendar inicio)
    {
        if(validaFecha(inicio)){
            this.fin = (GregorianCalendar) inicio.clone();
            this.fin.add(this.fin.HOUR,((dias+noches)*12));
            this.itinerario.setFechaViaje(inicio,this.fin);
            this.inicio = inicio;
            return true;
        }
        return false;
    }

    /**
     * modificar duracion 
     * validar valores
     * 
     */
    public boolean setDuracionViaje( int dias,int noches ) // Es necesario revisar este metodo pues se va a trabajar con fechas
    {
        // put your code here

        if(dias<=0 || noches<0 || Math.abs(dias-noches)>1){
            return false;
        }

        boolean modLis = listaArticulos.regenerarLista( dias, noches,  this.clima,  this.baño, this.genero);
        this.fin = (GregorianCalendar) this.inicio.clone();
        this.fin.add(fin.HOUR,((dias+noches)*12));
        if(modLis==true)
        { 
            
            this.itinerario.setFechaViaje(this.inicio,this.fin);
            this.dias=dias;
            this.noches=noches;
            return true;

        }
        return false;
    }

    /**
     * modificar clima 
     * 
     */
    public void setClima( Clima nuevoClima)
    {
        boolean modLis = listaArticulos.regenerarLista( this.dias, this.noches,  nuevoClima,  this.baño, this.genero);
        if(modLis==true)
        {
            this.clima =nuevoClima;
        }

    }

    /**
     * modificar baño
     * 
     */
    public void setBaño(boolean balneario)
    {
        boolean modLis = listaArticulos.regenerarLista( this.dias, this.noches,  this.clima,  balneario, this.genero);
        if(modLis==true)
        {
            this.baño = balneario;
        }

    }
    /**
     * valida que las fechas del viaje no sean antes de la fecha actual
     * 
     * @return true si es valida la fecha y false si la fecha es invalida
     */
    public boolean validaFecha(GregorianCalendar fecha){
        GregorianCalendar fechaActual = new GregorianCalendar();
        if(fecha.before(fechaActual)){
                    return false;
        }
        return true;
    }
}
