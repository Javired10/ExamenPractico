#  Buscaminas en Java (consola)

Este proyecto es una versión en consola del clásico juego **Buscaminas**, implementado en el lenguaje **Java** utilizando **Programación Orientada a Objetos (POO)**, el patrón **MVC**, y buenas prácticas como **TDD** (Desarrollo guiado por pruebas) y manejo de **excepciones personalizadas**.

---

##  Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/BuscaMinas.git
   cd BuscaMinas
   ```

2. Abre el proyecto en **IntelliJ IDEA** o tu IDE preferido.

3. Ejecuta la clase:
   ```java
   Main.java
   ```

---

##  Instrucciones de juego

- Para **descubrir una casilla**, escribe:  
  `A5` (letra de fila + número de columna)

- Para **marcar una mina**, escribe:  
  `M B3` (con espacio entre la "M" y la casilla)

- El juego termina cuando:
  - 💥 Descubres una mina (pierdes).
  - 🎉 Descubres todas las casillas seguras (ganas).

---

##  Estructura del proyecto

```
BuscaMinas/
├── src/
│   ├── Controlador/        # Lógica del flujo del juego
│   ├── Modelo/             # Clases Casilla y Tablero
│   ├── Vista/              # Interfaz por consola
│   ├── Excepciones/        # Excepciones personalizadas
│   └── Main.java           # Punto de entrada del juego
├── test/                   # Pruebas unitarias con JUnit
├── README.md               # Este archivo
├── Diagrama_UML.png        # Diagrama de clases
```

---

## ✅ Principales características

-  Tablero de 10x10 con 10 minas colocadas aleatoriamente.
-  Propagación automática al descubrir casillas sin minas cercanas.
-  Posibilidad de marcar casillas como posibles minas.
-  Validación de entrada del usuario (con manejo de errores).
-  Excepción personalizada: `CasillaYaDescubiertaException`.
-  Separación en capas según el patrón **Modelo-Vista-Controlador (MVC)**.
-  Pruebas unitarias con **JUnit 5**.

---

##  Pruebas unitarias

Las siguientes clases tienen cobertura de pruebas:

- `ControladorJuegoTest.java`
- `CasillaTest.java`
- `TableroTest.java`
- `VistaConsolaTest.java`
- `CasillaYaDescubiertaExceptionTest.java`

Ejecuta todas desde la carpeta `test/` en IntelliJ IDEA.

---

## 📷 Ejemplo de ejecución

```
   1 2 3 4 5 6 7 8 9 10
A  . . . . . . . . . .
B  . . . . . . . . . .
C  . . . . . . . . . .
D  . . . . . . . . . .
E  . . . . . . . . . .
F  . . . . . . . . . .
G  . . . . . . . . . .
H  . . . . . . . . . .
I  . . . . . . . . . .
J  . . . . . . . . . .
Ingresa coordenada (ej. A5 o M B3 para marcar):
```

---

##  Diagrama 

Incluido en el archivo `Diagrama_UML.png`. Representa las clases `Casilla`, `Tablero`, `VistaConsola`, `ControladorJuego`, `Main` y `Excepciones`.

---

## ✍️ Autor

- 👤 Javier Marca

---


