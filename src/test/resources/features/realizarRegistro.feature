#language: es

@RealizarRegistroEmpleados
  Característica: Realizar el flujo de registrar un empleado

    Antecedentes:
      Dado El usuario ingresa al modulo PIM
      |usuario|contrasena|
      |Admin  |admin123  |

    @CreacionExitosa
    Esquema del escenario: Registrar un empleado correctamente
      Cuando Se crea el empleado correctamente
        |primernombre  |segundonombre  |apellidos  |identificador  |nombreusuario  |contrasenausuario  |
        |<primernombre>|<segundonombre>|<apellidos>|<identificador>|<nombreusuario>|<contrasenausuario>|
      Entonces La informacion buscada del empleado es correcta
      Ejemplos:
          |primernombre|segundonombre|apellidos|identificador|nombreusuario|contrasenausuario|
      ##@externaldata@src/test/resources/DataDriven/autRetoDatos.xlsx@Datos
