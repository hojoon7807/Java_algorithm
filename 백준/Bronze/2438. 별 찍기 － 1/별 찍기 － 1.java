import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    
    public static void main(String[] args){
        n = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=n; i++){
            String star = "*".repeat(i);
            sb.append(star).append("\n");
        }
        
        System.out.println(sb);
    }
}