<p align = "center"> <img src = "https://res.cloudinary.com/djarwlymo/image/upload/v1683243482/images/mailservice_teru7a.png" /> </p>
<h1>Implementación de un servicio de mensajería utilizando la API de JavaMail</h1>

<p>Este proyecto consiste en una implementación de un servicio de mensajería para envío de correos electrónicos utilizando la API de JavaMail y el framework Spring Boot. El servicio permite enviar correos electrónicos simples o con archivos adjuntos, configurando los parámetros necesarios para el servidor SMTP del remitente y los datos de autenticación, entre otros.

La implementación se basa en un controlador REST que recibe la información del correo electrónico y del archivo adjunto en formato multipart/form-data y delega en un servicio la tarea de enviar el correo utilizando la API de JavaMail. Además, se incluye un ejemplo de configuración para la utilización del servicio con Gmail.

Este proyecto puede ser utilizado como base para la implementación de servicios de mensajería en aplicaciones Java y Spring Boot que requieran el envío de correos electrónicos.</p>
<h2>Conceptos básicos de SMTP para el envío de correo electrónico:</h2>

- SMTP significa Protocolo Simple de Transferencia de Correo.
- Se utiliza para enviar un mensaje de correo electrónico de un servidor de correo a otro.
- Cuando envías un mensaje de correo electrónico, el mensaje se envía desde el software cliente de correo en tu computadora a tu servidor de correo utilizando SMTP.
- Tu servidor de correo luego utiliza SMTP para enviar el correo al servidor de correo del destinatario.
- El cliente de correo del destinatario utiliza POP o IMAP para recuperar el correo electrónico de su servidor de correo.
<br />
<h2>Funcionalidades:</h2>

- Envío de correos electrónicos con un cuerpo de texto plano o con HTML.
- Adjuntar archivos a los correos electrónicos.
<br />
<h2>Tecnologías:</h2>

- Frameworks: Spring Boot 2.7.11
- Api de JavaMail
- Manejo de dependencias: Maven
<br />
<h2>Cómo ejecutarlo:</h2>

Requerimientos: Primero necesitarás instalar lo siguiente:

- JDK 11+
- MySQL workbench

<p>Además, debes configurar las siguientes variables de entorno en tu sistema o en el archivo <code>application.yml</code>:</p>

- <code>EMAIL_USERNAME</code>: nombre de usuario de la cuenta de correo electrónico que se usará para enviar los correos electrónicos.
- <code>EMAIL_PASSWORD</code>: contraseña de la cuenta de correo electrónico mencionada anteriormente.
- <code>EMAIL_HOST</code>: dirección del servidor de correo saliente (SMTP) que se utilizará para enviar los correos electrónicos. Por ejemplo, si usas Gmail, el valor para esta variable debería ser: <code>smtp.gmail.com</code>.

Una vez cumplidos estos pasos, puedes clonar el proyecto y ejecutarlo en tu IDE preferido.
