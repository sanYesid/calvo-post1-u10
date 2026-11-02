package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioExpressStrategyTest {

    private final EnvioExpressStrategy estrategia = new EnvioExpressStrategy();

    @ParameterizedTest(name = "{0} kg a {1} km cuesta {2}")
    @CsvSource({
            "3.0, 100.0, 156.0",    // pesoKg < 5, con multiplicador 1.3
            "8.0, 100.0, 161.85",   // 5 <= pesoKg < 20
            "25.0, 100.0, 198.25"   // pesoKg >= 20
    })
    void calculaCostoPorTramoDePeso(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }

    @ParameterizedTest(name = "{0} km cuesta {1}")
    @CsvSource({
            "500.0, 780.0",     // en el limite: sin recargo de 25
            "501.0, 814.06"     // sobre el limite: +25 antes del multiplicador
    })
    void aplicaRecargoSoloSobre500Km(double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(3.0, distanciaKm), 0.01);
    }
}