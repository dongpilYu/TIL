import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> arr = new ArrayList<>();
        while(st.hasMoreTokens()){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr.get(0));

        for(int i=1;i<num;i++){

            int maxVal = Math.max(arr.get(i), answer.get(i-1) + arr.get(i));
            answer.add(maxVal);

        }

        int max = Integer.MIN_VALUE;
        for(int number : answer){
            if(number > max)
                max = number;
        }

        System.out.println(max);

    }
}
