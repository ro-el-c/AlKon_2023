// 개구리
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_23797 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int last_k=0, last_p=0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == 'K'){
                if(last_p == 0)
                    last_k++;
                else{
                    last_p--;
                    last_k++;
                }
            }
            if(ch == 'P'){
                if(last_k == 0)
                    last_p++;
                else{
                    last_k--;
                    last_p++;
                }
            }
        }
        System.out.print(last_k+last_p);
    }
}