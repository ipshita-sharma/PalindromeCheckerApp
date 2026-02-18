import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    // Entry point of the Java application
    public static void main(String[] args) {

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a string
        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();

        // Create Stack and Queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Push and enqueue each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);     // LIFO
            queue.offer(ch);    // FIFO
        }

        // Variable to track palindrome status
        boolean isPalindrome = true;

        // Compare dequeue (queue) and pop (stack)
        for (int i = 0; i < input.length(); i++) {
            if (!queue.poll().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a Palindrome.");
        }

        // Close scanner
        scanner.close();
    }
}
