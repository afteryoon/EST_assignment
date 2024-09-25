package daliy.d0924;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 큰수출력 {
    //밑에 예시를 못보고 문제만 읽어 템플릿에 맞추지 못했습니다...
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }

        sb.append("stream 사용 : ");
        sb.append(arr[0]).append(" ");
        IntStream.range(1,n)
                        .filter(x -> arr[x-1] < arr[x] )
                                .forEach(x -> sb.append(arr[x]).append(" "));

        sb.append("\nstream 미사용 : ");
        sb.append(arr[0]).append(" ");
        for (int i = 1; i < n; i++) {
            if( arr[i-1] < arr[i] ){
                sb.append(arr[i]).append(" ");
            }
        }
        sb.append("\n교안 풀이 :");
        sb.append(solution(n,arr));
        System.out.println(sb);
    }
    //양식에 맞추기
    public static List<Integer> solution(int n, int[] array) {
        List<Integer> answer = new ArrayList<>();

        // 코드 작성
        answer.add(array[0]);
        IntStream.range(1,n)
                .filter(x -> array[x-1] < array[x] )
                .forEach(x -> answer.add(array[x]));

        return answer;
    }
//
//    public static void main(String[] args) {
//        PrintMoreBigNumber printMoreBigNumber = new PrintMoreBigNumber();
//        Scanner scanner = new Scanner(System.in);
//
//        int number = scanner.nextInt();
//        int[] array = new int[number];
//
//        for (int i = 0; i < number; i++) {
//            array[i] = scanner.nextInt();
//        }
//
//        for (int x : printMoreBigNumber.solution(number, array)) {
//            System.out.print(x + " ");
//        }
//    }


}
