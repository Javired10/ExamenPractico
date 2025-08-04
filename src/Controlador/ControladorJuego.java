package Controlador;

import Modelo.Tablero;
import Vista.VistaConsola;
import Excepciones.CasillaYaDescubiertaException;

/**
 * Controlador principal del juego.
 * Se encarga de conectar la lógica del tablero con la vista en consola.
 */
public class ControladorJuego {
    private Tablero tablero;
    private VistaConsola vista;
    private boolean juegoTerminado;

    public ControladorJuego() {
        this.tablero = new Tablero();
        this.vista = new VistaConsola();
        this.juegoTerminado = false;
    }

    /**
     * Inicia el ciclo principal del juego.
     * Muestra el tablero y procesa las jugadas del jugador hasta ganar o perder.
     */
    public void iniciarJuego() {
        vista.mostrarMensaje(" ¡Bienvenido al Buscaminas!");
        while (!juegoTerminado) {
            vista.mostrarTablero(tablero);
            String entrada = vista.pedirEntrada();

            try {
                // Si el jugador quiere marcar una casilla
                if (entrada.startsWith("M ")) {
                    entrada = entrada.substring(2).trim(); // Quitamos la "M "
                    int[] coords = convertirEntrada(entrada);
                    tablero.marcar(coords[0], coords[1]);
                } else {
                    // Descubrir una casilla
                    int[] coords = convertirEntrada(entrada);

                    if (tablero.getCasilla(coords[0], coords[1]).estaDescubierta()) {
                        throw new CasillaYaDescubiertaException("⚠️ Esa casilla ya fue descubierta.");
                    }

                    boolean esMina = tablero.descubrir(coords[0], coords[1]);

                    if (esMina) {
                        vista.mostrarTablero(tablero);
                        vista.mostrarMensaje("💥 ¡Has perdido! Pisaste una mina.");
                        juegoTerminado = true;
                    } else if (tablero.verificarVictoria()) {
                        vista.mostrarTablero(tablero);
                        vista.mostrarMensaje("🎉 ¡Felicidades! Has ganado.");
                        juegoTerminado = true;
                    }
                }
            } catch (CasillaYaDescubiertaException e) {
                vista.mostrarMensaje(e.getMessage());
            } catch (Exception e) {
                vista.mostrarMensaje("❌ Entrada inválida. Usa formato como A1 o M B3.");
            }
        }
    }

    /**
     * Convierte una entrada como "A5" en coordenadas [fila, columna].
     * Lanza excepción si el formato es incorrecto o fuera de rango.
     */
    private int[] convertirEntrada(String entrada) throws Exception {
        if (entrada.length() < 2 || entrada.length() > 3)
            throw new Exception("Formato inválido");

        char letraFila = entrada.charAt(0);
        int fila = letraFila - 'A'; // Convertimos letra en número (A=0, B=1, ...)

        int col = Integer.parseInt(entrada.substring(1)) - 1; // Columnas empiezan en 1

        if (fila < 0 || fila >= 10 || col < 0 || col >= 10)
            throw new Exception("Coordenadas fuera de rango");

        return new int[]{fila, col};
    }

    /**
     * Método público auxiliar para pruebas unitarias del método convertirEntrada().
     */
    public int[] convertirEntradaPublic(String entrada) throws Exception {
        return convertirEntrada(entrada);
    }
}
