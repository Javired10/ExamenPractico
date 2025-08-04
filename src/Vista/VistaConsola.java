package Vista;

import Modelo.Casilla;
import Modelo.Tablero;
import java.util.Scanner;

/**
 * VistaConsola se encarga de mostrar el tablero al jugador y
 * gestionar la interacción con el usuario por consola.
 */
public class VistaConsola {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarTablero(Tablero tablero) {
        System.out.print("  ");
        for (int i = 1; i <= tablero.getTamaño(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int fila = 0; fila < tablero.getTamaño(); fila++) {
            char letraFila = (char) ('A' + fila);
            System.out.print(letraFila + " ");
            for (int col = 0; col < tablero.getTamaño(); col++) {
                Casilla casilla = tablero.getCasilla(fila, col);
                if (casilla.estaDescubierta()) {
                    if (casilla.esMina()) {
                        System.out.print("X ");
                    } else if (casilla.getMinasCercanas() == 0) {
                        System.out.print("V ");
                    } else {
                        System.out.print(casilla.getMinasCercanas() + " ");
                    }
                } else if (casilla.estaMarcada()) {
                    System.out.print("M ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public String pedirEntrada() {
        System.out.print("Ingresa coordenada (ej. A5 o M B3 para marcar): ");
        return scanner.nextLine().toUpperCase();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
