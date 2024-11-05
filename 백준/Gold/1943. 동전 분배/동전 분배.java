import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            System.out.println(distribute() ? 1 : 0);
        }
    }
 
    private static boolean distribute() throws IOException {
        int[] coins = new int[100001];
 
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            int coin = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);
            for (int j = 0; j <= count; j++) {
                for (int k = total; k >= 0; k--) { // 이전 기록에 영향이 없도록 반대로 탐색
                    if (k + (coin * j) > 100000) { // 합이 100000원이 넘어가면 종료
                        break;
                    }
 
                    if (coins[k] > 0) { // 동전을 넣은 적이 있으면 현재 가격과 합을 계산하여 기록
                        coins[k + (coin * j)] += 1;
                    }
                }
            }
            for (int j = 0; j <= count; j++) { // 현재 동전 가격 기록
                coins[coin * j] += 1;
            }
            total += coin * count; // 총계 기록
        }
 
        if (total % 2 != 0) { // 나눠지지 않으면 바로 false 반환
            return false;
        }
 
        return coins[total / 2] != 0; // 총 값의 반이 기록되어 있는지 여부 반환
    }
}