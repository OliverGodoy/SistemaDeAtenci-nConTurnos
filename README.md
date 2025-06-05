# 🎟️ Sistema de Atención con Turnos

Este proyecto es una aplicación desarrollada con **Spring Boot** que gestiona la asignación y atención de turnos para clientes. Su arquitectura modular y el uso de tecnologías modernas permiten una implementación eficiente y escalable en diversos entornos.

---

## ✨ Características Principales

- ✅ **Arquitectura basada en Spring Boot**  
  Utiliza la anotación `@SpringBootApplication` para habilitar la configuración automática y la detección de componentes, facilitando el desarrollo y mantenimiento de la aplicación.

- 🔄 **Inyección de dependencias**  
  Implementa patrones de inyección de dependencias mediante constructores, promoviendo un código limpio y desacoplado.

- 📁 **Estructura de paquetes organizada**
  - `example.persistence`: Contiene la clase principal `PersistenceApplication`.
  - `example.persistence.entity`: Define las entidades JPA y modelos de dominio.
  - `example.persistence.repository`: Interfaces para el acceso a datos.
  - `example.persistence.service`: Lógica de negocio y servicios de la aplicación.

- 📨 **Integración con RabbitMQ**  
  Configura automáticamente componentes para la mensajería asincrónica, como fábricas de conexión, plantillas de Rabbit y contenedores de escucha de mensajes.

- 🗃️ **Soporte para MongoDB y JPA**  
  Permite la interacción con bases de datos relacionales y no relacionales, ofreciendo flexibilidad en la gestión de datos.

---

## 🧬 Estructura de la Aplicación

La clase principal `PersistenceApplication` sirve como punto de entrada de la aplicación y se encuentra en el paquete `example.persistence`.

Al iniciar, la aplicación realiza las siguientes acciones:

- 🟢 Inicializa el consumidor de RabbitMQ y registra los logs correspondientes.  
- 📤 Envía mensajes inmediatos utilizando el `MessageService`.  
- 📝 Crea entradas de log iniciales a través del `LogRepository`.

---

## 📚 Documentación Adicional

Para obtener más información sobre la arquitectura, el modelo de datos, el sistema de mensajería y otros componentes clave del proyecto, puedes consultar la documentación detallada en el siguiente enlace:

🔗 [Estructura de la Aplicación - Sistema de Atención con Turnos](https://deepwiki.com/OliverGodoy/SistemaDeAtenci-nConTurnos/1.1.1-application-structure)

---
