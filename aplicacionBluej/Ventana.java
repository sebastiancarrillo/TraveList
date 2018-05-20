import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;
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
    
    private void crearNuevo(JFrame cierre){
        cierre.setVisible(false);
        frame = new JFrame("TraveList"); //Se crea la ventana
        Container contentPane = frame.getContentPane(); //Se crea un contenedor
        //Insersion del logo de la aplicacion
        JLabel logo = new JLabel();
        JLabel titulo = new JLabel();
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new GridLayout(1,2,10,0));
        File archivoLogo = new File("../Images/logo.jpg");
        ImageIcon icon = new ImageIcon(archivoLogo.getPath());
        logo.setIcon(icon);
        titulo.setIcon(icon);
        encabezado.add(logo);
        encabezado.add(titulo);
        contentPane.add(encabezado, BorderLayout.NORTH);//
        //Creacion de las opciones de inicio del programa
        JTextField nombre = new JTextField(5);
        JLabel labelNombre = new JLabel("Nombre");
        JPanel organizador2 = new JPanel();
        organizador2.setLayout(new FlowLayout());
        organizador2.add(labelNombre);
        organizador2.add(nombre);
        JPanel toolbar = new JPanel();
        JPanel organizador = new JPanel();
        organizador.setLayout(new FlowLayout());
        toolbar.setLayout(new GridLayout(3,1,0,5));
        toolbar.add(organizador2);
        JRadioButton selectButton = new JRadioButton("Seleccionar");
        toolbar.add(selectButton);
        JButton crearViajeButton = new JButton("Crear nuevo viaje");
        crearViajeButton.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e) { crearNuevo(frame);}
                                    });
        toolbar.add(crearViajeButton);
        organizador.add(toolbar);
        contentPane.add(organizador, BorderLayout.CENTER);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    
    private void seleccionar(JFrame cierre){
        cierre.setVisible(false);
    }
    
    
    /**
     * Genera el frame con sus componentes
     */
    public void makeFrame(){
        frame = new JFrame("TraveList"); //Se crea la ventana
        Container contentPane = frame.getContentPane(); //Se crea un contenedor
        //Insersion del logo de la aplicacion
        JLabel logo = new JLabel();
        JLabel titulo = new JLabel();
        JPanel encabezado = new JPanel();
        encabezado.setLayout(new GridLayout(1,2,10,0));
        File archivoLogo = new File("../Images/logo.jpg");
        ImageIcon icon = new ImageIcon(archivoLogo.getPath());
        logo.setIcon(icon);
        titulo.setIcon(icon);
        encabezado.add(logo);
        encabezado.add(titulo);
        contentPane.add(encabezado, BorderLayout.NORTH);//
        //Creacion de las opciones de inicio del programa
        JPanel toolbar = new JPanel();
        JPanel organizador = new JPanel();
        organizador.setLayout(new FlowLayout());
        toolbar.setLayout(new GridLayout(2,1,0,5));
        JButton selectButton = new JButton("Seleccionar");
        selectButton.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e) { seleccionar(frame);}
                                    });
        toolbar.add(selectButton);
        JButton crearViajeButton = new JButton("Crear nuevo viaje");
        crearViajeButton.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e) { crearNuevo(frame);}
                                    });
        toolbar.add(crearViajeButton);
        organizador.add(toolbar);
        contentPane.add(organizador, BorderLayout.CENTER);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
