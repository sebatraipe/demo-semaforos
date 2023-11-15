package ar.unrn.demo.main;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        int numUsuarios = 5; // Cantidad de usuarios
        int numCanchas = 2; // Cantidad de canchas
        Semaphore[] semaforosCanchas = new Semaphore[numCanchas];

        // Inicializar los semáforos para representar las canchas
        for (int i = 0; i < numCanchas; i++) {
            semaforosCanchas[i] = new Semaphore(1); // Inicialmente, todas las canchas están disponibles
        }

        // Simulación de usuarios que solicitan turnos
        for (int i = 1; i <= numUsuarios; i++) {
            int usuarioID = i;
            new Thread(() -> {
                try {
                    // Los usuarios eligen una cancha al azar
                    int canchaElegida = (int) (Math.random() * numCanchas);
                    System.out.println("Usuario " + usuarioID + " elige la Cancha " + canchaElegida);

                    // Intenta reservar la cancha elegida
                    if (semaforosCanchas[canchaElegida].tryAcquire()) {
                        System.out.println("Usuario " + usuarioID + " ha reservado la Cancha " + canchaElegida);
                        Thread.sleep(3000); // Simula el tiempo de juego
                        semaforosCanchas[canchaElegida].release(); // Libera la cancha después de jugar
                    } else {
                        System.out.println("Usuario " + usuarioID + " no pudo reservar la Cancha " + canchaElegida);
                    }
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
