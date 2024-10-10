import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(st.nextToken()); 
		int C = Integer.parseInt(st.nextToken()); 
		char[][] map = new char[R][C];
		boolean[] visited = new boolean[4];
		int[][] dydx = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

		for(int i = 0; i < R; i++) {
			char[] charArr = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(charArr[j] == 'M'||charArr[j] == 'Z') {
					map[i][j] = '*';
				}
				else map[i][j] = charArr[j];				
			}
		}
		
		HashSet<Character>[] setArr = new HashSet[4]; 
		for(int i = 0; i < 4; i++) {
			HashSet<Character> set = new HashSet<>();
			set.add('.');
			set.add('*');
			if(i%2==0) set.add('|');
			else set.add('-');
			
			if(i == 0) {
				set.add('3');
				set.add('4');
			}else if(i == 1) {
				set.add('2');
				set.add('3');
			}else if(i == 2) {
				set.add('1');
				set.add('2');
			}else if(i == 3) {
				set.add('1');
				set.add('4');
			}
			
			setArr[i] = set;			
		}
		
		
		loop:for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != '.') continue;
				Arrays.fill(visited, false);
				int cnt = 0;
				for(int k = 0; k < 4; k++) {
					int cy = i+dydx[k][0];
					int cx = j+dydx[k][1];

					if(cy>=0&&cy<R&&cx>=0&&cx<C&&!setArr[k].contains(map[cy][cx])) {
						visited[k] = true;
						cnt++;
					}
				}
				if(cnt == 0) continue;
				else if(cnt == 1 || cnt == 3) {
					for(int k = 0; k < 4; k++) {
						int cy = i+dydx[k][0];
						int cx = j+dydx[k][1];

						if(cy>=0&&cy<R&&cx>=0&&cx<C&&map[cy][cx] == '*') {
							visited[k] = true;
							cnt++;
							break;
						}
					}
				}
				
				sb.append(i+1).append(" ").append(j+1).append(" ");
				if(cnt == 4) sb.append('+');
				else if(visited[1]&&visited[3]) sb.append('|');
				else if(visited[0]&&visited[2]) sb.append('-');
				else if(visited[2]&&visited[3]) sb.append('1');
				else if(visited[1]&&visited[2]) sb.append('2');
				else if(visited[0]&&visited[1]) sb.append('3');
				else if(visited[0]&&visited[3]) sb.append('4');
				sb.append("\n");
				break loop;
			}
		}
			
		System.out.println(sb);
	}
}