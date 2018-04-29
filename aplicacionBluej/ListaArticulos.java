import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.lang.Math;
import java.lang.Cloneable;
/**
 * lista de articulos modela una lista con los articulos generada
 * principalmente con datos basicos a la cual l se le pueden
 * agregar o quitar elementos
 * jusificacion de esta clase:(seguridad) poder hacer programacion defensiva a la hora de agregar elementos a la lista, puesto que si es un 
 * atributo en viaje podria agregar elementos de forma descontrolada, tambien quitarle obligaciones a la clase viajes.
 * 
 * @author Sebastian Carrillo - Jhon Melendez 
 * @version v1
 */
public class ListaArticulos
{
    // instance variables - replace the example below with your own
    private ArrayList<Articulo> listaArticulos;

    /**
     * Constructor for objects of class ListaArticulos
     * toma la lista basica de articulos para crear la lista del viaje
     * @param genero es un entero 0-mujer  1-hombre 
     */
    public ListaArticulos( int dias, int noches, Clima clima, boolean balneario, int genero)//debe pedir los datos del viaje duracion, baño...
    {
        // initialise instance variables
        listaArticulos =new ArrayList<Articulo>();
        //generar la lista basica segun sexo del usuario y datos del viaje
        generarLista( dias, noches, clima, balneario, genero);
    }
    
    /**
     * generar la lista del viaje
     * ojooo solo se debe generar una vez,toma los datos 
     * del viaje y genera una lista apropiada
     * si ya existesolo debe poderse agregar 
     * 
     * @ param  Datefehca inicio, int cantidad de dias, int cantidad noche, numb clima, boolean confirmacion balneario
     */
    protected void generarLista(int dias, int noches, Clima clima, boolean balneario, int genero)
    {
        // initialise instance variables
        if( genero == 0 ){ //aca se agregan cosas que solo llevan las mujeres
            agregaArticulo( "maquillaje","podria ser algo util ;)", 100 , Prioridad.ALTA );
            agregaArticulo( "kit regla","calcula tu proxima regla y si es el caso preparate", 1 , Prioridad.MEDIA);
            agregaArticulo( "utensilios manicura","esmalte,acetona,algodones,palito", 1 , Prioridad.BAJA );
            agregaArticulo( "crema corporal","", 1 , Prioridad.BAJA );
            if(dias>=3)
            {agregaArticulo( "cuchilla de afeitar","", 1 , Prioridad.MEDIA );
            }
        }else{//lo que solo llevan los hombres
            agregaArticulo( "cuchilla de afeitar","", 1 , Prioridad.MEDIA );

        }
        agregaArticulo( "documentos","identificacion, pasaporte, tarjeta de servicio militar", 1 , Prioridad.ALTA );
        agregaArticulo( "higiene oral","cepillo, crema, enjuague,hilo dental", 1 , Prioridad.ALTA );
        agregaArticulo( "cargador de celu","de las cosas mas importantes :O", 1 , Prioridad.ALTA );
        agregaArticulo( "medicamentos","si usas medicamentos a diario o algo para un dolor de cabeza sorpresa", 1 , Prioridad.ALTA );
        agregaArticulo( "toalla","dato:las de los hoteles podrian no estar tan limpias como crees", 1 , Prioridad.ALTA );
        agregaArticulo( "camara","el cargador!!! ", 1 , Prioridad.ALTA );
        agregaArticulo( "dinero en efectivo","moneda del lugar destino, intenta no cambiar en los aeropuertos(costoso)", 1 , Prioridad.ALTA );
        agregaArticulo( "tarjetas de credito","cuidado con los gastos extras innecesarios", 1 , Prioridad.ALTA );
        agregaArticulo( "celular","", 1 , Prioridad.ALTA );

        agregaArticulo( "higiene corporal","desodorante, champu, jabon, copitos de algodon", 1 , Prioridad.MEDIA );
        agregaArticulo( "protector solar","tu piel te lo agradecera", 1 , Prioridad.MEDIA );
        agregaArticulo( "perfume","con uno me parece suficiente", 1 , Prioridad.MEDIA );
        agregaArticulo( "mapa o gps","no te pierdas", 1 , Prioridad.MEDIA );
        agregaArticulo( "mochila","", 1 , Prioridad.MEDIA );
        agregaArticulo( "repelente","que los mosquitos no te alcancen", 1 , Prioridad.MEDIA );

        agregaArticulo( "paraguas","es mejor estar preparado, no?", 1 , Prioridad.BAJA );
        agregaArticulo( "cuchilla de afeitar","", 1 , Prioridad.BAJA );
        agregaArticulo( "pastillas para mereo","", 1 , Prioridad.BAJA );
        agregaArticulo( "gafas de sol","podras verte cool", 1 , Prioridad.BAJA );
        agregaArticulo( "encendedor o briket","o unos fosforos", 1 , Prioridad.BAJA );
        agregaArticulo( "papel higienico","unos cuadritos o un rollo", 1 , Prioridad.BAJA );
        agregaArticulo( "enretenimietno","libros, musica o revistas", 1 , Prioridad.BAJA );
        switch ((int) dias/2) {
            case 0 :
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, necesitas mas ropa?", 1 , Prioridad.ALTA );
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 1 , Prioridad.MEDIA );
            agregaArticulo( "zapatos","comodos o elegantes?", 1 , Prioridad.MEDIA );
            break; 

            case 1 :
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, necesitas mas ropa?", 3 , Prioridad.ALTA );
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 2 , Prioridad.MEDIA );
            agregaArticulo( "zapatos","comodos o elegantes?", 1 , Prioridad.MEDIA );
            break; 

