package se.hig.aod.lab1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckBalanceTest {

    @Test
    public void isBalanced() {
        assertTrue("test av ()", CheckBalance.isBalanced("()"));
        assertTrue("test av ((())())", CheckBalance.isBalanced("((())())"));
        assertFalse("test av )(", CheckBalance.isBalanced(")("));
        assertFalse("test av (()", CheckBalance.isBalanced("(()"));
        assertFalse("test av ())", CheckBalance.isBalanced("())"));
    }
}