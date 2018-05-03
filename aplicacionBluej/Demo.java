import java.util.Scanner;
import java.util.ArrayList;
import java.sql.Time;
/**
 * Write a description of class Demo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demo
{
    public static void main(String[] args){
        Articulo articulo = null;
        Actividad actividad = null;
        Viaje viaje = null;
        ListaViajes viajes = null;
        ListaArticulos articulos = null;
        ArrayList<String> actividadesString = new ArrayList();
        Clima clima = Clima.TEMPLADO;
        Prioridad prioridad = Prioridad.MEDIA;
        Itinerario itinerario = null;
        boolean resp, balneario, mantenerse, hay=false, nadamas;
        int añoIni, mesIni, diaIni, dias, noches, genero, climAns, cantidad, prioridAns, resp2, diaFin, horaIni, horaFin;
        String nombreViaje, descripcion, nombreArticulo="", nombreActividad="";
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in);
        Scanner reader3 = new Scanner(System.in);
        mantenerse = true;
        while(mantenerse){
            System.out.println("Desea seleccionar un viaje o agregar un nuevo? Seleccionar=true o Agregar=false");
            resp = reader3.nextBoolean();
            if (resp){ 
                hay = false;
                while (!hay){
                    System.out.println("Buscar el viaje por el nombre:");
                    hay = false;
                    nombreViaje = reader.next();
                    viaje = viajes.buscarViajeNombre(nombreViaje); 
                    if (viaje != null){
                        hay = true;
                    }
                }       
                System.out.println("Desea ingresar al itinerario o a la lista de articulos? Itinerario=true o Articulos=false");
                resp = reader3.nextBoolean();
                if(resp){
                    itinerario = viaje.getItinerario();
                    System.out.println("Desea agregar, modificar, eliminar alguna actividad o salir?");
                    resp2 = reader2.nextInt();
                    switch (resp2){
                        case 1:{
                            System.out.println("Ingrese el nombre de la actividad");
                            nombreActividad = reader.next();
                            System.out.println("Ingrese la descripcion de la actividad");
                            descripcion = reader.next();
                            System.out.println("Ingrese el dia de inicio");
                            diaIni = reader2.nextInt();
                            System.out.println("Ingrese el dia final");
                            diaFin = reader2.nextInt();
                            System.out.println("Ingrese la hora de inicio");
                            horaIni = reader2.nextInt();
                            System.out.println("Ingrese la hora final");
                            horaFin = reader2.nextInt();
                            itinerario.agregaActividad(new Actividad(nombreActividad,descripcion, diaIni, diaFin, viaje.getDuracionViaje()[1], new Time(horaIni,0,0), new Time(horaFin,0,0)));     
                            break;
                        } 
                        case 2:{
                            hay = false;
                            while (!hay){
                                System.out.println("Buscar el actividad por el nombre:");
                                hay = false;
                                nombreActividad = reader.next();
                                actividad = itinerario.buscarActividadPorNombre(nombreActividad);
                                if (actividad != null){
                                    hay = true;
                                }
                            }
                            nadamas = false;
                            while (nadamas){
                                System.out.println("Que desea modificar: Nombre=1,Descripcion=2,Dia inicio=3,Dia Fin=4,Hora inicio=5, Hora fin=6 o Fin=7");
                                resp2 = reader2.nextInt();
                                switch(resp2){
                                    case 1: {
                                        System.out.println("Ingrese el nuevo nombre");
                                        nombreActividad = reader.next();
                                        actividad.setNombre(nombreActividad);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Ingrese la nueva descripcion");
                                        descripcion = reader.next();
                                        actividad.setDescripcion(descripcion);
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Ingrese el nuevo dia de inicio");
                                        diaIni = reader2.nextInt();
                                        actividad.setDiaInicio(diaIni);
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Ingrese el nuevo dia final");
                                        diaFin = reader2.nextInt();
                                        actividad.setDiaFin(diaFin);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Ingrese la hora de inicio");
                                        horaIni = reader2.nextInt();
                                        actividad.setHoraInicio(new Time(horaIni,0,0));
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Ingrese la hora final");
                                        horaFin = reader2.nextInt();
                                        actividad.setHoraFin(new Time(horaFin,0,0));
                                        break;
                                    }
                                    case 7: nadamas = true; break;
                                }
                            }
                            break;
                        }
                        case 3:{
                            hay = false;
                            while (!hay){
                                System.out.println("Buscar la actividad por el nombre:");
                                hay = false;
                                nombreActividad = reader.next();
                                actividad = itinerario.buscarActividadPorNombre(nombreActividad);
                                if (actividad != null){
                                    itinerario.eliminaActividad(actividad);
                                    hay = true;
                                }
                            }
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Estos son los articulos que usted deberia llevar:");
                    articulos = viaje.getListaArticulos();
                    articulos.imprimirLista();
                    System.out.println("Desea añadir, modificar o eliminar articulos? Añadir=1, Modificar=2, Eliminar=3");
                    resp2 = reader2.nextInt();
                    switch (resp2){
                        case 1:{
                            System.out.println("Ingrese el nombre del articulo");
                            nombreArticulo = reader.next();
                            System.out.println("Ingrese la descripcion del articulo");
                            descripcion = reader.next();
                            System.out.println("Ingrese la cantidad de articulos");
                            cantidad = reader2.nextInt();
                            System.out.println("Seleccione la prioridad: Baja=1, Media=2, Alta=3");
                            prioridAns = reader2.nextInt();
                            switch (prioridAns){
                                case 1: prioridad = Prioridad.BAJA; break;
                                case 2: prioridad = Prioridad.MEDIA; break;
                                case 3: prioridad = Prioridad.ALTA; break;
                            }
                            articulos.agregaArticulo(nombreArticulo,descripcion,cantidad,prioridad,articulos.getListaArticulos());     
                            break;
                        } 
                        case 2:{
                            hay = false;
                            while (!hay){
                                System.out.println("Buscar el articulo por el nombre:");
                                hay = false;
                                nombreArticulo = reader.next();
                                articulo = articulos.buscarArticuloPorNombre(nombreArticulo,articulos.getListaArticulos());
                                if (articulo != null){
                                    hay = true;
                                }
                            }
                            nadamas = false;
                            while (nadamas){
                                System.out.println("Que desea modificar: Nombre=1,Descripcion=2,Cantidad=3,Estado=4,Prioridad=5 y Fin=6");
                                resp2 = reader2.nextInt();
                                switch(resp2){
                                    case 1: {
                                        System.out.println("Ingrese el nuevo nombre");
                                        nombreArticulo = reader.next();
                                        articulo.setNombre(nombreArticulo);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Ingrese la nueva descripcion");
                                        descripcion = reader.next();
                                        articulo.setDescripcion(descripcion);
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Ingrese la nueva cantidad");
                                        cantidad = reader2.nextInt();
                                        articulo.setCantidad(cantidad);
                                        break;                                    
                                    }
                                    case 4: {
                                        System.out.println("Ingrese el nuevo estado: Empacado=true o Por empacar=false");
                                        resp = reader3.nextBoolean();
                                        articulo.setEstado(resp);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Ingrese la prioridad. Baja=1, Media=2, Alta=3");
                                        resp2 = reader2.nextInt();
                                        switch(resp2){
                                            case 1: prioridad = Prioridad.BAJA; break;
                                            case 2: prioridad = Prioridad.MEDIA; break;
                                            case 3: prioridad = Prioridad.ALTA; break;
                                        }
                                        articulo.setPrioridad(prioridad);
                                        break;
                                    }
                                    case 6: nadamas = true; break;
                                }
                            }
                            break;
                        }
                        case 3:{
                            hay = false;
                            while (!hay){
                                System.out.println("Buscar el articulo por el nombre:");
                                hay = false;
                                nombreArticulo = reader.next();
                                articulo = articulos.buscarArticuloPorNombre(nombreArticulo,articulos.getListaArticulos());
                                if (articulo != null){
                                    articulos.eliminaArticulo(nombreArticulo,articulos.getListaArticulos());
                                    hay = true;
                                }
                            }
                            break;
                        }
                    } 
                }
            }
            else{
                System.out.println("Ingrese el nombre del viaje");
                nombreViaje = reader.next();
                System.out.println("Seleccione su sexo, hombre=1 o mujer=0");
                genero = reader2.nextInt();
                System.out.println("Seleccione el año");
                añoIni = reader2.nextInt();
                System.out.println("Seleccione el mes");
                mesIni = reader2.nextInt();
                System.out.println("Seleccione el dia");
                diaIni = reader2.nextInt();
                System.out.println("Seleccione el numero de dias");
                dias = reader2.nextInt();
                System.out.println("Seleccione el numero de noches");
                noches = reader2.nextInt();
                System.out.println("Seleccione el tipo de clima de lugar.");
                System.out.println("Muy frio=1, Frio=2, Templado=3, Calido=4, Muy calido=5");
                climAns = reader2.nextInt();
                switch (climAns){
                    case 1: clima = Clima.MUYFRIO; break;
                    case 2: clima = Clima.FRIO; break;
                    case 3: clima = Clima.TEMPLADO; break;
                    case 4: clima = Clima.CALIDO; break;
                    case 5: clima = Clima.MUYCALIDO; break;              
                }
                System.out.println("En el lugar hay balneario? Si=true o No=false");
                balneario = reader3.nextBoolean();
                viajes = new ListaViajes();
                viaje = new Viaje(añoIni,mesIni,diaIni,dias,noches,clima,balneario,genero,nombreViaje);
                viajes.agregarViaje(viaje);
                System.out.println("Desea ingresar a la lista de articulos o al itinerario? Articulos=true o Itinerario=false");
                resp = reader3.nextBoolean();
                if(resp){
                    System.out.println("Estos son los articulos que usted deberia llevar:");
                    articulos = viaje.getListaArticulos();
                    articulos.imprimirLista();
                    System.out.println("Desea añadir, modificar o eliminar articulos? Añadir=1, Modificar=2, Eliminar=3");
                    resp2 = reader2.nextInt();
                    switch (resp2){
                        case 1:{
                            System.out.println("Ingrese el nombre del articulo");
                            nombreArticulo = reader.next();
                            System.out.println("Ingrese la descripcion del articulo");
                            descripcion = reader.next();
                            System.out.println("Ingrese la cantidad de articulos");
                            cantidad = reader2.nextInt();
                            System.out.println("Seleccione la prioridad: Baja=1, Media=2, Alta=3");
                            prioridAns = reader2.nextInt();
                            switch (prioridAns){
                                case 1: prioridad = Prioridad.BAJA; break;
                                case 2: prioridad = Prioridad.MEDIA; break;
                                case 3: prioridad = Prioridad.ALTA; break;
                            }
                            articulos.agregaArticulo(nombreArticulo,descripcion,cantidad,prioridad,articulos.getListaArticulos());     
                            break;
                        } 
                        case 2:{
                            hay = false;
                            while (!hay){
                                System.out.println("Buscar el articulo por el nombre:");
                                hay = false;
                                nombreArticulo = reader.next();
                                articulo = articulos.buscarArticuloPorNombre(nombreArticulo,articulos.getListaArticulos());
                                if (articulo != null){
                                    hay = true;
                                }
                            }
                            nadamas = false;
                            while (nadamas){
                                System.out.println("Que desea modificar: Nombre=1,Descripcion=2,Cantidad=3,Estado=4,Prioridad=5 y Fin=6");
                                resp2 = reader2.nextInt();
                                switch(resp2){
                                    case 1: {
                                        System.out.println("Ingrese el nuevo nombre");
                                        nombreArticulo = reader.next();
                                        articulo.setNombre(nombreArticulo);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Ingrese la nueva descripcion");
                                        descripcion = reader.next();
                                        articulo.setDescripcion(descripcion);
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Ingrese la nueva cantidad");
                                        cantidad = reader2.nextInt();
                                        articulo.setCantidad(cantidad);
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Ingrese el nuevo estado: Empacado=true o Por empacar=false");
                                        resp = reader3.nextBoolean();
                                        articulo.setEstado(resp);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Ingrese la prioridad. Baja=1, Media=2, Alta=3");
                                        resp2 = reader2.nextInt();
                                        switch(resp2){
                                            case 1: prioridad = Prioridad.BAJA;
                                            case 2: prioridad = Prioridad.MEDIA;
                                            case 3: prioridad = Prioridad.ALTA;
                                        }
                                        articulo.setPrioridad(prioridad);
                                        break;
                                    }
                                    case 6: nadamas = true; break;
                                }
                            }
                            break;
                        }
                        case 3:{
                            hay = false;
                            while (!hay){
                                System.out.println("Buscar el articulo por el nombre:");
                                hay = false;
                                nombreArticulo = reader.next();
                                articulo = articulos.buscarArticuloPorNombre(nombreArticulo,articulos.getListaArticulos());
                                if (articulo != null){
                                    hay = true;
                                }
                            }
                            articulos.eliminaArticulo(nombreArticulo,articulos.getListaArticulos());
                            break;
                        }
                    }
                }
                else{
                    actividadesString.add("Nadar");
                    actividadesString.add("Skiar");
                    actividadesString.add("Hacer Torrentismo");
                    actividadesString.add("Escalar");
                    actividadesString.add("Caminar");
                    for (String actividadNombre:actividadesString){
                        System.out.println("Usted quiere " + actividadNombre + "? Si=True o No=False");
                        resp = reader3.nextBoolean();
                        if (resp){
                            System.out.println("Ingrese la descripcion de la actividad");
                            descripcion = reader.next();
                            System.out.println("Ingrese el dia de incio");
                            diaIni = reader2.nextInt();
                            System.out.println("Ingrese el dia final");
                            diaFin = reader2.nextInt();
                            System.out.println("Ingrese la hora de inicio");
                            horaIni = reader2.nextInt();
                            System.out.println("Ingrese la hora de finalizacion");
                            horaFin = reader2.nextInt();
                            itinerario.agregaActividad(new Actividad(actividadNombre,descripcion, diaIni, diaFin, viaje.getDuracionViaje()[1], new Time(horaIni,0,0), new Time(horaFin,0,0)));
                        }
                    }
                    System.out.println("Desea agregar, modificar, eliminar alguna actividad o salir?");
                    resp2 = reader2.nextInt();
                    switch (resp2){
                        case 1:{
                            System.out.println("Ingrese el nombre de la actividad");
                            nombreActividad = reader.next();
                            System.out.println("Ingrese la descripcion de la actividad");
                            descripcion = reader.next();
                            System.out.println("Ingrese el dia de inicio");
                            diaIni = reader2.nextInt();
                            System.out.println("Ingrese el dia final");
                            diaFin = reader2.nextInt();
                            System.out.println("Ingrese la hora de inicio");
                            horaIni = reader2.nextInt();
                            System.out.println("Ingrese la hora final");
                            horaFin = reader2.nextInt();
                            itinerario.agregaActividad(new Actividad(nombreActividad,descripcion, diaIni, diaFin, viaje.getDuracionViaje()[1], new Time(horaIni,0,0), new Time(horaFin,0,0)));     
                            break;
                        } 
                        case 2:{
                            hay = false;
                            while (!hay){
                                System.out.println("Buscar el actividad por el nombre:");
                                hay = false;
                                nombreActividad = reader.next();
                                actividad = itinerario.buscarActividadPorNombre(nombreActividad);
                                if (actividad != null){
                                    hay = true;
                                }
                            }
                            nadamas = false;
                            while (nadamas){
                                System.out.println("Que desea modificar: Nombre=1,Descripcion=2,Dia inicio=3,Dia Fin=4,Hora inicio=5, Hora fin=6 o Fin=7");
                                resp2 = reader2.nextInt();
                                switch(resp2){
                                    case 1: {
                                        System.out.println("Ingrese el nuevo nombre");
                                        nombreActividad = reader.next();
                                        actividad.setNombre(nombreActividad);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Ingrese la nueva descripcion");
                                        descripcion = reader.next();
                                        actividad.setDescripcion(descripcion);
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Ingrese el nuevo dia de inicio");
                                        diaIni = reader2.nextInt();
                                        actividad.setDiaInicio(diaIni);
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Ingrese el nuevo dia final");
                                        diaFin = reader2.nextInt();
                                        actividad.setDiaFin(diaFin);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Ingrese la hora de inicio");
                                        horaIni = reader2.nextInt();
                                        actividad.setHoraInicio(new Time(horaIni,0,0));
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Ingrese la hora final");
                                        horaFin = reader2.nextInt();
                                        actividad.setHoraFin(new Time(horaFin,0,0));
                                        break;
                                    }
                                    case 7: nadamas = true; break;
                                }
                            }
                            break;
                        }
                        case 3:{
                            hay = false;
                            while (!hay){
                                System.out.println("Buscar la actividad por el nombre:");
                                hay = false;
                                nombreActividad = reader.next();
                                actividad = itinerario.buscarActividadPorNombre(nombreActividad);
                                if (actividad != null){
                                    itinerario.eliminaActividad(actividad);
                                    hay = true;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Desea mantenerse en la aplicacion? Si=true o No=false");
            mantenerse = reader3.nextBoolean();
        }
    }
}
