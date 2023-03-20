package cajero;

public class Empleado extends Persona{
    private int numero_empleado;

	public Empleado(short pin, String nombre, String apellido, int numero_empleado) {
		super(pin, nombre, apellido);
		this.numero_empleado = numero_empleado;
	}

	public int getNumero_empleado() {
		return numero_empleado;
	}

	public void setNumero_empleado(int numero_empleado) {
		this.numero_empleado = numero_empleado;
	}
	
	
	
}
