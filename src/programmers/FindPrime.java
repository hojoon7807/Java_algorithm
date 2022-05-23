package programmers;

import java.util.HashSet;
import java.util.Set;

public class FindPrime {
    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();
    }

    public int solution(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();
        int n = arr.length;
        Set<Integer> numberSet = new HashSet();

        for(int r=1; r<=n; r++){
            permutation(numberSet,arr,0,n,r);
        }
        System.out.println(numberSet);

        for(Integer num: numberSet){
            if(isPrime(num) == true){
                answer ++;
            }
        }
        return answer;
    }

    void swap (char[] arr, int depth, int i){
        char tmp = arr[i];
        arr[i] = arr[depth];
        arr[depth] = tmp;
    }

    void permutation(Set<Integer> set, char[] arr, int depth, int n, int r){
        if (depth == r){
            String s = "";
            for (int i=0; i<r; i++){
                s += arr[i];
            }
            set.add(Integer.valueOf(s));
        }

        for(int i=depth; i<n; i++){
            swap(arr, depth,i);
            permutation(set,arr, depth+1, n, r);
            swap(arr, depth,i);
        }
    }

    boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for (int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
