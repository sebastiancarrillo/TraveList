

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaViajesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaViajesTest
{
    ListaViajes lista;
    Viaje viaje = new Viaje(2018, 12, 1, 8, 10, 11, Clima.FRIO, true, 0,"elmejor");
    /**
     * Default constructor for test class ListaViajesTest
     */
    public ListaViajesTest()
    {
        lista= new ListaViajes();        
        lista.agregarViaje(viaje);
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
    public void probarAgregarUnViaje()
    {
        assertEquals(true, lista.agregarViaje(viaje));
    }

    @Test
    public void probarEliminar()
    {
        Viaje vi = lista.buscarViajeNombre("ELMEJOR");
        assertEquals(true,lista.eliminarViaje(vi));
        vi = lista.buscarViajeNombre("ELMEJOd");
        assertEquals(false,lista.eliminarViaje(vi));
    }
    @Test
    public void probarBuscar()
    {
        Viaje vi = lista.buscarViajeNombre("elmejor");
        assertEquals(vi,lista.buscarViajeNombre("elmejor"));
        assertEquals(null,lista.buscarViajeNombre("zsvasv"));
    }
}


