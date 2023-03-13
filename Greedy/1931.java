import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); //화의 수

        /**
         * meeting[][0] = 시작 시간
         * meeting[][1] = 끝나는 시간
         */
        int[][] meeting = new int[N][2];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            meeting[i][0] = start;
            meeting[i][1] = finish;
        }

        //끝난는 시간이 빠른 순으로 정렬
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        /**
         * 회의실을 사용할 수 있는 최대의 회의 수를 구한다.
         * 최대의 회의 수를 구하기 위해서는 빨리 끝나는 회의들을 선택해야한다.
         * 즉, 활동 시간이 짧은 회의 선택
         */
        int pre_end_time = 0;
        int count = 0;
        for(int i = 0; i < N; i++){
            //시작시간이 전 회의의 끝나는 시간 이후
            //문제 조건 : 시작 시간과 끝나는 시간이 같을 수 있다.
            if(pre_end_time <= meeting[i][0]){
                pre_end_time = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
