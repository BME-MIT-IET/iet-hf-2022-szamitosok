import java.io.Console;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import View.MainPanel;
import View.PlayersPanel;

public class UITests {
    private FrameFixture mainFrameFixture;
    private FrameFixture playersFrameFicture;

    @Before
    public void setUp() {
        mainFrameFixture = new FrameFixture(new MainPanel()); //create a frame from main panel
        //playersFrameFicture = new FrameFixture(new PlayersPanel(3)); //create a frame from players panel
    }

    @After
    public void tearDown() {
        mainFrameFixture.cleanUp();
        //playersFrameFicture.cleanUp();
    }

    @Test
    public void testMainPanelWith3Players() throws InterruptedException {
        mainFrameFixture.show(); //make frame visible
        Thread.sleep(2000);
        mainFrameFixture.requireVisible(); //validate frame is visible
        mainFrameFixture.textBox("numberOfPlayersTF").setText("3");
        mainFrameFixture.button("startBT").click();
        Thread.sleep(5000);
        mainFrameFixture.requireNotVisible();
    }
    @Test
    public void testPlayersPanelWith3Players() throws InterruptedException {
        playersFrameFicture.show(); //make frame visible
        Thread.sleep(2000);
        playersFrameFicture.requireVisible(); //validate frame is visible
        mainFrameFixture.textBox("PlayerName0TF").setText("Player0");
        mainFrameFixture.textBox("PlayerName1TF").setText("Player1");
        mainFrameFixture.textBox("PlayerName2TF").setText("Player2");
        Thread.sleep(5000);
        mainFrameFixture.requireNotVisible();
    }
}