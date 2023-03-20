package main;

import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import cajero.Cliente;
import cajero.Datos;
import cajero.Empleado;
import cajero.Hora;
import cajero.Movimientos;
import cajero.cajero;

/*
 * los numeros de cuenta empiezan en 10000
 * */

public class Main {

	/*variables*/
	/*notas
	 *solo se puede usar el cajero por 1 persona
	 *el cajero acepta monedas (min $0.01)
	 *  */
	private static Empleado empleado = new Empleado((short) 6777, "Alejandro", "Mendez", 35);
	private static Cliente activo = new Cliente((short) 0, null, null, null, null);
	private static Datos datos = new Datos(activo, false);
	private static cajero cajero = new cajero(6000.0);
	private static int OP;
	static Calendar c = Calendar.getInstance();
	static Hora hora = new Hora();
	private static LinkedList<Movimientos> u_movimientos=new LinkedList<>();
	private static LinkedList<Movimientos> active_user=new LinkedList<>();
	//c.getTime();
	public static void main(String[] args) {
		//System.err.println(c.getTimeInMillis());
		
		Datos datos2 = new Datos(null, false);
		u_movimientos=datos2.generar();
		
		//System.err.println(u_movimientos.get(1).getHora());
		//System.err.println("Hora "+hora.obtenerhora() +" \nDia "+ c.get(Calendar.DATE) + " \nMes " + hora.getmesac()  + " \nAño "+ c.get(Calendar.YEAR));
		
		System.err.println(u_movimientos.get(0).getHora());
		
		pantalla_inicio();
		
		/*
		 * cajero cajero = new cajero(5000); JOptionPane.showMessageDialog(null,
		 * activo.retirardinero(5000, cajero)); JOptionPane.showMessageDialog(null,
		 * activo.retirardinero(5000, cajero)); JOptionPane.showMessageDialog(null,
		 * cajero.getSaldo());
		 */
	}

	
	
	public static void pantalla_inicio() {
		boolean validar;
		boolean empleado_b = false;
		do {
			String valor = JOptionPane.showInputDialog("ingrese el numero de cuenta");
			validar = datos.validar(valor);
			if (!validar) {
				if (valor.equals(String.valueOf(empleado.getNumero_empleado()))) {
					empleado_b = true;
					System.err.println(empleado_b);
				}
				;
			}else {
			OP=datos.id(valor);
			}

		} while (!validar && !empleado_b);

		if (validar) {
			menu();
		}

		if (empleado_b) {
			empleado_m();
		}
	}
	
	
	
	public static void menu() {
		String menu_op[] = { "retirar dinero","cambiar Pin","ver ultimos movimientos","salir" };
		active_user=datos.account_mov(u_movimientos, OP);
		System.err.println(active_user.get(0).getHora());
		int max = menu_op.length - 1;
		System.out.println(max);
		int eleccion;
		activo.setPin(datos.pin(OP));
		boolean key =true;
		do {
			if (!key) {
				JOptionPane.showMessageDialog(null, "clave erronea");
			}else {
				key=false;
			}
		key = activo.getPin()==(Integer.parseInt(JOptionPane.showInputDialog("ingrese el pin")));
		/*nota agregar salida del bucle*/
		} while (!key);
		  activo.setNombre(datos.nombre(OP));
		  activo.setApellido(datos.apellido(OP));
		  activo.setCuenta(datos.cuenta(OP));
		  activo.setSaldo(datos.getSaldos(OP));
		do {
			eleccion = JOptionPane.showOptionDialog(null, "Seleccione una opci�n", "cajero", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, menu_op, 0);
			System.out.println(eleccion);
			
			
			//retirar
		if (eleccion==0) {
			boolean validar_retiro=false;
			do {
			double retiro=Double.parseDouble(JOptionPane.showInputDialog("ingrese la cantidad a retirar"));
			if (retiro>=0) {
				if (cajero.getSaldo()>=retiro) {
				cajero.setSaldo(cajero.getSaldo()-retiro);
				activo.setSaldo(activo.getSaldo()-retiro);
				
				 }else {
					 JOptionPane.showMessageDialog(null,"no hay suficiente dinero en el cajero");
				 }
				validar_retiro=true;
			 }else {
				 JOptionPane.showMessageDialog(null, "el valor tiene que ser mayor a 0");
			 }
			} while (!validar_retiro);
			 
			 JOptionPane.showMessageDialog(null,"saldo restante $"+ activo.getSaldo());
		}	
		
		
		//cambiar pin
		if (eleccion==1) {
		
		short pin_u=(short)	Integer.parseInt(JOptionPane.showInputDialog("ingrese el pin actual"));
		if (pin_u==datos.pin(OP)) {
			 pin_u=(short)	Integer.parseInt(JOptionPane.showInputDialog("ingrese el pin nuevo"));
			 
		}
			
		}
		
		
		//ultimos movimientos
		if(eleccion==2) {
			
			
			
			
		}
		
		
		} while (eleccion != max);
		datos.setSaldos(activo.getSaldo(),OP);
		
		
		System.err.println();
		pantalla_inicio();
	}

	private static void empleado_m() {
		JOptionPane.showMessageDialog(null, "el cajero tiene $ " + cajero.getSaldo());
		int var;
		do {
			var = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantida a" + '\u00f1' + "adir"));
			if (var == 0) {
				JOptionPane.showMessageDialog(null, "no se puede ingresar $0");
			} else if (var < 0) {
				JOptionPane.showMessageDialog(null, "saliendo del sistema de carga del cajaro");

			}else {
				cajero.setSaldo(cajero.getSaldo()+var);
				JOptionPane.showMessageDialog(null, "el cajero tiene $ " + cajero.getSaldo());
				var=-1;
			}
		} while (var>=0);
		pantalla_inicio();
	}

}
