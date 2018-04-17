package se.hig.aod.lab1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for ListQueue
 *
 * @author Joakim Liljeroth
 */

public class ListQueueTest {

    ListQueue<Character> testQueue;
    Character[] fixture = {'a', 'b', 'c', 'd'};

    private void populateQueue(Character[] citizens) {
        for (Character c : citizens) {
            testQueue.enqueue(c);
        }
    }

    @Before
    public void setUp() {
        testQueue = new ListQueue<>();
    }

    @After
    public void tearDown() {
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
        testQueue.enqueue(fixture[0]);
        assertEquals(fixture[0], testQueue.dequeue());

    }

    @Test
    public void dequeue() {

        populateQueue(fixture);
        for (Character c : fixture) {
            assertEquals(c, testQueue.dequeue());
        }

        try {
            testQueue.dequeue();
            fail("Expected QueueEmptyException");
        } catch (QueueEmptyException qee) {
            assertNotNull("Expected QueueEmptyException", qee);
        }

    }

    @Test
    public void getFront() {
        try {
            testQueue.getFront();
            fail("Expected QueueEmptyException");
        } catch (QueueEmptyException qee) {
            assertNotNull("Expected QueueEmptyException", qee);
        }
        populateQueue(fixture);
        assertEquals(fixture[0], testQueue.getFront());
        assertEquals(fixture[0], testQueue.getFront());
        testQueue.dequeue();
        assertEquals(fixture[1], testQueue.getFront());
        testQueue.clear();
    }
}