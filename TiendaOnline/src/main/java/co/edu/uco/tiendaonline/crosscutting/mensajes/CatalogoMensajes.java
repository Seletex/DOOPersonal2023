package co.edu.uco.tiendaonline.crosscutting.mensajes;

import java.util.EnumMap;

import java.util.Map;

import co.edu.uco.tiendaonline.crosscutting.exception.concrete.CrossCuttingTiendaOnlineException;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CategoriaMensaje;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.CodigoMensaje;
import co.edu.uco.tiendaonline.crosscutting.mensajes.enumerator.TipoMensaje;

import co.edu.uco.tiendaonline.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {

	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new EnumMap<>(CodigoMensaje.class);

	static {
		cargarMensajes();
	}

	private CatalogoMensajes() {

	}

	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,
				"No se recibió el código del mensaje que se quería crear. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,
				"No existe un mensaje con el código indicado. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL,
				"No es posible obtener un mensaje con un código vacío o nulo. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL,
				"Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de validar si la conexión SQL estaba abierta. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000007, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible validar si una conexión está abierta cuando es nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000008, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible cerrar una conexión que ya fue cerrada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000009, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de cerrar una conexión SQL. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000010, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de cerrar la conexión. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible iniciar una transacción con una conexión que está nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000012, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible iniciar una transacción con una conexión cerrada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000013, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible iniciar una transacción que ya ha sido iniciada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000014, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de iniciar la transacción de una conexión SQL. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000015, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de iniciar la transacción de una conexión. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible confirmar una transacción con una conexión que está nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000017, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible confirmar una transacción con una conexión cerrada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000018, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible confirmar una transacción que no fue iniciada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000019, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de confirmar la transacción de una conexión SQL. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000020, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de confirmar la transacción de una conexión. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M000000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible cancelar una transacción con una conexión que está nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000022, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible cancelar una transacción con una conexión cerrada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000023, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible cancelar una transacción que no fue iniciada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000024, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de cancelar la transacción de una conexión SQL. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000025, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado cancelar de confirmar la transacción de una conexión. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"No es posible cerrar una conexión que está nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000027, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de obtener la conexión con SQL Server. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000028, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de obtener la conexión con SQL Server. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000029, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para PostgreSQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000030, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para MySQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000031, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos para Oracle no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000032, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"La Factorìa de datos deseada no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000033, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de obtener el DAO de ClienteSQLServerDAO debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de obtener el DAO de TipoIdentificacionSQLServerDAO debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000036, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de registrar la información del nuevo Tipo de Identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema de tipo SQLException en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000038, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de registrar la información del nuevo Tipo de Identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000039, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exception en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000040, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de actualizar la información del Tipo de Identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema de tipo SQLException en el método modificar la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000042, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de actualizar la información del Tipo de Identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000043, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exception en el método modificar la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000044, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar la información del Tipo de Identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000045, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema de tipo SQLException en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000046, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de eliminar la información del Tipo de Identificación"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000047, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exception en el método crear la clase TipoIdentificacion tratando llvar a cabo el registro del nuevo TipoIdentificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000048, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de consultar la información del Tipo de Identificación por identificador deseado..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000049, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema de tipo SQLException en el método consultar ById la clase TipoIdentificacion tratando de recuperar los datos del TipoIdentifiacin deseado. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000050, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de consultar la información del Tipo de Identificación"));

		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000051, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado de tipo Exception tratando de preparar la sentencia SQL de la consulta del tipo identificacion. Revise la traza cmpleta del problema para asi poder identificaciar que sucedio"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000052, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la consulta de los tipo de identificacion"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000054, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un prblema inesperado de tipo SQLException en el metodo preparar la sentencia de la clase TipoidentificacionSQLDAO tratando de colocar los parametros de la consulta SQL. Profavor revise la traza completa del problema presentado"
				));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000053, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un prblema de tipo SQLException en el metodo preparar la sentencia de la clase TipoidentificacionSQLDAO tratando de colocar los parametros de la consulta SQL. Profavor revise la traza completa del problema presentado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000057, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la consulta de los clientes"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000055, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un prblema de tipo SQLException en el metodo colocar parametros de la clase TipoidentificacionSQLDAO tratando de colocar los parametros de la consulta SQL. Profavor revise la traza completa del problema presentado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000056, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un prblema inesperado de tipo SQLException en el metodo colocar parametros de la clase TipoidentificacionSQLDAO tratando de colocar los parametros de la consulta SQL. Profavor revise la traza completa del problema presentado"));
	
	}

	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if (UtilObjeto.esNulo(codigo)) {

			throw CrossCuttingTiendaOnlineException.crear(obtenerContenidoMensaje(CodigoMensaje.M00000004),
					obtenerContenidoMensaje(CodigoMensaje.M00000003));
		}

		if (!MENSAJES.containsKey(codigo)) {
			throw CrossCuttingTiendaOnlineException.crear(obtenerContenidoMensaje(CodigoMensaje.M00000004),
					obtenerContenidoMensaje(CodigoMensaje.M00000002));
		}
		return MENSAJES.get(codigo);

	}

	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}

	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}

}
