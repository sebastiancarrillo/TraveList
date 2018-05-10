import javax.swing.*;
import java.awt.*;
import java.io.File;
/**
 * Write a description of class Pantalla here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ventana
{   
    private JFrame frame;
    /**
     * Constructor for objects of class Pantalla
     */
    public Ventana()
    {
        makeFrame();
    }

    /**
     * Genera el frame con sus componentes
     */
    public void makeFrame(){
        frame = new JFrame("TraveList"); //Se crea la ventana
        Container contentPane = frame.getContentPane(); //Se crea un contenedor
        //Insersion del logo de la aplicacion
        JLabel logo = new JLabel();
        File archivoLogo = new File("../Images/logo.jpg");
        ImageIcon icon = new ImageIcon(archivoLogo.getPath());
        logo.setIcon(icon);
        contentPane.add(logo, BorderLayout.NORTH);//
        //Creacion de las opciones de inicio del programa
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(0,1));
        JButton selectButton = new JButton("Seleccionar");
        toolbar.add(selectButton);
        JButton crearViajeButton = new JButton("Crear nuevo viaje");
        toolbar.add(crearViajeButton);
        JPanel organizador = new JPanel();
        organizador.add(toolbar);
        contentPane.add(organizador, BorderLayout.CENTER);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
