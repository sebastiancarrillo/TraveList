import java.util.GregorianCalendar;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ViajeTest.
 *
 * @author  (your name)
 * @version (a version number or a GregorianCalendar)
 */
public class ViajeTest
{
    Viaje viaje1;
    /**
     * Default constructor for test class ViajeTest
     */
    public ViajeTest()
    {
        viaje1 = new Viaje(2018, 12, 1, 8, 10, 11, Clima.FRIO, true, 0,"cancun");
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
    public void pruebaMetodosGet()
    {
        assertEquals(true, viaje1.getBaño());
        assertEquals(Clima.FRIO, viaje1.getClima());
        assertEquals(new GregorianCalendar(2018,12,1,8,0,0), viaje1.getInicio());
    }

    @Test
    public void pruebaSetInicio()
    {
        assertEquals(true, viaje1.setInicio(new GregorianCalendar(2018,11,30,10,0,0)));
        assertEquals(true, viaje1.setInicio(new GregorianCalendar(2018,12,30,10,0,0)));
        assertEquals(false, viaje1.setInicio(new GregorianCalendar(2018,3,10,10,0,0)));
    }

    @Test
    public void probarSetDuracion()
    {
        assertEquals(true, viaje1.setDuracionViaje(40, 40));
        assertEquals(false, viaje1.setDuracionViaje(22, 43));
    }

    @Test
    public void probarSetClima()
    {
        viaje1.setClima(Clima.CALIDO);
        assertEquals(Clima.CALIDO, viaje1.getClima());
    }

    @Test
    public void probarSetBaño()
    {
        viaje1.setBaño(false);
        assertEquals(false, viaje1.getBaño());
    }
}




