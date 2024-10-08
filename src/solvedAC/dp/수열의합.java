package solvedAC.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        dp[0] = arr[0];
        int maxSum = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        System.out.println(maxSum);
    }
}
