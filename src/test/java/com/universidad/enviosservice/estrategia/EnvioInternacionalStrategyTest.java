package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioInternacionalStrategyTest {

    private final EnvioInternacionalStrategy estrategia = new EnvioInternacionalStrategy();

    @ParameterizedTest(name = "{0} kg a {1} km cuesta {2}")
    @CsvSource({
            "3.0, 1000.0, 1850.0",    // pesoKg < 5
            "8.0, 1000.0, 1859.0",    // 5 <= pesoKg < 20
            "25.0, 1000.0, 1917.5"    // pesoKg >= 20
    })
    void calculaCostoPorTramoDePeso(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }

    @ParameterizedTest(name = "{0} km cuesta {1}")
    @CsvSource({
            "5000.0, 9050.0",     // en el limite: sin recargo de 100
            "5001.0, 9151.8"      // sobre el limite: +100
    })
    void aplicaRecargoSoloSobre5000Km(double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(3.0, distanciaKm), 0.01);
    }
}