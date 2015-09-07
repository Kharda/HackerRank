import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);

		int totV = sc.nextInt();
		int totE = sc.nextInt();
		int distances[][] = new int[totV][totV];
		boolean visited[] = new boolean[totV];
		int minDistances[] = new int[totV];
		for (int i = 0; i < totV; i++) {
			minDistances[i] = Integer.MAX_VALUE;
			for (int j = 0; j < totV; j++) {
				distances[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < totE; i++) {
			int v1 = sc.nextInt() - 1;
			int v2 = sc.nextInt() - 1;
			int dist = sc.nextInt();

			distances[v1][v2] = distances[v2][v1] = dist;
		}

		int start = sc.nextInt() - 1;

		int total = 1;
		int current = start;
		int minDist = 0;
		minDistances[current] = 0;

		while (total != totV) {
			visited[current] = true;

			for (int i = 0; i < totV; i++) {
				if (!visited[i]) {
					if (minDistances[i] > distances[current][i]) {
						minDistances[i] = distances[current][i];
					}
				}
			}

			minDist = Integer.MAX_VALUE;
			for (int i = 0; i < totV; i++) {
				if (!visited[i]) {
					if (minDistances[i] < minDist) {
						minDist = minDistances[i];
						current = i;
					}
				}
			}

			total++;
		}

		minDist = 0;
		for (int i = 0; i < totV; i++) {
			minDist += minDistances[i];
		}

		System.out.println(minDist);

	}
}
