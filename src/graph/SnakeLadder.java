package graph;

//Given a snake and ladder board of order 5x6 ,
// find the minimum number of dice throws required to reach the destination or last cell (30th cell)
//from source (1st cell) . 

//For the above board output will be 3 
//For 1st throw get a 2
//For 2nd throw get a 6
//For 3rd throw get a 2
//
//Input:
//The first line of input contains an integer T denoting the no of test cases. 
//Then T test cases follow. Each test case contains two lines. The first line of input 
//contains an integer N denoting the no of ladders and snakes present. 
//Then in the next line are 2*N space separated values a,b which denotes a ladder or a snake
//at position 'a' which takes to a position 'b'.
//
//Output:
//For each test case in a new line print the required answer denoting the min no of dice throws.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class SnakeLadder {
	static class QueueEntry{
		int v;
		int dist;		
		public QueueEntry(int v, int dist) {			
			this.v = v;
			this.dist = dist;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int testCases = Integer.parseInt(br.readLine());		
		while(testCases > 0){
			int ladderSnakeCount = Integer.parseInt(br.readLine());
			String[] positions = br.readLine().split("\\s");
			int[] snakeLadderPostion = new int[31];			
			for(int i = 0;ladderSnakeCount > 0 ; ladderSnakeCount--,i+=2){
				snakeLadderPostion[Integer.parseInt(positions[i])] =Integer.parseInt(positions[i+1]);
			}
			// the move start from block 1
			boolean[] visited =  new boolean[31];
			QueueEntry qe =  new QueueEntry(1,0);
			LinkedList<QueueEntry> queue =  new LinkedList<QueueEntry>();
			queue.add(qe);
			while(!queue.isEmpty()){
				
				qe =  queue.poll();
				if(qe.v == 30){
					break;
				}
				int currentVertex = qe.v;
				visited[currentVertex] = true;
				for(int i = currentVertex+1 ; i <= currentVertex+6; i++){
					if(!visited[i]){
						visited[i] = true;
						QueueEntry q =  new QueueEntry(i, qe.dist+1);
						if(snakeLadderPostion[i] != 0){
							q.v =  snakeLadderPostion[i];
						}
						queue.add(q);
					}
					if( i == 30)
						break;
				}
				
			}
			System.out.println(qe.dist);
			testCases--;
		}
		
	}	

}
