import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner sc = new Scanner(System.in);
    	
    	int tc = sc.nextInt();
    	
    	for (int t=0; t<tc; t++) {
        	
    		int totV = sc.nextInt();
    		int totE = sc.nextInt();
    		boolean[] visit = new boolean[totV];
    		int[] distances = new int[totV];
    		LinkedList<Integer>[] adjList = new LinkedList[totV];
    		for (int i=0; i<totV; i++) {
    			adjList[i] = new LinkedList<Integer>();
    		}
    		
    		for (int i=0; i<totV; i++) {
    			distances[i] = -1;
    		}
    		
    		for (int i=0; i< totE; i++) {
    			int v1 = sc.nextInt()-1;
    			int v2 = sc.nextInt()-1;
    			
    			adjList[v1].add(v2);
    			adjList[v2].add(v1);
    		}
    		
    		int start = sc.nextInt()-1;
    		distances[start] = 0;
    		
    		Queue<Integer> queue = new LinkedList<Integer>();
    		queue.add(start);
    		
    		Integer node = queue.poll();
    		while (node != null) {
    			Iterator<Integer> it = adjList[node].iterator();
    			
    			while (it.hasNext()) {
    				int nodeVisit = it.next();
    				if (visit[nodeVisit] == false) {
    					visit[nodeVisit] = true;
    					distances[nodeVisit] = distances[node] + 6;
    					queue.add(nodeVisit);
    				}
				}
    			
    			node = queue.poll();
			}
    		
    		for (int i=0; i<totV; i++) {
    			if (i != start) {
    				System.out.print(distances[i] + " ");
    			}
    		}
    		System.out.println();
    	}
    	
    }
}
