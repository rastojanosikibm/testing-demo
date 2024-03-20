import org.example.DemoTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSuite2 {

    @BeforeClass
    public static void SetUpClass() {

    }

    @Test
    public void firstTest() throws Throwable {
        DemoTest demoTest = new DemoTest();
        demoTest.run();
    }

    @Test
    public void secondTest() throws Throwable {
        DemoTest demoTest = new DemoTest();
        demoTest.run();
    }

    @AfterClass
    public static void TearDownClass() {
    }
}