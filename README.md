# ProyectoAndroidSuperpoderes

1) Para poder generar el Hash en tienpo de ejecución con los valores de timeStamp del momento de la petición.
Se necesitan los valores del timeStamp, el de la clave privada y la clave publica del api. Para ello, se
han almacenado los valores de ambas claves en el fichero local.properties, el cual forma aprte de gitIgnore, para
dar más seguridad y que nadie pueda hacer nada con las mías. Por tanto, para que funcione el proyecto, se tienen que
introducir en local.properties las claves como:
    * api.key.public="valor_de_la_clave_publica"
    * api.key.private="valor_de_la_clave_privada"

2) Como he comentado, el Hash MD5 se calcula en tiempo de ejecución. De media , 1 de cada 15 veces falla el cálculo. He puestro el tryCatch para que no se cierre la app,
pero en caso de que salte, no se cargan las series y peliculas. Se puede ir atrás desde el botón de atrás de la topbar o desde el boton home de la bottomBar. Si me da tiempo areglo el bug.

3) La ventana detalle está dividida en dos cuadrantes:
   * Cuadrante Superior:tarjeta con imagen, nombre de personaje y descripcion( scrollable). 
   * Cuadrante Inferior: TabRow con dos pestanas, una muestra los comics en los que aparece el personaje y la otra, las series.
     * Como componente no visto en clase he optado por TabRow porque como se tenía que mostrar información de dos endpoints, me apetecía
     hacerlo de esta forma ya que no la había usado.

4) Cuando un heroe pasa a ser favorito, se actualiza el vlaor del listado que incluye a todos los personajes, pasando su estaso a favorito.

#####     El valor del favorito no influye para la lista de heroes, por lo que toca **depurar para poder ver el cambio.** 


5) 
