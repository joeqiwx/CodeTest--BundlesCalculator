import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import static org.junit.jupiter.api.Assertions.*;

class BundleCalculatorTest {
    Logger logger = Logger.getLogger(BundleCalculator.class.getName());
    private OutputStream logOut;
    private StreamHandler testLogHandler;

    @BeforeEach
    public void setUp() throws Exception {
        setUpLogHandler(logger);
    }

    @Test
    public final void appHasCorrectOutPut(){
        String[] args = {"10", "IMG"};
        new CommandLine(new BundleCalculator()).execute(args);
        testLogHandler.flush();
        String captured = logOut.toString();
        assertTrue(captured.contains("10 IMG $800"));
    }

    protected void setUpLogHandler(Logger logger) {
        logOut = new ByteArrayOutputStream();
        Handler[] handlers = logger.getParent().getHandlers();
        testLogHandler = new StreamHandler(logOut, handlers[0].getFormatter());
        logger.addHandler(testLogHandler);
    }
}