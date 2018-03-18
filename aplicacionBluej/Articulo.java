
/**
 * modela un articulo con nombre descripcion canidad y estado
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class Articulo
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String descripcion;
    private int cantidad;
    private boolean empacado;

    /**
     * Constructor for objects of class Articulo
     * validar cantidad mayor a 0
     * almacenar nombres con un estandar todo minuscula quitar espacion inicio final
     */
    public Articulo(String nombre, String descripcion, int cantidad)
    {
        // initialise instance variables
       
        empacado = false;
    }

    /**
     * permite obtener el nombre del articulo
     * 
     * @return     nombre del articulo
     */
    public String getNombre()
    {
        // put your code here
        return nombre;
    }
    
    /**
     * permite obtener la descripcion del articulo
     * 
     * @return     descripcion del articulo
     */
    public String getDescripcion()
    {
        // put your code here
        return descripcion;
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
     * permite modificar el nombre del articulo
     * pasar el nombre al estandar antes de guardar
     * 
     * @param     nuevo nombre del articulo
     */
    public void setNombre(String nombre)
    {
        // put your code here
        
    }
    
    /**
     * permite modificar la descripcion del articulo
     * 
     * @param    nueva descripcion del articulo
     */
    public void setDescripcion(String desc)
    {
        // put your code here
        
    }
    
    /**
     * permite modificar la cantidad del articulo
     * validar mayor a 0
     * @param    nueva canidad
     */
    public void setCantidad(int cant)
    {
        // put your code here
        
    }
    
    /**
     * permite modificar el estado del articulo
     * 
     * @param    nuevo estado true, empacado,false no empacado
     */
    public void setCantidad( boolean estado )
    {
        // put your code here
        empacado = estado;
        
    }
    
    /**
     * metodo que cambia la prioridad del articulo
     *
     * @return boolean de confirmacion 
     */
    public boolean setPrioridad( Prioridad prior)
    {
        // put your code here
        return false;
    }
}
