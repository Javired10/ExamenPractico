package Test;

import Modelo.Tablero;
import Modelo.Casilla;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Tablero.
 */
public class TableroTest {

    @Test
    public void testInicializacionTablero() {
        Tablero tablero = new Tablero();
        assertEquals(10, tablero.getTamaño(), "El tablero debe tener tamaño 10x10");

        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                assertNotNull(tablero.getCasilla(fila, col), "La casilla no debe ser nula");
            }
        }
    }

    @Test
    public void testCantidadMinas() {
        Tablero tablero = new Tablero();
        int contadorMinas = 0;
        for (int fila = 0; fila < tablero.getTamaño(); fila++) {
            for (int col = 0; col < tablero.getTamaño(); col++) {
                if (tablero.getCasilla(fila, col).esMina()) {
                    contadorMinas++;
                }
            }
        }
        assertEquals(10, contadorMinas, "El número de minas debe ser exactamente 10");
    }

    @Test
    public void testDescubrirCasilla() {
        Tablero tablero = new Tablero();
        // Buscar una casilla que no sea mina para probar descubrimiento
        outerLoop:
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                Casilla c = tablero.getCasilla(fila, col);
                if (!c.esMina()) {
                    boolean pisoMina = tablero.descubrir(fila, col);
                    assertFalse(pisoMina, "No deberías pisar mina al descubrir una casilla vacía");
                    assertTrue(tablero.getCasilla(fila, col).estaDescubierta(), "La casilla debería estar descubierta");
                    break outerLoop;
                }
            }
        }
    }

    @Test
    public void testMarcarCasilla() {
        Tablero tablero = new Tablero();
        Casilla c = tablero.getCasilla(0, 0);
        assertFalse(c.estaMarcada(), "La casilla no debería estar marcada por defecto");

        tablero.marcar(0, 0);
        assertTrue(c.estaMarcada(), "La casilla debería estar marcada después de marcar()");

        tablero.marcar(0, 0);
        assertFalse(c.estaMarcada(), "La casilla debería desmarcarse al llamar marcar() de nuevo");
    }

    @Test
    public void testVerificarVictoria() {
        Tablero tablero = new Tablero();

        // Descubrir todas las casillas que NO son minas
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                Casilla c = tablero.getCasilla(fila, col);
                if (!c.esMina()) {
                    c.setDescubierta(true);
                }
            }
        }

        assertTrue(tablero.verificarVictoria(), "El jugador debería ganar si todas las casillas sin mina están descubiertas");
    }
}
