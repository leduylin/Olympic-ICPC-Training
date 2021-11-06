import java.io.*;
import java.util.*;

class Peragrams {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] countChar = new int[26];
        String givenString = reader.next();
        for (int i = 0; i < givenString.length(); i++) {
            countChar[givenString.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (countChar[i] % 2 != 0)
                count++;
        }
        if (count > 0)
            System.out.println(count - 1);
        else
            System.out.println(0);
    }

}