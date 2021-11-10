package cses_5000;

import java.io.*;
import java.util.*;

public class BuildingTeams {

	public static void main(String[] args) {
		int n = ni(), m = ni();
		Pupil[] pupils = new Pupil[n + 1];
		for (int i = 1; i <= n; i++) {
			pupils[i] = new Pupil(i);
		}
		for (int i = 0; i < m; i++) {
			Pupil u = pupils[ni()];
			Pupil v = pupils[ni()];
			u.addFriend(v);
			v.addFriend(u);
		}
		for (int i = 1; i <= n; i++) {
			Pupil p = pupils[i];
			if (!p.checked) {
				p.teamNum = 1;
				DFS(p, 1);
			}
		}
		StringBuilder outBuffer = new StringBuilder();
		boolean possible = true;
		for (int i = 1; i <= n; i++) {
			if (pupils[i].inTwoTeam) {
				possible = false;
				break;
			} else
				outBuffer.append(pupils[i].teamNum + " ");
		}
		if (possible)
			System.out.println(outBuffer);
		else
			System.out.println("IMPOSSIBLE");
	}

	static void DFS(Pupil p, int teamNum) {
		if (p.checked) {
			if (p.teamNum != teamNum)
				p.inTwoTeam = true;
			return;
		}
		p.checked = true;
		p.teamNum = teamNum;
		int nextTeamNum = 0;
		if (teamNum == 1)
			nextTeamNum = 2;
		else
			nextTeamNum = 1;

		for (int i = 0; i < p.friendList.size(); i++) {
			DFS(p.friendList.get(i), nextTeamNum);
		}

	}

	static class Pupil {
		int id;
		List<Pupil> friendList = new ArrayList<>();
		boolean checked = false;
		boolean inTwoTeam = false;
		int teamNum = 0;

		public Pupil(int id) {
			super();
			this.id = id;
		}

		public void addFriend(Pupil p) {
			friendList.add(p);
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
