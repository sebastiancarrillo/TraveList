import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
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
        prueba = new Itinerario(new Date(2018,5,2,8,30), new Date(2018,5,10,7,30));
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
        assertEquals(true, prueba.agregaActividad(new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",2018,5,5,6,
                               15,8,30,30,new Date(2018,5,2,8,0),new Date(2018,5,10,7,30))));
        assertEquals(true, prueba.agregaActividad(new Actividad("Caminar","Salir a caminar",2018,5,6,7,
                               15,8,30,30,new Date(2018,5,2,8,0),new Date(2018,5,10,7,30))));
        assertEquals(false, prueba.agregaActividad(new Actividad("Nadar","Nadar en la playa",2018,5,6,8,
                               12,8,30,30,new Date(2018,5,2,8,0),new Date(2018,5,10,7,30))));                                
    }

    @Test
    public void pruebaBuscarActividadPorNombre()
    {     
        Actividad actividad = new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",2018,5,5,6,
                               15,8,30,30,new Date(2018,5,2,8,0),new Date(2018,5,10,7,30));
        prueba.agregaActividad(actividad);
        prueba.agregaActividad(new Actividad("Caminar","Salir a caminar",2018,5,6,7,
                               15,8,30,30,new Date(2018,5,2,8,0),new Date(2018,5,10,7,30)));
        assertEquals(actividad,prueba.buscarActividadPorNombre("Rumbear"));
        assertEquals(null,prueba.buscarActividadPorNombre("Hola"));
    }

    @Test
    public void pruebaSetFechaViaje(){   
        Actividad actividad = new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",2018,5,5,6,
                               15,8,30,30,new Date(2018,5,2,8,0),new Date(2018,5,10,7,30));
        prueba.agregaActividad(actividad);
        Actividad actividad2 = new Actividad("Caminar","Salir a caminar",2018,5,6,7,
                               15,6,30,30,new Date(2018,5,2,8,0),new Date(2018,5,10,7,30));
        prueba.agregaActividad(actividad2);
        prueba.setFechaViaje(new Date(2018,5,6,0,0),new Date(2018,5,10,7,30));
        assertEquals(null,prueba.buscarActividadPorNombre("Rumbear"));
        assertEquals(actividad2, prueba.buscarActividadPorNombre("Caminar"));
    }
}