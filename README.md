# demo-semaforos
Proyecto de la asignatura Programación Concurrente 2023.

Se plantea un problema relacionado con la asignación de turnos en un establecimiento deportivo que dispone de dos canchas de fútbol 5 para alquiler.
El objetivo es permitir a los usuarios reservar un turno en una de las dos canchas de forma concurrente y asegurar que solo un usuario pueda reservar
una cancha en un momento dado.
Se ha propuesto una solución utilizando semáforos. Cada cancha está representada por un semáforo. Cuando un usuario solicita una cancha, el sistema 
verifica si la cancha está disponible. Si lo está, se reserva para el usuario. Si no, el usuario recibe una notificación de que no pudo reservar la cancha. 
Esto permite la concurrencia de múltiples usuarios y garantiza que solo uno de ellos pueda reservar la cancha en un momento dado.
