package com.nomina.servicio;

import com.nomina.dominio.Empleado;

public interface EstrategiaCargo {
    String getNombreCargo();
    double calcularSalarioBase();
    double calcularBonificacion(Empleado empleado);
}
