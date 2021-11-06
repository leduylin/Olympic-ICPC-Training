import java.io.*;
import java.util.*;

class EqualSumsEasy {

    public static void main(String[] args) {
        int t = ni();
        StringBuilder outBuffer = new StringBuilder();
        for (int j = 1; j <= t; j++) {
            int n = ni();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = ni();
            }
            boolean possible = false;
            HashMap<Integer, List<Integer>> sumSubSet = new HashMap<>();
            int subset_ct = 1 << n;
            for (int mask = 0; mask < subset_ct; mask++) {
                List<Integer> subset = new ArrayList<>();
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        sum += numbers[i];
                        subset.add(numbers[i]);
                    }
                }
                if (sumSubSet.get(sum) == null)
                    sumSubSet.put(sum, subset);
                else {
                    possible = true;
                    outBuffer.append("Case #" + j + ":\n");
                    for (int num : sumSubSet.get(sum)) {
                        outBuffer.append(num + " ");
                    }
                    outBuffer.append("\n");
                    for (int num : subset) {
                        outBuffer.append(num + " ");
                    }
                    break;
                }
            }
            if (!possible)
                outBuffer.append("Impossible");
            outBuffer.append("\n");
        }
        System.out.println(outBuffer);

    }

    static InputStream is = System.in;

    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    static float nf() {
        return Float.parseFloat(ns());
    }

    static double nd() {
        return Double.parseDouble(ns());
    }

    static char nc() {
        return (char) skip();
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

}