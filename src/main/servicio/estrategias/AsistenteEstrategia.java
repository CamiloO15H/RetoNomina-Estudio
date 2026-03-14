package com.nomina.servicio.estrategias;

import com.nomina.dominio.Empleado;
import com.nomina.servicio.EstrategiaCargo;

public class AsistenteEstrategia implements EstrategiaCargo {
    @Override
    public String getNombreCargo() {
        return "ASISTENTE";
    }

    @Override
    public double calcularSalarioBase() {
        return 2100000;
    }

    @Override
    public double calcularBonificacion(Empleado empleado) {
        double bono = 300000;
        if (empleado.tieneHijosACargo) {
            bono += 200000;
        }
        return bono;
    }
}
