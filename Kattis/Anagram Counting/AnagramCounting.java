import java.io.*;
import java.math.BigInteger;
import java.util.*;

 class AnagramCounting {

    public static void main(String[] args) {
        BigInteger[] factorial = new BigInteger[201];
        factorial[0] = BigInteger.ONE;
        factorial[1] = BigInteger.ONE;
        for (int i = 2; i < 201; i++) {
            factorial[i] = BigInteger.valueOf(i).multiply(factorial[i - 1]);
        }
        Scanner reader = new Scanner(System.in);
        StringBuilder outBuffer = new StringBuilder();
        while (reader.hasNext()) {
            int[] countChar = new int[58];
            String givenString = reader.nextLine();
            for (int i = 0; i < givenString.length(); i++) {
                countChar[givenString.charAt(i) - 'A']++;
            }
            List<Integer> sameChar = new ArrayList<>();
            for (int count : countChar) {
                if (count > 1)
                    sameChar.add(count);
            }
            BigInteger res = factorial[givenString.length()];
            for (int count : sameChar) {
                res = res.divide(factorial[count]);
            }
            outBuffer.append(res + "\n");
        }
        System.out.println(outBuffer);
    }

}