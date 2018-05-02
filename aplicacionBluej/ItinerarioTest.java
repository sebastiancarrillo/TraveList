import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Time;
import java.util.ArrayList;

/**
 * The test class ItinerarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItinerarioTest
{
    Itinerario prueba;
    /**
     * Default constructor for test class ItinerarioTest
     */
    public ItinerarioTest()
    {
        prueba = new Itinerario(10);
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
    public void puebaAgregaActividad(){
        assertEquals(true, prueba.agregaActividad(new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",
                    4, 4, 10, new Time(18,0,0), new Time(18,0,0))));
        assertEquals(true, prueba.agregaActividad(new Actividad("Caminar","Salir a caminar",
                    4, 4, 10, new Time(16,0,0), new Time(18,0,0))));
        assertEquals(false, prueba.agregaActividad(new Actividad("Nadar","Nadar en la playa",
                    4, 4, 10, new Time(17,0,0), new Time(19,0,0))));                                
    }

    @Test
    public void pruebaBuscarActividadPorNombre()
    {
        ArrayList<Actividad> lista = new ArrayList();      
        Actividad actividad = new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",4, 4, 10, new Time(18,0,0), new Time(18,0,0));
        lista.add(actividad);
        prueba.agregaActividad(actividad);
        prueba.agregaActividad(new Actividad("Caminar","Salir a caminar",4, 4, 10, new Time(16,0,0), new Time(18,0,0)));
        assertEquals(lista,prueba.buscarActividadPorNombre("Rumbear"));
    }

    @Test
    public void pruebaSetDuracion(){
        ArrayList<Actividad> lista = new ArrayList();       
        Actividad actividad = new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",
                9, 9, 10, new Time(18,0,0), new Time(18,0,0));
        prueba.agregaActividad(actividad);
        prueba.agregaActividad(new Actividad("Caminar","Salir a caminar",
                4, 4, 10, new Time(16,0,0), new Time(18,0,0)));
        prueba.setDuracion(8);
        assertEquals(lista,prueba.buscarActividadPorNombre("Rumbear"));
    }
}