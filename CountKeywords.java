import java.util.*;
import java.io.*;

public class CountKeywords {
 public static void main(String[] args) {
  if (args.length != 1) {
   System.out.println("Usage: java CountKeywords <Java source file>");
   System.exit(1);
  }

  String filename = args[0];
  File file = new File(filename);

  if (file.exists()) {
   try {
    int keywordCount = countKeywords(file);
    System.out.println("The number of keywords in " + filename + " is " + keywordCount);
   } catch (IOException e) {
    System.err.println("Error reading the file: " + e.getMessage());
   }
  } else {
   System.out.println("File " + filename + " does not exist");
  }
 }

 public static int countKeywords(File file) throws IOException {
  // Array of all Java keywords + true, false, and null
  String[] keywordString = {
    "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
    "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
    "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
    "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
    "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
    "true", "false", "null"
  };

  Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
  int count = 0;

  try (Scanner input = new Scanner(file)) {
   while (input.hasNextLine()) {
    String line = input.nextLine();

    // Remove comments and strings using regular expressions
    line = line.replaceAll("(//[^\\n]*|/\\*.*?\\*/|\"[^\"]*\")", "");

    // Split the line into words and count keywords
    for (String word : line.split("\\s+")) {
     if (keywordSet.contains(word)) {
      count++;
     }
    }
   }
  }

  return count;
 }
}