package Modelo;

import java.io.Serializable;
import java.util.Random;

/**
 * Representa el tablero del juego Buscaminas.
 * Se encarga de colocar minas, contar minas cercanas y manejar la lógica del juego.
 */
public class Tablero implements Serializable {
    private Casilla[][] casillas;
    private final int tamaño = 10;  // Tamaño del tablero (10x10)
    private final int minas = 10;   // Número total de minas en el tablero

    public Tablero() {
        casillas = new Casilla[tamaño][tamaño];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero: crea las casillas, coloca minas y calcula minas cercanas.
     */
    private void inicializarTablero() {
        for (int fila = 0; fila < tamaño; fila++) {
            for (int col = 0; col < tamaño; col++) {
                casillas[fila][col] = new Casilla(); // Creamos una nueva casilla vacía
            }
        }
        colocarMinas();
        contarMinasCercanas();
    }

    /**
     * Coloca las minas aleatoriamente en el tablero sin repetir posiciones.
     */
    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < minas) {
            int fila = random.nextInt(tamaño);
            int col = random.nextInt(tamaño);
            if (!casillas[fila][col].esMina()) {
                casillas[fila][col].setMina(true);
                minasColocadas++;
            }
        }
    }

    /**
     * Calcula el número de minas cercanas para cada casilla.
     */
    private void contarMinasCercanas() {
        for (int fila = 0; fila < tamaño; fila++) {
            for (int col = 0; col < tamaño; col++) {
                int totalMinas = 0;
                for (int df = -1; df <= 1; df++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nuevaFila = fila + df;
                        int nuevaCol = col + dc;
                        if (nuevaFila >= 0 && nuevaFila < tamaño &&
                                nuevaCol >= 0 && nuevaCol < tamaño &&
                                casillas[nuevaFila][nuevaCol].esMina()) {
                            totalMinas++;
                        }
                    }
                }
                casillas[fila][col].setMinasCercanas(totalMinas);
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public int getTamaño() {
        return tamaño;
    }

    /**
     * Descubre una casilla y sus vecinas si no tiene minas cercanas.
     * @return true si el jugador pisa una mina.
     */
    public boolean descubrir(int fila, int col) {
        Casilla casilla = casillas[fila][col];
        if (casilla.estaDescubierta()) return false;
        casilla.setDescubierta(true);

        if (casilla.getMinasCercanas() == 0 && !casilla.esMina()) {
            for (int df = -1; df <= 1; df++) {
                for (int dc = -1; dc <= 1; dc++) {
                    int nuevaFila = fila + df;
                    int nuevaCol = col + dc;
                    if (nuevaFila >= 0 && nuevaFila < tamaño &&
                            nuevaCol >= 0 && nuevaCol < tamaño) {
                        descubrir(nuevaFila, nuevaCol);
                    }
                }
            }
        }

        return casilla.esMina();
    }

    public void marcar(int fila, int col) {
        Casilla casilla = casillas[fila][col];
        casilla.setMarcada(!casilla.estaMarcada());
    }

    public boolean verificarVictoria() {
        for (int fila = 0; fila < tamaño; fila++) {
            for (int col = 0; col < tamaño; col++) {
                Casilla c = casillas[fila][col];
                if (!c.esMina() && !c.estaDescubierta()) return false;
            }
        }
        return true;
    }
}
