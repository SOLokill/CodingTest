package algorithm_java;
/*
    problem : baekjoon NO.10250
    task : 호텔 정문으로부터 걷는 거리가 가장 짧도록 방을 배정하는 프로그램을 작성하고자 한다.
    문제를 단순화하기 위해서 호텔은 직사각형 모양이라고 가정하자.
    각 층에 W 개의 방이 있는 H 층 건물이라고 가정하자 (1 ≤ H, W ≤ 99).
    그리고 엘리베이터는 가장 왼쪽에 있다고 가정하자(그림 1 참고). 이런 형태의 호텔을 H × W 형태 호텔이라고 부른다.
    호텔 정문은 일층 엘리베이터 바로 앞에 있는데, 정문에서 엘리베이터까지의 거리는 무시한다.
    또 모든 인접한 두 방 사이의 거리는 같은 거리(거리 1)라고 가정하고 호텔의 정면 쪽에만 방이 있다고 가정한다.
    손님은 엘리베이터를 타고 이동하는 거리는 신경 쓰지 않는다. 다만 걷는 거리가 같을 때에는 아래층의 방을 더 선호한다.
    여러분이 작성할 프로그램은 초기에 모든 방이 비어있다고 가정하에 이 정책에 따라 N 번째로 도착한 손님에게 배정될 방 번호를 계산하는 프로그램이다.
    첫 번째 손님은 101 호, 두 번째 손님은 201 호 등과 같이 배정한다.
    그림 1 의 경우를 예로 들면, H = 6이므로 10 번째 손님은 402 호에 배정해야 한다.
    point :
        - 같은 거리일 경우 낮은 층수부터 배정
        - 입력은 T개의 테스트 케이스, h, w, n 세 정수를 포함. 각각 호텔의 층 수, 각 층의 방 수, 몇 번째 손님인지를 나타냄.
        - 출력은 n 번째 손님에게 배정되어야 하는 방 번호를 출력
        - 엘레베이터로부터 가까운 거리부터 배정
        - N을 H로 나눈 나머지 값이 층 수
        - N % H 일 때는 H 층이 배정받는 층 수
        - (N / H) + 1 = X
        - N % H = 0 일 때는 +1을 하지 않는다.
 */
import java.util.Scanner;

public class BK10250 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt();	// 테스트 케이스

        for(int i = 0; i < T; i++) {

            int H = in.nextInt();
            int W = in.nextInt(); 	// 쓸모없는 변수다.
            int N = in.nextInt();

            if(N % H == 0) {
                System.out.println((H * 100) + (N / H));

            } else {
                System.out.println(((N % H) * 100) + ((N / H) + 1));
            }
        }
        in.close();
    }
}