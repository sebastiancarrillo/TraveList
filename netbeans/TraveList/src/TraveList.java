/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhon
 */
public class TraveList {
    public static ListaViajes viajes = new ListaViajes();
    public static void main(String[] args){
        new VentanaInicio(viajes).setVisible(true);
    }  
}
