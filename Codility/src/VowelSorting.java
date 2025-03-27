
import java.util.*;

public class VowelSorting {
    
    private static int countVowels(String sentence) {
        int c = 0;
        String vowels = "aeiouAEIOU";
        for (char ch : sentence.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
            "Hemant Malviya",
            "Developer",
            "ASE",
            "spring programming"
        );

        sentences.sort((s1, s2) -> Integer.compare(countVowels(s1), countVowels(s2)));

        System.out.println("Sorted sentences: ");
        for (String sentence : sentences) {
            System.out.println(sentence + " (Vowels: " + countVowels(sentence) + ")");
        }
    }
}