package controlador;

import modelo.*;
import Vista.*;

import javax.swing.*;
import java.util.Random;

public class AplMain {
    public static void main(String[] args) {
        // Lógica del patrón Decorator
        Desplazamiento personaje = new Personaje("Pepito");
        Random random = new Random();
        int opcion = random.nextInt(3);

        switch (opcion) {
            case 0:
                personaje = new Bicicleta(personaje, random.nextBoolean() ? "lenta" : "rápida");
                break;
            case 1:
                personaje = new Moto(personaje, random.nextBoolean() ? "bajo" : "alto");
                break;
            case 2:
                personaje = new Carro(personaje, random.nextBoolean() ? "normal" : "lujo");
                break;
        }

        personaje.mover(); // mensaje en consola

        // 🚗 Mostrar interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Simulación Decorator - Movimiento");
            Vista panel = new Vista();
            ventana.add(panel);
            ventana.setSize(800, 500);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
