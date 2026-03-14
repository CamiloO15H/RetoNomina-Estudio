package com.nomina.servicio;

import com.nomina.dominio.Empleado;
import com.nomina.dominio.ResultadoNomina;

/**
 * ESTE ES EL "ORQUESTADOR" O EL CONTADOR JEFE.
 * Ya no tiene un montón de IFs complicados. Ahora simplemente:
 * 1. Mira qué cargo es el empleado.
 * 2. Pide el manual (Estrategia) al archivador (Registry).
 * 3. Sigue las instrucciones de ese manual.
 */
public class NominaService {

    private final CargoRegistry registry;
    private static final double PORCENTAJE_SALUD = 0.04;
    private static final double PORCENTAJE_PENSION = 0.04;

    /**
     * Inyección de Dependencias: Al crear el servicio, le pasamos el registro de cargos.
     */
    public NominaService(CargoRegistry registry) {
        this.registry = registry;
    }

    /**
     * Ya no hay IFs. Si mañana llega un cargo nuevo, este método SIGUE IGUAL.
     * Eso es el principio de Abierto/Cerrado (OCP).
     */
    public ResultadoNomina calcular(Empleado empleado) {
        // Pedimos la estrategia correcta según el cargo.
        EstrategiaCargo estrategia = registry.getEstrategia(empleado.cargo);

        // Delegamos los cálculos a la estrategia. Ella sabe qué hacer.
        double salarioBase = estrategia.calcularSalarioBase();
        double bonificacion = estrategia.calcularBonificacion(empleado);
        
        // Descuentos de ley (estos suelen ser iguales para todos).
        double descuentoSalud = salarioBase * PORCENTAJE_SALUD;
        double descuentoPension = salarioBase * PORCENTAJE_PENSION;

        // Armamos el reporte final.
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
