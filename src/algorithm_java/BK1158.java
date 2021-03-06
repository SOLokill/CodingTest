package algorithm_java;
/*
    problem : baekjoon NO.1158
    task : N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
    point :
        - 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
        이제 순서대로 K번째 사람을 제거한다.
        한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
        이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
        원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
        예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
        - 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
        - 예제와 같이 요세푸스 순열을 출력한다.
    explain :
        - index를 이용하여 해당되는 사람을 제거해야 하기 때문에 deque는 안된다. linkedList나 Array를 사용하는 것이 좋을 것 같다.
        - 사람들이 제거되는 순서에 맞춰서 저장을 해야 하기 때문에 따로 이 순서를 Array에 저장한다.
        - 해당 index가 제거되면 저절로 index가 줄어들어 모든 data가 앞으로 이동해줘야 하기 때문에 ArrayList가 나을 것 같다.
        - index는 제거할 인덱스 값, rear는 array의 size() 값을 가져온다. 물론 짝수 값이면 / 2 - 1 을 해준다.
        - 재시도 후, 알고리즘 검색을 통해 linkedList를 사용한다는 사실을 확인, Array 에서 linkedList 로 다시 진행하기로 결정.
        - 1 ~ N 까지 queue에 offer 한다.
        K -1 번째까지는 첫 번째 값을 맨 뒤로 보낸다.
        K번째 일때는 poll 해서 출력한다.
        queue의 사이즈가 1개일 때까지 반복한다. (Queue의 요소가 1개면 바로 빼서 출력한다.)

    conclusion :
        너무 어렵게 생각했다. 아니면 내 구현력의 문제인 것 같다. 조금 차분히, 그리고 제대로 다시 진행해보자.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
//import java.util.ArrayList;
import java.util.LinkedList;

public class BK1158 {
    static int N, K, rear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<Integer> result;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
//        result = new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<>();
//        int index = -1;
        for (int i = 1; i <= N; i++) {
            result.offer(i);
        }
//        int cnt = 0;
        sb.append("<");
        while (result.size() != 1) {
            for(int i = 0;i < K -1 ; i++){
                result.offer(result.poll());
            }
            sb.append(result.poll()).append(", ");
//            index += K - cnt;
//            rear = result.size();
//            if(index == rear){
//                sb.append(result.get(index-1)).append(" ");
//                result.remove(index-1);
//                cnt = 0;
//                continue;
//            }
//            if (index > rear) {
//                index = index - rear;
//                sb.append(result.get(index)).append(" ");
//                result.remove(index);
//                continue;
//            }
//            sb.append(result.get(index)).append(" ");
//            result.remove(index);
//            rear--;
//            cnt++;
        }
        sb.append(result.poll()).append(">");
        System.out.print(sb);
    }
}
