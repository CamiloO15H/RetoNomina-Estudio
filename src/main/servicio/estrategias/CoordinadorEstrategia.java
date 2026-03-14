package com.nomina.servicio.estrategias;

import com.nomina.dominio.Empleado;
import com.nomina.servicio.EstrategiaCargo;

/**
 * MANUAL DE CÁLCULO PARA EL COORDINADOR.
 */
public class CoordinadorEstrategia implements EstrategiaCargo {
    @Override
    public String getNombreCargo() {
        return "COORDINADOR";
    }

    @Override
    public double calcularSalarioBase() {
        return 4200000;
    }

    @Override
    public double calcularBonificacion(Empleado empleado) {
        double bono = 600000;
        if (empleado.tieneHijosACargo) {
            bono += 350000;
        }
        return bono;
    }
}
