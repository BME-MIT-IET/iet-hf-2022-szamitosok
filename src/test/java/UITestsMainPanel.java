import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import View.MainPanel;

public class UITestsMainPanel {
    private FrameFixture mainFrameFixture;

    @Before
    public void setUp() {
        mainFrameFixture = new FrameFixture(new MainPanel()); //create a frame from main panel
    }

    @After
    public void tearDown() {
        mainFrameFixture.cleanUp();
    }

    @Test
    public void testMainPanelWith3Players() throws InterruptedException {
        mainFrameFixture.show(); //make frame visible
        Thread.sleep(2000);
        mainFrameFixture.requireVisible(); //validate frame is visible
        mainFrameFixture.textBox("numberOfPlayersTF").setText("3");
        mainFrameFixture.button("startBT").click();
        Thread.sleep(2000);
        mainFrameFixture.requireNotVisible();
    }
}