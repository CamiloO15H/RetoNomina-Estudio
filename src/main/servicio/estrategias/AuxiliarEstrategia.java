package com.nomina.servicio.estrategias;

import com.nomina.dominio.Empleado;
import com.nomina.servicio.EstrategiaCargo;

public class AuxiliarEstrategia implements EstrategiaCargo {
    @Override
    public String getNombreCargo() {
        return "AUXILIAR";
    }

    @Override
    public double calcularSalarioBase() {
        return 1160000;
    }

    @Override
    public double calcularBonificacion(Empleado empleado) {
        double bono = 100000;
        if (empleado.tieneHijosACargo) {
            bono += 50000;
        }
        return bono;
    }
}
