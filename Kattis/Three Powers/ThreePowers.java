import java.io.*;
import java.math.BigInteger;
import java.util.*;

class ThreePowers {

    public static void main(String[] args) {
        BigInteger[] threePower = new BigInteger[200];
        threePower[0] = BigInteger.valueOf(1);
        for (int i = 1; i < 200; i++) {
            threePower[i] = BigInteger.valueOf(3).multiply(threePower[i - 1]);
        }
        StringBuilder outBuffer = new StringBuilder();

        long n = nl();
        while (n != 0) {
            n--;
            outBuffer.append("{ ");
            String bitmask = Long.toBinaryString(n);
            List<BigInteger> setItem = new ArrayList<>();
            int length = bitmask.length();
            for (int i = 0; i < bitmask.length(); i++) {
                if (bitmask.charAt(length - 1 - i) == '1') {
                    setItem.add(threePower[i]);
                }
            }
            boolean closeSign = false;
            for (int i = 0; i < setItem.size(); i++) {
                if (i == setItem.size() - 1) {
                    outBuffer.append(setItem.get(i) + " }");
                    closeSign = true;
                } else {
                    outBuffer.append(setItem.get(i) + ", ");
                }
            }
            if (!closeSign)
                outBuffer.append("}");
            outBuffer.append("\n");
            n = nl();
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
