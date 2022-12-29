package backjun

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * N과 L이 주어질 때, 합이 N이면서, 길이가 적어도 L인 가장 짧은 연속된 음이 아닌 정수 리스트를 구하는 프로그램을 작성하시오.
 */
class Solution1024 {

    fun solution(n: Long, l: Long): LongArray {


        /**
         * 모든 숫자는 최소한 n/l 이상이다.
         * 가장 짧으려면 일단 단위가 가장 커야한다.
         * n/l인 버림처리 된 자연수를 기준으로 한다.
         */

        val pivot = n/2

        (pivot downTo  l).forEach { num ->
            println(num)
            val result = logic(n, num, l)

            if(result > 0) {
                return (result downTo  1).map { num - it }.toLongArray()
            }
        }

        return longArrayOf()

    }

    /**
     *
     * 1. 가장 큰 기준 숫자부터 하나씪 줄여간다.
     *
     * 2. 기준 숫자부터 l이상으로
     */



    /**
     * 검증
     * 해당 숫자부터 하나씩 빼면서
     */
    private fun logic(goal: Long, num: Long, len: Long): Long {

        (len..100).forEach {
            val sum = (1..it).map { value ->
                num - value
            }.sum()

            if(sum == goal) {
                return it
            } else if( sum > goal) {
                // 해당 수를 시작으로는 못함
                return -1
            }
        }

        return -1
    }
}



fun main() = with(BufferedReader(InputStreamReader(System.`in`)))  {
    val sol = Solution1024()

    println(sol.solution(18,2).toList())
    println(sol.solution(18,4).toList())
    println(sol.solution(18,5).toList())
    println(sol.solution(45,10).toList())
    println(sol.solution(100,4).toList())
    println(sol.solution(1000000000,2).toList())

//    val input = readLine().split(" ").map { it.toInt() }

//    val result = sol.solution(input[0].toLong(), input[1].toLong())
//
//    if(result.isEmpty()) {
//        print(-1)
//    }
//
//    result.forEach { print("$it ") }

}