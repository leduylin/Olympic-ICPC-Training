import java.io.*;
import java.util.*;
 
public class ABCString {
 
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int t = reader.nextInt();
		StringBuilder outBuffer = new StringBuilder();
		while (t-- > 0) {
			String word = reader.next();
			String[] wordSplit = word.split("");
			int[] count = new int[3];
			for (int i = 0; i < word.length(); i++) {
				if (wordSplit[i].equals("A"))
					count[0]++;
				else if (wordSplit[i].equals("B"))
					count[1]++;
				else
					count[2]++;
			}
			int indexOfMax = -1;
			int max = 0;
			for (int i = 0; i < 3; i++) {
				if (count[i] > max) {
					indexOfMax = i;
					max = count[i];
				}
			}
			String maxExist = "";
			if (indexOfMax == 0)
				maxExist = "A";
			else if (indexOfMax == 1)
				maxExist = "B";
			else
				maxExist = "C";
 
			if (maxExist.equals(wordSplit[0])) {
				for (int i = 0; i < wordSplit.length; i++) {
					if (wordSplit[i].equals(maxExist))
						wordSplit[i] = "(";
					else
						wordSplit[i] = ")";
				}
			} else {
				for (int i = 0; i < wordSplit.length; i++) {
					if (!wordSplit[i].equals(maxExist))
						wordSplit[i] = "(";
					else
						wordSplit[i] = ")";
				}
			}
 
			ArrayList<String> result = new ArrayList<>();
			for (int i = 0; i < wordSplit.length; i++) {
				if (wordSplit[i].equals("("))
					result.add(wordSplit[i]);
				else if (result.size() > 0 && result.get(result.size() - 1).equals("("))
					result.remove(result.size() - 1);
				else
					result.add(wordSplit[i]);
			}
 
			if (result.size() == 0) {
				outBuffer.append("YES\n");
			} else
				outBuffer.append("NO\n");
 
		}
		System.out.print(outBuffer);
	}
 
	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;
 
		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}
 
		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}
 
		public String nextLine() throws IOException {
			return reader.readLine();
		}
 
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
 
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
 
}