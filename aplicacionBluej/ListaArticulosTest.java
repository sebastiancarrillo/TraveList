
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class ListaArticulosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaArticulosTest
{
    /**
     * Default constructor for test class ListaArticulosTest
     */
    public ListaArticulosTest()
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
    public void pruebaAgregaArticulo()
    {
        ListaArticulos listaArt1 = new ListaArticulos(10, 9, Clima.FRIO, true, 0);
        assertEquals(true, listaArt1.agregaArticulo("prueba", "k", 9, Prioridad.BAJA,null));
        assertEquals(false, listaArt1.agregaArticulo("prueba", "k", 10, Prioridad.MEDIA,null));
        assertEquals(false, listaArt1.agregaArticulo("2", "ka", 10, Prioridad.BAJA,null));
    }

    @Test
    public void pruebaEliminaArticulo()
    {
        ListaArticulos listaArt1 = new ListaArticulos(10, 9, Clima.FRIO, true, 0);
        assertEquals(true, listaArt1.agregaArticulo("a", "j", 10, Prioridad.ALTA,null));
        assertEquals(false, listaArt1.eliminaArticulo("o"));
        assertEquals(true, listaArt1.eliminaArticulo("a"));
    }

    @Test
    public void pruebaBuscaArticuloPorNombre()
    {
        ListaArticulos listaArt1 = new ListaArticulos(10, 10, Clima.FRIO, true, 0);
        assertEquals(true, listaArt1.agregaArticulo("a", "k", 47, Prioridad.BAJA,null));
        assertEquals(null, listaArt1.buscarArticuloPorNombre("kkk"));
        Articulo prueba = listaArt1.buscarArticuloPorNombre("a");
        assertEquals(prueba, listaArt1.buscarArticuloPorNombre("a"));
    }

    @Test
    public void pruebaGenerarLista()
    {
        ListaArticulos listaArt1 = new ListaArticulos(10, 10, Clima.FRIO, true, 0);
        assertEquals(true, listaArt1.eliminaArticulo("maquillaje"));
        assertEquals(true, listaArt1.eliminaArticulo("CUCHILLA DE AFEITAR"));
        assertEquals(true, listaArt1.eliminaArticulo("PRENDAS PARA EL FRIO"));
        assertEquals(true, listaArt1.eliminaArticulo("VESTIDOS DE BANO"));
        assertEquals(7, listaArt1.buscarArticuloPorNombre("CONJUNTOS DE ROPA").getCantidad());
        ListaArticulos listaArt2 = new ListaArticulos(1, 1, Clima.MUYCALIDO, true, 1);
        assertEquals(false, listaArt2.eliminaArticulo("maquillaje"));
        assertEquals(true, listaArt2.eliminaArticulo("CUCHILLA DE AFEITAR"));
        assertEquals(false, listaArt2.eliminaArticulo("PRENDAS PARA EL FRIO"));
        assertEquals(true, listaArt2.eliminaArticulo("VESTIDOS DE BANO"));
        assertEquals(1, listaArt2.buscarArticuloPorNombre("CONJUNTOS DE ROPA").getCantidad());
        ListaArticulos listaArt3 = new ListaArticulos(1, 1, Clima.MUYCALIDO, false, 1);
        assertEquals(false, listaArt3.eliminaArticulo("VESTIDOS DE BANO"));
    }

    @Test
    public void pruebaGetListaArticulos()
    {
        ListaArticulos listaArt1 = new ListaArticulos(10, 10, Clima.FRIO, true, 0);
        ArrayList<Articulo> ar = listaArt1.getListaArticulos();
        ar.add(new Articulo("a", "b", 1, Prioridad.ALTA));
        assertNotEquals(ar, listaArt1.getListaArticulos());//probamos si agregandole un articulo al clon cambia la lista interna de lista de articulos 
    }
}



