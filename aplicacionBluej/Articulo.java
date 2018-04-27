import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private Prioridad prioridad;

    /**
     * Constructor for objects of class Articulo
     * validar cantidad mayor a 0
     * almacenar nombres con un estandar todo minuscula quitar espacion inicio final
     *TODO: validar nombre desde la calse donde se crea
      */
    public Articulo(String nombre, String descripcion, int cantidad , Prioridad prioridad)
    {
   
        this.nombre = nombre;

        this.descripcion = descripcion;
        this.cantidad =cantidad;
        empacado = false;
        this.prioridad = prioridad;
    }

    /**
     * permite obtener el nombre del articulo
     * 
     * @return     nombre del articulo
     */
    public String getNombre()
    {
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
     * permite modificar el nombre del articulo
     * pasar el nombre al estandar antes de guardar, que no este vacio
     * 
     * 
     * @param     nuevo nombre del articulo
     */
    public void setNombre(String nombre)
    {
        // put your code here
        if(validaNombre(nombre))
        {
            this.nombre = nombre;
        }
    }

    /**
     * permite modificar la descripcion del articulo
     * 
     * @param    nueva descripcion del articulo
     */
    public void setDescripcion(String desc)
    {
        // put your code here
        descripcion=desc;
    }

    /**
     * permite modificar la cantidad del articulo
     * validar mayor a 0
     * @param    nueva canidad
     * @return    boolean de confirmacion
     */
    public boolean setCantidad(int cant)
    {
        if(cant > 0)
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

    /**
     * metodo para validar el nombre del producto
     * 
     * solo se permiten nombres sin numeros  
     * 
     */
    public static boolean validaNombre(String nombre)
    {
        //nombre.replaceAll("\\s","").trim().toUpperCase();
        if(!nombre.equals("") && nombre.length() <= 15 )
        {
            nombre=nombre.replaceAll("\\s","").trim();//quita saltos de linea y espacios
            Pattern patron = Pattern.compile("[^A-Za-z ]");
            Matcher encaja = patron.matcher(nombre);
            if( !encaja.find() )// que sean solo letras
            {
                return true;
            }
        }
        return false;
    }
}
