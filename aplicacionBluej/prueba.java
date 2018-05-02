import java.sql.Time;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Write a description of class prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class prueba
{
    // instance variables - replace the example below with your own
    private int x;

    private Time tiempo;
    /**
     * Constructor for objects of class prueba
     */
    public prueba()
    {
        // initialise instance variables
        //new Articulo("hola");
        this.tiempo = new Time(18,0,0);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void sampleMethod()
    {
        // put your code here
        //Date origin = new Date();
        Date fecha = new Date(2018,12,15);
        System.out.println(fecha.getYear());
        System.out.println(fecha.getMonth());
        System.out.println(fecha.getDate());

        Time tiempo = new Time(2018,12,1);
        try {
            // Articulo art = new Articulo("hola2");
        } catch (RuntimeException e) {
            //System.out.println("holaaaaaaaaaaaaaaa");
            //
        }
System.out.println("");
        GregorianCalendar origin = new GregorianCalendar(2018 , 12, 20);
        System.out.println(origin.DAY_OF_MONTH);
        System.out.println(origin.MONTH);
        System.out.println(origin.YEAR);
  
    }
}
