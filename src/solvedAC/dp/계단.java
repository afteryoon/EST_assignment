package solvedAC.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
       for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
       }

        int[] dp = new int[n];
        dp[0] = arr[0];
        if(n>=2)
            dp[1] = arr[1]+arr[0];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2] , dp[i-3] + arr[i-1])+arr[i];
        }

        System.out.println(dp[n - 1]);
    }
}
