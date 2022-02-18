package greedy;

public class Money {
    public static void main(String[] args) {
        int n = 1280;
        int count = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for (int i = 0; i < coinTypes.length; i++) {
            count += n / coinTypes[i];
            n %= coinTypes[i];
        }
        System.out.println(count);

    }
}
