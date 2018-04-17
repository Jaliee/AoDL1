package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for ListStack
 *
 * Modified by Joakim Liljeroth
 */

public class ListStackTest {
    ListStack<Character> testStack;
    Character[] fixture = {'a', 'b', 'c', 'd'};

    private void populateStack(Character[] citizens) {
        for (Character c : citizens) {
            testStack.push(c);
        }
    }

    @Before
    public void setUp() {
        testStack = new ListStack<>();
    }

    @After
    public void tearDown() {
        testStack = null;
    }

    @Test
    public void testNewStackIsEmpty() {

        assertTrue("A new instance cannot contain any item!", testStack.isEmpty());
    }

    @Test
    public void testStackWithItemNotEmpty() {
        testStack.push('a');
        assertFalse("Containing an item but empty!", testStack.isEmpty());
    }

    @Test
    public void testPopOnEmptyStack() {
        try {
            testStack.pop();
            fail("Expected: StackEmptyException!");
        } catch (StackEmptyException e) {
            assertNotNull("Expected: StackEmptyException!", e);
        }
    }

    @Test
    public void testStackIsEmptyAfterPop() {

        populateStack(fixture);

        for (int i = 0; i < fixture.length - 1; i++) {
            testStack.pop();
            assertFalse("Should not be empty", testStack.isEmpty());
        }
        testStack.pop();
        assertTrue("Should be empty", testStack.isEmpty());
    }

    @Test
    public void testPopOrder() {

        populateStack(fixture);

        for (int i = fixture.length - 1; i >= 0; i--) {
            assertEquals(fixture[i], testStack.pop());
        }
    }

    @Test
    public void testClearEmptyStack() {

        try {
            testStack.clear();
        } catch (Exception e) {
            fail("Unexpected Error: " + e);
        }

        if (!testStack.isEmpty()) {
            fail("Stack not cleared");
        }
    }

    @Test
    public void testClearPopulatedStack() {

        populateStack(fixture);

        try {
            testStack.clear();
        } catch (Exception e) {
            fail("Unexpected Error: " + e);
        }

        if (!testStack.isEmpty()) {
            fail("Stack not cleared");
        }
    }
}
