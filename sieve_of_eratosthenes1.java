import java.util.*;

public class sieve_of_eratosthenes1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        String str = "";
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                str += Integer.toString(i) + " ";
            }
        }
        System.out.println(str);
    }

}
