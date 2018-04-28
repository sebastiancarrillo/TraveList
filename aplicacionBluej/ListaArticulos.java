import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/**
 * lista de articulos modela una lista con los articulos generada
 * principalmente con datos basicos a la cual l se le pueden
 * agregar o quitar elementos
 * jusificacion de esta clase:(seguridad) poder hacer programacion defensiva a la hora de agregar elementos a la lista, puesto que si es un 
 * atributo en viaje podria agregar elementos de forma descontrolada, tambien quitarle obligaciones a la clase viajes.
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
     * @param genero es un entero 0-mujer  1-hombre 
     */
    public ListaArticulos( Date fechaIni, int dias, int noches, Clima clima, boolean balneario, int genero)//debe pedir los datos del viaje duracion, baño...
    {
        // initialise instance variables
        listaArticulos =new ArrayList<Articulo>();
        //generar la lista basica segun sexo del usuario y datos del viaje
        generarLista( fechaIni, dias, noches, clima, balneario, genero);
    }

    /**
     * generar la lista del viaje
     * ojooo solo se debe generar una vez,toma los datos 
     * del viaje y genera una lista apropiada
     * si ya existesolo debe poderse agregar 
     * 
     * @ param  Datefehca inicio, int cantidad de dias, int cantidad noche, numb clima, boolean confirmacion balneario
     */
    public void generarLista( Date fechaIni, int dias, int noches, Clima clima, boolean balneario, int genero)
    {
        // initialise instance variables
        if( genero == 0 ){ //aca se agregan cosas que solo llevan las mujeres
            agregaArticulo( "maquillaje","", 1 , Prioridad.MEDIA );
            agregaArticulo( "Toallas higienicas","paquete", 1 , Prioridad.BAJA );//TODO:poner que se agregue esto esdecierta cantidad de dias
            agregaArticulo( "uñas","paquete", 1 , Prioridad.BAJA );
            
        }else{//lo que solo llevan los hombres
            
        }
        
    }

    /**
     * agrega un articulo lista de articulos
     * debe validar que el elemento no se haya agregado ya, comparar...
     * 
     * @param  nuevo articulo a agregar
     * @return    true si se agrego exitosamente, false si no
     */
    public boolean agregaArticulo( String nombre, String descripcion, int cantidad , Prioridad prioridad )
    {
        // put your code here
        try {
            if(buscarArticuloPorNombre( nombre ) != null){
                Articulo nuevoArt = new Articulo(nombre, descripcion, cantidad, prioridad);
                listaArticulos.add( nuevoArt );
                return true;
            }
            else{return false;}//ya existe un articulo con ese nombre TODO: qeu hacer cuando ya existe???????????
        } catch (RuntimeException e) {
            //System.out.println("holaaaaaaaaaaaaaaa");
            return false;
        } 
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
        return listaArticulos.remove(articulo);
    }

    /**
     * encontrar articulo segun indice
     * 
     * @param  nombre del articulo
     * @return    actividad encontrada o null
     */
    public Articulo buscarArticuloPorNombre( String nombre )
    {
        if( listaArticulos.size()>=1 ){
            Iterator <Articulo> it = listaArticulos.iterator();
            while(it.hasNext())
            {
                Articulo art = it.next();
                String nomb = nombre.replaceAll("\\s","").trim().toUpperCase();
                if( art.getNombre().equals(nomb))
                {
                    return art;
                }
            }
        }
        return null;
    }
}
