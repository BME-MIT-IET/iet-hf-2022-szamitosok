import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExampleTest {
    private FrameFixture frameFixture;

    @Before
    public void setUp() {
        frameFixture = new FrameFixture(new MainPanel()); //create a frame from main panel
        frameFixture.show(); //make frame visible
    }

    @After
    public void tearDown() {
        frameFixture.cleanUp();
    }

    @Test
    public void testFrameVisibility() throws InterruptedException {
        Thread.sleep(2000);
        frameFixture.requireVisible(); //validate frame is visible
    }
}