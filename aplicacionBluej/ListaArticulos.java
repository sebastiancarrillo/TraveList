import java.util.ArrayList;
import java.util.Date;
/**
 * lista de articulos modela una lista con los articulos generada
 * principalmente con datos basicos a la cual l se le pueden
 * agregar o quitar elementos
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class ListaArticulos
{
    // instance variables - replace the example below with your own
    private ArrayList<Articulo> listaArticulos;

    /**
     * Constructor for objects of class ListaArticulos
     * toma la lista basica de articulos para crear la lista del viaje
     */
    public ListaArticulos( Date fechaIni, int dias, int noches, Clima clima, boolean balneario )//debe pedir los datos del viaje duracion, baño...
    {
        // initialise instance variables
    }

     /**
     * generar la lista del viaje
     * ojooo solo se debe generar una vez,toma los datos 
     * del viaje y genera una lista apropiada
     * si ya existesolo debe poderse agregar 
     * 
     * @return arreglo con la lista basica 
     */
    public ArrayList generarLista( ArrayList lista )
    {
        // initialise instance variables
        return lista;
    }

    /**
     * agrega un articulo lista de articulos
     * debe validar que el elemento no se haya agregado ya, pasar a minusculas, quitar espacion, comparar...
     * 
     * @param  nuevo articulo a agregar
     * @return    true si se agrego exitosamente, false si no
     */
    public boolean agregaArticulo( Articulo nuevo )
    {
        // put your code here
        return false;
 
   }
   
   /**
     * elimina una actividad deseada
     * TODO: se podria pasar el nombre del articulo y buscarlo o solo pasar el articulo, cual se nos facilita?
     *  
     * @param  articulo a eliminar
     * @return    true si se elimino exitosamente, false si no
     */
    public boolean eliminaArticulo( Articulo articulo )
    {
        // put your code here
        
        /////////TODO: escoger mejor metodo de eliminar una actividad
     ////////////indice o actividad
        return false;
    }
    
    
    /**
     * encontrar actividad segun indice
     * 
     * @param  index int de la actividad
     * @return    actividad encontrada o null
     */
    public Articulo buscarArticuloPorIndex( String nombre )
    {
        
        return new Articulo( nombre, "", 0);
    }
}
