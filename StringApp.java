import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StringApp {

  /**
   * Reads the contents of a file and returns it as a String.
   *
   * @param path the path to the file
   * @return the contents of the file as a String, or "file not found!" if an IOException occurs
   */
  public static String readFileAsString(String path) {
    try {
      return Files.readString(Path.of(path));
    } catch (IOException e) {
      return "file not found!";
    }
  }


  // Part 1
  public static String pow(String s, int n) {
    String result = "";
    if (n <= 0) return "";

    for (int i=0; i<n; i++) {
      result += s;
    }
    return result;
  }

  // Part 2
  public static int factorCount(String a, String f) {
      int count = 0;

      while (a.length() >= f.length()) {
      int i= a.indexOf(f);
      if (i == -1) {
          break;
      }
      count++;
      a = a.substring(i + f.length());
    }
    return count;
  }

  public static int factorCount(String a, String f, boolean caseSensitive) {
    int count = 0;

    if (!caseSensitive) {
      a = a.toLowerCase();
      f = f.toLowerCase();
    }

    while (a.length() >= f.length()) {
        int i= a.indexOf(f);
        if (i == -1) {
            break;
        }
        count++;
        a = a.substring(i + f.length());
    }
    return count;
  }

  // Part 3
  public static void main(String[] args) {
    String input = args[0].toLowerCase();
    if (input.length()==0) return;

    int[] counts = new int[26];

    for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        if (ch >= 'a' && ch <= 'z') {
            counts[ch - 'a']++;
        }
    }

    for (char letter = 'a'; letter <= 'z'; letter++) {
        System.out.println(letter + ": " + counts[letter - 'a']);
    }
  }
}
