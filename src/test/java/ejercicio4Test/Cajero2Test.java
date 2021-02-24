package ejercicio4Test;

import ejercicio4.BDUtil;
import ejercicio4.Cajero2;
import ejercicio4.ClientDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Parameterized.class)
@PrepareForTest({BDUtil.class, ClientDB.class})
public class Cajero2Test {

    @Parameterized.Parameter(0)
    public int ci;
    @Parameterized.Parameter(1)
    public int monto;
    @Parameterized.Parameter(2)
    public int saldo;
    @Parameterized.Parameter(3)
    public boolean expectedConnectionMock;
    @Parameterized.Parameter(4)
    public boolean expectedUpdateMock;
    @Parameterized.Parameter(5)
    public String expectedResult;

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

    @Test
    public void verify_calculate_amount(){
        PowerMockito.mockStatic(BDUtil.class);
        PowerMockito.mockStatic(ClientDB.class);
        Mockito.when(ClientDB.isConnectionSuccessfullyStatic("mysql")).thenReturn(this.expectedConnectionMock);
        Mockito.when(BDUtil.updateSaldoStatic(this.ci, this.saldo - this.monto)).thenReturn(this.expectedUpdateMock);

        Cajero2 cajero = new Cajero2(saldo);
        String actualResult = cajero.getCash(this.ci, this.monto);
        Assert.assertEquals("ERROR! ", this.expectedResult, actualResult);
    }

}

