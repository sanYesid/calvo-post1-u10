package com.universidad.enviosservice.estrategia;


abstract class EnvioPorTramosStrategy implements EstrategiaEnvio {

    /** Valor para las estrategias que no aplican recargo por distancia. */
    static final double SIN_RECARGO_POR_DISTANCIA = Double.POSITIVE_INFINITY;

    private static final double LIMITE_TRAMO_BAJO_KG = 5;
    private static final double LIMITE_TRAMO_MEDIO_KG = 20;
    private static final double KG_TRAMO_MEDIO = LIMITE_TRAMO_MEDIO_KG - LIMITE_TRAMO_BAJO_KG;

    private final double tarifaPorKm;
    private final double cargoFijo;
    private final double tarifaKgTramoMedio;
    private final double tarifaKgTramoAlto;
    private final double kmParaRecargo;
    private final double recargoPorDistancia;
    private final double multiplicadorFinal;

    EnvioPorTramosStrategy(double tarifaPorKm, double cargoFijo,
                           double tarifaKgTramoMedio, double tarifaKgTramoAlto,
                           double kmParaRecargo, double recargoPorDistancia,
                           double multiplicadorFinal) {
        this.tarifaPorKm = tarifaPorKm;
        this.cargoFijo = cargoFijo;
        this.tarifaKgTramoMedio = tarifaKgTramoMedio;
        this.tarifaKgTramoAlto = tarifaKgTramoAlto;
        this.kmParaRecargo = kmParaRecargo;
        this.recargoPorDistancia = recargoPorDistancia;
        this.multiplicadorFinal = multiplicadorFinal;
    }

    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double costo = distanciaKm * tarifaPorKm + cargoFijo;

        if (pesoKg >= LIMITE_TRAMO_MEDIO_KG) {
            costo += KG_TRAMO_MEDIO * tarifaKgTramoMedio
                    + (pesoKg - LIMITE_TRAMO_MEDIO_KG) * tarifaKgTramoAlto;
        } else if (pesoKg >= LIMITE_TRAMO_BAJO_KG) {
            costo += (pesoKg - LIMITE_TRAMO_BAJO_KG) * tarifaKgTramoMedio;
        }

        if (distanciaKm > kmParaRecargo) {
            costo += recargoPorDistancia;
        }

        return costo * multiplicadorFinal;
    }
}