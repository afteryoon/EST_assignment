package solvedAC.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전 {
    static int count=0;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int[] coin = {500,100,50,10,5,1};
        for (int i = 0; i < coin.length; i++) {
            coinCount(coin[i]);
        }
        System.out.println(count);
    }
    public static void coinCount(int coin){
        if (num/coin>=1){
            count+=num/coin;
            num=num%coin;
        }
    }

}
