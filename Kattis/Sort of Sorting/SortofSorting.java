import java.io.*;
import java.util.*;

 class SortofSorting {

    public static void main(String[] args) {
        int n = ni();
        StringBuilder outBuffer = new StringBuilder();
        while (n != 0) {
            List<Name> names = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String name = ns();
                if (name.length() > 2)
                    names.add(new Name(i, name.substring(0, 2), name));
                else
                    names.add(new Name(i, name, name));

            }

            names.sort((n1, n2) -> {
                int compare = n1.firstLetters.compareTo(n2.firstLetters);
                if (compare != 0)
                    return compare;

                compare = Integer.compare(n1.order, n2.order);
                return compare;
            });
            for (int i = 0; i < n; i++) {
                outBuffer.append(names.get(i).name + "\n");
            }
            n = ni();
            outBuffer.append("\n");
        }
        System.out.print(outBuffer);
    }

    static class Name {
        public int order;
        public String firstLetters;
        public String name;

        public Name(int order, String firstLetters, String name) {
            super();
            this.order = order;
            this.firstLetters = firstLetters;
            this.name = name;
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
