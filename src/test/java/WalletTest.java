import org.example.Wallet;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalletTest {
    static Wallet wallet;

    @BeforeAll
    static void initClass(){
        wallet = new Wallet();
        wallet.setOwner("Rudi");
    }

    @BeforeEach
    void setUp(){
        System.out.println("BeforeEach dilakukan");
    }

    @AfterEach
    void after(){
        System.out.println("After Each dilakukan");
    }
    @AfterAll
    void afterAll(){
        System.out.println("After All dilakukan");
    }


    @Test
    void getNameTest(){
        Assertions.assertEquals("Rudi", wallet.getName());
    }

    @Test
    void depositTest(){
        wallet.deposit(20000);
        Assertions.assertEquals(20000, wallet.getCash());
    }

    @Test
    void withdrawTest(){
        wallet.withdraw(5000);
        Assertions.assertEquals(15000,wallet.getCash());
    }

    @Test
    void checkCardTest(){
        wallet.addCards("BRI", 1234);
        wallet.addCards("BNI", 1235);
        Assertions.assertTrue(wallet.checkCards("BRI", 1234));
    }

    @Test
    void removeCardTest(){
        wallet.removeCard("BRI", 1234);
        Assertions.assertFalse(wallet.checkCards("BRI", 1234));
    }
}
