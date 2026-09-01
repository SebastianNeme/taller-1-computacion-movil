# Taller 1: Layouts y listas en Android Compose

## Integrantes

- Sebastián Peralta Neme (`SebastianNeme`)
- Samuel Enrique Giraldo Sabogal (`Segiraldo0610`)

## Estado actual

El repositorio contiene únicamente la base del proyecto Android correspondiente a la etapa 2. Las funcionalidades del taller se desarrollarán en ramas separadas para que ambos integrantes participen.

## Descripción

El objetivo es desarrollar una aplicación Android en Kotlin y Jetpack Compose que consulte la API de DummyJSON y muestre un directorio con 120 usuarios. Desde la lista se podrá seleccionar una persona para consultar su información completa.

La información se obtiene desde:

`https://dummyjson.com/user?limit=120`

## Funcionalidades solicitadas

- Consulta de los 120 usuarios en una sola petición.
- Lista construida con `LazyColumn` y `ListItem`.
- Nombre, apellido, empresa e imagen de cada usuario.
- Encabezado fijo con el número total de usuarios cargados.
- Pantalla de detalle con empresa, teléfono, correo, edad, género, altura, peso y universidad.
- Apertura del marcador del teléfono al seleccionar el número del usuario.
- Navegación entre la lista y el detalle sin realizar una nueva consulta a la API.
- Manejo de los estados de carga, resultado y error.
- Compatibilidad con tema claro y oscuro.
- Componentes reutilizables para las imágenes y los campos de detalle.

## Funcionamiento esperado

Al iniciar la aplicación, Ktor deberá consultar la lista de usuarios. El resultado quedará almacenado en memoria para evitar llamadas adicionales durante la ejecución. Cuando se seleccione un usuario, el objeto correspondiente se enviará a la pantalla de detalle mediante Navigation 3.

Las imágenes se cargarán con Coil. El número telefónico utilizará `Intent.ACTION_DIAL`, por lo que la aplicación abrirá el marcador del dispositivo sin iniciar la llamada automáticamente.

## Tecnologías previstas

- Kotlin
- Jetpack Compose y Material 3
- Navigation 3, versión 1.1.6
- Ktor Client, versión 3.5.2
- Coil, versión 3.5.0
- Kotlin Serialization
- ViewModel y StateFlow

## Organización prevista del proyecto

```text
data/model        Modelos de la respuesta de DummyJSON
data/remote       Configuración de Ktor y consulta de la API
data/repository   Almacenamiento de la respuesta en memoria
ui/components     Componentes reutilizables
ui/navigation     Rutas y navegación entre pantallas
ui/screens        Pantallas de lista y detalle
ui/theme          Colores y temas de la aplicación
ui/viewmodel      Estado y lógica de la interfaz
```

La distribución propuesta de las etapas y responsabilidades está en [PLAN_TRABAJO.md](PLAN_TRABAJO.md). Puede ajustarse entre los integrantes antes de comenzar cada etapa.

## Ejecución

1. Abrir el proyecto en Android Studio.
2. Esperar a que termine la sincronización de Gradle.
3. Seleccionar un emulador o un dispositivo Android.
4. Ejecutar la aplicación desde Android Studio.

También se puede compilar y ejecutar las pruebas desde una terminal en Windows:

```powershell
.\gradlew.bat testDebugUnitTest assembleDebug
```

El APK de depuración se genera en:

```text
app/build/outputs/apk/debug/app-debug.apk
```

La aplicación requiere Android 6.0, API 23, o una versión posterior y necesita acceso a Internet.

## Entrega del taller

La entrega debe incluir:

- Código fuente del proyecto en un archivo ZIP o RAR.
- APK de depuración.
- Enlace público o no listado de YouTube con un video de máximo cuatro minutos.

En el video se deben mostrar las funcionalidades de la aplicación y explicar brevemente la organización de paquetes, los componentes, las pantallas, la navegación y el consumo de la API con Ktor.
