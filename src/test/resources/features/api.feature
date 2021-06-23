#language:es
Característica: Iniciar sesion o crear
 Antecedentes:
 Dado el servicio rest


  @APIS
  Esquema del escenario: Iniciar sesion
    Cuando se realiza una peticion GET <id>
    Entonces Se obtine resultado <status> <id>
  Ejemplos:
    |id|status|
    |15|200   |

  @APISLIST
  Esquema del escenario: Consultar usuarios
    Cuando consulto los usuarios <id>
    Entonces Se valida resultado de usuarios status <status> nombre <nombre>
    Ejemplos:
      |id|status|nombre       |
      |1 |200   |Romaguera-Crona|

  @APIPOST
  Esquema del escenario: Crear usuario
    Cuando creo el nuevo usuario con nombre <nombre> y apellido <apellido>
    Entonces Valido la creacion exitosa
    Ejemplos:
      |nombre         |apellido |
      |Esteban        |Tomassini|