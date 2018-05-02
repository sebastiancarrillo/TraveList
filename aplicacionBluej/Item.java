import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Abstract class Item - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Item
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String descripcion;

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
    public Item(String nombre, String descripcion)
    {
        // put your code here
        if (!validaNombre(nombre) || descripcion.length()>=200)
        {         
            throw new RuntimeException("nombre invalido, no pude tener numeros");
        }
        this.nombre = nombre.trim().toUpperCase();
        this.descripcion = descripcion;
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
     * permite modificar el nombre del articulo
     * pasar el nombre al estandar antes de guardar, que no este vacio
     * 
     * 
     * @param     nuevo nombre del articulo
     * @return     boolean para confirmacion
     */
    public boolean setNombre(String nombre)
    {
        // put your code here
        if(validaNombre(nombre))
        {
            this.nombre = nombre.trim().toUpperCase();
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * metodo que modifica la descripcion de la actividad
     * 
     * @param  nuevaDescripcion   
     * @return     boolean para confirmar el cambio 
     */
    public boolean setDescripcion( String nuevaDescripcion )
    {
        if (nuevaDescripcion != "" && nuevaDescripcion.length() <= 50){
            this.descripcion = nuevaDescripcion;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * metodo para validar el nombre del producto
     * 
     * solo se permiten nombres sin numeros  
     * 
     */
    public  boolean validaNombre(String nombre)
    {
        //nombre.replaceAll("\\s","").trim().toUpperCase();
        if(!nombre.equals("") && nombre.length() <= 30 )
        {
            nombre=nombre.trim().toUpperCase();//quita saltos de linea y espacios
            Pattern patron = Pattern.compile("[^A-Za-z,ñ ]");
            Matcher encaja = patron.matcher(nombre);
            if( !encaja.find() )// que sean solo letras
            {
                return true;
            }
        }
        return false;
    }
}
