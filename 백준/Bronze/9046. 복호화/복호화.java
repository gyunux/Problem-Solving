import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(br.readLine());
        for(int r = 0; r < repeat ; r++){
            String word = br.readLine().trim().toLowerCase();

            int[] charCount = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isAlphabetic(c)) {
                    charCount[c - 'a']++;
                }
            }

            int maxCount = -1;
            char maxChar = '?';

            for (int i = 0; i < 26; i++) {
                if (charCount[i] > maxCount) {
                    maxCount = charCount[i];
                    maxChar = (char) (i + 'a');
                } else if (charCount[i] == maxCount) {
                    maxChar = '?';
                }
            }

            System.out.println(maxChar);
   
        }
    }
}