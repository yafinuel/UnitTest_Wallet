import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WalletTest {
    @Test
    public void testSetOwner(){
        Wallet wallet = new Wallet();
        wallet.setOwner("Rudi");
        Assertions.assertEquals("Rudi", wallet.getName());
    }

    @Test
    public void testDeposit(){
        Wallet wallet = new Wallet();
        wallet.deposit(20000);
        Assertions.assertEquals(20000, wallet.getCash());
        wallet.deposit(-10000);
        Assertions.assertEquals(20000, wallet.getCash());
    }

    @Test
    public void testWihdraw(){
        Wallet wallet = new Wallet();
        wallet.deposit(20000);
        wallet.withdraw(10000);
        Assertions.assertEquals(10000, wallet.getCash());
        wallet.withdraw(50000);
        Assertions.assertEquals(10000, wallet.getCash());
    }

    @Test
    public void testAddCards(){
        Wallet wallet = new Wallet();
        wallet.addCards("BRI", 123);
        wallet.addCards("BRI", 124);
        List<List<Object>> expected = List.of(
                List.of("BRI", 123),
                List.of("BRI", 124)
        );
        Assertions.assertEquals(expected, wallet.getCards());
    }

    @Test
    public void testRemoveCards(){
        Wallet wallet = new Wallet();
        wallet.addCards("BRI", 123);
        wallet.addCards("BRI", 124);
        wallet.removeCard("BRI", 124);
        List<List<Object>> expected = List.of(
                List.of("BRI", 123)
        );
        Assertions.assertEquals(expected, wallet.getCards());
    }
}
