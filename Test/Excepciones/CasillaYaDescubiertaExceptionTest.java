package Test;

import Excepciones.CasillaYaDescubiertaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la excepción CasillaYaDescubiertaException.
 */
public class CasillaYaDescubiertaExceptionTest {

    @Test
    public void testMensajeExcepcion() {
        String mensajeEsperado = "Esa casilla ya fue descubierta.";
        CasillaYaDescubiertaException ex = new CasillaYaDescubiertaException(mensajeEsperado);

        // Comprobar que el mensaje se guarda correctamente
        assertEquals(mensajeEsperado, ex.getMessage());
    }

    @Test
    public void testLanzamientoDeExcepcion() {
        assertThrows(CasillaYaDescubiertaException.class, () -> {
            throw new CasillaYaDescubiertaException("Error lanzado manualmente.");
        });
    }
}
