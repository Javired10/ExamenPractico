package Modelo;

import java.io.Serializable;

/**
 * Representa una casilla del tablero de Buscaminas.
 * Cada casilla puede ser una mina, estar descubierta, marcada o mostrar minas cercanas.
 */
public class Casilla implements Serializable {
    private boolean esMina;          // Indica si la casilla contiene una mina
    private boolean descubierta;     // Indica si el jugador ya la descubrió
    private boolean marcada;         // Indica si fue marcada como posible mina
    private int minasCercanas;       // Número de minas en casillas vecinas

    public Casilla() {
        this.esMina = false;
        this.descubierta = false;
        this.marcada = false;
        this.minasCercanas = 0;
    }

    // Métodos para acceder o modificar los datos de la casilla
    public boolean esMina() { return esMina; }
    public void setMina(boolean esMina) { this.esMina = esMina; }
    public boolean estaDescubierta() { return descubierta; }
    public void setDescubierta(boolean descubierta) { this.descubierta = descubierta; }
    public boolean estaMarcada() { return marcada; }
    public void setMarcada(boolean marcada) { this.marcada = marcada; }
    public int getMinasCercanas() { return minasCercanas; }
    public void setMinasCercanas(int minasCercanas) { this.minasCercanas = minasCercanas; }
}
