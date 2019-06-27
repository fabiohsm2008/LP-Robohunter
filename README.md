# LP
Lenguajes de programación (CCOMP 7-1)

## Nuevas Funcionalidades

### 1. Paradas para recargar totalmente la estamina. Cuando el robot se para encima de ella, cargar.

   Encargada: Melissa
   
   Estado: Completo
   
   Comentarios:
   Función: detectarParada()
   

### 2. Tiempo (máx 60sec). Usar threads. Cambiarlo en Modo Torneo.

    Encargado: Martin
    
    Estado: Incompleto
    
    Comentarios:
    
    
### 3. En caso que la estamina se acabe, la velocidad de los movimientos básicos (andar y girar), se reducirá a la mitad.
   
   Encargado: Yato-sama
   
   Estado: Incompleto
   
   Comentarios:
   
   
### 4. Cada personaje tiene una determinada vida inicial (10.0) .

   Encargado: Bryan
   
   Estado: Incompleto
   
   Comentarios:
   
   
### 5. Puede utilizar 2 tipos de armas. Sin embargo:

* Una arma tendrá un costo de estamina de 1
* Una segunda arma tendrá un costo de estamina entre 2 y 5.


   Encargado: Anthony
   
   Estado: Incompleto
   
   Comentarios:
   
   
### 6. Permitir movimiento diagonal (puede disparar en diagonal tb)

   Encargado: Oscar
   
   Estado: Completo!!
   
   Comentarios: 
       
     Constantes: Implemente direcciones NORESTE, NOROESTE, SURESTE, SUROESTE.
     Funciones: irANorEste(), irANorOeste(), ... .
     Funciones: girarIzquierda(), girarDerecha() estan adaptadas a las nuevas direcciones.
     Pantalla: Los robots, si mira a NORESTE, NOROESTE, se mostrara como mirar NORTE.
     Pantalla: Los robots, si mira a SURESTE, SUROESTE, se mostrara como mirar SUR.
    
     
     
### 7. Permitir partidas con n jugadores (2,3, o 4)

   Encargado: Juan
   
   Estado: Incompleto
   
   Comentarios:
   
   
### 8. Implementar Función Torneo

   Encargado: Fabio
   
   Estado: Completo
   
   Comentarios: 
   El código base de PartidaTorneo tenía un error de puntero nulo que se solucionó añadiendo un tablero para cada juego del torneo.
   
   
### 9. Establecer criterio de distancia:

la fuerza depende de la distancia.

   Encargada: Diana 
   
   Estado: completo
   
   Comentarios:
   
### 10. Utilizar reflection para cargar todas las clases de un package

   Encargado: Luis 
   
   Estado: Completo +-
   
   Comentarios: Ya no se añaden bots de forma estática, para probar es necesario hacer un package o volver a añadirlos en la función                     initJugadores()
