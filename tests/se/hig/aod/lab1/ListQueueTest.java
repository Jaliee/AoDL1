package se.hig.aod.lab1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListQueueTest {

    ListQueue<Character> testQueue;
    Character[] fixture = {'a', 'b', 'c', 'd'};

    private void populateQueue(Character[] citizens) {
        for (Character c : citizens) {
            testQueue.enqueue(c);
        }
    }

    @Before
    public void setUp() throws Exception {
        testQueue = new ListQueue<>();
    }

    @After
    public void tearDown() throws Exception {
        testQueue = null;
    }

    @Test
    public void clearEmpty() {
        try {
            testQueue.clear();
        } catch (Exception e) {
            fail("Unexpected error: " + e);
        }

        if (!testQueue.isEmpty()) {
            fail("Queue not cleared");
        }
    }

    @Test
    public void clearPopulated() {
        populateQueue(fixture);
        try {
            testQueue.clear();
        } catch (Exception e) {
            fail("Unexpected error: " + e);
        }

        if (!testQueue.isEmpty()) {
            fail("Queue not cleared");
        }
    }

    @Test
    public void isEmpty() {
        assertTrue("Empty queue not detected as empty", testQueue.isEmpty());
        populateQueue(fixture);
        assertFalse("Populated queue detected as empty", testQueue.isEmpty());
    }

    @Test
    public void enqueue() {
    }

    @Test
    public void dequeue() {
    }

    @Test
    public void getFront() {
    }
}