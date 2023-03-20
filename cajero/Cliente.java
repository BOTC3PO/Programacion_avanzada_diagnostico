package cajero;

public class Cliente extends Persona {
	private String cuenta;
	private Double saldo;

	public Cliente(short pin, String nombre, String apellido, String cuenta, Double saldo) {
		super(pin, nombre, apellido);
		this.cuenta = cuenta;
		this.saldo = saldo;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	

	@Override
	public String toString() {
		return "Cliente [cuenta=" + cuenta + ", saldo=" + saldo + "]";
	}

	public String retirardinero(int monto, cajero cajero) {
		if (this.getSaldo() >= monto) {
			if (cajero.getSaldo() >= monto) {
				this.setSaldo(this.getSaldo() - monto);
				cajero.setSaldo(cajero.getSaldo() - monto);
				return "se retiro " + monto + " de la cuenta " + this.getCuenta() + " y el saldo restante es "
						+ this.getSaldo();
			} else {
				return "el cajero no tiene suficiente dinero ";
			}
		} else {
			return "no hay suficiente dinero en la cuenta";
		}
	}
}
