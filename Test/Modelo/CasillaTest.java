package Test;

import Modelo.Casilla;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Casilla.
 */
public class CasillaTest {

    @Test
    public void testValoresPorDefecto() {
        Casilla casilla = new Casilla();
        assertFalse(casilla.esMina(), "La casilla no debería ser mina por defecto.");
        assertFalse(casilla.estaDescubierta(), "La casilla no debería estar descubierta por defecto.");
        assertFalse(casilla.estaMarcada(), "La casilla no debería estar marcada por defecto.");
        assertEquals(0, casilla.getMinasCercanas(), "La casilla no debería tener minas cercanas por defecto.");
    }

    @Test
    public void testSetYGetMina() {
        Casilla casilla = new Casilla();
        casilla.setMina(true);
        assertTrue(casilla.esMina(), "La casilla debería ser marcada como mina.");
    }

    @Test
    public void testSetYGetDescubierta() {
        Casilla casilla = new Casilla();
        casilla.setDescubierta(true);
        assertTrue(casilla.estaDescubierta(), "La casilla debería estar descubierta.");
    }

    @Test
    public void testSetYGetMarcada() {
        Casilla casilla = new Casilla();
        casilla.setMarcada(true);
        assertTrue(casilla.estaMarcada(), "La casilla debería estar marcada.");
    }

    @Test
    public void testSetYGetMinasCercanas() {
        Casilla casilla = new Casilla();
        casilla.setMinasCercanas(3);
        assertEquals(3, casilla.getMinasCercanas(), "La casilla debería tener 3 minas cercanas.");
    }
}
