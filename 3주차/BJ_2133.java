// 타일 채우기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[31];
        arr[0] = 1;
        arr[2] = 3;

        for(int i=4; i<31; i++) {
            arr[i] = arr[i-2] * arr[2];
            for(int j=4; j<=i; j++){
                arr[i] += arr[i-j]*2;
                j++;
            }
            i++;
        }

        System.out.print(arr[N]);
    }
}