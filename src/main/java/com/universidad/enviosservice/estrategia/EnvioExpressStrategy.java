package com.universidad.enviosservice.estrategia;

public class EnvioExpressStrategy extends EnvioPorTramosStrategy {

    public EnvioExpressStrategy() {
        // tarifa/km, cargo fijo, kg 5-20, kg >20, km para recargo, recargo, multiplicador
        super(1.2, 0, 1.5, 2.0, 500, 25, 1.3);
    }
}