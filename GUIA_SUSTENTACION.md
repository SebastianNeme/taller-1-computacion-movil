# Guía de sustentación

## ¿Qué hace la aplicación?

Consulta 120 usuarios de DummyJSON y los presenta en una lista. Cada elemento muestra nombre, apellido, empresa e imagen. Al seleccionar una persona se abre un detalle con su información, y al tocar el teléfono se abre el marcador sin iniciar la llamada.

## ¿Por qué se usa `LazyColumn`?

La lista contiene 120 elementos. `LazyColumn` solo compone los elementos visibles y los que están próximos a aparecer. Esto evita crear toda la lista al mismo tiempo y corresponde al patrón trabajado en clase para listas desplazables.

Cada usuario se representa con `ListItem`. El encabezado usa `stickyHeader`, por lo que el total de usuarios continúa visible al desplazarse.

## ¿Cómo se consulta la API?

`UsersApi` configura un `HttpClient` de Ktor con el motor Android. `ContentNegotiation` y Kotlin Serialization convierten automáticamente el JSON en `UsersResponse`, `User` y `Company`.

`ignoreUnknownKeys` permite ignorar los campos de DummyJSON que la aplicación no necesita. La función de consulta es `suspend`, así que no bloquea la interfaz.

## ¿Cómo se garantiza una sola consulta?

`UsersRepository` guarda un `Result<List<User>>` en memoria. La primera solicitud consulta la API; las siguientes reciben el resultado guardado. El `Mutex` evita que dos solicitudes simultáneas ejecuten dos consultas antes de que se complete la primera.

La pantalla de detalle recibe el usuario que ya estaba cargado. Por eso no necesita volver a consultar la API.

## ¿Cómo se maneja el estado?

`UsersViewModel` expone un `StateFlow` con tres posibilidades:

- `Loading`: la consulta está en curso.
- `Success`: contiene la lista recibida.
- `Error`: contiene una explicación del problema.

La pantalla observa el estado con `collectAsStateWithLifecycle`, evitando mantener observaciones innecesarias cuando la actividad no está visible.

## ¿Cómo funciona la navegación?

Navigation 3 utiliza dos rutas serializables que implementan `NavKey`: una para la lista y otra para el detalle. `rememberNavBackStack` conserva la pila, `NavDisplay` muestra la ruta actual y `entryProvider` relaciona cada ruta con su pantalla.

La ruta de detalle contiene el `User` seleccionado. Al volver se elimina la última ruta y se muestra nuevamente la misma lista almacenada.

## ¿Cómo se cargan las imágenes?

`UserAvatar` usa Coil mediante `SubcomposeAsyncImage`. Mientras se descarga la imagen, o si ocurre un error, muestra un ícono de persona. El componente se reutiliza en la lista y en el detalle con tamaños diferentes.

## ¿Cómo se abre el teléfono?

Se construye un `Intent` con `Intent.ACTION_DIAL` y un URI con esquema `tel:`. Esto abre el marcador con el número preparado, pero no realiza la llamada. Por eso no se solicita el permiso para llamar directamente.

## ¿Cómo se soportan los temas?

`Taller1Theme` consulta `isSystemInDarkTheme` y selecciona un esquema claro u oscuro de Material 3. Todos los componentes utilizan colores de `MaterialTheme`, de modo que se adaptan automáticamente.

## Versiones exigidas

- Navigation 3: 1.1.6.
- Ktor: 3.5.2.
- Coil: 3.5.0.

## Preguntas que podrían hacer

### ¿Por qué no se consulta un usuario individual en el detalle?

Porque el taller exige conservar la lista y evitar una nueva consulta. El objeto seleccionado ya contiene toda la información necesaria.

### ¿Qué diferencia hay entre el modelo y el estado de interfaz?

`User` representa los datos recibidos. `UsersUiState` representa lo que debe mostrar la pantalla en un momento determinado: carga, resultado o error.

### ¿Qué sucede si la API agrega campos?

La deserialización continúa funcionando porque se configuró `ignoreUnknownKeys`.

### ¿Por qué se usa `ACTION_DIAL` y no `ACTION_CALL`?

`ACTION_DIAL` deja la decisión final al usuario y no necesita el permiso sensible para realizar llamadas.
