import org.junit.Before;
import org.junit.Test;
import root.Task;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class TaskTest {

    private Task task;
    private File propsFile;
    private File inputFile;
    private File outputFile;

    @Before
    public void setUp() {
        task = new Task();
        propsFile = new File("example.properties");
        inputFile = new File("input.xml");
        outputFile = new File("output.xml");
    }

    @Test
    public void sourceFileTest() {
        assertTrue(propsFile.exists());
    }

    @Test
    public void inputFileTest() {
        assertTrue(inputFile.exists());
    }

    @Test
    public void outputFileTest() {
        assertTrue(outputFile.exists());
    }

    @Test
    public void fileTransformationTest() throws IOException {
        task.readSourceAndProcessData();
        assertEquals(propsFile, propsFile);
        assertNotEquals(inputFile, outputFile);
    }

}