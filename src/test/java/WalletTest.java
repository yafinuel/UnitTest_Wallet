import org.example.Owner;
import org.example.Wallet;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalletTest {
    static Wallet wallet;

    @BeforeAll
    static void initClass(){
        System.out.println("Before all dilakukan");
    }

    @BeforeEach
    void setUp(){
        wallet = new Wallet();
        Owner owner = new Owner(1, "Rudi", "rudi@gmail.com");
        System.out.println(wallet.setOwner(owner));
    }

    @AfterEach
    void after(){
        System.out.println("After Each dilakukan");
    }
    @AfterAll
    void afterAll(){
        System.out.println("After All dilakukan");
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 100000, 0})
    @DisplayName("Test Deposit Berbagai Nominal")
    void depositMultipleAmounts(int amount) {
        wallet.deposit(amount);
        Assertions.assertEquals(amount, wallet.getCash());
    }

    @ParameterizedTest
    @CsvSource({
            "5000, 10000, 5000",   // Tarik 5rb dari 10rb -> sisa 5rb
            "10000, 10000, 0",     // Tarik semua -> sisa 0
            "0, 5000, 5000"        // Tarik 0 -> sisa tetap
    })
    @DisplayName("Test Withdraw Berhasil")
    void withdrawSuccessTest(int withdrawAmount, int initialDeposit, int expectedBalance) {
        wallet.deposit(initialDeposit);
        wallet.withdraw(withdrawAmount);
        Assertions.assertEquals(expectedBalance, wallet.getCash());
    }

    @ParameterizedTest
    @CsvSource({
            "15000, 10000", // Tarik 15rb padahal saldo cuma 10rb
            "1, 0"          // Tarik 1 padahal saldo 0
    })
    @DisplayName("Test Withdraw Saldo Tidak Cukup")
    void withdrawInsufficientBalance(int withdrawAmount, int initialDeposit) {
        wallet.deposit(initialDeposit);
        String result = wallet.withdraw(withdrawAmount);
        Assertions.assertEquals("Saldo anda tidak mencukupi", result);
    }

    @ParameterizedTest
    @CsvSource({
            "BRI, 1234",
            "BNI, 5566",
            "BCA, 9999"
    })
    @DisplayName("Test Tambah dan Cek Kartu")
    void addAndCheckCardsTest(String bank, int accNumber) {
        wallet.addCards(bank, accNumber);
        Assertions.assertTrue(wallet.checkCards(bank, accNumber));
    }
}
