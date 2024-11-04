# Guía de Inicialización del Proyecto

## Prerrequisitos

Asegúrate de tener instalados los siguientes componentes en tu sistema:

- Java Development Kit (JDK) 11 o superior
- PostgreSQL 17
- Gradle
- Git

## Clonar el Repositorio

Clona el repositorio del proyecto desde GitHub y cárgalo en Intellij:

```sh
git clone https://github.com/onicalls/tbd_ayudantia2.git
cd tbd_ayudantia2
```

## Configuración de la Base de Datos

En la dirección del proyecto `src/main/resources/datitos/` encontrarás el archivo `createDB.sql`, para crear la base de datos.
Luego puedes poblarla con el archivo `establecimiento.sql`. Si la tienes poblada y quieres probar los triggers, ejecuta el archivo `functions.sql`.

## Sobre la aplicación

Esta ayudantía trata sobre Spring Security, CORS y JWT. Revisa la dirección `src/main/java/tbd/ayudantia2/config` para encontrar las clases creadas para este proyecto. También revisa los controladores de register y login en la dirección `src/main/java/tbd/ayudantia2/controller`. Cada una de ellas está documentado para que puedas entender qué se ha hecho.

## Cliente para probar el backend

Personalmente recomiendo el plugin freemium de Intellij llamado JetClient. Sino, puedes utilizar Postman como vieja confiable. Aquí tienes unas instrucciones a seguir para verificar que todo funciona en orden:

```json
METODO POST
http://localhost:8080/auth/register

BODY EN JSON:
{
  "username": "sepamoyin",
  "password": "SuperContraseña123.",
  "email": "sepamoyin@usach.cl",
  "rol": "ADMIN" // Puedes cambiarlo a ADMIN, MOD u otro
}
```

```json
METODO POST
http://localhost:8080/auth/login

BODY EN JSON:
{
  "username": "sepamoyin",
  "password": "SuperContraseña123."
}

DEL HEADER DE LA RESPUESTA, COPIA EL VALOR DE LA KEY "Authorization"
```

```json
METODO GET
http://localhost:8080/establecimientos/126704
http://localhost:8080/establecimientos/

AUTH DEL ESTILO BEARER TOKEN: pegar el valor de la key "Authorization" que copiaste en el paso anterior
```
