import java.util.Date;
import java.util.ArrayList;
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
   
    /**
     * Constructor for objects of class Viaje
     * 

     */
    public Viaje(Date fechaIni, int dias, int noches, Clima clima, boolean balneario,int genero)
    {
        ArrayList<String> listaBasica = generaListaActiviadesBasica();
        itinerario = new Itinerario(listaBasica);
        listaArticulos = new ListaArticulos(fechaIni, dias, noches, clima, balneario, 1);//1 es un hombre 0una mujera
        
        // initialise instance variables
    } 
    
    /**
     * obtener la lista de articulos
     * 
     * @return     lista de articulos
     */
    public ArrayList generaListaActiviadesBasica()
    {
        // put your code here
        return new ArrayList<String>();
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
     * obtener fecha de inicio
     * 
     * @return     fechainicio
     */
    public Date getFechaInicio()
    {
        // put your code here
        return fechaInicio;
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
    public void setFechaInicio(Date fecha)
    {
        // put your code here

    }
    
    /**
     * modificar duracion 
     * validar valores
     * 
      */
    public void setDuracionViaje( int dias,int noches)
    {
        // put your code here

    }
    
    /**
     * modificar clima 
     * 
     */
    public void setClima( Clima nuevoClima)
    {
        // put your code here
        
    }
    
    /**
     * modificar baño
     * 
     */
    public void setBaño( boolean balneario  )
    {
        // put your code here
        

    }
}
