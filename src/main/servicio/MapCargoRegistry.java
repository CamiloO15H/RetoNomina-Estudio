package com.nomina.servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * ESTA ES LA IMPLEMENTACIÓN DEL ARCHIVADOR.
 * Usa un "Mapa" (como un diccionario) para guardar todas las estrategias.
 */
public class MapCargoRegistry implements CargoRegistry {
    // Aquí guardamos: "Nombre del Cargo" -> "Su Manual de Cálculo"
    private final Map<String, EstrategiaCargo> estrategias = new HashMap<>();

    /**
     * Cuando se crea el registro, le pasamos una lista de todos los manuales que tenemos.
     */
    public MapCargoRegistry(List<EstrategiaCargo> listaEstrategias) {
        for (EstrategiaCargo estrategia : listaEstrategias) {
            estrategias.put(estrategia.getNombreCargo(), estrategia);
        }
    }

    @Override
    public EstrategiaCargo getEstrategia(String cargo) {
        EstrategiaCargo estrategia = estrategias.get(cargo);
        
        // Si alguien pide un cargo que no tenemos mapeado, lanzamos un error claro.
        if (estrategia == null) {
            throw new RuntimeException("¡Pilas! El cargo '" + cargo + "' no está registrado en el sistema.");
        }
        return estrategia;
    }
}
