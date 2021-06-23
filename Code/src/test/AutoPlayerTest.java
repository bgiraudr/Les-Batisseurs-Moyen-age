package test;

import org.junit.*;
import static org.junit.Assert.*;
import batisseur.*;

import java.util.ArrayList;

public class AutoPlayerTest {

    AutoPlayer p;
    Game g;

    @Before()
    public void setUp() {
        g = new Game("a","b","c","d",Mode.HA,UI.TUI);
        p = new AutoPlayer("name",new Board(g));
    }

    @After()
    public void tearDown() {
        p = null;
        g = null;
    }

    @Test()
    public void testAutoPlayer() {
        assertNotNull(p);
    }

    @Test()
    public void getDifficulty() {
        assertTrue(p.getDifficulty() == Difficulty.EASY);
        p.setDifficulty(Difficulty.HARD);
        assertTrue(p.getDifficulty() == Difficulty.HARD);
        assertFalse(p.getDifficulty() == Difficulty.EASY);
    }

    @Test()
    public void getName() {
        assertSame(p.getName(), "name");
    }

    @Test()
    public void getPoint() {
        assertTrue(p.getPoint() == 0);
        p.addPoint(3);
        assertTrue(p.getPoint() == 3);
        p.addPoint(3);
        assertTrue(p.getPoint() == 6);
    }

    @Test()
    public void getCoin() {
        p.setCoin(0);
        assertTrue(p.getCoin() == 0);
        p.addCoin(3);
        assertTrue(p.getCoin() == 3);
        p.addCoin(3);
        assertTrue(p.getCoin() == 6);
    }

    @Test()
    public void getAction() {
        p.setAction(3);
        assertTrue(p.getAction() == 3);
        p.removeAction(2);
        assertTrue(p.getAction() == 1);
        p.removeAction(2);
        assertTrue(p.getAction() == 1);
    }

    @Test()
    public void buyAction() {
        p.setCoin(0);
        p.setAction(0);
        p.buyAction(2);
        assertFalse(p.getAction() == 2);
        p.addCoin(10);
        p.buyAction(2);
        assertTrue(p.getAction() == 2);
        assertTrue(p.getCoin() == 0);
        p.addCoin(3);
        p.buyAction(1);
        assertFalse(p.getPoint() == 3);
        assertTrue(p.getCoin() == 3);
    }

    @Test()
    public void actionToCoins() {
        p.setAction(3);
        p.setCoin(0);
        p.actionToCoins(3);
        assertTrue(p.getCoin() == 6);
        p.setAction(3);
        p.setCoin(0);
        p.actionToCoins(2);
        assertTrue(p.getCoin() == 3);
        assertTrue(p.getAction() == 1);
        p.setCoin(0);
        p.actionToCoins(1);
        assertTrue(p.getCoin() == 1);
        assertTrue(p.getAction() == 0);
    }

    @Test()
    public void workerToBuilding() {
        IWorker w1 = new Worker("Test",0,1,2,3,4);
        IBuilding b1 = new Building("name",1,2,3,0,3,5);
        p.setCoin(30);
        p.setAction(3);
        //addBuilding vérifie que les cartes sont dans la main du joueur
        //donc on doit ajouter ces cartes au joueur
        p.getBoard().getFiveBuildingCards().add(b1);
        p.getBoard().getFiveWorkerCards().add(w1);
        p.hireWorker(w1);
        p.addBuilding(b1);
        p.workerToBuilding(w1,b1);

        assertTrue(p.getStartedBuilding().contains(b1));
        assertTrue(p.getBuildingsCards().contains(b1));
        ArrayList<IWorker> worker = b1.getWorkerOn();
        assertTrue(b1.getWorkerOn().contains(w1));

        p.setCoin(0);
        p.setAction(3);
        IWorker w2 = new Worker("Test",0,1,2,3,4);
        p.getBoard().getFiveWorkerCards().add(w2);
        p.hireWorker(w2);
        p.workerToBuilding(w2,b1);
        assertFalse(b1.getWorkerOn().contains(w2));

    }

    @Test()
    public void getBuildingsCards() {
        IBuilding b2 = new Building("name",1,2,3,0,3,5);
        ArrayList<IBuilding> arr = new ArrayList<IBuilding>();
        arr.add(b2);
        p.setAction(3);
        p.getBoard().getFiveBuildingCards().add(b2);
        p.addBuilding(b2);
        assertEquals(arr,p.getBuildingsCards());
    }

    @Test()
    public void getWorkerCards() {
        IWorker w1 = new Worker("Test",0,1,2,3,4);
        p.setCoin(30);
        //le worker doit être sur le board pour être recruté
        p.getBoard().getFiveWorkerCards().add(w1);
        p.hireWorker(w1);
        assertTrue(p.getWorkerCards().contains(w1));
        assertTrue(p.getCoin() == 26);
    }

    @Test()
    public void getRemoveBuilding() {
        IWorker w1 = new Worker("Test",0,1,2,3,4);
        IWorker w2 = new Worker("Test",0,1,2,3,4);
        IBuilding b1 = new Building("name",1,2,3,0,3,5);
        p.setCoin(30);
        p.setAction(50);
        p.getBoard().getFiveBuildingCards().add(b1);
        p.getBoard().getFiveWorkerCards().add(w1);
        p.getBoard().getFiveWorkerCards().add(w2);
        p.hireWorker(w1);
        p.addBuilding(b1);
        p.hireWorker(w2);

        p.setAction(10);
        assertTrue(p.getRemoveBuilding(b1) == 1);
        p.workerToBuilding(w1,b1);

        assertTrue(p.getAction() == 9);
        assertTrue(p.getRemoveBuilding(b1) == 2);
        p.workerToBuilding(w2,b1);
        assertTrue(p.getAction() == 7);
    }

    @Test()
    public void finishBuilding() {
        IWorker w1 = new Worker("Test",0,1,2,3,4);
        IBuilding b1 = new Building("name",0,1,1,1,3,5);
        p.setCoin(30);
        p.setAction(50);
        p.getBoard().getFiveBuildingCards().add(b1);
        p.getBoard().getFiveWorkerCards().add(w1);
        p.hireWorker(w1);
        assertTrue(p.getCoin() == 26);
        p.addBuilding(b1);
        p.workerToBuilding(w1,b1);
        assertTrue(p.getWorkerCards().contains(w1));
        assertFalse(p.getBuildingsCards().contains(b1));
        assertTrue(p.getCoin() == 25); //cout worker + gain batiment
        assertTrue(p.getPoint() == 5);
    }
}