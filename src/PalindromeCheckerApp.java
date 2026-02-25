import java.util.*;

public class PalindromeCheckerApp {

    // -------------------------------
    // 1. Two-Pointer Approach
    // -------------------------------
    public static boolean twoPointerCheck(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = processed.length() - 1;

        while (start < end) {
            if (processed.charAt(start) != processed.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // -------------------------------
    // 2. Stack Approach
    // -------------------------------
    public static boolean stackCheck(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : processed.toCharArray()) {
            stack.push(c);
        }

        for (char c : processed.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // -------------------------------
    // 3. StringBuilder Reverse Approach
    // -------------------------------
    public static boolean reverseCheck(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(processed).reverse().toString();
        return processed.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Two-Pointer Timing
        long startTime1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        // Stack Timing
        long startTime2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        // Reverse Timing
        long startTime3 = System.nanoTime();
        boolean result3 = reverseCheck(input);
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;

        System.out.println("\n--- Results ---");
        System.out.println("Two-Pointer Result: " + result1 + " | Time: " + duration1 + " ns");
        System.out.println("Stack Result:       " + result2 + " | Time: " + duration2 + " ns");
        System.out.println("Reverse Result:     " + result3 + " | Time: " + duration3 + " ns");

        scanner.close();
    }
}