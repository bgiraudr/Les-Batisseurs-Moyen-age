package test;

import org.junit.*;
import static org.junit.Assert.*;
import batisseur.*;

import java.util.ArrayList;

public class MachineTest {

    Machine m;

    @Before()
    public void setUp() {
        m = new Machine("name",1,2,3,0,3,0,0,0,1);
    }

    @After()
    public void tearDown() {
        m = null;
    }

    @Test()
    public void testMachine() {
        assertNotNull(m);
    }

    @Test()
    public void getWorkerOn() {
        ArrayList<IWorker> workerOn = new ArrayList<IWorker>();
        Worker w1 = new Worker("Test",0,1,2,3,4);
        m.addWorkerOn(w1);
        workerOn.add(w1);
        assertEquals(m.getWorkerOn(),workerOn);
        Worker w2 = new Worker("Test",0,1,2,3,4);
        m.addWorkerOn(w2);
        workerOn.add(w2);
        assertEquals(m.getWorkerOn(),workerOn);
    }

    @Test()
    public void addWorkerOn() {
        Worker w2 = new Worker("Test",0,1,2,3,4);
        Machine m1 = new Machine("Test",0,1,1,1,1,1,1,1,1);
        m.addWorkerOn(w2);
        m.addWorkerOn(m1);
        assertTrue(m.getWorkerOn().contains(w2));
        assertFalse(m.getWorkerOn().contains(m1)); //the machine is not a worker
        m1.addWorkerOn(new Worker("Test",0,2,2,3,4));
        m.addWorkerOn(m1);
        assertTrue(m.getWorkerOn().contains(m1));
    }

    @Test()
    public void removeWorkerOn() {
        Worker w3 = new Worker("Test",0,1,2,3,4);
        m.addWorkerOn(w3);
        m.removeWorkerOn(w3);
        assertFalse(m.getWorkerOn().contains(w3));
    }

    @Test()
    public void getPoint() {
        assertTrue(m.getPoint() == 3);
        m.setPoint(2);
        assertTrue(m.getPoint() == 2);
    }

    @Test()
    public void getMachineBuff() {
        String[] buff = {"1","tuiles"};
        assertArrayEquals(m.getMachineBuff(), buff);
    }

    @Test()
    public void checkRessources() {
        int[] a = {0,0,0,0};
        assertArrayEquals(m.checkRessources(),a);

        int[] b = {0,1,2,3};
        Worker w3 = new Worker("Test",0,1,2,3,4);
        Worker w2 = new Worker("Test",1,3,2,1,0);
        m.addWorkerOn(w3);
        assertArrayEquals(m.checkRessources(),b);
        int[] c = {1,4,4,4};
        m.addWorkerOn(w2);
        assertArrayEquals(m.checkRessources(),c);
    }
}