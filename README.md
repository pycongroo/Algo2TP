#Rama GMaker
Esta es una pequeña explicacion de como deben interactuar generalmente las clases de un Juego de mesa
##Explicacion de interacciones
- [Jugador] _mueve_ una [Ficha]:
  1. [Jugador] _pregunta_ posibles [Ubicaciones] a la [Ficha]:
    - [Ficha] _obtiene_ nuevas [Ubicaciones] en base a [Ubicacion] actual y Lista de [Movimientos].
  2. [Jugador] _intenta_ ubicar [Ficha] en posible [Ubicacion].
  3. [Juego] _verifica_ nueva [Ubicacion] de [Ficha].
    - Si nueva [Ubicacion] _no coincide_ con [Ubicacion] de [Ficha] aliada:
      - [Juego] _acepta_ nueva [Ubicacion] de [Ficha].
      - [Juego] _actualiza_ nuevo [Estado].
      - [Juego] _realiza_ acciones de [Estado].
    - Si no cumple condicion:
      - [Juego] _muestra_ aviso de rechazo.
