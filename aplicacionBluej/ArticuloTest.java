

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArticuloTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArticuloTest
{
    /**
     * Default constructor for test class ArticuloTest
     */
    public ArticuloTest()
    {
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
        Articulo articulo1 = new Articulo("articulo", "articulo de prueba", 5, Prioridad.ALTA);
        assertEquals("articulo de prueba", articulo1.getDescripcion());
        assertEquals(false, articulo1.getEstado());
        assertEquals("ARTICULO", articulo1.getNombre());
        assertEquals(Prioridad.ALTA, articulo1.getPrioriad());
    }

    @Test
    public void pruebaMetodosSet()
    {
        Articulo articulo1 = new Articulo("articulo", "articulo de prueba", 10, Prioridad.ALTA);
        assertEquals(true, articulo1.setCantidad(20));
        assertEquals(20, articulo1.getCantidad());
        assertEquals(false, articulo1.setCantidad(0));
        assertEquals(false, articulo1.setCantidad(-1));
        articulo1.setDescripcion("cambio");
        assertEquals("cambio", articulo1.getDescripcion());
        articulo1.setEstado(true);
        assertEquals(true, articulo1.getEstado());
        assertEquals(true, articulo1.setNombre("juanIto"));
        assertEquals("JUANITO", articulo1.getNombre());
        assertEquals(false, articulo1.setNombre("juan2ito"));
        assertEquals(false, articulo1.setNombre("juankkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"));
        assertEquals(false, articulo1.setNombre(""));
        articulo1.setPrioridad(Prioridad.BAJA);
        assertEquals(Prioridad.BAJA, articulo1.getPrioriad());
    }

    @Test
    public void pruebaValidaNombre()
    {
        Articulo articulo1 = new Articulo("prueba", "prueba", 10, Prioridad.MEDIA);
        assertEquals(true, articulo1.validaNombre("juan"));
        assertEquals(false, articulo1.validaNombre("2j"));
        assertEquals(false, articulo1.validaNombre("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"));
        assertEquals(true, articulo1.validaNombre("aaaaaaaaaaaaaaaaaaa"));
        assertEquals(true, articulo1.validaNombre("aaaaaaaaaaaaaaaaaaaa"));
        assertEquals(false, articulo1.validaNombre("aaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(true, articulo1.validaNombre("jshf"));
        assertEquals(false, articulo1.validaNombre(""));
    }
}






