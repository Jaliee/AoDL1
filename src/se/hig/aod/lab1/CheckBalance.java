package se.hig.aod.lab1;

import java.util.Scanner;

/**
 * En klass som använder sig av en stack för att kontrollera parentesuttryck.
 *
 * @author Magnus Blom, Peter Jenke
 * @version 2014-01-16
 * Modified by Joakim Liljeroth
 */
public class CheckBalance {
    public static boolean isBalanced(String uttryck) {
        Stack<Character> charStack = new ListStack<Character>();
        boolean balancerad = true;
        for (int i = 0; i < uttryck.length() && balancerad == true; i++) {
            if (uttryck.charAt(i) == '(') {
                charStack.push('(');
            } else if (uttryck.charAt(i) == ')') {
                if (!charStack.isEmpty()) {
                    charStack.pop();
                } else {
                    balancerad = false;
                }
            }
        }
        if (!charStack.isEmpty()) {
            balancerad = false;
        }
        charStack.clear();
        return balancerad;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print("Mata in ett parentesuttryck: ");
            String uttryck = console.next();
            if (isBalanced(uttryck))
                System.out.println("Strängen är parentesbalanserad!");
            else
                System.out.println("Strängen är INTE parentesbalanserad!");
        }
        console.close();
    }
}
