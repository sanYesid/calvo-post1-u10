package com.universidad.enviosservice.estrategia;

public class EnvioInternacionalStrategy extends EnvioPorTramosStrategy {

    public EnvioInternacionalStrategy() {
        // tarifa/km, cargo fijo, kg 5-20, kg >20, km para recargo, recargo, multiplicador
        super(1.8, 50, 3.0, 4.5, 5000, 100, 1.0);
    }
}