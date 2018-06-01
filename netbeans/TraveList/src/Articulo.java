 
/**
 * modela un articulo con nombre descripcion canidad y estado
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Articulo extends Item
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String descripcion;
    private int cantidad;
    private boolean empacado;
    private Prioridad prioridad;

    /**
     * Constructor for objects of class Articulo
     * validar cantidad mayor a 0
     * almacenar nombres con un estandar todo minuscula quitar espacion inicio final
     *TODO: selanza una exepcion si elnombre no es valido
     */
    public Articulo(String nombre, String descripcion, int cantidad , Prioridad prioridad)
    {
        super(nombre, descripcion);

        if(cantidad>=1){
            this.cantidad =cantidad;
        }else{
            this.cantidad=1;
        }
        empacado = false;
        this.prioridad = prioridad;
    }

    /**
     * permite obtener el nombre del articulo
     * 
     * @return     nombre del articulo
     */
    public int getCantidad()
    {
        // put your code here
        return cantidad;
    }

    /**
     * permite obtener el estado del articulo
     * 
     * @return     empacado? del articulo
     */
    public boolean getEstado()
    {
        // put your code here
        return empacado;
    }

    /**
     * permite obtener laprioriad del articulo
     * 
     * @return     prioridad
     */
    public Prioridad getPrioriad()
    {
        // put your code here
        return prioridad;
    }


    /**
     * permite modificar la cantidad del articulo
     * validar mayor a 0
     * @param    nueva canidad
     * @return    boolean de confirmacion
     */
    public boolean setCantidad(int cant)
    {
        if( cant > 0 )
        {
            cantidad = cant;
            return true;
        }
        return false;
    }

    /**
     * permite modificar el estado del articulo
     * 
     * @param    nuevo estado true, empacado,false no empacado
     */
    public void setEstado( boolean estado )
    {
        // put your code here
        empacado = estado;
    }

    /**
     * metodo que cambia la prioridad del articulo
     *
     * @return boolean de confirmacion 
     */
    public void setPrioridad( Prioridad prior)
    {
        // put your code here
        prioridad = prior;
    }

}
