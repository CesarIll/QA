package ejercicio4Test;

import ejercicio4.BDUtil;
import ejercicio4.Cajero;
import ejercicio4.ClientDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CajeroTest {

    private int ci;
    private int monto;
    private int saldo;
    private boolean expectedConnectionMock;
    private boolean expectedUpdateMock;
    private String expectedResult;

    public CajeroTest(int ci, int monto, int saldo, boolean expectedConnectionMock, boolean expectedUpdateMock, String expectedResult){
        this.ci = ci;
        this.monto = monto;
        this.saldo = saldo;
        this.expectedConnectionMock = expectedConnectionMock;
        this.expectedUpdateMock = expectedUpdateMock;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();

        objects.add(new Object[]{122342, 1, 2000, true, false, "Actualizacion Incorrecta, Intente Nuevamente"});
        objects.add(new Object[]{122342, 1000, 2000, false, false, "Conexion a BD no fue satisfactoria"});

        objects.add(new Object[]{122342, 0, 2000, true, false, "Amount No Valido"});
        objects.add(new Object[]{122342, 1, 2000, true, true, "Usted esta sacando la cantidad de 1 y tiene en saldo 1999"});
        objects.add(new Object[]{122342, 2, 2000, true, true, "Usted esta sacando la cantidad de 2 y tiene en saldo 1998"});
        objects.add(new Object[]{122342, 999, 2000, true, true, "Usted esta sacando la cantidad de 999 y tiene en saldo 1001"});
        objects.add(new Object[]{122342, 1000, 2000, true, true, "Usted esta sacando la cantidad de 1000 y tiene en saldo 1000"});
        objects.add(new Object[]{122342, 1001, 2000, true, true, "Usted esta sacando la cantidad de 1001 y tiene en saldo 999"});
        objects.add(new Object[]{122342, 1999, 2000, true, true, "Usted esta sacando la cantidad de 1999 y tiene en saldo 1"});
        objects.add(new Object[]{122342, 2000, 2000, true, true, "Usted esta sacando la cantidad de 2000 y tiene en saldo 0"});
        objects.add(new Object[]{122342, 2001, 2000, true, false, "Usted no tiene suficiente saldo"});

        return objects;
    }

    //Paso 2
    ClientDB clientDBMock = Mockito.mock(ClientDB.class);
    BDUtil bdUtilMock = Mockito.mock(BDUtil.class);

    @Test
    public void verify_calculate_amount(){
        // Paso 3
        Mockito.when(clientDBMock.isConnectionSuccessfully("mysql")).thenReturn(this.expectedConnectionMock);
        Mockito.when(bdUtilMock.updateSaldo(this.ci, this.saldo - this.monto)).thenReturn(this.expectedUpdateMock);

        // Paso 4
        Cajero cajero = new Cajero(clientDBMock, bdUtilMock, saldo);
        String actualResult = cajero.getCash(this.ci, this.monto);
        Assert.assertEquals("ERROR! ", this.expectedResult, actualResult);
    }

}
