Cloud-Fog-Edge Temperature Simulation
Descripción

Este proyecto consiste en la simulación de un sistema distribuido basado en arquitectura Cloud-Fog-Edge para la recogida y gestión de datos de temperatura.

La aplicación está desarrollada en Java y utiliza varias clases que representan cada nivel del sistema: Edge, Fog y Cloud, simulando cómo viajan los datos desde el origen hasta su almacenamiento final.

Funcionamiento

El sistema funciona de la siguiente manera:

El EdgeNode genera datos de temperatura de forma aleatoria y los envía al FogNode.
El FogNode procesa esos datos, detecta si la temperatura es alta (mayor de 30) y los reenvía al CloudServer.
El CloudServer almacena todos los datos recibidos y, al final, muestra un resumen por pantalla.

Además, el sistema se detiene automáticamente cuando se alcanzan 20 temperaturas altas, mostrando este dato por pantalla.

Estructura del proyecto

El proyecto está dividido en las siguientes clases:

Main (clase principal)
Se encarga de crear los nodos (Cloud, Fog y Edge), iniciar la simulación y mostrar el resumen final.
CloudServer
Almacena los datos recibidos en un ArrayList
Permite guardar datos
Muestra un resumen final
FogNode
Recibe los datos del Edge
Detecta temperaturas altas (>30)
Lleva un contador de temperaturas altas
Envía los datos al Cloud
EdgeNode
Genera datos aleatorios
Los envía al Fog
Muestra los datos generados
SensorData
Representa cada dato de temperatura
Contiene:
ID del sensor (String)
Temperatura (double)
Incluye getters y método toString()
Objetivo

Simular cómo se gestionan datos en un sistema distribuido moderno, diferenciando claramente los roles de cada nivel (Edge, Fog y Cloud) y cómo interactúan entre sí.
