package cses_5000;

import java.io.*;
import java.util.*;

public class BuildingRoads {

	public static void main(String[] args) {
		int n = ni(), m = ni();
		City[] cities = new City[n + 1];
		for (int i = 1; i <= n; i++) {
			cities[i] = new City(i);
		}
		for (int i = 0; i < m; i++) {
			City u = cities[ni()];
			City v = cities[ni()];
			u.addConnectedCity(v);
			v.addConnectedCity(u);
		}
		List<Integer> representComponent = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			City u = cities[i];
			if (!u.checked) {
				representComponent.add(i);
				DFS(u);
			}
		}
		StringBuilder outBuffer = new StringBuilder();
		outBuffer.append((representComponent.size() - 1) + "\n");
		for (int i = 1; i < representComponent.size(); i++) {
			outBuffer.append(representComponent.get(0) + " " + representComponent.get(i) + "\n");
		}
		System.out.println(outBuffer);
	}

	static void DFS(City vertice) {
		if (vertice.checked)
			return;
		vertice.checked = true;
		for (int i = 0; i < vertice.connectedCities.size(); i++) {
			DFS(vertice.connectedCities.get(i));
		}

	}

	static class City {
		int id;
		List<City> connectedCities = new ArrayList<>();
		boolean checked = false;

		public City(int id) {
			super();
			this.id = id;
		}

		public void addConnectedCity(City c) {
			connectedCities.add(c);
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
