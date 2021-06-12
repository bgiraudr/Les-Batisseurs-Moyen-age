package test;

import org.junit.*;
import static org.junit.Assert.*;
import batisseur.Worker;

import java.util.ArrayList;

public class WorkerTest {

    Worker w;

    @Before()
    public void setUp() {
        w = new Worker("name",1,2,3,0,3);
    }

    @After()
    public void tearDown() {
        w = null;
    }

    @Test()
    public void testWorker() {
        assertNotNull(w);
    }

    @Test()
    public void getCost() {
        assertTrue(w.getCost() == 3);
        w.setCost(6);
        assertTrue(w.getCost() == 6);
    }

    @Test()
    public void getWood() {
        assertTrue(w.getWood() == 1);
    }

    @Test()
    public void getStone() {
        assertTrue(w.getStone() == 2);
    }

    @Test()
    public void getKnowledge() {
        assertTrue(w.getKnowledge() == 3);
    }

    @Test()
    public void getTile() {
        assertTrue(w.getTile() == 0);
    }

    @Test()
    public void getName() {
        assertSame(w.getName(), "name");
    }
}