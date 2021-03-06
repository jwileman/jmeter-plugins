package kg.apc.jmeter.config;

import java.io.File;
import java.io.IOException;
import org.apache.jmeter.engine.event.LoopIterationEvent;
import org.apache.jorphan.util.JMeterStopTestNowException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.*;

/**
 *
 * @author direvius
 */
public class LockFileTest {

    private LockFile testInstance;

    public LockFileTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        testInstance = new LockFile();
        testInstance.setFilename("test.lock");
        testInstance.setFilemask("testmask*.lock");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of testStarted method, of class LockFile. Happy Scenario
     */
    @Test
    public void testTestStartedHappy() {
        System.out.println("testStarted Happy");
        testInstance.testStarted();
        File f = new File("test.lock");
        assert (f.exists());
        f.delete();
    }

    /**
     * Test of testStarted method, of class LockFile. Unhappy scenario
     */
    @Test
    public void testTestStartedUnhappy() {
        System.out.println("testStarted Unhappy");
        testInstance.testStarted();
        File f = new File("test.lock");
        try {
            f.createNewFile();
        } catch (IOException ex) {
            fail("Could not create lock file by hands");
        }
        boolean thrown = false;
        try {
            testInstance.testStarted();
        } catch (JMeterStopTestNowException e) {
            thrown = true;
        }
        assert thrown;
        f.delete();
    }

    /**
     * Test of testStarted method, of class LockFile. Unhappy by mask scenario
     */
    @Test
    public void testTestStartedUnhappyMask() {
        System.out.println("testStarted Unhappy by mask");
        testInstance.testStarted();
        File f = new File("testmask123.lock");
        try {
            f.createNewFile();
        } catch (IOException ex) {
            fail("Could not create lock file by hands");
        }
        boolean thrown = false;
        try {
            testInstance.testStarted();
        } catch (JMeterStopTestNowException e) {
            thrown = true;
        }
        assert thrown;
        f.delete();
    }

    /**
     * Test of testEnded method, of class LockFile. Happy Scenario
     */
    @Test
    public void testTestEndedHappy() {
        System.out.println("testEnded Happy");
        File f = new File("test.lock");
        try {
            f.createNewFile();
        } catch (IOException ex) {
            fail("Could not create lock file by hands");
        }
        testInstance.testEnded();
        assert !f.exists();
    }

    /**
     * Test of testEnded method, of class LockFile. Unhappy Scenario
     */
    @Test
    public void testTestEndedUnhappy() {
        System.out.println("testEnded Unhappy");
        File f = new File("test.lock");
        testInstance.testEnded();
        assert !f.exists();
    }

    /**
     * Test of testIterationStart method, of class LockFile.
     */
    @Test
    public void testTestIterationStart() {
        System.out.println("testIterationStart");
        LoopIterationEvent lie = null;
        LockFile instance = new LockFile();
        instance.testIterationStart(lie);
    }

    /**
     * Test of filename property, of class LockFile.
     */
    @Test
    public void testSetGetFilename() {
        System.out.println("setFilename");
        String filename = "testfilename";
        LockFile instance = new LockFile();
        instance.setFilename(filename);
        assertEquals(filename, instance.getFilename());
    }

    /**
     * Test of filemask property, of class LockFile.
     */
    @Test
    public void testSetGetFilemask() {
        System.out.println("setFilemask");
        String filemask = "testfilemask";
        LockFile instance = new LockFile();
        instance.setFilemask(filemask);
        assertEquals(filemask, instance.getFilemask());
    }

    /**
     * Test of testStarted method, of class LockFile.
     */
    @Test
    public void testTestStarted_0args() {
        System.out.println("testStarted");
        LockFile instance = new LockFile();
        instance.testStarted();
    }

    /**
     * Test of testStarted method, of class LockFile.
     */
    @Test
    public void testTestStarted_String() {
        System.out.println("testStarted");
        String string = "";
        LockFile instance = new LockFile();
        instance.testStarted(string);
    }

    /**
     * Test of testEnded method, of class LockFile.
     */
    @Test
    public void testTestEnded_0args() {
        System.out.println("testEnded");
        LockFile instance = new LockFile();
        instance.testEnded();
    }

    /**
     * Test of testEnded method, of class LockFile.
     */
    @Test
    public void testTestEnded_String() {
        System.out.println("testEnded");
        String string = "";
        LockFile instance = new LockFile();
        instance.testEnded(string);
    }

    /**
     * Test of getFilename method, of class LockFile.
     */
    @Test
    public void testGetFilename() {
        System.out.println("getFilename");
        LockFile instance = new LockFile();
        String expResult = "";
        String result = instance.getFilename();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFilename method, of class LockFile.
     */
    @Test
    public void testSetFilename() {
        System.out.println("setFilename");
        String filename = "";
        LockFile instance = new LockFile();
        instance.setFilename(filename);
    }

    /**
     * Test of getFilemask method, of class LockFile.
     */
    @Test
    public void testGetFilemask() {
        System.out.println("getFilemask");
        LockFile instance = new LockFile();
        String expResult = "";
        String result = instance.getFilemask();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFilemask method, of class LockFile.
     */
    @Test
    public void testSetFilemask() {
        System.out.println("setFilemask");
        String filemask = "";
        LockFile instance = new LockFile();
        instance.setFilemask(filemask);
    }
}
