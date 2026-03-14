package com.nomina.servicio;

import com.nomina.dominio.Empleado;
import com.nomina.dominio.ResultadoNomina;

public class NominaService {

    private final CargoRegistry registry;
    private static final double PORCENTAJE_SALUD = 0.04;
    private static final double PORCENTAJE_PENSION = 0.04;

    public NominaService(CargoRegistry registry) {
        this.registry = registry;
    }

    public ResultadoNomina calcular(Empleado empleado) {
        EstrategiaCargo estrategia = registry.getEstrategia(empleado.cargo);

        double salarioBase = estrategia.calcularSalarioBase();
        double bonificacion = estrategia.calcularBonificacion(empleado);
        double descuentoSalud = salarioBase * PORCENTAJE_SALUD;
        double descuentoPension = salarioBase * PORCENTAJE_PENSION;

        ResultadoNomina resultado = new ResultadoNomina();
        resultado.nombreEmpleado = empleado.nombre;
        resultado.cargo = empleado.cargo;
        resultado.salarioBase = salarioBase;
        resultado.bonificacion = bonificacion;
        resultado.descuentoSalud = descuentoSalud;
        resultado.descuentoPension = descuentoPension;
        resultado.totalDevengado = salarioBase + bonificacion;
        resultado.totalDeducido = descuentoSalud + descuentoPension;
        resultado.netoAPagar = resultado.totalDevengado - resultado.totalDeducido;

        return resultado;
    }
}
