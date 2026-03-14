package com.nomina.servicio;

import com.nomina.dominio.Empleado;
import com.nomina.dominio.ResultadoNomina;
import com.nomina.servicio.estrategias.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NominaServiceTest {

    private NominaService service;

    @BeforeEach
    void setUp() {
        CargoRegistry registry = new MapCargoRegistry(Arrays.asList(
                new GerenteEstrategia(),
                new CoordinadorEstrategia(),
                new AsistenteEstrategia(),
                new OperarioEstrategia(),
                new AuxiliarEstrategia()
        ));
        service = new NominaService(registry);
    }

    @Test
    void gerente_sin_hijos_calcula_neto_correcto() {
        Empleado emp = new Empleado("Laura", "GERENTE", 160, false);
        ResultadoNomina r = service.calcular(emp);
        assertEquals(8500000, r.salarioBase, 0.01);
        assertEquals(1200000, r.bonificacion, 0.01);
    }

    @Test
    void auxiliar_con_hijos_calcula_bono_correcto() {
        Empleado emp = new Empleado("Juan", "AUXILIAR", 160, true);
        ResultadoNomina r = service.calcular(emp);
        assertEquals(1160000, r.salarioBase, 0.01);
        assertEquals(150000, r.bonificacion, 0.01);
    }

    @Test
    void operario_siempre_recibe_auxilio_transporte() {
        Empleado emp = new Empleado("Pedro", "OPERARIO", 160, false);
        ResultadoNomina r = service.calcular(emp);
        assertEquals(162000, r.bonificacion, 0.01);
    }

    @Test
    void cargo_desconocido_lanza_excepcion() {
        Empleado emp = new Empleado("X", "INVALIDO", 160, false);
        assertThrows(RuntimeException.class, () -> service.calcular(emp));
    }
}
