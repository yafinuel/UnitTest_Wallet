import org.example.Kalkulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KalkulatorTest {

    @Test
    public void testPenjumlahan()
    {
        Kalkulator calc = new Kalkulator();
        calc.setNumber1(1);
        calc.setNumber2(1);
        Assertions.assertEquals(2,calc.penjumlahan());
    }
}
