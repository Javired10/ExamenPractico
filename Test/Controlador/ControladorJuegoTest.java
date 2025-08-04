package Test;

import Controlador.ControladorJuego;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas para ControladorJuego (solo método convertirEntrada).
 */
public class ControladorJuegoTest {

    @Test
    public void testEntradaValida() throws Exception {
        ControladorJuego juego = new ControladorJuego();
        assertArrayEquals(new int[]{0, 0}, juego.convertirEntradaPublic("A1"));
        assertArrayEquals(new int[]{2, 4}, juego.convertirEntradaPublic("C5"));
        assertArrayEquals(new int[]{9, 9}, juego.convertirEntradaPublic("J10"));
    }

    @Test
    public void testFormatoInvalido() {
        ControladorJuego juego = new ControladorJuego();

        assertThrows(Exception.class, () -> juego.convertirEntradaPublic(""));
        assertThrows(Exception.class, () -> juego.convertirEntradaPublic("Z"));
        assertThrows(Exception.class, () -> juego.convertirEntradaPublic("A"));
        assertThrows(Exception.class, () -> juego.convertirEntradaPublic("111"));
    }

    @Test
    public void testCoordenadasFueraDeRango() {
        ControladorJuego juego = new ControladorJuego();

        assertThrows(Exception.class, () -> juego.convertirEntradaPublic("K1")); // Fila inválida
        assertThrows(Exception.class, () -> juego.convertirEntradaPublic("A0")); // Columna inválida
        assertThrows(Exception.class, () -> juego.convertirEntradaPublic("J11")); // Columna inválida
    }
}