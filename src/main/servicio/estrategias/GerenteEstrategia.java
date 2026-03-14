package com.nomina.servicio.estrategias;

import com.nomina.dominio.Empleado;
import com.nomina.servicio.EstrategiaCargo;

/**
 * MANUAL DE CÁLCULO PARA EL GERENTE.
 * Aquí solo vive la lógica del Gerente. Si cambiamos esto, NO rompemos a los demás cargos.
 * (Alta Cohesión).
 */
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
        // Lógica: Bono de 1.2M + 0.5M si tiene hijos.
        double bono = 1200000;
        if (empleado.tieneHijosACargo) {
            bono += 500000;
        }
        return bono;
    }
}
