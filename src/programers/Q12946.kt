package programers

import java.util.Stack

class Q12946 {
    fun solution(n: Int): Array<IntArray> {
        var answer = arrayOf<IntArray>()


        return answer
    }

    /**
     * from 에서 to로 via를 통해서 이동한다.
     *
     */
    fun logic(n: Int, from:Int, to:Int, via:Int) {
        /**
         * 재귀적으로 돌며 최선의 수를 찾는다.
         * 자신이 온 곳을 제외하고 갈 수 있는 곳으로 가는데..
         * 시작이 어딘가가 종요하지 않다 마지막이 중요하다.
         * 원반을 하나씩 옮겨간다. 탈출조건은 모든 원반을 이동한 상태이다.
         *
         *
         */
    }
}
/**
 * 원판의 개수 n 이 주어질 떄 3번으로 모두 이동시키고 싶다
 * 최소로 옮기는 방법을 리턴하여라
 * x -> y로 옮긴다. 이동 좌표 배열
 * 스왑이 일어나는 순서대로 배열에 담아라
 * 자신보다 큰
 * [ [1,2], [1,3], [2,3] ]
 * 1번 stack에
 * 하노이의 탑은 정답이 있는
 * 3개의 기둥이 존제하는 경우 처음 항목이 가장 위로 올라가야 한다.
 * 1번기둥에서 시작한다.
 *
 * 2
 * 1을 2번에 둔다.
 * 2를 3번에 둔다.
 * 2에 있던 1을 3번에 올린다. 3 끝
 *
 *
 * 3
 * 1을 3번에 둔다
 * 2를 2번에 둔다
 * 1을 2번에 둔다
 * 3을 3번에 둔다
 * 1을 1번에 둔다
 * 2을 3번에 둔다
 * 1을 3번에 둔다 7 끝
 *
 * 3
 * 1을 2번에 둔다.
 * 2를 3번에 둔다.
 * 2에 있던 1을 3번에 올린다. 3 0 1,2
 *
 * 최소갯수를 구하는 경우 2일떄는 시작이 2이지만 3일떄는 시작이 3이다.
 *
 * 그냥 무작점 옮기면 되는건가?..
 *
 *
 *
 */