# Guion del video de entrega

Duración objetivo: 3 minutos y 40 segundos. No superar cuatro minutos.

## 0:00–0:20 — Presentación

**Mostrar:** portada con el nombre del taller y los integrantes.

**Decir:**

“Somos Sebastián Peralta y Samuel Giraldo. Esta es nuestra solución del Taller 1 de Computación Móvil: un directorio de 120 usuarios desarrollado con Kotlin y Jetpack Compose.”

## 0:20–1:05 — Funcionamiento

**Mostrar:** aplicación abierta, total de usuarios, desplazamiento, selección de una persona, pantalla de detalle y teléfono.

**Decir:**

“Al abrir la aplicación se realiza una única consulta a DummyJSON. El encabezado indica que se cargaron 120 usuarios y permanece visible mientras desplazamos la lista. Cada elemento muestra nombre, apellido, empresa e imagen. Al seleccionar una persona vemos su nombre, apellido, imagen, empresa, teléfono y los campos adicionales. Al tocar el teléfono se abre el marcador, pero la aplicación no realiza la llamada.”

## 1:05–1:25 — Tema oscuro

**Mostrar:** cambiar el dispositivo a modo oscuro y volver a la aplicación.

**Decir:**

“Los colores provienen de MaterialTheme. Por eso la misma interfaz se adapta automáticamente al tema claro y al tema oscuro del dispositivo.”

## 1:25–1:55 — Organización

**Mostrar:** árbol de paquetes del proyecto.

**Decir:**

“El proyecto se separa en dos partes principales. En data están los modelos, la configuración de Ktor y el repositorio. En ui están el ViewModel, las pantallas, los componentes reutilizables, la navegación y el tema.”

## 1:55–2:35 — API y estado

**Mostrar:** `UsersApi.kt`, `UsersRepository.kt` y `UsersViewModel.kt`.

**Decir:**

“Ktor utiliza el motor Android y ContentNegotiation para convertir el JSON en data classes. El repositorio guarda el resultado y utiliza un Mutex; así, aunque se pida la información varias veces, la API se consulta solo una vez. El ViewModel publica un StateFlow con los estados Loading, Success y Error, y la interfaz reacciona al estado actual.”

## 2:35–3:20 — Compose y navegación

**Mostrar:** `UserListScreen.kt`, `UserDetailScreen.kt` y `UsersApp.kt`.

**Decir:**

“La lista usa LazyColumn, ListItem y stickyHeader, que son los componentes trabajados en clase. Las imágenes se cargan con Coil mediante un componente reutilizable. Navigation 3 maneja rutas serializables, rememberNavBackStack, NavDisplay y entryProvider. El usuario seleccionado viaja completo a la pantalla de detalle, de modo que no se hace otra consulta.”

## 3:20–3:40 — Cierre

**Mostrar:** `app/build.gradle.kts` y regresar a la aplicación.

**Decir:**

“Finalmente, el marcador usa ACTION_DIAL. Las versiones son Navigation 3 1.1.6, Ktor 3.5.2 y Coil 3.5.0. Con esto se cumplen los requisitos funcionales y técnicos del taller.”
