import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;
import java.util.Calendar;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;
import java.util.Properties;

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
        //Creacion del formulario
        //Campo de nombre
        JTextField nombre = new JTextField(5);
        JLabel labelNombre = new JLabel("Nombre");
        JPanel organizador2 = new JPanel();
        organizador2.setLayout(new FlowLayout());
        organizador2.add(labelNombre);
        organizador2.add(nombre);
        JPanel toolbar = new JPanel();
        JPanel organizador = new JPanel();
        organizador.setLayout(new FlowLayout());
        toolbar.setLayout(new GridLayout(5,1,0,5));
        toolbar.add(organizador2);
        //RadioButtons de sexo
        JPanel organizador3 = new JPanel();
        organizador3.setLayout(new FlowLayout());
        JRadioButton manRadioButton = new JRadioButton("Hombre");
        organizador3.add(manRadioButton);
        JRadioButton womanRadioButton = new JRadioButton("Mujer");
        organizador3.add(womanRadioButton);
        toolbar.add(organizador3);
        //Seleccionador de fecha
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        toolbar.add(datePicker);
        //Seleccionar el numero de dias y de noches
        JPanel organizador4 = new JPanel();
        organizador4.setLayout(new FlowLayout());
        JLabel dias = new JLabel("Dias");
        organizador4.add(dias);
        JTextField numDias = new JTextField(1);
        organizador4.add(numDias);
        JLabel noches = new JLabel("Noches");
        organizador4.add(noches);
        JTextField numNoches = new JTextField(1);
        organizador4.add(numNoches);
        toolbar.add(organizador4);
        //Botones de continuar y volver
        JPanel organizador5 = new JPanel();
        organizador5.setLayout(new FlowLayout());
        JButton volver = new JButton("Volver");
        volver.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e) { 
                                            frame.setVisible(false);
                                            makeFrame();
                                        }
                                    });
        organizador5.add(volver);
        JButton continuar = new JButton("Continuar");
        organizador5.add(continuar); 
        continuar.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e) { 
                                            crearNuevo2(frame);
                                        }
                                    });
        contentPane.add(organizador5, BorderLayout.SOUTH);
        //Mostrar la ventana
        organizador.add(toolbar);
        contentPane.add(organizador, BorderLayout.CENTER);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    
    private void crearNuevo2(JFrame cierre){
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
        //Creacion del formulario
        //Campo clima
        JComboBox clima = new JComboBox();
        clima.addItem("Muy Frio");
        clima.addItem("Frio");
        clima.addItem("Templado");
        clima.addItem("Calido");
        clima.addItem("Muy Calido");
        JLabel labelClima = new JLabel("Clima");
        JPanel organizador2 = new JPanel();
        organizador2.setLayout(new FlowLayout());
        organizador2.add(labelClima);
        organizador2.add(clima);
        JPanel toolbar = new JPanel();
        JPanel organizador = new JPanel();
        organizador.setLayout(new FlowLayout());
        toolbar.setLayout(new GridLayout(2,1,0,5));
        toolbar.add(organizador2);
        //JRadioButton de si hay balneario
        JPanel organizador3 = new JPanel();
        organizador3.setLayout(new FlowLayout());
        JLabel balneario = new JLabel("Hay balneario:");
        organizador3.add(balneario);
        JRadioButton siBalneario = new JRadioButton("Si");
        organizador3.add(siBalneario);
        JRadioButton noBalneario = new JRadioButton("No");
        organizador3.add(noBalneario);
        toolbar.add(organizador3);
        //Botones de continuar y volver
        JPanel organizador5 = new JPanel();
        organizador5.setLayout(new FlowLayout());
        JButton volver = new JButton("Volver");
        volver.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e) { 
                                            frame.setVisible(false);
                                            makeFrame();
                                        }
                                    });
        organizador5.add(volver);
        JButton continuar = new JButton("Continuar");
        organizador5.add(continuar); 
        continuar.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e) { 
                                            frame.setVisible(false);
                                        }
                                    });
        contentPane.add(organizador5, BorderLayout.SOUTH);
        //Mostrar la ventana
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
