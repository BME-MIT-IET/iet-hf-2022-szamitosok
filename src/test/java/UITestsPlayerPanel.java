import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import View.PlayersPanel;

public class UITestsPlayerPanel {
    private FrameFixture playersFrameFicture;

    @Before
    public void setUp() {
        playersFrameFicture = new FrameFixture(new PlayersPanel(3)); //create a frame from players panel
    }

    @After
    public void tearDown() {
        playersFrameFicture.cleanUp();
    }
    @Test
    public void testPlayersPanelWith3Players() throws InterruptedException {
        playersFrameFicture.show(); //make frame visible
        Thread.sleep(2000);
        playersFrameFicture.requireVisible(); //validate frame is visible
        playersFrameFicture.textBox("PlayerName0TF").setText("Player1");
        playersFrameFicture.textBox("PlayerName1TF").setText("Player2");
        playersFrameFicture.textBox("PlayerName2TF").setText("Player3");
        Thread.sleep(2000);
        playersFrameFicture.button("okBT").click();
        Thread.sleep(5000);
        playersFrameFicture.requireNotVisible();
    }
}