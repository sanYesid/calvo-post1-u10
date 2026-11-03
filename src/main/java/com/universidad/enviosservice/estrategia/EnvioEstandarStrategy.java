package com.universidad.enviosservice.estrategia;

public class EnvioEstandarStrategy extends EnvioPorTramosStrategy {

    public EnvioEstandarStrategy() {
        // tarifa/km, cargo fijo, kg 5-20, kg >20, km para recargo, recargo, multiplicador
        super(0.5, 0, 0.8, 1.2, 500, 10, 1.0);
    }
}