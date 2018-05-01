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
    private ListaArticulos listaArticulos;
    private Itinerario itinerario;
    private Date fechaInicio;
    private int dias;//duracion 
    private int noches;//duracion
    private Clima clima;  
    private boolean baño;  // indica si hay un cuerpo de agua cercano
    private int genero; //  si es mujer, 1 si es hombre

    /**
     * Constructor for objects of class Viaje
     * 

     */
    public Viaje(Date fechaIni, int dias, int noches, Clima clima, boolean balneario,int genero)
    {
        try {//estas clases validan los parametros entonces aca no los validamos
            listaArticulos = new ListaArticulos(dias, noches, clima, balneario, genero);//1 es un hombre 0una mujera
            itinerario = new Itinerario(dias);
        } catch (RuntimeException e) {
            //System.out.println("holaaaaaaaaaaaaaaa");
            throw new RuntimeException("parametros de fechas, duracion o genero invalidos");
        } 
        // la fecha es validadaen esta clase :
        Date fechaActual = new Date();
        if(fechaActual.getYear() <= fechaIni.getYear()){
            if(fechaActual.getMonth() <= fechaIni.getMonth()){
                if(fechaActual.getDay()<fechaIni.getDay()){
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

    } 

    /**
     * obtener la lista de articulos
     * 
     * @return     lista de articulos
     */
    public ListaArticulos getListaArticulos()
    {
        // put your code here
        return (ListaArticulos) listaArticulos.clone();
    }    

    /**
     * obtener itinerario
     * 
     * @return     itinerario
     */
    public Itinerario getItinerario()
    {
        // put your code here
        return (Itinerario) itinerario.clone();
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
                if(fechaActual.getDay()<fecha.getDay()){
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
        this.dias=dias;
        this.noches=noches;
      boolean modLis = listaArticulos.regenerarLista( this.dias, this.noches,  this.clima,  this.baño, this.genero);
      //boolean modItin = Itinerario.modificarDuracion( dias );
      boolean modItin =true;
      if((modLis==true) && (modItin==true))
      {
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
         //TODO/////////////////////////////////////////////////////////////////////////////////////
        /*
         * modificar lista de articulos por modificacion del clima
       */

    }

    /**
     * modificar baño
     * 
     */
    public void setBaño( boolean balneario  )
    {
        //TODO/////////////////////////////////////////////////////////////////////////////////////
        /*
         * modificar  lista de articulos por modificacion de presencia de cuerpo de agua
       */

    }

}
