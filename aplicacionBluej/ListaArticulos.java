import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.lang.Math;

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
    private ArrayList<Articulo> listaBasica;// se guarda por si la persona hace algun cambio en los daos basicos del viaje

    /**
     * Constructor for objects of class ListaArticulos
     * toma la lista basica de articulos para crear la lista del viaje
     * @param genero es un entero 0-mujer  1-hombre 
     */
    public ListaArticulos( int dias, int noches, Clima clima, boolean balneario, int genero)//debe pedir los datos del viaje duracion, baño...
    {
        if ((dias<=0) || (noches<=0) || (genero<0) || (genero>1) || (Math.abs(dias-noches)>1))
        {         
            throw new RuntimeException("datos no validos");
        }
        listaArticulos =new ArrayList<Articulo>();
        listaBasica =new ArrayList<Articulo>();
        //generar la lista basica segun sexo del usuario y datos del viaje
        generarLista( dias, noches, clima, balneario, genero, listaArticulos);
        generarLista( dias, noches, clima, balneario, genero, listaBasica);
    }

    /**
     * generar la lista del viaje 
     * del viaje y genera una lista apropiada
     * si ya existesolo debe poderse agregar 
     * 
     * @ param  Datefehca inicio, int cantidad de dias, int cantidad noche, numb clima, boolean confirmacion balnearioy lista a la quue se vana a agregar los articulos
     */
    protected void generarLista(int dias, int noches, Clima clima, boolean balneario, int genero, ArrayList<Articulo> lista)
    {
        // initialise instance variables

        if(lista==null)
        {
            lista=listaArticulos;
        }
        if( genero == 0 ){ //aca se agregan cosas que solo llevan las mujeres
            agregaArticulo( "maquillaje","podria ser algo util ;)", 100 , Prioridad.ALTA ,lista);
            agregaArticulo( "kit regla","calcula tu proxima regla y si es el caso preparate", 1 , Prioridad.MEDIA,lista);
            agregaArticulo( "utensilios manicura","esmalte,acetona,algodones,palito", 1 , Prioridad.BAJA ,lista);
            agregaArticulo( "crema corporal","", 1 , Prioridad.BAJA ,lista);
            if(dias>=3)
            {agregaArticulo( "cuchilla de afeitar","", 1 , Prioridad.MEDIA ,lista);
            }
        }else{//lo que solo llevan los hombres
            agregaArticulo( "cuchilla de afeitar","", 1 , Prioridad.MEDIA ,lista);

        }
        agregaArticulo( "documentos","identificacion, pasaporte, tarjeta de servicio militar", 1 , Prioridad.ALTA ,lista);
        agregaArticulo( "higiene oral","cepillo, crema, enjuague,hilo dental", 1 , Prioridad.ALTA ,lista);
        agregaArticulo( "cargador de celu","de las cosas mas importantes :O", 1 , Prioridad.ALTA ,lista);
        agregaArticulo( "medicamentos","si usas medicamentos a diario o algo para un dolor de cabeza sorpresa", 1 , Prioridad.ALTA ,lista);
        agregaArticulo( "toalla","dato:las de los hoteles podrian no estar tan limpias como crees", 1 , Prioridad.ALTA ,lista);
        agregaArticulo( "camara","el cargador!!! ", 1 , Prioridad.ALTA ,lista);
        agregaArticulo( "dinero en efectivo","moneda del lugar destino, intenta no cambiar en los aeropuertos(costoso)", 1 , Prioridad.ALTA ,lista);
        agregaArticulo( "tarjetas de credito","cuidado con los gastos extras innecesarios", 1 , Prioridad.ALTA ,lista);
        agregaArticulo( "celular","", 1 , Prioridad.ALTA ,lista);

        agregaArticulo( "higiene corporal","desodorante, champu, jabon, copitos de algodon", 1 , Prioridad.MEDIA ,lista);
        agregaArticulo( "protector solar","tu piel te lo agradecera", 1 , Prioridad.MEDIA ,lista);
        agregaArticulo( "perfume","con uno me parece suficiente", 1 , Prioridad.MEDIA ,lista);
        agregaArticulo( "mapa o gps","no te pierdas", 1 , Prioridad.MEDIA ,lista);
        agregaArticulo( "mochila","", 1 , Prioridad.MEDIA ,lista);
        agregaArticulo( "repelente","que los mosquitos no te alcancen", 1 , Prioridad.MEDIA ,lista);

        agregaArticulo( "paraguas","es mejor estar preparado, no?", 1 , Prioridad.BAJA ,lista);
        agregaArticulo( "cuchilla de afeitar","", 1 , Prioridad.BAJA ,lista);
        agregaArticulo( "pastillas para mereo","", 1 , Prioridad.BAJA ,lista);
        agregaArticulo( "gafas de sol","podras verte cool", 1 , Prioridad.BAJA ,lista);
        agregaArticulo( "encendedor o briket","o unos fosforos", 1 , Prioridad.BAJA ,lista);
        agregaArticulo( "papel higienico","unos cuadritos o un rollo", 1 , Prioridad.BAJA ,lista);
        agregaArticulo( "enretenimietno","libros, musica o revistas", 1 , Prioridad.BAJA ,lista);
        switch ((int) dias/2) {
            case 0 :
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, necesitas mas ropa?", 1 , Prioridad.ALTA ,lista);
            agregaArticulo( "zapatos","comodos o elegantes?", 1 , Prioridad.MEDIA ,lista);
            break; 

            case 1 :
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, necesitas mas ropa?", 3 , Prioridad.ALTA ,lista);
            agregaArticulo( "zapatos","comodos o elegantes?", 1 , Prioridad.MEDIA ,lista);
            break; 

            case 2 :
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, necesitas mas ropa?", 5 , Prioridad.ALTA ,lista);
            agregaArticulo( "zapatos","comodos o elegantes?", 2 , Prioridad.MEDIA ,lista);
            break; 

            case 3 :
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, escoge, necesitas mas ropa?", 6 , Prioridad.ALTA ,lista);
            agregaArticulo( "zapatos","comodos o elegantes?", 2 , Prioridad.MEDIA ,lista);
            break; 

            default : 
            agregaArticulo( "conjuntos de ropa","piensa en las actividades que vas a realizar, escoge, necesitas mas ropa?", 7 , Prioridad.ALTA ,lista);
            agregaArticulo( "zapatos","comodos o elegantes?", 3 , Prioridad.MEDIA ,lista);

        }
        switch ((int) noches/2) {
            case 0 :
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 1 , Prioridad.MEDIA ,lista);
            break; 

            case 1 :           
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 2 , Prioridad.MEDIA ,lista);
            break; 

            case 2 :
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 3 , Prioridad.MEDIA ,lista);
            break; 

            case 3 :
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 4 , Prioridad.MEDIA ,lista);
            break; 

            default : 
            agregaArticulo( "pijama","es mejor dormir con algo puesto por si hay alguna emergencia", 5 , Prioridad.MEDIA ,lista);
        }

        if( (clima==Clima.MUYFRIO) || (clima ==Clima.FRIO))//TODO, no se si se compare asi dos enumb
        {
            agregaArticulo( "prendas para el frio","unas bufandas, chaqueta, gorro, algo de tu estilo. ", 1 , Prioridad.ALTA ,lista);
        }
        if(balneario)
        {
            agregaArticulo( "vestidos de bano","con uno es suficiente, pero puedes llevar los que quieras", 1 , Prioridad.ALTA ,lista);
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
     * @param  nuevo articulo a agregar y la listadode se va  agregar utilice null para agregar a la lista principal de articulos
     * @return    true si se agrego exitosamente, false si no
     */
    public boolean agregaArticulo( String nombre, String descripcion, int cantidad , Prioridad prioridad ,ArrayList<Articulo> lista)
    {
        // put your code here
        if (lista ==null)
        {
            lista = listaArticulos;
        }
        try {
            if(buscarArticuloPorNombre( nombre , lista) == null){  
                if (lista ==null)
                {
                    lista = listaArticulos;
                }
                Articulo nuevoArt = new Articulo(nombre, descripcion, cantidad, prioridad);
                lista.add( nuevoArt );
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
    public boolean eliminaArticulo( String nombre , ArrayList<Articulo>lista)
    {
        if (lista ==null)
        {
            lista = listaArticulos;
        }
        Articulo articulo = buscarArticuloPorNombre( nombre , lista);
        if( articulo != null )
        {
            lista.remove(articulo);
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
    public Articulo buscarArticuloPorNombre( String nombre ,ArrayList<Articulo> lista)
    {

        if(lista==null)
        {lista=listaArticulos;

        }
        Iterator <Articulo> it = lista.iterator();
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

    /**cuando se modifica algo en los parametros de viaje se cambia la lista basica y se actualiza en el sistema
     * 
     *si miran cuales objetos de la lista basica han sido eliminados de la lista real para no volverlos a agregar,
     * 
     * @param los datos del viaje
     * 
     */
    public boolean regenerarLista(int dias, int noches, Clima clima, boolean balneario, int genero)
    {
        if ((dias<=0) || (noches<=0) || (genero<0) || (genero>1) || (Math.abs(dias-noches)>1))
        {         
            return false;
        }
        ArrayList<Articulo> listaBasicaAnterior = new ArrayList();
        listaBasicaAnterior = (ArrayList<Articulo>) listaBasica.clone();
        
        //generar la nueva lista basica con los datos nuevos
        listaBasica = new ArrayList<Articulo>(); 
        generarLista( dias, noches, clima, balneario, genero, listaBasica);
        
        ArrayList<Articulo> listaBasicaNueva = new ArrayList();
        listaBasicaNueva = (ArrayList<Articulo>) listaBasica.clone();//se crea un clonpara no modificar la verdadera lista nueva por si llega a hacer mas cambio luego el usuario
        //buscamos los articulos de la ListaBasica que hayan sido borrados de la ListaArticulos
        
        Iterator <Articulo> it = listaBasicaAnterior.iterator();
        while(it.hasNext())//recorremos la anterior lista basica mirando si borraros articulos para quitarlos de la lista que se va a agregar uego
        {
            Articulo art = it.next();

            if(buscarArticuloPorNombre(art.getNombre(), null )==null)// si el resultadoes null es porque noencontroel articulo en la listaArticulos por lo tanto fue borrado de la lista asi que no lo volvemos a agregar()
            {
                listaBasicaNueva.remove( buscarArticuloPorNombre(art.getNombre(), listaBasicaNueva) );

            }
            listaArticulos.remove( buscarArticuloPorNombre(art.getNombre(), null) );
        }
        it = listaBasicaNueva.iterator();
        while(it.hasNext())//los articulos que quedaron el la nueva lista se agregan a la listaArticulos
        {
            Articulo art = it.next();
            listaArticulos.add(art);
        }
        return true;
    }

    /**
     * codigo para poder clonar los objeto, realmente es de la clase object
     */
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }

    /**
     * metodo para imprimir la lista actual de articulos
     */
    public void imprimirLista()
    {
        Iterator <Articulo> it = listaArticulos.iterator();
         System.out.println("               ");
        while(it.hasNext())//los articulos que quedaron el la nueva lista se agregan a la listaArticulos
        {
            Articulo art = it.next();
            
            System.out.println(art.getNombre());
        }
    }
}
