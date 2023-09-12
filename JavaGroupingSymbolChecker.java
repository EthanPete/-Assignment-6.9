import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class JavaGroupingSymbolChecker {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java JavaGroupingSymbolChecker <source-code-file>");
            return;
        }

        String fileName = args[0];

        if (checkGroupingSymbols(fileName)) {
            System.out.println("The source code file has correct grouping symbols.");
        } else {
            System.out.println("The source code file has incorrect grouping symbols.");
        }
    }

    public static boolean checkGroupingSymbols(String fileName) {
        Stack<Character> stack = new Stack<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (c == '(' || c == '{' || c == '[') {
                        stack.push(c);
                    } else if (c == ')' || c == '}' || c == ']') {
                        if (stack.isEmpty()) {
                            return false; // No matching opening symbol found
                        }

                        char top = stack.pop();
                        if (!isValidPair(top, c)) {
                            return false; // Invalid pair of symbols
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return stack.isEmpty(); // All symbols must be matched
    }

    public static boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}