package com.universidad.enviosservice.estrategia;

public class EnvioOvernightStrategy extends EnvioPorTramosStrategy {

    private static final double DISTANCIA_MAXIMA_KM = 300;

    public EnvioOvernightStrategy() {
        // tarifa/km, cargo fijo, kg 5-20, kg >20, km para recargo, recargo, multiplicador
        super(2.0, 20, 2.5, 3.0, SIN_RECARGO_POR_DISTANCIA, 0, 1.0);
    }

    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        if (distanciaKm > DISTANCIA_MAXIMA_KM) {
            throw new IllegalArgumentException("OVERNIGHT no disponible para mas de 300 km");
        }
        return super.calcular(pesoKg, distanciaKm);
    }
}