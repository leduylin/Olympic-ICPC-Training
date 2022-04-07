package cses_5000;

import java.io.*;
import java.util.*;

public class MessageRoute {

	public static void main(String[] args) {
		int n = ni(), m = ni();
		Computer[] computers = new Computer[n + 1];
		for (int i = 1; i <= n; i++) {
			computers[i] = new Computer(i);
		}
		for (int i = 0; i < m; i++) {
			Computer u = computers[ni()];
			Computer v = computers[ni()];
			u.route(v);
			v.route(u);
		}

		Computer u = computers[1];
		ArrayDeque<Computer> queue = new ArrayDeque<>();
		queue.add(u);
		u.checked = true;
		while (!queue.isEmpty()) {
			for (Computer c : queue.getFirst().connectedComputers) {
				if (!c.checked) {
					queue.add(c);
					c.checked = true;
					c.previousComputer = queue.getFirst();
				}
			}
			queue.removeFirst();
		}
		
		if (computers[n].previousComputer == null)
			System.out.println("IMPOSSIBLE");
		else {
			List<Computer> route = new ArrayList<>();
			route.add(computers[n]);
			Computer currentComputer = computers[n].previousComputer;
			route.add(currentComputer);
			while (currentComputer.id != computers[1].id) {
				route.add(currentComputer.previousComputer);
				currentComputer = currentComputer.previousComputer;
			}
			StringBuilder outBuffer = new StringBuilder();
			outBuffer.append(route.size() + "\n");
			for (int i = route.size() - 1; i >= 0; i--) {
				outBuffer.append(route.get(i).id + " ");
			}
			System.out.println(outBuffer);
		}
	}

	static class Computer {
		int id;
		List<Computer> connectedComputers = new ArrayList<>();
		boolean checked = false;
		Computer previousComputer;

		public Computer(int id) {
			super();
			this.id = id;
		}

		public void route(Computer u) {
			connectedComputers.add(u);
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
