import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner sc = new Scanner(System.in);
    	
    	int tc = sc.nextInt();
    	
    	for (int t=0; t<tc; t++) {
        	
    		int totV = sc.nextInt();
    		int totE = sc.nextInt();
    		int distances[][] = new int[totV][totV];
    		boolean visit[] = new boolean[totV];
    		int minDistances[] = new int[totV];
    		for (int i=0; i<totV; i++) {
    			minDistances[i] = Integer.MAX_VALUE;
    			for (int j=0; j<totV; j++) {
    				distances[i][j] = Integer.MAX_VALUE;
    			}
    		}
    		
    		for (int i=0; i< totE; i++) {
    			int v1 = sc.nextInt()-1;
    			int v2 = sc.nextInt()-1;
    			int dist = sc.nextInt();
    			
    			if (dist < distances[v1][v2]) {
    				distances[v1][v2] = dist;
    			}
    			
    			if (dist < distances[v2][v1]) {
    				distances[v2][v1] = dist;
    			}
    		}
    		
    		int start = sc.nextInt()-1;
    		
			int total = 0;
			int current = start;
			int minDistance = Integer.MAX_VALUE;
			minDistances[current] = 0;
			while (total < totV) {
				total++;
				visit[current] = true;
				for (int i=0; i<totV; i++) {
					if (!visit[i]) {
						if (distances[current][i] != Integer.MAX_VALUE && (minDistances[current] + distances[current][i]) < minDistances[i]) {
							minDistances[i] = minDistances[current] + distances[current][i];
						}
					}
				}
				
				minDistance = Integer.MAX_VALUE;
				for (int i=0; i<totV; i++) {
					if (!visit[i] && minDistances[i] < minDistance) {
						minDistance = minDistances[i];
						current = i;
					}
				}
			}
    		
    		for (int i=0; i<totV; i++) {
    			if (i != start) {
    				if (minDistances[i] == Integer.MAX_VALUE) {
    					System.out.print("-1 ");
    				} else {
    					System.out.print(minDistances[i] + " ");
    				}
    			}
    		}
    		System.out.println();
    	}
    	
    }
}
