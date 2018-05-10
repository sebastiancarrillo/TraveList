import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.GregorianCalendar;

/**
 * The test class ActividadTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ActividadTest
{
    Actividad prueba;
    /**
     * Default constructor for test class ActividadTest
     */
    public ActividadTest()
    {
        prueba = new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",2018,5,5,6,
                               15,8,30,30,new GregorianCalendar(2018,5,2,3,0),new GregorianCalendar(2018,5,7,8,0));
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void pruebaMetodosGet(){ 
        assertEquals("RUMBEAR", prueba.getNombre());
        assertEquals("Salir a tomar y bailar con unos amigos", prueba.getDescripcion());
        GregorianCalendar result = new GregorianCalendar(2018,5,5,15,30);
        assertEquals(result, prueba.getInicio());
        result = new GregorianCalendar(2018,5,6,8,30);
        assertEquals(result, prueba.getFin());
        assertEquals(Estado.ACTIVA, prueba.getEstado());
    }
    @Test
    public void pruebaMetodosSet(){
        assertEquals(true, prueba.setNombre("Salir a tomar"));
        assertEquals(false, prueba.setNombre(""));
        assertEquals(false, prueba.setNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(true, prueba.setDescripcion("Salir a tomar con amigos"));
        assertEquals(false, prueba.setDescripcion(""));
        assertEquals(false, prueba.setDescripcion("asdlñkfjsadlfkjsadlkfjsadlfkjsadlfkjsadklsjdflkasjflaskjflkasdfjasldkfjas"));
        assertEquals(true, prueba.setInicio(2,4,30));
        assertEquals(false, prueba.setInicio(6,10,0));
        assertEquals(false, prueba.setInicio(10,0,0));
        prueba.setInicio(5,15,30);
        assertEquals(true, prueba.setFin(5,16,0));
        assertEquals(false, prueba.setFin(4,0,0));
        assertEquals(false, prueba.setFin(1,2,0));
    }
}
