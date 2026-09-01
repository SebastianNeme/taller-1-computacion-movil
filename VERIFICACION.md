# Resultados de verificación

Fecha: 1 de septiembre de 2026.

## Compilación automatizada

Comando ejecutado:

```powershell
.\gradlew.bat clean testDebugUnitTest lintDebug assembleDebug
```

Resultado: `BUILD SUCCESSFUL`.

- Pruebas ejecutadas: 3.
- Fallos: 0.
- Errores: 0.
- APK generado: `app/build/outputs/apk/debug/app-debug.apk`.

El análisis estático no encontró errores. Los avisos restantes corresponden únicamente a versiones más recientes disponibles; se conservaron Navigation 3 1.1.6, Ktor 3.5.2 y Coil 3.5.0 para coincidir con las versiones solicitadas en el taller.

## Pruebas unitarias

- Parseo de `UsersResponse` ignorando campos adicionales.
- Cinco solicitudes concurrentes utilizan una sola llamada a la fuente.
- Un resultado fallido queda almacenado y tampoco repite la llamada.

## API

Se comprobó directamente que `https://dummyjson.com/user?limit=120` responde correctamente y entrega el arreglo `users`. La aplicación mostró 120 elementos recibidos de esa consulta.

## Prueba funcional

Dispositivo de prueba: Pixel 6 virtual con Android 15, API 35.

- La lista mostró 120 usuarios con nombre, apellido, empresa e imagen.
- El encabezado continuó visible después de desplazar la lista.
- El detalle mostró nombre, apellido, empresa, teléfono, correo, edad, género, altura, peso y universidad.
- El marcador se abrió con el teléfono del usuario seleccionado y no se inició la llamada.
- Al regresar desde el detalle apareció la lista almacenada sin mostrar un nuevo estado de carga.
- La lista y el detalle se comprobaron en tema oscuro.
- El registro `AndroidRuntime` no presentó errores fatales durante el recorrido.
