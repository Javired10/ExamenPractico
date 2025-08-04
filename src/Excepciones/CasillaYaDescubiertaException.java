package Excepciones;

/**
 * Excepción personalizada que se lanza cuando el jugador intenta descubrir
 * una casilla que ya había sido descubierta.
 */
public class CasillaYaDescubiertaException extends Exception {
    public CasillaYaDescubiertaException(String mensaje) {
        super(mensaje);
    }
}
