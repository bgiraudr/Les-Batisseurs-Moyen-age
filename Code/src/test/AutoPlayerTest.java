package test;

import org.junit.*;
import static org.junit.Assert.*;
import batisseur.*;


import java.util.ArrayList;

public class AutoPlayerTest {

    AutoPlayer p;

    @Before()
    public void setUp() {
        p = new AutoPlayer("name",new Board(),Difficulty.EASY);
    }

    @After()
    public void tearDown() {
        p = null;
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
        Worker w1 = new Worker("Test",0,1,2,3,4);
        Building b1 = new Building("name",1,2,3,0,3,5);
        p.addBuilding(b1);
        p.workerToBuilding(w1,b1);
        assertFalse(p.getStartedBuilding().contains(b1));
        assertTrue(p.getBuildingsCards().contains(b1));
        p.openBuilding(b1);
        p.workerToBuilding(w1,b1);
        assertTrue(p.getStartedBuilding().contains(b1));
        assertFalse(p.getBuildingsCards().contains(b1));
        ArrayList<Card> worker = b1.getWorkerOn();
        assertTrue(b1.getWorkerOn().contains(w1));
    }

    @Test()
    public void getBuildingsCards() {
        Building b2 = new Building("name",1,2,3,0,3,5);
        ArrayList<IBuilding> arr = new ArrayList<IBuilding>();
        arr.add(b2);
        p.addBuilding(b2);
        assertEquals(arr,p.getBuildingsCards());
    }

    @Test()
    public void getWorkerCards() {
        Worker w1 = new Worker("Test",0,1,2,3,4);
        p.setCoin(30);
        p.hireWorker(w1);
        assertTrue(p.getWorkerCards().contains(w1));
        assertTrue(p.getCoin() == 26);
    }
}