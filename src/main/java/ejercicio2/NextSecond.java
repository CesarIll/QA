package ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NextSecond {

    public String newDate(int dia, String mes, int anio, int hora, int minuto, int segundo){
        String siguienteSegundo;
        List<String> meses = new LinkedList<>();
        meses.add("Enero"); meses.add("Febrero"); meses.add("Marzo"); meses.add("Abril"); meses.add("Mayo"); meses.add("Junio"); meses.add("Julio"); meses.add("Agosto"); meses.add("Septiembre"); meses.add("Octubre"); meses.add("Noviembre"); meses.add("Diciembre");
        if (dia < 1 || dia > 31) {
            siguienteSegundo = "Invalid Day : " + dia;
        } else if (mes.equals("Febrero") && (dia == 30 || dia == 31)) {
            siguienteSegundo = "Invalid Day : " + dia;
        } else if (mes.equals("Febrero") && dia == 29 && anio % 4 != 0 && anio % 100 == 0) {
            siguienteSegundo = "Invalid Day : " + dia;
        } else if (dia == 31 && (mes.equals("Abril") || mes.equals("Junio") || mes.equals("Septiembre") || mes.equals("Noviembre"))) {
            siguienteSegundo = "Invalid day: " + dia;
        } else if (!meses.contains(mes)) {
            siguienteSegundo = "Invalid Month : " + mes;
        } else if (anio < 0) {
            siguienteSegundo = "Invalid Year : " + anio;
        } else if (hora < 0 || hora > 23) {
            siguienteSegundo = "Invalid Hour : " + hora;
        } else if (minuto < 0 || minuto > 59) {
            siguienteSegundo = "Invalid Minute : " + minuto;
        } else if (segundo < 0 || segundo > 59) {
            siguienteSegundo = "Invalid Second : " + segundo;
        } else if (segundo != 59) {
            int temp = segundo + 1;
            siguienteSegundo = dia + " " + mes + " " + anio + " " + hora + ":" + minuto + ":" + temp;
        } else if (minuto != 59) {
            int temp = minuto + 1;
            siguienteSegundo = dia + " " + mes + " " + anio + " " + hora + ":" + temp + ":0";
        } else if (hora != 23) {
            int temp = hora + 1;
            siguienteSegundo = dia + " " + mes + " " + anio + " " + temp + ":0:0";
        } else if (dia < 28) {
            int temp = dia + 1;
            siguienteSegundo = temp + " " + mes + " " + anio + " 0:0:0";
        } else if (dia == 28 && mes.equals("Febrero")) {
            if (anio % 4 != 0) {
                siguienteSegundo = "1 Marzo " + anio + " 0:0:0";
            } else {
                siguienteSegundo = "29 Febrero " + anio + " 0:0:0";
            }
        } else if (dia == 28) {
            int temp = dia + 1;
            siguienteSegundo = temp + " " + mes + " " + anio + " 0:0:0";
        } else if (dia == 29 && mes.equals("Febrero")) {
            siguienteSegundo = "1 Marzo " + anio + " 0:0:0";
        } else if (dia == 29) {
            int temp = dia + 1;
            siguienteSegundo = temp + " " + mes + " " + anio + " 0:0:0";
        } else if (dia == 30 && (mes.equals("Abril") || mes.equals("Junio") || mes.equals("Septiembre") || mes.equals("Noviembre"))) {
            int temp = 0;
            for (int i = 0; i < meses.size(); i++) {
                if (meses.get(i).equals(mes)) {
                    temp = i + 1;
                }
            }
            siguienteSegundo = "1 " + meses.get(temp) + " " + anio + " 0:0:0";
        } else if (dia == 30) {
            int temp = dia + 1;
            siguienteSegundo = temp + " " + mes + " " + anio + " 0:0:0";
        } else if (dia == 31 && !mes.equals("Diciembre")) {
            int temp = 0;
            for (int i = 0; i < meses.size(); i++) {
                if (meses.get(i).equals(mes)) {
                    temp = i + 1;
                }
            }
            siguienteSegundo = "1 " + meses.get(temp) + " " + anio + " 0:0:0";
        } else {
            int temp = anio + 1;
            siguienteSegundo = "1 Enero " + temp + " 0:0:0";
        }
        return siguienteSegundo;
    }
}
