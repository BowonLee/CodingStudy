package programers

import java.util.Stack

class Q154539 {
    fun solution(numbers: IntArray): IntArray {
        var answer = IntArray(numbers.size) {-1}
        val indexStack = Stack<Int>()

        numbers.forEachIndexed { index, i ->

            while (indexStack.isNotEmpty()) {
                val prevIndex = indexStack.peek()

                if(numbers[prevIndex] < i) {
                    // 새로 들어온 값이 크면
                    answer[prevIndex] = i
                    indexStack.pop()
                } else {
                    break
                }
            }

            indexStack.push(index)
            }

        return answer
    }
}

fun main() {

    val sol = Q154539()

    println(sol.solution(intArrayOf(2, 3, 3, 5)).toList())
    println(sol.solution(intArrayOf(9, 1, 5, 3, 6, 2)).toList())
}
/**
 * 자신보다 뒤에 있으면서 큰 가장 가까운 수
 * 존제하지 않으면 -1
 *
 * 단순 비교하면 무조건 시간초과 확정
 * 배열의 최대치가 1,000,000 이기에 n^2를 넘어서면 거의 확정이다.
 *
 * 1. 배열을  순화하기 시작한다.
 * 2. 해당 값의 인덱스를 스텍에 넣는다.
 * 3. 다음 값의 인덱스의 수가 스텍의 가장 위의 숫자보다 큰지 비교한다.
 * 4. 크다면 스택에서 꺼낸 인덱스의 값을 해당 값으로 채운 후 3으로 돌아간다
 * 5. 작다면 그 값도 스텍에 넣고 순회한다.
 *
 * [9, 1, 5, 3, 6, 2]
 *
 * [-8, 4, -2, 3, -4]
 *
 *
 *
 *
 * 변화량의 총 합을 구했을 때 양수가 되는 첫 지점을 구한다? <- 시간초과
 *
 * 반대로 순회하면서 이전의 모든 극대값들을 순회 <- 정확도 보완하면 시간초과
 *
 * stack에 인덱스를 순서대로 저장한다
 * 뒤에 들어온 숫자가 더 크면 스텍에서 그 숫자를 빼고 해당 인덱스에
 *
 */