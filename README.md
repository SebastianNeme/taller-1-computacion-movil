# Taller 1: Layouts y listas en Android Compose

## Integrantes

- Sebastián Peralta Neme (`SebastianNeme`)
- Samuel Enrique Giraldo Sabogal (`Segiraldo0610`)

## Estado actual

La aplicación está implementada, compila correctamente y fue validada en un emulador Pixel 6 con Android 15. Incluye la consulta de usuarios, la lista, el detalle, la navegación, el tema oscuro y la apertura del marcador.

## Descripción

Aplicación Android desarrollada en Kotlin y Jetpack Compose que consulta la API de DummyJSON y muestra un directorio con 120 usuarios. Desde la lista se puede seleccionar una persona para consultar su información completa.

La información se obtiene desde:

`https://dummyjson.com/user?limit=120`

## Funcionalidades implementadas

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

## Funcionamiento

Al iniciar la aplicación, Ktor consulta la lista de usuarios. El repositorio conserva el resultado en memoria para impedir llamadas adicionales durante la ejecución. Cuando se selecciona un usuario, el objeto completo se envía a la pantalla de detalle mediante Navigation 3.

Las imágenes se cargan con Coil. El número telefónico utiliza `Intent.ACTION_DIAL`, por lo que la aplicación abre el marcador del dispositivo sin iniciar la llamada automáticamente.

## Tecnologías

- Kotlin
- Jetpack Compose y Material 3
- Navigation 3, versión 1.1.6
- Ktor Client, versión 3.5.2
- Coil, versión 3.5.0
- Kotlin Serialization
- ViewModel y StateFlow

## Organización del proyecto

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

La distribución de las etapas está registrada en [PLAN_TRABAJO.md](PLAN_TRABAJO.md).

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

## Pruebas

Las pruebas unitarias verifican:

- El parseo de la respuesta JSON aunque la API envíe campos adicionales.
- Que varias solicitudes concurrentes produzcan una sola consulta.
- Que un resultado fallido también quede almacenado y no repita la petición.

Para ejecutar pruebas, análisis estático y compilación:

```powershell
.\gradlew.bat testDebugUnitTest lintDebug assembleDebug
```

## Sustentación

- [Guía de sustentación](GUIA_SUSTENTACION.md)
- [Guion del video](GUION_VIDEO.md)
- [Lista de comprobación de la entrega](CHECKLIST_ENTREGA.md)
- [Resultados de verificación](VERIFICACION.md)

## Entrega del taller

La entrega debe incluir:

- Código fuente del proyecto en un archivo ZIP o RAR.
- APK de depuración.
- Enlace público o no listado de YouTube con un video de máximo cuatro minutos.

En el video se deben mostrar las funcionalidades de la aplicación y explicar brevemente la organización de paquetes, los componentes, las pantallas, la navegación y el consumo de la API con Ktor.
