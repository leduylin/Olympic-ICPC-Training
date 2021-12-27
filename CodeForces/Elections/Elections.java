import java.io.*;
import java.util.*;

public class Elections {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int numberOfCandidates = reader.nextInt();
		int numberOfCities = reader.nextInt();
		Candidate[] candidates = new Candidate[numberOfCandidates];
		for (int i = 0; i < numberOfCandidates; i++) {
			candidates[i] = new Candidate();
			candidates[i].index = i;
			candidates[i].winCity = 0;
		}

		for (int i = 0; i < numberOfCities; i++) {
			int maxVote = 0;
			int winCandidateIndex = 0;
			for (int j = 0; j < numberOfCandidates; j++) {
				candidates[j].currentVote = reader.nextInt();
				if (candidates[j].currentVote > maxVote) {
					maxVote = candidates[j].currentVote;
					winCandidateIndex = j;
				}
			}
			candidates[winCandidateIndex].winCity++;
		}
		Arrays.sort(candidates, (candidate1, candidate2) -> {
			int compare = Integer.compare(candidate2.winCity, candidate1.winCity);
			if (compare != 0)
				return compare;
			compare = Integer.compare(candidate1.index, candidate2.index);
			return compare;
		});
		int result = candidates[0].index + 1;
		System.out.print(result);

	}

	static class Candidate {
		public int winCity;
		public int index;
		public int currentVote;
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