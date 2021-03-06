package algorithm_java;
/*
    problem :
    task :
    point :
    explain :
        - 단어 하나를 모든 인덱스를 돌면서 기존 단어와 매칭이 되는지 한 글자씩 확인한다. 다음 글자를 넣었을 때 매칭이 되면 또 다음 글자를 매칭한다.
        만약 제일 끝 자리에 있는 단어까지 다 봤다면 다시 앞으로 돌아가서 매칭한다. 모든 글자가 매칭이 될 때 해당 단어의 cnt를 올린다.
        - 한 번 나왔던 단어는 또 cnt 하지 않는다.
        - 다른 방법 : set 안에 받은 단어를 가지고 만들 수 있는 사이클 단어를 다 만들어 넣는다. 그리고 그 뒤로 받는 단어가 set에 있는 단어와 중복이 된다면
        continue 하고 중복되지 않는 단어가 있다면 cnt 를 올려준다. contains() == O(1)
    conclusion :
 */
public class BK1544 {
}
