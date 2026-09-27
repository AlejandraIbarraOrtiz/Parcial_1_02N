# 🚗 RentCar - Sistema de Gestión de Alquiler de vehículos

## Programación II
### Parcial 1 - Patrones creacionales

### 👥 Integrantes
- Alejandra Ibarra Ortiz
- Jose Alberto Hernández León

---

 ## 📌 Descripción

<p align="justify">
RentCar es una aplicación desarrollada en Java y JavaFX para gestionar
la información de una empresa de alquiler de vehículos.

El sistema permite administrar la información necesaria para el proceso
de alquiler, organizando las diferentes funcionalidades mediante una estructura
que busca mantener el código ordenado, desacoplado y fácil de mantener.
</p>

---

## 🧠 Pensamiento computacional

### 🔹 Abstracción

### ¿Qué se solicita finalmente?

<p align = "justify">
Se solicita desarrollar un sistema que permita gestionar los clientes,
vehículos, modalidades de alquiler, reservas y servicios adicionales
ofrecidos por una empresa de alquiler de vehículos.
</p>

### ¿Qué información es relevante?

- Datos del cliente.
- Datos de la modalidad de alquiler.
- Datos del vehículo.
- Información de los servicios adicionales.
- Datos de la empresa.

### ¿Cómo se agrupa la información?

#### 👤 Cliente
- Nombre.
- ID.
- Teléfono.
- Correo electrónico.
- Edad.
- Fecha de registro.

#### 🚘 Modalidad de alquiler
- Código.
- Nombre.
- Descripción.
- Duración mínima en días.
- Valor diario.
- Estado: disponible, suspendido o finalizado.

#### 🚙 Vehículo
- Placa.
- Marca.
- Modelo.
- Año.
- Tipo.
- Tarifa diaria.

#### 🧾 Servicio adicional
- Código.
- Nombre.
- Descripción.
- Precio.
- Disponibilidad.

#### 🏢 Empresa
- Nombre comercial.
- NIT.
- Dirección.
- Teléfono.
- Correo electrónico.
- Página web.

### ¿Qué funcionalidades se solicitan finalmente?

- Registrar clientes.
- Registrar modalidades de alquiler.
- Registrar vehículos.
- Solicitar servicios adicionales.
- Realizar consultas sobre clientes.
- Calcular los ingresos generados.

---

## 🔹 Descomposición

### ¿Cómo se distribuyen las funcionalidades?

Las funcionalidades del sistema se distribuyen entre diferentes clases,
permitiendo que cada una tenga una responsabilidad específica.

- **Cliente:** contiene la información correspondiente a los clientes.
- **AdministradorClientes:** administra el registro, búsqueda, modificación y eliminación de clientes.
- **Vehículo:** contiene la información de los vehículos disponibles para alquiler.
- **Modalidad de alquiler:** contiene la información y características de cada modalidad de alquiler.
- **Servicio adicional:** contiene la información de los servicios adicionales ofrecidos por RentCar.
- **RentCarSingleton:** contiene la información general de la empresa y permite acceder a una única instancia de RentCar.
- **Validadores:** se encargan de realizar las validaciones necesarias sobre la información de los clientes.

### ¿Qué debo hacer para probar las funcionalidades?

- Registrar clientes y verificar sus datos.
- Buscar clientes mediante su número de teléfono.
- Verificar si el teléfono de un cliente corresponde a un número perfecto.
- Modificar la información permitida de un cliente.
- Eliminar clientes registrados.
- Registrar vehículos.
- Crear un vehículo a partir de otro utilizando Prototype.
- Crear las diferentes modalidades de alquiler.
- Comprobar que los datos de la empresa sean los mismos al utilizar la instancia de RentCar.

## 🔹 Reconocimiento de patrones

### ¿Qué puedo reutilizar de la solución de otros problemas?

Se pueden reutilizar los patrones creacionales y la implementación de los
principios SOLID para organizar las responsabilidades y la creación de objetos
dentro del sistema.

### Patrones creacionales

- **Singleton:** utilizado en RentCarSingleton para mantener una única instancia de la empresa.
- **Builder:** utilizado para construir las modalidades de alquiler con sus diferentes características.
- **Factory:** utilizado para crear los diferentes tipos de modalidades de alquiler.
- **Prototype:** utilizado en Vehiculo para crear un vehículo a partir de otro existente.

  ### Principios SOLID

Durante el desarrollo se busca aplicar los principios SOLID mediante la
separación de responsabilidades y el uso de interfaces.

- **Responsabilidad única:** las clases tienen responsabilidades específicas. Por ejemplo, `Cliente` almacena la información del cliente, AdministradorClientes gestiona los clientes y las clases validadoras realizan las validaciones.
- **Abierto/Cerrado:** el uso de interfaces y patrones permite agregar nuevas implementaciones sin modificar completamente las existentes.
- **Sustitución de Liskov:** las implementaciones pueden utilizarse mediante las interfaces definidas para los patrones.
- **Segregación de interfaces:** se utilizan interfaces específicas para las responsabilidades necesarias.
- **Inversión de dependencias:** se utilizan abstracciones en los patrones creacionales para reducir el acoplamiento entre clases.

---

## 🔹 Codificación

### ¿Cómo se prueba la solución en Java?

La solución se prueba ejecutando el proyecto y verificando las funcionalidades
implementadas. Se realizan pruebas de registro, búsqueda, modificación y
eliminación de clientes, gestión de vehículos y creación de modalidades.

También se verifica el funcionamiento de los patrones creacionales Singleton,
Builder, Factory y Prototype, comprobando que cada uno cumpla con la función
para la cual fue implementado.

### ¿Cómo se escribe la solución en Java?

La solución se desarrolla utilizando programación orientada a objetos,
definiendo las clases, atributos, métodos y relaciones necesarias para
representar el sistema de gestión de alquiler de vehículos.

Se aplican los patrones creacionales Singleton, Builder, Factory y Prototype
para organizar la creación y configuración de objetos.

Además, se utiliza JavaFX para desarrollar la interfaz gráfica y una
arquitectura MVC para separar el modelo, las vistas y los controladores.

---

# 🧩 Arquitectura MVC

El proyecto utiliza la arquitectura MVC para separar las responsabilidades
de la aplicación:

- **Modelo:** contiene las clases que representan los datos y la lógica del sistema.
- **Vista:** está formada por los archivos FXML utilizados para la interfaz gráfica.
- **Controlador:** recibe las acciones realizadas desde las vistas y permite la comunicación con la lógica del sistema.

---

# 📊 Diagrama de clases

El diagrama de clases representa las principales clases del sistema,
sus atributos, métodos, relaciones y multiplicidades.

---

# 📂 Repositorio

El código fuente y el historial de desarrollo del proyecto se encuentran
disponibles en este repositorio.
