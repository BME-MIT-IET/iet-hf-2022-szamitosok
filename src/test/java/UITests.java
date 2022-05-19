import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Test;

import Model.Game;
import View.AsteroidFieldPanel;
import View.ControlPanel;

public class UITests {
    private FrameFixture frameFixture;

    public void setUp(int n) throws InterruptedException{
        startGameWithNPlayers(n);
        frameFixture.show(); //make frame visible
        Thread.sleep(2000);
        frameFixture.requireVisible(); //validate frame is visible
    }

    @After
    public void tearDown() {
        frameFixture.cleanUp();
    }

    @Test
    public void test1() throws InterruptedException {
        setUp(3);
        frameFixture.menuItem("selectPlayerM").click();
        frameFixture.menuItem("0playerMI").click();
        assert frameFixture.menuItem("selectPlayerM").target.getText().equals("Player1");
        frameFixture.menuItem("selectPlayerM").click();
        frameFixture.menuItem("1playerMI").click();
        assert frameFixture.menuItem("selectPlayerM").target.getText().equals("Player2");
        frameFixture.menuItem("selectPlayerM").click();
        frameFixture.menuItem("2playerMI").click();
        assert frameFixture.menuItem("selectPlayerM").target.getText().equals("Player3");
    }

    @Test
    public void test2() throws InterruptedException {
        setUp(1);
        frameFixture.menuItem("selectPlayerM").click();
        frameFixture.menuItem("0playerMI").click();
        assert frameFixture.menuItem("selectPlayerM").target.getText().equals("Player1");
        int layers =Integer.parseInt(frameFixture.label("kivalasztottLayerL").text());
        assert layers>=1;
        frameFixture.button("furjBT").click();
        frameFixture.menuItem("selectPlayerM").click();
        frameFixture.menuItem("0playerMI").click();
        assert frameFixture.menuItem("selectPlayerM").target.getText().equals("Player1");
        int nextlayers =Integer.parseInt(frameFixture.label("kivalasztottLayerL").text());
        assert layers>nextlayers;
    }

    @Test
    public void test3() throws InterruptedException {
        setUp(1);
        frameFixture.menuItem("selectPlayerM").click();
        frameFixture.menuItem("0playerMI").click();
        assert frameFixture.menuItem("selectPlayerM").target.getText().equals("Player1");
        frameFixture.menuItem("selectAsterM").click();
        frameFixture.menuItem("0asteroidMI").click();
        String nextAsteroid = frameFixture.menuItem("selectAsterM").target.getText();
        assert nextAsteroid.split(" ")[0].equals("Model.Asteroid");
        frameFixture.button("mozogjBT").click();
        frameFixture.menuItem("selectPlayerM").click();
        frameFixture.menuItem("0playerMI").click();
        assert frameFixture.menuItem("selectPlayerM").target.getText().equals("Player1");
        assert frameFixture.label("currentAsteroidL").text().equals(nextAsteroid);
    }

    private void startGameWithNPlayers(int n){
        Game game =  new Game();
		ArrayList<String> nevek = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            nevek.add("Player"+(i+1));
        }
        try {
            game.start(nevek);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        JFrame mainFrame = new JFrame();
        JPanel mainPanel = new JPanel();
        JPanel gamePanel = new JPanel();

        JPanel controlPanel = new ControlPanel(game, game.getAsteroids());

        mainPanel.setLayout(new CardLayout());

        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(controlPanel, BorderLayout.EAST);
        gamePanel.add(new AsteroidFieldPanel(mainPanel, game), BorderLayout.WEST);

        mainPanel.add(gamePanel, "GAMEPANEL");
        mainFrame.add(mainPanel);
        mainFrame.pack();
        frameFixture = new FrameFixture(mainFrame); //create a frame from main panel
    }
}