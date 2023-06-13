# ProyectoAndroidSuperpoderes

1) Para poder generar el Hash en tienpo de ejecución con los valores de timeStamp del momento de la petición.
Se necesitan los valores del timeStamp, el de la clave privada y la clave publica del api. Para ello, se
han almacenado los valores de ambas claves en el fichero local.properties, el cual forma aprte de gitIgnore, para
dar más seguridad y que nadie pueda hacer nada con las mías. Por tanto, para que funcione el proyecto, se tienen que
introducir en local.properties las claves como:
    * api.key.public="valor_de_la_clave_publica"
    * api.key.private="valor_de_la_clave_privada"