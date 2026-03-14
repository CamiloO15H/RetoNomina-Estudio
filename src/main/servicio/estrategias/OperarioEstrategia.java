package com.nomina.servicio.estrategias;

import com.nomina.dominio.Empleado;
import com.nomina.servicio.EstrategiaCargo;

/**
 * MANUAL DE CÁLCULO PARA EL OPERARIO.
 * El operario tiene un auxilio de transporte fijo.
 */
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
        // En este caso es solo el auxilio de transporte.
        return 162000;
    }
}
