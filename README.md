# Sistema de Nómina - Refactorizado

Este proyecto es una solución al reto de procesamiento de nómina, aplicando principios de arquitectura limpia y patrones de diseño.

## Arquitectura y Principios
Se ha rediseñado el sistema para cumplir con los siguientes pilares:

1.  **Open/Closed Principle (OCP)**: El sistema está abierto a la extensión pero cerrado a la modificación. Se pueden añadir nuevos cargos sin alterar la lógica central de `NominaService`.
2.  **Strategy Pattern**: La lógica de cálculo de cada cargo se ha encapsulado en clases independientes que implementan la interfaz `EstrategiaCargo`.
3.  **Inyección de Dependencias**: `NominaService` depende de la abstracción `CargoRegistry`, lo que facilita el testing y la escalabilidad.

## Cómo añadir un nuevo cargo
Simplemente cree una nueva clase en el paquete `estrategias` que implemente `EstrategiaCargo` y regístrela en el `CargoRegistry`.

## Cargo Auxiliar
Se ha incluido la implementación del cargo **AUXILIAR** como demostración de la facilidad de extensión del sistema.