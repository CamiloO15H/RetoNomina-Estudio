package com.nomina.servicio.estrategias;

import com.nomina.dominio.Empleado;
import com.nomina.servicio.EstrategiaCargo;

public class OperarioEstrategia implements EstrategiaCargo {
    @Override
    public String getNombreCargo() {
        return "OPERARIO";
    }

    @Override
    public double calcularSalarioBase() {
        return 1300000;
    }

    @Override
    public double calcularBonificacion(Empleado empleado) {
        return 162000;
    }
}