            case 2 :
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, necesitas mas ropa?", 5 , Prioridad.ALTA );
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 3 , Prioridad.MEDIA );
            agregaArticulo( "zapatos","comodos o elegantes?", 2 , Prioridad.MEDIA );
            break; 

            case 3 :
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, escoge, necesitas mas ropa?", 6 , Prioridad.ALTA );
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 4 , Prioridad.MEDIA );
            agregaArticulo( "zapatos","comodos o elegantes?", 2 , Prioridad.MEDIA );
            break; 

            default : 
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, escoge, necesitas mas ropa?", 7 , Prioridad.ALTA );

            agregaArticulo( "zapatos","comodos o elegantes?", 3 , Prioridad.MEDIA );agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 5 , Prioridad.MEDIA );
        }
        if( (clima==Clima.MUYFRIO) || (clima ==Clima.FRIO))//TODO, no se si se compare asi dos enumb
        {
            agregaArticulo( "prendas para el frio","unas bufandas, chaqueta, gorro, algo de tu estilo. ", 1 , Prioridad.ALTA );
        }
        if(balneario)
        {
            agregaArticulo( "vestidos de bano","con uno es suficiente, pero puedes llevar los que quieras", 1 , Prioridad.ALTA );
        }
    }

    /**
     * devuelve un clon de la lista
     * 
     * @return    ArrayList<Articulo> un clon de la lista
     */
    public ArrayList<Articulo> getListaArticulos()
    {
        // put your code here
        return (ArrayList<Articulo>) listaArticulos.clone();
    }

    /**
     * agrega un articulo lista de articulos
     * debe validar que el elemento no se haya agregado ya, comparar...
     * 
     * @param  nuevo articulo a agregar
     * @return    true si se agrego exitosamente, false si no
     */
    public boolean agregaArticulo( String nombre, String descripcion, int cantidad , Prioridad prioridad )
    {
        // put your code here
        try {
            if(buscarArticuloPorNombre( nombre ) == null){  
                Articulo nuevoArt = new Articulo(nombre, descripcion, cantidad, prioridad);
                listaArticulos.add( nuevoArt );
                return true;
            }
            else{return false;}
        } catch (RuntimeException e) {
            //System.out.println("holaaaaaaaaaaaaaaa");
            return false;
        } 
    }

    /**
     * elimina una actividad deseada
     *  
     * @param  articulo a eliminar
     * @return    true si se elimino exitosamente, false si no
     */
    public boolean eliminaArticulo( String nombre )
    {
        Articulo articulo = buscarArticuloPorNombre( nombre );
        if( articulo != null )
        {
            return true;
        }
        return false;
    }

    /**
     * encontrar articulo segun indice
     * 
     * @param  nombre del articulo
     * @return    actividad encontrada o null
     */
    public Articulo buscarArticuloPorNombre( String nombre )
    {

        Iterator <Articulo> it = listaArticulos.iterator();
        while(it.hasNext())
        {
            Articulo art = it.next();
            String nomb = nombre.trim().toUpperCase();
            if( art.getNombre().equals(nomb))
            {
                return art;
            }
        }
        return null;
    }
}
