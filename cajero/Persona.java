package cajero;

public abstract class Persona {
	
	private short Pin;
	private String nombre,apellido;

	public Persona(short pin, String nombre, String apellido) {
		super();
		Pin = pin;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public short getPin() {
		return Pin;
	}

	public void setPin(short pin) {
		Pin = pin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
