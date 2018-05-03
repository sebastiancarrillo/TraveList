import java.util.Date;
/**
 * Write a description of class prueba here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class prueba
{
    public static void main(String[] args){
        Actividad prueba = new Actividad("Rumbear","Salir a tomar y bailar con unos amigos",2018,5,5,6,8,15,30,30,new Date(2018,5,2,3,0),new Date(2018,5,7,8,0));
        boolean hola = prueba.setInicio(2,4,30);
        //boolean hola = prueba.validaFecha(new Date(2018,5,2,4,30), new Date(2018,5,6,15,30), new Date(2018,5,2,3,0), new Date(2018,5,7,8,0));
        System.out.println(hola);
    }
}
