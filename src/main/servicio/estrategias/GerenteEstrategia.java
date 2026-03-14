package com.nomina.servicio.estrategias;

import com.nomina.dominio.Empleado;
import com.nomina.servicio.EstrategiaCargo;

public class GerenteEstrategia implements EstrategiaCargo {
    @Override
    public String getNombreCargo() {
        return "GERENTE";
    }

    @Override
    public double calcularSalarioBase() {
        return 8500000;
    }

    @Override
    public double calcularBonificacion(Empleado empleado) {
        double bono = 1200000;
        if (empleado.tieneHijosACargo) {
            bono += 500000;
        }
        return bono;
    }
}
