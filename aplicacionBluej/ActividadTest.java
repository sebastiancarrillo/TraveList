import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Time;

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
        prueba = new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",
                                        4, 4, 10, new Time(18,0,0), new Time(20,0,0));
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
        assertEquals(4, prueba.getDiaInicio());
        assertEquals(4, prueba.getDiaFin());
        assertEquals(10, prueba.getDuracion());
        assertEquals(new Time(18,0,0), prueba.getHoraInicio());
        assertEquals(new Time(20,0,0), prueba.getHoraFin());
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
        assertEquals(true, prueba.setDiaInicio(2));
        assertEquals(false, prueba.setDiaInicio(5));
        assertEquals(false, prueba.setDiaInicio(11));
        prueba.setDiaInicio(4);
        assertEquals(true, prueba.setDiaFin(5));
        assertEquals(false, prueba.setDiaFin(2));
        assertEquals(false, prueba.setDiaFin(11));
        assertEquals(true, prueba.setHoraInicio(new Time(17,0,0)));
        assertEquals(false, prueba.setHoraInicio(new Time(21,0,0)));
        prueba.setHoraInicio(new Time(18,0,0));
        assertEquals(true, prueba.setHoraFin(new Time(21,0,0)));
        assertEquals(false, prueba.setHoraFin(new Time(17,0,0)));
    }
}
