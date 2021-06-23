package test;

import org.junit.*;
import static org.junit.Assert.*;
import batisseur.*;

import java.util.ArrayList;

public class GameTest {

    Game g;

    @Before()
    public void setUp() {
        g = new Game("a","b","c","d",Mode.HA,UI.TUI);
    }

    @After()
    public void tearDown() {
        g = null;
    }

    @Test()
    public void testGame() {
        assertNotNull(g);
    }

    @Test()
    public void changeCurrent() {
        g.createPlayers("","","","",Mode.HA);
        Player[] p = g.getAllPlayers();
        g.setCurrent(p[0]);
        g.changeCurrent();
        assertTrue(g.getCurrent() == p[1]);
    }

    @Test()
    public void checkWin() {
        g.createPlayers("","","","",Mode.HA);
        Player[] p = g.getAllPlayers();
        p[0].addPoint(20);
        assertTrue(g.checkWin());
    }

    @Test()
    public void end() {
        g.createPlayers("","","","",Mode.HAA);
        Player[] p = g.getAllPlayers();
        p[0].addPoint(20);
        p[1].addPoint(13);
        p[1].setCoin(30);
        p[2].addPoint(13);
        p[2].setCoin(65);
        g.end();
    }
}