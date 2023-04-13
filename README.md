# Documentación del proyecto Spring Boot Store

### Instalación y configuración
Requisitos previos
Antes de comenzar con la instalación y configuración de este proyecto, asegúrese de tener lo siguiente:

Java 19 instalado en su sistema
PostgreSQL instalado en su sistema y configurado con una base de datos
Una cuenta en GitHub y Git instalado en su sistema
Clonar el repositorio
Para clonar este repositorio, abra su terminal y ejecute el siguiente comando:

`git clone https://github.com/Angel-Raa/Spring-Boot-Store.git `

Configuración de la base de datos
Antes de ejecutar la aplicación, debe configurar la base de datos. Abra el archivo application.properties ubicado en src/main/resources y modifique las siguientes propiedades:

`spring.datasource.url=jdbc:postgresql://localhost:5432/tienda` 
 `spring.datasource.username=usuario` 
`spring.datasource.password=contraseña`

Reemplace usuario y contraseña con sus credenciales de PostgreSQL.

Ejecutar la aplicación
Para ejecutar la aplicación, abra su terminal y vaya al directorio raíz del proyecto. Luego, ejecute el siguiente comando:
Esto iniciará la aplicación en http://localhost:8080.

Uso
Una vez que la aplicación esté en ejecución, puede usarla para realizar las siguientes operaciones:

Registro de usuarios
Inicio de sesión de usuarios
Ver productos
Agregar productos al carrito de compras
Realizar pedidos
Tecnologías utilizadas
Este proyecto utiliza las siguientes tecnologías:

- Java 19
- Spring Boot 3
- Spring Security
- JWT
- PostgreSQL

Contribución
Si desea contribuir a este proyecto, siga los siguientes pasos:

Forkea el repositorio.
Cree una nueva rama con su función: `git checkout -b feature/nombre-de-la-funcion`.
Haga los cambios necesarios y confirme los cambios: git commit -am 'Agregue alguna función'.
Empuje la rama: git push origin feature/nombre-de-la-funcion.
Envíe una solicitud de extracción.
Licencia
Este proyecto está bajo la Licencia MIT.
