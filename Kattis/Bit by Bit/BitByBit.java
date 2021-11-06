import java.io.*;
import java.util.*;

class BitByBit {

    public static void main(String[] args) {
        StringBuilder outBuffer = new StringBuilder();
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        reader.nextLine();
        while (n != 0) {
            res = new String[32];
            Arrays.fill(res, "?");
            String[] temp = res;
            for (int i = 0; i < n; i++) {
                String[] command = reader.nextLine().split(" ");
                if (command[0].equals("CLEAR")) {
                    clear(Integer.valueOf(command[1]));
                } else if (command[0].equals("SET")) {
                    set(Integer.valueOf(command[1]));
                } else if (command[0].equals("OR")) {
                    or(Integer.valueOf(command[1]), Integer.valueOf(command[2]));
                } else if (command[0].equals("AND")) {
                    and(Integer.valueOf(command[1]), Integer.valueOf(command[2]));
                }
            }
            for (String bit : res) {
                outBuffer.append(bit);
            }
            outBuffer.append("\n");
            n = reader.nextInt();
            reader.nextLine();
        }
        System.out.println(outBuffer);
    }

    static String[] res = new String[32];

    public static void clear(int bit) {
        res[32 - 1 - bit] = "0";
    }

    public static void set(int bit) {
        res[32 - 1 - bit] = "1";
    }

    public static void or(int bitI, int bitJ) {
        if (res[32 - 1 - bitI].equals("1") || res[32 - 1 - bitJ].equals("1"))
            res[32 - 1 - bitI] = "1";
        else if (res[32 - 1 - bitI].equals("?") || res[32 - 1 - bitJ].equals("?"))
            res[32 - 1 - bitI] = "?";
        else
            res[32 - 1 - bitI] = "0";
    }

    public static void and(int bitI, int bitJ) {
        if (res[32 - 1 - bitI].equals("0") || res[32 - 1 - bitJ].equals("0"))
            res[32 - 1 - bitI] = "0";
        else if (res[32 - 1 - bitI].equals("?") || res[32 - 1 - bitJ].equals("?"))
            res[32 - 1 - bitI] = "?";
        else
            res[32 - 1 - bitI] = "1";

    }

}
