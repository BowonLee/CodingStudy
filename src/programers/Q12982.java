package programers;

import java.util.Arrays;

public class Q12982 {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        long sum = 0L;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i]);
        }


        for (int i = 0; i < d.length ; i++) {

            sum += d[i];
            answer++;

            if(sum == budget) {
                System.out.println("???");
                break;
            } else if (sum > budget) {
                System.out.println("!!!");
                answer--;
                break;
            }
        }

        return answer ;

    }

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(solution(new int[]{3,1,1}, 3));
    }
}
