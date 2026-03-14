package com.nomina.servicio.estrategias;

import com.nomina.dominio.Empleado;
import com.nomina.servicio.EstrategiaCargo;

/**
 * MANUAL DE CÁLCULO PARA EL AUXILIAR.
 * ¡Mira qué fácil fue añadirlo! No tuvimos que tocar el NominaService.
 * Simplemente creamos este nuevo archivo y lo registramos. (OCP en acción).
 */
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
        // Lógica: Bono de 100k + 50k si tiene hijos.
        double bono = 100000;
        if (empleado.tieneHijosACargo) {
            bono += 50000;
        }
        return bono;
    }
}
