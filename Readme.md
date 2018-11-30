## Workshop FMCat

Barcelona, 17 de Noviembre de 2018

[![Documentation Status](https://readthedocs.org/projects/fmcat-vii-presentation/badge/?version=latest)](https://fmcat-vii-presentation.readthedocs.io/en/latest/?badge=latest)
                

### Desarrollo de Aplicaciones híbridas web/mobile para sistemas FileMaker

#### Descripción

Taller de iniciación a la creación de aplicaciones híbridas, para navegador o nativas para plataformas móviles, empleando fuentes de datos FileMaker.
Se mostrará el proceso de creación de aplicaciones empleando tecnologías de ultima generación en cada una de las partes, desde el acceso a los datos mediante una API REST a medida o empleando la DATA API de FileMaker Server hasta la creación de los clientes tanto en versión HTML/Javascript/CSS para navegadores convencionales como versiones nativas para dispositivos móviles iOS, Android o Windows.

Los trabajos del taller se enfocaran primero en configurar las tecnologías básicas a emplear en cada área valorando las distintas opciones existentes y analizando las razones de elección en cada caso, aunque finalmente se mostraran las opciones existentes para la automatización y generación de aplicaciones que reducen dramáticamente la complejidad y tiempo de desarrollo. Se realizarán diversos ejemplos funcionales en cada caso.

Durante el proceso se introducirán conceptos sobre todas las herramientas de trabajo necesarias para la compilación y generación de las aplicaciones, gestores de dependencias, generadores de código y herramientas de edición recomendadas. Se proporcionaran una serie de recetas de instalación y configuración del entorno de trabajo y depuración, tanto en equipos OSX como Windows.

#### Descripción extendida (programa detallado): 

##### 1.A FMS v11~16

NOTA: Modulo no necesario en caso de disponer de FMSv17 ya que esta versión dispone del servicio REST necesario para conectar directamente con la parte servidor del punto 1.B

* Creación servicios REST empleando FMS JDBC, SpringBoot (Java), NodeJS (Javascript)
* Emulación de DATA API para compatibilidad futura con FMS v17 y posteriores
* Diseño para trabajo simultáneo con varios sistemas de bases de datos (caso FMS + MariaDB/MySQL)
* Documentación APIs REST automatizada (Swagger)

##### 1.B Aplicación Servidor

* Instalación y descripción del kit básico de desarrollo (IDEs, gestión de dependencia y frameworks)
* Uso de los servicios REST de FMS16 o Data API FMS17 (directamente)
* Seguridad (local o externa), implementación de Cross Origin (CORS)
* Instalación como servicio, monitorización y depuración
* Conexión a otros servicios no FMS (FileSystem, PDF, mensajería, server push, websockets...)
* Opciones profesionales y open source de desarrollo y generación automatizada (Cuba, Vaadin, JHipster)
* Estrategias de escalabilidad y seguridad.

##### 2.A Creación aplicación cliente

* Revisión y análisis de las distintas opciones incluyendo profesionales o gratuitas.
* Creación de interfaces de cliente mediante frameworks (Angular, React, Vue). Opciones y empleo de Componentes UI (Materials, PrimeNG). Empleo de librerías de estilo (Bootstrap)
* Estrategias para apps multi-dispositivo

##### 2.B Distribución

* Introducción a las tecnologías de compilación en formatos nativos (Cordova)
* Introducción a las plataformas de despliegue y distribución (Ionic y otras)
* Generación de aplicaciones nativas (iOS+Android) con Ionic.
* Test dinámico en dispositivos móviles (Ionic Developer)


![](https://fmcatalonia.files.wordpress.com/2018/06/wshop-fcat-stack.png?w=480)


### Creditos

Workshop oprganizado por FileMaker Catalonia, FMcat ().

Dirigido por Joan Subirós jsubiros@fmsuit.com (FMsuit https://www.fmsuit.com)