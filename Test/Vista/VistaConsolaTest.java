package Test;

import Vista.VistaConsola;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas para VistaConsola.
 * Solo se testean los métodos que interactúan con el usuario (entrada/salida).
 */
public class VistaConsolaTest {

    @Test
    public void testMostrarMensaje() {
        // Capturar la salida estándar (System.out)
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaCapturada));

        VistaConsola vista = new VistaConsola();
        vista.mostrarMensaje("¡Hola mundo!");

        // Verificar que el mensaje se imprimió correctamente
        assertTrue(salidaCapturada.toString().contains("¡Hola mundo!"));
    }

    @Test
    public void testPedirEntrada() {
        // Simular entrada por teclado
        String entradaSimulada = "C7\n"; // simula que el usuario escribe C7
        ByteArrayInputStream entradaInput = new ByteArrayInputStream(entradaSimulada.getBytes());
        System.setIn(entradaInput);

        VistaConsola vista = new VistaConsola();
        String resultado = vista.pedirEntrada();

        assertEquals("C7", resultado);
    }
}
