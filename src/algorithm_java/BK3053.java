package algorithm_java;
/*
    probelm : baekjoon NO.3053
    task : 택시 기하학에서 두 점 T1(x1,y1), T2(x2,y2) 사이의 거리는 다음과 같이 구할 수 있다.
        D(T1,T2) = |x1-x2| + |y1-y2| 두 점 사이의 거리를 제외한 나머지 정의는 유클리드 기하학에서의 정의와 같다.
        따라서 택시 기하학에서 원의 정의는 유클리드 기하학에서 원의 정의와 같다.
        원: 평면 상의 어떤 점에서 거리가 일정한 점들의 집합
        반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와, 택시 기하학에서 원의 넓이를 구하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에는 유클리드 기하학에서 반지름이 R인 원의 넓이를, 둘째 줄에는 택시 기하학에서 반지름이 R인 원의 넓이를 출력한다. 정답과의 오차는 0.0001까지 허용한다.
        - 맨해튼 거리 라는 이론을 알아야 한다.
        - 택시 기하학에서의 거리 = 두 점의 x 좌표의 차 + 두 점의 y 좌표의 차 가 되는 것
        - 우리가 평소에 아는 '거리' 라는 개념은 초록색(유클리드 기하학)과 같지만 ( D(T₁, T₂)² = (𝑥₁ - 𝑥₂)² + (y₁ - y₂)² )
        - 택시기하학에서는 '거리'라는 개념을 새로 정의한 것이다. ( D(T₁, T₂) = |𝑥₁ - 𝑥₂| + |y₁ - y₂| )
        - 유클리드 기하학에서의 원의 넓이 = 𝜋𝑟² = 3 × 3 × 𝜋 = 9𝜋
        - 맨해튼 거리의 원은 중심 점에서 반지름이라고 불리는 일정한 거리만큼 떨어져 있는 점들의 집합이다 거리D = |𝑥| + |y|
        - 택시 기하학에서의 원의 넓이 = 2𝑟² = 2 × 3 × 3 = 18
 */
import java.util.Scanner;

public class BK3053 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        sc.close();

        System.out.println(r * r * Math.PI);
        System.out.print(2 * r * r);
    }
}
