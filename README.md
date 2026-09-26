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
- Modalidad.

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
