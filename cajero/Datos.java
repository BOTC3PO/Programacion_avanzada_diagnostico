package cajero;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Datos {

	@SuppressWarnings("unused")
	private Cliente variable;
	Hora hora = new Hora();
//simulacion de base de datos
//tendria que ser una linked list
	private short pins[] = { 0000, 5056, 8947, 9654 };
	private String nombres[] = { "Julian", "Pedro", "Carlos", "Peter" };
	private String apellidos[] = { "Peralta", "Villa", "Xi", "Parker" };
	private String[] cuentas = { "158654", "597456", "98452", "95585" };
	private Double saldos[] = { 95000.0, 500.0, 6000.0, 600000.0 };
	// time = time stamp https://www.unixtimestamp.com/
	private String datos[][] = {
			{ "158654", "time", "1", "600", "45888", "2022" + " 12 " + hora.getmesname(6) + " 00:56:45" },
			{ "158654", "time", "1", "600", "45888", "2022" + " 15 " + hora.getmesname(8) + " 13:00:15" },
			{ "158654", "time", "1", "600", "45888", "2022" + " 24 " + hora.getmesname(3) + " 22:02:22" },
			{ "158654", "time", "1", "600", "45888", "2022" + " 12 " + hora.getmesname(4) + " 01:40:27" },
			{ "158654", "time", "1", "600", "45888", "2022" + " 12 " + hora.getmesname(10) + " 20:59:37" },
			{ "597456", "time", "1", "600", "45888", "2022" + " 05 " + hora.getmesname(11) + " 13:16:24" },
			{ "597456", "time", "1", "600", "45888", "2022" + " 23 " + hora.getmesname(0) + " 04:56:48" },
			{ "597456", "time", "1", "600", "45888", "2022" + " 21 " + hora.getmesname(11) + " 00:03:28" },
			{ "597456", "time", "1", "600", "45888", "2022" + " 18 " + hora.getmesname(10) + " 01:10:32" },
			{ "597456", "time", "1", "600", "45888", "2022" + " 19 " + hora.getmesname(7) + " 04:12:28" },
			{ "98452", "time", "1", "600", "45888", "2022" + " 25 " + hora.getmesname(2) + " 23:00:25" },
			{ "98452", "time", "1", "600", "45888", "2022" + " 07 " + hora.getmesname(3) + " 03:06:50" },
			{ "98452", "time", "1", "600", "45888", "2022" + " 10 " + hora.getmesname(9) + " 17:56:23" },
			{ "98452", "time", "1", "600", "45888", "2022" + " 13 " + hora.getmesname(11) + " 03:42:23" },
			{ "98452", "time", "1", "600", "45888", "2022" + " 18 " + hora.getmesname(1) + " 17:42:21" },
			{ "95585", "time", "1", "600", "45888", "2022" + " 29 " + hora.getmesname(4) + " 15:02:32" },
			{ "95585", "time", "1", "600", "45888", "2022" + " 30 " + hora.getmesname(3) + " 01:32:43" },
			{ "95585", "time", "1", "600", "45888", "2022" + " 14 " + hora.getmesname(8) + " 10:32:12" },
			{ "95585", "time", "1", "600", "45888", "2022" + " 19 " + hora.getmesname(6) + " 13:34:23" },
			{ "95585", "time", "1", "600", "45888", "2022" + " 20 " + hora.getmesname(1) + " 09:23:43" }, };
	private LinkedList<Movimientos> u_movimientos = new LinkedList<>();

	/* dato */
	@SuppressWarnings("unused")
	private boolean validador;

	public Datos(Cliente variable, boolean validador) {
		this.variable = variable;
		this.validador = validador;
	}

	public Cliente getVariable(Cliente variable/* ,int dar */) {
		/*
		 * variable.setPin(pins[dar]); variable.setNombre(nombres[dar]);
		 * variable.setApellido(apellidos[dar]); variable.setCuenta(cuentas[dar]);
		 * variable.setSaldo(saldos[dar]);
		 */
		return variable;
	}

	public short pin(int dar) {
		return pins[dar];
	}

	public void cambiarpin(short nuevo, int dar) {
		pins[dar] = nuevo;
	}

	public String nombre(int dar) {
		return nombres[dar];
	}

	public String apellido(int dar) {
		return apellidos[dar];
	}

	public String cuenta(int dar) {
		return cuentas[dar];
	}

	public Double getSaldos(int dar) {
		return saldos[dar];
	}

	public void setSaldos(Double saldo, int dar) {
		saldos[dar] = saldo;
	}

	public void setVariable(Cliente variable, int dar) {
		saldos[dar] = variable.getSaldo();
		this.variable = variable;
	}

	public boolean validar(String valor) {
		boolean dat = Arrays.asList(cuentas).contains(valor);
		return dat;
	}

	public int id(String valor) {
		int dar = 0;
		for (int i = 0; i < cuentas.length; i++) {
			if (cuentas[i].equals(valor)) {
				dar = i;
			}
		}
		return dar;
	}

	public LinkedList<Movimientos> ordenador() {

		return u_movimientos;
	}

	public LinkedList<Movimientos> account_mov(LinkedList<Movimientos> var, int OP) {
		LinkedList<Movimientos> var2 = new LinkedList<>();
		System.err.println(var.size());
		for (int i = 0; i < var.size(); i++) {
			if ((String.valueOf(OP)).equals((var.get(OP).getCuenta()))) {
				var2.add(var.get(i));
			}
		}
		System.err.println(var.get(0).getHora());
		return var2;
	}

	public LinkedList<Movimientos> generar() {
		for (int i = 0; i < datos.length; i++) {
			u_movimientos.addLast(mov(i));
		}
		return u_movimientos;
//	Movimientos movimientos = new Movimientos(cuenta,numero_movimiento,tipo,cantidad,saldo,Hora);

//	u_movimientos.add(0,);

	}

	public Movimientos mov(int z) {
		Movimientos m = new Movimientos(null, null, null, null, null, null);
		m.setCuenta(datos[z][0]);
		m.setNumero_movimiento(datos[z][1]);
		m.setTipo(datos[z][2]);
		m.setCantidad(datos[z][3]);
		m.setSaldo(datos[z][4]);
		m.setHora(datos[z][5]);
		// System.err.println(datos[i][0]);
		return m;
	}

}
