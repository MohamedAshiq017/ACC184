import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       
        System.out.print("Enter the number of words in the dictionary: ");
        int wordCount = input.nextInt();

        System.out.print("Enter the string to be segmented: ");
        String str = input.next();

        String[] dictionary = new String[wordCount];
        
    
        System.out.println("Enter the words in the dictionary:");
        for (int i = 0; i < wordCount; i++) {
            dictionary[i] = input.next();
        }

        System.out.println(canSegmentString(str, dictionary));
    }

 
    private static int canSegmentString(String str, String[] dictionary) {
       
        boolean[] possible = new boolean[str.length() + 1];
        possible[0] = true;


        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (possible[j] && isWordInDictionary(str.substring(j, i), dictionary)) {
                    possible[i] = true;
                    break;
                }
            }
        }

    
        return possible[str.length()] ? 1 : 0;
    }

    private static boolean isWordInDictionary(String word, String[] dictionary) {
        for (String dictWord : dictionary) {
            if (word.equals(dictWord)) {
                return true;
            }
        }
        return false;
    }
}
