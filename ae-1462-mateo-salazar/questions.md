# Preguntas — Arquitectura en Capas

## 1. ¿Qué es un controlador?
Un controlador es la capa que recibe las peticiones HTTP del cliente y devuelve una respuesta.

## 2. ¿Qué responsabilidad tiene la capa de servicio?
La capa de servicio contiene la lógica de negocio de la aplicación y coordina el proceso entre el controlador y el repositorio.

## 3. ¿Qué hace el repositorio?
El repositorio se encarga de comunicarse con la base de datos para guardar, consultar o recuperar información.

## 4. ¿Qué es una entidad?
Una entidad es una clase que representa una tabla de la base de datos y sus campos representan columnas.

## 5. ¿Para qué sirve un DTO?
Un DTO sirve para transportar datos entre el cliente y la API sin exponer directamente la entidad de la base de datos.

## 6. ¿Cuál es la diferencia entre un Request y un Response?
Un Request contiene los datos que el cliente envía a la API, mientras que un Response contiene los datos que la API devuelve al cliente.

## 7. ¿Por qué separamos la aplicación en capas?
Separamos la aplicación en capas para organizar mejor el código, facilitar el mantenimiento y separar responsabilidades.

## 8. ¿Qué anotación se usa para marcar un controlador REST? ¿Y un servicio?
Para marcar un controlador REST se usa `@RestController` y para marcar un servicio se usa `@Service`.

## 9. ¿Qué hace `@RequestBody` en un endpoint?
`@RequestBody` permite tomar el cuerpo de una petición HTTP y convertirlo en un objeto de Kotlin.

## 10. ¿Cuál es el flujo que sigue un request desde que llega hasta que se guarda en la base de datos?
El request llega al controlador, luego el controlador llama al servicio, el servicio aplica la lógica de negocio y finalmente usa el repositorio para guardar la entidad en la base de datos.