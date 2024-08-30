# Descripción de la prueba

Automatizar las pruebas de la siguiente aplicación web:
[https://demos.devexpress.com/rwa/dxhotels/](https://demos.devexpress.com/rwa/dxhotels/)  

Condiciones: Usar SerenityBDD para llevar a cabo las pruebas automatizadas de esta
aplicación.

Escenarios:  
A. Login exitoso y login fallido  

B. Reservación de un hotel:
 - Fecha de check-in: 2 días a partir de la fecha actual.
 - Fecha de check-out: 7 días a partir de la fecha actual.
 - Número de habitaciones: 2.
 - Número de adultos: 3.
 - Número de niños: 2.
 - Rango de precio: superior a $200 USD.
 - Número de estrellas: 3 o más.
 - Aplicar los filtros seleccionados.
 - Seleccionar el hotel más económico que cumpla con los filtros establecidos.
 - Validar mensaje de reservación exitosa.

Los escenarios de inicio de sesión exitosos no fueron probados, por lo que la página no cumple correctamente con el atributo no funcional de 'Testabilidad'. Dado que contiene un captcha, se recomendaría en un escenario real abordarlo de una de las siguientes formas:
- Pedir al cliente desactivar este captcha para el ambiente de QA, en caso de contar con uno.
- Pedir al cliente una URL prelogueada para las pruebas posteriores al inicio de sesión.
- En caso de que las opciones anteriores no estén disponibles, se podría intentar solucionar el captcha con un proveedor de este servicio, como 2Captcha o Anti-captcha.
- Usar una librería de Java para descifrar el captcha, como JCaptcha.

Adicionalmente al realizar un logueo correcto manual, la pagina no informa de dicho logueo exitoso, lo cual estaria restando "Usabilidad" a la pagina.

## Escenarios probados

Escenario 1: Intento de inicio de sesión con una contraseña vacía. Se verifica que se le indique al usuario con un recuadro rojo que el dato falta
```gherkin
Scenario Outline: Attempt to login with an empty password field
    Given the user is on the login page
    When the user attempts to log in with an empty password and a valid "<email>"
    And the user press the button summit
    Then the user should see a password field with red border
    Examples:
      | email             |
      | sebas44@gmail.com |
```
Escenario 2: Intento de inicio de sesión con un email vacío. Se verifica que se le indique al usuario con un recuadro rojo que el dato falta
```gherkin
 Scenario Outline: Attempt to login with an empty email field
    Given the user is on the login page
    When the user attempts to log in with an empty email and a valid "<password>"
    And the user press the button summit
    Then the user should see an email field with red border
    Examples:
      | password |
      | abc123   |
```
Escenario 3: Intento de inicio de sesión con un email y contraseña correctos, pero un captcha vacío. Se verifica que se deniegue el inicio de sesión y se le indique al usuario que el captcha es incorrecto
```gherkin
Scenario Outline: Attempt to login with an email and password but captcha empty
    Given the user is on the login page
    When the user attempts to log in with an valid email "<email>" and password "<password>"
    And the user press the button summit
    Then the user should see an error message captcha
    Examples:
      | email             | password |
      | sebas44@gmail.com | abc123   |
```
Escenario 4: Intento de inicio de sesión con un email y contraseña correctos, pero un captcha erróneo. Se verifica que se deniegue el inicio de sesión y se le indique al usuario que el captcha es incorrecto
```gherkin
Scenario Outline: Attempt to login with an email and password but captcha with wrong code
    Given the user is on the login page
    When the user attempts to log in with an valid email "<email>" and password "<password>"
    And the user enters a wrong "<captcha>"
    And the user press the button summit
    Then the user should see an error message captcha
    Examples:
      | email             | password | captcha |
      | sebas44@gmail.com | abc123   | abcdf   |
```
Escenario 5: Se hace una reservación y se verifican el uso de filtros, los parámetros de búsqueda y la confirmación del mensaje exitoso
```gherkin
Feature: Hotel reservation

  Scenario Outline: Successful hotel reservation with specific filters
    Given the user is on the hotel booking page
    When the user selects "Las Vegas, USA" on location field
    And the user selects the check-in date <checkInDate> days from today
    And the user selects the check-out date <checkOutDate> days from today
    And the user selects "<totalRooms>" rooms
    And the user selects "<totalAdults>" adults
    And the user selects "<totalChildren>" children
    And the user press the button search
    And the user selects a price range above "<priceRange>" USD
    And the user selects 3 stars rating or more
    And the user applies the selected filters
    And the user selects the cheapest hotel that meets the filters
    Then the user should see the message "Your Reservation Summary"

    Examples:
      | checkInDate | checkOutDate | totalRooms | totalAdults | totalChildren | priceRange |
      | 2           | 7            | 2          | 3           | 2             | 200        |
```
