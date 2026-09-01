# Plan de trabajo

La aplicación se construirá por partes para que los dos integrantes participen en decisiones y código. La versión completa que existe de manera local se usará únicamente como referencia de comprobación.

## Etapa 1: preparación

- Crear el repositorio privado.
- Agregar a los integrantes.
- Registrar las instrucciones y tecnologías del taller en el README.

## Etapa 2: proyecto base

- Crear el proyecto Android con Kotlin y Jetpack Compose.
- Configurar los temas claro y oscuro.
- Agregar Navigation 3, Ktor, Coil y Kotlin Serialization.
- Declarar el permiso de Internet.
- Comprobar que la aplicación base compile.

## Etapa 3: datos y lista

Responsable inicial: Samuel.

- Crear los modelos `User`, `Company` y `UsersResponse`.
- Configurar el cliente Ktor y consultar DummyJSON.
- Mostrar los usuarios con `LazyColumn` y `ListItem`.
- Agregar el encabezado fijo con el total de usuarios.
- Cargar las imágenes con Coil.

## Etapa 4: detalle y navegación

Responsable inicial: Sebastián.

- Definir las rutas con Navigation 3.
- Navegar de la lista al detalle pasando el usuario seleccionado.
- Mostrar el teléfono y por lo menos seis campos adicionales.
- Abrir el marcador con `Intent.ACTION_DIAL`.

## Etapa 5: integración

Trabajo conjunto.

- Garantizar que la API se consulte una sola vez.
- Revisar los estados de carga y error.
- Probar los temas claro y oscuro.
- Ejecutar las pruebas y generar el APK.
- Grabar el video de máximo cuatro minutos.

## Forma de trabajo

Cada integrante creará una rama para su parte. Los cambios se revisarán mediante un pull request antes de integrarlos. Ninguna rama debe incluir archivos generados por Android Studio o carpetas `build`.
