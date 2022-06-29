package algorithm_java;

import java.util.Scanner;

/*
    문제 : 백준 10430번 나머지
    설명 : (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
        (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
        세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
    풀이 :
        - 단순 연산 문제기에 연산 로직에 신경을 쓰자

 */
public class BK10430 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.print((A+B)%C + ((A%C) + (B%C))%C;);
    }
}
