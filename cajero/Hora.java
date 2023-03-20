package cajero;

import java.util.Calendar;

public class Hora {
	
private Calendar c = Calendar.getInstance();
private String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
	       "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};


public Calendar getC() {
	return c;
}

public void setC(Calendar c) {
	this.c = c;
}

public String[] getMes() {
	return mes;
}

public void setMes(String[] mes) {
	this.mes = mes;
}

public String getmesname(int numero) {
	return mes[numero];
}

public String getmesac() {
	return mes[c.get(Calendar.MONTH)];
}

public String obtenerhora() {
	String formathora =String.valueOf(c.get(Calendar.HOUR_OF_DAY))+":"+String.valueOf(c.get(Calendar.MINUTE))+":"+String.valueOf(c.get(Calendar.SECOND));
	return formathora;
}

}
