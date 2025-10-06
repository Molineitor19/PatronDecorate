package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Vista extends JPanel implements ActionListener {

    private Image fondo; //sdsadsdadsadasdasdasdsad
    private Image[] frames;
    private int frameIndex = 0;
    private int x = 0;
    private Timer timer;
    private int delay;  
    private int paso;   
    private Random rand;
    private String tipoVehiculo;
    private boolean esPro;

    public Vista() {
        rand = new Random();

        fondo = new ImageIcon(getClass().getResource("/Imagenes/imagenes/Fondo.jpg")).getImage();

        cargarVehiculoAleatorio();

        timer = new Timer(delay, this);
        timer.start();
    }

    private void cargarVehiculoAleatorio() {
        int tipo = rand.nextInt(3); // 0 carro, 1 moto, 2 bici
        esPro = rand.nextBoolean();
        frameIndex = 0;
        x = -200;

        switch (tipo) {
            case 0 -> { 
                tipoVehiculo = "carro";
                if (esPro) {
                    frames = new Image[]{
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/carrotuneado1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/carrotuneado2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/carrotuneado3.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/carrotuneado4.png")).getImage()
                    };
                    delay = 7; 
                    paso = 11;
                } else {
                    frames = new Image[]{
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/carronormal1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/carronormal2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/carronormal3.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/carronormal4.png")).getImage()
                    };
                    delay = 10;
                    paso = 9;
                }
            }
            case 1 -> { 
                tipoVehiculo = "moto";
                if (esPro) {
                    frames = new Image[]{
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/motopro1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/motopro2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/motopro3.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/motopro4.png")).getImage()
                    };
                    delay = 4; 
                    paso = 10;
                } else {
                    frames = new Image[]{
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/motonormal1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/motonormal2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/motonormal3.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/motonormal4.png")).getImage()
                    };
                    delay = 15;
                    paso = 7;
                }
            }
            case 2 -> { 
                tipoVehiculo = "bicicleta";
                if (esPro) {
                    frames = new Image[]{
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/Ciclapro1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/Ciclapro2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/Ciclapro3.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/Ciclapro4.png")).getImage()
                    };
                    delay = 20;
                    paso = 5;
                } else {
                    frames = new Image[]{
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/Ciclanormal1.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/Ciclanormal2.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/Ciclanormal3.png")).getImage(),
                        new ImageIcon(getClass().getResource("/Imagenes/imagenes/Ciclanormal4.png")).getImage()
                    };
                    delay = 25; 
                    paso = 5;
                }
            }
        }

        // Reiniciar el timer con  nueva velocidad
        if (timer != null) {
            timer.setDelay(delay);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(frames[frameIndex], x, getHeight() - 180, 200, 120, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameIndex = (frameIndex + 1) % frames.length;
        x += paso;

        if (x > getWidth()) {
            cargarVehiculoAleatorio();
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Simulación Decorator - Movimiento");
        Vista panel = new Vista();
        ventana.add(panel);
        ventana.setSize(800, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
