import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class PseudoprimeNumbers {

    public static void main(String[] args) {
        sieve();
        StringBuilder outBuffer = new StringBuilder();
        while (true) {
            int n = ni();
            int P = n;
            BigInteger p = BigInteger.valueOf(n);
            n = ni();
            BigInteger a = BigInteger.valueOf(n);
            if (p.equals(BigInteger.ZERO) && a.equals(BigInteger.ZERO))
                break;
            if (isPrime(P)) {
                if (a.modPow(p, p).equals(a)) {
                    outBuffer.append("yes\n");
                } else {
                    outBuffer.append("no\n");
                }
            } else {
                outBuffer.append("no\n");
            }
        }
        System.out.println(outBuffer);
    }

    public static boolean mark[] = new boolean[20000000];
    public static int Primes[] = new int[10000005], nPrimes;

    static boolean isPrime(int n) {
        if (n < 10000000)
            return mark[n];
        if (n % 2 == 0 || n % 3 == 0)
            return true;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return true;
        }
        return false;
    }

    public static void sieve() {
        int n = 10000000;
        int i, j, limit = (int) (Math.sqrt((double) n) + 1);
        mark[0] = true;
        mark[1] = true;
        for (i = 4; i <= n; i += 2) {
            mark[i] = true;
        }
        Primes[(int) nPrimes++] = 2;
        for (i = 3; i <= n; i += 2) {
            if (!mark[i]) {
                Primes[nPrimes++] = i;
                if (i <= limit) {
                    for (j = i * i; j <= n; j += 2 * i) {
                        mark[j] = true;
                    }
                }
            }
        }
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
