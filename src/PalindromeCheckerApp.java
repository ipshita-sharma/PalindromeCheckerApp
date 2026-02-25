import java.util.Scanner;

// Service Class (Encapsulated Palindrome Logic)
class PalindromeChecker {

    // Public method exposed to client
    public boolean checkPalindrome(String input) {

        // Preprocessing (optional normalization)
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        char[] charArray = processed.toCharArray();

        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}


// Application Class (Client)
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC11: Object-Oriented Palindrome Service ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Creating object of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}