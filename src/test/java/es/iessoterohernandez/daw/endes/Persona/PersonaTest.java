package es.iessoterohernandez.daw.endes.Persona;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    private static Persona persona; // Declaración del objeto Persona que se utilizará en las pruebas

    @BeforeAll
    public static void init() {
        // Configurar el objeto Persona antes de cada prueba
        // Inicializar el objeto Persona con valores específicos utilizando un constructor
        persona = new Persona("Juan", 30, 'H', 75, 1.75);
        System.out.println("inicio");
    }
    
    @AfterAll
    public static void finish() {
        persona = null;
        System.out.println("finish");
    }

    @Test
    public void calcularIMC_PesoIdeal() {
        // Prueba para calcular el IMC cuando el peso está en el rango ideal
        // Act: Llamar al método calcularIMC() en el objeto Persona
        int resultado = persona.calcularIMC();

        // Assert: Verificar que el resultado devuelto sea igual al valor esperado para peso ideal
        assertEquals(Persona.PESO_IDEAL, resultado);
    }

    @Test
    public void calcularIMC_Infrapeso() {
        // Prueba para calcular el IMC cuando el peso está por debajo del rango ideal
        // Arrange: Configurar el peso y altura específicos para este caso
        persona.setPeso(45);
        persona.setAltura(1.60);

        // Act: Llamar al método calcularIMC() en el objeto Persona
        int resultado = persona.calcularIMC();

        // Assert: Verificar que el resultado devuelto sea igual al valor esperado para infrapeso
        assertEquals(Persona.INFRAPESO, resultado);
    }

    @Test
    public void calcularIMC_Sobrepeso() {
        // Prueba para calcular el IMC cuando el peso está por encima del rango ideal
        // Arrange: Configurar el peso y altura específicos para este caso
        persona.setPeso(90);
        persona.setAltura(1.80);

        // Act: Llamar al método calcularIMC() en el objeto Persona
        int resultado = persona.calcularIMC();

        // Assert: Verificar que el resultado devuelto sea igual al valor esperado para sobrepeso
        assertEquals(Persona.SOBREPESO, resultado);
    }

    @Test
    public void esMayorDeEdad_Menor() {
        // Prueba para determinar si una persona es menor de edad
        // Arrange: Configurar la edad específica para este caso
        persona.setEdad(15);

        // Act: Llamar al método esMayorDeEdad() en el objeto Persona
        boolean resultado = persona.esMayorDeEdad();

        // Assert: Verificar que el resultado devuelto sea falso, ya que la persona es menor de edad
        assertFalse(resultado);
    }

    @Test
    public void esMayorDeEdad_Mayor() {
        // Prueba para determinar si una persona es mayor de edad
        // Arrange: Configurar la edad específica para este caso
        persona.setEdad(25);

        // Act: Llamar al método esMayorDeEdad() en el objeto Persona
        boolean resultado = persona.esMayorDeEdad();

        // Assert: Verificar que el resultado devuelto sea verdadero, ya que la persona es mayor de edad
        assertTrue(resultado);
    }
}