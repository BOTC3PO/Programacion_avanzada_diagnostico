package cajero;

public class Movimientos {

	private String cuenta;
	private String numero_movimiento;
	private String tipo;
	private String cantidad;
	private String saldo;
	private String Hora;
	
	public Movimientos(String cuenta, String numero_movimiento, String tipo, String cantidad, String saldo,
			String hora) {
		super();
		this.cuenta = cuenta;
		this.numero_movimiento = numero_movimiento;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.saldo = saldo;
		Hora = hora;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getNumero_movimiento() {
		return numero_movimiento;
	}
	public void setNumero_movimiento(String numero_movimiento) {
		this.numero_movimiento = numero_movimiento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
		Hora = hora;
	}
	
	
}
