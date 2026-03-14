package com.nomina.servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MapCargoRegistry implements CargoRegistry {
    private final Map<String, EstrategiaCargo> estrategias = new HashMap<>();

    public MapCargoRegistry(List<EstrategiaCargo> listaEstrategias) {
        for (EstrategiaCargo estrategia : listaEstrategias) {
            estrategias.put(estrategia.getNombreCargo(), estrategia);
        }
    }

    @Override
    public EstrategiaCargo getEstrategia(String cargo) {
        EstrategiaCargo estrategia = estrategias.get(cargo);
        if (estrategia == null) {
            throw new RuntimeException("Cargo no reconocido: " + cargo);
        }
        return estrategia;
    }
}
