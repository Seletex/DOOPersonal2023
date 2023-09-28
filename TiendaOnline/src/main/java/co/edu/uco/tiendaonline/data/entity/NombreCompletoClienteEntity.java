package co.edu.uco.tiendaonline.data.entity;

public final class NombreCompletoClienteEntity {
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	
	
	

	private NombreCompletoClienteEntity(final String primerNombre,final String segundoNombre,final String primerApellido,
			final String segundoApellido) {
	setPrimerNombre(primerNombre);
	setSegundoNombre(segundoNombre);
	setPrimerApellido(primerApellido);
	setSegundoApellido(segundoApellido);
	}
	
	public static final NombreCompletoClienteEntity crear(final String primerNombre,final String segundoNombre,final String primerApellido,
			final String segundoApellido) {
		return new NombreCompletoClienteEntity(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	private final void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	private final void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	private final void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	private final void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}




}