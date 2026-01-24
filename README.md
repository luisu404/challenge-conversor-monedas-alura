<h1 align="center"> Conversor de Moneda Luisu404 </h1>
<img width="100" height="100" alt="Logo" src="https://github.com/user-attachments/assets/a31fcd9e-2087-445e-b604-3914b5fd0d61" />


# 💱 Currency Convert Master

![Java](https://img.shields.io/badge/Java-24-orange?style=flat&logo=java)
![License](https://img.shields.io/badge/License-MIT-blue.svg)
![Status](https://img.shields.io/badge/Status-Activo-success)

Aplicación de consola desarrollada en Java para convertir monedas en tiempo real utilizando la API de ExchangeRate-API. Permite realizar conversiones entre diferentes divisas, guardar un historial de conversiones y consultarlo cuando sea necesario.

## 📋 Descripción

**Currency Convert Master** es un conversor de monedas interactivo que permite a los usuarios:
- ✅ Convertir entre múltiples monedas de forma rápida y sencilla
- ✅ Seleccionar monedas predefinidas o ingresar códigos personalizados
- ✅ Guardar un historial de todas las conversiones realizadas
- ✅ Consultar el historial completo con detalles de cada conversión
- ✅ Eliminar el historial cuando sea necesario

## 🚀 Características

- **Interfaz de consola intuitiva** con menús fáciles de navegar
- **Conversión de pares de monedas** con tasas de cambio en tiempo real
- **Monedas predefinidas** para acceso rápido (USD, EUR, DOP, ARS, COP, VES, BRL, HTG)
- **Códigos personalizados** para cualquier moneda soportada por la API
- **Historial de conversiones** guardado en formato JSON
- **Validación de entradas** para evitar errores del usuario
- **Manejo de excepciones** robusto para mayor estabilidad

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java 24
- **API**: [ExchangeRate-API](https://www.exchangerate-api.com/)
- **Librería JSON**: Gson (Google JSON)
- **Cliente HTTP**: HttpClient (Java 11+)

## 📦 Requisitos Previos

- Java JDK 11 o superior
- Conexión a Internet (para consultar la API)
- Librería Gson (incluida en el proyecto)


## 📖 Cómo Usar

### Menú Principal

Al iniciar la aplicación, verás el siguiente menú:
```
****** Seleccione las opción digitando el numero del menu *******
                      ************************  MENU  *************************
                      *     [1]. Convertir Monedas                            *
                      *     [2]. Ver Historia de Conversiones                 *
                      *     [3]. Eliminar historial de conversiones           *
                      *     [0]. Salir                                        *
                      *********************************************************
```

### 1️⃣ Convertir Monedas

1. Selecciona la opción `[1]` del menú principal
2. Elige la **moneda de origen** del submenú:
   - `[1]` USD - Dólar estadounidense
   - `[2]` DOP - Peso dominicano
   - `[3]` BRL - Real Brasileño
   - `[4]` ARS - Peso argentino
   - `[5]` COP - Peso colombiano
   - `[6]` VES - Bolívar Soberano venezolano
   - `[7]` EUR - Euro
   - `[8]` HTG - Gourde haitiano
   - `[9]` Otras monedas (ingresa el código, ej: JPY, GBP, CAD)
   - `[0]` Volver al menú principal

3. Elige la **moneda de destino** con las mismas opciones
4. Ingresa el **monto** a convertir (debe ser mayor a 0)
5. El sistema mostrará:
   - Tasa de conversión actual
   - Resultado de la conversión
   - Fecha de actualización de la tasa
6. Se te preguntará si deseas realizar otra conversión

**Ejemplo de conversión:**
```
Moneda ORIGEN: --> 1
Moneda DESTINO: --> 2
Monto: --> 100

-----------------------------------------------------------------
    Convirtiendo de: USD a DOP
    A la Fecha (23/01/2026 14:30:00) 1 USD = 58.50 DOP
    Resultado: 5850.00 DOP
✓ Conversión guardada en el historial
-----------------------------------------------------------------

¿Desea realizar otra conversión? (S/N): -->
```

### 2️⃣ Ver Historial

- Selecciona la opción `[2]` del menú principal
- Se mostrará un listado completo de todas las conversiones realizadas
- Cada conversión incluye:
  - Número de conversión
  - Monedas involucradas
  - Tasa de cambio aplicada
  - Resultado de la conversión
  - Fecha y hora de registro

**Ejemplo de historial:**
```
════════════════ HISTORIAL DE CONVERSIONES ════════════════

──────────── Conversión #1 ────────────
    Convirtiendo de: USD a DOP
    A la Fecha (23/01/2026 14:30:00) 1 USD = 58.50 DOP
    Resultado: 5850.00 DOP
Fecha de registro: 23/01/2026 14:30:15

──────────── Conversión #2 ────────────
    Convirtiendo de: EUR a USD
    A la Fecha (23/01/2026 15:00:00) 1 EUR = 1.09 USD
    Resultado: 109.00 USD
Fecha de registro: 23/01/2026 15:00:42

════════════════════════════════════════════════════════════
Total de conversiones: 2
```

### 3️⃣ Limpiar Historial

- Selecciona la opción `[3]` del menú principal
- Confirma la operación ingresando `S` (Sí) o `N` (No)
- El historial será eliminado permanentemente si confirmas

### 0️⃣ Salir

- Selecciona la opción `[0]` en cualquier menú para salir de la aplicación

## 📂 Estructura del Proyecto
```
currency-convert-master/
│
├── Principal.java              # Clase principal con el menú
├── ConvertirMonedas.java       # Lógica de conversión
├── ConversorService.java       # Servicio de API
├── PairConversionModel.java    # Modelo de datos
├── Utilidades.java             # Métodos auxiliares
├── HistorialConversiones.json  # Archivo de historial (generado automáticamente)
├── gson-2.10.1.jar            # Librería Gson
└── README.md                   # Este archivo
```

## 🔑 Configuración de la API

La aplicación utiliza la API de ExchangeRate-API. La clave API está configurada en `ConversorService.java`:
```java
String apiKey = "TU_API_KEY";
```

> **Nota**: Puedes obtener tu propia API key gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/)

## 📊 Ejemplo de Archivo JSON

El historial se guarda en `HistorialConversiones.json` con el siguiente formato:
```json
[
  {
    "time_last_update_utc": "Fri, 23 Jan 2026 14:30:00 +0000",
    "base_code": "USD",
    "target_code": "DOP",
    "conversion_rate": 58.5,
    "conversion_result": 5850.0,
    "fecha_registro": "Jan 23, 2026 2:30:15 PM",
    "monto": 100.0
  }
]
```

## ⚠️ Manejo de Errores

La aplicación incluye validaciones para:
- ❌ Entrada de letras donde se esperan números
- ❌ Montos negativos o cero
- ❌ Opciones fuera del rango del menú
- ❌ Códigos de moneda inválidos
- ❌ Errores de conexión a la API
- ❌ Archivos JSON corruptos


## 👨‍💻 Autor

**Desarrollado por:** [luisu404](https://github.com/luisu404)

**Proyecto:** Challenge - Conversor de Monedas  
**Programa:** Oracle Next Education (ONE) - Alura Latam  
**Fecha:** Enero 2026

---

## 🌟 Agradecimientos

- **Alura Latam** y **Oracle Next Education** por la oportunidad de aprendizaje
- **ExchangeRate-API** por proporcionar la API de tasas de cambio
- **Google Gson** por la librería de manejo de JSON

---

### 📧 Contacto

¿Tienes preguntas o sugerencias? No dudes en contactarme:

- GitHub: [@luisu404](https://github.com/luisu404)

---

⭐ **Si te ha gustado este proyecto, no olvides darle una estrella en GitHub!** ⭐
