package algorithm_java;
/*
    problem : baekjoon NO.2840
    task : 상덕이가 종이에 적어놓은 내용과 바퀴의 칸의 수가 주어졌을 때, 바퀴에 적어놓은 알파벳을 알아내는 프로그램을 작성하시오.
    point :
        - 바퀴에 같은 글자는 두 번 이상 등장하지 않는다. 또, 바퀴는 시계방향으로만 돌아간다.
        바퀴 옆에는 화살표가 있는데, 이 화살표는 항상 한 곳을 가리키고 있으며, 돌아가는 동안 가리키는 글자는 바뀌게 된다.
        - 상덕이는 바퀴를 연속해서 K번 돌릴 것이다.
        매번 바퀴를 돌릴 때 마다, 상덕이는 화살표가 가리키는 글자가 변하는 횟수와 어떤 글자에서 회전을 멈추었는지를 종이에 적는다.
        - 첫째 줄에 바퀴의 칸의 수 N과 상덕이가 바퀴를 돌리는 횟수 K가 주어진다. (2 ≤ N ≤ 25, 1 ≤ K ≤ 100)
        - 다음 줄부터 K줄에는 바퀴를 회전시켰을 때 화살표가 가리키는 글자가 몇 번 바뀌었는지를 나타내는 S와 회전을 멈추었을 때 가리키던 글자가 주어진다. (1 ≤ S ≤ 100)
        - 첫째 줄에 마지막 회전에서 화살표가 가리키는 문자부터 시계방향으로 바퀴에 적어놓은 알파벳을 출력한다.
        이때, 어떤 글자인지 결정하지 못하는 칸은 '?'를 출력한다. 만약, 상덕이가 적어놓은 종이에 해당하는 행운의 바퀴가 없다면 "!"를 출력한다.
     approach :
        - 환형 큐 혹은 덱을 이용해 첫번째 인덱스와 마지막 인덱스가 연결되도록 구현한다.
        - 문제를 잘 이해하지 못해 구글링을 시도. <<
        N개의 칸으로 이루어진 바퀴를 사용하고, 화살표가 현재 가리키고 있는 위치를 'p'라고 해봅시다.
        여기서 바퀴를 'S'만큼 회전을 하는 것은 'S mod N'만큼 회전하는 것과 같습니다. 바퀴의 주기가 N이기 때문이죠.
        바퀴는 시계방향으로 돌기 때문에 다음 번에 화살표가 가리킬 위치는 "P = p - (S mod N)"가 됩니다.
        'P'가 음수가 되는 경우, 화살표가 첫번째 칸(Index = '0')에서 반대방향으로 P만큼 돌아간 상태와 같으므로 P = N- |P|가 성립합니다.
        초기 화살표의 위치 'p'를 0으로 두고 바퀴를 K번 돌리는 과정을 수행합시다. 위에서 언급했듯이 몇 가지 조건만 체크해주시면 되는데요,
        1) 이전에 방문했던 위치에 다른 알파벳을 가리키고 있는 경우 (해당 인덱스에 '?'이 아닌 문자가 저장되어있는데 또 다른 문자가 저장된다고 하는 경우)
        2) 한번 등장했던 알파벳이 다른 위치에서도 등장하는 경우 (룰렛에 중복이 되는 문자가 있으면 안되는데 중복이 발생하는 경우)
        위와 같은 상황이 발생하면 '!'를 출력하고 끝내야 합니다. 그런 경우가 없다면 문제에서 요구하는 대로 바퀴에 적힌 글자들을 출력하면 됩니다.
        두 번째 예제에서 인덱스 에러가 발생. < 절대값을 이용해주어야 한다. 라이브러리를 사용하거나 직접 구현하자.
        - 출력 부분에서 %연산을 이용해 N번 돌려주어야 정답이다.
    conclusion :
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.math.*;
import java.text.*;
public class BK2840 {
    static int N, K;
    static char[] q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        q = new char[N];
        Arrays.fill(q, '?');
        int index = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            index -= s % N; // 바퀴는 시계방향으로만 돌아간다 == 화살표 방향이 반시계방향으로 돈다.
            if (index < 0) {
                index += N; // 인덱스 에러를 방지하기 위해 절대값을 구해준다.
            }
//            while (index >= N) {
//                index -= N;
//            }
            // 삽입 시에 같은 위치에 다른 문자가 입력으로 들어온 경우
            if (q[index] != '?' && q[index] != ch) {
                System.out.print("!");
                return;
            }
            q[index] = ch;

        }

        // 삽입 과정 후에 중복 글자 제거하기
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (q[i] != '?' && q[i] != q[j]) {
                    System.out.print("!");
                    return;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(q[(i + index) % N]);
        }
        System.out.print(sb);

    }



}
