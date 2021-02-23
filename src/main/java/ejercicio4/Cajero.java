package ejercicio4;

public class Cajero {
    private BDUtil dbUtil = new BDUtil();
    private ClientDB clientDB = new ClientDB();
    private String msg = "";
    private int saldo;

    public Cajero(int saldo) {
        this.saldo = saldo;
    }

    //Paso 1
    public Cajero(ClientDB clientDB, BDUtil dbUtil, int saldo) {
        this.clientDB = clientDB;
        this.dbUtil = dbUtil;
        this.saldo = saldo;
    }

    public String getCash(int ci, int amount) {

        if (clientDB.isConnectionSuccessfully("mysql")) {
            if (amount > 0 && amount <= this.saldo) {
                int newSaldo = this.saldo - amount;
                boolean isUpdated = dbUtil.updateSaldo(ci, newSaldo);
                msg = isUpdated ? "Usted esta sacando la cantidad de " + amount + " y tiene en saldo " + newSaldo : "Actualizacion Incorrecta, Intente Nuevamente";
            } else if (amount <= 0) {
                msg = "Amount No Valido";
            } else {
                msg = "Usted no tiene suficiente saldo";
            }
        } else {
            msg = "Conexion a BD no fue satisfactoria";
        }
        return msg;
    }
}
