package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioEstandarStrategyTest {

    private final EnvioEstandarStrategy estrategia = new EnvioEstandarStrategy();

    @ParameterizedTest(name = "{0} kg a {1} km cuesta {2}")
    @CsvSource({
            "3.0, 100.0, 50.0",   // pesoKg < 5
            "8.0, 100.0, 52.4",   // 5 <= pesoKg < 20
            "25.0, 100.0, 68.0"   // pesoKg >= 20
    })
    void calculaCostoPorTramoDePeso(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }

    @ParameterizedTest(name = "{0} km cuesta {1}")
    @CsvSource({
            "500.0, 250.0",   // en el limite: sin recargo
            "501.0, 260.5"    // sobre el limite: +10
    })
    void aplicaRecargoSoloSobre500Km(double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(3.0, distanciaKm), 0.01);
    }
}