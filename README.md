# Disney Characters App

## Descripción del Proyecto

Disney Characters App es una aplicación Android desarrollada en Kotlin que consume la API pública de Disney para mostrar un listado de personajes. La aplicación permite consultar personajes, visualizarlos en una interfaz moderna construida con Jetpack Compose y gestionar una lista de favoritos persistida localmente.

El proyecto fue desarrollado utilizando Clean Architecture, el patrón MVVM y principios SOLID.

## Funcionalidades

* Consumo de API REST utilizando Retrofit.
* Carga asíncrona mediante Kotlin Coroutines.
* Listado de personajes Disney.
* Seleccionar favoritos.
* Persistencia local de favoritos utilizando Room.
* Pantalla de personajes favoritos.
* Persistencia de datos después de cerrar y abrir la aplicación.
* Navegación entre pantallas con Navigation Compose.
* Interfaz desarrollada con Jetpack Compose.

## Arquitectura Utilizada

El proyecto sigue los principios de Clean Architecture y MVVM:

### Presentation

Responsable de la interfaz de usuario y manejo del estado.

Componentes principales:

* Screens
* ViewModels
* UiState
* Navigation

### Domain

Contiene la lógica de negocio de la aplicación.

Componentes principales:

* Models
* Repository Interfaces
* Use Cases

### Data

Responsable de obtener y almacenar datos.

Componentes principales:

* Retrofit API Service
* DTOs
* Room Database
* DAO
* Repository Implementations
* Mappers

## Librerías Utilizadas

### Jetpack Compose

Construcción de la interfaz de usuario.

### Navigation Compose

Navegación entre pantallas.

### Retrofit

Consumo de servicios REST.

### Gson Converter

Conversión de respuestas JSON a objetos Kotlin.

### Kotlin Coroutines

Manejo de operaciones asíncronas.

### StateFlow

Gestión reactiva del estado de la UI.

### Room

Persistencia local de favoritos.

### Hilt

Inyección de dependencias.

### Coil

Carga y visualización de imágenes desde URLs.

## API Utilizada

Disney API

https://disneyapi.dev/

## Instrucciones para Ejecutar el Proyecto

### Requisitos

* Android Studio Koala o superior
* JDK 17
* Android SDK 35
* Gradle compatible con el proyecto

### Clonar repositorio

```bash
git clone https://github.com/TU_USUARIO/DisneyCharactersApp.git
```

### Abrir proyecto

1. Abrir Android Studio.
2. Seleccionar "Open".
3. Elegir la carpeta del proyecto.
4. Sincronizar dependencias
5. Conectar dispositivo o iniciar emulador
6. Ajecutar la aplicación


## Autor

Carolina América Moctezuma Vega

Android Developer | QA Tester

