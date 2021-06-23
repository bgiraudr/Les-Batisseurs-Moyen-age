package test;

import org.junit.*;
import static org.junit.Assert.*;
import batisseur.*;

import java.util.ArrayList;

public class BoardTest {

    Game g;
    Board b;

    @Before()
    public void setUp() {
        g = new Game("a","b","c","d",Mode.HA,UI.TUI);
        b = new Board(g);
    }

    @After()
    public void tearDown() {
        b = null;
    }

    @Test()
    public void testBoard() {
        assertNotNull(b);
    }

    @Test()
    public void createWorkerCards() {
        assertTrue(b.getWorkerCards().size() > 0);
    }

    @Test()
    public void createBuildingCards() {
        assertTrue(b.getBuildingCards().size() > 0);
    }

    @Test()
    public void createMachineCards() {
        assertTrue(b.getMachineCards().size() > 0);
    }

    @Test()
    public void pickRandomCard() {
        Card c = b.pickRandomCard(b.getMachineCards());
        assertTrue(b.getMachineCards().contains(c));
    }

    @Test()
    public void generateInitApprenti() {
        Card c = b.generateInitApprenti();
        assertFalse(b.getApprentiCard().contains(c)); //L'apprenti a été enlevé
    }

    @Test()
    public void generateBoardBuilding() {
        b.generateBoardBuilding();
        for(IBuilding a : b.getFiveBuildingCards()) {
            assertFalse(b.getBuildingCards().contains(a));
        }
    }

    @Test()
    public void generateBoardWorker() {
        b.generateBoardWorker();
        for(IWorker a : b.getFiveWorkerCards()) {
            assertFalse(b.getWorkerCards().contains(a));
        }
    }

    @Test()
    public void checkEmpty() {
        assertTrue(!b.checkEmpty());
        b.getWorkerCards().clear();
        assertTrue(b.checkEmpty());
    }
}