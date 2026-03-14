package com.nomina.servicio;

import com.nomina.dominio.Empleado;

/**
 * ESTA ES NUESTRA "FICHA DE TRABAJO" O CONTRATO (Interface).
 * Imagina que es como un manual que dice qué DEBE saber hacer cualquier cargo,
 * pero no dice CÓMO hacerlo. Cada cargo (Gerente, Operario, etc.) tendrá su propia versión.
 */
public interface EstrategiaCargo {
    
    /**
     * @return El nombre del cargo (Ej: "GERENTE").
     */
    String getNombreCargo();

    /**
     * @return Cuánto gana este cargo por defecto.
     */
    double calcularSalarioBase();

    /**
     * @param empleado Los datos del empleado para saber si tiene hijos, etc.
     * @return El cálculo del bono específico para este cargo.
     */
    double calcularBonificacion(Empleado empleado);
}
