# **ArqueoBD - Gestión de Yacimientos Arqueológicos**

ArqueoBD es una aplicación web diseñada para la gestión y administración de bases de datos de yacimientos arqueológicos. Permite almacenar, consultar y administrar información relevante sobre los yacimientos, facilitando el trabajo de investigadores y arqueólogos.

## **Estado del Proyecto**

**En desarrollo:** Actualmente se han implementado funcionalidades básicas para la gestión de yacimientos, incluyendo la integración con **PostgreSQL** como base de datos principal. Pronto se agregará la interfaz frontend con **Angular**.

---

## **Tecnologías Utilizadas**

El proyecto utiliza las siguientes tecnologías:

### **Backend**
- **Spring Boot:** Framework para el desarrollo de aplicaciones backend en Java.
- **JPA (Java Persistence API):** Librería para la gestión de la persistencia de datos.
- **PostgreSQL:** Base de datos utilizada en el entorno de producción.
- **H2:** Base de datos en memoria para pruebas.
- **Lombok:** Para reducir el código boilerplate en las entidades y servicios.
- **Spring Validation:** Para validación de datos.

### **Frontend (Próximamente)**
- **Angular:** Framework para la construcción de una interfaz de usuario interactiva y dinámica.

---

## **Instalación y Ejecución**

### **Requisitos Previos**
Antes de ejecutar el proyecto, asegúrate de tener instalado en tu sistema:
- **Java 17 o superior**
- **Maven**
- **PostgreSQL** (con una base de datos creada llamada `bd_arqueobd`)

### **Configuración de la Base de Datos**
Asegúrate de configurar tu PostgreSQL con las siguientes credenciales en el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:8081/bd_arqueobd
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.database=POSTGRESQL
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
```

### **Clonar el repositorio**
Ejecuta el siguiente comando:

```bash
git clone https://github.com/marcospaab/ArqueoBD.git
```

### **Ejecutar el Proyecto**
Navega al directorio del proyecto y ejecuta:

```bash
cd ArqueoBD
mvn spring-boot:run
```

Accede a la aplicación a través del navegador en:

```
http://localhost:8080
```

---

## **Estructura del Proyecto**

El proyecto está organizado en las siguientes secciones:

- **Backend:** Maneja la lógica del servidor y la interacción con la base de datos.
- **Base de Datos:** Ahora utiliza **PostgreSQL** como base de datos principal y **H2** para pruebas.
- **Frontend:** Se desarrollará con **Angular** en futuras actualizaciones.

---

## **Futuras Mejoras**

- **Implementación del frontend con Angular**
- **Autenticación y autorización de usuarios**
- **Mejoras en el sistema de búsqueda y filtrado de yacimientos**
- **Optimización del rendimiento y seguridad**

---

## **Contacto**
Si tienes alguna pregunta o sugerencia, no dudes en ponerte en contacto:

📧 **Email:** marcos.padin@outlook.es

