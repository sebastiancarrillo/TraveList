import java.util.Date;
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
    private Date fechaInicio;  // cuidado enero es el mes 0 diciembre el mes 11 y el año esta adelantado en 1
    private int dias;//duracion 
    private int noches;//duracion
    private Clima clima;  
    private boolean baño;  // indica si hay un cuerpo de agua cercano
    private int genero; //  si es mujer, 1 si es hombre

    /**
     * Constructor for objects of class Viaje
     * 

     */
    public Viaje(int añoIni,int mesIni, int diaIni , int dias, int noches, Clima clima, boolean balneario,int genero,String nombreViaje)
    {
        try {//estas clases validan los parametros entonces aca no los validamos
            if(nombreViaje.length() >= 30)
            {
                throw new RuntimeException("nombre muy largo");
            }
            listaArticulos = new ListaArticulos(dias, noches, clima, balneario, genero);//1 es un hombre 0una mujera
            itinerario = new Itinerario(dias);
        } catch (RuntimeException e) {
            //System.out.println("holaaaaaaaaaaaaaaa");
            throw new RuntimeException("parametros de fechas, duracion o genero invalidos");
        } 
        // la fecha es validadaen esta clase :
        Date fechaIni = new Date(añoIni,mesIni,diaIni);

        Date fechaActual = new Date();
        if(fechaActual.getYear() <= fechaIni.getYear()){
            if(fechaActual.getMonth() <= fechaIni.getMonth()){
                if(fechaActual.getDate()<fechaIni.getDate()){
                    throw new RuntimeException("fecha invalida, debe ser mayor que la actual");
                }
            }
        }
        //si llega hasta aca los parametros son validos
        this.fechaInicio=fechaIni;
        this.dias = dias;  
        this.noches = noches;
        this.clima = clima;
        this.baño = balneario;
        this.genero = genero;
        this.nombre = nombreViaje.toUpperCase().replaceAll("\\s","").trim();
    } 

    /**
     * obtener la lista de articulos
     * 
     * @return     lista de articulos
     */
    public ListaArticulos getListaArticulos()
    {
        // put your code here
        return listaArticulos;
    }    

    /**
     * obtener itinerario
     * 
     * @return     itinerario
     */
    public Itinerario getItinerario()
    {
        // put your code here
        return itinerario;
    }
    
    /**
     * obtain the travels name
     * 
     * @return     itinerario
     */
    public String getNombre()
    {
        // put your code here
        return nombre;
    }

    /**
     * obtener fecha de inicio
     * 
     * @return     fechainicio
     */
    public Date getFechaInicio()
    {
        // put your code here

        return (Date) fechaInicio.clone();
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
    public boolean setFechaInicio(Date fecha)
    {
        // put your code here
        Date fechaActual = new Date();
        if(fechaActual.getYear() <= fecha.getYear()){
            if(fechaActual.getMonth() <= fecha.getMonth()){
                if(fechaActual.getDate()<fecha.getDate()){
                    return false;
                }
            }
        }
        fechaInicio =fecha;
        return true;
    }

    /**
     * modificar duracion 
     * validar valores
     * 
     */
    public boolean setDuracionViaje( int dias,int noches )
    {
        // put your code here

        if(dias<=0 || noches<0 || Math.abs(dias-noches)>1){
            return false;
        }

        boolean modLis = listaArticulos.regenerarLista( dias, noches,  this.clima,  this.baño, this.genero);
        //boolean modItin = Itinerario.modificarDuracion( dias );
        itinerario.setDuracion(dias);
        if(modLis==true)
        {
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
    public void setBaño( boolean balneario  )
    {
        boolean modLis = listaArticulos.regenerarLista( this.dias, this.noches,  this.clima,  balneario, this.genero);
        if(modLis==true)
        {
            this.baño = balneario;
        }

    }

}
