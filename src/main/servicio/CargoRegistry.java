package com.nomina.servicio;

/**
 * ESTE ES EL "ARCHIVADOR" O "RECEPCIÓN".
 * Su único trabajo es que tú le des un nombre de cargo y él te entregue
 * la carpeta (Estrategia) correcta para ese cargo.
 */
public interface CargoRegistry {
    /**
     * @param cargo "GERENTE", "AUXILIAR", etc.
     * @return La clase que sabe calcular los valores para ese cargo.
     */
    EstrategiaCargo getEstrategia(String cargo);
}
