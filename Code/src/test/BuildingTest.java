package test;

import org.junit.*;
import static org.junit.Assert.*;
import batisseur.*;

import java.util.ArrayList;

public class BuildingTest {

    Building b;

    @Before()
    public void setUp() {
        b = new Building("name",1,2,3,0,3,5);
    }

    @After()
    public void tearDown() {
        b = null;
    }

    @Test()
    public void testBuilding() {
        assertNotNull(b);
    }

    @Test()
    public void getWorkerOn() {
        ArrayList<IWorker> workerOn = new ArrayList<IWorker>();
        Worker w1 = new Worker("Test",0,1,2,3,4);
        b.addWorkerOn(w1);
        workerOn.add(w1);
        assertEquals(b.getWorkerOn(),workerOn);
        Worker w2 = new Worker("Test",0,1,2,3,4);
        b.addWorkerOn(w2);
        workerOn.add(w2);
        assertEquals(b.getWorkerOn(),workerOn);
    }

    @Test()
    public void addWorkerOn() {
        Worker w2 = new Worker("Test",0,1,2,3,4);
        Machine m1 = new Machine("Test",0,1,1,1,1,1,1,1,1);
        b.addWorkerOn(w2);
        b.addWorkerOn(m1);
        assertTrue(b.getWorkerOn().contains(w2));
        assertFalse(b.getWorkerOn().contains(m1)); //the machine is not a worker
        m1.addWorkerOn(new Worker("Test",0,2,2,3,4));
        b.addWorkerOn(m1);
        assertTrue(b.getWorkerOn().contains(m1));
    }

    @Test()
    public void removeWorkerOn() {
        Worker w3 = new Worker("Test",0,1,2,3,4);
        b.addWorkerOn(w3);
        b.removeWorkerOn(w3);
        assertFalse(b.getWorkerOn().contains(w3));
    }

    @Test()
    public void getCoin() {
        assertTrue(b.getCoin() == 3);
        b.setCoin(6);
        assertTrue(b.getCoin() == 6);
    }

    @Test()
    public void getPoint() {
        assertTrue(b.getPoint() == 5);
        b.setPoint(2);
        assertTrue(b.getPoint() == 2);
    }
}